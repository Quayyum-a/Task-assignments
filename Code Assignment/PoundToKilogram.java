import java.util.Scanner;

	public class PoundToKilogram {
	public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
 
	System.out.print("Enter a value: ");
	double pound = scanner.nextDouble();

double kilogram = pound * 0.454;
	System.out.printf("The kilogram in pound is " + kilogram);



}



}