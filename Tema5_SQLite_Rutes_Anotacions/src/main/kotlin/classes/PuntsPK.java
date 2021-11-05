package classes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PuntsPK implements Serializable {
    private Integer numR;
    private Integer numP;

    @Column(name = "num_r")
    @Id
    public Integer getNumR() {
        return numR;
    }

    public void setNumR(Integer numR) {
        this.numR = numR;
    }

    @Column(name = "num_p")
    @Id
    public Integer getNumP() {
        return numP;
    }

    public void setNumP(Integer numP) {
        this.numP = numP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PuntsPK puntsPK = (PuntsPK) o;

        if (numR != null ? !numR.equals(puntsPK.numR) : puntsPK.numR != null) return false;
        if (numP != null ? !numP.equals(puntsPK.numP) : puntsPK.numP != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numR != null ? numR.hashCode() : 0;
        result = 31 * result + (numP != null ? numP.hashCode() : 0);
        return result;
    }
}
