import java.util.Scanner;

	public class LargestAndSmallest {
	public static void main(String[] args) {

	Scanner scanner = new Scanner (System.in);

	System.out.print("Enter First Integer: ");
	int number1 = scanner.nextInt();

	System.out.print("Enter Second Integer: ");
	int number2 = scanner.nextInt();

	System.out.print("Enter Third Integer: ");
	int number3 = scanner.nextInt();

	System.out.print("Enter Fourth Integer: ");
	int number4 = scanner.nextInt();
	
	System.out.print("Enter Fifth Integer: ");
	int number5 = scanner.nextInt();

	int smallest;
        
        if (number1 <= number2 && number1 <= number3 && number1 <= number4 && number1 <= number5) {
            smallest = number1;
        } else if (number2 <= number1 && number2 <= number3 && number2 <= number4 && number2 <= number5) {
            smallest = number2;
        } else if (number3 <= number1 && number3 <= number2 && number3 <= number4 && number3 <= number5) {
            smallest = number3;
        }  else if (number4 <= number1 && number4 <= number2 && number4 <= number3 && number4 <= number5) {
            smallest = number4;
	  }  else {
            smallest = number5;
	  }
		System.out.println(" The smallest value is " + smallest);
	
	int largest;
        
        if (number1 >= number2 && number1 >= number3 && number1 >= number4 && number1 >= number5) {
            largest = number1;
        } else if (number2 >= number1 && number2 >= number3 && number2 >= number4 && number2 >= number5) {
            largest = number2;
        } else if (number3 >= number1 && number3 >= number2 && number3 >= number4 && number3 >= number5) {
            largest = number3;
        }  else if (number4 >= number1 && number4 >= number2 && number4 >= number3 && number4 >= number5) {
            largest = number4;
	  }  else {
            largest = number5;
	  }
		System.out.println("The Largest value is " + largest);


}

}