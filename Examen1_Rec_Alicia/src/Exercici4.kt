import java.sql.DriverManager

fun main(){
    val con = DriverManager.getConnection("jdbc:postgresql://89.36.214.106/factura","factura","factura")
    val st = con.createStatement()
    val sent = "select c.cod_cat , c.descripcio ,count(a.cod_a),avg(a.preu) " +
                    "from categoria c inner join article a using(cod_cat) " +
                    "group by c.cod_cat , c.descripcio " +
                    "order by 1"
    val rs = st.executeQuery(sent)
    while (rs.next()){
        println(rs.getString(1) + ": " + rs.getString(2))
        println("\tNúmero d'articles: " + rs.getInt(3))
        println("\tMitjana de preus: " + rs.getDouble(4))
        println()
    }
    rs.close()
    st.close()
    con.close()
}