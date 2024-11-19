class NegativeAmountException extends Exception {
    public NegativeAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}

public class bank {
    private int accountNumber;
    private String customerName;
    private String accountType;
    private float balance;

    public bank(int accountNumber, String customerName, String accountType, float openingBalance) throws LowBalanceException {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountType = accountType;

        if (accountType.equals("Savings") && openingBalance < 1000) {
            throw new LowBalanceException("Opening balance for Savings must be at least Rs. 1000.");
        } else if (accountType.equals("Current") && openingBalance < 5000) {
            throw new LowBalanceException("Opening balance for Current must be at least Rs. 5000.");
        }

        this.balance = openingBalance;
    }

    public void deposit(float amt) throws NegativeAmountException {
        if (amt < 0) {
            throw new NegativeAmountException("Cannot deposit a negative amount.");
        }
        balance += amt;
    }

    public void withdraw(float amt) throws NegativeAmountException, InsufficientFundsException {
        if (amt < 0) {
            throw new NegativeAmountException("Cannot withdraw a negative amount.");
        }

        float minBalance = accountType.equals("Savings") ? 1000 : 5000;
        if (balance - amt < minBalance) {
            throw new InsufficientFundsException("Insufficient funds to maintain minimum balance.");
        }

        balance -= amt;
    }

    public float getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        try {
            bank account = new bank(12345, "Alice", "Savings", 2000);
            System.out.println("Account created for " + account.customerName + " with balance: " + account.getBalance());

            account.deposit(500);
            System.out.println("After deposit, balance: " + account.getBalance());

            account.withdraw(1200);
            System.out.println("After withdrawal, balance: " + account.getBalance());

            account.withdraw(500);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
