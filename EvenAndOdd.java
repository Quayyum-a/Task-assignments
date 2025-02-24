import java.util.Scanner;

public class EvenAndOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int odd = 0;
        int even = 0;

        System.out.println("Enter the number of integers you want to input: ");
        int numbers = scanner.nextInt();

        for (int integer = 1; integer <= numbers; integer++) {
            System.out.println("Enter integer " + integer + " :");
            int number1 = scanner.nextInt();

            if (number1 % 2 == 0) {
                even += number1;
            } else {
                odd += number1;
            }
        }

        System.out.println("Sum of even numbers: " + even);
        System.out.println("Sum of odd numbers: " + odd);
    }
}