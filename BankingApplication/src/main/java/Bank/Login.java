package Bank;

import java.time.Instant;
import java.util.Date;

import static Bank.Main.map;
import static Bank.Main.sc;

public class Login {
    public Login() {
        System.out.println("Welcome to Login Page");
        authendicateUser();
    }

    private void authendicateUser() {

        String username;
        String password;
        User loggedInUser;

        while (true) {
            System.out.println("Enter the Username");
            username = sc.next();
            loggedInUser = map.get(username);
            if (loggedInUser != null) {
                break;
            }
            System.out.println("Invalid username....");
        }
        while (true) {
            System.out.println("Enter the password");
            password = sc.next();
            if (loggedInUser.getPassword().equals(password)) {
                break;
            }
            System.out.println("Invalid Password....");
        }
        System.out.println("Successfully Logged In.....");
        customerDetails(loggedInUser);
    }

    private void customerDetails(User loggedInUser) {
        while (true) {
            try {
                System.out.println("1.Check Available Balance\n2.Deposit Amount\n3.Withdraw Amount\n4.HomePage\n5.User Details\n6.Transaction Details");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Account Balance : "+loggedInUser.getAccountBalance());
                        break;
                    case 2:
                        depositAmount(loggedInUser);
                        break;
                    case 3:
                        withDrawAmount(loggedInUser);
                        break;
                    case 4:
                        Main.loginPage();
                        break;
                    case 5:
                        System.out.println(loggedInUser);
                        break;
                    case 6:
                        displayTransaction(loggedInUser);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }

            } catch (RuntimeException e) {
                System.out.println(e);
                System.out.println("Invalid Input...");
                sc.remove();
            }
        }
    }
    private void displayTransaction(User loginUser) {
        for (TransactionImpl transaction: loginUser.getTransactionDetails()) {
            System.out.println("\n--- Transaction Details ---");
            System.out.printf("%-20s: ₹%,.2f%n", "Initial Balance", transaction.getInitialBalance());
            System.out.printf("%-20s: ₹%,.2f%n", "Withdrawal Amount", transaction.getWithdraw());
            System.out.printf("%-20s: ₹%,.2f%n", "Deposit Amount", transaction.getDeposit());
            System.out.printf("%-20s: ₹%,.2f%n", "Current Balance", transaction.getCurrentBalance());
            System.out.printf("%-20s: %tF %<tT%n", "Transaction Date", transaction.getTransactionDate());
            System.out.println("------------------------------------------------------------------------");
        }
    }

    private void withDrawAmount(User loggedInUser) {
        TransactionImpl transaction=new TransactionImpl();
        transaction.setInitialBalance(loggedInUser.getAccountBalance());
        double amount;
        while (true) {
            System.out.println("Enter the Amount to be Withdraw");
            amount = sc.nextDouble();
            if (loggedInUser.getAccountBalance() - amount > 0) {
                break;
            }
            System.out.println("Amount balance can't be less than 0 ");
        }
        transaction.setWithdraw(amount);
        transaction.setCurrentBalance(loggedInUser.getAccountBalance()-amount);
        transaction.setTransactionDate(Date.from(Instant.now()));
        loggedInUser.getTransactionDetails().add(transaction);
        loggedInUser.setAccountBalance(loggedInUser.getAccountBalance()-amount);
        loggedInUser.setTransaction(loggedInUser.getTransaction()+1);
        System.out.println("Amount withdraw Successfully.... "+amount);
    }

    private void depositAmount(User loggedInUser) {
        TransactionImpl transaction=new TransactionImpl();
        transaction.setInitialBalance(loggedInUser.getAccountBalance());
        double amount;
        System.out.println("Enter the Amount to be Deposited");
        amount = sc.nextDouble();
        transaction.setDeposit(amount);
        transaction.setCurrentBalance(loggedInUser.getAccountBalance()+amount);
        transaction.setTransactionDate(Date.from(Instant.now()));
        loggedInUser.getTransactionDetails().add(transaction);
        loggedInUser.setAccountBalance(loggedInUser.getAccountBalance()+amount);
        loggedInUser.setTransaction(loggedInUser.getTransaction()+1);
        System.out.println("Amount Deposited Successfully.... "+amount);
    }
}
