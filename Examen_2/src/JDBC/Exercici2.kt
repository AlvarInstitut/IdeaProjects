package JDBC

import java.sql.DriverManager

fun main(){
    val con = DriverManager.getConnection("jdbc:postgresql://89.36.214.106/energies","energies","energies")
    val st =con.createStatement()
    val rs = st.executeQuery("SELECT nom, concepte , SUM(quant) " +
            "FROM ENERGIA , PRODUCCIO_ENERGIA , PAIS " +
            "WHERE ENERGIA.num=energia AND pais=PAIS.num " +
            "GROUP BY 1, 2 " +
            "ORDER BY 1")
    var nomAnt =""
    while(rs.next()) {
        if (rs.getString(1) != nomAnt){
            nomAnt = rs.getString(1)
            println(nomAnt)
        }
        println("\t" + rs.getString(2) + " ---> " + rs.getInt(3))
    }
    rs.close()
    st.close()
    con.close()
}