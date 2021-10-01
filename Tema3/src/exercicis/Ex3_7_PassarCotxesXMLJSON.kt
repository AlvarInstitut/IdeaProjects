package exercicis

import org.json.JSONArray
import org.json.JSONObject
import org.w3c.dom.Element
import java.io.FileWriter

import javax.xml.parsers.DocumentBuilderFactory

fun main(){
    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("cotxes.xml")
    val arrel = JSONObject()
    val ofertaJson = JSONObject()
    arrel.put("oferta",ofertaJson)
    val vehiclesJson = JSONArray()
    ofertaJson.put("vehiculos",vehiclesJson)
    val vehicles = doc.getElementsByTagName("vehiculo")
    for(i in 0 until vehicles.length){
        val v = vehicles.item(i) as Element
        val vJson = JSONObject()
        vehiclesJson.put(vJson)
        vJson.put("marca",v.getElementsByTagName("marca").item(0).textContent)
        val model = v.getElementsByTagName("modelo").item(0) as Element
        val modelJson = JSONObject()
        vJson.put("modelo",modelJson)
        modelJson.put("color",model.getAttribute("color"))
        modelJson.put("nombre_modelo",model.textContent)
        val motor = v.getElementsByTagName("motor").item(0) as Element
        val motorJson = JSONObject()
        vJson.put("motor",motorJson)
        motorJson.put("combustible",motor.getAttribute("combustible"))
        motorJson.put("nombre_motor",motor.textContent)
        vJson.put("matricula",v.getElementsByTagName("matricula").item(0).textContent)
        vJson.put("kilometros",v.getElementsByTagName("kilometros").item(0).textContent)
        vJson.put("precio_inicial",v.getElementsByTagName("precio_inicial").item(0).textContent)
        vJson.put("precio_oferta",v.getElementsByTagName("precio_oferta").item(0).textContent)
        val extras = v.getElementsByTagName("extra")
        val extraJson = JSONArray()
        vJson.put("extra",extraJson)
        for(j in 0 until extras.length){
            val extra = extras.item(j) as Element
            val eJson = JSONObject()
            extraJson.put(eJson)
            eJson.put("valor",extra.getAttribute("valor"))
            eJson.put("nombre_extra",extra.textContent)
        }
        val fotos = v.getElementsByTagName("foto")
        val fotoJson = JSONArray()
        vJson.put("foto",fotoJson)
        for(j in 0 until fotos.length){
            val foto = fotos.item(j) as Element
            fotoJson.put(foto.textContent)
        }
    }
    val f = FileWriter("cotxes.json")
    f.write(arrel.toString(4))
    f.close()

}