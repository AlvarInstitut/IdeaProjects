package Exist

import net.xqj.exist.ExistXQDataSource

fun main(){
    val s = ExistXQDataSource()
    s.setProperty("serverName", "89.36.214.106")
    val conn = s.getConnection()

    val sent = "for \$p in //Provincia\n" +
            "let \$d := avg(\$p//Dones)\n" +
            "let \$h := avg(\$p//Homes)\n" +
            "let \$q := count(\$p//Any[number(Dones)<number(Homes)])\n" +
            "return concat(\$p/Nom, '\n\tMitjana Dones: ', \$d,'\n" +
            "\tMitjana Homees: ',\$h,'\n" +
            "\tAnys amb menys dones que homes: ',\$q,'\n')"

    val cons = conn.prepareExpression (sent)
    val rs = cons.executeQuery ()

    while (rs.next())
        println(rs.getItemAsString(null))
}