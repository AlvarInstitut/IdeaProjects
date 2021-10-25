package jdbc

import java.sql.DriverManager

fun main(){
    val con = DriverManager.getConnection("jdbc:postgresql://89.36.214.106:5432/factura","factura","factura")
    val st1 = con.createStatement()
    val rs1 = st1.executeQuery("SELECT CATEGORIA.cod_cat,descripcio " +
                                "FROM CATEGORIA " +
                                "ORDER BY 1")
    val st2 = con.prepareStatement("SELECT COUNT(cod_a),AVG(preu) " +
                                    "FROM ARTICLE " +
                                    "WHERE cod_cat=?")
    while(rs1.next()){
        println(rs1.getString(1) + ": " + rs1.getString(2))
        st2.setString(1,rs1.getString(1))
        val rs2 = st2.executeQuery()
        if (rs2.next()) {
            println("\tNúmero d'articles: " + rs2.getInt(1))
            println("\tMitjana de preus: " + rs2.getDouble(2))
        }
        println()
    }
    st2.close()
    rs1.close()
    st1.close()
    con.close()
}