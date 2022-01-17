package exemples

import com.mongodb.MongoClient

fun main(){
    val con = MongoClient("localhost" , 27017)
    val bd = con.getDatabase("test")
   val llibres = bd.getCollection("libro").find()

    for (llibre in llibres)
        println(llibre.get("titulo"))

   con.close();
}