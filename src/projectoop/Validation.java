package projectoop;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validation {
    static boolean isUniqueUsername(String username, List<Account> accountList) {
        for (Account account : accountList) {
            if (account.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
     
    static boolean isUniquePhoneNumber(String phoneNumber, List<Account> accountList) {
        for (Account account : accountList) {
            if (account.getPhoneNumber().equals(phoneNumber)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidBalance(String balance) {
        String balanceRegex = "^[1-9]\\d*(\\.\\d+)?$";
        return balance.matches(balanceRegex);
    }

    public static boolean isValidNik(String nik) {
        String nikRegex = "^\\d{16}$";
        return nik.matches(nikRegex);
    }
    
    //Polymerphism
    public static String isValidNik(Scanner scanner){
        String nik;
        boolean valid = false;
        do {
            System.out.print("Enter your NIK: ");
            nik = scanner.nextLine();
            if (isValidNik(nik)) {
                valid = true;
            } else {
                System.out.println("Invalid NIK format.");
            }
        } while (!valid);
        return nik;        
    }
    
    public static boolean isValidEmail(String email) {
        String emailRegex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

     //Polymerphism
    public static String isValidEmail(Scanner scanner) {
        String email;
        boolean valid = false;
        do {
            System.out.print("Enter Email: ");
            email = scanner.nextLine();
            if (isValidEmail(email)) {
                // Validate domain
                if (email.matches("^\\S+@\\S+\\.\\S+$")) {
                    valid = true;
                } else {
                    System.out.println("Invalid email domain.");
                }
            } else {
                System.out.println("Invalid email format.");
            }
        } while (!valid);
        return email;
    }
    
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^08\\d{8,12}$";
        return phoneNumber.matches(phoneRegex);
    }

    //Polymerphism
    public static String isValidPhoneNumber(Scanner scanner) {
        String phoneNumber;
        boolean valid = false;
        do {
            System.out.print("Enter Phone Number: ");
            phoneNumber = scanner.nextLine();
            if (isValidPhoneNumber(phoneNumber)) {
                valid = true;
            } else {
                System.out.println("Invalid phone number format.");
            }
        } while (!valid);
        return phoneNumber;
    }
    
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        return password.matches(passwordRegex);
    }
    
    //Polymerphism
    public static String isValidPassword(Scanner scanner) {
        String password;
        boolean valid = false;
        do {
            System.out.println("Enter Password (at least 8 characters, including lowercase, uppercase, and number):");
            password = scanner.nextLine();
            if (isValidPassword(password)) {
                valid = true;
            } else {
                System.out.println("Invalid password format.");
            }
        } while (!valid);
        return password;
    }
    
    static boolean isValidConfirmation(String input) {
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no");
    }

    //Polymerphism
    static boolean isValidConfirmation(Scanner scanner, String message) {
        String input;
        boolean valid = false;
        do {
            System.out.print(message + " (yes/no): ");
            input = scanner.nextLine();
            if (isValidConfirmation(input)) {
                valid = true;
            } else {
                System.out.println("Please enter either 'yes' or 'no'.");
            }
        } while (!valid);
        return input.equalsIgnoreCase("yes");
    }
}