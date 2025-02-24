import java.util.Scanner;

public class BarChart {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers between 1 and 30:");

        
        for (int count = 0; count < numbers.length; count++) {
            numbers[count] = input.nextInt();
            if (numbers[count] < 1 || numbers[count] > 30) {
                System.out.println("Invalid input. Enter a number between 1 and 30.");
                count--;
            }
        }

        System.out.println("Bar Chart:");

        
        for (int num : numbers) {
            for (int index = 0; index < num; index++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}