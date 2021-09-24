package exercicis

import javax.swing.*
import java.awt.*
import java.io.File

class Exercici_2_3 : JFrame() {
    val area = JTextArea()
    val scrollPane = JScrollPane(area)

    val menu_p = JMenuBar()

    val menu_arxiu = JMenu("Arxiu")
    val menu_ajuda = JMenu("Ajuda")

    val obrir = JMenuItem("Obrir")
    val guardar = JMenuItem("Guardar")
    val guardarCom = JMenuItem("Guardar com ...")
    val eixir = JMenuItem("Eixir")

    val quantA = JMenuItem("Quant a Editor")

    val fCh = JFileChooser()

    // per a l'ampliació
    val codificacio = JComboBox(arrayOf("UTF-8","ISO-8859-15"))

    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        setLayout(BorderLayout())
        setTitle("Editor de text més avançat")
        add(scrollPane)
        // Per a l'ampliació
        codificacio.setSelectedIndex(0)
        add(codificacio,BorderLayout.SOUTH)
        area.setEditable(true)

        setSize(750, 400)
        setJMenuBar(menu_p)

        menu_p.add(menu_arxiu)
        menu_p.add(menu_ajuda)

        menu_arxiu.add(obrir)
        menu_arxiu.add(guardar)
        menu_arxiu.add(guardarCom)
        menu_arxiu.add(JSeparator())
        menu_arxiu.add(eixir)

        menu_ajuda.add(quantA);

        obrir.addActionListener { obrir() }

        guardar.addActionListener { guardar() }

        guardarCom.addActionListener { guardarCom() }

        eixir.addActionListener { eixir() }

        quantA.addActionListener { quantA() }
    }

    fun obrir() {
        // Instruccions per a obrir un fitxer i posar el contingut en el JTextArea
        if (fCh.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
            area.text = fCh.selectedFile.readText()
    }

    fun guardar() {
        // Instruccions per a guardar el contingut del JTextArea al fitxer.
        if (fCh.selectedFile != null)
            fCh.selectedFile.writeText(area.text, charset(codificacio.selectedItem.toString()))
        else
            guardarCom()
    }

    fun guardarCom() {
        // Instruccions per a guardar el contingut del JTextArea al fitxer, amb la possibilitat de canviar el nom
        if (fCh.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
            fCh.selectedFile.writeText(area.text, charset(codificacio.selectedItem.toString()))
    }

    fun eixir() {
        // Instruccions per a eixir
        System.exit(0)
    }

    fun quantA() {
        // Instruccions per a mostrar un diàleg amb la versió (Acerca de...)
        JOptionPane.showMessageDialog(this, "Editor 1.0")
    }
}


fun main(args: Array<String>) {
    EventQueue.invokeLater( { Exercici_2_3().isVisible = true })
}
