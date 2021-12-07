package exercicis

import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JComboBox
import javax.swing.JTextArea
import java.awt.BorderLayout
import java.awt.FlowLayout
import javax.swing.JPanel
import java.awt.Color
import javax.swing.JScrollPane
import java.io.FileInputStream
import com.google.firebase.FirebaseOptions
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.DocumentChange
import com.google.firebase.FirebaseApp
import com.google.firebase.cloud.FirestoreClient
import java.awt.EventQueue

class EstadisticaCF : JFrame() {

    val etCombo = JLabel("Llista de províncies:")
    val comboProv = JComboBox<String>()

    val etiqueta = JLabel("Estadístiques:")
    val area = JTextArea()

    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setBounds(100, 100, 450, 400)
        setLayout(BorderLayout())
        // contenidor per als elements

        val panell1 = JPanel(FlowLayout())
        panell1.add(etCombo)
        panell1.add(comboProv)
        getContentPane().add(panell1, BorderLayout.NORTH)

        val panell2 = JPanel(BorderLayout())
        panell2.add(etiqueta, BorderLayout.NORTH)
        area.setForeground(Color.blue)
        area.setEditable(false)
        val scroll = JScrollPane(area)
        panell2.add(scroll, BorderLayout.CENTER)
        getContentPane().add(panell2, BorderLayout.CENTER)

        setVisible(true)

        val serviceAccount = FileInputStream("xat-ad-firebase-adminsdk-my2d0-8c69944b34.json")

        val options = FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build()

        FirebaseApp.initializeApp(options)

        val db = FirestoreClient.getFirestore()

        // Instruccions per a omplir el JComboBox amb les províncies
        var conjPov = mutableSetOf<String>()
        db.collection("Estadistica").addSnapshotListener { snapshots, e ->
            if (e != null) {
                System.err.println("Listen failed: " + e)
                return@addSnapshotListener
            }

            for (dc in snapshots!!.getDocumentChanges()) {
                when (dc.getType()) {
                    DocumentChange.Type.ADDED ->
                        conjPov.add(dc.document.getString("Provincia")!!)
                }
            }
            for (p in conjPov.sorted())
                comboProv.addItem(p)
        }

        // Instruccions per agafar la informació de tots els anys de la província triada
        comboProv.addActionListener() {
            db.collection("Estadistica").whereEqualTo("Provincia",comboProv.selectedItem).orderBy("any").addSnapshotListener { snapshots, e ->
                area.text=""
                for (dc in snapshots!!.getDocumentChanges()) {
                    when (dc.getType()) {
                        DocumentChange.Type.ADDED -> {
                            val doc= dc.document
                            area.append(doc.getString("any")!! + ": " + doc.getString("Dones") + " - " + doc.getString("Homes") + "\n")
                        }
                    }
                }
                for (p in conjPov.sorted())
                    comboProv.addItem(p)
            }
        }
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        EstadisticaCF().isVisible = true
    }
}
