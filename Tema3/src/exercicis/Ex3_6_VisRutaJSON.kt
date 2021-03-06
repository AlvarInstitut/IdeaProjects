package exercicis

import javax.swing.*
import java.awt.*
import com.squareup.moshi.Moshi
import java.io.File

class FinestraJSON : JFrame() {

    init {
        var llistaRutes: ArrayList<Ruta>
        // sentències per a omplir llistaRutes
        val json = File("Rutes.json").readText()

        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Rutes::class.java)
        val rutes = adapter.fromJson(json)
        llistaRutes = ArrayList(rutes.rutes)

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
        for (r in llistaRutes)
            nomsLlistaRutes.add(r.nom)

        val combo = JComboBox(nomsLlistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"), BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        combo.addActionListener {
            // accions quan s'ha seleccionat un element del combobox,
            // i que han de consistir en omplir el JTextArea
            val ruta = llistaRutes.get(combo.selectedIndex)
            area.text = ""
            for (p in ruta.llistaDePunts)
                area.append(p.nom + " (" + p.coord.latitud + "," + p.coord.longitud + ")\n")
        }
        combo.selectedIndex=0
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        FinestraJSON().isVisible = true
    }
}

