import classes.Comarca
import java.util.logging.Level
import java.util.logging.LogManager
import javax.persistence.Persistence

fun main(){
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
    val em = Persistence.createEntityManagerFactory("default").createEntityManager()
    val sent = em.createQuery("select c from Comarca c order by c.nomC")
    for (com in sent.resultList) {
        com as Comarca
        println(com.nomC + " (" + com.provincia +"): " + com.poblaciosByNomC!!.size + " pobles")
    }
}