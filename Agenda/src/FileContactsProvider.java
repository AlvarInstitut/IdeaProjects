import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class FileContactsProvider implements IContactsProvider {
    private final String contactsFilePath = "resources/contacts.txt";
    private final String fieldsSeparator = ";";
    private int nextContactId = 0;

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contacts = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(contactsFilePath))) {
            String line;
            while ((line = br.readLine()) != null)
                contacts.add(readContact(line));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (!contacts.isEmpty())
            nextContactId = Collections.max(contacts, Comparator.comparing(contact -> contact.getId())).getId() + 1;

        return contacts;
    }

    private void saveContacts(List<Contact> contacts) {
        try (PrintWriter bw = new PrintWriter(new FileWriter(contactsFilePath))) {
            for (Contact contact : contacts)
                bw.println(contactStr(contact));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addContact(Contact contact) {
        contact.setId(nextContactId++);
        List<Contact> contacts = loadContacts();
        contacts.add(contact);
        saveContacts(contacts);
    }

    @Override
    public void removeContact(Contact contact) {
        List<Contact> contacts = loadContacts();
        contacts.remove(contact);
        saveContacts(contacts);
    }

    @Override
    public void updateContact(Contact contact) {
        List<Contact> contacts = loadContacts();
        contacts.remove(contact);
        contacts.add(contact);
        saveContacts(contacts);
    }

    private Contact readContact(String contactStr) {
        String[] contactParts = contactStr.split(fieldsSeparator);
        String id = contactParts[0];
        String name = contactParts[1];
        String phoneNumber = contactParts[2];
        String mail = contactParts[3];
        String address = contactParts[4];
        return new Contact(Integer.parseInt(id), name, phoneNumber, mail, address);
    }

    private String contactStr(Contact contact) {
        return  contact.getId() + fieldsSeparator + contact.getName() + fieldsSeparator +
                contact.getPhoneNumber() + fieldsSeparator + contact.getEmail() + fieldsSeparator +
                contact.getAddress() + System.lineSeparator();
    }
}
