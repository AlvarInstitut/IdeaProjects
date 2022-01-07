package exercicis

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.DocumentChange
import com.google.cloud.storage.Bucket
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import com.google.firebase.database.*
import exemples_realtimedatabase.Missatge
import java.awt.*
import java.io.FileInputStream
import javax.swing.*

class Tirada(var nom: String, var tirada: String, var colocades: Int, var desordenades: Int)

class T7Ex1_Mastermind : JFrame() {

    val etJugador = JLabel("Nom Jugador: ")
    val jugador = JTextField(15)

    val etiqueta = JLabel("Tirades:")
    val area = JTextArea()

    val etIntroduccioTirada = JLabel("Introdueix tirada:")
    val enviar = JButton("Enviar")
    val tirada = JTextField(15)

    val botoPartidaNova = JButton("PARTIDA NOVA")

    var numSecret = ""

    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setBounds(100, 100, 450, 300)
        setLayout(BorderLayout())

        // contenidor per als elements
        //Hi haurà títol. Panell de dalt: últim missatge. Panell de baix: per a introduir missatge. Panell central: tot el xat

        val panell1 = JPanel(FlowLayout())
        panell1.add(etJugador)
        panell1.add(jugador)
        getContentPane().add(panell1, BorderLayout.NORTH)

        val panell2 = JPanel(BorderLayout())
        panell2.add(etiqueta, BorderLayout.NORTH)
        area.setForeground(Color.BLUE)
        area.isEditable=false
        val scroll = JScrollPane(area)
        panell2.add(scroll, BorderLayout.CENTER)
        getContentPane().add(panell2, BorderLayout.CENTER)

        val panell3 = JPanel(FlowLayout())
        panell3.add(etIntroduccioTirada)
        panell3.add(tirada)
        panell3.add(enviar)
        getContentPane().add(panell3, BorderLayout.SOUTH)
        botoPartidaNova.isVisible=false
        panell3.add(botoPartidaNova)

        setVisible(true)
        enviar.addActionListener { enviar() }

        botoPartidaNova.addActionListener { partidaNova() }

        val serviceAccount = FileInputStream("xat-ad-firebase-adminsdk-my2d0-8c69944b34.json")

        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://xat-ad.firebaseio.com/").build()

        FirebaseApp.initializeApp(options)

        title="MASTERMIND"

        // Exemple de listener de lectura única addListenerForSingleValue()
        // Per a AGAFAR SI ESTÀ LA PARTIDA EN MARXA I EL NÚMERO SECRET
        val mastermind = FirebaseDatabase.getInstance().getReference("Mastermind")

        mastermind.addListenerForSingleValueEvent(object : ValueEventListener {
            override
            fun onDataChange(dataSnapshot: DataSnapshot) {
                println("Entrem")
                if (dataSnapshot.child("finalitzada").getValue(Boolean::class.java)){
                    //partidaNova()
                    println("Patida nova")
                }
                else {
                    numSecret = dataSnapshot.child("numSecret").getValue(String::class.java)
                }
            }

            override
            fun onCancelled(error: DatabaseError) {
            }
        })

        // Exemple de listener de lectura contínua addValueEventListener()
        // Per a posar l'últim missatge registrat. Sobre a1
        val finalitzada = FirebaseDatabase.getInstance().getReference("Mastermind/finalitzada")

        finalitzada.addValueEventListener(object : ValueEventListener {
            override
            fun onDataChange(dataSnapshot: DataSnapshot) {
                //ultimMissatge.setText(dataSnapshot.getValue().toString())
                val b = dataSnapshot.getValue(Boolean::class.java)
                etIntroduccioTirada.isVisible= ! b
                tirada.isVisible=! b
                enviar.isVisible=! b
                botoPartidaNova.isVisible=b
            }

            override
            fun onCancelled(error: DatabaseError) {
            }
        })

        // Exemple de listener d'una llista addChildEventListener()
        // Per a posar tota la llista de tirades
        val tirades = FirebaseDatabase.getInstance().getReference("Mastermind/tirades")

        tirades.addChildEventListener(object : ChildEventListener {
            override
            fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
                area.append(
                    dataSnapshot.child("nom").getValue().toString() + ": "
                            + dataSnapshot.child("tirada").getValue().toString() + " "
                            + dataSnapshot.child("colocades").getValue().toString() + " "
                            + dataSnapshot.child("desordenades").getValue().toString() + "\n")

            }

            override
            fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {
            }

            override
            fun onChildRemoved(dataSnapshot: DataSnapshot) {
            }

            override
            fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {
            }

            override
            fun onCancelled(databaseError: DatabaseError) {
            }
        }
        )
    }

    fun partidaNova(){
        val mastermind = FirebaseDatabase.getInstance().getReference("Mastermind")

        mastermind.addListenerForSingleValueEvent(object : ValueEventListener {
            override
            fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.child("finalitzada").getValue(Boolean::class.java)){
                    println("Patida nova")
                    FirebaseDatabase.getInstance().getReference("Mastermind/tirades").setValue(null,null)
                    numSecret=genera()
                    FirebaseDatabase.getInstance().getReference("Mastermind/numSecret").setValue(numSecret,null)
                    FirebaseDatabase.getInstance().getReference("Mastermind/finalitzada").setValue(false,null)
                    area.text=""
                }
                else {
                    numSecret = dataSnapshot.child("numSecret").getValue(String::class.java)
                }
            }

            override
            fun onCancelled(error: DatabaseError) {
            }
        })

    }

    fun genera(): String {
        val i0 = (Math.random() * 10).toInt()
        var i1 = (Math.random() * 10).toInt()
        while (i1 == i0)
            i1 = (Math.random() * 10).toInt()
        var i2 = (Math.random() * 10).toInt()
        while (i2 == i0 || i2 == i1)
            i2 = (Math.random() * 10).toInt()
        var i3 = (Math.random() * 10).toInt()
        while (i3 == i0 || i3 == i1 || i3 == i2)
            i3 = (Math.random() * 10).toInt()
        return (i0.toString() + i1.toString() + i2.toString() + i3.toString())
    }

    fun comprova(num: String, sec: String): IntArray {
        var pos = 0
        var nopos = 0
        for (i in 0..3)
            for (j in 0..3)
                if (num[i] == sec[j])
                    if (i == j) pos++
                    else nopos++
        return intArrayOf(pos, nopos)
    }

    fun enviar(){
        val ordDesord = comprova(tirada.text,numSecret)
        val p = FirebaseDatabase.getInstance().getReference("Mastermind")
        val t = Tirada(jugador.text, tirada.text,ordDesord.get(0), ordDesord.get(1))
        p.child("tirades").push().setValue(t, null)
        if (ordDesord.get(0)==4)
            p.child("finalitzada").setValue(true,null)
        tirada.text=""
    }
}



fun main(args: Array<String>) {
    EventQueue.invokeLater {
        T7Ex1_Mastermind().isVisible = true
    }
}