class Account {
  #firstName;
  #lastName;
  #accountNumber;
  #balance;
  #pin;

  constructor(firstName, lastName, accountNumber, pin) {
      this.#firstName = firstName;
      this.#lastName = lastName;
      this.#accountNumber = accountNumber;
      this.#balance = 0.0;
      this.#pin = String(pin); // Store PIN as string
  }

  getFirstName() {
      return this.#firstName;
  }

  getLastName() {
      return this.#lastName;
  }

  getAccountNumber() {
      return this.#accountNumber;
  }

  getBalance() {
      return this.#balance;
  }

  deposit(amount) {
      if (amount <= 0) {
          throw new Error("Deposit amount must be greater than zero");
      }
      if (isNaN(amount)) {
          throw new Error("Deposit amount must be a number");
      }
      this.#balance += amount;
  }

  withdraw(amount, pin) {
      if (amount <= 0) {
          throw new Error("Withdrawal amount must be greater than zero");
      }
      if (isNaN(amount)) {
          throw new Error("Withdrawal amount must be a number");
      }
      if (amount > this.#balance) {
          throw new Error("Insufficient balance");
      }
      if (!this.verifyPin(pin)) {
          throw new Error("Incorrect PIN");
      }
      this.#balance -= amount;
  }

  changePin(oldPin, newPin) {
      if (String(oldPin) !== String(this.#pin)) {
          throw new Error("Old PIN is incorrect");
      }
      if (String(newPin) === String(oldPin)) {
          throw new Error("New PIN must be different from old PIN");
      }
      if (!/^[0-9]{4}$/.test(String(newPin))) {
          throw new Error("New PIN must be exactly 4 digits");
      }
      this.#pin = String(newPin);
  }

  verifyPin(pin) {
      return String(pin) === String(this.#pin);
  }
}

module.exports = Account;