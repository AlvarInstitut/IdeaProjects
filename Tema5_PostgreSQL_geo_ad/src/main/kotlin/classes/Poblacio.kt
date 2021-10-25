package classes

import java.math.BigDecimal
import classes.Institut
import classes.Comarca
import classes.Poblacio
import javax.persistence.*
import java.io.Serializable
@Entity
class Poblacio:Serializable {
    @get:Column(name = "cod_m")
    @get:Id
    var codM = 0

    @get:Column(name = "nom")
    @get:Basic
    var nom: String? = null

    @get:Column(name = "poblacio")
    @get:Basic
    var poblacio: Int? = null

    @get:Column(name = "extensio")
    @get:Basic
    var extensio: BigDecimal? = null

    @get:Column(name = "altura")
    @get:Basic
    var altura: Int? = null

    @get:Column(name = "longitud")
    @get:Basic
    var longitud: String? = null

    @get:Column(name = "latitud")
    @get:Basic
    var latitud: String? = null

    @get:Column(name = "llengua")
    @get:Basic
    var llengua: String? = null

    @get:OneToMany(mappedBy = "poblacio")
    var instituts: Collection<Institut>? = null

    @get:JoinColumn(name = "nom_c", referencedColumnName = "nom_c")
    @get:ManyToOne
    var comarca: Comarca? = null
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val poblacio1 = o as Poblacio
        if (codM != poblacio1.codM) return false
        if (if (nom != null) nom != poblacio1.nom else poblacio1.nom != null) return false
        if (if (poblacio != null) poblacio != poblacio1.poblacio else poblacio1.poblacio != null) return false
        if (if (extensio != null) extensio != poblacio1.extensio else poblacio1.extensio != null) return false
        if (if (altura != null) altura != poblacio1.altura else poblacio1.altura != null) return false
        if (if (longitud != null) longitud != poblacio1.longitud else poblacio1.longitud != null) return false
        if (if (latitud != null) latitud != poblacio1.latitud else poblacio1.latitud != null) return false
        return if (if (llengua != null) llengua != poblacio1.llengua else poblacio1.llengua != null) false else true
    }

    override fun hashCode(): Int {
        var result = codM
        result = 31 * result + if (nom != null) nom.hashCode() else 0
        result = 31 * result + if (poblacio != null) poblacio.hashCode() else 0
        result = 31 * result + if (extensio != null) extensio.hashCode() else 0
        result = 31 * result + if (altura != null) altura.hashCode() else 0
        result = 31 * result + if (longitud != null) longitud.hashCode() else 0
        result = 31 * result + if (latitud != null) latitud.hashCode() else 0
        result = 31 * result + if (llengua != null) llengua.hashCode() else 0
        return result
    }
}