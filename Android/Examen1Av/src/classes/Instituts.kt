package classes

import java.io.Serializable

class Instituts (var codi: String, var nom: String?, var adreca: String?, var numero: String?, var codpostal: Int?, var poblacio: Poblacions?) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }
}