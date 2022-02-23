package exercicis

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.DocumentChange
import com.google.cloud.storage.Bucket
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import com.google.firebase.cloud.StorageClient
//import uk.co.caprica.vlcj.player.*
import java.awt.BorderLayout
import java.awt.EventQueue
import java.awt.FlowLayout
import java.awt.GridLayout
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.nio.ByteBuffer
import java.nio.channels.Channels
import java.nio.file.Paths
import javax.sound.sampled.AudioSystem
import javax.swing.*


class AudiosCF_CS : JFrame() {

    val etCombo = JLabel("Llista de Audios:")
    val combo = JComboBox<String>()

    val play = JButton("Play")
    val stop = JButton("Stop")

    lateinit var bucket: Bucket
    var clip = AudioSystem.getClip()

    //lateinit var clip: AdvancedPlayer
    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setBounds(100, 100, 450, 300)
        setLayout(GridLayout(2,1))
        // contenidor per als elements

        val panell1 = JPanel(FlowLayout())
        panell1.add(etCombo)
        panell1.add(combo)
        getContentPane().add(panell1)

        val panell2 = JPanel(BorderLayout())
        val panell3 = JPanel(FlowLayout())
        panell2.add(panell3, BorderLayout.CENTER)
        panell3.add(play)
        panell3.add(stop)
        getContentPane().add(panell2)

        setVisible(true)

        val serviceAccount = FileInputStream("xat-ad-firebase-adminsdk-my2d0-8c69944b34.json")

        val options = FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setStorageBucket("xat-ad.appspot.com")
            .build()

        FirebaseApp.initializeApp(options)

        val db = FirestoreClient.getFirestore()

        // Instruccions per a omplir el JComboBox amb les províncies
        db.collection("Audios").addSnapshotListener { snapshots, e ->
            for (dc in snapshots!!.getDocumentChanges()) {
                when (dc.getType()) {
                    DocumentChange.Type.ADDED ->
                        combo.addItem(dc.document.getString("fitxer")!!)
                }
            }
            combo.addActionListener { agafar() }
        }
        db.collection("Audios")
        play.addActionListener {
            println("reproduint")
            clip.start()
            println("Ha funcionat?")
            //clip.loop()
        }
        stop.addActionListener { clip.stop() }
    }

    fun agafar() {
        // Instruccions per agafar la imatge
        bucket = StorageClient.getInstance().bucket()
        val blob = bucket?.get(combo.getSelectedItem().toString())
        val audio = ByteBuffer.allocate(1024 * 1024)
        blob?.reader()?.read(audio)
        val destFilePath = Paths.get("auxiliar.jpg")
        blob?.downloadTo(destFilePath)
        println(blob)

        //clip = Applet.newAudioClip(destFilePath.toUri().toURL())
        val reader = blob.reader()

        val inputStream: InputStream = Channels.newInputStream(reader)
        //var clip = AudioSystem.getClip()
        clip.open(AudioSystem.getAudioInputStream(inputStream))
        clip.start()

        //clip = MediaPlayer(inputStream)
//        val ais: AudioInputStream = AudioSystem.getAudioInputStream(url)

    }

}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        AudiosCF().isVisible = true
    }
}