package exercicis

import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField
import javax.swing.JTextArea
import javax.swing.DefaultListModel
import javax.swing.JList
import javax.swing.JScrollPane
import java.awt.FlowLayout
import java.awt.Color
import redis.clients.jedis.Jedis

import java.awt.EventQueue

class EstadisticaRD : JFrame() {

    val etTipClau= JLabel("Tipus:")
    val tipClau= JTextField(8)
    val contClau = JTextArea(8,15)
    val con = Jedis("89.36.214.106")
    val listModel = DefaultListModel<String>()
    val llClaus = JList(listModel)

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setBounds(100, 100, 450, 450)
        setLayout(FlowLayout())

        con.connect()
        con.auth("ieselcaminas.ad")

        llClaus.setForeground(Color.blue)
        val scroll = JScrollPane(llClaus)
        llClaus.setVisibleRowCount(20)

        val scroll2 = JScrollPane(contClau)

        add(scroll)
        add(etTipClau)
        add(tipClau)
        add(scroll2)

        setSize(600, 400)
        setVisible(true)

        inicialitzar()

        llClaus.addListSelectionListener{valorCanviat()}

    }
    fun inicialitzar(){
        for (c in con.keys("*").sorted())
            listModel.addElement(c)
    }

    fun valorCanviat() {
        contClau.text = ""
        val c = llClaus.selectedValue
        val tC = con.type(c)
        tipClau.text = tC
        when (tC){
            "string" -> contClau.text = con.get(c)
            "hash" -> for (s in con.hkeys(c))
                        contClau.append(s + " -> " + con.hget(c,s) + "\n")
            "list" -> for (s in con.lrange(c,0,-1))
                        contClau.append(s + "\n")
            "set" -> for (s in con.smembers(c))
                        contClau.append(s + "\n")
            "zset" -> for (s in con.zrangeWithScores(c,0,-1))
                         contClau.append(s.element + " -> " + s.score + "\n")

        }
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        EstadisticaRD().isVisible = true
    }
}

