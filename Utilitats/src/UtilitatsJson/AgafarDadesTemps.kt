package UtilitatsJson

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import org.bson.Document
import org.json.JSONObject
import org.json.JSONTokener
import java.net.URL

fun main(){
    val con = MongoClient(MongoClientURI("mongodb://ad:ieselcaminas@89.36.214.106/?authSource=test"))
    val bd = con.getDatabase("test")

    for (i in 6238..6238) {
        val url = URL("https://api.tutiempo.net/json/?lan=es&apid=qCE4zXza4qzv90u&lid=" + i)
        val rd = url.openConnection().getInputStream().reader()

        val arrel = JSONTokener(rd).nextValue() as JSONObject
        val doc= Document((arrel.get("day1") as JSONObject).toMap())
        doc.put("name",(arrel.get("locality") as JSONObject).get("name"))
        bd.getCollection("Temps").insertOne(doc)
        println("" + i +": " + (arrel.get("locality") as JSONObject).get("name"))
    }
}