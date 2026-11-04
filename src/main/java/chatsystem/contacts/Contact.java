package chatsystem.contacts;


public class Contact {
    // contient un pseudo choisit par l'utilisateur.


    private final String pseudo;

    public Contact(String pseudo) {

        if (pseudo.isBlank()) {
            throw new IllegalArgumentException("Le pseudo ne peut pas être vide / composé d'espaces");
        }

        this.pseudo = pseudo;
    }


    public String getPseudo() {
        return pseudo;
    }


    @Override
    public String toString() {
        return "Contact:  pseudo = " + pseudo;
    }
}