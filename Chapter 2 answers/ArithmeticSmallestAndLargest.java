import java.util.Scanner;

public class ArithmeticSmallestAndLargest {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
int max = 0;
int min = 0;

    System.out.print("Enter first integer: ");
    int number1 = input.nextInt();

    System.out.print("Enter second integer: ");
    int number2 = input.nextInt();

    System.out.print("Enter third integer: ");
    int number3 = input.nextInt();

    int sum = number1 + number2 + number3;
    int average = sum / 3;
    int product = number1 * number2 * number3;
    
    if(number1 > number2 && number1 > number3){
      max = number1;
  }
  else if(number2 > number1 && number2 > number3){
      max = number2;
  }
  else if(number3 > number1 && number3 > number2){
      max = number3;
  }
  if(number1 < number2 && number1 < number3){
      min = number1;
  }
  else if(number2 < number1 && number2 < number3){
      min = number2;
  }
  else if(number3 < number1 && number3 < number2){
      min = number3;
  }
    System.out.printf("Sum is %d%n", sum);
    System.out.printf("Average is %d%n", average);
    System.out.printf("Product is %d%n", product);
    System.out.printf("Smallest is %d%n", min);
    System.out.printf("Largest is %d%n", max);
    input.close();
  }
}
