package exemples

import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.net.URL
import java.util.*

fun main(args: Array<String>) {

    val url1 = URL("http://localhost:41062/www/rutes_2.php");
    val rutes = JSONTokener(url1.openConnection().getInputStream()).nextValue() as JSONArray

    val sc = Scanner(System.`in`)

    for (r in rutes){
        r as JSONObject
        println("Ruta " + r.get("num_r").toString() + ": " + r.get("nom_r") )
    }
    println("Tria una ruta (0 per a acabar)")
    var opcio = sc.nextInt()
    while (opcio != 0){
        if (opcio>0 && opcio<=rutes.length()){
            val url2 = URL("http://localhost:41062/www/punts.php?num_r="+opcio);
            val punts = JSONTokener(url2.openConnection().getInputStream()).nextValue() as JSONArray
            for (p in punts){
                p as JSONObject
                println("Punt " + p.get("num_p") + ": " + p.get("nom_p") + " (" + p.get("latitud") + "," + p.get("longitud") + ")")
            }
            println()
        }
        println("Tria una ruta (0 per a acabar)")
        opcio = sc.nextInt()
    }
}