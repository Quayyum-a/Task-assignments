public class DiamondPrinting {
    public static void main(String[] args) {
        int numberOfRows = 5; 

        
        for (int currentRow = 1; currentRow <= numberOfRows; currentRow++) {
            
            for (int spaceCount = 1; spaceCount <= numberOfRows - currentRow; spaceCount++) {
                System.out.print(" ");
            }
            
            for (int starCount = 1; starCount <= 2 * currentRow - 1; starCount++) {
                System.out.print("*");
            }
            System.out.println(); 
        }

        
        for (int currentRow = numberOfRows - 1; currentRow >= 1; currentRow--) {
            
            for (int spaceCount = 1; spaceCount <= numberOfRows - currentRow; spaceCount++) {
                System.out.print(" ");
            }
            
            for (int starCount = 1; starCount <= 2 * currentRow - 1; starCount++) {
                System.out.print("*");
            }
            System.out.println(); 
        }
    }
}
