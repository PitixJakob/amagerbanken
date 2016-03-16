/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Account;
import model.Current;
import model.Customer;

/**
 *
 * @author Morten Ricki Rasmussen
 */
public class AccountPanel extends javax.swing.JPanel {

    private Customer customer;
    private Account toAccount;
    private Account account;
    private DefaultComboBoxModel model;
    private BankViewControl bvc;

    public AccountPanel(Account account, Customer customer, BankViewControl bvc) {
        initComponents();
        this.account = account;
        this.customer = customer;
        model = new DefaultComboBoxModel();
        this.bvc = bvc;
        setData();
    }

    public void setData() {
        String reg = "" + account.getRegNr();
        String number = "" + account.getAccountNumber();
        String regAndNumber = reg + " - " + number;
        String balance = account.getBalanceFormat();
        if (account.getAccountType() == 2){
            overdrawButton.setVisible(false);
        }
        accNumberField.setText(regAndNumber);
        balanceField.setText(balance);
        interestLabel.setText("Nuværende Rente: " + account.getInterest());
        overdrawLabel.setText("Nuværende overtræk: " + account.getOverdrawFormat());
        transferLabel1.setText("Du overfører fra " + regAndNumber);
        transferLabel4.setText("Du overfører fra " + regAndNumber);
    }

    public void showError(String header, String line1, String line2, String line3) {
        jLabel21.setText(header);
        jLabel22.setText(line1);
        jLabel23.setText(line2);
        jLabel24.setText(line3);
        BankGui.updateDialog(errorDialog);
    }

    public long getNumber(JTextField field) {
        long amount;
        String stringAmount = field.getText();
        if (field.getText().contains(".")) {
            int decimals = field.getText().length() - field.getText().lastIndexOf(".");
            stringAmount = field.getText().replace(".", "");
            amount = (long) (Double.parseDouble(stringAmount));
            if (decimals > 2) {
                amount = amount * 10;
            }
        } else {
            amount = (long) (Double.parseDouble(stringAmount) * 100);
        }

        return amount;
    }

    public void enterOnlyNumbers(KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        interestDialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        interestLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        editInterestButton = new javax.swing.JButton();
        overdrawDialog = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        overdrawLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        editOverdrawButton = new javax.swing.JButton();
        inOutDialog = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        inOutCommitButton = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        savingsTransferDialog = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        transferLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        transferLabel2 = new javax.swing.JLabel();
        transferLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        currentTransferDialog = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        transferLabel4 = new javax.swing.JLabel();
        transferLabel5 = new javax.swing.JLabel();
        transferLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        transferLabel7 = new javax.swing.JLabel();
        transferLabel8 = new javax.swing.JLabel();
        confirmDialog = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        errorDialog = new javax.swing.JDialog();
        jButton9 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        accNumberField = new javax.swing.JLabel();
        balanceField = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        interestButton = new javax.swing.JButton();
        overdrawButton = new javax.swing.JButton();
        inOutButton = new javax.swing.JButton();
        transferButton = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ændre Rente");

        interestLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        interestLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        interestLabel.setText("Nuværende Rente:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Ny Rente:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        editInterestButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        editInterestButton.setText("Ændre");
        editInterestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editInterestButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(interestLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(editInterestButton)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(45, 45, 45)
                .addComponent(interestLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editInterestButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout interestDialogLayout = new javax.swing.GroupLayout(interestDialog.getContentPane());
        interestDialog.getContentPane().setLayout(interestDialogLayout);
        interestDialogLayout.setHorizontalGroup(
            interestDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        interestDialogLayout.setVerticalGroup(
            interestDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ændre Tilladte Overtræk");

        overdrawLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        overdrawLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        overdrawLabel.setText("Nuværende Overtræk:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Nyt Overtræk");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        editOverdrawButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        editOverdrawButton.setText("Ændre");
        editOverdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOverdrawButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(overdrawLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(editOverdrawButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(45, 45, 45)
                .addComponent(overdrawLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editOverdrawButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout overdrawDialogLayout = new javax.swing.GroupLayout(overdrawDialog.getContentPane());
        overdrawDialog.getContentPane().setLayout(overdrawDialogLayout);
        overdrawDialogLayout.setHorizontalGroup(
            overdrawDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        overdrawDialogLayout.setVerticalGroup(
            overdrawDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Ind- og Udbetaling");

        inOutCommitButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        inOutCommitButton.setText("Ind- og Udbetal");
        inOutCommitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inOutCommitButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jRadioButton1.setText("Indbetaling");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jRadioButton2.setText("Udbetaling");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Beløb");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(inOutCommitButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField3))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(31, 31, 31)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(inOutCommitButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout inOutDialogLayout = new javax.swing.GroupLayout(inOutDialog.getContentPane());
        inOutDialog.getContentPane().setLayout(inOutDialogLayout);
        inOutDialogLayout.setHorizontalGroup(
            inOutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        inOutDialogLayout.setVerticalGroup(
            inOutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Overfør fra Opsparingskonto");

        transferLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        transferLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transferLabel1.setText("Du er ved at overføre fra kontoen:");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        transferLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        transferLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transferLabel2.setText("Overfør til:");

        transferLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        transferLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transferLabel3.setText("Beløb");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Overfør");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transferLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(transferLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(transferLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transferLabel1)
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transferLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transferLabel3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout savingsTransferDialogLayout = new javax.swing.GroupLayout(savingsTransferDialog.getContentPane());
        savingsTransferDialog.getContentPane().setLayout(savingsTransferDialogLayout);
        savingsTransferDialogLayout.setHorizontalGroup(
            savingsTransferDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savingsTransferDialogLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        savingsTransferDialogLayout.setVerticalGroup(
            savingsTransferDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Overfør fra Lønkonto");

        transferLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        transferLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transferLabel4.setText("Du er ved at overføre fra kontoen:");

        transferLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        transferLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transferLabel5.setText("Overfør til:");

        transferLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        transferLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transferLabel6.setText("Beløb");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("Overfør");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        transferLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        transferLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transferLabel7.setText("Reg. nr");

        transferLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        transferLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transferLabel8.setText("Kontonummer");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transferLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(transferLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(transferLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(transferLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(transferLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transferLabel4)
                .addGap(30, 30, 30)
                .addComponent(transferLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transferLabel7))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transferLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transferLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout currentTransferDialogLayout = new javax.swing.GroupLayout(currentTransferDialog.getContentPane());
        currentTransferDialog.getContentPane().setLayout(currentTransferDialogLayout);
        currentTransferDialogLayout.setHorizontalGroup(
            currentTransferDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentTransferDialogLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        currentTransferDialogLayout.setVerticalGroup(
            currentTransferDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Er du sikker?");

        jButton3.setText("Ja");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Nej");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout confirmDialogLayout = new javax.swing.GroupLayout(confirmDialog.getContentPane());
        confirmDialog.getContentPane().setLayout(confirmDialogLayout);
        confirmDialogLayout.setHorizontalGroup(
            confirmDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(confirmDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(confirmDialogLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(confirmDialogLayout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))))
        );
        confirmDialogLayout.setVerticalGroup(
            confirmDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(35, 35, 35)
                .addGroup(confirmDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jButton9.setText("Færdig");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("jLabel21");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("jLabel21");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("jLabel21");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("jLabel21");

        javax.swing.GroupLayout errorDialogLayout = new javax.swing.GroupLayout(errorDialog.getContentPane());
        errorDialog.getContentPane().setLayout(errorDialogLayout);
        errorDialogLayout.setHorizontalGroup(
            errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, errorDialogLayout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(191, 191, 191))
        );
        errorDialogLayout.setVerticalGroup(
            errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, errorDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(60, 60, 60)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addContainerGap())
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1140, 130));
        setMinimumSize(new java.awt.Dimension(1140, 0));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1140, 130));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Reg- og Kontonummer");

        accNumberField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        accNumberField.setText("Reg- og Kontonummer");

        balanceField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        balanceField.setText("Saldo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Saldo");

        interestButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        interestButton.setText("Rente");
        interestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interestButtonActionPerformed(evt);
            }
        });

        overdrawButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        overdrawButton.setText("Overtræk");
        overdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overdrawButtonActionPerformed(evt);
            }
        });

        inOutButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        inOutButton.setText("Ind/Udbetaling");
        inOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inOutButtonActionPerformed(evt);
            }
        });

        transferButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        transferButton.setText("Overfør");
        transferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(balanceField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(interestButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(overdrawButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inOutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transferButton)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(29, 29, 29)
                        .addComponent(balanceField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(accNumberField))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(overdrawButton, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addComponent(inOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addComponent(transferButton, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                    .addComponent(interestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(191, 191, 191))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void interestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interestButtonActionPerformed
        BankGui.updateDialog(interestDialog);
    }//GEN-LAST:event_interestButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!jTextField5.getText().isEmpty()) {
            try {
                long amount = getNumber(jTextField5);

                long acc = Long.parseLong(jTextField7.getText());
                int reg = Integer.parseInt(jTextField6.getText());

                toAccount = new Current(acc, reg);
                if (bvc.transfer(account, toAccount, amount)) {
                    BankGui.updateDialog(confirmDialog);
                    BankGui.updateDialog(currentTransferDialog);
                } else {
                    showError("Fejl", "Overførsel ikke mulig", "Den valgte modtager konto eksisterer muligvis ikke", "Man kan ikke overføre 0 kr");
                }
            } catch (SQLException ex) {
                showError("Det er sket en uventet fejl", "Forbindelse til databasen er nede", "Kontakt support", ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            bvc.commit();
            BankGui.updateDialog(confirmDialog);
        } catch (SQLException ex) {
            showError("Det er sket en uventet fejl", "Forbindelse til databasen er nede", "Kontakt support", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            showError("Det er sket en uventet fejl", "Kan ikke find database driver", "Kontakt support", ex.getMessage());
        } catch (IOException ex) {
            showError("Det er sket en uventet fejl", "System fejl", "Kontakt support", ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void editInterestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editInterestButtonActionPerformed
        double interest = Double.parseDouble(jTextField1.getText());
        try {
            bvc.editInterest(account, interest);
            JOptionPane.showMessageDialog(null, "Rente ændret");
            BankGui.updateDialog(interestDialog);
        } catch (SQLException ex) {
            showError("Det er sket en uventet fejl", "Forbindelse til databasen er nede", "Kontakt support", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            showError("Det er sket en uventet fejl", "Kan ikke find database driver", "Kontakt support", ex.getMessage());
        } catch (IOException ex) {
            showError("Det er sket en uventet fejl", "System fejl", "Kontakt support", ex.getMessage());
        }
    }//GEN-LAST:event_editInterestButtonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void inOutCommitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inOutCommitButtonActionPerformed
        long amount = (long) (Double.parseDouble(jTextField3.getText()) * 100);

        try {
            System.out.println(amount);
            if (jRadioButton1.isSelected()) {
                bvc.deposit(account, amount);
                BankGui.updateDialog(inOutDialog);
                BankGui.updateDialog(confirmDialog);
            } else if (jRadioButton2.isSelected()) {
                bvc.withdraw(account, amount);
                BankGui.updateDialog(inOutDialog);
                BankGui.updateDialog(confirmDialog);
            }
        } catch (Exception e) {
            showError("Det er sket en uventet fejl", "Forbindelse til databasen er nede", "Kontakt support", e.getMessage());
        }
    }//GEN-LAST:event_inOutCommitButtonActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        inOutCommitButton.setText("Indbetal");
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        inOutCommitButton.setText("Udbetal");
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void transferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferButtonActionPerformed
        if (account.getAccountType() == 1) {
            BankGui.updateDialog(currentTransferDialog);
        } else {
            ArrayList<Account> accounts = customer.getAccounts();
            for (Account account1 : accounts) {
                if (account1 != this.account) {
                    model.addElement(account1);
                }
            }
            jComboBox1.setModel(model);
            BankGui.updateDialog(savingsTransferDialog);
        }
    }//GEN-LAST:event_transferButtonActionPerformed

    private void editOverdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editOverdrawButtonActionPerformed
        long overdraw = (long) (Double.parseDouble(jTextField2.getText()) * 100);

        try {
            bvc.editOverdraw(account, overdraw);
            JOptionPane.showMessageDialog(null, "Overtræk Ændret");
            BankGui.updateDialog(overdrawDialog);
        } catch (SQLException ex) {
            showError("Det er sket en uventet fejl", "Forbindelse til databasen er nede", "Kontakt support", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            showError("Det er sket en uventet fejl", "Kan ikke find database driver", "Kontakt support", ex.getMessage());
        } catch (IOException ex) {
            showError("Det er sket en uventet fejl", "System fejl", "Kontakt support", ex.getMessage());
        }
    }//GEN-LAST:event_editOverdrawButtonActionPerformed

    private void overdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overdrawButtonActionPerformed
        BankGui.updateDialog(overdrawDialog);
    }//GEN-LAST:event_overdrawButtonActionPerformed

    private void inOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inOutButtonActionPerformed
        BankGui.updateDialog(inOutDialog);
    }//GEN-LAST:event_inOutButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jTextField4.getText().isEmpty()) {
            try {
                long amount = (long) (Double.parseDouble(jTextField4.getText()) * 100);

                toAccount = (Account) jComboBox1.getSelectedItem();
                if (bvc.transfer(account, toAccount, amount)) {
                    BankGui.updateDialog(confirmDialog);
                    BankGui.updateDialog(currentTransferDialog);
                } else {
                    showError("Fejl", "Overførsel ikke mulig", "Denne konto kan ikke have en balance under 0 kr", "");
                }

            } catch (SQLException ex) {
                showError("Det er sket en uventet fejl", "Forbindelse til databasen er nede", "Kontakt support", ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            bvc.rollback();
            BankGui.updateDialog(confirmDialog);
        } catch (SQLException ex) {
            showError("Det er sket en uventet fejl", "Forbindelse til databasen er nede", "Kontakt support", ex.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        enterOnlyNumbers(evt);
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        enterOnlyNumbers(evt);
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        enterOnlyNumbers(evt);
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        enterOnlyNumbers(evt);
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        enterOnlyNumbers(evt);
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        if (!Character.isDigit(evt.getKeyChar()) || jTextField7.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        if (!Character.isDigit(evt.getKeyChar()) || jTextField6.getText().length() >= 4) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        BankGui.updateDialog(errorDialog);
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accNumberField;
    private javax.swing.JLabel balanceField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDialog confirmDialog;
    private javax.swing.JDialog currentTransferDialog;
    private javax.swing.JButton editInterestButton;
    private javax.swing.JButton editOverdrawButton;
    private javax.swing.JDialog errorDialog;
    private javax.swing.JButton inOutButton;
    private javax.swing.JButton inOutCommitButton;
    private javax.swing.JDialog inOutDialog;
    private javax.swing.JButton interestButton;
    private javax.swing.JDialog interestDialog;
    private javax.swing.JLabel interestLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton overdrawButton;
    private javax.swing.JDialog overdrawDialog;
    private javax.swing.JLabel overdrawLabel;
    private javax.swing.JDialog savingsTransferDialog;
    private javax.swing.JButton transferButton;
    private javax.swing.JLabel transferLabel1;
    private javax.swing.JLabel transferLabel2;
    private javax.swing.JLabel transferLabel3;
    private javax.swing.JLabel transferLabel4;
    private javax.swing.JLabel transferLabel5;
    private javax.swing.JLabel transferLabel6;
    private javax.swing.JLabel transferLabel7;
    private javax.swing.JLabel transferLabel8;
    // End of variables declaration//GEN-END:variables
}
