import java.util.LinkedList;
import java.util.List;

public class HardCodedDataProvider implements IContactsProvider {

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contacts = new LinkedList<>();
        contacts.add(new Contact(0,"Maria", "123456789", "mail@dominio.com", "C/Bonita"));
        contacts.add(new Contact(1, "Laura", "123456789", "mail@dominio.com", "C/Bonita"));
        contacts.add(new Contact(2, "Ramón", "123456789", "mail@dominio.com", "C/Bonita"));
        contacts.add(new Contact(3, "Pedro", "123456789", "mail@dominio.com", "C/Bonita"));
        contacts.add(new Contact(4, "Maria", "123456789", "mail@dominio.com", "C/Bonita"));
        return contacts;
    }

    @Override
    public void addContact(Contact contact) {

    }

    @Override
    public void removeContact(Contact contact) {

    }

    @Override
    public void updateContact(Contact contact) {

    }
}
