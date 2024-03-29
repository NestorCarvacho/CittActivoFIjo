/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.DaoColor;
import Modelo.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class JfrmAgregarColor extends javax.swing.JFrame {

    /**
     * Creates new form JfrmAgregarColor
     */
    public JfrmAgregarColor() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JfrmAgregarColor.DO_NOTHING_ON_CLOSE);
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
        txtNombreColor = new javax.swing.JTextField();
        btnGrabarColor = new javax.swing.JButton();
        btnSalirColor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("VALORANT", 0, 36)); // NOI18N
        jLabel1.setText("INGRESO DE COLOR");

        txtNombreColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreColorActionPerformed(evt);
            }
        });

        btnGrabarColor.setText("GRABAR");
        btnGrabarColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarColorActionPerformed(evt);
            }
        });

        btnSalirColor.setText("Cerrar");
        btnSalirColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(txtNombreColor, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGrabarColor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(btnSalirColor)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrabarColor))
                .addGap(18, 18, 18)
                .addComponent(btnSalirColor)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarColorActionPerformed
        try {
            int idColor = 0;
            String nombreColor = txtNombreColor.getText();
            Color color = new Color(idColor, nombreColor);
            boolean resp = new DaoColor().Grabar(color);
            if (resp) {
                JOptionPane.showMessageDialog(null, "Grabo");
            } else {
                JOptionPane.showMessageDialog(null, "No Grabo");
            }
        } catch (Exception e) {
            System.out.println("error grabar: "+e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo grabar");
        }
    }//GEN-LAST:event_btnGrabarColorActionPerformed

    private void txtNombreColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreColorActionPerformed

    private void btnSalirColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirColorActionPerformed
        // TODO add your handling code here:
        mostrarMain();
    }//GEN-LAST:event_btnSalirColorActionPerformed
    
    private void mostrarMain() {
        this.dispose();
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
            java.util.logging.Logger.getLogger(JfrmAgregarColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmAgregarColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmAgregarColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmAgregarColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfrmAgregarColor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGrabarColor;
    private javax.swing.JButton btnSalirColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtNombreColor;
    // End of variables declaration//GEN-END:variables
}
