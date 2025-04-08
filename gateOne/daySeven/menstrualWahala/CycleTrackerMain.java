package daySeven.menstrualWahala;

import java.util.Scanner;

public class CycleTrackerMain {
    private static CycleTracker tracker = new CycleTracker();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== Cycle Tracker =====");
            System.out.println("1. Create New Cycle");
            System.out.println("2. Access Existing Cycle");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = getIntInput(1, 3);
                switch (choice) {
                    case 1: createNewCycle(); break;
                    case 2: accessCycle(); break;
                    case 3: running = false; System.out.println("Goodbye!"); break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void createNewCycle() {
        System.out.println("\n=== Create New Cycle ===");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine().trim();
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine().trim();
        try {
            tracker.createCycle(userId, startDate);
            System.out.println("Cycle created for User ID: " + userId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void accessCycle() {
        System.out.println("\n=== Access Cycle ===");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine().trim();
        try {
            tracker.login(userId);
            cycleMenu();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void cycleMenu() {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n=== Cycle Menu ===");
            System.out.println("User ID: " + tracker.getStartDate());
            System.out.println("1. Check Start Date");
            System.out.println("2. Set Cycle Length");
            System.out.println("3. Set Period Duration");
            System.out.println("4. Next Period Date");
            System.out.println("5. Ovulation Date");
            System.out.println("6. Fertile Window");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");

            try {
                int choice = getIntInput(1, 7);
                switch (choice) {
                    case 1: System.out.println("Start Date: " + tracker.getStartDate()); break;
                    case 2: setCycleLength(); break;
                    case 3: setPeriodDuration(); break;
                    case 4: System.out.println("Next Period: " + tracker.calculateNextPeriodDate()); break;
                    case 5: System.out.println("Ovulation: " + tracker.calculateOvulationDate()); break;
                    case 6: System.out.println("Fertile Window Starts: " + tracker.calculateFertileWindow()); break;
                    case 7: tracker.logout(); loggedIn = false; System.out.println("Logged out."); break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void setCycleLength() {
        System.out.print("Enter average cycle length (21-35): ");
        int length = getIntInput(21, 35);
        tracker.setAverageCycleLength(length);
        System.out.println("Cycle length set to " + length + " days.");
    }

    private static void setPeriodDuration() {
        System.out.print("Enter period duration (2-8): ");
        int duration = getIntInput(2, 8);
        tracker.setPeriodDuration(duration);
        System.out.println("Period duration set to " + duration + " days.");
    }

    private static int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input < min || input > max) {
                    throw new IllegalArgumentException("Input must be between " + min + " and " + max);
                }
                return input;
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number between " + min + " and " + max + ".");
                scanner.nextLine();
            }
        }
    }
}