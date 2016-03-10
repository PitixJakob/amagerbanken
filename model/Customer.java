package model;

import java.util.ArrayList;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public class Customer {
    
    private String name;
    private int phone;
    private String email;
    private String password;
    private String cpr;
    private ArrayList<Account> accounts;
    
    public Customer(String cpr, String name, int phone, String email, String password, ArrayList<Account> accounts) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.cpr = cpr;
        this.accounts = accounts;
    }
    
    public Customer(String cpr, String name, int phone, String email, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.cpr = cpr;
        accounts = new ArrayList<>();
    }
    
    //--------------------------------------------------------------------------
    // Accesors
    //--------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public String getCpr(){
        return cpr;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    
    //--------------------------------------------------------------------------
    // Mutators
    //--------------------------------------------------------------------------

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setCpr(String cpr) {
        this.cpr = cpr;
    }
    
    public void setAccounts(ArrayList accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    } 
    
    
    
}
