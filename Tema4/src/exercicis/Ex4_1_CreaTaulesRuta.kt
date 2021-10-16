package exercicis

import java.sql.DriverManager

fun main(args: Array<String>) {
    val url = "jdbc:sqlite:Rutes.sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()
    st.executeUpdate("CREATE TABLE RUTES (" +
                       "num_r INT PRIMARY KEY, " +
                        "nom_r TEXT, " +
                        "desn INT, " +
                        "desn_ac INT)")
    st.executeUpdate("CREATE TABLE PUNTS (" +
            "num_r INT REFERENCES RUTES, " +
            "num_p INT, " +
            "nom_p TEXT, " +
            "latitud REAL, " +
            "longitud REAL, " +
            "PRIMARY KEY (num_r,num_p))")
    st.close()
    con.close()
}