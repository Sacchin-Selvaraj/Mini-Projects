package Bank;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User{

    private String username;
    private String password;
    private int age;
    private String gender;
    private int phoneNumber;
    private int accountNumber;
    private double accountBalance;
    private int transaction;
    private List<TransactionImpl> transactionDetails=new ArrayList<>();


    public User(String username, String password, int age, String gender, int phoneNumber, int accountNumber) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
    }

}
