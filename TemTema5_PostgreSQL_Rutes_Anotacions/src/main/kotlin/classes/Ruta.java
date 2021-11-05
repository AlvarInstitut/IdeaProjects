package classes;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Ruta {
    private Integer numR;
    private String nomR;
    private Integer desnivell;
    private Integer desnivellAcumulat;
    private Collection<Punt> punts;

    @Id
    @Column(name = "num_r")
    public Integer getNumR() {
        return numR;
    }

    public void setNumR(Integer numR) {
        this.numR = numR;
    }

    @Basic
    @Column(name = "nom_r")
    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    @Basic
    @Column(name = "desnivell")
    public Integer getDesnivell() {
        return desnivell;
    }

    public void setDesnivell(Integer desnivell) {
        this.desnivell = desnivell;
    }

    @Basic
    @Column(name = "desnivell_acumulat")
    public Integer getDesnivellAcumulat() {
        return desnivellAcumulat;
    }

    public void setDesnivellAcumulat(Integer desnivellAcumulat) {
        this.desnivellAcumulat = desnivellAcumulat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ruta ruta = (Ruta) o;

        if (numR != null ? !numR.equals(ruta.numR) : ruta.numR != null) return false;
        if (nomR != null ? !nomR.equals(ruta.nomR) : ruta.nomR != null) return false;
        if (desnivell != null ? !desnivell.equals(ruta.desnivell) : ruta.desnivell != null) return false;
        if (desnivellAcumulat != null ? !desnivellAcumulat.equals(ruta.desnivellAcumulat) : ruta.desnivellAcumulat != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numR != null ? numR.hashCode() : 0;
        result = 31 * result + (nomR != null ? nomR.hashCode() : 0);
        result = 31 * result + (desnivell != null ? desnivell.hashCode() : 0);
        result = 31 * result + (desnivellAcumulat != null ? desnivellAcumulat.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ruta")
    public Collection<Punt> getPunts() {
        return punts;
    }

    public void setPunts(Collection<Punt> punts) {
        this.punts = punts;
    }
}
