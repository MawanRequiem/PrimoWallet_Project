package projectoop;

import java.io.*;
import java.util.*;

public class AccountManagement {
    private final List<Account> accountList;
    private final BankTransfer bankTransfer = new BankTransfer();
    private final Cash cash = new Cash();
    
    //accountList variable creation with arrayList type
    public AccountManagement() {
        accountList = new ArrayList<>();
    }

    //Getting accountList Value
    public List<Account> getAccountList() {
        return accountList;
    }

    
    //Register account method
    //Dynamic Polymerphism
    public void registerAccount(String username, String email, String phoneNumber, String password) {
        if (!Validation.isUniqueUsername(username, accountList)) {
            System.out.println("Username already exists. Please choose another username.");
            return;
        }
        if (!Validation.isUniquePhoneNumber(phoneNumber, accountList)) {
            System.out.println("Phone number already exists. Please choose another phone number.");
            return;
        }
        accountList.add(new RegulerAccount(username, "Reguler", email, phoneNumber, 0, password));
        System.out.println("Account created successfully. Please login.");
    }

    //updateAccount method to update the reader
    public void updateAccount(String username, String type, String email, String phoneNumber, String nik, double balance, String password) {
        for (Account account : accountList) {
            if (account.getUsername().equals(username)) {
                account.setType(type);
                account.setEmail(email);
                account.setPhoneNumber(phoneNumber);
                if (account instanceof PremiumAccount) {
                    ((PremiumAccount) account).setNik(nik);
                }
                account.setBalance(balance);
                account.setPassword(password);
                return;
            }
        }
        
        if (type.equals("Reguler")) {
            accountList.add(new RegulerAccount(username, type, email, phoneNumber, balance, password));
        } else if (type.equals("Premium")) {
            accountList.add(new PremiumAccount(username, type, email, phoneNumber, nik, balance, password));
        }
    }

    //loginAccount method
    public Account loginAccount(String username, String password) {
        for (Account account : accountList) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    //saveAccount method to save the TXT file
    public void saveAccount(String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Account account : accountList) {
                if (account instanceof RegulerAccount) {
                    printWriter.println(account.getUsername() + ";" + account.getType() + ";" + account.getEmail() + ";" +
                            account.getPhoneNumber() + ";0;" + account.getBalance() + ";" + account.getPassword());
                } else if (account instanceof PremiumAccount) {
                    PremiumAccount premiumAccount = (PremiumAccount) account;
                    printWriter.println(account.getUsername() + ";" + account.getType() + ";" + account.getEmail() + ";" +
                            account.getPhoneNumber() + ";" + premiumAccount.getNik() + ";" + account.getBalance() + ";" + account.getPassword());
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to save account data to file " + fileName);
        }
    }
   
    //viewAccount method to show logged in user data
public void viewAccount(Account loggedInAccount) {
    System.out.println("Username: " + loggedInAccount.getUsername());
    System.out.println("Type: " + loggedInAccount.getType());
    if (!Validation.isValidEmail(loggedInAccount.getEmail())) {
        System.out.println("Email: " + loggedInAccount.getEmail());
    } else {
        System.out.println("Email: Something wrong wirth database, Contact admin for verification.");
    }
    if (!Validation.isValidPhoneNumber(loggedInAccount.getPhoneNumber())) {
        System.out.println("Phone Number: " + loggedInAccount.getPhoneNumber());
    } else {
        System.out.println("Phone Number: Something wrong with database, Contact admin for verification.");
    }
    System.out.println("Balance: " + loggedInAccount.getBalance());
}

    //addBalance Abstract Class method
    
    void addBalance(Scanner scanner, Account loggedInAccount) {
        System.out.println("===========================================");
        System.out.println("Choose deposit method:");
        System.out.println("1. Bank Transfer");
        System.out.println("2. Cash");
        System.out.println("===========================================");
        System.out.print("Select menu: ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                bankTransfer.deposit(scanner, loggedInAccount);
                break;
            case "2":
                cash.deposit(scanner, loggedInAccount);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    //looping method to search account by username
    public Account findAccountByUsername(String username) {
        for (Account account : accountList) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    //looping method to search account by phone number
    public Account findAccountByPhoneNumber(String phoneNumber) {
        for (Account account : accountList) {
            if (account.getPhoneNumber().equals(phoneNumber)) {
                return account;
            }
        }
        return null;
    }
    
    public void transferBalance(Scanner scanner, Account loggedInAccount) {
        if (!(loggedInAccount instanceof PremiumAccount)) {
            System.out.println("Only premium accounts can perform transfers.");
            return;
        }
        else if (loggedInAccount.getBalance() == 0){
            System.out.println("Your balance is 0 please deposit first");
            return;
        }

        String recipientPhoneNumber;
        Account recipientAccount;
        int invalidPhoneNumberAttempts = 0;

        do {
            System.out.print("Enter recipient's Phone Number: ");
            recipientPhoneNumber = scanner.nextLine();
            recipientAccount = findAccountByPhoneNumber(recipientPhoneNumber);

            if (recipientAccount == null) {
                System.out.println("Recipient account not found. Please try again.");
                invalidPhoneNumberAttempts++;
                if (invalidPhoneNumberAttempts >= 3) {
                    System.out.println("You've exceeded the maximum number of invalid attempts. Returning to menu.");
                    return;
                }
            } else if (recipientPhoneNumber.equals(loggedInAccount.getPhoneNumber())) {
                System.out.println("You cannot transfer funds to your own account. Please enter a different phone number.");
                recipientAccount = null;
            }
        } while (recipientAccount == null);

        double amount;
        do {
            System.out.print("Enter amount to transfer: ");
            String amountInput = scanner.nextLine();
            try {
                amount = Double.parseDouble(amountInput);
                if (amount <= 0 || amountInput.startsWith("0")) {
                    System.out.println("Transfer amount is invalid. Please enter a valid amount.");
                    amount = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount format. Please enter a valid number.");
                amount = 0;
            }
        } while (amount <= 0);

        PremiumAccount premiumLoggedInAccount = (PremiumAccount) loggedInAccount;

        if (premiumLoggedInAccount.getBalance() < amount) {
            System.out.println("Insufficient balance.");
            return;
        }

        if (recipientAccount instanceof PremiumAccount) {
            premiumLoggedInAccount.transfer((PremiumAccount) recipientAccount, amount);
        } else {
            loggedInAccount.setBalance(loggedInAccount.getBalance() - amount);
            recipientAccount.setBalance(recipientAccount.getBalance() + amount);
        }
        
        saveAccount("account.txt");
    }

    //Polymerphism
    void withdrawBalance(Scanner scanner, Account loggedInAccount) {
        System.out.println("===========================================");
        System.out.println("Choose withdraw method:");
        System.out.println("1. Bank Transfer");
        System.out.println("2. Cash");
        System.out.println("===========================================");
        System.out.print("Select menu: ");
        
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                bankTransfer.withdraw(scanner, loggedInAccount);
                break;
            case "2":
                cash.withdraw(scanner, loggedInAccount);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
public void practice (String user, String nomor, int age) {
    System.out.println("parameter 1 : "+user);
    System.out.println("parameter 2 : "+nomor);
    System.out.println("parameter 3 : "+age);
}

    //Polymerphism
public void statusUpgrade(Scanner scanner, AccountManagement manage, MainProgram mainProgram, Account loggedInAccount) {
    if (loggedInAccount instanceof RegulerAccount) {
        boolean validNIK = false; // Menyimpan status validasi NIK
        do {
            String nik = Validation.isValidNik(scanner);

            // NIK valid, set flag validasi ke true dan lanjutkan proses upgrade
            validNIK = true;
            System.out.println("Please wait for confirmation.");

            String username = loggedInAccount.getUsername();
            String email = loggedInAccount.getEmail();
            String phoneNumber = loggedInAccount.getPhoneNumber();
            double balance = loggedInAccount.getBalance();
            String password = loggedInAccount.getPassword();

            PremiumAccount premiumAccount = new PremiumAccount(username, "Premium", email, phoneNumber, nik, balance, password);

            manage.getAccountList().remove(loggedInAccount);
            manage.getAccountList().add(premiumAccount);
            manage.saveAccount("account.txt");

            System.out.println("Upgrade successful.");

            mainProgram.logout(loggedInAccount);

            mainProgram.loginAfterUpgrade(scanner, manage, username, password, loggedInAccount);
        } while (!validNIK); // Loop terus menerus sampai NIK yang valid dimasukkan
    } else {
        System.out.println("You already have a Premium Account.");
    }
}

    
    //Abstract, Inheritance, Polymerphism
    class BankTransfer implements Balance {
        @Override
        public void deposit(Scanner scanner, Account loggedInAccount) {
             // Implement bank transfer deposit logic
             // You can use existing validation and balance updating here
             System.out.print("Enter bank account number: ");
             String bankDetails = scanner.nextLine();

             double amount;
             boolean valid = false;
             do {
                 System.out.print("Enter amount to transfer: ");
                 String amountInput = scanner.nextLine();
                 try {
                     amount = Double.parseDouble(amountInput);
                     if (amount <= 0 || amountInput.startsWith("0")) {
                         System.out.println("Transfer amount is invalid. Please enter a valid amount.");
                         amount = 0;
                     } else {
                         loggedInAccount.setBalance(loggedInAccount.getBalance() + amount);
                         System.out.println("Transfer successful.");
                         System.out.println("Current Balance: " + loggedInAccount.getBalance());
                         valid = true;
                     }
                 } catch (NumberFormatException e) {
                     System.out.println("Invalid amount format. Please enter a valid number.");
                     amount = 0;
                 }
             } while (!valid);
             saveAccount("account.txt");
         }


        @Override
        public void withdraw(Scanner scanner, Account loggedInAccount) {
             // Implement bank transfer withdrawal logic
             // You can use existing validation and balance updating here
             System.out.print("Enter bank account number: ");
             String bankDetails = scanner.nextLine();

             double amount;
             boolean valid = false;
             do {
                 System.out.print("Enter amount to withdraw: ");
                 String amountInput = scanner.nextLine();
                 try {
                     amount = Double.parseDouble(amountInput);
                     if (amount <= 0 || amountInput.startsWith("0")) {
                         System.out.println("Withdrawal amount is invalid. Please enter a valid amount.");
                         amount = 0;
                     } else {
                         if (loggedInAccount.getBalance() >= amount) {
                             loggedInAccount.setBalance(loggedInAccount.getBalance() - amount);
                             System.out.println("Withdrawal successful.");
                             System.out.println("Current Balance: " + loggedInAccount.getBalance());
                             valid = true;
                         } else {
                             System.out.println("Insufficient balance.");
                         }
                     }
                 } catch (NumberFormatException e) {
                     System.out.println("Invalid amount format. Please enter a valid number.");
                     amount = 0;
                 }
             } while (!valid);
             saveAccount("account.txt");
         }
    }

        //Abstract, Inheritance, Polymerphism
    class Cash implements Balance {
         @Override
         public void deposit(Scanner scanner, Account loggedInAccount) {
             // Implement cash deposit logic
             // You can use existing validation and balance updating here
             double amount;
             boolean valid = false;
             do {
                 System.out.print("Enter amount of cash to deposit: ");
                 String amountInput = scanner.nextLine();
                 try {
                     amount = Double.parseDouble(amountInput);
                     if (amount <= 0 || amountInput.startsWith("0")) {
                         System.out.println("Deposit amount is invalid. Please enter a valid amount.");
                         amount = 0;
                     } else {
                         loggedInAccount.setBalance(loggedInAccount.getBalance() + amount);
                         System.out.println("Deposit successful.");
                         System.out.println("Current Balance: " + loggedInAccount.getBalance());
                         valid = true;
                     }
                 } catch (NumberFormatException e) {
                     System.out.println("Invalid amount format. Please enter a valid number.");
                     amount = 0;
                 }
             } while (!valid);
             saveAccount("account.txt");
         }

         @Override
         public void withdraw(Scanner scanner, Account loggedInAccount) {
             // Implement cash withdrawal logic
             // You can use existing validation and balance updating here
             double amount;
             boolean valid = false;
             do {
                 System.out.print("Enter amount of cash to withdraw: ");
                 String amountInput = scanner.nextLine();
                 try {
                     amount = Double.parseDouble(amountInput);
                     if (amount <= 0 || amountInput.startsWith("0")) {
                         System.out.println("Withdrawal amount is invalid. Please enter a valid amount.");
                         amount = 0;
                     } else {
                         if (loggedInAccount.getBalance() >= amount) {
                             loggedInAccount.setBalance(loggedInAccount.getBalance() - amount);
                             System.out.println("Withdrawal successful.");
                             System.out.println("Current Balance: " + loggedInAccount.getBalance());
                             valid = true;
                         } else {
                             System.out.println("Insufficient balance.");
                         }
                     }
                 } catch (NumberFormatException e) {
                     System.out.println("Invalid amount format. Please enter a valid number.");
                     amount = 0;
                 }
             } while (!valid);
             saveAccount("account.txt");
         }
     }
    
}
