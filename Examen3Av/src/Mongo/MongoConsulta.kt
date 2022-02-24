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

    val seleccionar = Document()
    val cond = Document()
    cond.put("\$lt","55")
    cond.put("\$gt","50")
    seleccionar.put("InternetDiari", Document("\$gte","80"))
    seleccionar.put("Comprat3Mesos", cond)

    val com = bd.getCollection("EstadisticaInternet").find(seleccionar).sort(ordenar)

    for (c in com)
        println("%-25s %4s %4s".format(c.get("Nom").toString(),c.get("InternetDiari"),c.get("Comprat3Mesos")))

    con.close()

}