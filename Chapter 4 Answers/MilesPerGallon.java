import java.util.Scanner;

public class MilesPerGallon {
    public static void main(String[] args) {
        int totalMiles = 0; 
        int totalGallons = 0; 
        int count = 0; 
		  double totalCombined = 0;
        Scanner scanner = new Scanner(System.in);
	
			System.out.print("Input number of trips covered: ");
			int trips = scanner.nextInt();
			
		for (count = 1; count <= trips; count++){ 
            System.out.print("Input no." + count +  " miles driven: ");
            int miles = scanner.nextInt();
            totalMiles += miles; 

            System.out.print("Input no." + count +  " gallons used: ");
            int gallons = scanner.nextInt();
            totalGallons += gallons; 
				
				float average = (float) totalMiles / totalGallons;
				 totalCombined += average;
				System.out.printf("The average miles and gallons used this trip is: %.2f\n", average);
				System.out.println(" ");
				
      } 
				
				
				System.out.printf("The combined average miles and gallons used all trips: %.2f\n", totalCombined);
        

            System.out.println("Do you want to add more data?");
           System.out.println("Enter 1 to continue or -1 to stop: ");
            count = scanner.nextInt();

	
	
	while (count != -1);

      
        

    scanner.close(); 
    }
}
