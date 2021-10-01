package exercicis

import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream

fun main(){
    val f = ObjectInputStream(FileInputStream("Rutes.obj"))
    try {
        while(true){
            (f.readObject() as Ruta).mostrarRuta()
            println()
        }
    }
    catch (eof: EOFException){
        f.close()
    }
}