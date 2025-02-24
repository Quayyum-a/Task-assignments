import java.util.Scanner;
	public class Physics {
	public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);

	System.out.print("Enter value for Vo: ");
	double value1 = scanner.nextDouble();

	System.out.print("Enter value for V1: ");
	double value2 = scanner.nextDouble();

	System.out.print("Enter value for Time taken T: ");
	double time = scanner.nextDouble();


	double acceleration = (value2 - value1) / time;
	System.out.print("The Average Acceleration value is : " + acceleration);







 }


}