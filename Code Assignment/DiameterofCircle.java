import java.util.Scanner;
	public class DiameterofCircle {
	public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	double pi = 3.14159;
	System.out.print("Enter value for radius: ");
	double radius = scanner.nextDouble();


	System.out.printf("diameter = %.2f%n", 2 * radius);

	System.out.printf("circumference = %.2f%n", 2 *  pi * radius);

	System.out.printf("diameter = %.2f%n", pi * radius * radius);






 }

}