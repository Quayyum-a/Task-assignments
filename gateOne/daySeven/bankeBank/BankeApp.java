package daySeven.bankeBank;

import java.util.HashMap;
import java.util.Map;

public class BankeApp {
    private final Map<String, Account> accounts = new HashMap<>();
    private Account activeAccount;

    public String createAccount(String firstName, String lastName, int pin) {
        validateName(firstName);
        validateName(lastName);
        validatePin(pin);
        String accountNumber = generateAccountNumber();
        Account newAccount = new Account(firstName, lastName, pin, accountNumber);
        accounts.put(accountNumber, newAccount);
        activeAccount = newAccount;
        return accountNumber;
    }

    public void login(String accountNumber, int pin) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        if (!account.verifyPin(pin)) {
            throw new IllegalArgumentException("Incorrect PIN");
        }
        activeAccount = account;
    }

    public void logout() {
        activeAccount = null;
    }

    public void deposit(double amount) {
        checkActiveAccount();
        activeAccount.deposit(amount);
    }

    public void withdraw(double amount, int pin) {
        checkActiveAccount();
        activeAccount.withdraw(amount, pin);
    }

    public double getBalance() {
        checkActiveAccount();
        return activeAccount.getBalance();
    }

    public void transfer(String recipientAccountNumber, double amount, int pin) {
        checkActiveAccount();
        Account recipient = accounts.get(recipientAccountNumber);
        if (recipient == null) {
            throw new IllegalArgumentException("Recipient account does not exist");
        }
        activeAccount.withdraw(amount, pin);
        recipient.deposit(amount);
    }

    public void changePin(int oldPin, int newPin) {
        checkActiveAccount();
        activeAccount.changePin(oldPin, newPin);
    }

    public boolean verifyPin(int pin) {
        checkActiveAccount();
        return activeAccount.verifyPin(pin);
    }

    public void closeAccount(int pin) {
        checkActiveAccount();
        if (!activeAccount.verifyPin(pin)) {
            throw new IllegalArgumentException("Incorrect PIN");
        }
        accounts.remove(activeAccount.getAccountNumber());
        activeAccount = null;
    }

    public String getAccountName() {
        checkActiveAccount();
        return activeAccount.getFirstName() + " " + activeAccount.getLastName();
    }

    public String getAccountNumber() {
        checkActiveAccount();
        return activeAccount.getAccountNumber();
    }

    public int getAccountCount() {
        return accounts.size();
    }

    private String generateAccountNumber() {
        return String.valueOf(1000000000 + (int) (Math.random() * 900000000));
    }

    private void validateName(String name) {
        if (!name.matches("^[A-Za-z]+$")) {
            throw new IllegalArgumentException("Name should contain only letters");
        }
    }

    private void validatePin(int pin) {
        if (String.valueOf(pin).length() != 4 || !String.valueOf(pin).matches("^[0-9]+$")) {
            throw new IllegalArgumentException("PIN must be exactly 4 digits");
        }
    }

    private void checkActiveAccount() {
        if (activeAccount == null) {
            throw new IllegalStateException("No active account");
        }
    }
}