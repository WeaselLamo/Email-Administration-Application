package email;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String departmentName;
    private String email;
    private int mailCapacity=500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "mangesh.com";

    // Constructor to receive First Name and Last Name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        
        // Call a method asking for the department - return the department
        this.departmentName = setDepartment();
        
        // Call a method that returns a Random Password
        this.password = randomPassword(8);
        System.out.println("Your Password is: " + this.password);
        
        //Combine elements to generate email
        email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+departmentName +"."+ companySuffix;
        
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("New worker: "+firstName + ".\nEnter the Code\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter Department Code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    
    //Set Mail Capacity
     public void setMailCapacity(int capacity) {
    	 this.mailCapacity = capacity;
     }
     
     //Set Alternate Email
     public void setAlternateEmail(String altEmail) {
    	 this.alternateEmail = altEmail;
     }
     
     
     //Change Password
     public void changePassword(String password) {
    	 this.password = password;
     }
     
     public int getMailCapacity() {return mailCapacity;}
     public String getAlternateEmail() {return alternateEmail;}
     public String getPassword() {return password;}
     
     public String showInfo() {
    	 return "DISPLAY NAME: "+ firstName + " " + lastName +
    			 "\nCOMPANY EMAIL: " + email +
    			 "\nMAILBOX CAPACITY: "+ mailCapacity + "mb";
     }
     
}
