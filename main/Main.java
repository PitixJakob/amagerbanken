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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
        JOptionPane jop = new JOptionPane();
        JDialog dialog = jop.createDialog("Fejl i opstart");
        try {
            Bank bank = new Bank();
            BankViewController bvc = new BankViewController(bank);
            BankGui bg = new BankGui(bvc);
            bank.addListener((ActionListener) bg);
            CustomerViewControl cvc = null;
            cvc = new CustomerViewControl(bank);
            CustomerGui cg = new CustomerGui(cvc);
            bank.addListener((ActionListener) cg);
            bg.validate();
            bg.setLocationRelativeTo(null);
            bg.setVisible(false);
        } catch (SQLException ex) {
            jop.setMessage("Fejl i forbindelsen til databasen, kontakt support: "+ex.getLocalizedMessage());
            dialog.pack();
            dialog.setVisible(true);
        } catch (ClassNotFoundException ex) {
            jop.setMessage("Der mangler en fil i lib mappen, kontakt support: "+ex.getLocalizedMessage());
            dialog.pack();
            dialog.setVisible(true);
        } catch (IOException ex) {
            jop.setMessage("Kunne ikke få adgang til filen med databaseindstillinger, kontakt support: "+ex.getLocalizedMessage());
            dialog.pack();
            dialog.setVisible(true);
        }

    }

}
