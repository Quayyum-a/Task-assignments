import java.util.Scanner;

public class DistanceBetweenTwoPoints{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the x-coordinate of the first point: ");
        int x1 = input.nextInt();
        System.out.print("Enter the y-coordinate of the first point: ");
        int y1 = input.nextInt();

        
        System.out.print("Enter the x-coordinate of the second point: ");
        int x2 = input.nextInt();
        System.out.print("Enter the y-coordinate of the second point: ");
        int y2 = input.nextInt();

        
        if (x1 == x2) {
            System.out.println("The points on a vertical line are  perpendicular to the x-axis.");
        } else if (y1 == y2) {
            System.out.println("The points on a horizontal line are perpendicular to the y-axis.");
        } else {
            System.out.println("The points do not lie on a line perpendicular to any axis.");
        }

        
    }
}
