/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.managment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Aniket
 */
public class return_book extends javax.swing.JFrame {
    public void updateIssueIDS() {
        issues.removeAllItems();
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBMS_Project?useSSL=false", "root", "ani123");
            Statement stm = conn.createStatement();
            String query = "select issueId from issues where isBookReturned=0;";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                issues.addItem(rs.getString("issueId"));
            }
            conn.close();
        }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    /**
     * Creates new form Delete_staff
     */
    String staffId;
    public return_book(String sid) {
        initComponents();
        updateIssueIDS();
        staffId = sid;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        issues = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Return Book");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel2.setText("Issue ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 54, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, -1));

        jLabel3.setText("Return Date");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " ", " " }));
        jComboBox1.setSelectedIndex(3);
        jComboBox1.setSelectedItem(1);
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 53, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        jComboBox2.setSelectedIndex(2);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 51, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
        jComboBox3.setSelectedIndex(8);
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 60, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 150, -1));

        getContentPane().add(issues, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 180, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\New folder\\5th sem\\SD\\LibraryManagementSystem\\Images\\Return-Book.jpg")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 340, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String issueId = issues.getSelectedItem().toString();
        int isBookReturned = 1, isFinePaid = 1;
        String dueDate = "", userId = "", returnDate = (String)jComboBox3.getSelectedItem() + "-" + (String)jComboBox2.getSelectedItem() + "-" + (String)jComboBox1.getSelectedItem(); 
        try
        {
            Class.forName("java.sql.DriverManager");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBMS_Project","root", "ani123");
            Statement stmt = con.createStatement();
            String q ="select isBookReturned, dueDate, userId from issues where issueId= '"+issueId+"';";
            ResultSet rs = stmt.executeQuery(q);
            int countRS = 0, finePerDay = 0;
            while(rs.next())
            {
                countRS++;
                isBookReturned = rs.getInt("isBookReturned");
                dueDate = rs.getString("dueDate");
                userId = rs.getString("userId");
            }
            if(countRS != 1)
            {
                JOptionPane.showMessageDialog(null, "No Records Found");
            }
            else if(isBookReturned == 1)
                JOptionPane.showMessageDialog(null, "Book Has Been Already Returned");
            else
            {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = sdf.parse(dueDate);
                Date date2 = sdf.parse(returnDate);
                long diff = date2.getTime() - date1.getTime(), dayMils = 1000*60*60*24, fine = diff / dayMils;
                fine = fine > 0 ? fine : 0;
                if(fine == 0)
                    isFinePaid = 1;
                else
                    isFinePaid = 0;
                q = "Select finePerDay from user_types inner join lib_users on user_types.userType = lib_users.userType where lib_users.userId = '" +userId+"';";
                rs = stmt.executeQuery(q);
                if(rs.next())
                {
                    finePerDay = rs.getInt("finePerDay");
                    fine *= finePerDay;
                    q = "update issues set isBookReturned = 1, isFinePaid = "+isFinePaid+" ,returnStaffId = '"+staffId+"', fine = "+fine+" where issueId="+issueId+";";
                    stmt.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Book Has Now Been Returned. An amount of "+fine+" has to be collected");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Something Went Wrong");
                }
            }
        }
        catch (Exception x)
        {
            JOptionPane.showMessageDialog(this,x.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(return_book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(return_book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(return_book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(return_book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new return_book("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> issues;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
