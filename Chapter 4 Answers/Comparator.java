import java.util.Scanner;
	public class Comparator {
		public static void main(String[] args){
			Scanner entry = new Scanner(System.in);
			
			System.out.print("Enter first number to compare: ");
			int value1 = entry.nextInt();
			System.out.print("Enter second number to compare: ");
			int value2 = entry.nextInt();
			
			if (value1 == value2){
				System.out.println("0");
				}else if (value1 > value2){
				System.out.println("1");
				}
				else if (value1 < value2){
				System.out.println("-1");}
				
			
			
			
		}
	
	}