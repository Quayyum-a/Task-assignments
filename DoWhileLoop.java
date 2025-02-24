import java.util.Scanner;

public class DoWhileLoop {
    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("Enter The Miles Driven: ");
            int miles = scanner.nextInt();

            System.out.println("Enter Gallon used: ");
            int gallon = scanner.nextInt();

            double result = (miles * gallon) / 2.352;
            System.out.println("The miles per gallon obtained is: " + result);

            System.out.println("Do you want to repeat the Process?");
            System.out.println("Enter 1 to continue and -1 to stop ");
            count = scanner.nextInt();
        } while (count != -1);
    }
}
