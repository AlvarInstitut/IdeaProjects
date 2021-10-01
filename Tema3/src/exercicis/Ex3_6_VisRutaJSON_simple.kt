package exercicis

import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import javax.swing.*
import java.awt.*

import java.io.File
import java.io.FileReader

class FinestraJSON2 : JFrame() {

    init {
        val r_json = FileReader("Rutes.json")

        val rutes = (JSONTokener(r_json).nextValue() as JSONObject).get("rutes") as JSONArray

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("JSON: Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1, BorderLayout.NORTH)
        add(panell2, BorderLayout.CENTER)

        var nomsLlistaRutes = arrayListOf<String>()
        // sentències per a omplir l'ArrayList anterior amb el nom de les rutes
        for (r in rutes) {
            r as JSONObject
            nomsLlistaRutes.add(r.get("nom").toString())
        }

        val combo = JComboBox(nomsLlistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"), BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        combo.addActionListener {
            // accions quan s'ha seleccionat un element del combobox,
            // i que han de consistir en omplir el JTextArea
            val r = rutes.getJSONObject(combo.selectedIndex)
            area.text=""
            for (p in r.getJSONArray("llistaDePunts")) {
                p as JSONObject
                area.append(p.getString("nom") + " (")
                val coord = p.getJSONObject("coord")
                area.append(coord.get("latitud").toString() + ",")
                area.append(coord.get("longitud").toString() + ")\n")
            }
        }
        combo.selectedIndex=0
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        FinestraJSON2().isVisible = true
    }
}

