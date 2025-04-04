import java.util.Scanner;

	public class Arithmetic {
	public static void main(String[] args) {

	Scanner scanner = new Scanner (System.in);

	System.out.print("Enter First Integer: ");
	int number1 = scanner.nextInt();

	System.out.print("Enter Second Integer: ");
	int number2 = scanner.nextInt();

	System.out.print("Enter Third Integer: ");
	int number3 = scanner.nextInt();

	int sum = number1 + number2 + number3;
	System.out.println("The sum of the numbers is " + sum);

	double average = sum / 3;
	System.out.println("The average of the numbers is " + average);

	double product = number1 * number2 * number3;
	System.out.println("The product of the numbers is " + product);

	int smallest;
        
        if (number1 <= number2 && number1 <= number3) {
            smallest = number1;
        } else if (number2 <= number1 && number2 <= number3) {
            smallest = number2;
        } else {
            smallest = number3;
        }
	System.out.println("The smallest number is " + smallest);
	

	int largest;
        
        if (number1 >= number2 && number1 >= number3) {
            largest = number1;
        } else if (number2 >= number1 && number2 >= number3) {
            largest = number2;
        } else {
            largest = number3;
        }
	System.out.println("The largest number is " + largest);





 }

  public static int sumOfSquare(int i, int j) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'sumOfSquare'");
  }

  public int DifferenceOfSum(int i, int j) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'DifferenceOfSum'");
  }

}