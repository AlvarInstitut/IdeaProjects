package classesFactura;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;

public class Factura {
    private int numF;
    private Date data;
    private Integer codVen;
    private BigInteger iva;
    private Client client;
    private Collection<LiniaFac> liniaFacs;

    public int getNumF() {
        return numF;
    }

    public void setNumF(int numF) {
        this.numF = numF;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getCodVen() {
        return codVen;
    }

    public void setCodVen(Integer codVen) {
        this.codVen = codVen;
    }

    public BigInteger getIva() {
        return iva;
    }

    public void setIva(BigInteger iva) {
        this.iva = iva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factura factura = (Factura) o;

        if (numF != factura.numF) return false;
        if (data != null ? !data.equals(factura.data) : factura.data != null) return false;
        if (codVen != null ? !codVen.equals(factura.codVen) : factura.codVen != null) return false;
        if (iva != null ? !iva.equals(factura.iva) : factura.iva != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numF;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (codVen != null ? codVen.hashCode() : 0);
        result = 31 * result + (iva != null ? iva.hashCode() : 0);
        return result;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<LiniaFac> getLiniaFacs() {
        return liniaFacs;
    }

    public void setLiniaFacs(Collection<LiniaFac> liniaFacs) {
        this.liniaFacs = liniaFacs;
    }
}
