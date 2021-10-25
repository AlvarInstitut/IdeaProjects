package classes

import java.io.Serializable
class Institut:Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }
    var codi: String? = null
    var nom: String? = null
    var adreca: String? = null
    var numero: String? = null
    var codpostal: Int? = null
    var poblacio: Poblacio? = null
}