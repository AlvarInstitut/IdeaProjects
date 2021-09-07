package exercicis

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun main(args: Array<String>) {
    var fActiu = File.listRoots()[0]
    var ent = 0
    while (ent != -1) {
        llistaDirectori(fActiu)
        println("Introdueix un número (-1 per acabar):")
        ent = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
        val f = fActiu.listFiles()[ent-1]
        if (f.exists()) {
            if (f.isDirectory()) {
                llistaDirectori(f)
            } else
                println("No és un directori")
        } else
            println("No existeix el directori")
    }
}

fun llistaDirectori(f: File) {
    val s = "Llista de fitxers i directoris del directori " + f.getCanonicalPath()
    println(s)
    println("-".repeat(s.length))
    println("0.- Directori pare")
    var i=1
    for (e in f.listFiles().sorted()) {
        if (e.isFile())
            println("" + i + ".- " + e.getName() + "\t " + e.length())
        if (e.isDirectory())
            println("" + i + ".- " + e.getName() + "\t <Directori>")
        i++
    }
}