package projectoop;

//Encapsulation
public class Account {
    String username;
    private String email;
    private double balance;
    private String phoneNumber;
    private String password;
    private String type;

    //Constructor
    public Account(String username, String type, String email, String phoneNumber, double balance, String password) {
        this.username = username;
        this.type = type;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.password = password;
    }
    
//Deklrasi Encapsulation Getter Setter        
        public String getType() {
            return type;
        }

        public void setType(String tipe) {
            this.type = tipe;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }        
  }



