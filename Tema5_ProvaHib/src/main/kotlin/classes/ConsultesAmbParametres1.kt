package classes

import classes.Poblacio
import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(args: Array<String>) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sessio = Configuration().configure().buildSessionFactory().openSession()

    val q = sessio.createQuery("from Poblacio where altura>=?1 and comarca.nomC=?2")
    q.setParameter(1, 500)
    q.setString(2, "Alcalatén")

    q.list().forEach {
        it as Poblacio
        println(it.nom + " - " + it.altura)
    }

    sessio.close()
}
