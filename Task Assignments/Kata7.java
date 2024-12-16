import java.util.Scanner;

public class Kata7 {

    public static boolean isPalindrome(int[] number) {
        for (int index = 0; index < number.length / 2; index++) {
            if (number[index] != number[number.length - 1 - index]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] number = new int[5];

        System.out.println("Enter a 5-digit number:");
        int entry = scanner.nextInt(); 


        for (int index = 4; index >= 0; index--) {
            number[index] = entry % 10; 
            entry /= 10;          
        }

        System.out.println("Are the 5 digits Palindrome?: " + isPalindrome(number));
    }
}
