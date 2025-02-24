import java.util.Scanner;

public class SalesCommission {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sales = 0.0; 
        double commissionRate = 0.09; 
        double salary = 200.0; 
        double itemValue;

        System.out.println("Enter the sales of items sold this week.");
        System.out.println("Type -1 to finish entering items.");

        System.out.print("Enter sold item value: ");
        itemValue = scanner.nextDouble();

        while (itemValue != -1) {
            if (itemValue < 0) {
                System.out.println("Invalid value. Please enter a positive number.");
            } else {
                sales += itemValue; 
            }

            System.out.print("Enter sold item value: ");
            itemValue = scanner.nextDouble();
        }

  
        double commission = sales * commissionRate;
        double totalEarnings = salary + commission;

        
        System.out.printf("Total gross sales: %.2f%n", sales);
        System.out.printf("Total earnings: %.2f%n", totalEarnings);

        
    }
}
