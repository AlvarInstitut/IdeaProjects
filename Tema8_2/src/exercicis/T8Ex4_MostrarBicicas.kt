package exercicis

import com.mongodb.MongoClient
import java.util.logging.Level
import java.util.logging.LogManager

fun main(){
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val con = MongoClient("localhost" , 27017)
    val bd = con.getDatabase("test")

    val estacions = bd.getCollection("bicicas").find()
    for (e in estacions){
        println("" + e.get("id") + ".- " + e.get("punto") + " (" + e.get("ocupados") + "/" + e.get("puestos") + ")")
    }
    con.close()
}