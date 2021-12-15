package JDBC

import java.sql.DriverManager
import java.util.*

fun main(){
    val con = DriverManager.getConnection("jdbc:postgresql://89.36.214.106/energies","energies","energies")

    fun EnergaiAny(anyEn: Int): Int {
        val st = con.createStatement()
        val rs = st.executeQuery("SELECT SUM(quant) FROM PRODUCCIO_ENERGIA WHERE any_p=" + anyEn)
        if (rs.next())
            return rs.getInt(1)
        else
            return 0
        rs.close()
        st.close()
    }

    val sc = Scanner(System.`in`)
    println("Introdueix un any (0 per a acabar)")
    var a = sc.nextInt()
    while (a != 0){
        println ("Enegia produïda l'any " + a + ": " + EnergaiAny(a))
        a = sc.nextInt()
    }
    con.close()
}