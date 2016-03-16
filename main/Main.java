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
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
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
            jop.setMessageType(INFORMATION_MESSAGE);
            jop.setMessage("Prøver at oprette forbindelse til serveren, vent venligst");
            jop.setOptions(new Object[]{});
            dialog.setModal(false);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setTitle("Forbinder til serveren");
            dialog.setVisible(true);
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
            dialog.setVisible(false);
            dialog.setTitle("Fejl i opstart");
        } catch (SQLException ex) {
            dialog.setVisible(false);
            dialog.setTitle("Fejl i opstart");
            jop.setMessage("Fejl i forbindelsen til databasen, kontakt support: " + ex.getLocalizedMessage());
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            System.exit(0);
        } catch (ClassNotFoundException ex) {
            dialog.setVisible(false);
            dialog.setTitle("Fejl i opstart");
            jop.setMessage("Der mangler en fil i lib mappen, kontakt support: " + ex.getLocalizedMessage());
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            System.exit(0);
        } catch (IOException ex) {
            dialog.setVisible(false);
            dialog.setTitle("Fejl i opstart");
            jop.setMessage("Kunne ikke få adgang til filen med databaseindstillinger, kontakt support: " + ex.getLocalizedMessage());
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            System.exit(0);
        }

    }

}
