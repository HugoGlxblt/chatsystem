package chatsystem.controlleur ;
import chatsystem.contacts.ContactList;
import chatsystem.contacts.PseudoAlreadyExists ;

public class Controller {
    
    ContactList contactmap;
    public Controller(ContactList contactmap){
        this.contactmap = contactmap ;
    }
    public void handleMessage(String ip, String message) {
        try {
            this.contactmap.addUser(ip, message);
        } catch (PseudoAlreadyExists e) {
            System.out.println("Received duplicated contact: " + message);
        }
    }
}