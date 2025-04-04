import java.util.Scanner;

public class CreditLimitCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input customer details
        System.out.print("Enter account number: ");
        int accountNumber = input.nextInt();

        System.out.print("Enter balance at the beginning of the month: ");
        int balance = input.nextInt();

        System.out.print("Enter total items charged this month: ");
        int totalItemsCharged = input.nextInt();

        System.out.print("Enter total of credit applied to the customer this month: ");
        int totalCredit = input.nextInt();

        System.out.print("Enter allowed credit limit: ");
        int creditLimit = input.nextInt();

        // Calculate new balance
        int newBalance = balance + totalItemsCharged - totalCredit;

        // Display new balance
        System.out.printf("New balance for account %d: $%d%n", accountNumber, newBalance);

        // Check if credit limit is exceeded
        if (newBalance > creditLimit) {
            System.out.println("Credit limit exceeded!");
        } else {
            System.out.println("Credit limit not exceeded.");
        }

         // Close the scanner
    }
}