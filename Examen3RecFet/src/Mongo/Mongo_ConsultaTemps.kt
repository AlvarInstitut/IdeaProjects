package Mongo

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import org.bson.Document

fun main(){
    val con = MongoClient(MongoClientURI("mongodb://ad:ieselcaminas@89.36.214.106/?authSource=test"))
    val bd = con.getDatabase("test")
    val ordenar = Document()
    ordenar.put("temperature_max", -1)
    val seleccionar = Document()
    seleccionar.put("temperature_max", Document("\$gte",17))
    seleccionar.put("temperature_min", Document("\$lt",4))

    val pobles = bd.getCollection("Temps").find(seleccionar).sort(ordenar)

    for (p in pobles)
        System.out.println(p.get("name").toString() + " --> " + p.get("temperature_max")  + " - " + p.get("temperature_min"))

    con.close()

}