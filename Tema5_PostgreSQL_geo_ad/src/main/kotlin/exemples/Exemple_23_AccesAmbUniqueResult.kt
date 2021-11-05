package exemples

import classes.Comarca
import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(args: Array<String>) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sessio = Configuration().configure().buildSessionFactory().openSession()

    val d = sessio.createQuery ("from Comarca where nomC='Alcalatén'").uniqueResult() as Comarca

    println(d.nomC + " - " + d.provincia)

    sessio.close()
}