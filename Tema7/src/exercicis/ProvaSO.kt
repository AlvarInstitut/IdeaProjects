package exercicis

import java.io.File
import javax.sound.sampled.*
import javax.swing.JDialog
import javax.swing.JFileChooser


class CoreJavaSound : Any(), LineListener {
    var soundFile: File
    var playingDialog: JDialog? = null
    var clip: Clip
    override fun update(le: LineEvent) {
        val type = le.type
        if (type === LineEvent.Type.OPEN) {
            println("OPEN")
        } else if (type === LineEvent.Type.CLOSE) {
            println("CLOSE")
            System.exit(0)
        } else if (type === LineEvent.Type.START) {
            println("START")
            playingDialog!!.isVisible = true
        } else if (type === LineEvent.Type.STOP) {
            println("STOP")
            playingDialog!!.isVisible = false
            clip.close()
        }
    }

    companion object {
        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val s = CoreJavaSound()
        }
    }

    init {
        val chooser = JFileChooser()
        chooser.showOpenDialog(null)
        soundFile = chooser.selectedFile
        System.out.println("Playing " + soundFile.getName())
        val linfo = Line.Info(Clip::class.java)
        val line = AudioSystem.getLine(linfo)
        clip = line as Clip
        clip.addLineListener(this)
        val ais: AudioInputStream = AudioSystem.getAudioInputStream(soundFile)
        clip.open(ais)
        clip.start()
    }
}