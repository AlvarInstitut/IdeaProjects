package classes

import classes.Comarca
import classes.SessionFactoryUtil

fun main(args:Array<String>){
    val sF = SessionFactoryUtil.sessionFactory
    val sessio = sF.openSession()
    val com = sessio.load("classes.Comarca", "Alt Maestrat") as Comarca
    print("Comarca " + com.nomC + ": ")
    print(com.provincia)
    println(" (" + com.poblacions.size + " pobles)")
    sessio.close()
}