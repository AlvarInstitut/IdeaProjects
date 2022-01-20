package exemples

import com.mongodb.MongoClient

fun main(){
    val con = MongoClient("localhost" )
    val bd = con.getDatabase("test")
    val llibres = bd.getCollection("bicicas").find()

    for (llibre in llibres)
        println(llibre.get("punto"))

    con.close();
}