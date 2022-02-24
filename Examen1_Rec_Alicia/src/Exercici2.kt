import java.io.EOFException
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun main (){
    val f = ObjectInputStream(FileInputStream("Finques.obj"))

    val doc = DocumentBuilderFactory.newInstance ().newDocumentBuilder().newDocument()
    val arrel = doc.createElement ("finques")
    doc.appendChild(arrel)

    try {
        while (true) {
            val finca = f.readObject() as Finca
            finca.resum()

            val fincaXml = doc.createElement ("finca")

            val adrXml = doc.createElement ("adreca")
            adrXml.appendChild(doc.createTextNode(finca.adreça)) // forma llarga: afegim un fill que és un node de text
            fincaXml.appendChild(adrXml)

            val vivXml = doc.createElement ("vivendes")
            vivXml.setAttribute("num", Integer.toString(finca.vivendes.size))
            fincaXml.appendChild(vivXml)

            arrel.appendChild(fincaXml)
        }
    } catch (eof: EOFException) {
        f.close()

        val trans = TransformerFactory.newInstance().newTransformer()
        trans.setOutputProperty(OutputKeys.INDENT, "yes")
        trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2")
        trans.transform(DOMSource(doc), StreamResult("Finques.xml"))
    }
}