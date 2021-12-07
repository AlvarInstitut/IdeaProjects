package classes

import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(){
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sessio = Configuration().configure().buildSessionFactory().openSession()

    val q = sessio.createQuery("from Ruta order by nomR")

    for (r in q.list()){
        r as Ruta
        println(r.nomR + " - " + r.punts.size + " punts")
        for (p in r.punts)
            println ("\t" + p.nomP)
        println()
    }
    sessio.close()
}