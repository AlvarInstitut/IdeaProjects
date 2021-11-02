package classes

import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(args: Array<String>) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sf = Configuration().configure().buildSessionFactory()
    val sessio = sf.openSession()
    val com = sessio.load("classes.Comarca", "Alt Maestrat") as Comarca
    print("Comarca " + com.nomC + ": ")
    print(com.provincia)
    println(" (" + com.poblacions.size + " pobles)")
    sessio.close()
}