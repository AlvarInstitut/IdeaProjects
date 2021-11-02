package classes

import classes.Comarca
import classes.SessionFactoryUtil
import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager

fun main(args: Array<String>) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    //val sF = SessionFactoryUtil.sessionFactory
    val sessio = Configuration().configure().buildSessionFactory().openSession()
    val com = sessio.get("classes.Comarca", "Alt Maestrat")
    if (com != null) {
        com as Comarca
        print("La comarca " + com.nomC)
        print(" (província de " + com.provincia + ") ")
        println("té " + com.poblacions.size + " pobles")
        println()
        println("Llista de pobles")
        println("-----------------")

        for (p in com.poblacions.sortedBy { it.nom })
            println(p.nom + " (" + p.poblacio + " habitants)")
    }
    else
        println("No existeix")
    sessio.close()
}