package email_app;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 10;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    // Constructor to receive the firstName and lastName
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created " + this.firstName + " " + this.lastName);

        // Call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        // Call a method that return a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password: " + this.password);

        // Combine elements to generate email:
        email  = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
        System.out.println("Your email: " + email);
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n4 for none");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {return "Sales";}
        else if (depChoice == 2) {return "Development";}
        else if (depChoice == 3) {return "Accounting";}
        else {return "";}
    }

    // Generate a random password
    public String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i=0; i<length; i++) {
            int rand = (int) (Math.random()  *  passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;

    }
    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
}

