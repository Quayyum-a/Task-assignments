import java.util.Scanner;

	public class MeterToPing {
	public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);

	System.out.print("Enter Square Meter: ");
	double squareMeter = scanner.nextDouble();

	double ping = squareMeter * 0.3025;
	System.out.println("Ping is: " + ping);





 }

}