
import classes.Comarques
import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream

fun main(){
    val f = ObjectInputStream(FileInputStream("GeoAD.obj"))
    try {
        while (true) {
            val c = f.readObject() as Comarques
            println("Comarca: " + c.nomC+ " (" + c.provincia + ")")
            for (p in (c.poblacions))
                println("\t" + p.nom+": "  +  p.instituts.size + " instituts")
        }
    }
    catch(e: EOFException) {
        f.close()
    }
}