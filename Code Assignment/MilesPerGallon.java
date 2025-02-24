import java.util.Scanner;

public class MilesPerGallon {
    public static void main(String[] args) {
        int totalMiles = 0; 
        int totalGallons = 0; 
        int count = 0; 

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter the miles driven: ");
            int miles = scanner.nextInt();
            totalMiles += miles; 

            System.out.println("Enter the gallons used: ");
            int gallons = scanner.nextInt();
            totalGallons += gallons; 
				
				float average = totalMiles / totalGallons;
				System.out.printf("The average miles and gallons used for this trip is ", average);
        

            System.out.println("Do you want to add more data?");
            System.out.println("Enter 1 to continue or -1 to stop: ");
            count = scanner.nextInt();

        } 
	
	while (count != -1);

      
        

       
    }
}
