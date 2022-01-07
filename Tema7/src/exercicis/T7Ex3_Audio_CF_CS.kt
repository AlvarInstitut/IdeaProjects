package exercicis

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import com.google.firebase.cloud.StorageClient
import java.awt.BorderLayout
import java.awt.EventQueue
import java.awt.FlowLayout
import java.io.File
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.file.Paths
import javax.sound.sampled.AudioSystem
import javax.swing.*


class SonsCS_CF : JFrame() {

    val etAudios = JLabel("Llista de Audios:")
    val comboAudios = JComboBox<String>()

    val play = JButton("Play")
    val stop = JButton("Stop")

    // declare ací el clip per poder accedir a ell en els botons de Play i Stop
    val clip = AudioSystem.getClip()

    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        setBounds(100, 100, 500, 150)
        setLayout(BorderLayout())
        // contenidor per als elements
        //Hi haurà títol. Panell de dalt: últim missatge. Panell de baix: per a introduir missatge. Panell central: tot el xat

        val panell1 = JPanel(FlowLayout())
        panell1.add(etAudios)
        panell1.add(comboAudios)
        getContentPane().add(panell1, BorderLayout.NORTH)

        val panell2 = JPanel(FlowLayout())
        panell2.add(play)
        panell2.add(stop)
        getContentPane().add(panell2, BorderLayout.SOUTH)
        setVisible(true)

        val serviceAccount = FileInputStream("xat-ad-firebase-adminsdk-my2d0-8c69944b34.json")

        val options = FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build()

        FirebaseApp.initializeApp(options)

        val db = FirestoreClient.getFirestore()

        // Instruccions per a omplir el JComboBox amb els audios
        val documents = db.collection("Audios").get().get().getDocuments()
        val llistaAudios = ArrayList<String>()
        val llistaFitxers = ArrayList<String>()
        if (documents != null) {
            for (document in documents) {
                llistaAudios.add(document.getString("nom")!!)
                llistaFitxers.add(document.getString("fitxer")!!)
            }
        }
        for (p in llistaAudios)
            comboAudios.addItem(p)

        val bucket = StorageClient.getInstance().bucket("xat-ad.appspot.com")
        // Instruccions per fer sonar l'audio triat
        comboAudios.addActionListener() {
            println(llistaFitxers[comboAudios.getSelectedIndex()])
            val blob = bucket?.get(llistaFitxers[comboAudios.getSelectedIndex()])

            //  Amb fitxer temporal
//            val destFilePath = Paths.get("auxiliar.jpg")
//            blob?.downloadTo(destFilePath)
//            val audioInputStream = AudioSystem.getAudioInputStream(destFilePath.toFile())

            //  Amb buffer de bytes
            val au = ByteBuffer.allocate(1024 * 1024)
            blob?.reader()?.read(au)
            val audioInputStream = AudioSystem.getAudioInputStream(au.array().inputStream())

            clip.close()   // ha d'estar tancat abans de tornar a obrir-lo
            clip.open(audioInputStream)

        }

        play.addActionListener() {
            clip?.start()
        }

        stop.addActionListener() {
            clip?.stop()
        }

    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        SonsCS_CF().isVisible = true
    }
}