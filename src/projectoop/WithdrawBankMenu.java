package projectoop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class WithdrawBankMenu extends javax.swing.JFrame {
    Connection Con = null;
    PreparedStatement pst = null;
    ResultSet Rs = null;
    Statement St = null;
    
    /**
     * Creates new form RegistersCoba
     */
    public WithdrawBankMenu() {
        initComponents();
    }

    String PhoneNumber;
    double OldBalance;
    
    public WithdrawBankMenu(String Phone) {
        PhoneNumber = Phone;
        initComponents();
    }
    
    private void GetBalance(){
    String Query = "select * from accounttb where PhoneNumber='"+PhoneNumber+"'";
            try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb","root","");
                St = Con.createStatement();
                Rs = St.executeQuery(Query);
                if(Rs.next()){
                    OldBalance = Rs.getDouble(6);
                } else {
                    //JOptionPane.showMessageDialog(this, "Wrong Account Number Or Password");
                }
        
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
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
        backButton_Withdraw = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        continueButton_Withdraw = new javax.swing.JButton();
        withdrawBalance_Withdraw1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        withdrawBalance_Withdraw = new javax.swing.JTextField();
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

        backButton_Withdraw.setBackground(new java.awt.Color(0, 204, 255));
        backButton_Withdraw.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        backButton_Withdraw.setText("Back");
        backButton_Withdraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButton_WithdrawMouseClicked(evt);
            }
        });
        jPanel1.add(backButton_Withdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 185, 45));

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectoop/icon/Artboard 4 copy 3.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Withdraw Balance");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, 24));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 85));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Nominal to Withdraw");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        continueButton_Withdraw.setBackground(new java.awt.Color(0, 204, 255));
        continueButton_Withdraw.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        continueButton_Withdraw.setText("Continue");
        continueButton_Withdraw.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        continueButton_Withdraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                continueButton_WithdrawMouseClicked(evt);
            }
        });
        jPanel1.add(continueButton_Withdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 185, 45));

        withdrawBalance_Withdraw1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawBalance_Withdraw1ActionPerformed(evt);
            }
        });
        jPanel1.add(withdrawBalance_Withdraw1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 425, 30));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter Your Bank Account Number");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        withdrawBalance_Withdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawBalance_WithdrawActionPerformed(evt);
            }
        });
        jPanel1.add(withdrawBalance_Withdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 425, 30));

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

    private void withdrawBalance_WithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawBalance_WithdrawActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_withdrawBalance_WithdrawActionPerformed

    private void withdrawBalance_Withdraw1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawBalance_Withdraw1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_withdrawBalance_Withdraw1ActionPerformed

    private void continueButton_WithdrawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueButton_WithdrawMouseClicked
        if(withdrawBalance_Withdraw.getText().isEmpty() || withdrawBalance_Withdraw.getText().equals(0)){
            JOptionPane.showMessageDialog(this, "Enter Valid Amount");
        } else {
            GetBalance();
            try{
                String Query = "Update accounttb set Balance=? where PhoneNumber=?";
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb","root","");
                PreparedStatement ps = Con.prepareStatement(Query);
                ps.setDouble(1, OldBalance-Double.valueOf(withdrawBalance_Withdraw.getText()));
                ps.setString(2, PhoneNumber);
                if(ps.executeUpdate()==1){
                    JOptionPane.showMessageDialog(this, "Withdraw Succesful");
                } else {
                    JOptionPane.showMessageDialog(this, "Withdraw Failed");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_continueButton_WithdrawMouseClicked

    private void backButton_WithdrawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButton_WithdrawMouseClicked
        new AddMethodMenu(PhoneNumber).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButton_WithdrawMouseClicked

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
            java.util.logging.Logger.getLogger(WithdrawBankMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WithdrawBankMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WithdrawBankMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WithdrawBankMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new WithdrawBankMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton_Withdraw;
    private javax.swing.JButton continueButton_Withdraw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField withdrawBalance_Withdraw;
    private javax.swing.JTextField withdrawBalance_Withdraw1;
    // End of variables declaration//GEN-END:variables
}