package classes;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(PractiquesPK.class)
public class Practiques {
    private String dni;
    private Date data;
    private Short km;
    private Float val;
    private Alumne alumne;
    private Vehicle vehicle;

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
    @Column(name = "km")
    public Short getKm() {
        return km;
    }

    public void setKm(Short km) {
        this.km = km;
    }

    @Basic
    @Column(name = "val")
    public Float getVal() {
        return val;
    }

    public void setVal(Float val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Practiques that = (Practiques) o;

        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (km != null ? !km.equals(that.km) : that.km != null) return false;
        if (val != null ? !val.equals(that.val) : that.val != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dni != null ? dni.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (km != null ? km.hashCode() : 0);
        result = 31 * result + (val != null ? val.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "cotxe", referencedColumnName = "matricula")
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
