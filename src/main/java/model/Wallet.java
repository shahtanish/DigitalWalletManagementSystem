package model;

public class Wallet {
    private String userEmail;
    private double balance;

    public Wallet() {}

    public Wallet(String userEmail, double balance) {
        this.userEmail = userEmail;
        this.balance = balance;
    }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
