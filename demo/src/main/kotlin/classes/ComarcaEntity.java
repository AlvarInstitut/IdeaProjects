package classes;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "comarca", schema = "public", catalog = "geo_ad")
public class ComarcaEntity {
    private String nomC;
    private String provincia;
    private Collection<PoblacioEntity> poblaciosByNomC;

    @Id
    @Column(name = "nom_c")
    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    @Basic
    @Column(name = "provincia")
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComarcaEntity that = (ComarcaEntity) o;

        if (nomC != null ? !nomC.equals(that.nomC) : that.nomC != null) return false;
        if (provincia != null ? !provincia.equals(that.provincia) : that.provincia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nomC != null ? nomC.hashCode() : 0;
        result = 31 * result + (provincia != null ? provincia.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "comarcaByNomC")
    public Collection<PoblacioEntity> getPoblaciosByNomC() {
        return poblaciosByNomC;
    }

    public void setPoblaciosByNomC(Collection<PoblacioEntity> poblaciosByNomC) {
        this.poblaciosByNomC = poblaciosByNomC;
    }
}
