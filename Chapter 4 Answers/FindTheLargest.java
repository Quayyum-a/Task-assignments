import java.util.Scanner;
	public class FindTheLargest{
			public static void main(String[] args){
				Scanner entry = new Scanner(System.in);
				
				int counter = 1;
				int largest = Integer.MIN_VALUE;
				
				while (counter < 10){
					System.out.println("Enter unit sold " + counter);
					int number = entry.nextInt();
										
					if (number > largest){
							largest = number;
					}
					counter++;
				}
					
						
						System.out.println("The largest integer of the 10 integers is " + largest);
					
				
			}
	}