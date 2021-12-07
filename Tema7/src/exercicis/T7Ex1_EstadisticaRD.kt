package exercicis

import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JComboBox
import javax.swing.JTextArea
import java.awt.BorderLayout
import javax.swing.JPanel
import java.awt.FlowLayout
import java.awt.Color
import javax.swing.JScrollPane
import java.io.FileInputStream
import com.google.firebase.FirebaseOptions
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ChildEventListener
import java.awt.EventQueue


class EstadisticaRD : JFrame() {

    val etProv = JLabel("Provincia: ")
    val provincia = JComboBox<String>()

    val etiqueta = JLabel("Missatges:")
    val area = JTextArea()


    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setBounds(100, 100, 450, 450)
        setLayout(BorderLayout())
        // contenidor per als elements
        //Hi haurà títol. Panell de dalt: últim missatge. Panell de baix: per a introduir missatge. Panell central: tot el xat

        val panell1 = JPanel(FlowLayout())
        panell1.add(etProv)
        panell1.add(provincia)
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
            .setDatabaseUrl("https://xat-ad.firebaseio.com").build()

        FirebaseApp.initializeApp(options)

        // Posar tota la llista de províncies al JComboBox anomenat provincia
        val db = FirebaseDatabase.getInstance()
        val refV = db.getReference("EstadisticaVariacioPoblacional")

        refV.addChildEventListener(object: ChildEventListener{
            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
               provincia.addItem(p0!!.child("nombre").getValue().toString())
            }

            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(p0: DataSnapshot?) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(p0: DatabaseError?) {
                TODO("Not yet implemented")
            }

        })



        provincia.addActionListener() {
            // Posar la informació de tots els anys en el JTextArea anomenat area
            val refProv = db.getReference("EstadisticaVariacioPoblacional/" + provincia.selectedIndex + "/data")
            area.text=""
            refProv.addChildEventListener(object: ChildEventListener{
                override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
                    area.append(p0!!.child("nombrePeriodo").getValue().toString() + ": " + p0!!.child("valor").getValue().toString() + "\n")
                }

                override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                    TODO("Not yet implemented")
                }

                override fun onChildRemoved(p0: DataSnapshot?) {
                    TODO("Not yet implemented")
                }

                override fun onChildMoved(p0: DataSnapshot?, p1: String?) {
                    TODO("Not yet implemented")
                }

                override fun onCancelled(p0: DatabaseError?) {
                    TODO("Not yet implemented")
                }

            })

        }
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        EstadisticaRD().isVisible = true
    }
}