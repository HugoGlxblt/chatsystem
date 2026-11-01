package chatsystem.contacts;

import java.util.Objects;

public class Contact {
    // contient un id unique donné par le système et un pseudo choisit par l'utilisateur.

    private final String id;
    private final String pseudo;

    public Contact(String id, String pseudo) {

        if (id.isBlank()) {
            throw new IllegalArgumentException("L'id ne peut pas être vide / composé d'espaces");
        }
        if (pseudo.isBlank()) {
            throw new IllegalArgumentException("Le pseudo ne peut pas être vide / composé d'espaces");
        }

        this.id = id;
        this.pseudo = pseudo;
    }

    public String getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    @Override
    public boolean equals(Object o) {
        Contact contact = (Contact) o;
        return id.equals(contact.id);
    }

    @Override
    public String toString() {
        return "Contact: id =" + id + ", pseudo = " + pseudo;
    }
}