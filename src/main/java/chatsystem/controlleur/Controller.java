package chatsystem.controlleur ;
import chatsystem.contacts.ContactList;
import chatsystem.contacts.PseudoAlreadyExists ;

public class Controller {
    
    ContactList contactmap;
    public Controller(ContactList contactmap){
        contactmap = this.contactmap ;
    }
    public void handleMessage(String ip, String message) {
        try {
            this.contactmap.addUser(ip, message);
            System.out.println("New Contact added to the list: " + message);
        } catch (PseudoAlreadyExists e) {
            System.out.println("Received duplicated contact: " + message);
        }
    }
}