import java.io.Serializable

class Finca : Serializable {
    var adreça: String? = null
    var vivendes: ArrayList<Vivenda> = ArrayList<Vivenda>()

    fun resum() {
        // Aquest és el que heu d'implementar
        println(adreça)
        for (v in vivendes)
            println("\tVivenda " + v.pis + v.porta + ", habitants: " + v.noms.size)
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}