package oldSnacks.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckOutApp {
    public static void main(String... args) {
        Scanner input = new Scanner(System.in);

        double totalPrice = 0.0;
        List<String> purchasedItems = new ArrayList<>();

        System.out.println("\nWhat is the customer's name? ");
        String customerName = input.nextLine();

        String response = "yes";
        while (response.equalsIgnoreCase("yes")) {
            System.out.println("What did the customer buy? ");
            String productName = input.nextLine();

            int quantity = 0;
            while (true) {
                System.out.println("How many pieces? ");
                try {
                    quantity = Integer.parseInt(input.nextLine());
                    if (quantity > 0) break;
                    else System.out.println("Pieces must be a positive number. Try again.");
                } catch (NumberFormatException e) {
                    System.out.println("That is not a number. Please try again.");
                }
            }

            double unitPrice = 0.0;
            while (true) {
                System.out.println("How much per unit? ");
                try {
                    unitPrice = Double.parseDouble(input.nextLine());
                    if (unitPrice > 0) break;
                    else System.out.println("Price must be a positive number. Try again.");
                } catch (NumberFormatException e) {
                    System.out.println("That is not a valid number. Please try again.");
                }
            }

            double productTotal = quantity * unitPrice;
            totalPrice += productTotal;

            purchasedItems.add(String.format("%-10s %-5s %-10s %-10s", "ITEM", "QTY", "PRICE", "TOTAL"));
            purchasedItems.add(String.format("%-10s %-5d %-10.2f %-10.2f", productName, quantity, unitPrice, productTotal));
            System.out.printf("Added %s (x%d) - Total: %.2f%n", productName, quantity, productTotal);

            System.out.println("Add more items? (yes/no): ");
            response = input.nextLine();
            while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
                System.out.println("Please type 'yes' or 'no': ");
                response = input.nextLine();
            }
        }

        System.out.println("What is the cashier's name? ");
        String cashierName = input.nextLine();

        double discountPercentage = 0.0;
        while (true) {
            System.out.println("Enter discount percentage (if any): ");
            try {
                discountPercentage = Double.parseDouble(input.nextLine());
                if (discountPercentage >= 0) break;
                else System.out.println("Discount cannot be negative. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid number. Please try again.");
            }
        }

        double discount = (discountPercentage / 100) * totalPrice;
        double vat = 0.1750 * totalPrice;
        double finalPrice = totalPrice - discount + vat;

        System.out.println("\n<<< SEMICOLON STORE >>>");
        System.out.println("MAIN BRANCH");
        System.out.println("LOCATION: 312, HERBERT MACAULAY WAY, SABO-YABA, LAGOS");
        System.out.println("TEL: 03293828343");
        System.out.println("Date: " + java.time.LocalDateTime.now());
        System.out.println("Cashier: " + cashierName);
        System.out.println("Customer: " + customerName);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Items Purchased:");
        for (String item : purchasedItems) {
            System.out.println(item);
        }
        System.out.println("-------------------------------------------------------------");
        System.out.printf("\nSubtotal: %.2f%n", totalPrice);
        System.out.printf("Discount: -%.2f%n", discount);
        System.out.printf("VAT (17.50%%): +%.2f%n", vat);
        System.out.println("-------------------------------------------------------------");
        System.out.printf("Bill Total: %.2f%n", finalPrice);
        System.out.println("-------------------------------------------------------------");
        System.out.printf("THIS IS NOT A RECEIPT, KINDLY PAY: %.2f%n", finalPrice);
        System.out.println("-------------------------------------------------------------");

        double payment = 0.0;
        while (true) {
            System.out.println("How much are you paying? ");
            try {
                payment = Double.parseDouble(input.nextLine());
                if (payment >= finalPrice) break;
                System.out.println("That amount is too low. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid number. Please try again.");
            }
        }

        double balance = payment - finalPrice;
        System.out.printf("Change: %.2f%n", balance);

        System.out.println("-------------------------------------------------------------");
        System.out.println("Thank you for shopping at SEMICOLON STORE!");
        System.out.println("-------------------------------------------------------------");

        input.close();
    }
}
