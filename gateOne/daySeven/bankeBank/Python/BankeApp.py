import random
import re
from Account import Account

class BankeApp:
    def __init__(self):
        self._accounts = {}
        self._active_account = None

    def create_account(self, first_name, last_name, pin):
        self._validate_name(first_name)
        self._validate_name(last_name)
        self._validate_pin(pin)
        account_number = self._generate_account_number()
        new_account = Account(first_name, last_name, pin, account_number)
        self._accounts[account_number] = new_account
        self._active_account = new_account
        return account_number

    def login(self, account_number, pin):
        account = self._accounts.get(account_number)
        if account is None:
            raise ValueError("Account not found")
        if not account.verify_pin(pin):
            raise ValueError("Incorrect PIN")
        self._active_account = account

    def logout(self):
        self._active_account = None

    def deposit(self, amount):
        self._check_active_account()
        self._active_account.deposit(amount)

    def withdraw(self, amount, pin):
        self._check_active_account()
        self._active_account.withdraw(amount, pin)

    def get_balance(self):
        self._check_active_account()
        return self._active_account.get_balance()

    def transfer(self, recipient_account_number, amount, pin):
        self._check_active_account()
        recipient = self._accounts.get(recipient_account_number)
        if recipient is None:
            raise ValueError("Recipient account does not exist")
        if recipient_account_number == self._active_account.get_account_number():
            raise ValueError("Cannot transfer to the same account")
        self._active_account.withdraw(amount, pin)
        recipient.deposit(amount)

    def change_pin(self, old_pin, new_pin):
        self._check_active_account()
        self._active_account.change_pin(old_pin, new_pin)

    def verify_pin(self, pin):
        self._check_active_account()
        return self._active_account.verify_pin(pin)

    def close_account(self, pin):
        self._check_active_account()
        if not self._active_account.verify_pin(pin):
            raise ValueError("Incorrect PIN")
        del self._accounts[self._active_account.get_account_number()]
        self._active_account = None

    def get_account_name(self):
        self._check_active_account()
        return f"{self._active_account.get_first_name()} {self._active_account.get_last_name()}"

    def get_account_number(self):
        self._check_active_account()
        return self._active_account.get_account_number()

    def get_account_count(self):
        return len(self._accounts)

    def _generate_account_number(self):
        return str(1000000000 + random.randint(0, 900000000))

    def _validate_name(self, name):
        if not re.match("^[A-Za-z]+$", name):
            raise ValueError("Name should contain only letters")

    def _validate_pin(self, pin):
        if len(str(pin)) != 4 or not str(pin).isdigit():
            raise ValueError("PIN must be exactly 4 digits")

    def _check_active_account(self):
        if self._active_account is None:
            raise ValueError("No active account")