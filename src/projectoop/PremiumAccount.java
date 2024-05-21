package projectoop;

//Inheritance
public class PremiumAccount extends Account {
    private String nik;

    public PremiumAccount(String username, String type, String email, String phoneNumber, String nik, double balance, String password) {
        super(username, "Premium", email, phoneNumber, balance, password);
        this.nik = nik;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }
    
    //Polymorphism
    public void transfer(Account recipient, double amount) {
        double prevBal = getBalance();
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
            recipient.setBalance(recipient.getBalance() + amount);
            System.out.println("Transfer successful.");
            System.out.println("Previous Balance : " + prevBal);
            System.out.println("After Balance : " + getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}