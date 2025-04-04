import java.util.Scanner;

public class GasMilelage{
	public static void main(String... args){
	Scanner input = new Scanner(System.in);
	int count = 0;
	int totalMiles = 0;
	int totalGallons = 0;
	
	System.out.print("How many trips do you want to calculate for: ");
	int trips = input.nextInt();
	
	while (count < trips){
		System.out.print("\nEnter miles driven: ");
		int miles = input.nextInt();
		totalMiles += miles;
		
		System.out.print("Enter gallons used: ");
		int gallons = input.nextInt();
		totalGallons += gallons;
		
		float mpg = miles / gallons;
		
		System.out.print("\nThe miles per gallon for this trip is: " + mpg + "\n");
		count++;
	}
	float total = totalMiles / totalGallons;
	System.out.print("\nThe total miles per gallon for all trips is: " + total);
	
	}
}