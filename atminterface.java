package codesoft;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount account) {
        bankAccount = account;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= bankAccount.getBalance()) {
            bankAccount.withdraw(amount);
            System.out.println("Withdrawal of ₹" + amount + " successful.");
        } else {
            System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            bankAccount.deposit(amount);
            System.out.println("Deposit of ₹" + amount + " successful.");
        } else {
            System.out.println("Deposit failed. Invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Your balance is ₹" + bankAccount.getBalance());
    }

    public void showOptions() {
        System.out.println("Welcome to the ATM. Please select an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }
}

public class atminterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount(1000);
        ATM atm = new ATM(bankAccount);
        int option;
        do {
            atm.showOptions();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 4);

        scanner.close();
    }
}
