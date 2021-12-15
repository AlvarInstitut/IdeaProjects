package classesFactura;

import java.math.BigDecimal;
import java.util.Collection;

public class Article {
    private String codA;
    private String descrip;
    private BigDecimal preu;
    private Integer stock;
    private Integer stockMin;
    private Collection<LiniaFac> liniaFacs;

    public String getCodA() {
        return codA;
    }

    public void setCodA(String codA) {
        this.codA = codA;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public BigDecimal getPreu() {
        return preu;
    }

    public void setPreu(BigDecimal preu) {
        this.preu = preu;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStockMin() {
        return stockMin;
    }

    public void setStockMin(Integer stockMin) {
        this.stockMin = stockMin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (codA != null ? !codA.equals(article.codA) : article.codA != null) return false;
        if (descrip != null ? !descrip.equals(article.descrip) : article.descrip != null) return false;
        if (preu != null ? !preu.equals(article.preu) : article.preu != null) return false;
        if (stock != null ? !stock.equals(article.stock) : article.stock != null) return false;
        if (stockMin != null ? !stockMin.equals(article.stockMin) : article.stockMin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codA != null ? codA.hashCode() : 0;
        result = 31 * result + (descrip != null ? descrip.hashCode() : 0);
        result = 31 * result + (preu != null ? preu.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (stockMin != null ? stockMin.hashCode() : 0);
        return result;
    }

    public Collection<LiniaFac> getLiniaFacs() {
        return liniaFacs;
    }

    public void setLiniaFacs(Collection<LiniaFac> liniaFacs) {
        this.liniaFacs = liniaFacs;
    }
}
