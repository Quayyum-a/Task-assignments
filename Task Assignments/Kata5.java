import java.util.Scanner;
	public class Kata5 {

	public static int factorOf(int number){
		int count = 0; 

        for (int integer = 1; integer <= number; integer++) {
            if (number % integer == 0) { 
                count++; 
            }
        }
        return count;
}

	
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        
        System.out.print("Enter an integer: ");
        int entry = scanner.nextInt(); 
        
     
        if (entry <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int factors = factorOf(entry); 
            System.out.println("The number of factors of " + entry + " is: " + factors);
        
        
        
    }
}










}
