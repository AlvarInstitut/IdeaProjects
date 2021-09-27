package classesJAXB

import java.io.File
import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException

fun main() {
    try {
        val file = File("cotxes.xml")
        val jaxbContext = JAXBContext.newInstance(Oferta::class.java)
        val jaxbUnmarshaller = jaxbContext.createUnmarshaller()
        val oferta = jaxbUnmarshaller.unmarshal(file) as Oferta
        for (v in oferta.getVehiculo())
            println(v.getMatricula() + " (" + v.getMarca() + ")")
    } catch (e: JAXBException) {
        e.printStackTrace()
    }
}