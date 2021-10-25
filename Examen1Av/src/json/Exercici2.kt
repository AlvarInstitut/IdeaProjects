package json

import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.io.FileReader

fun main(){
    val r_json = FileReader("VariacioPoblacional.json")

    val arrel = JSONTokener(r_json).nextValue() as JSONArray

    for (p in arrel){
        p as JSONObject
        if (p.getString("Nombre") == "Castelló"){
            println("\t" + p.getString("Nombre"))
            var s = 0
            for (a in p.getJSONArray("Data")){
                a as JSONObject
                println(a.getString("NombrePeriodo") + " ---> " + a.getInt("Valor"))
                s += a.getInt("Valor")
            }
            println("Variació Total: " + s)
        }

    }
}