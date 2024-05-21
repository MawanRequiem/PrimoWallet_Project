package projectoop;

import java.util.Scanner;

//Balance abstract class
interface Balance {
    //abstract method
    public abstract void deposit(Scanner scanner, Account loggedInAccount);
    public abstract void withdraw(Scanner scanner, Account loggedInAccount);
}





