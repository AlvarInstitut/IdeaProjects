package classes;

public class Empleat {
    private Integer num;
    private String nom;
    private Integer depart;
    private Integer edat;
    private Double sou;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getDepart() {
        return depart;
    }

    public void setDepart(Integer depart) {
        this.depart = depart;
    }

    public Integer getEdat() {
        return edat;
    }

    public void setEdat(Integer edat) {
        this.edat = edat;
    }

    public Double getSou() {
        return sou;
    }

    public void setSou(Double sou) {
        this.sou = sou;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empleat empleat = (Empleat) o;

        if (num != null ? !num.equals(empleat.num) : empleat.num != null) return false;
        if (nom != null ? !nom.equals(empleat.nom) : empleat.nom != null) return false;
        if (depart != null ? !depart.equals(empleat.depart) : empleat.depart != null) return false;
        if (edat != null ? !edat.equals(empleat.edat) : empleat.edat != null) return false;
        if (sou != null ? !sou.equals(empleat.sou) : empleat.sou != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = num != null ? num.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (depart != null ? depart.hashCode() : 0);
        result = 31 * result + (edat != null ? edat.hashCode() : 0);
        result = 31 * result + (sou != null ? sou.hashCode() : 0);
        return result;
    }
}
