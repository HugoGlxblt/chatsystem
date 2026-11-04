package chatsystem;

import chatsystem.contacts.ContactList;
import chatsystem.contacts.PseudoAlreadyExists;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;



/**
 * Unit test for ContactList
 */
public class ContactListTest {
    //Test
    
    @Test
    void ajoutContact() {
        ContactList testContactList = new ContactList();
        assertDoesNotThrow(() -> testContactList.addUser("ip", "pseudo"));    
    }
    @Test
    void testhasPseudo() {
        ContactList testContactList = new ContactList();
        assertDoesNotThrow(() -> testContactList.addUser("ip", "pseudo"));    
        assertEquals(true, testContactList.hasPseudo("pseudo"));
        assertEquals(false, testContactList.hasPseudo("pseudo2"));
    }

    @Test
    void ajoutContactDejaExistant() {
        ContactList testContactList = new ContactList();
        assertDoesNotThrow(() -> testContactList.addUser("ip", "pseudo"));    
        assertThrows(PseudoAlreadyExists.class, () -> testContactList.addUser("ip", "pseudo"));
    }


    
}
