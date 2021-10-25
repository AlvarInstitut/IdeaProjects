package classes

import java.io.Serializable


class Comarca: Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }

    var nomC: String? = null
    var provincia: String? = null

}