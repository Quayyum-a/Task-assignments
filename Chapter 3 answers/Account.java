public class Account {
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        if(balance > 0.0){
            this.balance = balance;
        }
    }
    public void deposit(double depositAmount) {
        if(depositAmount > 0){
            balance += depositAmount;
        }
    }
    public double getBalance() {
        return balance;
    }
    public String withdraw(double withdrawalAmount) {
        if(withdrawalAmount > 0 && withdrawalAmount <= balance){
            balance -= withdrawalAmount;
            String done = "Withdrawal successful";
            return done;
        }

        return "Withdrawal amount exceeded account balance.";
    }
    public void setName(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

}


