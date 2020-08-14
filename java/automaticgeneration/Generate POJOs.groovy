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
    def objName = objName(table.getName(), true)
    def fields = calcFields(table)
    packageName = getPackageName(dir)
    // 实体生成
    PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(dir, className + ".java")), "UTF-8"))
    printWriter.withPrintWriter { out -> generate(out, className, objName, fields, table) }

}

// 获取包所在文件夹路径
def getPackageName(dir) {
    return dir.toString().replaceAll("\\\\", ".").replaceAll("/", ".").replaceAll("^.*src(\\.main\\.java\\.)?", "") + ";"
}
// 实体生成输出方法
def generate(out, className, objName, fields, table) {
    Set types = new HashSet()
    fields.each() {
        types.add(it.type)
    }

    out.println "import com.zdww.cd.commons.domain.AbstractDomainValue;"
    out.println "import com.zdww.cd.commons.domain.CreateAndUpdateTimeable;"
    out.println "import com.zdww.cd.commons.dal.core.annotation.DomainCode;"
    out.println "import com.zdww.eemp.arev.biz.api.dto.${className}DTO;"
    out.println "import com.zdww.eemp.common.core.internal.model.AbsExtDomainValue;"
    out.println "import lombok.*;"
    out.println "import org.springframework.beans.BeanUtils;"
    out.println "import java.util.Date;"
    out.println "import javax.persistence.Column;"
    out.println "import javax.persistence.Entity;"
    out.println "import javax.persistence.Table;"
    out.println "import java.io.Serializable;"
    out.println ""

    out.println "/**\n"
    out.println " * @Description " + table.getComment() + " "
    out.println " * @Author  hanjp \n"
    out.println " * @Date " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " \n"
    out.println " */"
    out.println ""

    out.println "@Data"
    out.println "@Builder"
    out.println "@NoArgsConstructor"
    out.println "@AllArgsConstructor"
    out.println "@Entity"
    out.println "@Table ( name =\"" + table.getName() + "\")"
    out.println "@DomainCode(\"DQ_HJGL\")"
    out.println "@EqualsAndHashCode(callSuper = true)"
    out.println "public class $className  extends AbsExtDomainValue implements Serializable {"
    out.println ""
    out.println genSerialID()
    fields.each() {
        if (!(it.name in exceptNames)) {
            out.println ""
            // 输出注释
            if (isNotEmpty(it.commoent)) {
                out.println "\t/**"
                out.println "\t * ${it.commoent.toString()}"
                out.println "\t */"
            }
            if ((it.annos + "").indexOf("[@Id]") >= 0) out.println "\t@Id"
            if (it.annos != "") out.println "   ${it.annos.replace("[@Id]", "")}"

            // 输出成员变量
            out.println "\tprivate ${it.type} ${it.name};"
        }
    }
    out.println ""
    out.println "\t/**"
    out.println "\t * 数据转换"
    out.println "\t * @param ${objName}"
    out.println "\t * @return ${className}DTO"
    out.println "\t */"
    out.println "\tpublic static " + className + "DTO convert(${className} ${objName}){ "
    out.println "\t\t${className}DTO ${objName}DTO = new ${className}DTO();"
    out.println "\t\tBeanUtils.copyProperties(${objName},${objName}DTO);"
    out.println "\t\treturn ${objName}DTO;"
    out.println "\t}"

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

// 已经修改为使用javaName, 如果有需要可以在def className = javaName(table.getName(), true)中修改为javaClassName
// 处理类名（这里是因为我的表都是以t_命名的，所以需要处理去掉生成类名时的开头的T，
// 如果你不需要那么请查找用到了 javaClassName这个方法的地方修改为 javaName 即可）
def javaClassName(str, capitalize) {
    def s = com.intellij.psi.codeStyle.NameUtil.splitNameIntoWords(str)
            .collect { Case.LOWER.apply(it).capitalize() }
            .join("")
            .replaceAll(/[^\p{javaJavaIdentifierPart}[_]]/, "_")
    // 去除开头的T  http://developer.51cto.com/art/200906/129168.htm
    s = s[1..s.size() - 1]
    capitalize || s.length() == 1 ? s : Case.LOWER.apply(s[0]) + s[1..-1]
}

def javaName(str, capitalize) {
//    def s = str.split(/(?<=[^\p{IsLetter}])/).collect { Case.LOWER.apply(it).capitalize() }
//            .join("").replaceAll(/[^\p{javaJavaIdentifierPart}]/, "_")
//    capitalize || s.length() == 1? s : Case.LOWER.apply(s[0]) + s[1..-1]
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
