package Mongo

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import org.bson.Document

fun main(){
    val con = MongoClient(MongoClientURI("mongodb://ad:ieselcaminas@89.36.214.106/?authSource=test"))
    val bd = con.getDatabase("test")

    val cond1 = Document()
    cond1.put("InternetDiari",Document("\$gt","80"))
    val cond22 = Document()
    cond22.put("\$gt","50")
    cond22.put("\$lt","55")
    cond1.put("Comprat3Mesos",cond22)

    val com = bd.getCollection("EstadisticaInternet").find(cond1).sort(Document("InternetDiari",-1))

    for (c in com)
        println("%-25s %4s %4s".format(c.get("Nom").toString(),c.get("InternetDiari"),c.get("Comprat3Mesos")))

    con.close()

}