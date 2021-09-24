package exemples

import javax.swing.*
import java.awt.*

class Finestra : JFrame() {

    init {
        val f = GUIForm()
        setContentPane(f.PanellPrincipal)
        f.button1.background=Color.RED
        f.button2.addActionListener {
            JOptionPane.showMessageDialog(null,"Hola")
        }
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Designer GUI")
        setSize(400, 300)
    }
}

fun main(args: Array<String>) {
    Finestra().isVisible = true
}


