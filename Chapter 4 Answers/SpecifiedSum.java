import java.util.Scanner;

public class SpecifiedSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        int sumOfEntry = 0; 
        
        System.out.print("Enter a number: ");
        int entry = input.nextInt();
        
        for (count = 1; count <= entry; count++) { 
            System.out.println("Enter integer no." + count + ": ");
            int response = input.nextInt(); 
            
            sumOfEntry += response; 
            
            if (sumOfEntry == entry) {
                System.out.println("The initial number has been met.");
                break; 
            }
        }

        if (sumOfEntry > entry) {
            System.out.println("The sum is now larger than the initial number.");
        }

        
    }
}
