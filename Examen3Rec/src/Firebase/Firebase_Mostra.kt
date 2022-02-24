package Firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import java.awt.EventQueue
import java.awt.FlowLayout
import java.awt.Font
import java.io.FileInputStream
import javax.swing.JFrame
import javax.swing.JLabel


class Firebase_Mostra : JFrame() {

    val numPremiat = JLabel("25000")

    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setBounds(100, 100, 250, 100)
        setLayout(FlowLayout())

        numPremiat.font = Font("Arial", Font.BOLD, 22)
        getContentPane().add(numPremiat)

        setVisible(true)

        val serviceAccount = FileInputStream("exadfirebase-firebase-adminsdk-wgvi4-9fb6b2831d.json")

        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://acces-a-dades-6e5a6.firebaseio.com").build()

        FirebaseApp.initializeApp(options)

        //Instruccions per a muntar un listener permanent que puga llegir el número de Firebase i el pose en JLabel numPremiat


    }

}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        Firebase_Mostra().isVisible = true
    }
}