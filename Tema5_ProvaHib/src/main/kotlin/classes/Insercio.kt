package classes

import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(args: Array<String>) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sf = Configuration().configure().buildSessionFactory()
    val sessio = sf.openSession()
    val t = sessio.beginTransaction ()
    val com = Comarca()

    com.nomC = "Columbretes"
    com.provincia = "Castelló"

    sessio.save(com)

    t.commit()
    sessio.close()
}