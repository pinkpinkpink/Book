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
    // Controller
    PrintWriter printWriterController = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(dir, className + "Controller.java")), "UTF-8"))
    printWriterController.withPrintWriter { out -> generateController(out, className, objName, fields, table) }

}

// 获取包所在文件夹路径
def getPackageName(dir) {
    return dir.toString().replaceAll("\\\\", ".").replaceAll("/", ".").replaceAll("^.*src(\\.main\\.java\\.)?", "") + ";"
}
// Controller生成输出方法
def generateController(out, className, objName, fields, table) {

    out.println "import com.zdww.cd.commons.utils.JsonResponse;"
    out.println "import com.zdww.cd.commons.utils.Page;"
    out.println "import com.zdww.eemp.arev.biz.api.${className}Api;"
    out.println "import com.zdww.eemp.arev.biz.api.dto.${className}DTO;"
    out.println "import com.zdww.eemp.arev.biz.internal.model.${className};"
    out.println "import com.zdww.eemp.arev.biz.internal.service.${className}Service;"
    out.println "import lombok.Data;"
    out.println "import lombok.extern.slf4j.Slf4j;"
    out.println "import org.springframework.beans.BeanUtils;"
    out.println "import org.springframework.web.bind.annotation.RestController;"
    out.println ""
    out.println "import javax.annotation.Resource;"
    out.println "import java.util.ArrayList;"
    out.println "import java.util.List;"
    out.println ""
    // 添加
    out.println "/**"
    out.println " * @InterfaceName ${className}Service"
    out.println " * @Description  "
    out.println " * @Author  hanjp"
    out.println " * @Date " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " "
    out.println " */"
    out.println ""
    out.println "@Slf4j"
    out.println "@Data"
    out.println "@RestController"
    out.println "public class ${className}Controller implements ${className}Api {"
    out.println ""
    out.println "@Resource"
    out.println "private ${className}Service ${objName}Service;"
    // 添加
    out.println "@Override"
    out.println "public JsonResponse<Boolean> add(${className}DTO ${objName}DTO) {"
    out.println "\ttry {"
    out.println "\t\t   return JsonResponse.ok(${objName}Service.add(convertToPO(${objName}DTO))) ;"
    out.println "\t} catch (Exception e) {"
    out.println "\t\t    return JsonResponse.error(e.getCause().getMessage());"
    out.println "\t}"
    out.println "}"
    out.println ""
    // 分页
    out.println "@Override"
    out.println " public JsonResponse<Page<${className}DTO>> findByPage(Long pageNo, Long pageSize) {"
    out.println "     Page<${className}DTO> pages =  ${objName}Service.findByPage( pageNo,  pageSize);"
    out.println "     return JsonResponse.ok(pages);"
    out.println " }"
    out.println ""
    // 批量删除
    out.println "@Override"
    out.println " public JsonResponse<Boolean> deletes(String pkIds) {"
    out.println "   return JsonResponse.ok(${objName}Service.deletes(pkIds)) ;"
    out.println " }"
    out.println ""
    // 主键查询
    out.println "@Override"
    out.println " public JsonResponse<${className}DTO>  findById(String pkId) {"
    out.println "   return JsonResponse.ok(convertToDTO(${objName}Service.findById(pkId))) ;"
    out.println " }"
    out.println ""
    // 更新
    out.println "@Override"
    out.println " public JsonResponse<Boolean> update(${className}DTO ${objName}DTO) {\n"
    out.println "   return JsonResponse.ok(${objName}Service.update(convertToPO(${objName}DTO)));\n"
    out.println "}"

    out.println " public ${className}DTO convertToDTO(${className} ${objName}) {"
    out.println "   if (${objName} != null) {"
    out.println "       ${className}DTO ${objName}DTO = new ${className}DTO();"
    out.println "       BeanUtils.copyProperties(${objName}, ${objName}DTO);"
    out.println "       return ${objName}DTO;"
    out.println "     }"
    out.println "      return null;"
    out.println " }"
    out.println " public ${className} convertToPO(${className}DTO ${objName}DTO) {"
    out.println "        if (${objName}DTO != null) {"
    out.println "            ${className} ${objName} = new ${className}();"
    out.println "            BeanUtils.copyProperties(${objName}DTO, ${objName});"
    out.println "            return ${objName};"
    out.println "        }"
    out.println "        return null;"
    out.println " }"

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
