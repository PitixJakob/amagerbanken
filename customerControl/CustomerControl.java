/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerControl;

import model.Bank;

/**
 *
 * @author Gudni
 */
public class CustomerControl {
    
    private Bank bank;
    private String username, password;

    public CustomerControl(Bank bank, String username, String password) {
        this.bank = bank;
        this.username = username;
        this.password = password;
         
    }
    
    
    
}
