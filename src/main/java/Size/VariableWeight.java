/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Size;

import Commons.Weights;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ISHU
 */
public class VariableWeight extends javax.swing.JFrame {

    /**
     * Creates new form VariableWeight
     */
    public VariableWeight() {
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

        jLabelVarableW = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVariableW = new javax.swing.JTable();
        jButtVariablW = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelVarableW.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelVarableW.setText("            Weight related to the Variable Factor");

        jTableVariableW.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableVariableW.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Global Variable", "2"},
                {"Local Variable", "1"},
                {"Primitive date type", "1"},
                {"Composite data type variable", "2"}
            },
            new String [] {
                "Program Conponent", "Weight"
            }
        ));
        jScrollPane1.setViewportView(jTableVariableW);

        jButtVariablW.setBackground(new java.awt.Color(102, 204, 255));
        jButtVariablW.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtVariablW.setText("Save");
        jButtVariablW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtVariablWActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabelVarableW, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(jButtVariablW)))
                .addContainerGap(458, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabelVarableW, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButtVariablW, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtVariablWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtVariablWActionPerformed
         DefaultTableModel model = (DefaultTableModel)jTableVariableW.getModel();

            Weights.globalVariable = Integer.parseInt(model.getValueAt(0, 1).toString());
            Weights.localVariable = Integer.parseInt(model.getValueAt(1, 1).toString());
            Weights.primitiveDataType = Integer.parseInt(model.getValueAt(2, 1).toString());
            Weights.compositeDataType = Integer.parseInt(model.getValueAt(3, 1).toString());

            

        dispose();
    }//GEN-LAST:event_jButtVariablWActionPerformed

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
            java.util.logging.Logger.getLogger(VariableWeight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VariableWeight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VariableWeight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VariableWeight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VariableWeight().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtVariablW;
    private javax.swing.JLabel jLabelVarableW;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVariableW;
    // End of variables declaration//GEN-END:variables
}
