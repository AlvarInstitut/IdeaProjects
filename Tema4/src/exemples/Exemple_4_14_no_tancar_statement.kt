package exemples

import java.sql.DriverManager

fun main(args: Array<String>) {
    val url = "jdbc:postgresql://89.36.214.106:5432/geo_ad"
    val usuari = "geo_ad"
    val password = "geo_ad"

    val con = DriverManager.getConnection(url, usuari, password)

    val st = con.createStatement()
    val rs = st.executeQuery("SELECT * FROM COMARCA ORDER BY 1")
    st.close()

    while (rs.next()) {
        print("" + rs.getString(1) + "\t")
        println(rs.getString(2))
    }
    rs.close()
    con.close()
}