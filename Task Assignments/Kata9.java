import java.util.Scanner;
public class Kata9 {

	public static long squareOf(int number) {
	return number * number;
}

	public static void main(String[] args) {

	Scanner scanner = new Scanner (System.in);


System.out.println("Enter an integer to calculate the square: ");
	int entry = scanner.nextInt();

	long result = squareOf(entry);


	System.out.println("The square of " + entry + " is " + result);

}

 }