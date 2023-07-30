/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.DaoEmpleado;
import Controlador.DaoProducto;
import Controlador.DaoTipoMovimiento;
import Controlador.DaoUbicacion;
import Controlador.DaoUsuario;
import Modelo.Empleado;
import Modelo.Producto;
import Modelo.TipoMovimiento;
import Modelo.Ubicacion;
import Modelo.Usuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oracle.sql.ROWID;

/**
 *
 * @author Usuario
 */
public class JFrmNuevoMovimiento extends javax.swing.JFrame {

    /**
     * Creates new form JFrmNuevoMovimiento
     */
    public JFrmNuevoMovimiento() {
        initComponents();
        //set programa en la mitad de la pantalla
        setLocationRelativeTo(null);
        ListarCboUbicacionFinal();
        ListarCboTipoMovimiento();
        btnEliminarProducto.setEnabled(false);
        /*ListarCboEncargardoMovimiento();*/

        setIconImage(getIconImage());
        setIconImage(getIconHome());
        setIconImage(getIconUser());
        setIconImage(getIconPaper());
        setIconImage(getIconArrows());
        setIconImage(getIconBox());
    }

    @Override
    public Image getIconImage() {

        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Img/caja.png"));
        return retValue;

    }

    public Image getIconHome() {

        Image homeValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Img/home.png"));
        return homeValue;
    }

    public Image getIconUser() {

        Image userValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Img/user.png"));
        return userValue;
    }

    public Image getIconBox() {

        Image boxValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Img/box.png"));
        return boxValue;
    }

    public Image getIconPaper() {

        Image paperValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Img/paper.png"));
        return paperValue;
    }

    public Image getIconArrows() {

        Image arrowsValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Img/arrows.png"));
        return arrowsValue;
    }

    private void ListarCboUbicacionFinal() {
        CboUbicacionFinal.removeAllItems();
        CboUbicacionFinal.addItem("-- Seleccione --");
        for (Empleado emp : new DaoEmpleado().Listar()) {
            CboUbicacionFinal.addItem(emp.getNombreEmpleado());
        }
        for (Ubicacion ubi : new DaoUbicacion().Listar()) {
            CboUbicacionFinal.addItem(ubi.getDescripcionUbicacion());
        }
    }

    private void ListarCboTipoMovimiento() {
        CboTipoMovimiento.removeAllItems();
        CboTipoMovimiento.addItem("-- Seleccione --");
        for (TipoMovimiento tpMov : new DaoTipoMovimiento().Listar()) {
            CboTipoMovimiento.addItem(tpMov.getNombreTipoMovimiento());
        }
    }

    private void AgregarProducto() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) jtblMovimiento.getModel();
            String producto = txtNumeroActivo.getText();
            Producto prod = new DaoProducto().Buscar2(producto);
            Object[] fila = new Object[5];
            fila[0] = prod.getNumActivoProducto();
            fila[1] = prod.getNumSerieProducto();
            fila[2] = prod.getTipoProducto().getDescripcionTipoProducto();
            fila[3] = prod.getUbicacionProducto();
            fila[4] = prod.getEstadoProducto();

            modelo.addRow(fila);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se puede agregar");
        }

    }

    /*
    private void ListarCboEncargardoMovimiento() {
        CboEncargardoMovimiento.removeAllItems();
        CboEncargardoMovimiento.addItem("-- Seleccione --");
    }
     */
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
        CboUbicacionFinal = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        TxtBuscarProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtSerie = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNumeroActivo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUbicacionActual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        CboTipoMovimiento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblMovimiento = new javax.swing.JTable();
        btnGenerarMovimiento = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Ubicaion Final");

        CboUbicacionFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Crea un Nuevo Movimiento");

        TxtBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBuscarProductoActionPerformed(evt);
            }
        });
        TxtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtBuscarProductoKeyPressed(evt);
            }
        });

        jLabel4.setText("Buscar Producto");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtSerie.setEnabled(false);
        txtSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerieActionPerformed(evt);
            }
        });

        jLabel5.setText("Numero de Serie");

        txtNumeroActivo.setEnabled(false);

        jLabel6.setText("Numero de Activo");

        txtUbicacionActual.setEnabled(false);

        jLabel7.setText("Ubicacion Actual");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        CboTipoMovimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Tipo Movimiento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumeroActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CboUbicacionFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CboTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtUbicacionActual, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar))
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CboUbicacionFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CboTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUbicacionActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jtblMovimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Activo", "Numero Serie", "Descripcion", "Ubicacion Actual", "Estado Producto"
            }
        ));
        jScrollPane1.setViewportView(jtblMovimiento);

        btnGenerarMovimiento.setText("Guardar Movimiento");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminarProducto.setText("Eliminar producto");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGenerarMovimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarMovimiento)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminarProducto))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            String numAct = TxtBuscarProducto.getText();
            Producto prod = new DaoProducto().Buscar2(numAct);
            if (prod != null) {
//              JOptionPane.showMessageDialog(null, "Existe Producto");
                txtNumeroActivo.setText("" + prod.getNumActivoProducto());
                txtSerie.setText("" + prod.getNumSerieProducto());
                txtUbicacionActual.setText(prod.getUbicacionProducto().toString());
                agregarProductoALista();
            } else {
                Producto prod1 = new DaoProducto().BuscarSerie(numAct);
                if (prod1 != null) {
//                    JOptionPane.showMessageDialog(null, "Existe Producto");
                    txtNumeroActivo.setText("" + prod1.getNumActivoProducto());
                    txtSerie.setText("" + prod1.getNumSerieProducto());
                    txtUbicacionActual.setText(prod1.getUbicacionProducto().toString());
                    agregarProductoALista();
                } else {
                    JOptionPane.showMessageDialog(null, "No Existe Producto");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se Encontró producto");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void TxtBuscarProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarProductoKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        try {
            String numAct = TxtBuscarProducto.getText();
            Producto prod = new DaoProducto().Buscar2(numAct);
            if (prod != null) {
                JOptionPane.showMessageDialog(null, "Existe Producto");
                txtNumeroActivo.setText("" + prod.getNumActivoProducto());
                txtSerie.setText("" + prod.getNumSerieProducto());
                txtUbicacionActual.setText(prod.getUbicacionProducto().toString());
                agregarProductoALista();
            } else {
                Producto prod1 = new DaoProducto().BuscarSerie(numAct);
                if (prod1 != null) {
//                    JOptionPane.showMessageDialog(null, "Existe Producto");
                    txtNumeroActivo.setText("" + prod1.getNumActivoProducto());
                    txtSerie.setText("" + prod1.getNumSerieProducto());
                    txtUbicacionActual.setText(prod1.getUbicacionProducto().toString());
                    agregarProductoALista();
                } else {
                    JOptionPane.showMessageDialog(null, "No Existe Producto");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se Encontró producto");
        }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se Encontró producto");
        }

    }//GEN-LAST:event_TxtBuscarProductoKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    try {
            // TODO add your handling code here:
            String producto = txtNumeroActivo.getText();

            Producto prod = new DaoProducto().Buscar2(producto);

            DefaultTableModel modelo = (DefaultTableModel) jtblMovimiento.getModel();

            boolean existe = false;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                String numProducto = (String) modelo.getValueAt(i, 0);
                if (numProducto.equalsIgnoreCase(producto) ) {
                    existe = true;
                    break;
                }
            }
            if (existe) {
                JOptionPane.showMessageDialog(null, "El producto ya existe en la tabla.");
            } else if (prod != null) {
                AgregarProducto();
                btnEliminarProducto.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: No se puede Agregar en Blanco");
        }                                 
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void TxtBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBuscarProductoActionPerformed

    private void txtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        try {
            //Free Research Preview. ChatGPT may produce inaccurate information about people, places, or facts. ChatGPT May 24 Version
            DefaultTableModel model = (DefaultTableModel) jtblMovimiento.getModel();
            // Get the selected row index
            int selectedRow = jtblMovimiento.getSelectedRow();
            // Check if a row is selected
            if (selectedRow != -1) {
                // Remove the row from the table model
                model.removeRow(selectedRow);

                // Update the JTable
                model.fireTableDataChanged();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

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
            java.util.logging.Logger.getLogger(JFrmNuevoMovimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmNuevoMovimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmNuevoMovimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmNuevoMovimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmNuevoMovimiento().setVisible(true);
            }
        });
    }

    private void agregarProductoALista() {
        try {
            // TODO add your handling code here:
            String producto = txtNumeroActivo.getText();

            Producto prod = new DaoProducto().Buscar2(producto);

            DefaultTableModel modelo = (DefaultTableModel) jtblMovimiento.getModel();

            boolean existe = false;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                String numProducto = (String) modelo.getValueAt(i, 0);
                if (numProducto == producto) {
                    existe = true;
                    break;
                }
            }
            if (existe) {
                JOptionPane.showMessageDialog(null, "El producto ya existe en la tabla.");
            } else if (prod != null) {
                AgregarProducto();
                btnEliminarProducto.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: No se puede Agregar en Blanco");
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CboTipoMovimiento;
    private javax.swing.JComboBox<String> CboUbicacionFinal;
    private javax.swing.JTextField TxtBuscarProducto;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnGenerarMovimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblMovimiento;
    private javax.swing.JTextField txtNumeroActivo;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtUbicacionActual;
    // End of variables declaration//GEN-END:variables
}
