package exercicis

import java.io.*

fun main(){
    val f = DataInputStream(FileInputStream("Rutes.dat"))
    val f2 = ObjectOutputStream(FileOutputStream("Rutes.obj"))
    while (f.available() > 0){
        val nom = f.readUTF()
        val desn = f.readInt()
        val desnAc = f.readInt()
        var llistaPunts = mutableListOf<PuntGeo>()
        val n = f.readInt()
        for (i in 1..n){
            llistaPunts.add(PuntGeo(f.readUTF(),Coordenades(f.readDouble(),f.readDouble())))
        }
        val ruta = Ruta(nom,desn,desnAc,llistaPunts)
        ruta.mostrarRuta()
        f2.writeObject(ruta)
        println()
    }
    f.close()

}