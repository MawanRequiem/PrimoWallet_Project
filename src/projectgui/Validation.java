package projectgui;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validation {

    public static boolean isValidMustNumber(String balance) {
        String balanceRegex = "^[1-9]\\d*(\\.\\d+)?$";
        return balance.matches(balanceRegex);
    }

    public static boolean isValidNik(String nik) {
        String nikRegex = "^\\d{16}$";
        return nik.matches(nikRegex);
    }
       
    public static boolean isValidEmail(String email) {
        String emailRegex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^08\\d{8,12}$";
        return phoneNumber.matches(phoneRegex);
    }

    
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        return password.matches(passwordRegex);
    }
    

}