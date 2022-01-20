package exemples

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import org.bson.Document
import java.util.logging.Level
import java.util.logging.LogManager


fun main(){
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)

    val con = MongoClient(MongoClientURI("mongodb://ad:ieselcaminas@89.36.214.106/?authSource=test"))
    val bd = con.getDatabase("test")

    val doc = Document()
    doc.put("msg4","Missatge inserit des de Kotlin")
    val c = bd.getCollection("exemple").insertOne(doc)

    con.close()
}