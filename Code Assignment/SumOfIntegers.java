import java.util.Scanner;

	public class SumOfIntegers {
	public static void main(String[] args) {

	Scanner scanner = new Scanner (System.in);

	System.out.print("Enter an integer between 0 to 1000: ");
	int number1 = scanner.nextInt();

	int extract1 = number1 % 10;
		int extract2 = number1 / 10;
		int extract3 = extract2 % 10;
		int extract4 = extract2 / 10;

	int sum = extract1 + extract3 + extract4;

	System.out.println("Sum of all digits is: " + sum);





  }

}