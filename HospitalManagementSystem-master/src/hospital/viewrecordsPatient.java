/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author galenoareliano
 */
public class viewrecordsPatient extends javax.swing.JFrame {
    
    private Object[] editedRowData = new Object[5]; // Assuming 3 columns - ID, DoctorName, Specialization

    /**
     * Creates new form viewrecordsPatient
     */
    public viewrecordsPatient() {
        initComponents();
        this.getPatient();
        setupTableAndButton(); // Set up table listener and button action

    }
    
    public void getPatient(){
        // TODO add your handling code here:
        try{ Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
            Statement st= conn.createStatement();
            String sql="select * from paitient_record";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs= pstmt.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)jTable1.getModel();
            tm.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getInt("ID"),rs.getString("PatientName"),rs.getString("PatientDisease"),rs.getString("Date"),rs.getString("Time")};
                tm.addRow(o);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void setupTableAndButton() {
        jTable1.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.DELETE) {
                // Handle deletion case
                SwingUtilities.invokeLater(() -> {
                    // Actions after row deletion
                    // For example, resetting editedRowData
                    editedRowData = new Object[5]; // Resetting the array, adjust the size as needed
                });
                return;
            }

            int row = e.getFirstRow();
            DefaultTableModel model = (DefaultTableModel) e.getSource();

            if (row >= 0 && row < model.getRowCount()) {
                for (int i = 0; i < editedRowData.length; i++) {
                    editedRowData[i] = model.getValueAt(row, i);
                }
            }
        });
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("View Details");

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("LOGOUT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Pasien", "Penyakit", "Tanggal", "Waktu"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDelete)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if (editedRowData[0] != null && editedRowData[1] != null && editedRowData[2] != null) {
        String pid = editedRowData[0].toString(); // ID
        String pname = editedRowData[1].toString(); // PatientName
        String pdisease = editedRowData[2].toString(); // PatientDisease

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "")) {
                String sql = "UPDATE paitient_record SET PatientName = ?, PatientDisease = ? WHERE ID = ?";
                try (PreparedStatement ptstmt = conn.prepareStatement(sql)) {
                    ptstmt.setString(1, pname);
                    ptstmt.setString(2, pdisease);
                    ptstmt.setInt(3, Integer.parseInt(pid));
                    ptstmt.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(null, "Record updated successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    } else {
        JOptionPane.showMessageDialog(null, "No cell has been edited or selected.");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        PATIENT obj = new PATIENT();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        LoginPage obj =new LoginPage();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        System.out.println("Selected row: " + selectedRow);
        
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString()); // Assuming ID is in the first column
                    deleteRecordFromDatabase(id);
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    System.out.println("Row count before deletion: " + model.getRowCount());
                    model.removeRow(selectedRow);
                    System.out.println("Row count after deletion: " + model.getRowCount());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format");
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error occurred while deleting record: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void deleteRecordFromDatabase(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "");
            String sql = "DELETE FROM paitient_record WHERE ID = ?";
            PreparedStatement ptstmt = conn.prepareStatement(sql);
            ptstmt.setInt(1, id);
            int affectedRows = ptstmt.executeUpdate();
            if (affectedRows == 0) {
                JOptionPane.showMessageDialog(null, "No record found with ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
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
            java.util.logging.Logger.getLogger(viewrecordsPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewrecordsPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewrecordsPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewrecordsPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewrecordsPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
