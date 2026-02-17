package week_6;

public class BankAccountTypes {

    public static void main(String[] args) {
    	// Declaring our object variables
        BankAccount savingsAccount = new Savings("676767", 1500);
        BankAccount checkingAccount = new Checking("694200", 500);
        BankAccount creditAccount = new Credit("177013", -2000);

        // Display all account type info
        savingsAccount.displayAccountInfo();
        checkingAccount.displayAccountInfo();
        creditAccount.displayAccountInfo();
    }
}

abstract class BankAccount {
	private double balance;
	private String accountNumber;
	
	// Constructor
	BankAccount(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	// Getters and Setters
	String getAccountNumber() {
		return accountNumber;
	}
	
	void setBalance(double b) {
		balance = b;
	}
	
	double getBalance() {
		return balance;
	}
	
    // Abstract methods for our bank accounts
    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    abstract void displayAccountInfo();
}

// Savings Account
class Savings extends BankAccount {

	Savings(String accNumber, double balance){
		super(accNumber, balance);
	}
	
    // Deposit adds amount to balance
    void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.printf("Deposit Success! $%.2f added. Current balance: $%.2f\n\n", amount, getBalance());
    }

    // Withdraw subtracts amount if balance is sufficient
    void withdraw(double amount) {
        if (getBalance() - amount < 0) {
            System.out.println("Transaction Failed! Withdraw amount exceeds balance.\n");
            return;
        }
        setBalance(getBalance() - amount);
        System.out.printf("Withdrawal Success! Current balance: $%.2f\n\n", getBalance());
    }

    // Display account info with account number and current balance
    void displayAccountInfo() {
        System.out.printf("Savings Account   :  Account Number = %s, Balance = $%.2f\n", getAccountNumber(), getBalance());
    }
}

// Checking Account 
class Checking extends BankAccount {
	// Fixed overdraft limit
	private final double overDraftLimit = 3000.00;	
	
	Checking(String accNumber, double balance){
		super(accNumber, balance);
	}
	
    void deposit(double amount) {
        setBalance(getBalance() +  amount);
        System.out.printf("Deposit Success! $%.2f added. Current balance: $%.2f\n\n", amount, getBalance());
    }

    // Withdraw method, allows overdraft but has limit
    void withdraw(double amount) {
        // Check if withdrawal exceeds overdraft limit
        if (getBalance() - amount < -overDraftLimit) {
            System.out.printf("Transaction Failed! "
            + "Withdraw amount exceeds overdraft limit of $%.2f\n\n", overDraftLimit);
            return;
        }

        // Subtract amount from balance
        setBalance(getBalance() - amount);
        System.out.printf("Withdrawal Success! Current balance: $%.2f", getBalance());

        // Show overdraft info only if balance is negative
        if (getBalance() < 0) {
            System.out.printf(" (Overdraft used, limit: $%.2f)", overDraftLimit);
        }
        System.out.println("\n");
    }

    // I just used a bit of conditional for displaying, for proper negative value output
    void displayAccountInfo() {  
        if (getBalance() < 0) {
            System.out.printf("Checking Account  :  Account Number = %s,"
            + " Balance = -$%.2f (Overdraft Limit: $%.2f)\n", getAccountNumber(), Math.abs(getBalance()), overDraftLimit);
        } else {
            System.out.printf("Checking Account  :  Account Number = %s,"
            + " Balance = $%.2f\n", getAccountNumber(), getBalance());
        }
    }
}

// Credit Account 
class Credit extends BankAccount {
    // In credit, balance represents what you owe the bank
	// Fixed credit limit
	private final double creditLimit = 5000.00;	
	
	Credit(String accNumber, double balance){
		super(accNumber, balance);
	}

    // Deposit reduces credit balance
    void deposit(double amount) { 
        setBalance(getBalance() - amount);
        System.out.printf("Deposit Success! $%.2f paid. Current balance: $%.2f\n\n", amount, getBalance());
    }

    // Withdraw here means borrowing more, which increases debt, but has limit
    void withdraw(double amount) {
        if (getBalance() + amount > creditLimit) {
            System.out.printf("Transaction Failed! "
            + "Withdraw amount exceeds credit limit of $%.2f\n\n", creditLimit);
            return;
        }
        setBalance(getBalance() + amount);
        System.out.printf("Withdrawal Success! Current balance: $%.2f\n\n", getBalance());
    }

    void displayAccountInfo() {
        if (getBalance() < 0) {
            System.out.printf("Credit Account    :  Account Number = %s,"
            + " Balance = -$%.2f (Credit Limit: $%.2f)\n", getAccountNumber(), Math.abs(getBalance()), creditLimit);
        } else {
            System.out.printf("Credit Account    :  Account Number = %s,"
            + " Balance = $%.2f (Credit Limit: $%.2f)\n", getAccountNumber(), getBalance(), creditLimit);
        }
    }
}
