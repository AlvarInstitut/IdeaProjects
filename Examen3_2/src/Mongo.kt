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
    val cond1 = Document()
    cond1.put("\$gt","80")
    seleccionar.put("InternetDiari",cond1)
    val cond2 = Document()
    cond2.put("\$gt","50")
    cond2.put("\$lt","55")
    seleccionar.put("Comprat3Mesos",cond2)

    val provs = bd.getCollection("EstadisticaInternet").find(seleccionar).sort(ordenar)

    for (p in provs)
        System.out.println(p.get("Nom").toString() + " --> " + p.get("InternetDiari")+ " --> " + p.get("Comprat3Mesos"))

    con.close()
}