package daySeven.bankeBank;

public class BankeApp {
    private String firstName;
    private String lastName;
    private int pin;
    private double balance;
    private boolean accountExists;

    public void createAccount(String firstName, String lastName, int pin) {
        if (!firstName.matches("^[A-Za-z]+$")) {
            throw new IllegalArgumentException("First name should contain only letters");
        }
        if (!lastName.matches("^[A-Za-z]+$")) {
            throw new IllegalArgumentException("Last name should contain only letters");
        }
        if (String.valueOf(pin).length() != 4 || !String.valueOf(pin).matches("^[0-9]+$")) {
            throw new IllegalArgumentException("PIN must be exactly 4 digits");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.balance = 0;
        this.accountExists = true;
    }

    public String getAccount() {
        if (!accountExists) {
            throw new IllegalStateException("No active account");
        }
        return firstName + " " + lastName;
    }

    public void closeAccount() {
        if (!accountExists) {
            throw new IllegalStateException("No active account to close");
        }
        accountExists = false;
        balance = 0;
    }

    public void deposit(double amount) {
        if (!accountExists) {
            throw new IllegalStateException("No active account");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }
        balance += amount;
    }

    public void withdraw(double amount, int enteredPin) {
        if (!accountExists) {
            throw new IllegalStateException("No active account");
        }
        if (enteredPin != pin) {
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

    public double getBalance() {
        if (!accountExists) {
            throw new IllegalStateException("No active account");
        }
        return balance;
    }

    public void transfer(BankeApp recipient, double amount, int enteredPin) {
        if (!accountExists) {
            throw new IllegalStateException("No active account");
        }
        if (!recipient.accountExists) {
            throw new IllegalArgumentException("Recipient account does not exist");
        }
        if (enteredPin != pin) {
            throw new IllegalArgumentException("Incorrect PIN");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than zero");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
        recipient.deposit(amount);
    }

    public void changePin(int oldPin, int newPin) {
        if (!accountExists) {
            throw new IllegalStateException("No active account");
        }
        if (oldPin != pin) {
            throw new IllegalArgumentException("Old PIN is incorrect");
        }
        if (String.valueOf(newPin).length() != 4 || !String.valueOf(newPin).matches("^[0-9]+$")) {
            throw new IllegalArgumentException("New PIN must be exactly 4 digits");
        }
        pin = newPin;
    }

    public boolean verifyPin(int enteredPin) {
        if(enteredPin != pin){
            throw new IllegalArgumentException("PIN is incorrect");
        }
        return true;
    }

    public boolean accountExists() {
        return accountExists;
    }
}
