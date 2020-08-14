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
    // Service
    PrintWriter printWriterService = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(dir, className + "Service.java")), "UTF-8"))
    printWriterService.withPrintWriter { out -> generateService(out, className, objName, fields, table) }

}

// 获取包所在文件夹路径
def getPackageName(dir) {
    return dir.toString().replaceAll("\\\\", ".").replaceAll("/", ".").replaceAll("^.*src(\\.main\\.java\\.)?", "") + ";"
}

def generateService(out, className,objName, fields, table) {

    out.println "import com.zdww.cd.commons.utils.Page;"
    out.println "import com.zdww.eemp.arev.biz.api.dto.${className}DTO;"
    out.println "import com.zdww.eemp.arev.biz.internal.model.${className};"
    out.println "import java.util.List;"
    out.println ""
    out.println "/**"
    out.println " * @InterfaceName ${className}Service"
    out.println " * @Description "
    out.println " * @Author  hanjp"
    out.println " * @Date " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ""
    out.println " */"
    out.println ""
    out.println "public interface ${className}Service{"
    out.println ""
    // 添加
    out.println "/**"
    out.println " * "
    out.println " * @param ${objName}"
    out.println " * @return"
    out.println " */"
    out.println " boolean add(${className} ${objName});"
    // 分页
    out.println "/**"
    out.println " * @param pageNo    "
    out.println " * @param pageSize  "
    out.println " * @return"
    out.println " */"
    out.println " Page<${className}DTO> findByPage(Long pageNo, Long pageSize);"
    // 批量删除
    out.println "/**"
    out.println " *"
    out.println " * @param pkIds"
    out.println " * @return"
    out.println " */"
    out.println " boolean deletes(String pkIds);"
    // 主键查询
    out.println "/**"
    out.println " *"
    out.println " * @param pkId"
    out.println " * @return"
    out.println " */"
    out.println " ${className} findById(String pkId);"
    // 更新
    out.println "/**"
    out.println " * update"
    out.println " * @param ${objName}"
    out.println " * @return"
    out.println " */"
    out.println " boolean update(${className} ${objName});"

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
