package exercicis

import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.sql.DriverManager

fun main(args: Array<String>) {
    val url = "jdbc:sqlite:Rutes.sqlite"
    val con = DriverManager.getConnection(url)

    val f = ObjectInputStream(FileInputStream("Rutes.obj"))

    try {
        var i=1
        while (true) {
            val r = f.readObject() as Ruta
            val sql1 = "INSERT INTO RUTES VALUES(?,?,?,?)"
            val st1 = con.prepareStatement(sql1)
            st1.setInt(1,i)
            st1.setString(2,r.nom)
            st1.setInt(3,r.desnivell)
            st1.setInt(4,r.desnivellAcumulat)
            st1.executeUpdate()
            var j=1
            for(p in r.llistaDePunts){
                val sql2 = "INSERT INTO PUNTS VALUES(?,?,?,?,?)"
                val st2 = con.prepareStatement(sql2)
                st2.setInt(1,i)
                st2.setInt(2,j)
                st2.setString(3,p.nom)
                st2.setDouble(4,p.coord.latitud)
                st2.setDouble(5,p.coord.longitud)
                st2.executeUpdate()
                j++
            }
            i++
        }
    } catch (e: EOFException){
        f.close()
        con.close()
    }
}