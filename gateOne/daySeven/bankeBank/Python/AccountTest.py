import unittest
from Account import Account

class AccountTest(unittest.TestCase):
    def test_create_account_success(self):
        account = Account("John", "Doe", 1234, "1000000001")
        self.assertEqual(account.get_first_name(), "John")
        self.assertEqual(account.get_last_name(), "Doe")
        self.assertEqual(account.get_account_number(), "1000000001")
        self.assertEqual(account.get_balance(), 0.0)

    def test_deposit_success(self):
        account = Account("John", "Doe", 1234, "1000000001")
        account.deposit(500.0)
        self.assertEqual(account.get_balance(), 500.0)

    def test_deposit_invalid_amount(self):
        account = Account("John", "Doe", 1234, "1000000001")
        with self.assertRaises(ValueError) as context:
            account.deposit(-100.0)
        self.assertEqual(str(context.exception), "Deposit amount must be greater than zero")

    def test_withdraw_success(self):
        account = Account("John", "Doe", 1234, "1000000001")
        account.deposit(500.0)
        account.withdraw(200.0, 1234)
        self.assertEqual(account.get_balance(), 300.0)

    def test_withdraw_invalid_amount(self):
        account = Account("John", "Doe", 1234, "1000000001")
        account.deposit(500.0)
        with self.assertRaises(ValueError) as context:
            account.withdraw(-100.0, 1234)
        self.assertEqual(str(context.exception), "Withdrawal amount must be greater than zero")

    def test_withdraw_insufficient_funds(self):
        account = Account("John", "Doe", 1234, "1000000001")
        account.deposit(100.0)
        with self.assertRaises(ValueError) as context:
            account.withdraw(200.0, 1234)
        self.assertEqual(str(context.exception), "Insufficient funds")

    def test_withdraw_incorrect_pin(self):
        account = Account("John", "Doe", 1234, "1000000001")
        account.deposit(500.0)
        with self.assertRaises(ValueError) as context:
            account.withdraw(100.0, 1111)
        self.assertEqual(str(context.exception), "Incorrect PIN")

    def test_withdraw_correct_pin(self):
        account = Account("John", "Doe", 1234, "1000000001")
        account.deposit(500.0)
        account.withdraw(100.0, 1234)
        self.assertEqual(account.get_balance(), 400.0)



    def test_change_pin_success(self):
        account = Account("John", "Doe", 1234, "1000000001")
        account.change_pin(1234, 5678)
        self.assertTrue(account.verify_pin(5678))

    def test_change_pin_incorrect_old_pin(self):
        account = Account("John", "Doe", 1234, "1000000001")
        with self.assertRaises(ValueError) as context:
            account.change_pin(1111, 5678)
        self.assertEqual(str(context.exception), "Old PIN is incorrect")

    def test_change_pin_invalid_new_pin(self):
        account = Account("John", "Doe", 1234, "1000000001")
        with self.assertRaises(ValueError) as context:
            account.change_pin(1234, 56789)
        self.assertEqual(str(context.exception), "New PIN must be exactly 4 digits")

    def test_verify_pin_success(self):
        account = Account("John", "Doe", 1234, "1000000001")
        self.assertTrue(account.verify_pin(1234))

    def test_verify_pin_incorrect(self):
        account = Account("John", "Doe", 1234, "1000000001")
        self.assertFalse(account.verify_pin(1111))

if __name__ == "__main__":
    unittest.main()