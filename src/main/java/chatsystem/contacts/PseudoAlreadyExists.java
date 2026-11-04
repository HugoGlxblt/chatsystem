package chatsystem.contacts; 



public class  PseudoAlreadyExists extends Exception {

    private final String username;

    public PseudoAlreadyExists(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Le pseudo: " + username+" existait déja";
    }
}