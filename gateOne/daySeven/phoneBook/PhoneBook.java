package daySeven.phoneBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneBook {
    private final Map<String, Contact> contacts;

    public PhoneBook() {
        this.contacts = new HashMap<>();
    }

    public void addContact(String firstName, String lastName, String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        if (contacts.containsKey(phoneNumber)) {
            throw new IllegalArgumentException("Phone number already exists");
        }
        Contact newContact = new Contact(firstName, lastName, phoneNumber);
        contacts.put(phoneNumber, newContact);
    }

    public void removeContact(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        if (!contacts.containsKey(phoneNumber)) {
            throw new IllegalArgumentException("Contact with phone number " + phoneNumber + " not found");
        }
        contacts.remove(phoneNumber);
    }

    public Contact findContactByPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        Contact contact = contacts.get(phoneNumber);
        if (contact == null) {
            throw new IllegalArgumentException("Contact with phone number " + phoneNumber + " not found");
        }
        return contact;
    }

    public List<Contact> findContactsByFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        return contacts.values().stream()
                .filter(contact -> contact.getFirstName().equalsIgnoreCase(firstName.trim()))
                .collect(Collectors.toList());
    }

    public List<Contact> findContactsByLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        return contacts.values().stream()
                .filter(contact -> contact.getLastName().equalsIgnoreCase(lastName.trim()))
                .collect(Collectors.toList());
    }

    public void editContact(String oldPhoneNumber, String newFirstName, String newLastName, String newPhoneNumber) {

        if (oldPhoneNumber == null || oldPhoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Old phone number cannot be empty");
        }
        if (newPhoneNumber == null || newPhoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("New phone number cannot be empty");
        }


        Contact contactToEdit = findContactByPhoneNumber(oldPhoneNumber);

        if (!oldPhoneNumber.equals(newPhoneNumber) && contacts.containsKey(newPhoneNumber)) {
            throw new IllegalArgumentException("New phone number already exists");
        }


        contactToEdit.setFirstName(newFirstName);
        contactToEdit.setLastName(newLastName);


        if (!oldPhoneNumber.equals(newPhoneNumber)) {
            contacts.remove(oldPhoneNumber);
            contactToEdit.setPhoneNumber(newPhoneNumber);
            contacts.put(newPhoneNumber, contactToEdit);
        }
    }

    public int getContactCount() {
        return contacts.size();
    }

    public String displayAllContacts() {
        return contacts.values().toString();
    }
}