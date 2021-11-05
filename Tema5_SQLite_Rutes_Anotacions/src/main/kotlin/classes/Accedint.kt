package classes

import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(args: Array<String>) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sessio = Configuration().configure().buildSessionFactory().openSession()

    val r = sessio.load("classes.Rutes", 1) as Rutes
    print("Ruta " +  r.nomR + ": ")
    print(r.desn)
    println(" (" + r.punts.size + " pobles)")

    for (p in r.punts)
        println("\t" + p.nomP)
    sessio.close()
}