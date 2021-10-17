package util.bd

import java.awt.EventQueue
import java.awt.GridLayout
import java.awt.FlowLayout
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JTextField
import javax.swing.JTable
import javax.swing.JScrollPane

import javax.swing.table.DefaultTableModel

class FinestraAvancat : JFrame() {
    val gRutes = GestionarRutesBD()
    var llista = arrayListOf<Ruta>()
    var numActual = 0
    var actualitzant = false
    var modificacio = ""

    val qNom = JTextField(15)
    val qDesn = JTextField(5)
    val qDesnAcum = JTextField(5)
    val punts = JTable(1, 3)
    val primer = JButton(" << ")
    val anterior = JButton(" < ")
    val seguent = JButton(" > ")
    val ultim = JButton(" >> ")
    val tancar = JButton("Tancar")

    val editar = JButton("Editar")
    val eliminar = JButton("Eliminar")
    val nova = JButton("Nova Ruta")

    val acceptar = JButton("Acceptar")
    val cancelar = JButton("Cancel·lar")
    val mesP = JButton("+p")
    val menysP = JButton("-p")

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("JDBC: Visualitzar Rutes Avançat")
        setLayout(GridLayout(0, 1))

        val p_prin = JPanel()
        p_prin.setLayout(BoxLayout(p_prin, BoxLayout.Y_AXIS))
        val panell1 = JPanel(GridLayout(0, 2))
        panell1.add(JLabel("Ruta:"))
        qNom.setEditable(false)
        panell1.add(qNom)
        panell1.add(JLabel("Desnivell:"))
        qDesn.setEditable(false)
        panell1.add(qDesn)
        panell1.add(JLabel("Desnivell acumulat:"))
        qDesnAcum.setEditable(false)
        panell1.add(qDesnAcum)
        panell1.add(JLabel("Punts:"))

        val panell2 = JPanel(GridLayout(0, 1))
        punts.setEnabled(false)
        val scroll = JScrollPane(punts)
        panell2.add(scroll, null)

        val panell5 = JPanel(FlowLayout())
        panell5.add(primer)
        panell5.add(anterior)
        panell5.add(seguent)
        panell5.add(ultim)
        panell5.add(editar)
        panell5.add(eliminar)
        panell5.add(nova)

        acceptar.setVisible(false)
        panell5.add(acceptar)
        cancelar.setVisible(false)
        panell5.add(cancelar)
        mesP.setVisible(false)
        panell5.add(mesP)
        menysP.setVisible(false)
        panell5.add(menysP)

        val panell6 = JPanel(FlowLayout())
        panell6.add(tancar)

        add(p_prin)
        p_prin.add(panell1)
        p_prin.add(panell2)
        p_prin.add(panell5)
        p_prin.add(panell6)
        ActivarAltres(true)
        pack()
        ActivarAltres(false)

        primer.addActionListener{
            // instruccions per a situar-se en la primera ruta, i visualitzar-la
            numActual = 0
            VisRuta()
        }
        anterior.addActionListener{
            // instruccions per a situar-se en la ruta anterior, i visualitzar-la
            numActual--
            VisRuta()
        }
        seguent.addActionListener{
            // instruccions per a situar-se en la ruta següent, i visualitzar-la
            numActual++
            VisRuta()
        }
        ultim.addActionListener{
            // instruccions per a situar-se en l'últim ruta, i visualitzar-la
            numActual = llista.size-1
            VisRuta()
        }
        tancar.addActionListener{
            gRutes.close()
            System.exit(0)
        }

        editar.addActionListener {
            // instruccions per a editar la ruta que s'està veient en aquest moment
            // s'han d'activar els quadres de text, i el JTable
            modificacio ="editant"
            ActivarAltres(true)
            ActivarQuadres(true)
        }

        eliminar.addActionListener {
            // instruccions per a eliminar la ruta que s'està veient en aquest moment
            modificacio ="eliminant"
            ActivarAltres(true)
            mesP.isVisible=false
            menysP.isVisible= false
        }

        nova.addActionListener {
            // instruccions per a posar en blanc els quadres de text i el JTable, per a inserir una nova ruta
            // s'han d'activar els quadres de text, i el JTable
            modificacio ="inserint"
            PosarQuadresBlanc()
            ActivarQuadres(true)
            val modelPunts = punts.model
            val caps = arrayOf("Nom punt", "Latitud", "Longitud")
            punts.setModel(javax.swing.table.DefaultTableModel(null, caps))
            ActivarAltres(true)
        }

        acceptar.addActionListener {
            // instruccions per a acceptar l'acció que s'està fent (nova ruta, edició o eliminació)
            if (punts.isEditing())
                punts.getCellEditor().stopCellEditing()

            when (modificacio) {
                "editant" -> {
                    gRutes.guardar(IniRuta())
                }
                "eliminant" -> {
                    gRutes.esborrar(IniRuta())
                }
                "inserint" -> {
                    gRutes.inserir(IniRuta())
                    numActual=llista.size
                }
            }
            modificacio=""
            ActivarQuadres(false)
            ActivarAltres(false)
            llista = gRutes.llistat()
            if (numActual==llista.size)
                numActual--
            VisRuta()
        }

        cancelar.addActionListener {
            // instruccions per a cancel·lar l'acció que s'estava fent
            modificacio=""
            ActivarQuadres(false)
            ActivarAltres(false)
            VisRuta()
        }

        mesP.addActionListener {
            // instruccions per a afegir una línia en el JTable
            // S'ha de fer sobre el DefaultTableModel
            val m = punts.model as DefaultTableModel
            if (punts.getSelectedRow() == -1)
                m.addRow(arrayOfNulls<String>(3))
            else
                m.insertRow(punts.getSelectedRow(), arrayOfNulls<String>(3))
        }

        menysP.addActionListener {
            // instruccions per a llevar una línia del JTable
            // S'ha de fer sobre el DefaultTableModel
            val m = punts.model as DefaultTableModel
            if (punts.getSelectedRow() == -1)
                m.removeRow(punts.rowCount-1)
            else
                m.removeRow(punts.getSelectedRow())

        }

        inicialitzar()
        VisRuta()
    }

    fun plenarTaula(ll_punts: MutableList<PuntGeo>) {
        var ll = Array(ll_punts.size) { arrayOfNulls<String>(3) }
        for (i in 0 until ll_punts.size) {
            ll[i][0] = ll_punts.get(i).nom
            ll[i][1] = ll_punts.get(i).coord.latitud.toString()
            ll[i][2] = ll_punts.get(i).coord.longitud.toString()
        }
        val caps = arrayOf("Nom punt", "Latitud", "Longitud")
        punts.setModel(javax.swing.table.DefaultTableModel(ll, caps))
    }

    fun inicialitzar() {
        // instruccions per a iniialitzar llista i numActual
        llista = gRutes.llistat()
        numActual = 0
    }

    fun VisRuta(){
        // instruccions per a visualitzar la ruta actual (l'índex el tenim en numActual)
        val r = llista.get(numActual)
        qNom.text = r.nom
        qDesn.text = r.desnivell.toString()
        qDesnAcum.text = r.desnivellAcumulat.toString()
        plenarTaula(r.llistaDePunts)
        ActivarBotons()
    }

    fun ActivarBotons(){
        // instruccions per a activar o desactivar els botons de moviment ( setEnabled(Boolean) )
        if (numActual==0)
            anterior.isEnabled=false
        else
            anterior.isEnabled=true

        if (numActual==llista.size-1)
            seguent.isEnabled=false
        else
            seguent.isEnabled=true
    }

    fun ActivarAltres(b: Boolean) {
        // instruccions per a mostrar els botons acceptar, cancelar, mesP, menysP,
        // ocultar editar, eliminar, nova. O al revés
        // I descativar els de moviment
        acceptar.isVisible=b
        cancelar.isVisible=b
        mesP.isVisible=b
        menysP.isVisible=b

        editar.isVisible=!b
        eliminar.isVisible=!b
        nova.isVisible=!b

        primer.isEnabled=!b
        anterior.isEnabled=!b
        seguent.isEnabled=!b
        ultim.isEnabled=!b
        if (!b)
            ActivarBotons()
    }

    fun ActivarQuadres(b: Boolean) {
        // instruccions per a fer editables els JTextFiels i el JTable
        qNom.setEditable(b)
        qDesn.setEditable(b)
        qDesnAcum.setEditable(b)
        punts.isEnabled=b
    }

    fun PosarQuadresBlanc() {
        // instruccions per a deixar els controls en blanc per a inserir una nova ruta
        qNom.text=""
        qDesn.text=""
        qDesnAcum.text=""
    }

    fun IniRuta(): Ruta {
        // instruccions per a tornar una Ruta a partir de les dades dels controls
        val llistaDePunts = arrayListOf<PuntGeo>()
        for (i in 0 until punts.rowCount){
            llistaDePunts.add(PuntGeo(punts.getValueAt(i,0).toString(), Coordenades(punts.getValueAt(i,1).toString().toDouble(),punts.getValueAt(i,2).toString().toDouble())))
        }
        return (Ruta(qNom.text,qDesn.text.toInt(),qDesnAcum.text.toInt(),llistaDePunts))
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        FinestraAvancat().isVisible = true
    }
}