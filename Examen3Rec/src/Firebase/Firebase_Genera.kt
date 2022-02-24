package Firebase

import java.awt.EventQueue
import javax.swing.JFrame
import javax.swing.JButton
import java.awt.FlowLayout
import java.io.FileInputStream

import com.google.firebase.FirebaseOptions
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*

class Firebase_Genera : JFrame() {

    val enviar = JButton("Generar")

    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setBounds(100, 100, 250, 100)
        setLayout(FlowLayout())

        getContentPane().add(enviar)

        setVisible(true)
        enviar.addActionListener{enviar()}

        val serviceAccount = FileInputStream("exadfirebase-firebase-adminsdk-wgvi4-9fb6b2831d.json")

        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://acces-a-dades-6e5a6.firebaseio.com").build()

        FirebaseApp.initializeApp(options)

    }

    fun genera(): Int{
        return (0..100000).random()
    }

    fun enviar(){
        val num = genera()
        println(num)
        // Instruccions per a guardar num (el número aleatori generat) en Firebase
    }

}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        Firebase_Genera().isVisible = true
    }
}