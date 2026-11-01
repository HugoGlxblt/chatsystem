package chatsystem;

import chatsystem.contacts.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for Contact
 */
public class ContactTest {

    @Test
    void constructionPseudo() {
        Contact test = new Contact("id1", "pseudo");
        assertEquals(test.getId(), "id1");
        assertEquals(test.getPseudo(), "pseudo");
    }

    @Test
    void rejetPseudoVide() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("id-1", ""));
    }

    @Test
    void rejetIdVide() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("", "pseudo"));
    }

    @Test
    void contactsEgaux() {
        Contact test1 = new Contact("id1", "pseudo");
        Contact test2 = new Contact("id1", "pseudo2");
        assertEquals(test1.equals(test2),true);
    }
    
    @Test
    void contactsDifferents() {
        Contact test1 = new Contact("id1", "pseudo");
        Contact test2 = new Contact("id2", "pseudo");
        assertEquals(test1.equals(test2),false);
    }
}
