import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ExpenseTracker {
    private static ArrayList<String[]> expenses = new ArrayList<>();

    public static String getHeader() {
        return "Welcome to Semicolon Expense Tracker App";
    }

    public static String getMenu() {
        return "\n1. Add an expense\n2. View all expenses\n3. Calculate total expenses\n4. Exit";
    }

    public static int getChoice(int choice) {
        if (choice < 1 || choice > 4) { // Fixed validation
            throw new IllegalArgumentException("Invalid choice. Please enter a number between 1 and 4.");
        }
        return choice;
    }

    public static String getDate(Scanner scanner) {
        while (true) {
            System.out.print("Enter date (YYYY-MM-DD): ");
            String date = scanner.nextLine().trim();
            try {
                LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                return parsedDate.toString();
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Try again using YYYY-MM-DD.");
            }
        }
    }

    public static String getDescription(Scanner scanner) {
        while (true) {
            System.out.print("Enter description: ");
            String description = scanner.nextLine().trim();
            if (!description.isEmpty() && description.matches("[a-zA-Z0-9 ]+")) {
                return description;
            }
            System.out.println("Invalid input! Description must contain only letters, numbers, and spaces.");
        }
    }

    public static double getAmount(Scanner scanner) {
        while (true) {
            System.out.print("Enter amount: ");
            try {
                double amount = Double.parseDouble(scanner.nextLine().trim());
                if (amount > 0 && amount <= 1_000_000) {
                    return Math.round(amount * 100.0) / 100.0;
                }
                System.out.println("Amount must be greater than zero and reasonable.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid amount. Please enter a valid number.");
            }
        }
    }

    public static void addExpense(String[] expense) {
        expenses.add(expense);
    }

    public static String viewExpenses() {
        if (expenses.isEmpty()) {
            return "No expenses recorded yet.";
        } else {
            StringBuilder result = new StringBuilder("Expenses:\n");
            for (String[] expense : expenses) {
                result.append("Date: ").append(expense[0]).append(", Description: ").append(expense[1])
                      .append(", Amount: ₦").append(expense[2]).append("\n");  // Fixed currency symbol
            }
            return result.toString().trim();
        }
    }

    public static float calculateExpenses() {
        float total = 0;
        for (String[] expense : expenses) {
            total += Float.parseFloat(expense[2]);
        }
        return total;
    }

    public static String exitApp() {
       return "\nExiting the app. Goodbye!";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getHeader());
        while (true) {
            System.out.println(getMenu());

            int choice;
            while (true) {
                System.out.print("\nEnter your choice: ");
                try {
                    choice = Integer.parseInt(scanner.nextLine().trim());
                    getChoice(choice);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: Invalid choice. Please enter a number between 1 and 4.");
                }
            }

            switch (choice) {
                case 1:
                    String date = getDate(scanner);
                    String description = getDescription(scanner);
                    double amount = getAmount(scanner);

                    addExpense(new String[]{date, description, String.valueOf(amount)});
                    System.out.println("\nExpense added successfully!");
                    break;

                case 2:
                    System.out.println(viewExpenses());
                    break;

                case 3:
                    float total = calculateExpenses();
                    System.out.println("Total expenses: ₦" + total);
                    break;

                case 4:
                    System.out.println(exitApp());
                    return;
            }
        }
    }

    public static String getDescription(String string) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

    public static double getAmount(double d) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getAmount'");
    }
}
