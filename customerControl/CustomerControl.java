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
    private String password;
    private int cpr;

    public CustomerControl(Bank bank, int cpr, String password) {
        this.bank = bank;
        this.cpr = cpr;
        this.password = password;
         
    }
    
    
    
}
