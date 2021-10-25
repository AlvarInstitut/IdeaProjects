import classes.Comarca

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
        f.writeObject(com)
    }
}