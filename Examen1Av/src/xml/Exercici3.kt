package xml

import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory

fun main(args: Array<String>){

    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("cataleg.xml")
    val arrel = doc.getElementsByTagName("producte")
    for (i in 0..arrel.length-1){
        val p = arrel.item(i) as Element
        println("\t------ " + p.getAttribute("id") + " -------")
        println("Nom: " + p.getElementsByTagName("nom").item(0).textContent)
        println("Preu: " + p.getElementsByTagName("preu").item(0).textContent)
        println("Característiques:")
        val desc_car = p.getElementsByTagName("descripcio_caract")
        val valor_car = p.getElementsByTagName("valor_caract")
        for(j in 0..desc_car.length-1){
            println("\t" + desc_car.item(j).textContent + ": " +  valor_car.item(j).textContent)
        }
        println()
    }
}