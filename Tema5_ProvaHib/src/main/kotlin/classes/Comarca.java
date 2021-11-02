package classes;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Comarca {
    private String nomC;
    private String provincia;
    private Collection<Poblacio> poblacions;

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

        if (nomC != null ? !nomC.equals(comarca.nomC) : comarca.nomC != null) return false;
        if (provincia != null ? !provincia.equals(comarca.provincia) : comarca.provincia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nomC != null ? nomC.hashCode() : 0;
        result = 31 * result + (provincia != null ? provincia.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "comarca")
    public Collection<Poblacio> getPoblacions() {
        return poblacions;
    }

    public void setPoblacions(Collection<Poblacio> poblacions) {
        this.poblacions = poblacions;
    }
}
