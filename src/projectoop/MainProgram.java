package projectoop;

import java.io.*;
import java.util.*;

public class MainProgram {
    AccountManagement manage = new AccountManagement();
    public static void main(String[] args) {
        // Membuat objek ManajemenKaryawan
        AccountManagement manage = new AccountManagement();
        Scanner scanner = new Scanner(System.in);

        try {
            String fileName = "account.txt";
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File " + fileName + " not found.");
                System.out.println("Creating new file...");
                file.createNewFile();
            } else {
                BufferedReader reader;
                reader = new BufferedReader(new FileReader(fileName));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] accountData = line.split(";");
                    String username = accountData[0];
                    String type = accountData[1];
                    String email = accountData[2];
                    String phoneNumber = accountData[3];
                    String nik = accountData[4];
                    double balance = Double.parseDouble(accountData[5]);
                    String password = accountData[6];
                    
                    manage.updateAccount(username, type, email, phoneNumber, nik, balance, password); //Polymerphism
                }
                reader.close();
            }
        } catch (IOException e) {
            System.err.println("Failed to read file.");
        }

        // Menu login
        //Polymerphism
        boolean exit = false;
        while (!exit) {
            System.out.println("========== Welcome to PrimoWallet ==========");
            System.out.println("1. Eksekusi Practice");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.println("===========================================");
            System.out.print("Select menu: ");

            String pilihan = scanner.next();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case "1":
                    manage.practice("Username", "082124700252", 12);
                    break;
                case "2":
                    registerAccount(scanner, manage);
                    manage.saveAccount("account.txt");
                    break;
                case "3":
                    System.out.println("Thanks for using PrimoWallet");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Menu.");
            }
        }
    }

    //Polymerphism
    public static void menu(Scanner scanner, AccountManagement manage, Account loggedInAccount) {
        // Menampilkan menu
        MainProgram mp = new MainProgram();
        boolean exit = false;
        while (!exit) {
            System.out.println("=================== Menu ===================");
            System.out.println("1. View Account");
            System.out.println("2. Add Balance");
            System.out.println("3. Transfer");
            System.out.println("4. Withdraw Balance");
            System.out.println("5. Upgrade to Premium");
            System.out.println("6. Logout");
            System.out.println("===========================================");
            System.out.print("Select menu: ");
            String pilihan = scanner.next();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case "1":
                    manage.viewAccount(loggedInAccount);
                    break;
                case "2":
                    manage.addBalance(scanner, loggedInAccount);
                    break;
                case "3":
                    manage.transferBalance(scanner, loggedInAccount);
                    break;
                case "4":
                    manage.withdrawBalance(scanner, loggedInAccount);
                    break;
                case "5":
                    manage.statusUpgrade(scanner, manage, mp ,loggedInAccount);
                    break;
                case "6":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid menu.");
            }
        }
    }

    //Polymerphism
    public static void loginAccount(Scanner scanner, AccountManagement accountManagement) {
    int attemptCount = 0;
    final int MAX_ATTEMPTS = 3;
    boolean loginSuccess = false;

    do {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password : ");
        String password = scanner.nextLine();

        Account loggedInAccount = accountManagement.loginAccount(username, password);

        if (loggedInAccount != null) {
            System.out.println("Login successful!");
            menu(scanner, accountManagement, loggedInAccount);
            loginSuccess = true;
        } else {
            attemptCount++;
            System.out.println("Invalid username or password. Please try again.");
            if (attemptCount >= MAX_ATTEMPTS) {
                System.out.println("Max login attempts reached. Returning to main menu.");
                break;
            }
        }
    } while (!loginSuccess);
}

    //Polymerphism
   public static void registerAccount(Scanner scanner, AccountManagement manage) {
    String username = "";
    String email = "";
    String phoneNumber = "";
    String password = "";

    boolean valid = false;
    do {
        System.out.print("Enter Username: ");
        username = scanner.nextLine();
        if (!Validation.isUniqueUsername(username, manage.getAccountList())) {
            System.out.println("Username already exists. Please choose another username.");
        } else {
            valid = true;
        }
    } while (!valid);
    
    valid = false;
    do {
        email = Validation.isValidEmail(scanner);
        valid = true;
    } while (!valid);

    valid = false;
    do {
        phoneNumber = Validation.isValidPhoneNumber(scanner);
        if (!Validation.isUniquePhoneNumber(phoneNumber, manage.getAccountList())) {
            System.out.println("Phone number already exists. Please choose another phone number.");
        } else {
            valid = true;
        }
    } while (!valid);
    password = Validation.isValidPassword(scanner);
    
    manage.registerAccount(username, email, phoneNumber, password);
}
   
   public void loginAfterUpgrade(Scanner scanner, AccountManagement manage, String username, String password, Account loggedInAccount) {
    Account upgradedAccount = manage.loginAccount(username, password);

    if (upgradedAccount != null) {
        loggedInAccount = upgradedAccount;
        menu(scanner, manage, loggedInAccount);
    } else {
        System.out.println("Login failed after upgrade. Please login manually.");
        }
    }
   
   public void logout(Account loggedInAccount) {
    loggedInAccount = null;
    }
   
}