package projectoop;

//Inheritence
public class RegulerAccount extends Account {
    public RegulerAccount(String username, String type ,String email, String phoneNumber, double balance, String password) {
        super(username, "Reguler", email, phoneNumber, balance, password);
    }
}