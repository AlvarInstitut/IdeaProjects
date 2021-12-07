package classes;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Alumne {
    private String dni;
    private String nom;
    private Date dataN;
    private String diaC;
    private Double horaC;
    private String aprovat;
    private String baixa;
    private Professor professorByDniP;
    private Collection<Examen> examens;
    private Collection<Practiques> practiques;

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
    @Column(name = "data_n")
    public Date getDataN() {
        return dataN;
    }

    public void setDataN(Date dataN) {
        this.dataN = dataN;
    }

    @Basic
    @Column(name = "dia_c")
    public String getDiaC() {
        return diaC;
    }

    public void setDiaC(String diaC) {
        this.diaC = diaC;
    }

    @Basic
    @Column(name = "hora_c")
    public Double getHoraC() {
        return horaC;
    }

    public void setHoraC(Double horaC) {
        this.horaC = horaC;
    }

    @Basic
    @Column(name = "aprovat")
    public String getAprovat() {
        return aprovat;
    }

    public void setAprovat(String aprovat) {
        this.aprovat = aprovat;
    }

    @Basic
    @Column(name = "baixa")
    public String getBaixa() {
        return baixa;
    }

    public void setBaixa(String baixa) {
        this.baixa = baixa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumne alumne = (Alumne) o;

        if (dni != null ? !dni.equals(alumne.dni) : alumne.dni != null) return false;
        if (nom != null ? !nom.equals(alumne.nom) : alumne.nom != null) return false;
        if (dataN != null ? !dataN.equals(alumne.dataN) : alumne.dataN != null) return false;
        if (diaC != null ? !diaC.equals(alumne.diaC) : alumne.diaC != null) return false;
        if (horaC != null ? !horaC.equals(alumne.horaC) : alumne.horaC != null) return false;
        if (aprovat != null ? !aprovat.equals(alumne.aprovat) : alumne.aprovat != null) return false;
        if (baixa != null ? !baixa.equals(alumne.baixa) : alumne.baixa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dni != null ? dni.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (dataN != null ? dataN.hashCode() : 0);
        result = 31 * result + (diaC != null ? diaC.hashCode() : 0);
        result = 31 * result + (horaC != null ? horaC.hashCode() : 0);
        result = 31 * result + (aprovat != null ? aprovat.hashCode() : 0);
        result = 31 * result + (baixa != null ? baixa.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "dni_p", referencedColumnName = "dni")
    public Professor getProfessorByDniP() {
        return professorByDniP;
    }

    public void setProfessorByDniP(Professor professorByDniP) {
        this.professorByDniP = professorByDniP;
    }

    @OneToMany(mappedBy = "alumne")
    public Collection<Examen> getExamens() {
        return examens;
    }

    public void setExamens(Collection<Examen> examens) {
        this.examens = examens;
    }

    @OneToMany(mappedBy = "alumne")
    public Collection<Practiques> getPractiques() {
        return practiques;
    }

    public void setPractiques(Collection<Practiques> practiques) {
        this.practiques = practiques;
    }
}
