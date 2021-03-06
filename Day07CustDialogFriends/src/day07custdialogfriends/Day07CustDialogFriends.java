/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day07custdialogfriends;

import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;

/**
 *
 * @author YingLuo
 */
public class Day07CustDialogFriends extends javax.swing.JFrame {

    /**
     * Creates new form Day07CustDialogFriends
     */
    
    DefaultListModel<String> modelFriendsList = new DefaultListModel();
    
    int currentlyEditedItemIndex = -1; // adding, not editing
    
    
    
    public Day07CustDialogFriends() {
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

        dlgAddEdit = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        dlgAddEdit_tfName = new javax.swing.JTextField();
        dlgAddEdit_btCancel = new javax.swing.JButton();
        blgAddEdit_btSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFriends = new javax.swing.JList<>();
        lblStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miAddFriend = new javax.swing.JMenu();

        dlgAddEdit.setTitle("Add/Edit");
        dlgAddEdit.setModal(true);
        dlgAddEdit.setResizable(false);

        jLabel1.setText("Name:");

        dlgAddEdit_btCancel.setText("Cancel");
        dlgAddEdit_btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgAddEdit_btCancelActionPerformed(evt);
            }
        });

        blgAddEdit_btSave.setText("Save");
        blgAddEdit_btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blgAddEdit_btSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgAddEditLayout = new javax.swing.GroupLayout(dlgAddEdit.getContentPane());
        dlgAddEdit.getContentPane().setLayout(dlgAddEditLayout);
        dlgAddEditLayout.setHorizontalGroup(
            dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddEditLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addComponent(dlgAddEdit_btCancel)
                        .addGap(88, 88, 88)
                        .addComponent(blgAddEdit_btSave))
                    .addComponent(dlgAddEdit_tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        dlgAddEditLayout.setVerticalGroup(
            dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddEditLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dlgAddEdit_tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgAddEdit_btCancel)
                    .addComponent(blgAddEdit_btSave))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstFriends.setModel(modelFriendsList);
        lstFriends.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstFriendsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstFriends);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lblStatus.setText("jLabel1");
        lblStatus.setMaximumSize(new java.awt.Dimension(45, 5));
        lblStatus.setMinimumSize(new java.awt.Dimension(45, 5));
        getContentPane().add(lblStatus, java.awt.BorderLayout.PAGE_END);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        miAddFriend.setText("Add Friend");
        miAddFriend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miAddFriendMouseClicked(evt);
            }
        });
        jMenuBar1.add(miAddFriend);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miAddFriendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miAddFriendMouseClicked
        // TODO add your handling code here:
        // SHOW the dialog of add friend
        
        blgAddEdit_btSave.setText("Add friend");
        
        currentlyEditedItemIndex = -1;
        
        dlgAddEdit.pack();  // Without this the dialog window will be too small to see
        dlgAddEdit.setLocationRelativeTo(this);
        dlgAddEdit.setVisible(true);
        
        dlgAddEdit_tfName.setText("");
    }//GEN-LAST:event_miAddFriendMouseClicked

    private void dlgAddEdit_btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgAddEdit_btCancelActionPerformed
        // TODO add your handling code here:
        dlgAddEdit.setVisible(false);
        
    }//GEN-LAST:event_dlgAddEdit_btCancelActionPerformed

    private void blgAddEdit_btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blgAddEdit_btSaveActionPerformed
        // TODO add your handling code here:
        String name = dlgAddEdit_tfName.getText();
        // make sure name is not empty
        if(currentlyEditedItemIndex == -1){
            modelFriendsList.addElement(name);
        }else {
            modelFriendsList.set(currentlyEditedItemIndex, name);
        }
        
        dlgAddEdit.setVisible(false);
        
    }//GEN-LAST:event_blgAddEdit_btSaveActionPerformed

    private void lstFriendsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstFriendsMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1){  // if double click happened
            
            int index = lstFriends.getSelectedIndex();
            if(index <0){
                return;
            }
            blgAddEdit_btSave.setText("Update Friend");
            currentlyEditedItemIndex = index;
            dlgAddEdit_tfName.setText(modelFriendsList.get(index));
            
            dlgAddEdit.pack();  // Without this the dialog window will be too small to see
            dlgAddEdit.setVisible(true);
            dlgAddEdit.setLocationRelativeTo(this);
            
        }
        
    }//GEN-LAST:event_lstFriendsMouseClicked

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
            java.util.logging.Logger.getLogger(Day07CustDialogFriends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Day07CustDialogFriends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Day07CustDialogFriends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Day07CustDialogFriends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Day07CustDialogFriends().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blgAddEdit_btSave;
    private javax.swing.JDialog dlgAddEdit;
    private javax.swing.JButton dlgAddEdit_btCancel;
    private javax.swing.JTextField dlgAddEdit_tfName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JList<String> lstFriends;
    private javax.swing.JMenu miAddFriend;
    // End of variables declaration//GEN-END:variables
}
