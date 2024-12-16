import java.util.Scanner;
	public class Kata3{

		public static int subtract(int number1, int number2) {
		return Math.abs(number1 - number2);
}
public static void main(String[] args){

	Scanner scanner = new Scanner(System.in);

		System.out.println("Enter an integer: ");
		int entry1 = scanner.nextInt();
		System.out.println("Enter an integer: ");
		int entry2 = scanner.nextInt();

	int result = subtract(entry1, entry2);

		System.out.print("The difference of the two numbers is " + result);








}
}