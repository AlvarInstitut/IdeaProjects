package JDBC

import java.sql.DriverManager
import java.util.*

fun main(){
    val con = DriverManager.getConnection("jdbc:postgresql://89.36.214.106/energies","energies","energies")
    val st = con.prepareStatement("SELECT SUM(quant) FROM PRODUCCIO_ENERGIA WHERE energia = ?")
    val sc = Scanner(System.`in`)
    println("Introdueix un número del 1 al 5 (0 per acabar):")
    var e = sc.nextInt()
    while (e != 0){
        st.setInt(1,e)
        val rs = st.executeQuery()
        rs.next()
        println("Energia " + e + ". Total: " + rs.getInt(1))
        rs.close()
        e = sc.nextInt()
    }

    st.close()
    con.close()
}