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
        Contact test = new Contact("pseudo");
        assertEquals(test.getPseudo(), "pseudo");
    }

    @Test
    void rejetPseudoVide() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(""));
    }
    
}
