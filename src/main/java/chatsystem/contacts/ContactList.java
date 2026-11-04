package chatsystem.contacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactList {
    //la hashmap contient un string: l'adresse ip et un contact qui contient lui le pseudo. 
    private HashMap<String, Contact> map = new HashMap<>();

    public ContactList(){
        
    }

    

    public boolean hasPseudo(String pseudo) {
        for (Contact contact : this.map.values()) {
            if (contact.getPseudo().equals(pseudo)) {
                return true;
            }
        }
        return false;
    }


    public void addUser(String ip, String pseudo) throws PseudoAlreadyExists {
        if (hasPseudo(pseudo)) {
            throw new PseudoAlreadyExists(pseudo);
        } else {
            Contact contact = new Contact(pseudo);
            map.put(ip, contact);
            System.out.println("contact: "+pseudo+" ajouté");
        }
    }

    public List<Contact> getListOfContact() {
        return new ArrayList<>(this.map.values());
    }

}
