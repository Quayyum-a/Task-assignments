import java.util.Scanner;

public class RaisePower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base number: ");
        int number1 = scanner.nextInt();

        System.out.println("Enter the exponent number: ");
        int number2 = scanner.nextInt();

        int result = 1;
        for (int integer = 1; integer <= number2; integer++) {
            result *= number1;
        }

        System.out.println(number1 + " raised to the power of " + number2 + " is: " + result);
    }
}
