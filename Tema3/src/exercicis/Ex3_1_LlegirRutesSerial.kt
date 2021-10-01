package exercicis

import java.io.DataInputStream
import java.io.FileInputStream

fun main() {
    val f = DataInputStream(FileInputStream("Rutes.dat"))
    while (f.available() > 0){
        println("Ruta: " + f.readUTF())
        println("Desnivell: " + f.readInt())
        println("Desnivell acumulat: " + f.readInt())
        val n = f.readInt()
        println("Té " + n + " punts")
        for (i in 1..n){
            print("\tPunt " + i + ": ")
            println(f.readUTF() + " (" + f.readDouble() + "," + f.readDouble() + ")")
        }
        println()
    }
    f.close()
}