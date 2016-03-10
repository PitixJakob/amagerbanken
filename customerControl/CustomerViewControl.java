/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerControl;

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

    public CustomerViewControl(Bank bank, Customer customer) {
        this.bank = bank;
        this.customer = customer;
    }
    
    public ArrayList<Account> getAccount(){
        ArrayList<Account> account = new ArrayList();
        
    }
    
    
    
}
