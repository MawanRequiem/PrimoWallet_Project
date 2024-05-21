package projectgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import projectoop.*;

/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Personal
 */
public class UTPMenu extends javax.swing.JFrame {
    
    Connection Con = null;
    PreparedStatement pst = null;
    ResultSet Rs = null;
    Statement St = null;
    
    public UTPMenu() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    String PhoneNumber;
    public UTPMenu(String PN) {
        PhoneNumber = PN;
        initComponents();

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
        backButton_UTP = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        continueButton_UTP = new javax.swing.JButton();
        nikTextField_UTP = new javax.swing.JTextField();
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

        backButton_UTP.setBackground(new java.awt.Color(249, 249, 249));
        backButton_UTP.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        backButton_UTP.setText("Back");
        backButton_UTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton_UTPActionPerformed(evt);
            }
        });
        jPanel1.add(backButton_UTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 259, 185, 45));

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectoop/icon/Artboard 4 copy 5.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Upgrade to Premium");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, 24));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 85));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter NIK to Continue Upgrading Account");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 174, -1, -1));

        continueButton_UTP.setBackground(new java.awt.Color(249, 249, 249));
        continueButton_UTP.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        continueButton_UTP.setText("Continue");
        continueButton_UTP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        continueButton_UTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButton_UTPActionPerformed(evt);
            }
        });
        jPanel1.add(continueButton_UTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 259, 185, 45));

        nikTextField_UTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nikTextField_UTPActionPerformed(evt);
            }
        });
        jPanel1.add(nikTextField_UTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 211, 425, 30));

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
    
    
    private void nikTextField_UTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nikTextField_UTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nikTextField_UTPActionPerformed

    private void continueButton_UTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButton_UTPActionPerformed
        if(nikTextField_UTP.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing information");
        } else if (!Validation.isValidNik(nikTextField_UTP.getText())){
            JOptionPane.showMessageDialog(this, "Invalid NIK format");
        }
        else {
            try{
                
                // Cek apakah username atau nomor telepon sudah ada di database
                try {
                    Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb","root","");
                    PreparedStatement checkStmt = Con.prepareStatement("SELECT * FROM accounttb WHERE NIK=?");
                    checkStmt.setString(1, nikTextField_UTP.getText());
                    ResultSet rs = checkStmt.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "NIK already exists");
                        return; // Stop further execution
                    }
                    Con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                    return; // Stop further execution
                }
                
                String Query = "Update accounttb set NIK=?, Type=? where PhoneNumber=?";
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb","root","");
                PreparedStatement ps = Con.prepareStatement(Query);
                ps.setString(1, nikTextField_UTP.getText());
                ps.setString(2, "Premium");
                ps.setString(3, PhoneNumber);
                if(ps.executeUpdate()==1){
                    JOptionPane.showMessageDialog(this, "Upgrade Succesful");
                    Con.close();
                } else {
                    JOptionPane.showMessageDialog(this, "Upgrade Failed");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_continueButton_UTPActionPerformed

    private void backButton_UTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton_UTPActionPerformed
        String Query = "select * from accounttb where PhoneNumber='"+PhoneNumber+"'";
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
    }//GEN-LAST:event_backButton_UTPActionPerformed

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
            java.util.logging.Logger.getLogger(UTPMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UTPMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UTPMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UTPMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new UTPMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton_UTP;
    private javax.swing.JButton continueButton_UTP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nikTextField_UTP;
    // End of variables declaration//GEN-END:variables
}