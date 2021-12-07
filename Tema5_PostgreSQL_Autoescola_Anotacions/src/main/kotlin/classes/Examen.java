package classes;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(ExamenPK.class)
public class Examen {
    private String dni;
    private Date data;
    private Float qualificacio;
    private Alumne alumne;

    @Id
    @Column(name = "dni")
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Id
    @Column(name = "data")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Basic
    @Column(name = "qualificacio")
    public Float getQualificacio() {
        return qualificacio;
    }

    public void setQualificacio(Float qualificacio) {
        this.qualificacio = qualificacio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Examen examen = (Examen) o;

        if (dni != null ? !dni.equals(examen.dni) : examen.dni != null) return false;
        if (data != null ? !data.equals(examen.data) : examen.data != null) return false;
        if (qualificacio != null ? !qualificacio.equals(examen.qualificacio) : examen.qualificacio != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dni != null ? dni.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (qualificacio != null ? qualificacio.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni", nullable = false, insertable = false, updatable = false)
    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        this.alumne = alumne;
    }
}
