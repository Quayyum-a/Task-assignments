import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello, kindly enter your card details to verify:");
        String cardNumber = input.nextLine();


        String cardType = "";
        if (cardNumber.startsWith("4")) {
            cardType = "Visa Card";
        } else if (cardNumber.startsWith("5")) {
            cardType = "MasterCard";
        } else if (cardNumber.startsWith("37")) {
            cardType = "American Express Card";
        } else if (cardNumber.startsWith("6")) {
            cardType = "Discover Card";
        } else {
            cardType = "Invalid Card";
        }


        int sum1 = 0;
        int sum2 = 0;
        int total = 0;


        boolean doubleDigit = false;

        for (int count = cardNumber.length() - 1; count >= 0; count--) {
            char ch = cardNumber.charAt(count);
            if (!Character.isDigit(ch)) {
                System.out.println("Invalid input. Please enter numeric characters only.");
                return;
            }

            int digit = Character.getNumericValue(ch);

            if (doubleDigit) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum1 += digit;

            doubleDigit = !doubleDigit;
        }

        total = sum1 + sum2;

        String validity = "Invalid";
        if (total % 10 == 0) {
            validity = "Valid";
        }
            System.out.println("\nCredit Card Type: " + cardType);
            System.out.println("Credit Card Number: " + cardNumber);
            System.out.println("Credit Card Digit Length: " + cardNumber.length());
            System.out.println("Credit Card Validity Status: " + validity);
    }
}