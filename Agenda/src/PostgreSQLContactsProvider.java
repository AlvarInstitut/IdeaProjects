import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PostgreSQLContactsProvider implements  IContactsProvider{

    private Connection con = null;

    public PostgreSQLContactsProvider() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://89.36.214.106:5432/geo_1cfsy_0000x","geo_1cfsy_0000x","geo_1cfsy_0000x");
            Statement st = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS AGENDA (" +
                            "id SERIAL PRIMARY KEY," +
                            "name VARCHAR(100)," +
                            "phoneNumber VARCHAR(15)," +
                            "email VARCHAR(50)," +
                            "address VARCHAR(50) )";
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;
    }

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contacts = new LinkedList<>();
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM AGENDA");
            while (rs.next()){
                Contact c = new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                contacts.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public void addContact(Contact contact) {
        try {
            Statement st = con.createStatement();
            String sql = "INSERT INTO AGENDA(name,phoneNumber,email,address) VALUES " +
                            "('"+contact.getName()+"','"+contact.getPhoneNumber()+"','"+contact.getEmail()+"','"+contact.getAddress()+"')";
            st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeContact(Contact contact) {
        try {
            Statement st = con.createStatement();
            String sql = "DELETE FROM AGENDA WHERE id="+contact.getId();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateContact(Contact contact) {
        try {
            Statement st = con.createStatement();
            String sql = "UPDATE AGENDA SET name='"+contact.getName()+"',phoneNumber='"+contact.getPhoneNumber()+"" +
                                "',email='"+contact.getEmail()+"',address='"+contact.getAddress()+"' " +
                            "WHERE id=" + contact.getId();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
