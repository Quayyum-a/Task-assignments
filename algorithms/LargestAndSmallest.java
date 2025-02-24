package algorithms;

import java.util.Scanner;

public class LargestAndSmallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of integers you want to input: ");
        int count = scanner.nextInt();
        
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        
        for (int i = 1; i <= count; i++) {
            System.out.printf("Enter number %d: ", i);
            int number = scanner.nextInt();
            
            if (number < smallest) {
                smallest = number;
            }
            if (number > largest) {
                largest = number;
            }
        }
        
        System.out.println("Smallest number: " + smallest);
        System.out.println("Largest number: " + largest);
    }
}
