class Account:
    def __init__(self, first_name, last_name, pin, account_number):
        self._first_name = first_name
        self._last_name = last_name
        self._account_number = account_number
        self._pin = pin
        self._balance = 0.0

    def get_first_name(self):
        return self._first_name

    def get_last_name(self):
        return self._last_name

    def get_account_number(self):
        return self._account_number

    def get_balance(self):
        return self._balance

    def verify_pin(self, input_pin):
        return self._pin == input_pin

    def deposit(self, amount):
        if amount <= 0:
            raise ValueError("Deposit amount must be greater than zero")
        self._balance += amount

    def withdraw(self, amount, input_pin):
        if not self.verify_pin(input_pin):
            raise ValueError("Incorrect PIN")
        if amount <= 0:
            raise ValueError("Withdrawal amount must be greater than zero")
        if amount > self._balance:
            raise ValueError("Insufficient funds")
        self._balance -= amount

    def change_pin(self, old_pin, new_pin):
        if not self.verify_pin(old_pin):
            raise ValueError("Old PIN is incorrect")
        if old_pin == new_pin:
            raise ValueError("New PIN cannot be the same as the old PIN")
        if len(str(new_pin)) != 4:
            raise ValueError("New PIN must be exactly 4 digits")
        self._pin = new_pin