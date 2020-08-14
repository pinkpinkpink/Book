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
    // Api
    PrintWriter printWriterApi = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(dir, className + "Api.java")), "UTF-8"))
    printWriterApi.withPrintWriter { out -> generateApi(out, className, objName, fields, table) }

}

// 获取包所在文件夹路径
def getPackageName(dir) {
    return dir.toString().replaceAll("\\\\", ".").replaceAll("/", ".").replaceAll("^.*src(\\.main\\.java\\.)?", "") + ";"
}
// Api生成输出方法
def generateApi(out, className, objName, fields, table) {

    out.println "import com.zdww.cd.commons.utils.JsonResponse;"
    out.println "import com.zdww.cd.commons.utils.Page;"
    out.println "import com.zdww.eemp.arev.biz.api.dto.${className}DTO;"
    out.println "import io.swagger.annotations.Api;"
    out.println "import io.swagger.annotations.ApiImplicitParam;"
    out.println "import io.swagger.annotations.ApiOperation;"
    out.println "import org.springframework.web.bind.annotation.*;"
    out.println "import java.util.List;"

    out.println ""
    out.println "/**"
    out.println " * @Description  "
    out.println " * @Author  hanjp"
    out.println " * @Date " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " "
    out.println " */"
    out.println ""
    out.println "@Api(value = \""+table.getComment()+"\", tags=\""+table.getComment()+"\")"
    out.println "@RequestMapping(path = \"/biz-api/eemp/arev/v1/${objName}\")"
    out.println "public interface ${className}Api {"
    out.println ""
    // 新增
    out.println "@PostMapping(\"/add\")"
    out.println "@ApiOperation(\"add\")"
    out.println "// @RequiresPermissions(\"${objName}::add\")"
    out.println "JsonResponse<Boolean> add(@RequestBody ${className}DTO ${objName}DTO);"
    out.println ""
    // 批量删除
    out.println "@GetMapping(\"/deletes\")"
    out.println "@ApiOperation(\"deletes\")"
    out.println "@ApiImplicitParam(name =\"pkIds\" ,value = \"\")"
    out.println "// @RequiresPermissions(\"${objName}::deletes\")"
    out.println "JsonResponse<Boolean> deletes(@RequestParam(\"pkIds\") String pkIds);"
    out.println ""
    // 主键查询
    out.println "@GetMapping(\"/findById\")"
    out.println "@ApiOperation(\"findById\")"
    out.println "// @RequiresPermissions(\"${objName}::findById\")"
    out.println "JsonResponse<${className}DTO> findById(@RequestParam(\"pkId\")  String pkId);"
    out.println ""
    // 分页查询
    out.println "@GetMapping(\"/findByPage\")"
    out.println "@ApiOperation(\"findByPage\")"
    out.println "// @RequiresPermissions(\"${objName}::findByPage\")"
    out.println "JsonResponse<Page<${className}DTO>> findByPage(@RequestParam(name = \"pageNo\", defaultValue = \"1\", required = true) Long pageNo,"
    out.println "                                 @RequestParam(name = \"pageSize\", defaultValue = \"10\", required = true) Long pageSize);"
    out.println ""
    // 编辑
    out.println "@PostMapping(\"/update\")"
    out.println "@ApiOperation(\"update\")"
    out.println "// @RequiresPermissions(\"${objName}::update\")"
    out.println "JsonResponse<Boolean> update(@RequestBody ${className}DTO ${objName}DTO);"

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
