package daySeven.phoneBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    private Contact contact;

    @BeforeEach
    public void setup() {
        contact = new Contact("John", "Doe", "1234567890");
    }

    @Test
    public void testContactDetails() {
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
    }

    @Test
    public void firstNameCanBeUpdated() {
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void lastNameCanBeUpdated() {
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void phoneNumberCanBeUpdated() {
        contact.setPhoneNumber("0987654321");
        assertEquals("0987654321", contact.getPhoneNumber());
    }

    @Test
    public void contactCreationWithEmptyFirstNameThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("", "Doe", "1234567890");
        });
        assertEquals("First name cannot be empty", exception.getMessage());
    }

    @Test
    public void contactCreationWithEmptyLastNameThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("John", "", "1234567890");
        });
        assertEquals("Last name cannot be empty", exception.getMessage());
    }

    @Test
    public void contactCreationWithEmptyPhoneNumberThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("John", "Doe", "");
        });
        assertEquals("Phone number cannot be empty", exception.getMessage());
    }

    @Test
    public void contactCreationWithNullFirstNameThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Doe", "1234567890");
        });
        assertEquals("First name cannot be empty", exception.getMessage());
    }

    @Test
    public void contactCreationWithNullLastNameThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("John", null, "1234567890");
        });
        assertEquals("Last name cannot be empty", exception.getMessage());
    }

    @Test
    public void contactCreationWithNullPhoneNumberThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("John", "Doe", null);
        });
        assertEquals("Phone number cannot be empty", exception.getMessage());
    }


}