import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int countA = 0, countB = 0, countC = 0, countD = 0;
        
       
        for (int index = 1; index <= 5; index++) {
            System.out.print("Enter the name of student " + index + ": ");
            String studentName = scanner.nextLine(); 

            System.out.print("Enter the grade for " + studentName + " (A, B, C, D): ");
            char grade = scanner.nextLine().toUpperCase().charAt(0); 

            
            switch (grade) {
                case 'A':
                    countA++;
                    break;
                case 'B':
                    countB++;
                    break;
                case 'C':
                    countC++;
                    break;
                case 'D':
                    countD++;
                    break;
                default:
                    System.out.println("Invalid grade entered for " + studentName + ". Skipping.");
                    break;
            }
        }
        
       
       System.out.println("");
        System.out.println("Number of students with grade A: " + countA);
        System.out.println("Number of students with grade B: " + countB);
        System.out.println("Number of students with grade C: " + countC);
        System.out.println("Number of students with grade D: " + countD);

        
    }
}
