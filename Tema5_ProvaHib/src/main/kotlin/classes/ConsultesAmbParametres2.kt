package classes

import classes.SessionFactoryUtil
import classes.Poblacio
import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(args: Array<String>) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sessio = Configuration().configure().buildSessionFactory().openSession()

    val q = sessio.createQuery("from Poblacio where altura>=:alt and comarca.nomC=:com")
    q.setParameter("alt",500)

    q.setString("com", "Alcalatén")

    q.list().forEach {
        it as Poblacio
        println(it.nom + " -- " + it.altura)
    }

    sessio.close()
}