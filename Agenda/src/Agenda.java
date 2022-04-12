import java.util.*;
import java.util.stream.Collectors;

public class Agenda {
    private List<Contact> contacts;
    IContactsProvider provider;

    public Agenda(IContactsProvider provider) {
        this.provider = provider;
        loadAgenda();
    }

    public void loadAgenda() {
        contacts = provider.loadContacts();
        contacts.sort(Comparator.comparing(s -> s.getName()));
    }

    public void add(Contact contact) {
        provider.addContact(contact);
        loadAgenda();
    }

    public void remove(Contact contact) {
        provider.removeContact(contact);
        loadAgenda();
    }

    public void update(Contact contact) {
        provider.updateContact(contact);
        loadAgenda();
    }

    public Contact retrieve(int index) {
        return contacts.get(index);
    }

    public Collection<Contact> filter(String str) {
        return contacts.stream()
                .filter(c -> c.getName().contains(str) || c.getAddress().contains(str) || c.getPhoneNumber().contains(str) || c.getEmail().contains(str))
                .collect(Collectors.toList());
    }

    public void showAllContacts(){
        showContacts(contacts);
    }

    public void showContacts(Collection<Contact> contacts) {
        System.out.println(contactsStr(contacts));
    }

    @Override
    public String toString() {
        return contactsStr(contacts);
    }

    private String contactsStr(Collection<Contact> contactsToShow) {
        String agendaStr = "";
        for (Contact contact : contactsToShow)
            agendaStr += contacts.indexOf(contact) + "\n" + contact + "\n\n";
        return agendaStr;
    }
}
