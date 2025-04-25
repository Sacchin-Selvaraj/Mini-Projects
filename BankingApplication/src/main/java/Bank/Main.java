package Bank;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static Scanner sc =new Scanner(System.in);
    public static HashMap<String,User> map=new HashMap<>();

    public static void main(String[] args) {
         loginPage();
        }

    public static void loginPage() {
        while (true){
            System.out.println("Welcome to Kovai Bank\n 1.Login\n 2.Signup\n 3.Admin Login\n 4.Exit");
            System.out.println("Enter the Option : ");
            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        new Login();
                        break;
                    case 2:
                        new SignUp();
                        break;
                    case 3:
                        new Admin();
                        break;
                    case 4:
                        System.out.println("Exiting.......");
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice.....");

                }
            } catch (Exception e) {
                System.out.println("Invalid Choice.....");
                sc.next();
            }

        }
    }
}
