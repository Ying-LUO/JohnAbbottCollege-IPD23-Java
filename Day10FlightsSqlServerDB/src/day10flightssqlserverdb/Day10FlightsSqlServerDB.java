/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day10flightssqlserverdb;

import java.awt.Dimension;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author YingLuo
 */
public class Day10FlightsSqlServerDB extends javax.swing.JFrame {

    /**
     * Creates new form Day10FlightsSqlServerDB
     */
    
    DefaultListModel<Flight> listModelFlight = new DefaultListModel<>();
    DefaultComboBoxModel<Flight.Type> comboBoxModelFlightType = new DefaultComboBoxModel<>(Flight.Type.values());
    int currentlyEditedItemIndex = -1;  //adding
    Database db;        
    
    static final String SUFFIX_TXT = ".txt";
    static final String FILENAME_PATTERN = ".+\\.[A-Za-z0-9]+$";
            
    public Day10FlightsSqlServerDB() {
        initComponents();
        this.setPreferredSize(new Dimension(800, 600));
        try{
            db = new Database();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect" + ex.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
            
        }
        
        loadFlightFromDatabase();
    }
    
    private void loadFlightFromDatabase(){
        
        try{
            ArrayList<Flight> list = db.getAllFlights();
            
            listModelFlight.clear();
            listModelFlight.addAll(list);
            
        }catch(SQLException ex){    
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect" + ex.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
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

        fileChooser = new javax.swing.JFileChooser();
        dlgAddEdit = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        dlgAddEdit_lblId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dlgAddEdit_ftfOnDay = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dlgAddEdit_tfFromCode = new javax.swing.JTextField();
        dlgAddEdit_tfToCode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dlgAddEdit_cmbType = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        dlgAddEdit_sliderPassengers = new javax.swing.JSlider();
        dlgAddEdit_lblPassengers = new javax.swing.JLabel();
        dlgAddEdit_btCancel = new javax.swing.JButton();
        dlgAddEdit_btSave = new javax.swing.JButton();
        popupMenu = new javax.swing.JPopupMenu();
        miPopupDelete = new javax.swing.JMenuItem();
        lblStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFlight = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miSave = new javax.swing.JMenuItem();
        miExit = new javax.swing.JMenuItem();
        mnAdd = new javax.swing.JMenu();

        dlgAddEdit.setModal(true);
        dlgAddEdit.setResizable(false);

        jLabel1.setText("Id");

        dlgAddEdit_lblId.setText("-");

        jLabel2.setText("On Day");

        dlgAddEdit_ftfOnDay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));

        jLabel3.setText("From code");

        jLabel4.setText("To code");

        jLabel5.setText("Type");

        dlgAddEdit_cmbType.setModel(comboBoxModelFlightType);

        jLabel6.setText("Passengers");

        dlgAddEdit_sliderPassengers.setMajorTickSpacing(50);
        dlgAddEdit_sliderPassengers.setMaximum(200);
        dlgAddEdit_sliderPassengers.setMinorTickSpacing(25);
        dlgAddEdit_sliderPassengers.setPaintLabels(true);
        dlgAddEdit_sliderPassengers.setPaintTicks(true);
        dlgAddEdit_sliderPassengers.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dlgAddEdit_sliderPassengersStateChanged(evt);
            }
        });

        dlgAddEdit_lblPassengers.setText("______");

        dlgAddEdit_btCancel.setText("Cancel");
        dlgAddEdit_btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgAddEdit_btCancelActionPerformed(evt);
            }
        });

        dlgAddEdit_btSave.setText("Save");
        dlgAddEdit_btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgAddEdit_btSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgAddEditLayout = new javax.swing.GroupLayout(dlgAddEdit.getContentPane());
        dlgAddEdit.getContentPane().setLayout(dlgAddEditLayout);
        dlgAddEditLayout.setHorizontalGroup(
            dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddEditLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addComponent(dlgAddEdit_btCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dlgAddEdit_btSave))
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(dlgAddEdit_lblPassengers))
                        .addGap(18, 18, 18)
                        .addComponent(dlgAddEdit_sliderPassengers, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dlgAddEditLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(dlgAddEdit_lblId))
                            .addGroup(dlgAddEditLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(dlgAddEdit_ftfOnDay, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dlgAddEdit_tfToCode)
                            .addComponent(dlgAddEdit_tfFromCode)
                            .addComponent(dlgAddEdit_cmbType, 0, 254, Short.MAX_VALUE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        dlgAddEditLayout.setVerticalGroup(
            dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddEditLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dlgAddEdit_lblId))
                .addGap(11, 11, 11)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dlgAddEdit_ftfOnDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dlgAddEdit_tfFromCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dlgAddEdit_tfToCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dlgAddEdit_cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(dlgAddEdit_lblPassengers))
                    .addComponent(dlgAddEdit_sliderPassengers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgAddEdit_btCancel)
                    .addComponent(dlgAddEdit_btSave))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        miPopupDelete.setText("Delete");
        miPopupDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPopupDeleteActionPerformed(evt);
            }
        });
        popupMenu.add(miPopupDelete);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        lblStatus.setText("Total Flights");
        getContentPane().add(lblStatus, java.awt.BorderLayout.PAGE_END);

        lstFlight.setModel(listModelFlight);
        lstFlight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstFlightMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lstFlightMousePressed(evt);
            }
        });
        lstFlight.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFlightValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstFlight);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        miSave.setText("Save Selected into File(.txt)");
        miSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSaveActionPerformed(evt);
            }
        });
        jMenu1.add(miSave);

        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        jMenu1.add(miExit);

        jMenuBar1.add(jMenu1);

        mnAdd.setText("Add");
        mnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnAddMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnAdd);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnAddMouseClicked
        // TODO add your handling code here:
        
        dlgAddEdit_btSave.setText("Add");
        currentlyEditedItemIndex = -1;
        // cleanup the dialog before showing it
        clearUpInputs();
        // show the dialog
        dlgAddEdit.pack();
        dlgAddEdit.setLocationRelativeTo(this);
        dlgAddEdit.setVisible(true);

    }//GEN-LAST:event_mnAddMouseClicked

    private void dlgAddEdit_btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgAddEdit_btCancelActionPerformed
        // TODO add your handling code here:
        dlgAddEdit.setVisible(false);
    }//GEN-LAST:event_dlgAddEdit_btCancelActionPerformed

    private void dlgAddEdit_btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgAddEdit_btSaveActionPerformed
        try {

                Date onDay = Flight.dateFormat.parse(dlgAddEdit_ftfOnDay.getText());    //ParseException
                String fromCode = dlgAddEdit_tfFromCode.getText();
                String toCode = dlgAddEdit_tfToCode.getText();
                int passengers = dlgAddEdit_sliderPassengers.getValue();
                Flight.Type type = (Flight.Type)dlgAddEdit_cmbType.getSelectedItem();

                Flight flight = new Flight(0, onDay, fromCode, toCode, type, passengers);

                if(currentlyEditedItemIndex == -1){
                    db.addFlight(flight);  //InvalidDataException
                }else{
                    int id = lstFlight.getSelectedValue().getId();
                    flight = new Flight(id, onDay, fromCode, toCode, type, passengers);
                    db.updateFlight(flight);
                }
                loadFlightFromDatabase();
                //cleanup inputs
                clearUpInputs();
                dlgAddEdit.setVisible(false);

        } catch (IllegalArgumentException | ParseException | InvalidDataException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to add Flight" + ex.getMessage(), "Internal error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect" + ex.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_dlgAddEdit_btSaveActionPerformed

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_miExitActionPerformed

    private void miPopupDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPopupDeleteActionPerformed
        // TODO add your handling code here:
        Flight f = lstFlight.getSelectedValue();
            
        if(f == null){
            return;
        }
            
        int decision = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this item?\n" + lstFlight.getSelectedValue().toString(),
                "Confirm deletion",
                JOptionPane.OK_CANCEL_OPTION);
        
        if (decision == JOptionPane.OK_OPTION) {
            try {
                
                int result = db.deleteFlight(f.getId());
                
                if(result >0){
                    JOptionPane.showMessageDialog(this, "Delete record successfully");
                    
                }else{
                    JOptionPane.showMessageDialog(this, "Failed to delete record");
                }
                
                loadFlightFromDatabase();
                lblStatus.setText("Total Flights: " + db.getAllFlights().size());   //or listModelFlight.size()
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to delete a record" + ex.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_miPopupDeleteActionPerformed

    private void lstFlightValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFlightValueChanged
        // TODO add your handling code here:
        lblStatus.setText("Total Flights: " + listModelFlight.size());     //or db.getAllFlights().size()
    }//GEN-LAST:event_lstFlightValueChanged

    private void lstFlightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstFlightMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1){  // if double click happened
            
            Flight f = lstFlight.getSelectedValue();
            
            if(f == null){
                return;
            }
            
            dlgAddEdit_btSave.setText("Update");

            dlgAddEdit_lblId.setText(f.getId()+"");
            dlgAddEdit_ftfOnDay.setText(Flight.dateFormat.format(f.getOnDay()));
            dlgAddEdit_tfFromCode.setText(f.getFromCode());
            dlgAddEdit_tfToCode.setText(f.getToCode());
            dlgAddEdit_sliderPassengers.setValue(f.getPassengers());
            dlgAddEdit_cmbType.setSelectedItem(f.getType());
            
            currentlyEditedItemIndex = lstFlight.getSelectedIndex();
            
            // show the dialog
            dlgAddEdit.pack();
            dlgAddEdit.setLocationRelativeTo(this);
            dlgAddEdit.setVisible(true);
            
            lblStatus.setText("Total Flights: " + listModelFlight.size());   //or db.getAllFlights().size() with exception catch block
            
        }    
    }//GEN-LAST:event_lstFlightMouseClicked

    private void lstFlightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstFlightMousePressed
        // TODO add your handling code here:
        if(evt.isPopupTrigger()){
            popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_lstFlightMousePressed

    private void dlgAddEdit_sliderPassengersStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dlgAddEdit_sliderPassengersStateChanged
        // TODO add your handling code here:
        dlgAddEdit_lblPassengers.setText(dlgAddEdit_sliderPassengers.getValue()+"");
    }//GEN-LAST:event_dlgAddEdit_sliderPassengersStateChanged

    private void miSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSaveActionPerformed
        // TODO add your handling code here:
        
        if(lstFlight.isSelectionEmpty()){
            
            JOptionPane.showMessageDialog(this, "Please choose at least one record to save");
            
        }else{
            fileChooser.setDialogTitle("Export to File");
        
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {

                File chosenFile = fileChooser.getSelectedFile();

                if (!chosenFile.getName().toLowerCase().matches(FILENAME_PATTERN)) {
                    chosenFile = new File(fileChooser.getSelectedFile() + SUFFIX_TXT);
                }
                saveDataToFile(chosenFile);
            }
        }
    }//GEN-LAST:event_miSaveActionPerformed

    private void saveDataToFile(File file) {
        
        try (PrintWriter fileOutput = new PrintWriter(file)) {

            for(Flight f : lstFlight.getSelectedValuesList()){   
                String dataLine  = f.toDataLine();
                fileOutput.println(dataLine);      
            };

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data to file:\n" + ex.getMessage(),
                    "File error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    private void clearUpInputs(){
        
        dlgAddEdit_lblId.setText("-");
        dlgAddEdit_ftfOnDay.setText("01-01-1970");
        dlgAddEdit_tfFromCode.setText("");
        dlgAddEdit_tfToCode.setText("");
        dlgAddEdit_sliderPassengers.setValue(0);
        dlgAddEdit_cmbType.setSelectedItem(Flight.Type.Domestic);
        
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
            java.util.logging.Logger.getLogger(Day10FlightsSqlServerDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Day10FlightsSqlServerDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Day10FlightsSqlServerDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Day10FlightsSqlServerDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Day10FlightsSqlServerDB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog dlgAddEdit;
    private javax.swing.JButton dlgAddEdit_btCancel;
    private javax.swing.JButton dlgAddEdit_btSave;
    private javax.swing.JComboBox<Flight.Type> dlgAddEdit_cmbType;
    private javax.swing.JFormattedTextField dlgAddEdit_ftfOnDay;
    private javax.swing.JLabel dlgAddEdit_lblId;
    private javax.swing.JLabel dlgAddEdit_lblPassengers;
    private javax.swing.JSlider dlgAddEdit_sliderPassengers;
    private javax.swing.JTextField dlgAddEdit_tfFromCode;
    private javax.swing.JTextField dlgAddEdit_tfToCode;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JList<Flight> lstFlight;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miPopupDelete;
    private javax.swing.JMenuItem miSave;
    private javax.swing.JMenu mnAdd;
    private javax.swing.JPopupMenu popupMenu;
    // End of variables declaration//GEN-END:variables
}
