package classesFactura;

import java.util.Collection;

public class Client {
    private int codCli;
    private String nom;
    private String adreca;
    private Integer cp;
    private Poble poble;
    private Collection<Factura> facturas;

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (codCli != client.codCli) return false;
        if (nom != null ? !nom.equals(client.nom) : client.nom != null) return false;
        if (adreca != null ? !adreca.equals(client.adreca) : client.adreca != null) return false;
        if (cp != null ? !cp.equals(client.cp) : client.cp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codCli;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (adreca != null ? adreca.hashCode() : 0);
        result = 31 * result + (cp != null ? cp.hashCode() : 0);
        return result;
    }

    public Poble getPoble() {
        return poble;
    }

    public void setPoble(Poble poble) {
        this.poble = poble;
    }

    public Collection<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Collection<Factura> facturas) {
        this.facturas = facturas;
    }
}
