/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bank.BankGui;
import bank.BankViewController;
import customerControl.CustomerViewControl;
import customerGui.CustomerGui;
import handler.CustomerHandler;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bank;


/**
 *
 * @author jakob
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bank bank = null;
        try {
            bank = new Bank();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        BankViewController bvc = new BankViewController(bank);
        BankGui bg = new BankGui(bvc);
        bank.addListener((ActionListener) bg);
        CustomerViewControl cvc = null;
        try {
            cvc = new CustomerViewControl(bank);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        CustomerGui cg = new CustomerGui(cvc);
        bank.addListener((ActionListener) cg);
        bg.validate();
        bg.setLocationRelativeTo(null);
        bg.setVisible(false);
        
    }
    
}
