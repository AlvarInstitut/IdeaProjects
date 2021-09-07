package classes;

import javax.persistence.*;

@Entity
@Table(name = "institut", schema = "public", catalog = "geo_ad")
public class InstitutEntity {
    private String codi;
    private String nom;
    private String adreca;
    private String numero;
    private Integer codpostal;
    private PoblacioEntity poblacioByCodM;

    @Id
    @Column(name = "codi")
    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
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
    @Column(name = "adreca")
    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    @Basic
    @Column(name = "numero")
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "codpostal")
    public Integer getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(Integer codpostal) {
        this.codpostal = codpostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstitutEntity that = (InstitutEntity) o;

        if (codi != null ? !codi.equals(that.codi) : that.codi != null) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (adreca != null ? !adreca.equals(that.adreca) : that.adreca != null) return false;
        if (numero != null ? !numero.equals(that.numero) : that.numero != null) return false;
        if (codpostal != null ? !codpostal.equals(that.codpostal) : that.codpostal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codi != null ? codi.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (adreca != null ? adreca.hashCode() : 0);
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        result = 31 * result + (codpostal != null ? codpostal.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "cod_m", referencedColumnName = "cod_m")
    public PoblacioEntity getPoblacioByCodM() {
        return poblacioByCodM;
    }

    public void setPoblacioByCodM(PoblacioEntity poblacioByCodM) {
        this.poblacioByCodM = poblacioByCodM;
    }
}
