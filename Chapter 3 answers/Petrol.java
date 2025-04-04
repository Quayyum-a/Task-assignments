import java.util.Scanner;

public class Petrol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the location of the Petrol station: ");
        String location = scanner.nextLine();

        System.out.println("Enter the fuel type (Petrol, Diesel, Ethanol): ");
        String fuelType = scanner.nextLine();

        System.out.println("Enter the quantity of fuel purchased: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the price per unit of fuel: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter the discount percentage (if applicable): ");
        double discount = scanner.nextDouble();

        PetrolPurchase p = new PetrolPurchase(location, fuelType, quantity, price, discount);
        System.out.println("Purchase Amount: " + p.getPurchaseAmount());

    }
}
