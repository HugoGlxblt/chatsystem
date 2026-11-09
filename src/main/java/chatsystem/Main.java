package chatsystem;

import chatsystem.contacts.ContactList;
import chatsystem.controlleur.Controller;
import chatsystem.network.UDPServer;


public class Main {
    public static final int PORT = 9445;
    
    public static void main(String[] args) {
        UDPServer server = new UDPServer(PORT);
        ContactList contactList = new ContactList();
        Controller observer = new Controller(contactList);
        server.addObserver(observer);

        server.start();
    }
}
