import classes.Comarca
import classes.Comarques
import classes.Instituts
import classes.Poblacions

import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.util.logging.Level
import java.util.logging.LogManager
import javax.persistence.Persistence

fun main(){
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val f = ObjectOutputStream(FileOutputStream("GeoAD.obj"))
    val em = Persistence.createEntityManagerFactory("default").createEntityManager()
    val sent = em.createQuery("select c from Comarca c order by c.nomC")
    for (com in sent.resultList) {
        com as Comarca
        println(com.nomC + " (" + com.provincia +"): " + com.poblacions!!.size + " pobles")
        val pobl = mutableListOf<Poblacions>()
        val c = Comarques(com.nomC!!,com.provincia!!,pobl)
        for (p in com.poblacions!!){
            val inst = mutableListOf<Instituts>()
            val po = Poblacions(p.codM,p.nom,p.poblacio,p.extensio,p.altura,p.longitud,p.latitud,p.llengua,inst,c)
            if (p.instituts != null)
                 for (i in p.instituts!!) {
                     inst.add(Instituts(i.codi!!, i.nom, i.adreca, i.numero, i.codpostal,po))
                 }
            po.instituts=inst
            pobl.add(po)
        }
        c.poblacions=pobl
        f.writeObject(c)
    }
}