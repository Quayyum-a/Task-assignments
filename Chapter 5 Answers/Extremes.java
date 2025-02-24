import java.util.Scanner;
	public class Extremes {
		public static void main(String[] args ){
			Scanner entry = new Scanner(System.in);
			
			int count = 0;
			int sum = 0;
			int largest = Integer.MIN_VALUE;
			int smallest = Integer.MAX_VALUE;
			
			System.out.println("How many numbers do you want to input: ");
			int value1 = entry.nextInt();
			
			while (count < value1){
				System.out.println("Enter integer: ");
				int value2 = entry.nextInt();
					if (value2 > largest){
						largest = value2;
					}
					if (value2 < smallest){
						smallest = value2;
					}
				sum = largest + smallest;
				count++;
			}
			System.out.println("The sum of " + largest + " and " + smallest + " is " + sum);
		}
	}