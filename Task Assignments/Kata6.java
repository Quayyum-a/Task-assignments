import java.util.Scanner;
	public class Kata6 {


    public static boolean isSquareNumber(int number) {
        if (number < 0) {
            return false; 

        }

        int sqrt = (int) Math.sqrt(number); 
        return sqrt * sqrt == number; 
	
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        if (isSquareNumber(number)) {
            System.out.println(number + " is a square number." + isSquareNumber(number));
        } else {
            System.out.println(number + " is not a square number."+ isSquareNumber(number));
        }
    }
}
