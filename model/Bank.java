package model;

import handler.CustomerHandler;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public class Bank {
    private Customer customer;
    private Current account;
    private Current cash;
    private CustomerHandler ch;
    
    public Bank() throws ClassNotFoundException, SQLException, IOException {
        setInfo();
        ch = new CustomerHandler();
    }
     
    /**
     * Method loads bank and info from database
     */
    public void setInfo() {
        
    }
    
    
    public void setCustomers(Customer customer) {
        this.customer = customer;
    }
    
    public void setAccount(Current account) {
        this.account = account;
    }
    
    public void setCash(Current cash) {
        this.cash = cash;
    }
        
    public CustomerHandler getCustomerHandler(){
        return ch;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public void updateCustomer(String cpr, String name, int phone, String email){
        customer.setName(name);
        customer.setPhone(phone);
        customer.setEmail(email);
    }
    
}
