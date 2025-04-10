from BankeApp import BankeApp


class BankeAppMain:
    bank = BankeApp()
    scanner = input  # Using Python's input function instead of Scanner

    @staticmethod
    def main():
        running = True
        while running:
            print("\n===== Banke Banking System =====")
            print("1. Create New Account")
            print("2. Access Existing Account")
            print("3. Exit")
            print("Enter your choice: ", end="")

            try:
                choice = BankeAppMain.get_int_input(1, 3)
                if choice == 1:
                    BankeAppMain.create_new_account()
                elif choice == 2:
                    BankeAppMain.access_account()
                elif choice == 3:
                    running = False
                    print("Thank you for using Banke Banking System!")
            except ValueError as e:
                print(f"Error: {e}")

    @staticmethod
    def create_new_account():
        print("\n=== Create New Account ===")

        first_name = BankeAppMain.scanner("Enter First Name: ").strip()
        while not first_name:
            print("First name cannot be empty. Please try again.")
            first_name = BankeAppMain.scanner("Enter First Name: ").strip()

        last_name = BankeAppMain.scanner("Enter Last Name: ").strip()
        while not last_name:
            print("Last name cannot be empty. Please try again.")
            last_name = BankeAppMain.scanner("Enter Last Name: ").strip()

        valid_pin = False
        pin = 0
        while not valid_pin:
            try:
                pin = BankeAppMain.get_int_input(1000, 9999, "Create a 4-digit PIN: ")
                valid_pin = True
            except ValueError as e:
                print(f"Error: PIN must be exactly 4 digits (1000-9999)")

        try:
            account_number = BankeAppMain.bank.create_account(first_name, last_name, pin)
            print("\nAccount created successfully!")
            print(f"Your account number is: {account_number}")
            print("Please save this number for future access.")
        except ValueError as e:
            print(f"Error: {e}")

    @staticmethod
    def access_account():
        print("\n=== Access Account ===")
        account_number = BankeAppMain.scanner("Enter your account number: ").strip()

        valid_pin = False
        pin = 0
        while not valid_pin:
            try:
                pin = BankeAppMain.get_int_input(1000, 9999, "Enter your PIN: ")
                valid_pin = True
            except ValueError as e:
                print(f"Error: PIN must be exactly 4 digits (1000-9999)")

        try:
            BankeAppMain.bank.login(account_number, pin)
            BankeAppMain.account_menu()
        except ValueError as e:
            print(f"Error: {e}")

    @staticmethod
    def account_menu():
        logged_in = True
        while logged_in:
            print("\n=== Account Menu ===")
            print(f"Account Holder: {BankeAppMain.bank.get_account_name()}")
            print(f"Account Number: {BankeAppMain.bank.get_account_number()}")
            print("1. Check Balance")
            print("2. Deposit")
            print("3. Withdraw")
            print("4. Transfer Funds")
            print("5. Change PIN")
            print("6. Close Account")
            print("7. Logout")
            print("Enter your choice: ", end="")

            try:
                choice = BankeAppMain.get_int_input(1, 7)
                if choice == 1:
                    BankeAppMain.check_balance()
                elif choice == 2:
                    BankeAppMain.deposit()
                elif choice == 3:
                    BankeAppMain.withdraw()
                elif choice == 4:
                    BankeAppMain.transfer()
                elif choice == 5:
                    BankeAppMain.change_pin()
                elif choice == 6:
                    BankeAppMain.close_account()
                    logged_in = False
                elif choice == 7:
                    BankeAppMain.bank.logout()
                    logged_in = False
                    print("Logged out successfully.")
            except ValueError as e:
                print(f"Error: {e}")

    @staticmethod
    def check_balance():
        try:
            print(f"Current Balance: ${BankeAppMain.bank.get_balance()}")
        except ValueError as e:
            print(f"Error: {e}")

    @staticmethod
    def deposit():
        valid_amount = False
        while not valid_amount:
            try:
                amount = BankeAppMain.get_positive_double_input("Enter deposit amount: $")
                BankeAppMain.bank.deposit(amount)
                print(f"Deposit successful. New balance: ${BankeAppMain.bank.get_balance()}")
                valid_amount = True
            except ValueError as e:
                print(f"Error: {e}")

    @staticmethod
    def withdraw():
        valid_input = False
        while not valid_input:
            try:
                amount = BankeAppMain.get_positive_double_input("Enter withdrawal amount: $")
                pin = BankeAppMain.get_int_input(1000, 9999, "Enter your PIN: ")
                BankeAppMain.bank.withdraw(amount, pin)
                print(f"Withdrawal successful. New balance: ${BankeAppMain.bank.get_balance()}")
                valid_input = True
            except ValueError as e:
                print(f"Error: {e}")

    @staticmethod
    def transfer():
        valid_input = False
        while not valid_input:
            try:
                recipient_number = BankeAppMain.scanner("Enter recipient's account number: ").strip()
                amount = BankeAppMain.get_positive_double_input("Enter transfer amount: $")
                pin = BankeAppMain.get_int_input(1000, 9999, "Enter your PIN: ")
                BankeAppMain.bank.transfer(recipient_number, amount, pin)
                print(f"Transfer successful. New balance: ${BankeAppMain.bank.get_balance()}")
                valid_input = True
            except ValueError as e:
                print(f"Error: {e}")

    @staticmethod
    def change_pin():
        valid_input = False
        while not valid_input:
            try:
                old_pin = BankeAppMain.get_int_input(1000, 9999, "Enter current PIN: ")
                new_pin = BankeAppMain.get_int_input(1000, 9999, "Enter new 4-digit PIN: ")
                BankeAppMain.bank.change_pin(old_pin, new_pin)
                print("PIN changed successfully.")
                valid_input = True
            except ValueError as e:
                print(f"Error: {e}")

    @staticmethod
    def close_account():
        confirmation = BankeAppMain.scanner("Are you sure you want to close your account? (yes/no): ").strip().lower()
        if confirmation == "yes":
            valid_input = False
            while not valid_input:
                try:
                    pin = BankeAppMain.get_int_input(1000, 9999, "Enter your PIN to confirm: ")
                    BankeAppMain.bank.close_account(pin)
                    print("Account closed successfully.")
                    valid_input = True
                except ValueError as e:
                    print(f"Error: {e}")
        else:
            print("Account closure cancelled.")

    @staticmethod
    def get_int_input(min_val, max_val, prompt=""):
        while True:
            try:
                value = int(BankeAppMain.scanner(prompt))
                if value < min_val or value > max_val:
                    raise ValueError(f"Input must be between {min_val} and {max_val}")
                return value
            except ValueError as e:
                if str(e).startswith("Input must be between"):
                    print(f"Error: {e}")
                else:
                    print("Invalid input. Please enter a valid number.")

    @staticmethod
    def get_positive_double_input(prompt):
        while True:
            try:
                value = float(BankeAppMain.scanner(prompt))
                if value <= 0:
                    raise ValueError("Amount must be greater than zero")
                return value
            except ValueError as e:
                if str(e).startswith("Amount must be greater"):
                    print(f"Error: {e}")
                else:
                    print("Invalid input. Please enter a valid amount.")


if __name__ == "__main__":
    BankeAppMain.main()