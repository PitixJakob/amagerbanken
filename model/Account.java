package model;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public abstract class Account {
    
    private long accountNumber;
    private int regNr;
    private long balance;
    private double interest;
    private long overdraw;
    
    public Account(long accountNumber, int regNr, long balance, double interest, long overdraw) {
        this.accountNumber = accountNumber;
        this.regNr = regNr;
        this.balance = balance;
        this.interest = interest;
        this.overdraw = overdraw;
    }
    
    public Account(long accountNumber, int regNr) {
        this.accountNumber = accountNumber;
        this.regNr = regNr;
    }
    
    public abstract int getAccountType();
    
    //--------------------------------------------------------------------------
    // Accessors
    //--------------------------------------------------------------------------

    public long getAccountNumber() {
        return accountNumber;
    }

    public int getRegNr() {
        return regNr;
    }

    public long getBalance() {
        return balance;
    }

    public double getInterest() {
        return interest;
    }

    public long getOverdraw() {
        return overdraw;
    }
    
    public String getBalanceFormat() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
        String b = nf.format(((double) balance) / 100);
        return b;
    }
    
    public String getOverdrawFormat() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
        String b = nf.format(((double) overdraw / 100));
        return b;
    }
    
    //--------------------------------------------------------------------------
    // Mutators
    //--------------------------------------------------------------------------
    
    public void deposit(long amount) {
        balance = balance + amount;
    }
    
    public void withdraw(long amount) {
        balance = balance - amount;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setOverdraw(long overdraw) {
        this.overdraw = overdraw;
    }
    
    /**
     * Method used for tranfering money from account to account
     * @param reciver
     * @param amount
     * @return true if transfer compplete othervise returns false
     */
    public boolean transfer(Account reciver, int amount) {
        if (amount <= balance) {
            balance = balance - amount;
            reciver.deposit(amount);
            return true;
        } else {
            return false;
        }
    }
    
    public String toString() {
        return regNr + " - " + accountNumber + ": " + getBalanceFormat();
    }
}
    
