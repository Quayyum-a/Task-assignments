import java.util.Scanner;
public class AccountTest {
    public static void main(String[] args) {

        Account account1 = new Account("Jane Green", 50.00);
        Account account2 = new Account("John Blue", -7.53);

        String s = displayAccount(account1);
        System.out.println(s);

        String d = displayAccount(account2);
        System.out.println(d);


        Scanner input = new Scanner(System.in);

        System.out.print("Enter deposit amount for account1: ");
        double depositAmount = input.nextDouble();
        System.out.printf("%nadding %.2f to account1 balance%n%n", depositAmount);
        account1.deposit(depositAmount);

        s = displayAccount(account1); // Update the display string
        System.out.println(s);

        System.out.print("Enter deposit amount for account2:");
        depositAmount = input.nextDouble();
        System.out.printf("%nAdding %.2f to account2 balance%n%n", depositAmount);
        account2.deposit(depositAmount);

        d = displayAccount(account2); // Update the display string
        System.out.println(d);





    }
    public static String displayAccount(Account accountToDisplay) {
        return String.format("%s balance: $%.2f", accountToDisplay.getName(), accountToDisplay.getBalance());
    }
}
