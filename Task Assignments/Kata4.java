import java.util.Scanner;
public class Kata4 {

	public static float divide(float number1, float number2){
	
if (number1 == 0 || number2 == 0){
System.out.println("0");
        return Float.NaN;
}

	return number1 / number2;
}

	public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);

	System.out.println("Enter an integer: ");
		float entry1 = scanner.nextFloat();
		System.out.println("Enter an integer: ");
		float entry2 = scanner.nextFloat();
	

	float result = divide(entry1, entry2);


System.out.print( " is the quotient");


}

}