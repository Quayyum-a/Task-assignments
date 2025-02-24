import java.util.Scanner;
 public class CreditLimitCalculator {
		public static void main(String[] args){
			Scanner entry = new Scanner(System.in);
			int count = 0;
			
			do {
				System.out.print("Enter your Account Number: ");
				int account = entry.nextInt();
				
				System.out.print("Enter the Begining Balance of the month: ");
				int beginingBalance = entry.nextInt();
				
				System.out.print("Enter total items charged by the customer: ");
				int charges = entry.nextInt();
				
				System.out.print("Enter total credits applied to the customer's account this month: ");
				int creditApplied = entry.nextInt();
				
				System.out.print("Enter your Allowed credit limit: ");
				int creditLimit = entry.nextInt();
				
				int newBalance = beginingBalance + charges - creditApplied;
						System.out.println("Your new balance is " + newBalance);
						
			if (newBalance > creditLimit){
					System.out.println("You are Good!");
				}else{
					System.out.println("Credit Limit Exceeded!");
				}
				
				System.out.println("Do you want to check for another customer?");
				System.out.println("Enter 1 to continue or -1 to stop: ");
            count = entry.nextInt();
				
			}while (count != -1);
			
			
						System.out.println("Thank you!");
						
						
						
			
		}
 }