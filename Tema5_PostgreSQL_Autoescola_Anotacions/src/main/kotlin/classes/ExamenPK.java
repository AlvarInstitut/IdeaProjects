package classes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class ExamenPK implements Serializable {
    private String dni;
    private Date data;

    @Column(name = "dni")
    @Id
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Column(name = "data")
    @Id
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamenPK examenPK = (ExamenPK) o;

        if (dni != null ? !dni.equals(examenPK.dni) : examenPK.dni != null) return false;
        if (data != null ? !data.equals(examenPK.data) : examenPK.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dni != null ? dni.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
