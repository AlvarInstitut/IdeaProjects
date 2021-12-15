package classesFactura;

import java.util.Collection;

public class Poble {
    private int codPob;
    private String nom;
    private String provincia;
    private Collection<Client> clients;

    public int getCodPob() {
        return codPob;
    }

    public void setCodPob(int codPob) {
        this.codPob = codPob;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Poble poble = (Poble) o;

        if (codPob != poble.codPob) return false;
        if (nom != null ? !nom.equals(poble.nom) : poble.nom != null) return false;
        if (provincia != null ? !provincia.equals(poble.provincia) : poble.provincia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codPob;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (provincia != null ? provincia.hashCode() : 0);
        return result;
    }

    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Collection<Client> clients) {
        this.clients = clients;
    }
}
