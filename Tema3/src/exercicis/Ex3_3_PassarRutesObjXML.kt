package exercicis

import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun main(){
    val f1 = ObjectInputStream(FileInputStream("Rutes.obj"))
    val doc = DocumentBuilderFactory.newInstance ().newDocumentBuilder().newDocument()
    val arrel = doc.createElement ("rutes")
    doc.appendChild(arrel)
    try{
        while(true){
            val r = f1.readObject() as Ruta
            val rXml = doc.createElement ("ruta")
            arrel.appendChild(rXml)

            val nom = doc.createElement ("nom")
            nom.appendChild(doc.createTextNode(r.nom))
            rXml.appendChild(nom)

            val desn = doc.createElement ("desnivell")
            desn.appendChild(doc.createTextNode(r.desnivell.toString()))
            rXml.appendChild(desn)

            val desnAc = doc.createElement ("desnivellAcumulat")
            desnAc.appendChild(doc.createTextNode(r.desnivellAcumulat.toString()))
            rXml.appendChild(desnAc)

            val punts = doc.createElement ("punts")
            rXml.appendChild(punts)

            var i=1
            for (p in r.llistaDePunts){
                val punt = doc.createElement("punt")
                punt.setAttribute("num",i.toString())
                val nomP = doc.createElement("nom")
                nomP.textContent = p.nom
                punt.appendChild(nomP)
                val lat = doc.createElement("latitud")
                lat.textContent = p.coord.latitud.toString()
                punt.appendChild(lat)
                val lon = doc.createElement("longitud")
                lon.textContent = p.coord.longitud.toString()
                punt.appendChild(lon)
                punts.appendChild(punt)
                i++
            }

        }
    }
    catch(eof: EOFException){
        f1.close()
        val trans = TransformerFactory.newInstance().newTransformer()
        trans.transform(DOMSource(doc), StreamResult("Rutes.xml"))
    }
}