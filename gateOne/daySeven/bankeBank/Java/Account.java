package daySeven.bankeBank.Java;

public class Account {
    private final String firstName;
    private final String lastName;
    private final String accountNumber;
    private int pin;
    private double balance;

    public Account(String firstName, String lastName, int pin, String accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = 0.0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean verifyPin(int inputPin) {
        return this.pin == inputPin;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }
        balance += amount;
    }

    public void withdraw(double amount, int inputPin) {
        if (!verifyPin(inputPin)) {
            throw new IllegalArgumentException("Incorrect PIN");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    public void changePin(int oldPin, int newPin) {
        if (!verifyPin(oldPin)) {
            throw new IllegalArgumentException("Old PIN is incorrect");
        }
        if (newPin == oldPin) {
            throw new IllegalArgumentException("New PIN cannot be the same as the old PIN");
        }
        if (String.valueOf(newPin).length() != 4) {
            throw new IllegalArgumentException("New PIN must be exactly 4 digits");
        }
        this.pin = newPin;
    }
}