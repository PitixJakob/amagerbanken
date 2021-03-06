/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
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
    private CustomerViewControl cvc;

    /**
     * Creates new form accountPanel
     *
     * @param account
     */
    public AccountPanel(Account account, Customer customer, CustomerViewControl cvc) {
        initComponents();
        this.account = account;
        this.customer = customer;
        model = new DefaultComboBoxModel();
        this.cvc = cvc;
        setData();
    }

    public void setData() {
        String reg = "" + account.getRegNr();
        String number = "" + account.getAccountNumber();
        String regAndNumber = reg + " - " + number;
        String balance = account.getBalanceFormat();
        accNumberField.setText(regAndNumber);
        balanceField.setText(balance);
        interestField.setText(account.getInterest()+"%");
        overdrawField.setText(account.getOverdrawFormat());
        transferLabel1.setText("Du overfører fra " + regAndNumber);
        transferLabel4.setText("Du overfører fra " + regAndNumber);
    }
    
    public void showError(String header, String line1, String line2, String line3) {
        jLabel21.setText(header);
        jLabel22.setText(line1);
        jLabel23.setText(line2);
        jLabel24.setText(line3);
        updateDialog(errorDialog);
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
    
    public void updateDialog(JDialog dialog) {
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        if (dialog.isVisible()) {
            dialog.setVisible(false);
        } else {
            dialog.setVisible(true);
        }
    }
    
    public void enterOnlyNumbers(KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        savingsTransferDialog = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        transferLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<String>();
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
        transferButton = new javax.swing.JButton();
        interestField = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        overdrawField = new javax.swing.JLabel();

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
        setPreferredSize(new java.awt.Dimension(900, 130));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Reg- og Kontonummer");

        accNumberField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        accNumberField.setText("Reg- og Kontonummer");

        balanceField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        balanceField.setText("Saldo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Saldo");

        transferButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        transferButton.setText("Overfør");
        transferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferButtonActionPerformed(evt);
            }
        });

        interestField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        interestField.setText("Rente");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Rente");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setText("Overtræk");

        overdrawField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        overdrawField.setText("Overtræk");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(interestField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(overdrawField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transferButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(accNumberField))
                    .addComponent(transferButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel13))
                            .addGap(29, 29, 29)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(interestField)
                                .addComponent(overdrawField)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(29, 29, 29)
                            .addComponent(balanceField))))
                .addGap(191, 191, 191))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!jTextField5.getText().isEmpty()) {
            try {
                long amount = getNumber(jTextField5);

                long acc = Long.parseLong(jTextField7.getText());
                int reg = Integer.parseInt(jTextField6.getText());

                toAccount = new Current(acc, reg);
                if (cvc.transfer(account, toAccount, amount)) {
                    updateDialog(confirmDialog);
                    updateDialog(currentTransferDialog);
                } else {
                    showError("Fejl", "Overførsel ikke mulig", "Den valgte modtager konto eksisterer muligvis ikke", "Man kan ikke overføre 0 kr eller et minus beløb");
                }
            } catch (SQLException ex) {
                showError("Det er sket en uventet fejl", "Forbindelse til databasen er nede", "Kontakt support", ex.getMessage());
            } catch (ClassNotFoundException ex) {
                showError("Det er sket en uventet fejl", "Kan ikke find database driver", "Kontakt support", ex.getMessage());
            } catch (IOException ex) {
                showError("Det er sket en uventet fejl", "System fejl", "Kontakt support", ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            cvc.commit();
            updateDialog(confirmDialog);
        } catch (SQLException ex) {
            showError("Det er sket en uventet fejl", "Forbindelse til databasen er nede", "Kontakt support", ex.getMessage());
        } catch (ClassNotFoundException ex) {
            showError("Det er sket en uventet fejl", "Kan ikke find database driver", "Kontakt support", ex.getMessage());
        } catch (IOException ex) {
            showError("Det er sket en uventet fejl", "System fejl", "Kontakt support", ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void transferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferButtonActionPerformed
        if (account.getAccountType() == 1) {
            updateDialog(currentTransferDialog);
        } else {
            for (Account account1 : customer.getAccounts()) {
                if (account1.getAccountNumber() != account.getAccountNumber()) {
                    model.addElement(account1);
                }
            }
            jComboBox1.setModel(model);
            updateDialog(savingsTransferDialog);
        }
    }//GEN-LAST:event_transferButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jTextField4.getText().isEmpty()) {
            try {
                long amount = (long) (Double.parseDouble(jTextField4.getText()) * 100);

                toAccount = (Account) jComboBox1.getSelectedItem();
                if (cvc.transfer(account, toAccount, amount)) {
                    updateDialog(confirmDialog);
                    updateDialog(savingsTransferDialog);
                } else {
                    showError("Fejl", "Overførsel ikke mulig", "Denne konto kan ikke have en balance under 0 kr", "");
                }

            } catch (SQLException ex) {
                showError("Det er sket en uventet fejl", "Forbindelse til databasen er nede", "Kontakt support", ex.getMessage());
            } catch (ClassNotFoundException ex) {
                showError("Det er sket en uventet fejl", "Kan ikke find database driver", "Kontakt support", ex.getMessage());
            } catch (IOException ex) {
                showError("Det er sket en uventet fejl", "System fejl", "Kontakt support", ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            cvc.rollback();
            updateDialog(confirmDialog);
        } catch (SQLException ex) {
            showError("Det er sket en uventet fejl", "Forbindelse til databasen er nede", "Kontakt support", ex.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
        if (!Character.isDigit(evt.getKeyChar()) || jTextField7.getText().length() >= 4) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        updateDialog(errorDialog);
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accNumberField;
    private javax.swing.JLabel balanceField;
    private javax.swing.JDialog confirmDialog;
    private javax.swing.JDialog currentTransferDialog;
    private javax.swing.JDialog errorDialog;
    private javax.swing.JLabel interestField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel overdrawField;
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
