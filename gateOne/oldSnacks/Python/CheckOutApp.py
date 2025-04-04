from datetime import datetime

def main():
    total_price = 0.0
    purchased_items = []

    print("\nWhat is the customer's name? ")
    customer_name = input()

    response = "yes"
    while response.lower() == "yes":
        print("What did the customer buy? ")
        product_name = input()

        while True:
            print("How many pieces? ")
            try:
                quantity = int(input())
                if quantity > 0:
                    break
                else:
                    print("Pieces must be a positive number. Try again.")
            except ValueError:
                print("That is not a number. Please try again.")

        while True:
            print("How much per unit? ")
            try:
                unit_price = float(input())
                if unit_price > 0:
                    break
                else:
                    print("Price must be a positive number. Try again.")
            except ValueError:
                print("That is not a valid number. Please try again.")

        product_total = quantity * unit_price
        total_price += product_total

        purchased_items.append(f"{'ITEM':<10} {'QTY':<5} {'PRICE':<10} {'TOTAL':<10}")
        purchased_items.append(f"{product_name:<10} {quantity:<5} {unit_price:<10.2f} {product_total:<10.2f}")
        print(f"Added {product_name} (x{quantity}) - Total: {product_total:.2f}")

        print("Add more items? (yes/no): ")
        response = input().lower()
        while response not in ["yes", "no"]:
            print("Please type 'yes' or 'no': ")
            response = input().lower()

    print("What is the cashier's name? ")
    cashier_name = input()

    while True:
        print("Enter discount percentage (if any): ")
        try:
            discount_percentage = float(input())
            if discount_percentage >= 0:
                break
            else:
                print("Discount cannot be negative. Try again.")
        except ValueError:
            print("That is not a valid number. Please try again.")

    discount = (discount_percentage / 100) * total_price
    vat = 0.1750 * total_price
    final_price = total_price - discount + vat

    print("\n<<< SEMICOLON STORE >>>")
    print("MAIN BRANCH")
    print("LOCATION: 312, HERBERT MACAULAY WAY, SABO-YABA, LAGOS")
    print("TEL: 03293828343")
    print("Date:", datetime.now().strftime("%Y-%m-%d %H:%M:%S"))
    print("Cashier:", cashier_name)
    print("Customer:", customer_name)
    print("-------------------------------------------------------------")
    print("Items Purchased:")
    for item in purchased_items:
        print(item)
    print("-------------------------------------------------------------")
    print(f"\nSubtotal: {total_price:.2f}")
    print(f"Discount: -{discount:.2f}")
    print(f"VAT (17.50%): +{vat:.2f}")
    print("-------------------------------------------------------------")
    print(f"Bill Total: {final_price:.2f}")
    print("-------------------------------------------------------------")
    print(f"THIS IS NOT A RECEIPT, KINDLY PAY: {final_price:.2f}")
    print("-------------------------------------------------------------")

    while True:
        print("How much are you paying? ")
        try:
            payment = float(input())
            if payment >= final_price:
                break
            print("That amount is too low. Try again.")
        except ValueError:
            print("That is not a valid number. Please try again.")

    balance = payment - final_price
    print(f"Change: {balance:.2f}")

    print("-------------------------------------------------------------")
    print("Thank you for shopping at SEMICOLON STORE!")
    print("-------------------------------------------------------------")

if __name__ == "__main__":
    main()