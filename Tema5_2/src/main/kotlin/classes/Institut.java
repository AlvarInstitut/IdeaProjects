package classes;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Institut {
    private String codi;
    private String nom;
    private String adreca;
    private String numero;
    private Integer codpostal;
    private Poblacio poblacioByCodM;

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
        Institut institut = (Institut) o;
        return Objects.equals(codi, institut.codi) && Objects.equals(nom, institut.nom) && Objects.equals(adreca, institut.adreca) && Objects.equals(numero, institut.numero) && Objects.equals(codpostal, institut.codpostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codi, nom, adreca, numero, codpostal);
    }

    @ManyToOne
    @JoinColumn(name = "cod_m", referencedColumnName = "cod_m")
    public Poblacio getPoblacioByCodM() {
        return poblacioByCodM;
    }

    public void setPoblacioByCodM(Poblacio poblacioByCodM) {
        this.poblacioByCodM = poblacioByCodM;
    }
}
