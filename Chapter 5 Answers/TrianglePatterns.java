public class TrianglePatterns {
    public static void main(String[] args) {
        int number = 10;

        
        for (int index = 1; index <= number; index++) {
            for (int count = 1; count <= index; count++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        
        for (int index = number; index >= 1; index--) {
            for (int count = 1; count <= index; count++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        
        for (int index = number; index >= 1; index--) {
            for (int count = 1; count <= number - index; count++) {
                System.out.print(" ");
            }
            for (int count = 1; count <= index; count++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        
        for (int index = 1; index <= number; index++) {
            for (int count = 1; count <= number - index; count++) {
                System.out.print(" ");
            }
            for (int count = 1; count <= index; count++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
