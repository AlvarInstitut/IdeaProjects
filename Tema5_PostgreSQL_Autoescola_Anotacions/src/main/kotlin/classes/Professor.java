package classes;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Professor {
    private String dni;
    private String nom;
    private Date dataI;
    private Collection<Alumne> alumnes;

    @Id
    @Column(name = "dni")
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "data_i")
    public Date getDataI() {
        return dataI;
    }

    public void setDataI(Date dataI) {
        this.dataI = dataI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Professor professor = (Professor) o;

        if (dni != null ? !dni.equals(professor.dni) : professor.dni != null) return false;
        if (nom != null ? !nom.equals(professor.nom) : professor.nom != null) return false;
        if (dataI != null ? !dataI.equals(professor.dataI) : professor.dataI != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dni != null ? dni.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (dataI != null ? dataI.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "professorByDniP")
    public Collection<Alumne> getAlumnes() {
        return alumnes;
    }

    public void setAlumnes(Collection<Alumne> alumnes) {
        this.alumnes = alumnes;
    }
}
