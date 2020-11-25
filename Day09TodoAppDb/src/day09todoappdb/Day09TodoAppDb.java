/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day09todoappdb;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author YingLuo
 */
public class Day09TodoAppDb extends javax.swing.JFrame {

    /**
     * Creates new form Day09TodoAppDb
     */
    
    DefaultListModel<Todo> listModelTodo = new DefaultListModel<>();
    //DefaultListModel<Todo.Status> listModelTodoStatus = new DefaultListModel<>(Todo.Status.values());
    Database db;
    
    public Day09TodoAppDb() {
        initComponents();
        
        try{
            db = new Database();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect" + ex.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
            
        }
        
        loadTodoFromDatabase();
    }
    
    void loadTodoFromDatabase(){
        
        try{
            ArrayList<Todo> list = db.getAllTodos();
            
            listModelTodo.clear();
            listModelTodo.addAll(list);
            
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

        jLabel1 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfTask = new javax.swing.JTextField();
        sliderDifficulty = new javax.swing.JSlider();
        cmbStatus = new javax.swing.JComboBox<>();
        btAdd = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        lblDifficulty = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstTodos = new javax.swing.JList<>();
        ftfDueDate = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("ID");

        lblId.setText("-");

        jLabel3.setText("Task");

        jLabel4.setText("Difficulty");

        jLabel5.setText("Due date");

        jLabel6.setText("Status");

        sliderDifficulty.setMajorTickSpacing(1);
        sliderDifficulty.setMaximum(5);
        sliderDifficulty.setMinimum(1);
        sliderDifficulty.setMinorTickSpacing(1);
        sliderDifficulty.setPaintLabels(true);
        sliderDifficulty.setPaintTicks(true);
        sliderDifficulty.setToolTipText("");
        sliderDifficulty.setValue(1);
        sliderDifficulty.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderDifficultyStateChanged(evt);
            }
        });

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Done", "Delegated" }));

        btAdd.setText("Add todo");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btUpdate.setText("Update todo");
        btUpdate.setEnabled(false);
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btDelete.setText("Delete todo");
        btDelete.setEnabled(false);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        lblDifficulty.setText("1");

        lstTodos.setModel(listModelTodo);
        lstTodos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstTodos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstTodosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstTodos);

        ftfDueDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-mm-dd"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblId)
                                    .addComponent(tfTask, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(55, 55, 55)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ftfDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblDifficulty)
                                    .addGap(18, 18, 18)
                                    .addComponent(sliderDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sliderDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDifficulty)
                                    .addComponent(jLabel4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(ftfDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstTodosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstTodosValueChanged
        // TODO add your handling code here:
        Todo t = lstTodos.getSelectedValue();
        if(t!=null){
            lblId.setText(t.getId() + "");
            tfTask.setText(t.getTask());
            sliderDifficulty.setValue(t.getDifficulty());
            ftfDueDate.setText(Todo.dateFormat.format(t.getDueDate()));
            cmbStatus.setSelectedItem(t.getStatus().toString());
            btUpdate.setEnabled(true);
            btDelete.setEnabled(true);
        }else {  //nothing seleted
            clearUpInputs();
            btUpdate.setEnabled(false);
            btDelete.setEnabled(false);
        }
    }//GEN-LAST:event_lstTodosValueChanged

    private void clearUpInputs(){
        
        lblId.setText("-");
        tfTask.setText("");
        sliderDifficulty.setValue(1);
        ftfDueDate.setText("1970-01-01");
        cmbStatus.setSelectedItem(Todo.Status.Pending);
    }
    
    
    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        
        try {
            
            if(tfTask.getText().replaceAll("\\s+","").isEmpty()){   //IllegalArgumentException
                
                JOptionPane.showMessageDialog(this, "Task must be 1-100 characters");
                
            }else if(ftfDueDate.getText().replaceAll("\\s+","").isEmpty()){
                
                JOptionPane.showMessageDialog(this, "Please input right DueDate");
                
            }else{
 
                String task = tfTask.getText();
                int difficulty = sliderDifficulty.getValue();
                Date dueDate = new java.sql.Date(Todo.dateFormat.parse(ftfDueDate.getText()).getTime());        //ParseException
                Todo.Status status = Todo.Status.valueOf(cmbStatus.getSelectedItem().toString());
            
                db.addTodo(new Todo(0, task, difficulty, dueDate, status));  //InvalidDataException
                loadTodoFromDatabase();
                //cleanup inputs
                clearUpInputs();
            }

        } catch (IllegalArgumentException | ParseException | InvalidDataException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to add record" + ex.getMessage(), "Internel error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect" + ex.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
        } 
        
    }//GEN-LAST:event_btAddActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        // TODO add your handling code here:
        try {
            
            if(tfTask.getText().replaceAll("\\s+","").isEmpty()){
                
                JOptionPane.showMessageDialog(this, "Task must be 1-100 characters");
                
            }else if(ftfDueDate.getText().replaceAll("\\s+","").isEmpty()){
                
                JOptionPane.showMessageDialog(this, "Please input right DueDate");
                
            }else{
                int id = Integer.parseInt(lblId.getText());  // NumberFormatException
                String task = tfTask.getText();
                int difficulty = sliderDifficulty.getValue();
                Date dueDate = new java.sql.Date(Todo.dateFormat.parse(ftfDueDate.getText()).getTime());
                Todo.Status status = Todo.Status.valueOf(cmbStatus.getSelectedItem().toString());

                Todo t = new Todo(id, task, difficulty, dueDate, status);

                db.updateTodo(t);
                loadTodoFromDatabase();
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Internel error", JOptionPane.ERROR_MESSAGE);
        }catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Internel error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Internel error", JOptionPane.ERROR_MESSAGE);
        } catch (InvalidDataException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to add record" + ex.getMessage(), "Internel error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect" + ex.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
        } 
        
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int id = Integer.parseInt(lblId.getText());  // NumberFormatException
            
            int decision = JOptionPane.showConfirmDialog(this,
                                                        "Are you sure you want to delete this item?\n" + lstTodos.getSelectedValue().toString(),
                                                        "Confirm deletion",
                                                        JOptionPane.OK_CANCEL_OPTION);
            if (decision == JOptionPane.OK_OPTION) {
                int result = db.deleteTodo(id);
                if(result >0){
                    JOptionPane.showMessageDialog(this, "Delete record successfully");
                }else{
                    JOptionPane.showMessageDialog(this, "Failed to delete record");
                }
            }
            loadTodoFromDatabase();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Internel error", JOptionPane.ERROR_MESSAGE);
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed to delete a record" + ex.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btDeleteActionPerformed

    private void sliderDifficultyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderDifficultyStateChanged
        // TODO add your handling code here:
        lblDifficulty.setText(sliderDifficulty.getValue()+"");
    }//GEN-LAST:event_sliderDifficultyStateChanged

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
            java.util.logging.Logger.getLogger(Day09TodoAppDb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Day09TodoAppDb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Day09TodoAppDb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Day09TodoAppDb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Day09TodoAppDb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btUpdate;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JFormattedTextField ftfDueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDifficulty;
    private javax.swing.JLabel lblId;
    private javax.swing.JList<Todo> lstTodos;
    private javax.swing.JSlider sliderDifficulty;
    private javax.swing.JTextField tfTask;
    // End of variables declaration//GEN-END:variables
}
