import java.util.Scanner;

 	public class AreaOfTriangle {
	public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter a corordinate point (x1): ");
	double x1 = scanner.nextDouble();

System.out.println("Enter first corordinate point (x2): ");
	double x2 = scanner.nextDouble();

	System.out.println("Enter a corordinate point (x3): ");
	double x3 = scanner.nextDouble();




System.out.println("Enter a corordinate point (y1): ");
	double y1 = scanner.nextDouble();

System.out.println("Enter a corordinate point (y2): ");
	double y2 = scanner.nextDouble();

System.out.println("Enter a corordinate point (y3): ");
	double y3 = scanner.nextDouble();



double side1 = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);

 double side2 = Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2);

 double side3 = Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2);


  double s = (side1 + side2 + side3) / 2;

 double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

	System.out.println("The area of a Triangle is" + area);
  }



}