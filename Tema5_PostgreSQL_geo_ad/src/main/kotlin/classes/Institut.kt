package classes

import classes.Poblacio
import classes.Institut
import javax.persistence.*
import java.io.Serializable
@Entity
class Institut:Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }

    @get:Column(name = "codi")
    @get:Id
    var codi: String? = null

    @get:Column(name = "nom")
    @get:Basic
    var nom: String? = null

    @get:Column(name = "adreca")
    @get:Basic
    var adreca: String? = null

    @get:Column(name = "numero")
    @get:Basic
    var numero: String? = null

    @get:Column(name = "codpostal")
    @get:Basic
    var codpostal: Int? = null

    @get:JoinColumn(name = "cod_m", referencedColumnName = "cod_m")
    @get:ManyToOne
    var poblacio: Poblacio? = null
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val institut = o as Institut
        if (if (codi != null) codi != institut.codi else institut.codi != null) return false
        if (if (nom != null) nom != institut.nom else institut.nom != null) return false
        if (if (adreca != null) adreca != institut.adreca else institut.adreca != null) return false
        if (if (numero != null) numero != institut.numero else institut.numero != null) return false
        return if (if (codpostal != null) codpostal != institut.codpostal else institut.codpostal != null) false else true
    }

    override fun hashCode(): Int {
        var result = if (codi != null) codi.hashCode() else 0
        result = 31 * result + if (nom != null) nom.hashCode() else 0
        result = 31 * result + if (adreca != null) adreca.hashCode() else 0
        result = 31 * result + if (numero != null) numero.hashCode() else 0
        result = 31 * result + if (codpostal != null) codpostal.hashCode() else 0
        return result
    }
}