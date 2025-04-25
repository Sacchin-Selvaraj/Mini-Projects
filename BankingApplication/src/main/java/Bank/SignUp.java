package Bank;

import javax.sound.midi.Soundbank;
import java.util.Random;

import static Bank.Main.map;
import static Bank.Main.sc;

public class SignUp {

    public SignUp() {
        System.out.println("Welcome to SignUp page");
        createUser();
    }

    private void createUser() {
        System.out.println("Enter the Username");
        String username=sc.next();
        System.out.println("Enter the Password");
        String password= sc.next();
        System.out.println("Enter the Age");
        int age=sc.nextInt();
        System.out.println("Enter the Gender");
        String gender=sc.next();
        System.out.println("Enter the PhoneNumber");
        int phoneNumber= sc.nextInt();
        int accountNumber=generateAccountNumber();
        User currentuser=new User(username,password,age,gender,phoneNumber,accountNumber);
        map.put(username,currentuser);
        System.out.println("Account has been created successfully : "+username);
    }

    private int generateAccountNumber() {
        Random random=new Random(8);
        return random.nextInt(8);
    }
}
