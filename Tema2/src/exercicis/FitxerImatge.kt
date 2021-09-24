package exercicis

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class FitxerImatge(fEnt: File) {
    var f: File = File("")

    init {
        // Constructor
        // Control d'existència del fitxer i control de l'extensió .bmp (traure missatges d'error)
        // En cas que tot siga correcte, inicialitzar f amb fEnt
        if (fEnt.exists() && fEnt.name.endsWith(".bmp"))
            f = fEnt
        else
            println("No existeix el fitxer o no és .bmp")
    }

    fun transformaNegatiu() {
        // Transformar a negatiiu i guardar en _n.bmp
        val f2 = File(f.name.replace(".bmp","_n.bmp"))
        val fIn = FileInputStream(f)
        val fOut = FileOutputStream(f2)

        for (i in 1..54)
            fOut.write(fIn.read())

        var b = fIn.read()
        while(b != -1){
            fOut.write(255-b)
            b = fIn.read()
        }
        fOut.close()
        fIn.close()
    }

    fun transformaObscur() {
        // Transformar a una imatge més fosca i guardar en _o.bmp
        val f2 = File(f.name.replace(".bmp","_o.bmp"))
        val fIn = FileInputStream(f)
        val fOut = FileOutputStream(f2)

        for (i in 1..54)
            fOut.write(fIn.read())

        var b = fIn.read()
        while(b != -1){
            fOut.write(b/2)
            b = fIn.read()
        }
        fOut.close()
        fIn.close()
    }

    fun transformaBlancNegre() {
        // Transformar a una imatge en blanc i negre i guardar en _bn.bmp
        val f2 = File(f.name.replace(".bmp","_bn.bmp"))
        val fIn = FileInputStream(f)
        val fOut = FileOutputStream(f2)

        for (i in 1..54)
            fOut.write(fIn.read())

        var r = fIn.read()
        while(r != -1){
            val g = fIn.read()
            val b = fIn.read()
            val c = (r+g+b)/3
            fOut.write(c)
            fOut.write(c)
            fOut.write(c)
            r = fIn.read()
        }
        fOut.close()
        fIn.close()

    }
}

