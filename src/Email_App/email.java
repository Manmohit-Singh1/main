package Email_App;

import java.util.Scanner;

public class email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String alternateEmail;
    private int defaultPasswordLenght = 10;
    private String department;
    private int mailBoxCapacity = 500;
    private String companySuffix = "abcCompany.com";

    //Constructor for first and last name
    public email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        //method for asking the department - returning the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        //method for generating random password
        this.password = randomPassword(defaultPasswordLenght);
        System.out.println("Your Password is: " + this.password);

        //email generator
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "." + department + "@" + companySuffix;
        System.out.println("Your email is: " + email);

    }


    //Ask the department
    private String setDepartment(){
        System.out.print("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1){ return "sales";}
        else if (depChoice == 2) { return "dev";}
        else if (depChoice == 3){ return "acc";}
        else { return "";}
    }

    //generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%&";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //change the password
    public void changePassword(String password){
        this.password = password;
    }

    public String getPassword() { return password; }


    //set the mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }

    public int getMailBoxCapacity() {return mailBoxCapacity; }

    //set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    public String getAlternateEmail() {return alternateEmail; }


    public String showInfo(){
        return "Display Name: " + firstName + lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailBoxCapacity+"mb";
    }

}
