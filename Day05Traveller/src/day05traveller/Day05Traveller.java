/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day05traveller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author YingLuo
 * @since 2020-NOV-18
 * @version 1.0
 */
public class Day05Traveller extends javax.swing.JFrame {
    
    DefaultListModel<Traveller> modelListTraveller = new DefaultListModel<>();
    
    static final String SUFFIX_TXT = ".txt";
    static final String FILENAME_PATTERN = ".+\\.[A-Za-z0-9]+$";
    static final String DATA_FILENAME = "travels.txt";

    /**
     * Creates new form Day05
     */
    public Day05Traveller() throws InvalidDataException {
        initComponents();
        loadDataFromFile();
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstTraveller = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        cmbGender = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfPassportNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfDestAirportCode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfDepDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfRetDate = new javax.swing.JTextField();
        btExport = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Traveller List");

        lstTraveller.setModel(modelListTraveller);
        lstTraveller.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstTraveller.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstTravellerValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstTraveller);

        jLabel2.setText("Name");

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        cmbGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGenderActionPerformed(evt);
            }
        });

        jLabel3.setText("Gender");

        jLabel4.setText("PassportNo.");

        tfPassportNo.setText("XX123456");

        jLabel5.setText("Destination Airport Code");

        tfDestAirportCode.setText("XXX");

        jLabel6.setText("Departure Date");

        tfDepDate.setText("yyyy-mm-dd");
        tfDepDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDepDateActionPerformed(evt);
            }
        });

        jLabel7.setText("Return Date");

        tfRetDate.setText("yyyy-mm-dd");

        btExport.setText("Export to Document");
        btExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportActionPerformed(evt);
            }
        });

        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btUpdate.setText("Update");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btExport)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(btDelete)
                        .addGap(51, 51, 51)
                        .addComponent(btUpdate))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbGender, 0, 203, Short.MAX_VALUE)
                                    .addComponent(tfPassportNo)
                                    .addComponent(tfDestAirportCode)
                                    .addComponent(tfDepDate)
                                    .addComponent(tfName)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(tfRetDate, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfPassportNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDestAirportCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDepDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfRetDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd)
                    .addComponent(btExport)
                    .addComponent(btDelete)
                    .addComponent(btUpdate))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfDepDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDepDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDepDateActionPerformed

    private void cmbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGenderActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        saveDataToFile(new File(DATA_FILENAME));
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportActionPerformed
        // TODO add your handling code here:
        
        fileChooser.setDialogTitle("Export to File");
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            
            File chosenFile = fileChooser.getSelectedFile();
            
            if(!chosenFile.getName().toLowerCase().matches(FILENAME_PATTERN)){
                
                chosenFile = new File(fileChooser.getSelectedFile() + SUFFIX_TXT);
            }
            
            saveDataToFile(chosenFile);
        }
    }//GEN-LAST:event_btExportActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        try{
                    Traveller traveller = new Traveller(
                                                        tfName.getText(),
                                                        Gender.valueOf(cmbGender.getSelectedItem().toString()),
                                                        tfPassportNo.getText(),
                                                        tfDestAirportCode.getText(),
                                                        Traveller.dateFormat.parse(tfDepDate.getText()),
                                                        Traveller.dateFormat.parse(tfRetDate.getText())
                                                        );
                    
                    modelListTraveller.addElement(traveller);
                    
                }catch (ParseException ex){
                    
                    JOptionPane.showMessageDialog(this, "Faile to parse the input date: " + ex.getMessage());
                    
                }catch (InvalidDataException exc){
                    
                    JOptionPane.showMessageDialog(this, "Faile to create a new Traveller: " + exc.getMessage());
                }
        
    }//GEN-LAST:event_btAddActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        Traveller traveller = lstTraveller.getSelectedValue();
        if (traveller == null) { // this should never happen because button is disabled if no selection
            return;
        }
        int decision = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this item?\n" + traveller.toDataString(),
                "Confirm deletion",
                JOptionPane.OK_CANCEL_OPTION);
        if (decision == JOptionPane.OK_OPTION) {
            modelListTraveller.removeElement(traveller);
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        // TODO add your handling code here:
        Traveller traveller = lstTraveller.getSelectedValue();
        if (traveller == null) { // this should never happen because button is disabled if no selection
            return;
        }
        try {
            traveller.setName(tfName.getText());
            traveller.setGender(Gender.valueOf(cmbGender.getSelectedItem().toString()));
            traveller.setPassportNo(tfPassportNo.getText());
            traveller.setDestAirportCode(tfDestAirportCode.getText());
            traveller.setDepDate(Traveller.dateFormat.parse(tfDepDate.getText()));
            traveller.setRetDate(Traveller.dateFormat.parse(tfRetDate.getText()));
            
            lstTraveller.setModel(modelListTraveller); // force JList to re-read data
            tfName.setText("");
            cmbGender.setSelectedIndex(0);
            tfPassportNo.setText("");
            tfDestAirportCode.setText("");
            tfDepDate.setText("");
            tfRetDate.setText("");
            
        }catch (ParseException ex){
                    
                    JOptionPane.showMessageDialog(this, "Faile to parse the input date: " + ex.getMessage());
                    
                }catch (InvalidDataException exc){
                    
                    JOptionPane.showMessageDialog(this, "Faile to create a new Traveller: " + exc.getMessage());
                }

        
    }//GEN-LAST:event_btUpdateActionPerformed

    private void lstTravellerValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstTravellerValueChanged
        // TODO add your handling code here:
        Traveller traveller = lstTraveller.getSelectedValue();
        if (traveller != null) {
            tfName.setText(traveller.getName());
            cmbGender.getModel().setSelectedItem(traveller.getGender());
            tfPassportNo.setText(traveller.getPassportNo());
            tfDestAirportCode.setText(traveller.getDestAirportCode());
            tfDepDate.setText(Traveller.dateFormat.format(traveller.getDepDate()));
            tfRetDate.setText(Traveller.dateFormat.format(traveller.getRetDate()));
            btDelete.setEnabled(true);
            btUpdate.setEnabled(true);
        } else {
            btDelete.setEnabled(false);
            btUpdate.setEnabled(false);
        }
        
    }//GEN-LAST:event_lstTravellerValueChanged
  
    void loadDataFromFile() {
        
        int lineNo = 0;
        try (Scanner fileInput = new Scanner(new File(DATA_FILENAME))) {
            while (fileInput.hasNextLine()) {
                lineNo++;
                String line = fileInput.nextLine();
                String[] dataStr = line.split(";");
                if (dataStr.length != 6) {
                    JOptionPane.showMessageDialog(this, "Invalid data structure in line: " + lineNo);
                }
                
                try{
                    Traveller traveller = new Traveller(dataStr[0],
                                                    Gender.valueOf(dataStr[1]),
                                                    dataStr[2],
                                                    dataStr[3],
                                                    Traveller.dateFormat.parse(dataStr[4]),
                                                    Traveller.dateFormat.parse(dataStr[5]));
                    
                    modelListTraveller.addElement(traveller);
                    
                }catch (ParseException ex){
                    
                    JOptionPane.showMessageDialog(this, "Faile to parse the input date: " + ex.getMessage());
                    
                }catch (InvalidDataException exc){
                    
                    JOptionPane.showMessageDialog(this, "Faile to create a new Traveller: " + exc.getMessage());
                }

            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Errors reading data file" + e.getMessage());
        }
        
    }
    
    void saveDataToFile(File file) {
        
        try (PrintWriter fileOutput = new PrintWriter(file)) {

            for (int i = 0; i < modelListTraveller.size(); i++) {
                
                String dataLine = modelListTraveller.getElementAt(i).toDataString();
                
                fileOutput.println(dataLine);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data to file:\n" + ex.getMessage(),
                    "File error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
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
            java.util.logging.Logger.getLogger(Day05Traveller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Day05Traveller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Day05Traveller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Day05Traveller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new Day05Traveller().setVisible(true);
                } catch (InvalidDataException ex) {
                    JOptionPane.showMessageDialog(null, "Error in Traveller List: " + ex.getMessage());
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btExport;
    private javax.swing.JButton btUpdate;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Traveller> lstTraveller;
    private javax.swing.JTextField tfDepDate;
    private javax.swing.JTextField tfDestAirportCode;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPassportNo;
    private javax.swing.JTextField tfRetDate;
    // End of variables declaration//GEN-END:variables
}
