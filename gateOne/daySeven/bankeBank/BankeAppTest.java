package daySeven.bankeBank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankeAppTest {
    private BankeApp bank;
    private String aliceAccountNumber;
    private String bobAccountNumber;

    @BeforeEach
    public void setup() {
        bank = new BankeApp();
        aliceAccountNumber = bank.createAccount("Alice", "Johnson", 1234);
        bobAccountNumber = bank.createAccount("Bob", "Smith", 5678);
    }

    @Test
    public void testCreateAccount() {
        assertEquals(2, bank.getAccountCount());
        bank.login(aliceAccountNumber, 1234);
        assertEquals("Alice Johnson", bank.getAccountName());
    }

    @Test
    public void testLoginInvalidAccount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.login("9999999999", 1234);
        });
        assertEquals("Account not found", exception.getMessage());
    }

    @Test
    public void testLoginIncorrectPin() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.login(aliceAccountNumber, 1111);
        });
        assertEquals("Incorrect PIN", exception.getMessage());
    }

    @Test
    public void testDeposit() {
        bank.login(aliceAccountNumber, 1234);
        bank.deposit(1000);
        assertEquals(1000, bank.getBalance());
    }

    @Test
    public void testDepositNegativeAmount() {
        bank.login(aliceAccountNumber, 1234);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.deposit(-100);
        });
        assertEquals("Deposit amount must be greater than zero", exception.getMessage());
    }

    @Test
    public void testWithdraw() {
        bank.login(aliceAccountNumber, 1234);
        bank.deposit(1000);
        bank.withdraw(500, 1234);
        assertEquals(500, bank.getBalance());
    }

    @Test
    public void testWithdrawIncorrectPin() {
        bank.login(aliceAccountNumber, 1234);
        bank.deposit(1000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.withdraw(500, 5678);
        });
        assertEquals("Incorrect PIN", exception.getMessage());
    }

    @Test
    public void testTransfer() {
        bank.login(aliceAccountNumber, 1234);
        bank.deposit(1000);
        bank.transfer(bobAccountNumber, 300, 1234);
        assertEquals(700, bank.getBalance());
        bank.login(bobAccountNumber, 5678);
        assertEquals(300, bank.getBalance());
    }

    @Test
    public void testTransferToNonExistentAccount() {
        bank.login(aliceAccountNumber, 1234);
        bank.deposit(1000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.transfer("9999999999", 300, 1234);
        });
        assertEquals("Recipient account does not exist", exception.getMessage());
    }

    @Test
    public void testChangePin() {
        bank.login(aliceAccountNumber, 1234);
        bank.changePin(1234, 5678);
        assertTrue(bank.verifyPin(5678));
    }

    @Test
    public void testChangePinIncorrectOldPin() {
        bank.login(aliceAccountNumber, 1234);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.changePin(1111, 5678);
        });
        assertEquals("Old PIN is incorrect", exception.getMessage());
    }

    @Test
    public void testChangePinInvalidNewPin() {
        bank.login(aliceAccountNumber, 1234);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.changePin(1234, 56789);
        });
        assertEquals("New PIN must be exactly 4 digits", exception.getMessage());
    }

    @Test
    public void testCloseAccount() {
        bank.login(aliceAccountNumber, 1234);
        bank.closeAccount(1234);
        assertEquals(1, bank.getAccountCount());
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            bank.getBalance();
        });
        assertEquals("No active account", exception.getMessage());
    }
}