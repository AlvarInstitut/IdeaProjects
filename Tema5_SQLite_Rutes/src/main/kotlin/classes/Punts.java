package classes;

public class Punts {
    private Integer numR;
    private Integer numP;
    private String nomP;
    private Double latitud;
    private Double longitud;
    private Rutes ruta;

    public Integer getNumR() {
        return numR;
    }

    public void setNumR(Integer numR) {
        this.numR = numR;
    }

    public Integer getNumP() {
        return numP;
    }

    public void setNumP(Integer numP) {
        this.numP = numP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Punts punts = (Punts) o;

        if (numR != null ? !numR.equals(punts.numR) : punts.numR != null) return false;
        if (numP != null ? !numP.equals(punts.numP) : punts.numP != null) return false;
        if (nomP != null ? !nomP.equals(punts.nomP) : punts.nomP != null) return false;
        if (latitud != null ? !latitud.equals(punts.latitud) : punts.latitud != null) return false;
        if (longitud != null ? !longitud.equals(punts.longitud) : punts.longitud != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numR != null ? numR.hashCode() : 0;
        result = 31 * result + (numP != null ? numP.hashCode() : 0);
        result = 31 * result + (nomP != null ? nomP.hashCode() : 0);
        result = 31 * result + (latitud != null ? latitud.hashCode() : 0);
        result = 31 * result + (longitud != null ? longitud.hashCode() : 0);
        return result;
    }

    public Rutes getRuta() {
        return ruta;
    }

    public void setRuta(Rutes ruta) {
        this.ruta = ruta;
    }
}
