package projectgui;

import projectoop.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Personal
 */
public class TransferBalanceMenu extends javax.swing.JFrame {

    /**
     * Creates new form RegistersCoba
     */
    public TransferBalanceMenu() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    Connection Con = null;
    PreparedStatement pst = null;
    ResultSet Rs = null;
    Statement St = null;

    
    String SenderPhoneNumber;
    String RecepientPhoneNumber;
    double OldRecepientBalance;
    double OldSenderBalance;
    public TransferBalanceMenu(String Phone) {
        SenderPhoneNumber = Phone;
        initComponents();
    }
    

    private void GetSenderBalance(){
    String Query = "select * from accounttb where PhoneNumber='"+SenderPhoneNumber+"'";
            try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb","root","");
                St = Con.createStatement();
                Rs = St.executeQuery(Query);
                if(Rs.next()){
                    OldSenderBalance = Rs.getDouble(6);
                    Username = Rs.getString("Username");
                } else {
                    //JOptionPane.showMessageDialog(this, "Wrong Account Number Or Password");
                }
        
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
    }
    
    private void GetRecepientBalance(){
        RecepientPhoneNumber = phoneNumberTextField_Transfer.getText();
        String Query = "select * from accounttb where PhoneNumber='"+RecepientPhoneNumber+"'";
            try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb","root","");
                St = Con.createStatement();
                Rs = St.executeQuery(Query);
                if(Rs.next()){
                    OldRecepientBalance = Rs.getDouble(6);
                } else {
                    //JOptionPane.showMessageDialog(this, "Wrong Account Number Or Password");
                }
        
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
    }
    
    String MyDate;
    String Username;
    public void GetDate(){
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        MyDate = s.format(d);
    }
    
    private void DepositHistory(){
    String QueryAddHistory = "insert into transaction_history(Username, Transaction, Amount, Date) values(?,?,?,?)";
    try { 
            GetDate();
             Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb","root","");
             PreparedStatement His = Con.prepareStatement(QueryAddHistory);
             His.setString(1, Username);
             His.setString(2, "Transfer");
             His.setString(3, transferNominal_Transfer.getText());
             His.setString(4, MyDate);   
             int row = His.executeUpdate();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(this, e.getMessage());
         }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        backButton_Transfer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        continueButton_Transfer = new javax.swing.JButton();
        phoneNumberTextField_Transfer = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        transferNominal_Transfer = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton_Transfer.setBackground(new java.awt.Color(0, 204, 255));
        backButton_Transfer.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        backButton_Transfer.setText("Back");
        backButton_Transfer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButton_TransferMouseClicked(evt);
            }
        });
        backButton_Transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton_TransferActionPerformed(evt);
            }
        });
        jPanel1.add(backButton_Transfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 185, 45));

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectoop/icon/Artboard 4 copy 4.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Transfer Balance");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, 24));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 85));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Recipient Phone Number");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 174, -1, -1));

        continueButton_Transfer.setBackground(new java.awt.Color(0, 204, 255));
        continueButton_Transfer.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        continueButton_Transfer.setText("Continue");
        continueButton_Transfer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        continueButton_Transfer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                continueButton_TransferMouseClicked(evt);
            }
        });
        jPanel1.add(continueButton_Transfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 185, 45));

        phoneNumberTextField_Transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberTextField_TransferActionPerformed(evt);
            }
        });
        jPanel1.add(phoneNumberTextField_Transfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 211, 425, 30));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter Nominal to Transfer");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 254, -1, -1));

        transferNominal_Transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferNominal_TransferActionPerformed(evt);
            }
        });
        jPanel1.add(transferNominal_Transfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 291, 425, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectoop/icon/Artboard 1 copy.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phoneNumberTextField_TransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberTextField_TransferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTextField_TransferActionPerformed

    private void transferNominal_TransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferNominal_TransferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transferNominal_TransferActionPerformed

    private void continueButton_TransferMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueButton_TransferMouseClicked
        String phoneNumber = phoneNumberTextField_Transfer.getText();
        
        if(phoneNumberTextField_Transfer.getText().isEmpty() || transferNominal_Transfer.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing information");
        } else if (!Validation.isValidPhoneNumber(phoneNumberTextField_Transfer.getText())){
            JOptionPane.showMessageDialog(this, "Invalid phone number format");
        } else if (!Validation.isValidMustNumber(transferNominal_Transfer.getText())){
            JOptionPane.showMessageDialog(this, "Invalid nominal format");
        } else {
            GetRecepientBalance();
            GetSenderBalance();
            if (RecepientPhoneNumber.equals(SenderPhoneNumber)){
                JOptionPane.showMessageDialog(this, "You Can't Transfer to Yourself");
            } else {
                try {
                    // Check if recipient phone number exists in the database
                    boolean recipientExists = checkPhoneNumberExistence(phoneNumber);

                    if (!recipientExists) {
                        JOptionPane.showMessageDialog(this, "Recipient phone number not found");
                        return; // Stop further execution
                    }
                    
                    if(OldRecepientBalance < Double.valueOf(transferNominal_Transfer.getText())){
                        JOptionPane.showMessageDialog(this, "Kurang saldonya bos");
                        return;
                    }
                    
                        String QueryTF = "Update accounttb set Balance=? where PhoneNumber=?";
                        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb","root","");
                        St = Con.createStatement();
                            PreparedStatement rc = Con.prepareStatement(QueryTF);
                            PreparedStatement sd = Con.prepareStatement(QueryTF);
                            rc.setDouble(1, OldRecepientBalance+Double.valueOf(transferNominal_Transfer.getText()));
                            rc.setString(2, RecepientPhoneNumber);
                            sd.setDouble(1, OldSenderBalance-Double.valueOf(transferNominal_Transfer.getText()));
                            sd.setString(2, SenderPhoneNumber);
                            if(rc.executeUpdate()==1 && sd.executeUpdate()==1){
                                JOptionPane.showMessageDialog(this, "Transfer Succesful");
                                DepositHistory();
                                String QueryBack = "select * from accounttb where PhoneNumber='"+SenderPhoneNumber+"'";
                                    try{
                                        Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb","root","");
                                        St = Con.createStatement();
                                        Rs = St.executeQuery(QueryBack);
                                        if(Rs.next()){
                                            new MainMenu(Rs.getString(1), Rs.getDouble(6), Rs.getString(4)).setVisible(true);
                                            this.dispose();
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Wrong Account Number Or Password");
                                        }
                                    }catch(Exception e){
                                        JOptionPane.showMessageDialog(this, e);
                                    }
                            } else {
                                JOptionPane.showMessageDialog(this, "Transfer Failed");
                            }
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, e);
                }
            }
        }
    }//GEN-LAST:event_continueButton_TransferMouseClicked

    private boolean checkPhoneNumberExistence(String phoneNumber) {
    try {
        String query = "SELECT * FROM accounttb WHERE PhoneNumber=?";
        PreparedStatement stmt = Con.prepareStatement(query);
        stmt.setString(1, phoneNumber);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
        return false;
    }
}
    
    private void backButton_TransferMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButton_TransferMouseClicked
        String Query = "select * from accounttb where PhoneNumber='"+SenderPhoneNumber+"'";
            try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb","root","");
                St = Con.createStatement();
                Rs = St.executeQuery(Query);
                if(Rs.next()){
                    new MainMenu(Rs.getString(1), Rs.getDouble(6), Rs.getString(4)).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Account Number Or Password");
                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
    }//GEN-LAST:event_backButton_TransferMouseClicked

    private void backButton_TransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton_TransferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton_TransferActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransferBalanceMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransferBalanceMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransferBalanceMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransferBalanceMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransferBalanceMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton_Transfer;
    private javax.swing.JButton continueButton_Transfer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField phoneNumberTextField_Transfer;
    private javax.swing.JTextField transferNominal_Transfer;
    // End of variables declaration//GEN-END:variables
}
