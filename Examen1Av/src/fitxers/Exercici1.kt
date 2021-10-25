package fitxers

import java.io.*

fun main(){
    val f1 = BufferedReader(FileReader("Alumnes.txt"))
    val f2 = DataInputStream(FileInputStream("Alumnes.dat"))
    val f3 = File("Resum.txt")
    var dni = f1.readLine()
    while(dni != null){
        val nom = f2.readUTF()
        val n1 = f2.readFloat()
        val n2 = f2.readFloat()
        val n3 = f2.readFloat()
        var s = "DNI: " + dni + " Nom: " + nom + "\n"
        s += "Notes: " + n1 + "  " + n2 + "  " + n3 + "\n"
        s += "Nota mitjana: " + (n1+n2+n3)/3 + "\n"
        s += "-----------------------------------\n"
        print(s)
        f3.appendText(s)
        dni = f1.readLine()
    }
    f2.close()
    f1.close()
}