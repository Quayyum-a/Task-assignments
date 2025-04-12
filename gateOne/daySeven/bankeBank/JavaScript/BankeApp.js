const Account = require('./Account');

class BankeApp {
    #accounts;
    #activeAccount;

    constructor() {
        this.#accounts = new Map();
        this.#activeAccount = null;
    }

    createAccount(firstName, lastName, pin) {
        this.#validateName(firstName);
        this.#validateName(lastName);
        this.#validatePin(pin);
        const accountNumber = this.#generateAccountNumber();
        const newAccount = new Account(firstName, lastName, accountNumber, pin);
        this.#accounts.set(accountNumber, newAccount);
        this.#activeAccount = newAccount;
        return accountNumber;
    }

    login(accountNumber, pin) {
        const account = this.#accounts.get(accountNumber);
        if (!account) {
            throw new Error("Account not found");
        }
        if (!account.verifyPin(pin)) {
            throw new Error("Incorrect PIN");
        }
        this.#activeAccount = account;
    }

    logout() {
        this.#activeAccount = null;
    }

    deposit(amount) {
        this.#checkActiveAccount();
        if (amount <= 0) {
            throw new Error("Deposit amount must be greater than zero");
        }
        this.#activeAccount.deposit(amount);
    }

    withdraw(amount, pin) {
        this.#checkActiveAccount();
        if (amount <= 0) {
            throw new Error("Withdrawal amount must be greater than zero");
        }
        this.#activeAccount.withdraw(amount, pin);
    }

    getBalance() {
        this.#checkActiveAccount();
        return this.#activeAccount.getBalance();
    }

    transfer(recipientAccountNumber, amount, pin) {
        this.#checkActiveAccount();
        if (amount <= 0) {
            throw new Error("Transfer amount must be greater than zero");
        }
        const recipient = this.#accounts.get(recipientAccountNumber);
        if (!recipient) {
            throw new Error("Recipient account does not exist");
        }
        this.#activeAccount.withdraw(amount, pin);
        recipient.deposit(amount);
    }

    changePin(oldPin, newPin) {
        this.#checkActiveAccount();
        this.#activeAccount.changePin(oldPin, newPin);
    }

    verifyPin(pin) {
        this.#checkActiveAccount();
        return this.#activeAccount.verifyPin(pin);
    }

    closeAccount(pin) {
        this.#checkActiveAccount();
        if (!this.#activeAccount.verifyPin(pin)) {
            throw new Error("Incorrect PIN");
        }
        this.#accounts.delete(this.#activeAccount.getAccountNumber());
        this.#activeAccount = null;
    }

    getAccountName() {
        this.#checkActiveAccount();
        return `${this.#activeAccount.getFirstName()} ${this.#activeAccount.getLastName()}`;
    }

    getAccountNumber() {
        this.#checkActiveAccount();
        return this.#activeAccount.getAccountNumber();
    }

    getAccountCount() {
        return this.#accounts.size;
    }

    #generateAccountNumber() {
        return String(1000000000 + Math.floor(Math.random() * 900000000));
    }

    #validateName(name) {
        if (!/^[A-Za-z]+$/.test(name)) {
            throw new Error("Name should contain only letters");
        }
    }

    #validatePin(pin) {
        if (String(pin).length !== 4 || !/^[0-9]+$/.test(String(pin))) {
            throw new Error("PIN must be exactly 4 digits");
        }
    }

    #checkActiveAccount() {
        if (!this.#activeAccount) {
            throw new Error("No active account");
        }
    }
}

module.exports = BankeApp;