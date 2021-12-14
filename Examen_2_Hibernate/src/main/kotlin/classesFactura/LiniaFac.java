package classesFactura;

import java.math.BigDecimal;

public class LiniaFac {
    private int numL;
    private Integer quant;
    private BigDecimal preu;
    private Factura factura;
    private Article article;

    public int getNumL() {
        return numL;
    }

    public void setNumL(int numL) {
        this.numL = numL;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public BigDecimal getPreu() {
        return preu;
    }

    public void setPreu(BigDecimal preu) {
        this.preu = preu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LiniaFac liniaFac = (LiniaFac) o;

        if (numL != liniaFac.numL) return false;
        if (quant != null ? !quant.equals(liniaFac.quant) : liniaFac.quant != null) return false;
        if (preu != null ? !preu.equals(liniaFac.preu) : liniaFac.preu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numL;
        result = 31 * result + (quant != null ? quant.hashCode() : 0);
        result = 31 * result + (preu != null ? preu.hashCode() : 0);
        return result;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
