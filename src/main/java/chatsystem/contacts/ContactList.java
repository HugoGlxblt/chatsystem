package chatsystem.contacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactList {
    //la hashmap contient un string: l'adresse ip et un contact qui contient lui le pseudo. 
    private HashMap<String, Contact> map = new HashMap<>();

    public ContactList(){
        
    }

    public HashMap<String, Contact> getContactList(){
        return this.map;
    }

    public boolean hasPseudo(String pseudo) {
        for (Contact contact : this.map.values()) {
            if (contact.getPseudo().equals(pseudo)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasIp(String ip) {
        for (String adresseIp : this.map.keySet()) {
            if (adresseIp.equals(ip)) {
                return true;
            }
        }
        return false;
    }


    public void addUser(String ip, String pseudo) throws PseudoAlreadyExists {
        if (hasPseudo(pseudo)) {
            throw new PseudoAlreadyExists(pseudo);
        } else if(hasIp(ip)){
            System.out.println("contact: "+map.get(ip).getPseudo()+"modifié, le nouveau pseudo est:"+pseudo);
            Contact contact = new Contact(pseudo);
            map.put(ip, contact);
        }
        else {
            Contact contact = new Contact(pseudo);
            map.put(ip, contact);
            System.out.println("contact: "+pseudo+" ajouté");
        }
        System.out.println("Liste des contacts:"+this.getContactList().toString());
        System.out.println("--------------------------------------------------");
    }

    public List<Contact> getListOfContact() {
        return new ArrayList<>(this.map.values());
    }

}
