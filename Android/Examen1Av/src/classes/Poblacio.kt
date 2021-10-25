package classes

import java.math.BigDecimal

import java.io.Serializable

class Poblacio:Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }

    var codM = 0
    var nom: String? = null
    var poblacio: Int? = null
    var extensio: BigDecimal? = null
    var altura: Int? = null
    var longitud: String? = null
    var latitud: String? = null
    var llengua: String? = null
    var instituts: Collection<Institut>? = null
    var comarca: Comarca? = null
}