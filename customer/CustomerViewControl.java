/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Account;
import model.Bank;
import model.Customer;

/**
 *
 * @author Gudni
 */
public class CustomerViewControl {
    
    private Bank bank;
    private Customer customer;

    public CustomerViewControl(Bank bank) throws SQLException {
        this.bank = bank;
        customer = bank.getCustomerHandler().getCustomer("null");
    }
    
    public boolean login(String cpr, char[] password) throws SQLException{
        customer = bank.getCustomerHandler().customerLogin(cpr, password);
        if (customer == null){
            return false;
        }
        return true;
    }
    
    
    public ArrayList<Account> getAccounts(){
        return customer.getAccounts();
    }
    
    public Customer getCustomer() throws SQLException{
        customer = bank.getCustomerHandler().getCustomer(customer.getCpr());
        return customer;
    }
    
    public boolean transfer(Account fromAccount, Account toAccount, long amount) throws SQLException, ClassNotFoundException, IOException{
        return bank.getCustomerHandler().getAccountHandler().transfer(fromAccount, toAccount, amount);
    }
    
    public void commit() throws SQLException, ClassNotFoundException, IOException {
        bank.getCustomerHandler().getAccountHandler().commit();
        bank.notifyAllListeners();
    }
    
    public void rollback() throws SQLException {
        bank.getCustomerHandler().getAccountHandler().rollback();
    }
}
