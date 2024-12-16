import java.util.Scanner;

	public class Kata8 {

	public static void main(String [] args){

	Scanner scanner = new Scanner(System.in);



	System.out.println("Enter integer to get its factorial: ");
int entry = scanner.nextInt();

	int result = 1;

	for (int count = 1; count <= entry; count++){	
	result *= count;
}
	System.out.print(result);





}
}