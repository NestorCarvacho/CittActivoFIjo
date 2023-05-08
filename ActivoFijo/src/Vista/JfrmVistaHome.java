/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.DaoEmpleado;
import Controlador.DaoEstado;
import Controlador.DaoJornada;
import Controlador.DaoTipoEmpleado;
import Controlador.DaoTipoProducto;
import Controlador.DaoUbicacion;
import Modelo.Empleado;
import Modelo.Estado;
import Modelo.TipoEmpleado;
import Modelo.Jornada;
import Modelo.TipoProducto;
import Modelo.Ubicacion;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class JfrmVistaHome extends javax.swing.JFrame {

    /**
     * Creates new form JfrmVistaHome
     */
    public JfrmVistaHome() {
        initComponents();
        //CARGA DE CBO APENAS INICIE EL PROGRAMA
        ListarCboCargo();
        ListarCboJornada();
        ListarCboEstadoProducto();
        ListarCboUbicacion();
        ListarCboTipoProducto();
        ListarEmpleados();

        setIconImage(getIconImage());
        setIconImage(getIconHome());
        setIconImage(getIconUser());
        setIconImage(getIconPaper());
        setIconImage(getIconArrows());
        setIconImage(getIconBox());

    }

    //CARGA DE CBO PARA QUE LOS TOME DESDE LA BASE DE DATOS
    private void ListarCboCargo() {
        cboCargo.addItem("-- Seleccione --");
        for (TipoEmpleado tpEmp : new DaoTipoEmpleado().Listar()) {
            cboCargo.addItem(tpEmp.getDescripcionTipoEmpleado());
        }
    }

    private void ListarCboJornada() {
        cboJornada.removeAllItems();
        cboJornada.addItem("-- Seleccione --");
        for (Jornada jorn : new DaoJornada().Listar()) {
            cboJornada.addItem(jorn.getDescripcionJornada());
        }
    }

    private void ListarCboEstadoProducto() {
        cboEstadoProducto.removeAllItems();
        cboEstadoProducto.addItem("-- Seleccione --");
        for (Estado esta : new DaoEstado().Listar()) {
            cboEstadoProducto.addItem(esta.getDescripcionEstado());
        }
    }

    private void ListarCboUbicacion() {
        cboUbicacionProducto.removeAllItems();
        cboUbicacionProducto.addItem("-- Seleccione --");
        for (Ubicacion ubi : new DaoUbicacion().Listar()) {
            cboUbicacionProducto.addItem(ubi.getDescripcionUbicacion());
        }
    }

    private void ListarCboTipoProducto() {
        cboTipoProducto.removeAllItems();
        cboTipoProducto.addItem("-- Seleccione --");
        for (TipoProducto tpProd : new DaoTipoProducto().Listar()) {
            cboTipoProducto.addItem(tpProd.getDescripcionTipoProducto());
        }
    }

    private void ListarEmpleados() {
        DefaultTableModel modelo=new DefaultTableModel();
        JtbListarPersonas.setModel(modelo);
        modelo.addColumn("Rut");
        modelo.addColumn("Nombre");
        modelo.addColumn("Telefono");
        modelo.addColumn("Direccion");
        modelo.addColumn("Cargo");
        modelo.addColumn("Jornada");
        ArrayList<Empleado> listado = new DaoEmpleado().Listar();
        for (Empleado item : listado) {
            Object[] fila = new Object[6];
            fila[0]=item.getRutEmpleado();
            fila[1]=item.getNombreEmpleado();
            fila[2]=item.getTelefonoEmpleado();
            fila[3]=item.getDireccionEmpleado();
            fila[4]=item.getCargoEmpleado();
            fila[5]=item.getJornadaEmpleado();
            modelo.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane7 = new javax.swing.JTabbedPane();
        JpHome = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtbListarProductosHome = new javax.swing.JTable();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label5 = new java.awt.Label();
        label4 = new java.awt.Label();
        txtNumeroActivo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtTipoProducto = new javax.swing.JTextField();
        txtFechaAsignacion = new javax.swing.JTextField();
        txtNnumeroDeSerie = new javax.swing.JTextField();
        label7 = new java.awt.Label();
        txtUltimaActializacion = new javax.swing.JTextField();
        label8 = new java.awt.Label();
        label9 = new java.awt.Label();
        txtStock = new javax.swing.JTextField();
        label10 = new java.awt.Label();
        label11 = new java.awt.Label();
        txtEstado = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        label12 = new java.awt.Label();
        txtUnidadesLitros = new javax.swing.JTextField();
        label13 = new java.awt.Label();
        label14 = new java.awt.Label();
        txtCosto = new javax.swing.JTextField();
        JdcFechaLlegadaHome = new com.toedter.calendar.JDateChooser();
        JpCuentas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtbListarPersonas = new javax.swing.JTable();
        txtIdEmpleado = new javax.swing.JTextField();
        txtRunEmpleado = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        cboJornada = new javax.swing.JComboBox<>();
        cboSupervisor = new javax.swing.JComboBox<>();
        cboCargo = new javax.swing.JComboBox<>();
        label6 = new java.awt.Label();
        label15 = new java.awt.Label();
        label16 = new java.awt.Label();
        label17 = new java.awt.Label();
        label18 = new java.awt.Label();
        label19 = new java.awt.Label();
        label20 = new java.awt.Label();
        label21 = new java.awt.Label();
        btnCrearUsuario = new java.awt.Button();
        btnModificarUsuario = new java.awt.Button();
        btnEliminarUsuario = new java.awt.Button();
        label22 = new java.awt.Label();
        label23 = new java.awt.Label();
        JdcFechaLlegadaUsuario = new com.toedter.calendar.JDateChooser();
        btnCancelarUsuario = new java.awt.Button();
        JpProductos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JtbListarProductosProductos = new javax.swing.JTable();
        txtNumeroDeActivo = new javax.swing.JTextField();
        txtNumeroDeSerie = new javax.swing.JTextField();
        txtDescripcionProducto = new javax.swing.JTextField();
        cboTipoProducto = new javax.swing.JComboBox<>();
        txtUltimaActualizacionProducto = new javax.swing.JTextField();
        txtStockProducto = new javax.swing.JTextField();
        cboEstadoProducto = new javax.swing.JComboBox<>();
        txtColorProducto = new javax.swing.JTextField();
        txtMedicionProducto = new javax.swing.JTextField();
        txtCostoProducto = new javax.swing.JTextField();
        label40 = new java.awt.Label();
        label41 = new java.awt.Label();
        label42 = new java.awt.Label();
        label43 = new java.awt.Label();
        label44 = new java.awt.Label();
        label45 = new java.awt.Label();
        label46 = new java.awt.Label();
        label47 = new java.awt.Label();
        label48 = new java.awt.Label();
        label49 = new java.awt.Label();
        label50 = new java.awt.Label();
        label51 = new java.awt.Label();
        label52 = new java.awt.Label();
        btnCrearProducto = new java.awt.Button();
        btnModificarProducto = new java.awt.Button();
        btnEliminarProducto = new java.awt.Button();
        JdcFechaLlegadaProducto = new com.toedter.calendar.JDateChooser();
        JdcFechaAsignacionProducto = new com.toedter.calendar.JDateChooser();
        btnCancelarProducto = new java.awt.Button();
        label53 = new java.awt.Label();
        cboUbicacionProducto = new javax.swing.JComboBox<>();
        JpInformes = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        BtnExportarInventario = new javax.swing.JButton();
        BtnImprimirInventario = new javax.swing.JButton();
        btnMovimientos = new javax.swing.JButton();
        BtnImprimirMovimientos = new javax.swing.JButton();
        CboSeleccionBodegaInforme = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CboFiltroProductoInforme = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        BtnFiltrarInforme = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        JTblListarProductosInformes = new javax.swing.JTable();
        JpMovimientos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JtbListarProductosMovimientos = new javax.swing.JTable();
        label27 = new java.awt.Label();
        label28 = new java.awt.Label();
        label29 = new java.awt.Label();
        label30 = new java.awt.Label();
        label31 = new java.awt.Label();
        txtNumeroActivo2 = new javax.swing.JTextField();
        txtDescripcion2 = new javax.swing.JTextField();
        txtFechaAsignacion2 = new javax.swing.JTextField();
        txtNnumeroDeSerie2 = new javax.swing.JTextField();
        label32 = new java.awt.Label();
        txtUltimaActializacion2 = new javax.swing.JTextField();
        label33 = new java.awt.Label();
        label34 = new java.awt.Label();
        label35 = new java.awt.Label();
        label36 = new java.awt.Label();
        JcbUbicacioninicio = new javax.swing.JComboBox<>();
        JcbUbicacionDestino = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        JdcFechaLlegadaMovimiento = new com.toedter.calendar.JDateChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuCerrar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Activo Fijo Bodega");
        setForeground(java.awt.Color.white);
        setIconImage(getIconImage());
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jTabbedPane7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane7.setToolTipText("");

        JpHome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        JtbListarProductosHome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero de Activo", "Numero de Serie", "Descripcion", "Tipo Producto", "Ubicacion", "Fecha Asignacion", "Fecha Actualizacion"
            }
        ));
        jScrollPane1.setViewportView(JtbListarProductosHome);

        label1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        label1.setText("Detalle del Producto");

        label2.setText("Numero de Serie");

        label3.setText("Numero de Activo");

        label5.setText("Descripcion");

        label4.setText("Tipo de Producto");

        txtNumeroActivo.setEnabled(false);
        txtNumeroActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActivoActionPerformed(evt);
            }
        });

        txtDescripcion.setEnabled(false);
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        txtTipoProducto.setEnabled(false);
        txtTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoProductoActionPerformed(evt);
            }
        });

        txtFechaAsignacion.setEnabled(false);
        txtFechaAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaAsignacionActionPerformed(evt);
            }
        });

        txtNnumeroDeSerie.setEnabled(false);
        txtNnumeroDeSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNnumeroDeSerieActionPerformed(evt);
            }
        });

        label7.setText("Fecha Asignacion");

        txtUltimaActializacion.setEnabled(false);
        txtUltimaActializacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUltimaActializacionActionPerformed(evt);
            }
        });

        label8.setText("Ultima Actualización");

        label9.setText("Fecha Llegada");

        txtStock.setEnabled(false);
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        label10.setText("Stock");

        label11.setText("Estado");

        txtEstado.setEnabled(false);
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        txtColor.setEnabled(false);
        txtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorActionPerformed(evt);
            }
        });

        label12.setText("Color");

        txtUnidadesLitros.setEnabled(false);
        txtUnidadesLitros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadesLitrosActionPerformed(evt);
            }
        });

        label13.setText("Unidades/Lts");

        label14.setText("Costo");

        txtCosto.setEnabled(false);
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });

        JdcFechaLlegadaHome.setEnabled(false);

        javax.swing.GroupLayout JpHomeLayout = new javax.swing.GroupLayout(JpHome);
        JpHome.setLayout(JpHomeLayout);
        JpHomeLayout.setHorizontalGroup(
            JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpHomeLayout.createSequentialGroup()
                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(JpHomeLayout.createSequentialGroup()
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JpHomeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(155, 155, 155)
                                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumeroActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNnumeroDeSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaAsignacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(150, 150, 150)
                                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(JpHomeLayout.createSequentialGroup()
                                        .addComponent(label12, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(JpHomeLayout.createSequentialGroup()
                                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(17, 17, 17)
                                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtUltimaActializacion, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                            .addComponent(txtStock, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                            .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                            .addComponent(JdcFechaLlegadaHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(57, 57, 57)
                                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUnidadesLitros, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JpHomeLayout.setVerticalGroup(
            JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpHomeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpHomeLayout.createSequentialGroup()
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUltimaActializacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JdcFechaLlegadaHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpHomeLayout.createSequentialGroup()
                                .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JpHomeLayout.createSequentialGroup()
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JpHomeLayout.createSequentialGroup()
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpHomeLayout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNumeroActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNnumeroDeSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpHomeLayout.createSequentialGroup()
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JpHomeLayout.createSequentialGroup()
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFechaAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JpHomeLayout.createSequentialGroup()
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUnidadesLitros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(122, 122, 122)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("Home  ", new javax.swing.ImageIcon(getClass().getResource("/Img/home.png")), JpHome); // NOI18N
        JpHome.getAccessibleContext().setAccessibleName("");
        JpHome.getAccessibleContext().setAccessibleDescription("");

        JpCuentas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        JtbListarPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero de Activo", "Numero de Serie", "Descripcion", "Tipo Producto", "Ubicacion", "Fecha Asignacion", "Fecha Actualizacion"
            }
        ));
        jScrollPane2.setViewportView(JtbListarPersonas);

        txtIdEmpleado.setEnabled(false);
        txtIdEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEmpleadoActionPerformed(evt);
            }
        });

        txtRunEmpleado.setEnabled(false);
        txtRunEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRunEmpleadoActionPerformed(evt);
            }
        });

        txtNombre.setEnabled(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtTelefono.setEnabled(false);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        txtDireccion.setEnabled(false);
        txtDireccion.setMaximumSize(new java.awt.Dimension(300, 22));
        txtDireccion.setMinimumSize(new java.awt.Dimension(300, 22));
        txtDireccion.setPreferredSize(new java.awt.Dimension(300, 22));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        cboJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboJornada.setEnabled(false);

        cboSupervisor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboSupervisor.setEnabled(false);
        cboSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSupervisorActionPerformed(evt);
            }
        });

        cboCargo.setEnabled(false);
        cboCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCargoActionPerformed(evt);
            }
        });

        label6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        label6.setText("Detalle del Personal");

        label15.setText("R.U.N Empleado");

        label16.setText("ID empleado");

        label17.setText("Nombre");

        label18.setText("Telefono");

        label19.setText("Dirección");

        label20.setText("Jornada");

        label21.setText("Fecha Llegada");

        btnCrearUsuario.setLabel("Crear Usuario");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        btnModificarUsuario.setLabel("Modificar Usuario");

        btnEliminarUsuario.setLabel("Eliminar Usuario");

        label22.setText("Supervisor");

        label23.setText("Cargo");

        JdcFechaLlegadaUsuario.setEnabled(false);

        btnCancelarUsuario.setActionCommand("CancelarUsuario");
        btnCancelarUsuario.setEnabled(false);
        btnCancelarUsuario.setLabel("CancelarUsuario");
        btnCancelarUsuario.setName("CancelarUsuario"); // NOI18N
        btnCancelarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarUsuarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JpCuentasLayout = new javax.swing.GroupLayout(JpCuentas);
        JpCuentas.setLayout(JpCuentasLayout);
        JpCuentasLayout.setHorizontalGroup(
            JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpCuentasLayout.createSequentialGroup()
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(JpCuentasLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label15, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JpCuentasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label17, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(label18, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(label19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRunEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboJornada, 0, 172, Short.MAX_VALUE)
                    .addComponent(cboSupervisor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JdcFechaLlegadaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JpCuentasLayout.createSequentialGroup()
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpCuentasLayout.createSequentialGroup()
                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 595, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        JpCuentasLayout.setVerticalGroup(
            JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpCuentasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpCuentasLayout.createSequentialGroup()
                        .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRunEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpCuentasLayout.createSequentialGroup()
                                .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(label18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JpCuentasLayout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JpCuentasLayout.createSequentialGroup()
                        .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JdcFechaLlegadaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("Cuentas  ", new javax.swing.ImageIcon(getClass().getResource("/Img/user.png")), JpCuentas); // NOI18N

        JpProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JpProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JpProductosMouseExited(evt);
            }
        });
        JpProductos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JpProductosPropertyChange(evt);
            }
        });

        JtbListarProductosProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero de Activo", "Numero de Serie", "Descripcion", "Tipo Producto", "Ubicacion", "Fecha Asignacion", "Fecha Actualizacion"
            }
        ));
        jScrollPane4.setViewportView(JtbListarProductosProductos);

        txtNumeroDeActivo.setEnabled(false);
        txtNumeroDeActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDeActivoActionPerformed(evt);
            }
        });

        txtNumeroDeSerie.setEnabled(false);
        txtNumeroDeSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDeSerieActionPerformed(evt);
            }
        });

        txtDescripcionProducto.setEnabled(false);
        txtDescripcionProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionProductoActionPerformed(evt);
            }
        });

        cboTipoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTipoProducto.setEnabled(false);

        txtUltimaActualizacionProducto.setEnabled(false);
        txtUltimaActualizacionProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUltimaActualizacionProductoActionPerformed(evt);
            }
        });

        txtStockProducto.setEnabled(false);
        txtStockProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockProductoActionPerformed(evt);
            }
        });

        cboEstadoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboEstadoProducto.setEnabled(false);

        txtColorProducto.setEnabled(false);
        txtColorProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorProductoActionPerformed(evt);
            }
        });

        txtMedicionProducto.setEnabled(false);
        txtMedicionProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMedicionProductoActionPerformed(evt);
            }
        });

        txtCostoProducto.setEnabled(false);
        txtCostoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoProductoActionPerformed(evt);
            }
        });

        label40.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        label40.setText("Detalle del Producto");

        label41.setText("Numero de Serie");

        label42.setText("Numero de Activo");

        label43.setText("Descripcion");

        label44.setText("Tipo de Producto");

        label45.setText("Fecha Asignacion");

        label46.setText("Ultima Actualización");

        label47.setText("Fecha Llegada");

        label48.setText("Stock");

        label49.setText("Estado");

        label50.setText("Color");

        label51.setText("Unidades/Lts");

        label52.setText("Costo");

        btnCrearProducto.setLabel("Crear Producto");
        btnCrearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProductoActionPerformed(evt);
            }
        });

        btnModificarProducto.setLabel("Modificar Producto");

        btnEliminarProducto.setLabel("Eliminar Producto");

        JdcFechaLlegadaProducto.setEnabled(false);

        JdcFechaAsignacionProducto.setEnabled(false);

        btnCancelarProducto.setActionCommand("Cancelar");
        btnCancelarProducto.setEnabled(false);
        btnCancelarProducto.setLabel("Cancelar");
        btnCancelarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarProductoMouseClicked(evt);
            }
        });

        label53.setText("Ubicacion");

        cboUbicacionProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboUbicacionProducto.setEnabled(false);

        javax.swing.GroupLayout JpProductosLayout = new javax.swing.GroupLayout(JpProductos);
        JpProductos.setLayout(JpProductosLayout);
        JpProductosLayout.setHorizontalGroup(
            JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpProductosLayout.createSequentialGroup()
                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpProductosLayout.createSequentialGroup()
                        .addComponent(label40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrearProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JpProductosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpProductosLayout.createSequentialGroup()
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label45, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(label42, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(155, 155, 155)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumeroDeActivo, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(txtNumeroDeSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(cboTipoProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JdcFechaAsignacionProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(189, 189, 189)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label49, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label53, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUltimaActualizacionProducto)
                                    .addComponent(txtStockProducto)
                                    .addComponent(cboEstadoProducto, 0, 172, Short.MAX_VALUE)
                                    .addComponent(JdcFechaLlegadaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboUbicacionProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpProductosLayout.createSequentialGroup()
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label52, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label51, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMedicionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCostoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpProductosLayout.createSequentialGroup()
                                        .addComponent(label50, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtColorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane4))))
                .addContainerGap())
        );
        JpProductosLayout.setVerticalGroup(
            JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpProductosLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCrearProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label40, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JpProductosLayout.createSequentialGroup()
                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpProductosLayout.createSequentialGroup()
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumeroDeActivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumeroDeSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(label44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JdcFechaAsignacionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JpProductosLayout.createSequentialGroup()
                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpProductosLayout.createSequentialGroup()
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(JpProductosLayout.createSequentialGroup()
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtUltimaActualizacionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(14, 14, 14)
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JdcFechaLlegadaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(JpProductosLayout.createSequentialGroup()
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMedicionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCostoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JpProductosLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtStockProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpProductosLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtColorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboEstadoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboUbicacionProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jTabbedPane7.addTab("Productos  ", new javax.swing.ImageIcon(getClass().getResource("/Img/box.png")), JpProductos); // NOI18N

        JpInformes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BtnExportarInventario.setText("Exportar Inventario");
        BtnExportarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExportarInventarioActionPerformed(evt);
            }
        });

        BtnImprimirInventario.setText("Imprimir Inventario");

        btnMovimientos.setText("Exportar Movimientos");

        BtnImprimirMovimientos.setText("Imprimir Movimientos");

        CboSeleccionBodegaInforme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Seleccione Bodega");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BtnExportarInventario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnImprimirInventario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMovimientos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnImprimirMovimientos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(CboSeleccionBodegaInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnExportarInventario)
                    .addComponent(BtnImprimirInventario)
                    .addComponent(btnMovimientos)
                    .addComponent(BtnImprimirMovimientos))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CboSeleccionBodegaInforme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel2.setText("Seleccione Productos para Filtar");

        CboFiltroProductoInforme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --" }));

        BtnFiltrarInforme.setText("Filtrar");

        jLabel3.setText("Ingrese Productos para Filtar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(CboFiltroProductoInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnFiltrarInforme)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CboFiltroProductoInforme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnFiltrarInforme))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTblListarProductosInformes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Activos", "Numero de Serie", "Descripcion", "Ubicacion", "Tipo de Producto", "Fecha Asignacion", "Ultima Actualizacion"
            }
        ));
        jScrollPane5.setViewportView(JTblListarProductosInformes);

        javax.swing.GroupLayout JpInformesLayout = new javax.swing.GroupLayout(JpInformes);
        JpInformes.setLayout(JpInformesLayout);
        JpInformesLayout.setHorizontalGroup(
            JpInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpInformesLayout.createSequentialGroup()
                .addGroup(JpInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpInformesLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JpInformesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5)))
                .addContainerGap())
        );
        JpInformesLayout.setVerticalGroup(
            JpInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpInformesLayout.createSequentialGroup()
                .addGroup(JpInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("Informes  ", new javax.swing.ImageIcon(getClass().getResource("/Img/paper.png")), JpInformes); // NOI18N

        JpMovimientos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        JtbListarProductosMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Activo", "Numero de Serie", "Descripcion", "Tipo Producto", "Ubicacion", "Fecha Asignacion", "Fecha Actualizacion"
            }
        ));
        jScrollPane3.setViewportView(JtbListarProductosMovimientos);

        label27.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        label27.setText("Detalle del Producto");

        label28.setText("Numero de Serie");

        label29.setText("Numero de Activo");

        label30.setText("Descripcion");

        label31.setText("Tipo de Producto");

        txtNumeroActivo2.setEnabled(false);
        txtNumeroActivo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActivo2ActionPerformed(evt);
            }
        });

        txtDescripcion2.setEnabled(false);
        txtDescripcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcion2ActionPerformed(evt);
            }
        });

        txtFechaAsignacion2.setEnabled(false);
        txtFechaAsignacion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaAsignacion2ActionPerformed(evt);
            }
        });

        txtNnumeroDeSerie2.setEnabled(false);
        txtNnumeroDeSerie2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNnumeroDeSerie2ActionPerformed(evt);
            }
        });

        label32.setText("Fecha Asignacion");

        txtUltimaActializacion2.setEnabled(false);
        txtUltimaActializacion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUltimaActializacion2ActionPerformed(evt);
            }
        });

        label33.setText("Ultima Actualización");

        label34.setText("Fecha Llegada");

        label35.setText("Ubicacion inicio");

        label36.setText("Ubicacion Destino");

        JcbUbicacioninicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --" }));
        JcbUbicacioninicio.setEnabled(false);
        JcbUbicacioninicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcbUbicacioninicioActionPerformed(evt);
            }
        });

        JcbUbicacionDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --" }));
        JcbUbicacionDestino.setEnabled(false);
        JcbUbicacionDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcbUbicacionDestinoActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --" }));
        jComboBox1.setEnabled(false);

        JdcFechaLlegadaMovimiento.setEnabled(false);

        javax.swing.GroupLayout JpMovimientosLayout = new javax.swing.GroupLayout(JpMovimientos);
        JpMovimientos.setLayout(JpMovimientosLayout);
        JpMovimientosLayout.setHorizontalGroup(
            JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMovimientosLayout.createSequentialGroup()
                .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(JpMovimientosLayout.createSequentialGroup()
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpMovimientosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label32, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(155, 155, 155)
                                .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNumeroActivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDescripcion2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNnumeroDeSerie2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFechaAsignacion2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(150, 150, 150)
                                .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(17, 17, 17)
                                .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUltimaActializacion2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(JcbUbicacioninicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JcbUbicacionDestino, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JdcFechaLlegadaMovimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 444, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JpMovimientosLayout.setVerticalGroup(
            JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMovimientosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpMovimientosLayout.createSequentialGroup()
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroActivo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNnumeroDeSerie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpMovimientosLayout.createSequentialGroup()
                                .addComponent(label30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JpMovimientosLayout.createSequentialGroup()
                                .addComponent(txtDescripcion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFechaAsignacion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpMovimientosLayout.createSequentialGroup()
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUltimaActializacion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JdcFechaLlegadaMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcbUbicacioninicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcbUbicacionDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("Movimientos  ", new javax.swing.ImageIcon(getClass().getResource("/Img/arrows.png")), JpMovimientos); // NOI18N

        jMenu1.setText("Archivo");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });

        jMenuItem5.setText("Editar");
        jMenu1.add(jMenuItem5);

        jMenuItem2.setText("Productos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Informes");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Movimientos");
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator1);

        jMenuItem1.setText("Cerrar Sesion");
        jMenu1.add(jMenuItem1);

        mnuCerrar.setText("Cerrar");
        mnuCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuCerrarMouseClicked(evt);
            }
        });
        mnuCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCerrarActionPerformed(evt);
            }
        });
        jMenu1.add(mnuCerrar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cuentas");

        jMenuItem7.setText("Crear Usuario");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Modificar Ususario");
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Buscar Usuario");
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Productos");

        jMenuItem10.setText("Crear Producto");
        jMenu3.add(jMenuItem10);

        jMenuItem11.setText("Modificar Producto");
        jMenu3.add(jMenuItem11);

        jMenuItem12.setText("Buscar Producto");
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Informes");

        jMenuItem13.setText("Crear Informe");
        jMenu4.add(jMenuItem13);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Movimientos");

        jMenuItem14.setText("Nuevo Movimiento");
        jMenu5.add(jMenuItem14);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane7)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane7)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtNumeroActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActivoActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoProductoActionPerformed

    private void txtFechaAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaAsignacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaAsignacionActionPerformed

    private void txtNnumeroDeSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNnumeroDeSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNnumeroDeSerieActionPerformed

    private void txtUltimaActializacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUltimaActializacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUltimaActializacionActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorActionPerformed

    private void txtUnidadesLitrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadesLitrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadesLitrosActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtRunEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRunEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRunEmpleadoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtIdEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEmpleadoActionPerformed

    private void txtNumeroActivo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActivo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActivo2ActionPerformed

    private void txtDescripcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcion2ActionPerformed

    private void txtFechaAsignacion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaAsignacion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaAsignacion2ActionPerformed

    private void txtNnumeroDeSerie2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNnumeroDeSerie2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNnumeroDeSerie2ActionPerformed

    private void txtUltimaActializacion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUltimaActializacion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUltimaActializacion2ActionPerformed

    private void txtNumeroDeActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDeActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDeActivoActionPerformed

    private void txtDescripcionProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionProductoActionPerformed

    private void txtNumeroDeSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDeSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDeSerieActionPerformed

    private void txtUltimaActualizacionProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUltimaActualizacionProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUltimaActualizacionProductoActionPerformed

    private void txtStockProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockProductoActionPerformed

    private void txtColorProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorProductoActionPerformed

    private void txtMedicionProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMedicionProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedicionProductoActionPerformed

    private void txtCostoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoProductoActionPerformed

    private void JcbUbicacioninicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcbUbicacioninicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcbUbicacioninicioActionPerformed

    private void JcbUbicacionDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcbUbicacionDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcbUbicacionDestinoActionPerformed

    private void BtnExportarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExportarInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnExportarInventarioActionPerformed

    private void btnCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProductoActionPerformed
        // TODO add your handling code here:
        btnCancelarProducto.setEnabled(true);
        txtNumeroDeSerie.setEnabled(true);
        txtDescripcionProducto.setEnabled(true);
        cboTipoProducto.setEnabled(true);
        JdcFechaLlegadaProducto.setEnabled(true);
        txtStockProducto.setEnabled(true);
        cboEstadoProducto.setEnabled(true);
        txtColorProducto.setEnabled(true);
        txtMedicionProducto.setEnabled(true);
        txtCostoProducto.setEnabled(true);
        cboUbicacionProducto.setEnabled(true);

    }//GEN-LAST:event_btnCrearProductoActionPerformed

    private void JpProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JpProductosMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_JpProductosMouseExited

    private void JpProductosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JpProductosPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_JpProductosPropertyChange

    private void cboCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCargoActionPerformed

    }//GEN-LAST:event_cboCargoActionPerformed

    private void btnCancelarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarProductoMouseClicked
        btnCancelarProducto.setEnabled(false);
        txtNumeroDeSerie.setEnabled(false);
        txtDescripcionProducto.setEnabled(false);
        cboTipoProducto.setEnabled(false);
        JdcFechaLlegadaProducto.setEnabled(false);
        txtStockProducto.setEnabled(false);
        cboEstadoProducto.setEnabled(false);
        txtColorProducto.setEnabled(false);
        txtMedicionProducto.setEnabled(false);
        txtCostoProducto.setEnabled(false);
        cboUbicacionProducto.setEnabled(false);

        txtNumeroDeSerie.setText("");
        txtDescripcionProducto.setText("");
        txtStockProducto.setText("");
        txtColorProducto.setText("");
        txtMedicionProducto.setText("");
        txtCostoProducto.setText("");
        cboTipoProducto.setSelectedItem("-- Seleccione --");
        cboEstadoProducto.setSelectedItem("-- Seleccione --");
        cboUbicacionProducto.setSelectedItem("-- Seleccione --");
    }//GEN-LAST:event_btnCancelarProductoMouseClicked

    private void btnCancelarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarUsuarioMouseClicked
        // TODO add your handling code here:
        txtRunEmpleado.setEnabled(false);
        txtNombre.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtDireccion.setEnabled(false);
        cboJornada.setEnabled(false);
        JdcFechaLlegadaUsuario.setEnabled(false);
        cboSupervisor.setEnabled(false);
        cboCargo.setEnabled(false);

        txtRunEmpleado.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        JdcFechaLlegadaUsuario.setEnabled(false);
        cboJornada.setEnabled(false);
        cboCargo.setEnabled(false);
        cboJornada.setSelectedItem("-- Seleccione --");
        cboSupervisor.setSelectedItem("-- Seleccione --");
        cboCargo.setSelectedItem("-- Seleccione --");
        btnCancelarUsuario.setEnabled(false);
    }//GEN-LAST:event_btnCancelarUsuarioMouseClicked

    private void cboSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSupervisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSupervisorActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked

    }//GEN-LAST:event_jMenu1MouseClicked

    private void mnuCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_mnuCerrarMouseClicked

    private void mnuCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mnuCerrarActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        btnCancelarUsuario.setEnabled(true);
        txtRunEmpleado.setEnabled(true);
        txtNombre.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtDireccion.setEnabled(true);
        cboJornada.setEnabled(true);
        JdcFechaLlegadaUsuario.setEnabled(true);
        cboSupervisor.setEnabled(true);
        cboCargo.setEnabled(true);
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
            java.util.logging.Logger.getLogger(JfrmVistaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmVistaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmVistaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmVistaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfrmVistaHome().setVisible(true);
            }
        });
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnExportarInventario;
    private javax.swing.JButton BtnFiltrarInforme;
    private javax.swing.JButton BtnImprimirInventario;
    private javax.swing.JButton BtnImprimirMovimientos;
    private javax.swing.JComboBox<String> CboFiltroProductoInforme;
    private javax.swing.JComboBox<String> CboSeleccionBodegaInforme;
    private javax.swing.JTable JTblListarProductosInformes;
    private javax.swing.JComboBox<String> JcbUbicacionDestino;
    private javax.swing.JComboBox<String> JcbUbicacioninicio;
    private com.toedter.calendar.JDateChooser JdcFechaAsignacionProducto;
    private com.toedter.calendar.JDateChooser JdcFechaLlegadaHome;
    private com.toedter.calendar.JDateChooser JdcFechaLlegadaMovimiento;
    private com.toedter.calendar.JDateChooser JdcFechaLlegadaProducto;
    private com.toedter.calendar.JDateChooser JdcFechaLlegadaUsuario;
    private javax.swing.JPanel JpCuentas;
    private javax.swing.JPanel JpHome;
    private javax.swing.JPanel JpInformes;
    private javax.swing.JPanel JpMovimientos;
    private javax.swing.JPanel JpProductos;
    private javax.swing.JTable JtbListarPersonas;
    private javax.swing.JTable JtbListarProductosHome;
    private javax.swing.JTable JtbListarProductosMovimientos;
    private javax.swing.JTable JtbListarProductosProductos;
    private java.awt.Button btnCancelarProducto;
    private java.awt.Button btnCancelarUsuario;
    private java.awt.Button btnCrearProducto;
    private java.awt.Button btnCrearUsuario;
    private java.awt.Button btnEliminarProducto;
    private java.awt.Button btnEliminarUsuario;
    private java.awt.Button btnModificarProducto;
    private java.awt.Button btnModificarUsuario;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JComboBox<String> cboCargo;
    private javax.swing.JComboBox<String> cboEstadoProducto;
    private javax.swing.JComboBox<String> cboJornada;
    private javax.swing.JComboBox<String> cboSupervisor;
    private javax.swing.JComboBox<String> cboTipoProducto;
    private javax.swing.JComboBox<String> cboUbicacionProducto;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label13;
    private java.awt.Label label14;
    private java.awt.Label label15;
    private java.awt.Label label16;
    private java.awt.Label label17;
    private java.awt.Label label18;
    private java.awt.Label label19;
    private java.awt.Label label2;
    private java.awt.Label label20;
    private java.awt.Label label21;
    private java.awt.Label label22;
    private java.awt.Label label23;
    private java.awt.Label label27;
    private java.awt.Label label28;
    private java.awt.Label label29;
    private java.awt.Label label3;
    private java.awt.Label label30;
    private java.awt.Label label31;
    private java.awt.Label label32;
    private java.awt.Label label33;
    private java.awt.Label label34;
    private java.awt.Label label35;
    private java.awt.Label label36;
    private java.awt.Label label4;
    private java.awt.Label label40;
    private java.awt.Label label41;
    private java.awt.Label label42;
    private java.awt.Label label43;
    private java.awt.Label label44;
    private java.awt.Label label45;
    private java.awt.Label label46;
    private java.awt.Label label47;
    private java.awt.Label label48;
    private java.awt.Label label49;
    private java.awt.Label label5;
    private java.awt.Label label50;
    private java.awt.Label label51;
    private java.awt.Label label52;
    private java.awt.Label label53;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private javax.swing.JMenuItem mnuCerrar;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtColorProducto;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtCostoProducto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDescripcion2;
    private javax.swing.JTextField txtDescripcionProducto;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFechaAsignacion;
    private javax.swing.JTextField txtFechaAsignacion2;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtMedicionProducto;
    private javax.swing.JTextField txtNnumeroDeSerie;
    private javax.swing.JTextField txtNnumeroDeSerie2;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroActivo;
    private javax.swing.JTextField txtNumeroActivo2;
    private javax.swing.JTextField txtNumeroDeActivo;
    private javax.swing.JTextField txtNumeroDeSerie;
    private javax.swing.JTextField txtRunEmpleado;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtStockProducto;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipoProducto;
    private javax.swing.JTextField txtUltimaActializacion;
    private javax.swing.JTextField txtUltimaActializacion2;
    private javax.swing.JTextField txtUltimaActualizacionProducto;
    private javax.swing.JTextField txtUnidadesLitros;
    // End of variables declaration//GEN-END:variables
}
