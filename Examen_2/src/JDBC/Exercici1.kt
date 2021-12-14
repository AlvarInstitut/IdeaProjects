package JDBC

import java.sql.DriverManager

fun main(){
    val con = DriverManager.getConnection("jdbc:postgresql://89.36.214.106/energies","energies","energies")
    val st =con.createStatement()
    val rs = st.executeQuery("SELECT concepte , SUM(quant) " +
                                    "FROM ENERGIA , PRODUCCIO_ENERGIA " +
                                    "WHERE num=energia " +
                                    "GROUP BY 1 ")
    while(rs.next())
        println(rs.getString(1) + " --> " + rs.getDouble(2))

    rs.close()
    st.close()
    con.close()
}