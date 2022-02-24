package exist

import net.xqj.exist.ExistXQDataSource

fun main(){
    val s = ExistXQDataSource();
    s.setProperty("serverName", "89.36.214.106")
    //s.setProperty("port", "8080")

    val conn = s.getConnection()

    val sent = "for \$prov in doc('/db/Tema9/PoblacioSexe.xml')//Provincia\n" +
            "let \$d := avg(\$prov//Dones)\n" +
            "let \$h := avg(\$prov//Homes)\n" +
            "let \$q := count(\$prov//Any[number(.//Dones) < number(.//Homes)])\n" +
            "order by \$prov/Nom\n" +
            "return concat(\$prov/Nom,':\n\tMitjana Dones: ',\$d,'\n\tMitjana Homes: ',\$h,'\n\tAnys amb menys dones que homes: ',\$q,'\n')"

    val cons = conn.prepareExpression (sent)
    val rs = cons.executeQuery ()

    while (rs.next())
        println(rs.getItemAsString(null))
}