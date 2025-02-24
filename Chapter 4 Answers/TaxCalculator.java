import java.util.Scanner;
	public class TaxCalculation {
		public static void main(String[] args){
			Scanner entry = new Scanner(System.in);
			
			int count = 0;
			
			while (count < 3) {
				System.out.print("Enter the name of citizen: ");
				String name = entry.next();
				
				System.out.print("Enter the earnings of " + name + ": ");
				double earnings = entry.nextDouble();
				
				double tax;
            if (earnings <= 30000) {
                tax = earnings * 0.15; 
            } else {
                tax = (30000 * 0.15) + ((earnings - 30000) * 0.20);
            }

            
            System.out.printf("%s's total tax is: $%.2f%n", name, tax);

            count++;
        }
			}
		}
	