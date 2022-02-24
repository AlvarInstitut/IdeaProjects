package Exist

import net.xqj.exist.ExistXQDataSource

fun main(){
    val s = ExistXQDataSource();
    s.setProperty("serverName", "89.36.214.106")

    val conn = s.getConnection()
   val sent = "for \$c in //comarca\n" +
           "let \$p := count(\$c//poble)\n" +
           "let \$h := sum(\$c//poblacio)\n" +
           "let \$i := count(\$c//institut)\n" +
           "order by \$c\n" +
           "return concat(\$c/nom,':\n\tPobles: ',\$p,'\n\tHabitants: ',\$h,'\n\tInstituts: ',\$i,'\n')\n"

    val cons = conn.prepareExpression (sent)
    val rs = cons.executeQuery ()

    while (rs.next())
        println(rs.getItemAsString(null))
}