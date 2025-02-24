import java.util.Scanner;
	
	public class HealthApplication {
	public static void main(String[] args) {
	

	double pound = 0.45359237;
	double inch = 0.0254;

	Scanner scanner = new Scanner (System.in);
	
	System.out.print(" Enter weight in pounds: ");
	double weight = scanner.nextDouble();

	System.out.print("Enter height in inches: ");
	double height = scanner.nextDouble();

	double kilogram = weight * 0.45359237;
	double meters = height * 0.0254;

	double bmi = kilogram / (meters * meters);

	System.out.printf("The BMI is %.2f", bmi);



}

}