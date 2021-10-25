import classes.Comarca
import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream

fun main(){
    val f = ObjectInputStream(FileInputStream("GeoAD.obj"))
    try {
        while (true) {
            val c = f.readObject() as Comarca
            println(c.nomC + " --> " + c.provincia + " --> " + c.poblacions!!.size)
        }
    }
    catch(e: EOFException) {
        f.close()
    }
}