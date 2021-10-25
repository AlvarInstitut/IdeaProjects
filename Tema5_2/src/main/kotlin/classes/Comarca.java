package classes;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Comarca {
    private String nomC;
    private String provincia;
    private Collection<Poblacio> poblaciosByNomC;

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
        Comarca comarca = (Comarca) o;
        return Objects.equals(nomC, comarca.nomC) && Objects.equals(provincia, comarca.provincia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomC, provincia);
    }

    @OneToMany(mappedBy = "comarcaByNomC")
    public Collection<Poblacio> getPoblaciosByNomC() {
        return poblaciosByNomC;
    }

    public void setPoblaciosByNomC(Collection<Poblacio> poblaciosByNomC) {
        this.poblaciosByNomC = poblaciosByNomC;
    }
}
