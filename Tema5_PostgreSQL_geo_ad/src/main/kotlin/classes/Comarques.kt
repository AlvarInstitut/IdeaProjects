package classes

import java.io.Serializable

class Comarques (var nomC: String,var provincia: String, var poblacions: MutableList<Poblacions>) : Serializable{
    companion object {
        private const val serialVersionUID: Long = 1
    }
}