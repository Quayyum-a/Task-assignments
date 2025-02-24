import java.util.Scanner;
	public class Divisible {
	public static void main(String[] args) {

	Scanner scanner = new Scanner (System.in);
	System.out.print("Enter an integer: ");
	double number1 = scanner.nextDouble();
	
	double divisible = number1 / 3;

	double remainder = divisible % 3;

	if ( remainder <= 0 ) {
	System.out.println("It is a divisible number!");
}
	else {
	System.out.print("It is not a divisible number!");


	}




 }

}