package JDBC

import java.sql.DriverManager

fun main(){
    val con = DriverManager.getConnection("jdbc:postgresql://89.36.214.106/energies","energies","energies")

    val st = con.createStatement()
    val rs = st.executeQuery("SELECT nom, concepte, SUM(quant) " +
                                "FROM PAIS p, PRODUCCIO_ENERGIA pe, ENERGIA e " +
                                "WHERE p.num=pe.pais AND pe.energia=e.num " +
                                "GROUP BY 1,2 " +
                                "ORDER BY 1,2")
    var ant=""
    while(rs.next()){
        if (rs.getString(1)!=ant){
            ant=rs.getString(1)
            println(ant)
        }
        println("\t" + rs.getString(2) + " ---> " + rs.getInt(3))
    }
    rs.close()
    st.close()
    con.close()
}