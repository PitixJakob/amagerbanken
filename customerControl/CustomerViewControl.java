/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerControl;

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

    public CustomerViewControl(Bank bank) {
        this.bank = bank;
        customer = null;
    }
    
    public void login(String cpr, char[] password) throws SQLException{
        customer = bank.getCustomerHandler().customerLogin(cpr, password);
    }
    
    public ArrayList<Account> getAccounts(){
        ArrayList<Account> account = new ArrayList();
        return customer.getAccounts();
    }
    
    public void transfer(long amount){
        customer.
    }
}
