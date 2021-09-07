package classes;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "poblacio", schema = "public", catalog = "geo_ad")
public class PoblacioEntity {
    private int codM;
    private String nom;
    private Integer poblacio;
    private BigDecimal extensio;
    private Integer altura;
    private String longitud;
    private String latitud;
    private String llengua;
    private Collection<InstitutEntity> institutsByCodM;
    private ComarcaEntity comarcaByNomC;

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

        PoblacioEntity that = (PoblacioEntity) o;

        if (codM != that.codM) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (poblacio != null ? !poblacio.equals(that.poblacio) : that.poblacio != null) return false;
        if (extensio != null ? !extensio.equals(that.extensio) : that.extensio != null) return false;
        if (altura != null ? !altura.equals(that.altura) : that.altura != null) return false;
        if (longitud != null ? !longitud.equals(that.longitud) : that.longitud != null) return false;
        if (latitud != null ? !latitud.equals(that.latitud) : that.latitud != null) return false;
        if (llengua != null ? !llengua.equals(that.llengua) : that.llengua != null) return false;

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

    @OneToMany(mappedBy = "poblacioByCodM")
    public Collection<InstitutEntity> getInstitutsByCodM() {
        return institutsByCodM;
    }

    public void setInstitutsByCodM(Collection<InstitutEntity> institutsByCodM) {
        this.institutsByCodM = institutsByCodM;
    }

    @ManyToOne
    @JoinColumn(name = "nom_c", referencedColumnName = "nom_c")
    public ComarcaEntity getComarcaByNomC() {
        return comarcaByNomC;
    }

    public void setComarcaByNomC(ComarcaEntity comarcaByNomC) {
        this.comarcaByNomC = comarcaByNomC;
    }
}
