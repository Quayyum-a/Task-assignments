import java.util.Scanner;

	public class FutureInvestmentValue {
	public static void main(String[] args) {
	double monthlyrate = 50;

Scanner scanner = new Scanner(System.in);
	System.out.print("Enter Investment value: ");
	double investmentamount = scanner.nextDouble();

	System.out.print("Enter Annual interest value: ");
	double annualamount = scanner.nextDouble();

	System.out.print("Enter No. of years: ");
	int numberofyears = scanner.nextInt();

double result = investmentamount * 1 + monthlyrate;


	double accumulatedvalue = Math.pow(result, numberofyears * 12);

	System.out.println("The Future Investment Value is " + accumulatedvalue);
	










 }


}