package exemples

import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.net.URL

fun main(args: Array<String>) {

    val adr = URL("http://localhost:41062/www/rutes_2.php");
    val rutes = JSONTokener(adr.openConnection().getInputStream()).nextValue() as JSONArray

    for (r in rutes){
        r as JSONObject
        println("Ruta " + r.get("num_r").toString() + ": " + r.get("nom_r")
                .toString() + ". Desnivell: " + r.get("desn")
                .toString() + ". Desnivell Acumulat: " + r.get("desn_acum") )
    }
}