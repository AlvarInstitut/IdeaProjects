import java.io.IOException;
import java.util.List;

public interface IContactsProvider {
    List<Contact> loadContacts();
    void addContact(Contact contact);
    void removeContact(Contact contact);
    void updateContact(Contact contact);
}
