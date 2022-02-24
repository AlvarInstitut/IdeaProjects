package Mongo

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import org.bson.Document
import java.io.File

fun main(){
    val f = File("internet.csv")
    val con = MongoClient(MongoClientURI("mongodb://ad:ieselcaminas@89.36.214.106/?authSource=test"))
    val bd = con.getDatabase("test")
    for ( l in f.readLines()){
        val linia = l.split(";")
        val doc = Document()
        doc.put("Nom",linia.get(0))
        doc.put("TotalPersones",linia.get(1))
        doc.put("InternetDiari",linia.get(2))
        doc.put("Comprat3Mesos",linia.get(3))
        println(doc)
        bd.getCollection("EstadisticaInternet").insertOne(doc)
    }
}