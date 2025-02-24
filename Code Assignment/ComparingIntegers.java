import java.util.Scanner;

	public class ComparingIntegers {
	public static void main(String[] args) {
	int compare = 100;
	

	Scanner scanner = new Scanner(System.in);

	System.out.print("Enter an integer: ");
	int value = scanner.nextInt();

	if (value > compare) {
	System.out.println(value + " is greater than 100");
	}
	if (value == compare) {
	System.out.println(value + " is equal to 100");
	}
	if (value != compare) {
	System.out.println(value + " is not equal to 100");
	}
	if (value < compare) {
	System.out.println(value + " is less than 100");
	}
	double square = value * value;
	

	if (square > compare) {
	System.out.println(square + " is greater than 100");
	}
	if (square == compare) {
	System.out.println(square + " is equal to 100");
	}
	if (square != compare) {
	System.out.println(square + " is not equal to 100");
	}
	if (square < compare) {
	System.out.print(square + " is less than 100");
	}





}

}