import unittest
from BankeApp import BankeApp

class BankeAppTest(unittest.TestCase):
    def setUp(self):
        self.bank = BankeApp()
        self.alice_account_number = self.bank.create_account("Alice", "Johnson", 1234)
        self.bob_account_number = self.bank.create_account("Bob", "Smith", 5678)

    def test_create_account(self):
        self.assertEqual(self.bank.get_account_count(), 2)
        self.bank.login(self.alice_account_number, 1234)
        self.assertEqual(self.bank.get_account_name(), "Alice Johnson")

    def test_login_invalid_account(self):
        with self.assertRaises(ValueError) as context:
            self.bank.login("9999999999", 1234)
        self.assertEqual(str(context.exception), "Account not found")

    def test_login_incorrect_pin(self):
        with self.assertRaises(ValueError) as context:
            self.bank.login(self.alice_account_number, 1111)
        self.assertEqual(str(context.exception), "Incorrect PIN")

    def test_deposit(self):
        self.bank.login(self.alice_account_number, 1234)
        self.bank.deposit(1000)
        self.assertEqual(self.bank.get_balance(), 1000)

    def test_deposit_negative_amount(self):
        self.bank.login(self.alice_account_number, 1234)
        with self.assertRaises(ValueError) as context:
            self.bank.deposit(-100)
        self.assertEqual(str(context.exception), "Deposit amount must be greater than zero")

    def test_deposit_zero_amount(self):
        self.bank.login(self.alice_account_number, 1234)
        with self.assertRaises(ValueError) as context:
            self.bank.deposit(0)
        self.assertEqual(str(context.exception), "Deposit amount must be greater than zero")

    def test_get_balance(self):
        self.bank.login(self.alice_account_number, 1234)
        self.bank.deposit(1000)
        self.assertEqual(self.bank.get_balance(), 1000)

    def test_withdraw(self):
        self.bank.login(self.alice_account_number, 1234)
        self.bank.deposit(1000)
        self.bank.withdraw(500, 1234)
        self.assertEqual(self.bank.get_balance(), 500)

    def test_withdraw_incorrect_pin(self):
        self.bank.login(self.alice_account_number, 1234)
        self.bank.deposit(1000)
        with self.assertRaises(ValueError) as context:
            self.bank.withdraw(500, 5678)
        self.assertEqual(str(context.exception), "Incorrect PIN")

    def test_withdraw_insufficient_funds(self):
        self.bank.login(self.alice_account_number, 1234)
        self.bank.deposit(500)
        with self.assertRaises(ValueError) as context:
            self.bank.withdraw(1000, 1234)
        self.assertEqual(str(context.exception), "Insufficient funds")

    def test_withdraw_negative_amount(self):
        self.bank.login(self.alice_account_number, 1234)
        self.bank.deposit(1000)
        with self.assertRaises(ValueError) as context:
            self.bank.withdraw(-500, 1234)
        self.assertEqual(str(context.exception), "Withdrawal amount must be greater than zero")

    def test_withdraw_zero_amount(self):
        self.bank.login(self.alice_account_number, 1234)
        self.bank.deposit(1000)
        with self.assertRaises(ValueError) as context:
            self.bank.withdraw(0, 1234)
        self.assertEqual(str(context.exception), "Withdrawal amount must be greater than zero")

    def test_transfer(self):
        self.bank.login(self.alice_account_number, 1234)
        self.bank.deposit(1000)
        self.bank.transfer(self.bob_account_number, 300, 1234)
        self.assertEqual(self.bank.get_balance(), 700)
        self.bank.login(self.bob_account_number, 5678)
        self.assertEqual(self.bank.get_balance(), 300)

    def test_transfer_to_non_existent_account(self):
        self.bank.login(self.alice_account_number, 1234)
        self.bank.deposit(1000)
        with self.assertRaises(ValueError) as context:
            self.bank.transfer("9999999999", 300, 1234)
        self.assertEqual(str(context.exception), "Recipient account does not exist")

    def test_transfer_to_same_account(self):
        self.bank.login(self.alice_account_number, 1234)
        self.bank.deposit(1000)
        with self.assertRaises(ValueError) as context:
            self.bank.transfer(self.alice_account_number, 300, 1234)
        self.assertEqual(str(context.exception), "Cannot transfer to the same account")

    def test_transfer_incorrect_pin(self):
        self.bank.login(self.alice_account_number, 1234)
        self.bank.deposit(1000)
        with self.assertRaises(ValueError) as context:
            self.bank.transfer(self.bob_account_number, 300, 5678)
        self.assertEqual(str(context.exception), "Incorrect PIN")

    def test_transfer_insufficient_funds(self):
        self.bank.login(self.alice_account_number, 1234)
        self.bank.deposit(500)
        with self.assertRaises(ValueError) as context:
            self.bank.transfer(self.bob_account_number, 1000, 1234)
        self.assertEqual(str(context.exception), "Insufficient funds")

    def test_change_pin(self):
        self.bank.login(self.alice_account_number, 1234)
        self.bank.change_pin(1234, 5678)
        self.assertTrue(self.bank.verify_pin(5678))

    def test_change_pin_incorrect_old_pin(self):
        self.bank.login(self.alice_account_number, 1234)
        with self.assertRaises(ValueError) as context:
            self.bank.change_pin(1111, 5678)
        self.assertEqual(str(context.exception), "Old PIN is incorrect")

    def test_change_pin_invalid_new_pin(self):
        self.bank.login(self.alice_account_number, 1234)
        with self.assertRaises(ValueError) as context:
            self.bank.change_pin(1234, 56789)
        self.assertEqual(str(context.exception), "New PIN must be exactly 4 digits")

    def test_change_pin_same_as_old(self):
        self.bank.login(self.alice_account_number, 1234)
        with self.assertRaises(ValueError) as context:
            self.bank.change_pin(1234, 1234)
        self.assertEqual(str(context.exception), "New PIN cannot be the same as the old PIN")


    def test_close_account(self):
        self.bank.login(self.alice_account_number, 1234)
        self.bank.close_account(1234)
        self.assertEqual(self.bank.get_account_count(), 1)
        with self.assertRaises(ValueError) as context:
            self.bank.get_balance()
        self.assertEqual(str(context.exception), "No active account")

if __name__ == "__main__":
    unittest.main()