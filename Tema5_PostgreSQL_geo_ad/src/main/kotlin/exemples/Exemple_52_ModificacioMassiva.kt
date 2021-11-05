package exemples

import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(args: Array<String>) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sessio = Configuration().configure().buildSessionFactory().openSession()

    val t = sessio.beginTransaction()

    val files = sessio.createQuery("update Poblacio set poblacio = poblacio *1.05 where poblacio < 200").executeUpdate()

    println("S'han modificat " + files + " files.")

    t.rollback()

    sessio.close()
}