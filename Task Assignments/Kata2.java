import java.util.Scanner;
	public class Kata2{

public static boolean isPrime(int number) {

 if (number <= 1) return false;
        for (int prime = 2; prime <= Math.sqrt(number); prime++) {
            if (number % prime == 0) return false; 
        }
        return true;
    }


public static void main(String[] args){

	Scanner scanner = new Scanner(System.in);

	System.out.println("Enter an integer");
	int entry = scanner.nextInt();

        System.out.println("is " + entry + " a prime number? "  + isPrime(entry));

}

}