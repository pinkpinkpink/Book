package java.automaticgeneration

import com.intellij.database.model.DasTable
import com.intellij.database.model.ObjectKind
import com.intellij.database.util.Case
import com.intellij.database.util.DasUtil

import java.text.SimpleDateFormat

/*
 * Available context bindings:
 *   SELECTION   Iterable<DasObject>
 *   PROJECT     project
 *   FILES       files helper
 */
packageName = ""
typeMapping = [
        (~/(?i)tinyint|smallint|mediumint|int/)  : "Integer",
        (~/(?i)decimal/)                         : "BigDecimal",
        (~/(?i)bool|bit/)                        : "Boolean",
        (~/(?i)float|double|real|number/)        : "Double",
        (~/(?i)datetime|timestamp|date|time/)    : "Date",
        (~/(?i)blob|binary|bfile|clob|raw|image/): "InputStream",
        (~/(?i)/)                                : "String"
]
exceptNames = ["pkId", "createTime", "updateTime", "flagEemp", "statusEemp", "createUserId", "createUserName", "updateUserId", "updateUserName", "orgId", "orgName"]

FILES.chooseDirectoryAndSave("Choose directory", "Choose where to store generated files") { dir ->
    SELECTION.filter {
        it instanceof DasTable && it.getKind() == ObjectKind.TABLE
    }.each { generate(it, dir) }
}

def generate(table, dir) {
    def className = javaClassName(table.getName(), true)
    def fields = calcFields(table)
    packageName = getPackageName(dir)
    // DTO生成
    PrintWriter printWriterDTO = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(dir, className + "DTO.java")), "UTF-8"))
    printWriterDTO.withPrintWriter { out -> generateDTO(out, className, fields, table) }

}

// 获取包所在文件夹路径
def getPackageName(dir) {
    return dir.toString().replaceAll("\\\\", ".").replaceAll("/", ".").replaceAll("^.*src(\\.main\\.java\\.)?", "") + ";"
}
// DTO生成输出方法
def generateDTO(out, className, fields, table) {
    Set types = new HashSet()

    fields.each() {
        types.add(it.type)
    }

    out.println "import io.swagger.annotations.ApiModel;"
    out.println "import io.swagger.annotations.ApiModelProperty;"
    out.println "import lombok.*;"
    out.println "import org.springframework.format.annotation.DateTimeFormat;"
    out.println "import javax.persistence.Column;"
    out.println "import java.sql.Clob;"
    out.println "import java.util.Date;"
    out.println "import java.io.Serializable;"
    out.println ""
    out.println "/**"
    out.println " * @Description ${table.getComment()}"
    out.println " * @Author  hjp "
    out.println " * @Date " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " \n"
    out.println " */"
    out.println ""
    out.println ""




    out.println "@Data"
    out.println "@AllArgsConstructor"
    out.println "@NoArgsConstructor"
    out.println "@Builder"
    out.println "@ApiModel(\"${table.getComment()}\")"
    out.println "public class ${className}DTO extends AbsExtDTO implements Serializable {"
    out.println ""
    out.println genSerialID()
    fields.each() {
        if(!(it.name in exceptNames)){
        out.println ""
        // 输出 @ApiModelProperty
        if (isNotEmpty(it.commoent)) {
            out.println "\t@ApiModelProperty(\"${it.commoent.toString()}\")"
            if ("Date".equals(it.type)) {
                out.println "\t// @DateTimeFormat(pattern=\"yyyy-MM-dd HH:mm:ss\")"
            }
        }
        // 输出成员变量
        out.println "\tprivate ${it.type} ${it.name};"
        }
    }
    out.println "}"
}

def calcFields(table) {
    DasUtil.getColumns(table).reduce([]) { fields, col ->
        def spec = Case.LOWER.apply(col.getDataType().getSpecification())

        def typeStr = typeMapping.find { p, t -> p.matcher(spec).find() }.value
        def comm = [
                colName : col.getName(),
                name    : javaName(col.getName(), false),
                type    : typeStr,
                commoent: col.getComment(),
                annos   : "\t@Column(name = \"" + col.getName() + "\" )"]
        if ("id".equals(Case.LOWER.apply(col.getName())))
            comm.annos += ["@Id"]
        fields += [comm]
    }
}

def javaClassName(str, capitalize) {
    def s = com.intellij.psi.codeStyle.NameUtil.splitNameIntoWords(str)
            .collect { Case.LOWER.apply(it).capitalize() }
            .join("")
            .replaceAll(/[^\p{javaJavaIdentifierPart}[_]]/, "_")
    s = s[1..s.size() - 1]
    capitalize || s.length() == 1 ? s : Case.LOWER.apply(s[0]) + s[1..-1]
}

def javaName(str, capitalize) {
    def s = com.intellij.psi.codeStyle.NameUtil.splitNameIntoWords(str)
            .collect { Case.LOWER.apply(it).capitalize() }
            .join("")
            .replaceAll(/[^\p{javaJavaIdentifierPart}[_]]/, "_")
    capitalize || s.length() == 1 ? s : Case.LOWER.apply(s[0]) + s[1..-1]
}
// 生成变量名称
def objName(str, capitalize) {
    def s = com.intellij.psi.codeStyle.NameUtil.splitNameIntoWords(str)
            .collect { Case.LOWER.apply(it).capitalize() }
            .join("")
            .replaceAll(/[^\p{javaJavaIdentifierPart}[_]]/, "_")
    s = s[1..1].toLowerCase() + s[2..s.size() - 1]
    capitalize || s.length() == 1 ? s : Case.LOWER.apply(s[0]) + s[1..-1]
}

def isNotEmpty(content) {
    return content != null && content.toString().trim().length() > 0
}

static String changeStyle(String str, boolean toCamel) {
    if (!str || str.size() <= 1)
        return str

    if (toCamel) {
        String r = str.toLowerCase().split('_').collect { cc -> Case.LOWER.apply(cc).capitalize() }.join('')
        return r[0].toLowerCase() + r[1..-1]
    } else {
        str = str[0].toLowerCase() + str[1..-1]
        return str.collect { cc -> ((char) cc).isUpperCase() ? '_' + cc.toLowerCase() : cc }.join('')
    }
}

static String genSerialID() {
    return "\tprivate static final long serialVersionUID =  " + Math.abs(new Random().nextLong()) + "L;"
}
