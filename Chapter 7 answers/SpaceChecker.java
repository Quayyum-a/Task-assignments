import java.util.Scanner;

public class SpaceChecker{
	public static void main(String... args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your Favourite quote >> ");
		String word = input.nextLine();
		
		int numSpaces = 0;
		
		for (int count = 0; count < word.length(); count++){
			char ch = word.charAt(count);
			if (ch == ' '){
				numSpaces++;
			}
			
		}
		
		System.out.println("The number of spaces is " + numSpaces);
input.close();
		
		
	}
}

