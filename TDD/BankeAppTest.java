import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankeAppTest {
    @Test
    public void test_ValidAccountCreation() {
        BankeApp app = new BankeApp();
        app.createAccount("Alice", "Johnson", 1234);
        assertEquals("Alice Johnson", app.getAccount());
    }

    @Test
    public void test_FirstNameInvalid() {
        BankeApp app = new BankeApp();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.createAccount("Al!ce7", "Johnson", 1234);
        });
        assertEquals("First name should contain only letters", exception.getMessage());
    }

    @Test
    public void test_LastNameInvalid() {
        BankeApp app = new BankeApp();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.createAccount("Alice", "J0hnson@", 1234);
        });
        assertEquals("Last name should contain only letters", exception.getMessage());
    }

    @Test
    public void test_PinNotFourDigits() {
        BankeApp app = new BankeApp();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.createAccount("Alice", "Johnson", 12345);
        });
        assertEquals("PIN must be exactly 4 digits", exception.getMessage());
    }

    @Test
    public void test_CloseAccountSuccessfully() {
        BankeApp app = new BankeApp();
        app.createAccount("John", "Doe", 1234);
        app.closeAccount();
        assertFalse(app.accountExists());
    }

    @Test
    public void test_CloseNonExistentAccount() {
        BankeApp app = new BankeApp();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            app.closeAccount();
        });
        assertEquals("No active account to close", exception.getMessage());
    }

    @Test
    public void test_DepositValidAmount() {
        BankeApp app = new BankeApp();
        app.createAccount("John", "Doe", 1234);
        app.deposit(5000);
        assertEquals(5000, app.getBalance());
    }

    @Test
    public void test_DepositNegativeAmount() {
        BankeApp app = new BankeApp();
        app.createAccount("John", "Doe", 1234);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.deposit(-100);
        });
        assertEquals("Deposit amount must be greater than zero", exception.getMessage());
    }

    @Test
    public void test_DepositZero() {
        BankeApp app = new BankeApp();
        app.createAccount("John", "Doe", 1234);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.deposit(0);
        });
        assertEquals("Deposit amount must be greater than zero", exception.getMessage());
    }

    @Test
    public void test_DepositOnNonExistingAccount() {
        BankeApp app = new BankeApp();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            app.deposit(5000);
    });
       assertEquals("No active account",exception.getMessage());
    }

    @Test
    public void test_WithdrawValidAmount() {
        BankeApp app = new BankeApp();
        app.createAccount("John", "Doe", 1234);
        app.deposit(5000);
        app.withdraw(2000, 1234);
        assertEquals(3000, app.getBalance());
    }

    @Test
    public void test_WithdrawMoreThanBalance() {
        BankeApp app = new BankeApp();
        app.createAccount("John", "Doe", 1234);
        app.deposit(2000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.withdraw(3000, 1234);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    public void test_WithdrawNegativeAmount() {
        BankeApp app = new BankeApp();
        app.createAccount("John", "Doe", 1234);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.withdraw(-1000, 1234);
        });
        assertEquals("Withdrawal amount must be greater than zero", exception.getMessage());
    }

    @Test
    public void test_WithdrawZero() {
        BankeApp app = new BankeApp();
        app.createAccount("John", "Doe", 1234);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.withdraw(0, 1234);
        });
        assertEquals("Withdrawal amount must be greater than zero", exception.getMessage());
    }

    @Test
    public void test_WithdrawWrongPin() {
        BankeApp app = new BankeApp();
        app.createAccount("John", "Doe", 1234);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.withdraw(1000, 5678);
        });
        assertEquals("Incorrect PIN", exception.getMessage());
    }

    @Test
    public void test_WithdrawFromNonExistingAccount(){
        BankeApp app = new BankeApp();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            app.withdraw(1000, 1234);
        });
        assertEquals("No active account", exception.getMessage());
    }

    @Test
    public void test_CheckBalance() {
        BankeApp app = new BankeApp();
        app.createAccount("John", "Doe", 1234);
        app.deposit(2000);
        assertEquals(2000, app.getBalance());
    }

    @Test
    public void test_CheckBalance_NoAccount() {
        BankeApp app = new BankeApp();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            app.getBalance();
        });
        assertEquals("No active account", exception.getMessage());
    }


    @Test
    public void test_SuccessfulTransfer() {
        BankeApp sender = new BankeApp();
        BankeApp receiver = new BankeApp();

        sender.createAccount("John", "Doe", 1234);
        receiver.createAccount("Alice", "Smith", 5678);

        sender.deposit(5000);
        sender.transfer(receiver, 3000, 1234);

        assertEquals(2000, sender.getBalance());
        assertEquals(3000, receiver.getBalance());
    }

    @Test
    public void test_TransferMoreThanBalance() {
        BankeApp sender = new BankeApp();
        BankeApp receiver = new BankeApp();

        sender.createAccount("John", "Doe", 1234);
        receiver.createAccount("Alice", "Smith", 5678);

        sender.deposit(2000);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sender.transfer(receiver, 3000, 1234);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    public void test_TransferNegativeAmount() {
        BankeApp sender = new BankeApp();
        BankeApp receiver = new BankeApp();

        sender.createAccount("John", "Doe", 1234);
        receiver.createAccount("Alice", "Smith", 5678);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sender.transfer(receiver, -1000, 1234);
        });
        assertEquals("Transfer amount must be greater than zero", exception.getMessage());

    }

    @Test
    public void test_TransferWithIncorrectPin(){
        BankeApp sender = new BankeApp();
        BankeApp receiver = new BankeApp();

        sender.createAccount("John", "Doe", 1234);
        receiver.createAccount("Alice", "Smith", 5678);

        sender.deposit(5000);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sender.transfer(receiver, 3000, 4321);
        });
        assertEquals("Incorrect PIN", exception.getMessage());
    }

    @Test
    public void test_TransferToNonExistingAccount(){
        BankeApp sender = new BankeApp();
        BankeApp receiver = new BankeApp();

        sender.createAccount("John", "Doe", 1234);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sender.transfer(receiver, 1000, 5678);
        });
        assertEquals("Recipient account does not exist", exception.getMessage());
    }

}