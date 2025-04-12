const Account = require('./Account');

describe('Account', () => {
    test('should create account successfully', () => {
        const account = new Account("John", "Doe","1000000001", 1234);
        expect(account.getFirstName()).toBe("John");
        expect(account.getLastName()).toBe("Doe");
        expect(account.getAccountNumber()).toBe("1000000001");
        expect(account.getBalance()).toBe(0.0);
        });

        test('should deposit successfully', () => {
            const account = new Account("John", "Doe", 1234, "1000000001");
            account.deposit(500.0);
            expect(account.getBalance()).toBe(500.0);
        });

        test('should throw error for invalid deposit amount', () => {
            const account = new Account("John", "Doe", 1234, "1000000001");
            expect(() => account.deposit(-100.0)).toThrow("Deposit amount must be greater than zero");
        });

        test('should throw error for non-numeric deposit amount', () => {
            const account = new Account("John", "Doe", 1234, "1000000001");
            expect(() => account.deposit("abc")).toThrow("Deposit amount must be a number");
        });

        test('should withdraw successfully', () => {
            const account = new Account("John", "Doe", 1234, "1000000001");
            account.deposit(1000.0);
            account.withdraw(500.0);
            expect(account.getBalance()).toBe(500.0);
        });

        test('should throw error for invalid withdrawal amount', () => {
            const account = new Account("John", "Doe", 1234, "1000000001");
            expect(() => account.withdraw(-100.0)).toThrow("Withdrawal amount must be greater than zero");
        });

        test('should throw error for non-numeric withdrawal amount', () => {
            const account = new Account("John", "Doe", 1234, "1000000001");
            expect(() => account.withdraw("abc")).toThrow("Withdrawal amount must be a number");
        });

        test('should throw error when withdrawing with insufficient balance', () => {
            const account = new Account("John", "Doe", 1234, "1000000001");
            account.deposit(500.0);
            expect(() => account.withdraw(600.0)).toThrow("Insufficient balance");
        });

        test('should throw error for incorrect PIN on withdrawal', () => {
            const account = new Account("John", "Doe", 1234, "1000000001");
            account.deposit(500.0);
            expect(() => account.withdraw(100.0, 1111)).toThrow("Incorrect PIN");
        });

        test('should change PIN successfully', () => {
            const account = new Account("John", "Doe", "1000000001",1234);
            account.changePin(1234, 5678);
            expect(account.verifyPin(5678)).toBe(true);
        });

        test('should throw error for incorrect old PIN', () => {
            const account = new Account("John", "Doe", "1000000001",1234);
            expect(() => account.changePin(1111, 5678)).toThrow("Incorrect PIN");
        });

        test('should verify PIN successfully', () => {
            const account = new Account("John", "Doe", "1000000001",1234);
            expect(account.verifyPin(1234)).toBe(true);
            expect(account.verifyPin(5678)).toBe(false);
        });

        test('should throw error for invalid new PIN', () => {
            const account = new Account("John", "Doe", "1000000001",1234);
            expect(() => account.changePin(1234, 56789)).toThrow("New PIN must be exactly 4 digits");
        });

        test('should throw error for same old and new PIN', () => {
            const account = new Account("John", "Doe", "1000000001",1234);
            expect(() => account.changePin(1234, 1234)).toThrow("New PIN must be different from old PIN");
        });
        test('should throw error for non-numeric new PIN', () => {
            const account = new Account("John", "Doe", "1000000001",1234);
            expect(() => account.changePin(1234, "abcd")).toThrow("New PIN must be a number");
        });

        
 
    });

