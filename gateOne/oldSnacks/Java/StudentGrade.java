import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();
        System.out.print("Enter the number of subjects: ");
        int numSubjects = input.nextInt();

        System.out.println("Saving >>>>>>>>>>>>>>>>>>>>");
        System.out.println("Saved successfully");

        int[][] grades = new int[numStudents][numSubjects];
        int[] totals = new int[numStudents];
        int[] subjectPasses = new int[numSubjects];
        int[] subjectFailures = new int[numSubjects];

        for (int student = 0; student < numStudents; student++) {
            for (int subject = 0; subject < numSubjects; subject++) {
                int grade;
                while (true) {
                    System.out.print("Enter grade for student " + (student + 1) + " in subject " + (subject + 1) + ": ");
                    grade = input.nextInt();
                    if (grade >= 0 && grade <= 100) {
                        grades[student][subject] = grade;
                        System.out.println("Saving >>>>>>>>>>>>>>>>>>>>");
                        System.out.println("Saved successfully");

                        if (grade >= 50) {
                            subjectPasses[subject]++;
                        } else {
                            subjectFailures[subject]++;
                        }
                        break;
                    } else {
                        System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
                    }
                }
                totals[student] += grades[student][subject];
            }
        }

        System.out.println("======================================================================================================");
        System.out.print("Student\t\t");
        for (int count = 1; count <= numSubjects; count++) {
            System.out.print("Subject " + count + "\t");
        }
        System.out.println("Total\t\tAverage\t\tPosition");
        System.out.println("======================================================================================================");

        int[] positions = new int[numStudents];
        for (int count = 0; count < numStudents; count++) {
            positions[count] = 1;
        }
        for (int count = 0; count < numStudents; count++) {
            for (int counter = 0; counter < numStudents; counter++) {
                if (totals[count] < totals[counter]) {
                    positions[count]++;
                }
            }
        }

        for (int student = 0; student < numStudents; student++) {
            System.out.print("Student " + (student + 1) + "\t\t");
            for (int subject = 0; subject < numSubjects; subject++) {
                System.out.print(grades[student][subject] + "\t\t");
            }
            double average = (double) totals[student] / numSubjects;
            System.out.println(totals[student] + "\t\t" + average + "\t\t" + positions[student]);
        }

        
        System.out.println("\nSUBJECT SUMMARY");
        for (int subject = 0; subject < numSubjects; subject++) {
            int highestScore = 0;
            int lowestScore = 100;
            int highestStudent = 0;
            int lowestStudent = 0;
            int totalScore = 0;

            for (int student = 0; student < numStudents; student++) {
                int score = grades[student][subject];
                totalScore += score;

                if (score > highestScore) {
                    highestScore = score;
                    highestStudent = student + 1;
                }
                if (score < lowestScore) {
                    lowestScore = score;
                    lowestStudent = student + 1;
                }
            }

            double averageScore = (double) totalScore / numStudents;

            System.out.println("Subject " + (subject + 1));
            System.out.println("Highest scoring student is: Student " + highestStudent + " scoring " + highestScore);
            System.out.println("Lowest scoring student is: Student " + lowestStudent + " scoring " + lowestScore);
            System.out.println("Total Score is: " + totalScore);
            System.out.printf("Average score is: %.2f\n", averageScore);
            System.out.println("Number of passes: " + subjectPasses[subject]);
            System.out.println("Number of Fails: " + subjectFailures[subject]);
            System.out.println();
        }

        int hardestSubject = 0, easiestSubject = 0;
        for (int subject = 1; subject < numSubjects; subject++) {
            if (subjectFailures[subject] > subjectFailures[hardestSubject]) {
                hardestSubject = subject;
            }
            if (subjectPasses[subject] > subjectPasses[easiestSubject]) {
                easiestSubject = subject;
            }
        }

        int highestScore = Integer.MIN_VALUE, lowestScore = Integer.MAX_VALUE;
        int highestStudent = 0, lowestStudent = 0;
        int highestSubject = 0, lowestSubject = 0;

        for (int student = 0; student < numStudents; student++) {
            for (int subject = 0; subject < numSubjects; subject++) {
                if (grades[student][subject] > highestScore) {
                    highestScore = grades[student][subject];
                    highestStudent = student;
                    highestSubject = subject;
                }
                if (grades[student][subject] < lowestScore) {
                    lowestScore = grades[student][subject];
                    lowestStudent = student;
                    lowestSubject = subject;
                }
            }
        }

        int bestStudent = 0, worstStudent = 0;
        for (int student = 1; student < numStudents; student++) {
            if (totals[student] > totals[bestStudent]) {
                bestStudent = student;
            }
            if (totals[student] < totals[worstStudent]) {
                worstStudent = student;
            }
        }

        int classTotal = 0;
        for (int total : totals) {
            classTotal += total;
        }
        double classAverage = (double) classTotal / (numStudents * numSubjects);

        System.out.printf("The hardest subject is Subject %d with %d failures\n", hardestSubject + 1, subjectFailures[hardestSubject]);
        System.out.printf("The easiest subject is Subject %d with %d passes\n", easiestSubject + 1, subjectPasses[easiestSubject]);
        System.out.printf("The overall Highest score is scored by Student %d in subject %d scoring %d\n", highestStudent + 1, highestSubject + 1, highestScore);
        System.out.printf("The overall Lowest score is scored by Student %d in subject %d scoring %d\n", lowestStudent + 1, lowestSubject + 1, lowestScore);
        System.out.println("======================================================================================================\n");
        System.out.println("");
        System.out.println("\nCLASS SUMMARY");
        System.out.println("======================================================================================================");
        System.out.printf("Best Graduating Student is: Student %d scoring %d\n", bestStudent + 1, totals[bestStudent]);
        System.out.println("======================================================================================================\n");
        System.out.println("");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.printf("Worst Graduating Student is: Student %d scoring %d\n", worstStudent + 1, totals[worstStudent]);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
        System.out.println("");
        System.out.println("======================================================================================================");
        System.out.printf("Class total score is: %d\n", classTotal);
        System.out.printf("Class Average score is: %.2f\n", classAverage);
        System.out.println("======================================================================================================");

        input.close(); 
    }
}
