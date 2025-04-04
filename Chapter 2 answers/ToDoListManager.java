import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager {

    private static ArrayList<Object> tasks = new ArrayList<>();

    public static String getAppHeading() {
        return "To-Do List Manager";
    }

    public static String getMainMenu() {
        return """
            \n1. Add a task
            2. View tasks
            3. Mark task as complete
            4. Delete a task
            5. Exit""";
    }

    public static int getUserChoice(Scanner scanner) {
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();
            if (input.matches("[1-5]")) {
                return Integer.parseInt(input);
            }
            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }
    }

    public static void addNewTask(Scanner scanner) {
        System.out.print("Enter the task description: ");
        String taskDescription = scanner.nextLine().trim();
        if (taskDescription != null && !taskDescription.isEmpty()) {
            tasks.add((taskDescription));
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Error: Task description cannot be empty.");
        }
    }

    public static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is currently empty.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                Object task = tasks.get(i);
                String status = task.isCompleted() ? "[x]" : "[]";
                System.out.println((i + 1) + ". " + status + " " + task.getDescription());
            }
        }
    }

    public static void markTaskAsComplete(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks available to mark as completed.");
            return;
        }

        while (true) {
            System.out.print("Enter the task number to mark as complete: ");
            String input = scanner.nextLine().trim();
            try {
                int taskNumber = Integer.parseInt(input) - 1;
                if (taskNumber >= 0 && taskNumber < tasks.size()) {
                    tasks.get(taskNumber).setCompleted(true);
                    System.out.println("Task '" + tasks.get(taskNumber).getDescription() + "' marked as complete.");
                    break;
                } else {
                    System.out.println("Invalid task number. Please enter a valid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    public static void removeTask(String input) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to delete.");
            return;
        }

        try {
            int taskNumber = Integer.parseInt(input) - 1;
            if (taskNumber >= 0 && taskNumber < tasks.size()) {
                Task deletedTask = tasks.remove(taskNumber);
                System.out.println("Task '" + deletedTask.getDescription() + "' deleted successfully.");
            } else {
                System.out.println("Invalid task number. Please enter a valid number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number.");
        }
    }

    public static ArrayList<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public static void exitApplication() {
        System.out.println("\nExiting the app. Goodbye!");
    }

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println(getAppHeading());

        while (true) {
            System.out.println(getMainMenu());
            int userChoice = getUserChoice(userInputScanner);

            switch (userChoice) {
                case 1:
                    addNewTask(userInputScanner);
                    break;
                case 2:
                    displayTasks();
                    break;
                case 3:
                    markTaskAsComplete(userInputScanner);
                    break;
                case 4:
                    System.out.print("Enter the task number to delete: ");
                    removeTask(userInputScanner.nextLine());
                    break;
                case 5:
                    exitApplication();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}