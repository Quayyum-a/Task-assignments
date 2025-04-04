import java.util.Scanner;

public class ComparingIntegers {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter an integer: ");
    int number = input.nextInt();

    int square = number * number;

    compareToHundred(number, "number");
    compareToHundred(square, "square of the number");

    input.close();
  }

  private static void compareToHundred(int value, String description) {
    if (value > 100) {
      System.out.println("The " + description + " is greater than 100");
    } else if (value < 100) {
      System.out.println("The " + description + " is less than 100");
    } else {
      System.out.println("The " + description + " is equal to 100");
    }

    if (value != 100) {
      System.out.println("The " + description + " is not equal to 100");
    }
  }
}