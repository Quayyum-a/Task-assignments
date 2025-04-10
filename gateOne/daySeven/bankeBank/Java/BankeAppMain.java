package daySeven.bankeBank.Java;

import java.util.Scanner;

public class BankeAppMain {
    private static BankeApp bank = new BankeApp();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== Banke Banking System =====");
            System.out.println("1. Create New Account");
            System.out.println("2. Access Existing Account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = getIntInput(1, 3);

                switch (choice) {
                    case 1:
                        createNewAccount();
                        break;
                    case 2:
                        accessAccount();
                        break;
                    case 3:
                        running = false;
                        System.out.println("Thank you for using Banke Banking System!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void createNewAccount() {
        System.out.println("\n=== Create New Account ===");

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine().trim();
        while (firstName.isEmpty()) {
            System.out.println("First name cannot be empty. Please try again.");
            System.out.print("Enter First Name: ");
            firstName = scanner.nextLine().trim();
        }

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine().trim();
        while (lastName.isEmpty()) {
            System.out.println("Last name cannot be empty. Please try again.");
            System.out.print("Enter Last Name: ");
            lastName = scanner.nextLine().trim();
        }

        int pin = 0;
        boolean validPin = false;
        while (!validPin) {
            try {
                System.out.print("Create a 4-digit PIN: ");
                pin = getIntInput(1000, 9999);
                validPin = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: PIN must be exactly 4 digits (1000-9999)");
            }
        }

        try {
            String accountNumber = bank.createAccount(firstName, lastName, pin);
            System.out.println("\nAccount created successfully!");
            System.out.println("Your account number is: " + accountNumber);
            System.out.println("Please save this number for future access.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void accessAccount() {
        System.out.println("\n=== Access Account ===");
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine().trim();

        int pin = 0;
        boolean validPin = false;
        while (!validPin) {
            try {
                System.out.print("Enter your PIN: ");
                pin = getIntInput(1000, 9999);
                validPin = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: PIN must be exactly 4 digits (1000-9999)");
            }
        }

        try {
            bank.login(accountNumber, pin);
            accountMenu();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void accountMenu() {
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\n=== Account Menu ===");
            System.out.println("Account Holder: " + bank.getAccountName());
            System.out.println("Account Number: " + bank.getAccountNumber());
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Change PIN");
            System.out.println("6. Close Account");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");

            try {
                int choice = getIntInput(1, 7);

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        transfer();
                        break;
                    case 5:
                        changePin();
                        break;
                    case 6:
                        closeAccount();
                        loggedIn = false;
                        break;
                    case 7:
                        bank.logout();
                        loggedIn = false;
                        System.out.println("Logged out successfully.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void checkBalance() {
        try {
            System.out.println("Current Balance: $" + bank.getBalance());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deposit() {
        boolean validAmount = false;
        while (!validAmount) {
            try {
                System.out.print("Enter deposit amount: $");
                double amount = getPositiveDoubleInput();
                bank.deposit(amount);
                System.out.println("Deposit successful. New balance: $" + bank.getBalance());
                validAmount = true;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void withdraw() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter withdrawal amount: $");
                double amount = getPositiveDoubleInput();
                System.out.print("Enter your PIN: ");
                int pin = getIntInput(1000, 9999);
                bank.withdraw(amount, pin);
                System.out.println("Withdrawal successful. New balance: $" + bank.getBalance());
                validInput = true;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void transfer() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter recipient's account number: ");
                String recipientNumber = scanner.nextLine().trim();
                System.out.print("Enter transfer amount: $");
                double amount = getPositiveDoubleInput();
                System.out.print("Enter your PIN: ");
                int pin = getIntInput(1000, 9999);
                bank.transfer(recipientNumber, amount, pin);
                System.out.println("Transfer successful. New balance: $" + bank.getBalance());
                validInput = true;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void changePin() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter current PIN: ");
                int oldPin = getIntInput(1000, 9999);
                System.out.print("Enter new 4-digit PIN: ");
                int newPin = getIntInput(1000, 9999);
                bank.changePin(oldPin, newPin);
                System.out.println("PIN changed successfully.");
                validInput = true;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void closeAccount() {
        System.out.print("Are you sure you want to close your account? (yes/no): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("yes")) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Enter your PIN to confirm: ");
                    int pin = getIntInput(1000, 9999);
                    bank.closeAccount(pin);
                    System.out.println("Account closed successfully.");
                    validInput = true;
                } catch (IllegalArgumentException | IllegalStateException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Account closure cancelled.");
        }
    }


    private static int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input < min || input > max) {
                    throw new IllegalArgumentException("Input must be between " + min + " and " + max);
                }
                return input;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    private static double getPositiveDoubleInput() {
        while (true) {
            try {
                double input = scanner.nextDouble();
                scanner.nextLine();
                if (input <= 0) {
                    throw new IllegalArgumentException("Amount must be greater than zero");
                }
                return input;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
                scanner.nextLine();
            }
        }
    }
}