package exercicis

import com.mongodb.MongoClient

fun main(){
    val con = MongoClient("localhost" , 27017)
    val bd = con.getDatabase("test")

    val estacions = bd.getCollection("bicicas").find()
    for (e in estacions){
        println("" + e.get("id") + ".- " + e.get("punto") + " (" + e.get("ocupados") + "/" + e.get("puestos") + ")")
    }
    con.close()
}