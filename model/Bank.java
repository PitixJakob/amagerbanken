package model;

import java.util.ArrayList;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public class Bank {
    private ArrayList<Customer> customers;
    private Current account;
    private Current cash;
    
    public Bank() {
        setInfo();
    }
     
    /**
     * Method loads bank and info from database
     */
    public void setInfo() {
        
    }
    
    public void setCustomers(ArrayList customers) {
        this.customers = customers;
    }
    
    public void setAccount(Current account) {
        this.account = account;
    }
    
    public void setCash(Current cash) {
        this.cash = cash;
    }
    
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
}
