package exemples

import java.sql.DriverManager

fun main(args: Array<String>) {
    val url = "jdbc:postgresql://89.36.214.106:5432/geo_ad"
    val usuari = "geo_ad"
    val password = "geo_ad"

    val con = DriverManager.getConnection(url, usuari, password)

    val st = con.createStatement()
    val rs1 = st.executeQuery("SELECT * FROM comarca ORDER BY 1")
    while (rs1.next()) {
        print("" + rs1.getString(1) + "\t")
        println(rs1.getString(2))
        val rs2 = st.executeQuery("SELECT * FROM poblacio " +
                                         "WHERE nom_c='" + rs1.getString(1) + "' " +
                                         "ORDER BY nom")
        while(rs2.next())
            println("\t" + rs2.getString(2))
        rs2.close()
    }
    rs1.close()
    st.close()
    con.close()
}