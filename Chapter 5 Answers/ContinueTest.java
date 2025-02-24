public class ContinueTest {
    public static void main(String[] args) {
        for (int count = 1; count <= 10; count++) { 
            if (count != 5) {  
                System.out.printf("%d ", count);
            }
        }

        System.out.printf("%nUsed structured equivalent to skip printing 5%n");
    } 
}