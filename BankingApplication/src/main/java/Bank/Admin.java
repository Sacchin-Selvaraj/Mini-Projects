package Bank;

import java.util.Map;

import static Bank.Main.map;
import static Bank.Main.sc;

public class Admin {

    public Admin() {
        adminPage();
    }

    private void adminPage() {
        while (true) {
            try {
                System.out.println("1.Display User Details\n2.Total Balance in Bank\n3.Delete User\n4.Homepage\n5.Exit");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        displayUserDetails();
                        break;
                    case 2:
                        totalBalance();
                        break;
                    case 3:
                        deleteUser();
                        break;
                    case 4:
                        Main.loginPage();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (RuntimeException e) {
                System.out.println("Invalid Choice");
                sc.remove();
            }
        }
    }

    private void deleteUser() {
        System.out.println("Enter the Username");
        String username=sc.next();
        User user=map.get(username);
        if (user==null){
            System.out.println("There is no user under this name "+username);
            return;
        }
        map.remove(username);
        System.out.println("User removed Successfully");
    }

    private void totalBalance() {
        double totalBalance=0;
        for (Map.Entry<String,User> entry:map.entrySet()){
            User tempuser=entry.getValue();
            totalBalance+=tempuser.getAccountBalance();
        }
        System.out.println("Total Balance : "+totalBalance);
    }

    private void displayUserDetails() {
        for (Map.Entry<String,User> entry:map.entrySet()){
            System.out.printf("%-20s: %s%n", "Username",entry.getValue().getUsername() );
            System.out.printf("%-20s: %s%n", "Password", "********");
            System.out.printf("%-20s: %d%n", "Age", entry.getValue().getAge());
            System.out.printf("%-20s: %s%n", "Gender", entry.getValue().getGender());
            System.out.printf("%-20s: %d%n", "Phone Number", entry.getValue().getPhoneNumber());
            System.out.printf("%-20s: %d%n", "Account Number", entry.getValue().getAccountNumber());
            System.out.printf("%-20s: %.2f%n", "Account Balance", entry.getValue().getAccountBalance());
            System.out.printf("%-20s: %d%n", "Transactions", entry.getValue().getTransaction());
            System.out.println("----------------------------------------------------------------");
        }
    }
}
