package model;

import handler.CustomerHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Morten Ricki Rasmussen 
 */
public class Bank {
    private Customer customer;
    private Current account;
    private Current cash;
    private CustomerHandler ch;
    private ArrayList<ActionListener>listeners;
    
    public Bank() throws ClassNotFoundException, SQLException, IOException {
        ch = new CustomerHandler();
        listeners = new ArrayList<>();
        setInfo();
    }
     
    /**
     * Method loads bank and info from database
     */
    public void setInfo() {
        try {
            ArrayList accounts = ch.getAccountHandler().getAccounts("0000000000");
            account = (Current) accounts.get(0);
            cash = (Current) accounts.get(1);
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void setCustomer(Customer customer) {
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

    public Current getAccount() {
        return account;
    }

    public Current getCash() {
        return cash;
    }
    
    
    
    public void updateCustomer(String name, int phone, String email){
        customer.setName(name);
        customer.setPhone(phone);
        customer.setEmail(email);
    }
    
    public void addListener(ActionListener listener){
        if(!listeners.contains(listener)){
            listeners.add(listener);
        } 
    }
    
    public void notifyAllListeners(){
        for (ActionListener listener : listeners) {
            listener.actionPerformed(new ActionEvent(this, 1, null));
        }
    }
    
}
