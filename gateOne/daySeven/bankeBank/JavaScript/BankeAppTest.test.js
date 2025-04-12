const BankeApp = require('./BankeApp');

describe('BankeApp', () => {
    let bank;
    let aliceAccountNumber;
    let bobAccountNumber;

    beforeEach(() => {
        bank = new BankeApp();
        aliceAccountNumber = bank.createAccount("Alice", "Johnson", 1234);
        bobAccountNumber = bank.createAccount("Bob", "Smith", 5678);
    });

    test('should create account successfully', () => {
        expect(bank.getAccountCount()).toBe(2);
        bank.login(aliceAccountNumber, 1234);
        expect(bank.getAccountName()).toBe("Alice Johnson");
    });

    test('should throw error for invalid account login', () => {
        expect(() => bank.login("9999999999", 1234)).toThrow("Account not found");
    });

    test('should throw error for incorrect PIN login', () => {
        expect(() => bank.login(aliceAccountNumber, 1111)).toThrow("Incorrect PIN");
    });

    test('should deposit successfully', () => {
        bank.login(aliceAccountNumber, 1234);
        bank.deposit(1000);
        expect(bank.getBalance()).toBe(1000);
    });

    test('should throw error for negative deposit', () => {
        bank.login(aliceAccountNumber, 1234);
        expect(() => bank.deposit(-100)).toThrow("Deposit amount must be greater than zero");
    });

    test('should withdraw successfully', () => {
        bank.login(aliceAccountNumber, 1234);
        bank.deposit(1000);
        bank.withdraw(500, 1234);
        expect(bank.getBalance()).toBe(500);
    });

    test('should throw error for incorrect PIN withdrawal', () => {
        bank.login(aliceAccountNumber, 1234);
        bank.deposit(1000);
        expect(() => bank.withdraw(500, 5678)).toThrow("Incorrect PIN");
    });

    test('should transfer successfully', () => {
        bank.login(aliceAccountNumber, 1234);
        bank.deposit(1000);
        bank.transfer(bobAccountNumber, 300, 1234);
        expect(bank.getBalance()).toBe(700);
        bank.login(bobAccountNumber, 5678);
        expect(bank.getBalance()).toBe(300);
    });

    test('should throw error for transfer to non-existent account', () => {
        bank.login(aliceAccountNumber, 1234);
        bank.deposit(1000);
        expect(() => bank.transfer("9999999999", 300, 1234)).toThrow("Recipient account does not exist");
    });

    test('should change PIN successfully', () => {
        bank.login(aliceAccountNumber, 1234);
        bank.changePin(1234, 5678);
        expect(bank.verifyPin(5678)).toBe(true);
    });

    test('should throw error for incorrect old PIN', () => {
        bank.login(aliceAccountNumber, 1234);
        expect(() => bank.changePin(1111, 5678)).toThrow("Old PIN is incorrect");
    });

    test('should throw error for invalid new PIN', () => {
        bank.login(aliceAccountNumber, 1234);
        expect(() => bank.changePin(1234, 56789)).toThrow("New PIN must be exactly 4 digits");
    });

    test('should close account successfully', () => {
        bank.login(aliceAccountNumber, 1234);
        bank.closeAccount(1234);
        expect(bank.getAccountCount()).toBe(1);
        expect(() => bank.getBalance()).toThrow("No active account");
    });
});