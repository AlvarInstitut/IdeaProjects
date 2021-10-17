package util.bd

import java.sql.Connection
import java.sql.DriverManager

class GestionarRutesBD {
    lateinit var con: Connection
    init{
        con = DriverManager.getConnection("jdbc:sqlite:Rutes.sqlite")
        val st = con.createStatement()
        st.executeUpdate("CREATE TABLE IF NOT EXISTS RUTES (" +
                "num_r INT PRIMARY KEY, " +
                "nom_r TEXT, " +
                "desn INT, " +
                "desn_ac INT)")
        st.executeUpdate("CREATE TABLE IF NOT EXISTS PUNTS (" +
                "num_r INT REFERENCES RUTES, " +
                "num_p INT, " +
                "nom_p TEXT, " +
                "latitud REAL, " +
                "longitud REAL, " +
                "PRIMARY KEY (num_r,num_p))")
        st.close()
    }
    fun close(){
        con.close()
    }
    fun inserir(r: Ruta){
        val st1 = con.createStatement()
        val rs1 = st1.executeQuery("SELECT MAX(num_r) FROM RUTES")
        var num = 1
        if (rs1.next())
            num = rs1.getInt(1) + 1
        val st2 = con.prepareStatement("INSERT INTO RUTES VALUES(?,?,?,?)")
        st2.setInt(1,num)
        st2.setString(2,r.nom)
        st2.setInt(3,r.desnivell)
        st2.setInt(4,r.desnivellAcumulat)
        st2.executeUpdate()
        val st3 = con.prepareStatement("INSERT INTO PUNTS VALUES(?,?,?,?,?)")
        var numPunt = 1
        for (p in r.llistaDePunts){
            st3.setInt(1,num)
            st3.setInt(2,numPunt)
            st3.setString(3,p.nom)
            st3.setDouble(4,p.coord.latitud)
            st3.setDouble(5,p.coord.longitud)
            st3.executeUpdate()
            numPunt++
        }
        st1.close()
        st2.close()
        st3.close()
    }

    fun buscar(i: Int): Ruta?{
        val st1 = con.createStatement()
        val rs1 = st1.executeQuery("SELECT * FROM RUTES WHERE num_r = " + i)
        if (rs1.next()){
            val llistaDePunts = arrayListOf<PuntGeo>()
            val st2 = con.createStatement()
            val rs2 = st2.executeQuery("SELECT * FROM PUNTS WHERE num_r = " + i)
            while(rs2.next())
                llistaDePunts.add(PuntGeo(rs2.getString(3), Coordenades(rs2.getDouble(4),rs2.getDouble(5))))

            return Ruta(rs1.getString(2),rs1.getInt(3),rs1.getInt(4),llistaDePunts)
        }
        else
            return null
    }
    fun llistat(): ArrayList<Ruta>{
        val llistaDeRutes = arrayListOf<Ruta>()
        val st1 = con.createStatement()
        val rs1 = st1.executeQuery("SELECT num_r FROM RUTES")
        while (rs1.next())
            llistaDeRutes.add(buscar(rs1.getInt(1))!!)
    return llistaDeRutes
    }
    fun esborrar(i: Int){
        val st1 = con.createStatement()
        st1.executeUpdate("DELETE FROM PUNTS WHERE num_r=" + i)
        st1.executeUpdate("DELETE FROM RUTES WHERE num_r=" + i)
        st1.close()
    }
    fun esborrar(r: Ruta){
        val st0 = con.prepareStatement("SELECT num_r FROM RUTES WHERE nom_r=?")
        st0.setString(1,r.nom)
        val rs0=st0.executeQuery()
        if (rs0.next()) {
            val st1 = con.createStatement()
            st1.executeUpdate("DELETE FROM PUNTS WHERE num_r=" + rs0.getInt(1))
            st1.executeUpdate("DELETE FROM RUTES WHERE num_r=" + rs0.getInt(1))
            st1.close()
        }
    }
    fun guardar(r: Ruta){
        val st1 = con.prepareStatement("SELECT * FROM RUTES WHERE nom_r = ?")
        st1.setString(1,r.nom)
        val rs1 = st1.executeQuery()
        if (rs1.next()){
            val numR = rs1.getInt(1)
            val st2 = con.prepareStatement("UPDATE RUTES SET desn = ? , desn_ac = ? WHERE num_r = ?")
            st2.setInt(1,r.desnivell)
            st2.setInt(2,r.desnivellAcumulat)
            st2.setInt(3,numR)
            st2.executeUpdate()

            con.createStatement().executeUpdate("DELETE FROM PUNTS WHERE num_r=" + numR)
            val st3 = con.prepareStatement("INSERT INTO PUNTS VALUES(?,?,?,?,?)")
            var numPunt = 1
            for (p in r.llistaDePunts){
                st3.setInt(1,numR)
                st3.setInt(2,numPunt)
                st3.setString(3,p.nom)
                st3.setDouble(4,p.coord.latitud)
                st3.setDouble(5,p.coord.longitud)
                st3.executeUpdate()
                numPunt++
            }
            st2.close()
            st3.close()
        }
        else inserir(r)

        st1.close()
    }
}