package exercicis

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*


fun main(args: Array<String>) {
    var fActiu = File.listRoots()[0]
    var ent = 0
    while (ent != -1) {
        llistaDirectori(fActiu)
        println("Introdueix un número (-1 per acabar):")
        ent = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
        if (ent == 0) {
            if (fActiu == File.listRoots()[0])
                println("Estàs a l'arrel. No pots anar al pare")
            else
                fActiu = fActiu.parentFile
        }
        else {
            if ((ent > -1) && (ent <= fActiu.listFiles().size)) {
                val f = fActiu.listFiles().sorted()[ent - 1]
                if (f.canRead()) {
                    if (f.isDirectory()) {
                        fActiu = f
                    } else
                        println("No és un directori")
                } else
                    println("No tens permís")
            }
        else
            if (ent != -1)
                println("Opció invàlida")
        }
    }
}

fun llistaDirectori(f: File) {
    val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")

    val s = "Llista de fitxers i directoris del directori " + f.getCanonicalPath()
    println(s)
    println("-".repeat(s.length))
    println("0.- Directori pare")
    var i=1
    for (e in f.listFiles().sorted()) {
        print("" + i + ".- ")
        if (e.isFile())
            print("-")
        else
            print("d")
        if (e.canRead())
            print("r")
        else
            print("-")
        if (e.canWrite())
            print("w")
        else
            print("-")
        if (e.canExecute())
            print("x")
        else
            print("-")
        System.out.printf("%11d",e.length())
        print(" " + simpleDateFormat.format(Date(e.lastModified())))

        println(" " + e.getName() )
        i++
    }
}