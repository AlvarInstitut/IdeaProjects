package classes;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Vehicle {
    private String matricula;
    private String model;
    private Date dataC;
    private Integer km;
    private Collection<Practiques> practiquesByMatricula;

    @Id
    @Column(name = "matricula")
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "data_c")
    public Date getDataC() {
        return dataC;
    }

    public void setDataC(Date dataC) {
        this.dataC = dataC;
    }

    @Basic
    @Column(name = "km")
    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (matricula != null ? !matricula.equals(vehicle.matricula) : vehicle.matricula != null) return false;
        if (model != null ? !model.equals(vehicle.model) : vehicle.model != null) return false;
        if (dataC != null ? !dataC.equals(vehicle.dataC) : vehicle.dataC != null) return false;
        if (km != null ? !km.equals(vehicle.km) : vehicle.km != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = matricula != null ? matricula.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (dataC != null ? dataC.hashCode() : 0);
        result = 31 * result + (km != null ? km.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "vehicle")
    public Collection<Practiques> getPractiquesByMatricula() {
        return practiquesByMatricula;
    }

    public void setPractiquesByMatricula(Collection<Practiques> practiquesByMatricula) {
        this.practiquesByMatricula = practiquesByMatricula;
    }
}
