package daySeven.phoneBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    public void setup() {
        phoneBook = new PhoneBook();
        phoneBook.addContact("John", "Doe", "1234567890");
    }


    @Test
    public void testAddContact() {
        assertEquals(1, phoneBook.getContactCount());
        phoneBook.addContact("Jane", "Smith", "0987654321");
        assertEquals(2, phoneBook.getContactCount());
    }

    @Test
    public void testAddDuplicatePhoneNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.addContact("Jane", "Smith", "1234567890");
        });
        assertEquals("Phone number already exists", exception.getMessage());
    }

    @Test
    public void testAddContactNullPhoneNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.addContact("Jane", "Smith", null);
        });
        assertEquals("Phone number cannot be empty", exception.getMessage());
    }

    @Test
    public void testAddContactEmptyPhoneNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.addContact("Jane", "Smith", "   ");
        });
        assertEquals("Phone number cannot be empty", exception.getMessage());
    }


    @Test
    public void testRemoveContact() {
        phoneBook.removeContact("1234567890");
        assertEquals(0, phoneBook.getContactCount());
    }

    @Test
    public void testRemoveNonExistentContact() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.removeContact("0987654321");
        });
        assertEquals("Contact with phone number 0987654321 not found", exception.getMessage());
    }

    @Test
    public void testRemoveContactNullPhoneNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.removeContact(null);
        });
        assertEquals("Phone number cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testRemoveContactEmptyPhoneNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.removeContact("   ");
        });
        assertEquals("Phone number cannot be null or empty", exception.getMessage());
    }


    @Test
    public void testFindByPhoneNumber() {
        Contact contact = phoneBook.findContactByPhoneNumber("1234567890");
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
    }

    @Test
    public void testFindByPhoneNumberNonExistent() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.findContactByPhoneNumber("0987654321");
        });
        assertEquals("Contact with phone number 0987654321 not found", exception.getMessage());
    }

    @Test
    public void testFindByPhoneNumberNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.findContactByPhoneNumber(null);
        });
        assertEquals("Phone number cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testFindByPhoneNumberEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.findContactByPhoneNumber("   ");
        });
        assertEquals("Phone number cannot be null or empty", exception.getMessage());
    }


    @Test
    public void testFindByFirstName() {
        phoneBook.addContact("John", "Smith", "0987654321");
        List<Contact> matches = phoneBook.findContactsByFirstName("John");
        assertEquals(2, matches.size());
        assertTrue(matches.stream().allMatch(c -> c.getFirstName().equalsIgnoreCase("John")));
    }

    @Test
    public void testFindByFirstNameCaseInsensitive() {
        phoneBook.addContact("JOHN", "Smith", "0987654321");
        List<Contact> matches = phoneBook.findContactsByFirstName("john");
        assertEquals(2, matches.size());
    }

    @Test
    public void testFindByFirstNameNoMatches() {
        List<Contact> matches = phoneBook.findContactsByFirstName("Jane");
        assertTrue(matches.isEmpty());
    }

    @Test
    public void testFindByFirstNameNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.findContactsByFirstName(null);
        });
        assertEquals("First name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testFindByFirstNameEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.findContactsByFirstName("   ");
        });
        assertEquals("First name cannot be null or empty", exception.getMessage());
    }


    @Test
    public void testFindByLastName() {
        phoneBook.addContact("Jane", "Doe", "0987654321");
        List<Contact> matches = phoneBook.findContactsByLastName("Doe");
        assertEquals(2, matches.size());
        assertTrue(matches.stream().allMatch(c -> c.getLastName().equalsIgnoreCase("Doe")));
    }

    @Test
    public void testFindByLastName_CaseInsensitive() {
        phoneBook.addContact("Jane", "DOE", "0987654321");
        List<Contact> matches = phoneBook.findContactsByLastName("doe");
        assertEquals(2, matches.size());
    }

    @Test
    public void testFindByLastNameNoMatches() {
        List<Contact> matches = phoneBook.findContactsByLastName("Smith");
        assertTrue(matches.isEmpty());
    }

    @Test
    public void testFindByLastNameNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.findContactsByLastName(null);
        });
        assertEquals("Last name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testFindByLastNameEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.findContactsByLastName("   ");
        });
        assertEquals("Last name cannot be null or empty", exception.getMessage());
    }


    @Test
    public void testEditContactNewPhoneNumber() {
        phoneBook.editContact("1234567890", "Jane", "Smith", "0987654321");
        Contact contact = phoneBook.findContactByPhoneNumber("0987654321");
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhoneNumber());
        assertThrows(IllegalArgumentException.class, () -> phoneBook.findContactByPhoneNumber("1234567890"));
    }

    @Test
    public void testEditContactSamePhoneNumber() {
        phoneBook.editContact("1234567890", "Jane", "Smith", "1234567890");
        Contact contact = phoneBook.findContactByPhoneNumber("1234567890");
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testEditNonExistentContact() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.editContact("0987654321", "Jane", "Smith", "1111111111");
        });
        assertEquals("Contact with phone number 0987654321 not found", exception.getMessage());
    }

    @Test
    public void testEditContactDuplicateNewPhoneNumber() {
        phoneBook.addContact("Jane", "Smith", "0987654321");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.editContact("1234567890", "Jane", "Doe", "0987654321");
        });
        assertEquals("New phone number already exists", exception.getMessage());
    }

    @Test
    public void testEditContactNullOldPhoneNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.editContact(null, "Jane", "Smith", "0987654321");
        });
        assertEquals("Old phone number cannot be empty", exception.getMessage());
    }

    @Test
    public void testEditContactEmptyOldPhoneNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.editContact("   ", "Jane", "Smith", "0987654321");
        });
        assertEquals("Old phone number cannot be empty", exception.getMessage());
    }

    @Test
    public void testEditContactNull_NewPhoneNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.editContact("1234567890", "Jane", "Smith", null);
        });
        assertEquals("New phone number cannot be empty", exception.getMessage());
    }

    @Test
    public void testEditContactEmptyNewPhoneNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.editContact("1234567890", "Jane", "Smith", "   ");
        });
        assertEquals("New phone number cannot be empty", exception.getMessage());
    }


    @Test
    public void testGetContactCountEmpty() {
        PhoneBook emptyPhoneBook = new PhoneBook();
        assertEquals(0, emptyPhoneBook.getContactCount());
    }


    @Test
    public void testDisplayAllContactsEmpty() {
        PhoneBook emptyPhoneBook = new PhoneBook();
        assertEquals("[]", emptyPhoneBook.displayAllContacts());
    }

    @Test
    public void testDisplayAllContactsMultiple() {
        phoneBook.addContact("Jane", "Smith", "0987654321");
        String result = phoneBook.displayAllContacts();
        assertTrue(result.contains("John"));
        assertTrue(result.contains("Doe"));
        assertTrue(result.contains("Jane"));
        assertTrue(result.contains("Smith"));
    }
}