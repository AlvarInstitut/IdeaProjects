package com.example.editortext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val PATH = "/data/data/$packageName/files"

        obrir.setOnClickListener {
            try {
                val dir = File(PATH)
                if (!dir.exists())
                    dir.mkdir()
                val f = (File(dir, "notes.txt"))
                text.setText(f.readText())

            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

        guardar.setOnClickListener {
            try {
                val dir = File(PATH)
                if (!dir.exists())
                    dir.mkdir()
                val f = PrintWriter(FileWriter(File(dir, "notes.txt")))
                f.write(text.text.toString())
                f.close()

            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

        esborrar.setOnClickListener {
            text.setText("")
        }
    }
}