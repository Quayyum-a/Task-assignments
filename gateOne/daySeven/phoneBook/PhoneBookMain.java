package daySeven.phoneBook;

import java.util.List;
import java.util.Scanner;

public class PhoneBookMain {
    private static PhoneBook phoneBook = new PhoneBook();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                int choice = getIntInput(1, 8);
                switch (choice) {
                    case 1: addContact(); break;
                    case 2: removeContact(); break;
                    case 3: findByPhoneNumber(); break;
                    case 4: findByFirstName(); break;
                    case 5: findByLastName(); break;
                    case 6: editContact(); break;
                    case 7: listAllContacts(); break;
                    case 8: running = false; System.out.println("Goodbye!"); break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===== Phone Book =====");
        System.out.println("1. Add Contact");
        System.out.println("2. Remove Contact");
        System.out.println("3. Find Contact by Phone Number");
        System.out.println("4. Find Contacts by First Name");
        System.out.println("5. Find Contacts by Last Name");
        System.out.println("6. Edit Contact");
        System.out.println("7. List All Contacts");
        System.out.println("8. Exit");
        System.out.print("Enter your choice (1-8): ");
    }

    private static void addContact() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine().trim();
        phoneBook.addContact(firstName, lastName, phoneNumber);
        System.out.println("Contact added successfully.");
    }

    private static void removeContact() {
        System.out.print("Enter phone number to remove: ");
        String phoneNumber = scanner.nextLine().trim();
        phoneBook.removeContact(phoneNumber);
        System.out.println("Contact removed successfully.");
    }

    private static void findByPhoneNumber() {
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine().trim();
        Contact contact = phoneBook.findContactByPhoneNumber(phoneNumber);
        System.out.println(contact != null ? contact : "Contact not found.");
    }

    private static void findByFirstName() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine().trim();
        List<Contact> matches = phoneBook.findContactsByFirstName(firstName);
        System.out.println(matches.isEmpty() ? "No contacts found." : matches);
    }

    private static void findByLastName() {
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();
        List<Contact> matches = phoneBook.findContactsByLastName(lastName);
        System.out.println(matches.isEmpty() ? "No contacts found." : matches);
    }

    private static void editContact() {
        System.out.print("Enter phone number of contact to edit: ");
        String phoneNumber = scanner.nextLine().trim();
        System.out.print("Enter new first name (or press Enter to skip): ");
        String newFirstName = scanner.nextLine().trim();
        System.out.print("Enter new last name (or press Enter to skip): ");
        String newLastName = scanner.nextLine().trim();
        System.out.print("Enter new phone number (or press Enter to skip): ");
        String newPhoneNumber = scanner.nextLine().trim();
        phoneBook.editContact(phoneNumber, newFirstName, newLastName, newPhoneNumber);
        System.out.println("Contact updated successfully.");
    }

    private static void listAllContacts() {
        String allContacts = phoneBook.displayAllContacts();
        System.out.println(allContacts.equals("[]") ? "No contacts in phone book." : allContacts);
    }

    private static int getIntInput(int min, int max) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty.");
                }
                int choice = Integer.parseInt(input);
                if (choice < min || choice > max) {
                    throw new IllegalArgumentException("Input must be between " + min + " and " + max + ".");
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                System.out.print("Enter your choice (1-8): ");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.print("Enter your choice (1-8): ");
            }
        }
    }
}