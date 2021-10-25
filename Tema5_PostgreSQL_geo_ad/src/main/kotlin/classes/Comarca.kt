package classes
import java.io.Serializable
import classes.Poblacio
import classes.Comarca
import javax.persistence.*

@Entity
class Comarca: Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }

    @get:Column(name = "nom_c")
    @get:Id
    var nomC: String? = null

    @get:Column(name = "provincia")
    @get:Basic
    var provincia: String? = null

    @get:OneToMany(mappedBy = "comarca")
    var poblacions: Collection<Poblacio>? = null
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val comarca = o as Comarca
        if (if (nomC != null) nomC != comarca.nomC else comarca.nomC != null) return false
        return if (if (provincia != null) provincia != comarca.provincia else comarca.provincia != null) false else true
    }

    override fun hashCode(): Int {
        var result = if (nomC != null) nomC.hashCode() else 0
        result = 31 * result + if (provincia != null) provincia.hashCode() else 0
        return result
    }
}