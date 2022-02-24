import java.io.Serializable

class Vivenda : Serializable {
    var pis = 0
    var porta: String? = null
    var noms: ArrayList<String> = ArrayList()

    companion object {
        private const val serialVersionUID = 1L
    }
}