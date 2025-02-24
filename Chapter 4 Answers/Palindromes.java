import java.util.Scanner;

	class PalindromeInteger {
	public static void main(String[] args) {

	Scanner scanner = new Scanner (System.in);

	System.out.println("Enter a five digit Integer: ");
	int firstinteger = scanner.nextInt();

	int extractone = firstinteger / 10000;
	int extracttwo = firstinteger % 10000;
	int extractthree = extracttwo / 1000;
	int extractfour = extracttwo % 1000;
	int extractfive = extractfour / 100;
	int extractsix = extractfour % 100;
	int extractseven = extractsix / 10;
	int extracteight = extractsix % 10;
	
	if (extractone == extracteight && extractthree == extractseven) {
	System.out.println( + firstinteger + ": is a Palindrome integer!");
}

	else {
	System.out.println("Please enter a valid integer");
}

 }

}