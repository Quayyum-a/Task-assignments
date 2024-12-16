import java.util.Scanner;
	public class Kata1{

public static boolean isEven(int number) {
        return number % 2 == 0;  
    }

	public static void main(String[] args) {
       
	Scanner scanner = new Scanner(System.in);

	System.out.println("Enter an integer");
	int entry = scanner.nextInt();

        System.out.println("is " + entry + " an even number? "  + isEven(entry));
   
    
    }
}
