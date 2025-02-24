import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter a binary number: ");
        String binary = scanner.nextLine();

        
        int decimalValue = 0;

        
        int positionValue = 1;

        
        for (int i = binary.length() - 1; i >= 0; i--) {
            
            char digit = binary.charAt(i);

            
            if (digit == '1') {
                decimalValue += positionValue;
            }

            
            positionValue *= 2;
        }

        
        System.out.println("The decimal equivalent is: " + decimalValue);
    }
}
