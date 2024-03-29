/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.DaoProducto;
import Controlador.DaoTipoProducto;
import Modelo.Producto;
import Modelo.TipoProducto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nesto
 */
public class JfrmAgregarProductoMasivo extends javax.swing.JFrame {

    /**
     * Creates new form JfrmAgregarProductoMasivo
     */
    public JfrmAgregarProductoMasivo() {
        initComponents();
        listarCboTipoProducto();

        //setExtendedState(MAXIMIZED_BOTH);
        //set programa en la mitad de la pantalla
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JfrmVistaHome.DO_NOTHING_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CboTipoProducto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        BtnAgregarTipoProducto = new javax.swing.JButton();
        txtIngresaSerie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIngresaActivo = new javax.swing.JTextField();
        BtnGuardarProductos = new javax.swing.JButton();
        BtnAgregarALista = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtblListadoAgregar = new javax.swing.JTable();
        BtnDeshacer = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Carga Masiva Productos");

        jLabel2.setText("Tipo Producto");

        CboTipoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CboTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboTipoProductoActionPerformed(evt);
            }
        });

        jLabel3.setText("Serie Producto");

        BtnAgregarTipoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add.png"))); // NOI18N
        BtnAgregarTipoProducto.setText("Agregar Tipo Producto");

        txtIngresaSerie.setToolTipText("");
        txtIngresaSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngresaSerieActionPerformed(evt);
            }
        });

        jLabel4.setText("Activo Producto");

        BtnGuardarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save.png"))); // NOI18N
        BtnGuardarProductos.setText("Guardar Productos");

        BtnAgregarALista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ok.png"))); // NOI18N
        BtnAgregarALista.setText("Agregar a Lista");
        BtnAgregarALista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarAListaActionPerformed(evt);
            }
        });

        JtblListadoAgregar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Serie", "Activo", "Tipo Producto"
            }
        ));
        jScrollPane1.setViewportView(JtblListadoAgregar);

        BtnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back.png"))); // NOI18N
        BtnDeshacer.setText("Deshacer");
        BtnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeshacerActionPerformed(evt);
            }
        });

        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancel.png"))); // NOI18N
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIngresaSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtIngresaActivo, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addComponent(BtnAgregarALista, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CboTipoProducto, javax.swing.GroupLayout.Alignment.LEADING, 0, 289, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(BtnAgregarTipoProducto)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnGuardarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(381, 381, 381))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CboTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnAgregarTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtIngresaSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtIngresaActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnAgregarALista, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CboTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboTipoProductoActionPerformed


    }//GEN-LAST:event_CboTipoProductoActionPerformed

    private void listarCboTipoProducto() {
        CboTipoProducto.removeAllItems();
        CboTipoProducto.addItem("-- Seleccione --");
        for (TipoProducto ubi : new DaoTipoProducto().Listar()) {
            CboTipoProducto.addItem(ubi.getDescripcionTipoProducto());
        }
    }

    ;
    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        JfrmVistaUsuarioNormal vistaNormal = new JfrmVistaUsuarioNormal();
        vistaNormal.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnAgregarAListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarAListaActionPerformed
        try {
            DefaultTableModel modelo = (DefaultTableModel) JtblListadoAgregar.getModel();
            String producto1 = txtIngresaActivo.getText();
            String producto2 = txtIngresaSerie.getText();
            String tipoProducto = CboTipoProducto.getSelectedItem().toString();

            if (!producto1.isEmpty() && !producto2.isEmpty()) {
                Object[] fila = new Object[5];
                fila[0] = producto2;
                fila[1] = producto1;
                fila[2] = tipoProducto;
                
                modelo.addRow(fila);
            } else {
                JOptionPane.showMessageDialog(null, "Uno o ambos campos están vacíos.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede agregar.");
        }

    }//GEN-LAST:event_BtnAgregarAListaActionPerformed

    private void agregarProductoMasivo() {
        try {

            // TODO add your handling code here:
            String serieProducto = txtIngresaSerie.getText();
            String activoProducto = txtIngresaActivo.getText();
            String tipoProducto = CboTipoProducto.getSelectedItem().toString();

//            Producto prod = new DaoProducto().Buscar2(producto);
            DefaultTableModel modelo = (DefaultTableModel) JtblListadoAgregar.getModel();

            boolean existe = false;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                String numProducto = (String) modelo.getValueAt(i, 0);
                String serProducto = (String) modelo.getValueAt(i, 1);
                String tpProducto = (String) modelo.getValueAt(i, 2);
                System.out.println(tpProducto);
                if (numProducto.equalsIgnoreCase(serieProducto) || serProducto.equalsIgnoreCase(activoProducto) || tpProducto.equals(tipoProducto)) {
                    existe = true;
                    break;
                }
            }
            if (existe) {
                JOptionPane.showMessageDialog(null, "El producto ya existe en la tabla.");
            } else if (serieProducto != null) {
                BtnDeshacer.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: No se puede Agregar en Blanco");
        }

    }

    ;
    
    
    
    
    private void txtIngresaSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIngresaSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIngresaSerieActionPerformed

    private void BtnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeshacerActionPerformed
        try {
            DefaultTableModel modelo = (DefaultTableModel) JtblListadoAgregar.getModel();

            // Verificamos si hay al menos una fila en la tabla
            if (modelo.getRowCount() > 0) {
                // Eliminamos la última fila (fila en la posición rowCount - 1)
                modelo.removeRow(modelo.getRowCount() - 1);
            } else {
                JOptionPane.showMessageDialog(null, "No hay elementos para deshacer.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede deshacer.");
        }

    }//GEN-LAST:event_BtnDeshacerActionPerformed

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
            java.util.logging.Logger.getLogger(JfrmAgregarProductoMasivo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmAgregarProductoMasivo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmAgregarProductoMasivo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmAgregarProductoMasivo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfrmAgregarProductoMasivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarALista;
    private javax.swing.JButton BtnAgregarTipoProducto;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnDeshacer;
    private javax.swing.JButton BtnGuardarProductos;
    private javax.swing.JComboBox<String> CboTipoProducto;
    private javax.swing.JTable JtblListadoAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtIngresaActivo;
    private javax.swing.JTextField txtIngresaSerie;
    // End of variables declaration//GEN-END:variables

    private void AgregarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
