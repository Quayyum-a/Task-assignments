import java.util.Scanner;

	class SquareArithmetic {
	public static void main(String[] args) {

	Scanner scanner = new Scanner (System.in);

	System.out.println("Enter First Integer: ");
	int firstinteger = scanner.nextInt();

	System.out.println("Enter Second Integer: ");
	int secondinteger = scanner.nextInt();

int firstsquare = firstinteger * firstinteger;
int secondsquare = secondinteger * secondinteger;

	int sum = firstsquare + secondsquare;
	int difference = firstsquare - secondsquare;
	
	System.out.println("The square of first integer is: " + firstsquare);
	System.out.println("The square of second integer is: " + secondsquare);
	System.out.println("The sum of the squares is: " + sum);
System.out.println("The difference between squares is: " + difference);



 }
 
}