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
    // 实现类ServiceImpl
    PrintWriter printWriterServiceImpl = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(dir, className + "ServiceImpl.java")), "UTF-8"))
    printWriterServiceImpl.withPrintWriter { out -> generateServiceImpl(out, className, objName, fields, table) }

}

// 获取包所在文件夹路径
def getPackageName(dir) {
    return dir.toString().replaceAll("\\\\", ".").replaceAll("/", ".").replaceAll("^.*src(\\.main\\.java\\.)?", "") + ";"
}
// ServiceImpl生成输出方法
def generateServiceImpl(out, className,objName, fields, table) {
    out.println "import com.zdww.cd.commons.dal.core.InputParameters;"
    out.println "import com.zdww.cd.commons.dal.core.PageParam;"
    out.println "import com.zdww.cd.commons.dal.jdbc.JdbcQueryManager;"
    out.println "import com.zdww.cd.commons.dal.jdbc.orm.JdbcEntityManager;"
    out.println "import com.zdww.cd.commons.utils.Page;"
    out.println "import com.zdww.cd.commons.utils.exception.BusinessException;"
    out.println "import com.zdww.eemp.arev.biz.api.dto.${className}DTO;"
    out.println "import com.zdww.eemp.arev.biz.internal.model.${className};"
    out.println "import com.zdww.eemp.arev.biz.internal.model.${className};"
    out.println "import com.zdww.eemp.arev.biz.internal.service.${className}Service;"
    out.println "import org.springframework.stereotype.Service;"
    out.println ""
    out.println "import javax.annotation.Resource;"
    out.println "import java.util.ArrayList;"
    out.println "import java.util.List;"

    out.println ""
    out.println "/**"
    out.println " * @Description  "
    out.println " * @Author  hanjp"
    out.println " * @Date " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " "
    out.println " */"
    out.println ""
    out.println "@Service"
    out.println "public class ${className}ServiceImpl implements ${className}Service {"
    out.println ""
    out.println " @Resource(name = \"eempJdbcEntityManager\")"
    out.println " private JdbcEntityManager jdbcEntityManager;"
    out.println ""
    out.println " @Resource"
    out.println " private JdbcQueryManager jdbcQueryManager;"
    // 新增
    out.println "/**"
    out.println " * @param ${objName}"
    out.println " * @return"
    out.println " */"
    out.println " @Override"
    out.println " public boolean add(${className} ${objName}) {"
    out.println "     boolean result = false;"
    out.println "        try{"
    out.println "            AbsExtDomainUtil.addExtData(${objName});"
    out.println "            int total = jdbcEntityManager.save(${objName});"
    out.println "            if(total>0){"
    out.println "                result = true;"
    out.println "            }"
    out.println "        }catch (Exception e){"
    out.println "            throw new BusinessException(e.getMessage());"
    out.println "        }"
    out.println "        return result;"
    out.println " }"
    // 批量删除
    out.println "/**"
    out.println " * @param pkIds"
    out.println " * @return"
    out.println " */"
    out.println " @Override"
    out.println " public boolean deletes(String pkIds) {"
    out.println "       boolean result = false;"
    out.println "        try{"
    out.println "            List<${className}> list = new ArrayList<>();"
    out.println "            String ids[] = pkIds.split(\",\");"
    out.println "            for(int i=0;i<ids.length;i++){"
    out.println "                ${className} ${objName} = findById(ids[i]);"
    out.println "                AbsExtDomainUtil.deleteExtData(${objName});"
    out.println "                list.add(${objName});"
    out.println "            }"
    out.println "            int total = jdbcEntityManager.delete(list);"
    out.println "            if(total>0){"
    out.println "                result = true;"
    out.println "            }"
    out.println "        }catch (Exception e){"
    out.println "            throw new BusinessException(e.getMessage());"
    out.println "        }"
    out.println "        return result;"
    out.println "    }"

    out.println "/**"
    out.println " * @param pkId"
    out.println " * @return"
    out.println " */"
    out.println " @Override"
    out.println " public ${className} findById(String pkId) {"
    out.println "     return jdbcEntityManager.get(${className}.class, pkId)"
    out.println "         .orElseThrow(() -> new BusinessException(\"${className} findById Error\"));"
    out.println " }"

    out.println "/**"
    out.println " * @param pageNo "
    out.println " * @param pageSize "
    out.println " * @return"
    out.println " */"
    out.println " @Override"
    out.println " public Page<${className}DTO> findByPage(Long pageNo, Long pageSize) {"
    out.println "     InputParameters inputParameters = InputParameters.create();"
    out.println "     PageParam page = new PageParam(pageNo,pageSize);"
    out.println "    return jdbcQueryManager.queryForPage(\"${objName}Service_findByPage\", inputParameters, ${className}.class,page,${className}::convert);"
    out.println " }"


    out.println "/**"
    out.println " * "
    out.println " * @param ${objName}"
    out.println " * @return"
    out.println " */"
    out.println "    @Override"
    out.println "    public boolean update(${className} ${objName}) {"
    out.println "        boolean result = false;"
    out.println "        try {"
    out.println "            AbsExtDomainUtil.updateExtData(${objName});"
    out.println "            int total = jdbcEntityManager.update(${objName});"
    out.println "            if (total > 0) {"
    out.println "                result = true;"
    out.println "            }"
    out.println "        } catch (Exception e) {"
    out.println "            throw new BusinessException(e.getMessage());"
    out.println "        }"
    out.println "    return result;"
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
