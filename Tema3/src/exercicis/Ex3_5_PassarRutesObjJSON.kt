package exercicis

import com.squareup.moshi.Moshi
import java.io.EOFException
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream

fun main(){
    val rutes = mutableListOf<Ruta>()
    val f = ObjectInputStream(FileInputStream("Rutes.obj"))
    try {
        while(true){
            rutes.add(f.readObject() as Ruta)
        }
    }
    catch (eof:EOFException) {
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Rutes::class.java)
        val json = adapter.toJson(Rutes(rutes))

        File("Rutes.json").writeText(json)
    }
}