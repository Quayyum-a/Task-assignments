import java.util.Scanner;

	class PalindromeInteger {
	public static void main(String[] args) {

	Scanner scanner = new Scanner (System.in);

	System.out.println("Enter a three digit Integer: ");
	int firstinteger = scanner.nextInt();

	int extractone = firstinteger % 10;
	int extracttwo = firstinteger / 10;
	int extractthree = extracttwo % 10;
	int extractfour = extracttwo / 10;
	
	if (extractone == extractfour) {
	System.out.println( + firstinteger + ":  is a Palindrome integer!");
}

	else {
	System.out.println("It is not a Palindrome integer");
}

 }

}