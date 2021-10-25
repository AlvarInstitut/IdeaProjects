package classes;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

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
    private Collection<Institut> institutsByCodM;
    private Comarca comarcaByNomC;

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
        return codM == poblacio1.codM && Objects.equals(nom, poblacio1.nom) && Objects.equals(poblacio, poblacio1.poblacio) && Objects.equals(extensio, poblacio1.extensio) && Objects.equals(altura, poblacio1.altura) && Objects.equals(longitud, poblacio1.longitud) && Objects.equals(latitud, poblacio1.latitud) && Objects.equals(llengua, poblacio1.llengua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codM, nom, poblacio, extensio, altura, longitud, latitud, llengua);
    }

    @OneToMany(mappedBy = "poblacioByCodM")
    public Collection<Institut> getInstitutsByCodM() {
        return institutsByCodM;
    }

    public void setInstitutsByCodM(Collection<Institut> institutsByCodM) {
        this.institutsByCodM = institutsByCodM;
    }

    @ManyToOne
    @JoinColumn(name = "nom_c", referencedColumnName = "nom_c")
    public Comarca getComarcaByNomC() {
        return comarcaByNomC;
    }

    public void setComarcaByNomC(Comarca comarcaByNomC) {
        this.comarcaByNomC = comarcaByNomC;
    }
}
