package exercicis

import com.mongodb.MongoClient
import org.bson.Document
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.net.URLConnection


fun main(){
    val url = URL("http://gestiona.bicicas.es/apps/apps.php")
    val conn: URLConnection = url.openConnection()

    val rd =InputStreamReader(conn.getInputStream())
    val arrel = ((JSONTokener(rd).nextValue() as JSONArray).get(0) as JSONObject).get("ocupacion") as JSONArray
    println(arrel.length())

    val con = MongoClient("localhost" , 27017)
    val bd = con.getDatabase("test")

    for (e in arrel) {
        e as JSONObject

        val doc = Document()
        doc.put("id", e.get("id"))
        doc.put("punto", e.get("punto"))
        doc.put("puestos", e.get("puestos"))
        doc.put("ocupados", e.get("ocupados"))
        bd.getCollection("bicicas").insertOne(doc)
    }
    con.close();

}