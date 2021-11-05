package exemples

import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(args: Array<String>) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sessio = Configuration().configure().buildSessionFactory().openSession()

    val t = sessio.beginTransaction()

    val files = sessio.createQuery("delete Institut where codi like '12%'").executeUpdate()

    println("S'han esborrat " + files + " files.")

    t.rollback()

    sessio.close()
}