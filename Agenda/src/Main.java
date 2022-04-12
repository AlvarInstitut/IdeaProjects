import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda(new PostgreSQLContactsProvider());
        System.out.println(agenda);
        System.out.println("===============================================");
        Contact contacto = new Contact("prueba", "1234", null, "poh");
        agenda.add(contacto);
        Contact contacto1 = new Contact("hola", "1234", "asfd", "poh");
        agenda.add(contacto1);
        System.out.println(agenda);
        System.out.println("===============================================");
        Contact contact = agenda.retrieve(1);
        contact.setName("Pablo");
        agenda.update(contact);
        System.out.println(agenda);
        System.out.println("===============================================");
        agenda.remove(agenda.retrieve(2));
        System.out.println(agenda);
    }
}
