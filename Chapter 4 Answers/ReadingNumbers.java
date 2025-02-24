import java.util.Scanner;

public class ReadingNumbers {
    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);

        System.out.print("Enter the target number: ");
        int target = entry.nextInt(); 

        int sum = 0;   
        int count = 0; 

        while (sum < target) { 
            System.out.print("Enter an integer: ");
            int value = entry.nextInt();

            sum += value; 
            count++; 

            
        }

        System.out.println("The sum of the numbers (" + sum + ") has reached or exceeded the target (" + target + ").");
        System.out.println("You entered " + count + " numbers.");
        System.out.println("Thank you for using!");
    }
}
