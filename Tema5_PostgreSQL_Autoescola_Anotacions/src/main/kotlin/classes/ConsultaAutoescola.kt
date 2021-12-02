package classes

import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(){
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sf = Configuration().configure().buildSessionFactory()
    val sessio = sf.openSession()

    val q = sessio.createQuery("from Professor order by nom")

    for (p in q.list()){
        p as Professor
        println (p.nom)
        for (a in p.alumnes.sortedBy { it.nom }){
            var km = 0
            for (pr in a.practiques)
                km += pr.km
            println("\t" + a.nom + "\t " + km + " km. de pràctiques.\t" + a.examens.size + " exàmens")
        }
        println()
    }
}