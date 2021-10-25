package jdbc

import java.sql.DriverManager

fun main(){
    val con = DriverManager.getConnection("jdbc:postgresql://89.36.214.106:5432/factura","factura","factura")
    val st = con.createStatement()
    val rs = st.executeQuery("SELECT CATEGORIA.cod_cat,descripcio,COUNT(cod_a), AVG(preu) " +
                                "FROM CATEGORIA INNER JOIN ARTICLE ON CATEGORIA.cod_cat=ARTICLE.cod_cat " +
                                "GROUP BY 1,2 " +
                                "ORDER BY 1")
    while(rs.next()){
        println(rs.getString(1) + ": " + rs.getString(2))
        println("\tNúmero d'articles: " + rs.getInt(3))
        println("\tMitjana de preus: " + rs.getDouble(4))
        println()
    }
    rs.close()
    st.close()
    con.close()
}