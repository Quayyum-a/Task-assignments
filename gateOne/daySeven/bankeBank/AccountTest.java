package daySeven.bankeBank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void test_CreateAccount_Success() {
        Account account = new Account("John", "Doe", 1234, "1000000001");
        assertEquals("John", account.getFirstName());
        assertEquals("Doe", account.getLastName());
        assertEquals("1000000001", account.getAccountNumber());
        assertEquals(0.0, account.getBalance());
    }

    @Test
    public void test_Deposit_Success() {
        Account account = new Account("John", "Doe", 1234, "1000000001");
        account.deposit(500.0);
        assertEquals(500.0, account.getBalance());
    }

    @Test
    public void test_Deposit_InvalidAmount() {
        Account account = new Account("John", "Doe", 1234, "1000000001");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100.0);
        });
        assertEquals("Deposit amount must be greater than zero", exception.getMessage());
    }

    @Test
    public void test_Withdraw_Success() {
        Account account = new Account("John", "Doe", 1234, "1000000001");
        account.deposit(500.0);
        account.withdraw(200.0, 1234);
        assertEquals(300.0, account.getBalance());
    }

    @Test
    public void test_Withdraw_InvalidAmount() {
        Account account = new Account("John", "Doe", 1234, "1000000001");
        account.deposit(500.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-100.0, 1234);
        });
        assertEquals("Withdrawal amount must be greater than zero", exception.getMessage());
    }

    @Test
    public void test_Withdraw_InsufficientFunds() {
        Account account = new Account("John", "Doe", 1234, "1000000001");
        account.deposit(100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200.0, 1234);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    public void test_Withdraw_IncorrectPin() {
        Account account = new Account("John", "Doe", 1234, "1000000001");
        account.deposit(500.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100.0, 1111);
        });
        assertEquals("Incorrect PIN", exception.getMessage());
    }

    @Test
    public void test_ChangePin_Success() {
        Account account = new Account("John", "Doe", 1234, "1000000001");
        account.changePin(1234, 5678);
        assertTrue(account.verifyPin(5678));
    }

    @Test
    public void test_ChangePin_IncorrectOldPin() {
        Account account = new Account("John", "Doe", 1234, "1000000001");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.changePin(1111, 5678);
        });
        assertEquals("Old PIN is incorrect", exception.getMessage());
    }

    @Test
    public void test_ChangePin_InvalidNewPin() {
        Account account = new Account("John", "Doe", 1234, "1000000001");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.changePin(1234, 56789);
        });
        assertEquals("New PIN must be exactly 4 digits", exception.getMessage());
    }

    @Test
    public void test_VerifyPin_Success() {
        Account account = new Account("John", "Doe", 1234, "1000000001");
        assertTrue(account.verifyPin(1234));
    }

    @Test
    public void test_VerifyPin_Incorrect() {
        Account account = new Account("John", "Doe", 1234, "1000000001");
        assertFalse(account.verifyPin(1111));
    }
}