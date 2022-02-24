package Mongo

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import org.bson.Document
import java.util.logging.Level
import java.util.logging.LogManager

fun main(){
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)

    val con = MongoClient(MongoClientURI("mongodb://ad:ieselcaminas@89.36.214.106/?authSource=test"))
    val bd = con.getDatabase("test")

    val ordenar = Document()
    ordenar.put("InternetDiari", -1)

    val com = bd.getCollection("EstadisticaInternet").find().sort(ordenar)

    for (c in com)
        if (c.get("InternetDiari").toString()>"80") {
            val comp = c.get("Comprat3Mesos").toString()
            if (comp > "50" && comp<"55")
                println(c.get("Nom").toString() + " --> " + c.get("InternetDiari") + " ---> " + c.get("Comprat3Mesos"))
        }

    con.close()

}