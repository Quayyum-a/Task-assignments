import java.util.Scanner;
	
	public class AreaofRectangle {
	public static void main(String []args) {

	Scanner scanner = new Scanner(System.in);

	System.out.print("Enter Width Value: ");
	double width = scanner.nextDouble();

	System.out.print("Enter Height Value: " );
	double height = scanner.nextDouble();

	double area = width * height;
	double perimeter = 2 * width + height;

System.out.println("Value of area is " + area);
System.out.println("Value of Perimeter is " + perimeter);


 }

}