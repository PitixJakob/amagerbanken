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
    private String username;
    private String password;
    private ArrayList<Account> accounts;
    
    public Customer(String name, int phone, String email, String username, String password, ArrayList<Account> accounts) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.accounts = accounts;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setAccounts(ArrayList accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    } 
    
    
    
}
