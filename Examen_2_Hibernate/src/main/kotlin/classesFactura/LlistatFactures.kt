package classesFactura

import org.hibernate.cfg.Configuration
import java.util.logging.Level
import java.util.logging.LogManager
import kotlin.math.roundToInt

fun main(){
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)
    val sessio = Configuration().configure().buildSessionFactory().openSession()
    val q = sessio.createQuery ("from Factura")

    for (f in q.list()){
        f as Factura
        var t = 0.0
        for (l in f.liniaFacs)
            t += l.preu.toDouble() * l.quant
        println("Factura número " + f.numF + ". Client: " + f.client.nom + ". Total factura: " + (t*100).roundToInt()/100.0)
    }
    sessio.close()
}