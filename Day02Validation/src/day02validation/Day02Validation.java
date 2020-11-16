/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author YingLuo
 */
public class Day02Validation extends javax.swing.JFrame {

    /**
     * Creates new form Day02Validation
     */
    public Day02Validation() {
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

        btgGender = new javax.swing.ButtonGroup();
        lblName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lblPassport = new javax.swing.JLabel();
        tfPassport = new javax.swing.JTextField();
        lblContinent = new javax.swing.JLabel();
        cmbContinent = new javax.swing.JComboBox<>();
        lblGender = new javax.swing.JLabel();
        rdMale = new javax.swing.JRadioButton();
        rdFemale = new javax.swing.JRadioButton();
        rdOther = new javax.swing.JRadioButton();
        lblPets = new javax.swing.JLabel();
        ckbFish = new javax.swing.JCheckBox();
        ckbPig = new javax.swing.JCheckBox();
        ckbOther = new javax.swing.JCheckBox();
        lblHeight = new javax.swing.JLabel();
        slHeight = new javax.swing.JSlider();
        lblDOB = new javax.swing.JLabel();
        tfDOB = new javax.swing.JTextField();
        btVerify = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taResult = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblName.setText("Name");

        lblPassport.setText("Passport No.");

        lblContinent.setText("Continent");

        cmbContinent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please choose ...", "Asia", "Africa", "North America", "South America", "Antarctica", "Europe", "Australia" }));

        lblGender.setText("Gender");

        btgGender.add(rdMale);
        rdMale.setText("Male");
        rdMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMaleActionPerformed(evt);
            }
        });

        btgGender.add(rdFemale);
        rdFemale.setText("Female");
        rdFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFemaleActionPerformed(evt);
            }
        });

        btgGender.add(rdOther);
        rdOther.setText("Other");
        rdOther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdOtherActionPerformed(evt);
            }
        });

        lblPets.setText("Pets");

        ckbFish.setText("Fish");

        ckbPig.setText("Pig");
        ckbPig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbPigActionPerformed(evt);
            }
        });

        ckbOther.setText("Other");

        lblHeight.setText("Height");

        slHeight.setMajorTickSpacing(50);
        slHeight.setMaximum(250);
        slHeight.setMinimum(100);
        slHeight.setMinorTickSpacing(5);
        slHeight.setPaintLabels(true);
        slHeight.setPaintTicks(true);
        slHeight.setSnapToTicks(true);
        slHeight.setToolTipText("");
        slHeight.setValue(175);

        lblDOB.setText("Date of Birth");

        tfDOB.setText("YYYY-MM-DD");

        btVerify.setText("Verify and Add Below");
        btVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerifyActionPerformed(evt);
            }
        });

        taResult.setColumns(20);
        taResult.setRows(5);
        jScrollPane1.setViewportView(taResult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btVerify)
                .addGap(167, 167, 167))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblPassport)
                            .addComponent(lblContinent)
                            .addComponent(lblGender)
                            .addComponent(lblPets)
                            .addComponent(lblHeight)
                            .addComponent(lblDOB))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdMale)
                                    .addComponent(ckbFish))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdFemale)
                                    .addComponent(ckbPig))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ckbOther)
                                    .addComponent(rdOther)))
                            .addComponent(slHeight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfName)
                            .addComponent(tfPassport)
                            .addComponent(cmbContinent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfDOB))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassport)
                    .addComponent(tfPassport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContinent)
                    .addComponent(cmbContinent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(rdMale)
                    .addComponent(rdFemale)
                    .addComponent(rdOther))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPets)
                    .addComponent(ckbFish)
                    .addComponent(ckbPig)
                    .addComponent(ckbOther))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeight)
                    .addComponent(slHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDOB)
                    .addComponent(tfDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btVerify)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemaleActionPerformed
        // TODO add your handling code here:
        rdFemale.setActionCommand("Female");
    }//GEN-LAST:event_rdFemaleActionPerformed

    private void ckbPigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbPigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbPigActionPerformed

    private static final String DOB_PATTERN = 
        "^(19|20|21)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";
    
    private static final String PASSPORT_PATTERN = 
        "^[A-Z]{2}[0-9]{6}$";
    
    private static final String NAME_PATTERN = 
        "^\\W*(?:\\w+\\b\\W*){1,50}$";
    
    private Pattern dobPattern = Pattern.compile(DOB_PATTERN);
    private Pattern namePattern = Pattern.compile(NAME_PATTERN);
    private Pattern passportPattern = Pattern.compile(PASSPORT_PATTERN);
    
    private void btVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerifyActionPerformed
        // TODO add your handling code here:
        Matcher dobMatcher = dobPattern.matcher(tfDOB.getText());
        Matcher nameMatcher = namePattern.matcher(tfName.getText());
        Matcher passportMatcher = passportPattern.matcher(tfPassport.getText());
        
        if(!(nameMatcher.matches())){
            JOptionPane.showMessageDialog(this, "Please input 1-50 charactors as your name");
        }else if(!(passportMatcher.matches())){
            JOptionPane.showMessageDialog(this, "Please input passport number correctly");
        }else if(!(dobMatcher.matches())){
            JOptionPane.showMessageDialog(this, "Please input your date of birth format correctly");
        }else if(cmbContinent.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please choose one of your continent");
        }else if(btgGender.getSelection() == null){
            JOptionPane.showMessageDialog(this, "Please choose your gender");
        }else{
            String result = String.format("%s, %n%s, %n%s, %n%s, %n%s, %n%d, %n%s", 
                                        tfName.getText(), 
                                        tfPassport.getText(), 
                                        cmbContinent.getSelectedItem(),
                                        btgGender.getSelection().getActionCommand(),
                                        String.join(", ", (ckbFish.isSelected()) ? ckbFish.getText() : "", 
                                                           (ckbPig.isSelected()) ? ckbPig.getText() : "", 
                                                           (ckbOther.isSelected()) ? ckbOther.getText() : ""),
                                        slHeight.getValue(),
                                        tfDOB.getText());
            taResult.setText(result);
        }
       
    }//GEN-LAST:event_btVerifyActionPerformed

    private void rdMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMaleActionPerformed
        // TODO add your handling code here:
        rdMale.setActionCommand("Male");
    }//GEN-LAST:event_rdMaleActionPerformed

    private void rdOtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdOtherActionPerformed
        // TODO add your handling code here:
        rdOther.setActionCommand("Other");
    }//GEN-LAST:event_rdOtherActionPerformed

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
            java.util.logging.Logger.getLogger(Day02Validation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Day02Validation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Day02Validation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Day02Validation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Day02Validation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVerify;
    private javax.swing.ButtonGroup btgGender;
    private javax.swing.JCheckBox ckbFish;
    private javax.swing.JCheckBox ckbOther;
    private javax.swing.JCheckBox ckbPig;
    private javax.swing.JComboBox<String> cmbContinent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContinent;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassport;
    private javax.swing.JLabel lblPets;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JRadioButton rdOther;
    private javax.swing.JSlider slHeight;
    private javax.swing.JTextArea taResult;
    private javax.swing.JTextField tfDOB;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPassport;
    // End of variables declaration//GEN-END:variables
}
