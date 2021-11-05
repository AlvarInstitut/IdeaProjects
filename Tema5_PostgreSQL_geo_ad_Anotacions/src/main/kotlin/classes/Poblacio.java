package classes;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
public class Poblacio {
    private int codM;
    private String nom;
    private Integer poblacio;
    private BigDecimal extensio;
    private Integer altura;
    private String longitud;
    private String latitud;
    private String llengua;
    private Collection<Institut> instituts;
    private Comarca comarca;

    @Id
    @Column(name = "cod_m")
    public int getCodM() {
        return codM;
    }

    public void setCodM(int codM) {
        this.codM = codM;
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
    @Column(name = "poblacio")
    public Integer getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(Integer poblacio) {
        this.poblacio = poblacio;
    }

    @Basic
    @Column(name = "extensio")
    public BigDecimal getExtensio() {
        return extensio;
    }

    public void setExtensio(BigDecimal extensio) {
        this.extensio = extensio;
    }

    @Basic
    @Column(name = "altura")
    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    @Basic
    @Column(name = "longitud")
    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Basic
    @Column(name = "latitud")
    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    @Basic
    @Column(name = "llengua")
    public String getLlengua() {
        return llengua;
    }

    public void setLlengua(String llengua) {
        this.llengua = llengua;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Poblacio poblacio1 = (Poblacio) o;

        if (codM != poblacio1.codM) return false;
        if (nom != null ? !nom.equals(poblacio1.nom) : poblacio1.nom != null) return false;
        if (poblacio != null ? !poblacio.equals(poblacio1.poblacio) : poblacio1.poblacio != null) return false;
        if (extensio != null ? !extensio.equals(poblacio1.extensio) : poblacio1.extensio != null) return false;
        if (altura != null ? !altura.equals(poblacio1.altura) : poblacio1.altura != null) return false;
        if (longitud != null ? !longitud.equals(poblacio1.longitud) : poblacio1.longitud != null) return false;
        if (latitud != null ? !latitud.equals(poblacio1.latitud) : poblacio1.latitud != null) return false;
        if (llengua != null ? !llengua.equals(poblacio1.llengua) : poblacio1.llengua != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codM;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (poblacio != null ? poblacio.hashCode() : 0);
        result = 31 * result + (extensio != null ? extensio.hashCode() : 0);
        result = 31 * result + (altura != null ? altura.hashCode() : 0);
        result = 31 * result + (longitud != null ? longitud.hashCode() : 0);
        result = 31 * result + (latitud != null ? latitud.hashCode() : 0);
        result = 31 * result + (llengua != null ? llengua.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "poblacio")
    public Collection<Institut> getInstituts() {
        return instituts;
    }

    public void setInstituts(Collection<Institut> instituts) {
        this.instituts = instituts;
    }

    @ManyToOne
    @JoinColumn(name = "nom_c", referencedColumnName = "nom_c")
    public Comarca getComarca() {
        return comarca;
    }

    public void setComarca(Comarca comarca) {
        this.comarca = comarca;
    }
}
