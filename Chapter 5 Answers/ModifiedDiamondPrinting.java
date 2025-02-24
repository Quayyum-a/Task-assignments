import java.util.Scanner;

public class ModifiedDiamondPrinting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfRows;

        while (true) {
            System.out.print("Enter an odd number of rows (1 to 19): ");
            numberOfRows = input.nextInt();

            if (numberOfRows >= 1 && numberOfRows <= 19 && numberOfRows % 2 != 0) {
                break;
            }
            System.out.println("Invalid input. Please enter an odd number between 1 and 19.");
        }

        int middleRow = (numberOfRows + 1) / 2;

        for (int currentRow = 1; currentRow <= middleRow; currentRow++) {
            for (int spaceCount = 1; spaceCount <= middleRow - currentRow; spaceCount++) {
                System.out.print(" ");
            }
            for (int starCount = 1; starCount <= 2 * currentRow - 1; starCount++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int currentRow = middleRow - 1; currentRow >= 1; currentRow--) {
            for (int spaceCount = 1; spaceCount <= middleRow - currentRow; spaceCount++) {
                System.out.print(" ");
            }
            for (int starCount = 1; starCount <= 2 * currentRow - 1; starCount++) {
                System.out.print("*");
            }
            System.out.println();
        }

        
    }
}
