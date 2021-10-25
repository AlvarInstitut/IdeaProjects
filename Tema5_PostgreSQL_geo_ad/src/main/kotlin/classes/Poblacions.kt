package classes

import java.io.Serializable
import java.math.BigDecimal

class Poblacions(var codM: Int, var nom: String?, var numHabs: Int?, var extensio: BigDecimal?, var altura: Int?, var longitud: String?, var latitud: String?,
                 var llengua: String?, var instituts: MutableList<Instituts>, var comarca: Comarques?) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }
}
