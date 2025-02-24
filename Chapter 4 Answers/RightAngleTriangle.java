import java.util.Scanner;
	public class RightAngleTriangle {
		public static void main(String[] args){
			Scanner entry = new Scanner(System.in);
			
			System.out.println("Enter base lenght within 1 - 10: ");
			int base = entry.nextInt();
			
			if (base > 10 || base < 1){
				System.out.println("Please enter a valid base!");
			}else {
					  for (int row = 1; row <= base; row++) {
                
                for (int astericRow = 1; astericRow <= row; astericRow++) {
                    System.out.print("*");
                }
                
                System.out.println();
            }
				
			}
		}
	}