package classes;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Rutes {
    private Integer numR;
    private String nomR;
    private Integer desn;
    private Integer desnAc;
    private Collection<Punts> punts;

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
    @Column(name = "desn")
    public Integer getDesn() {
        return desn;
    }

    public void setDesn(Integer desn) {
        this.desn = desn;
    }

    @Basic
    @Column(name = "desn_ac")
    public Integer getDesnAc() {
        return desnAc;
    }

    public void setDesnAc(Integer desnAc) {
        this.desnAc = desnAc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rutes rutes = (Rutes) o;

        if (numR != null ? !numR.equals(rutes.numR) : rutes.numR != null) return false;
        if (nomR != null ? !nomR.equals(rutes.nomR) : rutes.nomR != null) return false;
        if (desn != null ? !desn.equals(rutes.desn) : rutes.desn != null) return false;
        if (desnAc != null ? !desnAc.equals(rutes.desnAc) : rutes.desnAc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numR != null ? numR.hashCode() : 0;
        result = 31 * result + (nomR != null ? nomR.hashCode() : 0);
        result = 31 * result + (desn != null ? desn.hashCode() : 0);
        result = 31 * result + (desnAc != null ? desnAc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "rutes")
    public Collection<Punts> getPunts() {
        return punts;
    }

    public void setPunts(Collection<Punts> punts) {
        this.punts = punts;
    }
}
