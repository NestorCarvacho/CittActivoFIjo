/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.DaoEmpleado;
import Controlador.DaoEstado;
import Controlador.DaoJornada;
import Controlador.DaoProducto;
import Controlador.DaoTipoEmpleado;
import Controlador.DaoTipoProducto;
import Controlador.DaoUbicacion;
import Modelo.Empleado;
import Modelo.Estado;
import Modelo.TipoEmpleado;
import Modelo.Jornada;
import Modelo.Producto;
import Modelo.TipoProducto;
import Modelo.Ubicacion;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
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
        //set programa en la mitad de la pantalla
        setLocationRelativeTo(null);
        //CARGA DE CBO APENAS INICIE EL PROGRAMA
        ListarCboCargo();
        ListarCboJornada();
        ListarCboEstadoProducto();
        ListarCboUbicacion();
        ListarCboTipoProducto();
        ListarEmpleados();
        ListarProductosHome();
        ListarProductosProductos();
        ListarProductosInformes();
        ListarProductosMovimientos();
        ListarcboTipoProductoHome();
        ListarcboUbicacionProductoHome();
        ListarcboEstadoProductoHome();
//        FiltroEmpleado();
//        Date fecha = new Date();
//        JdcFechaAsignacionHome.setDate(fecha);

        setIconImage(getIconImage());
        setIconImage(getIconHome());
        setIconImage(getIconUser());
        setIconImage(getIconPaper());
        setIconImage(getIconArrows());
        setIconImage(getIconBox());

    }

    //CARGA DE CBO PARA QUE LOS TOME DESDE LA BASE DE DATOS
    private void ListarCboCargo() {
        cboCargoEmpleado.addItem("-- Seleccione --");
        for (TipoEmpleado tpEmp : new DaoTipoEmpleado().Listar()) {
            cboCargoEmpleado.addItem(tpEmp.getDescripcionTipoEmpleado());
        }
    }

    //CboFiltroEmpleado
//    private void FiltroEmpleado() {
//        CboFiltroEmpleado.removeAllItems();
//        CboFiltroEmpleado.addItem("-- Seleccione --");
//        for (Empleado emp : new DaoEmpleado().Listar()) {
//            CboFiltroEmpleado.addItem(emp.getRutEmpleado());
//        }
//    }
    private void ListarCboJornada() {
        cboJornadaEmpleado.removeAllItems();
        cboJornadaEmpleado.addItem("-- Seleccione --");
        for (Jornada jorn : new DaoJornada().Listar()) {
            cboJornadaEmpleado.addItem(jorn.getDescripcionJornada());
        }
    }

    private void ListarCboEstadoProducto() {
        cboEstadoProductoProducto.removeAllItems();
        cboEstadoProductoProducto.addItem("-- Seleccione --");
        for (Estado esta : new DaoEstado().Listar()) {
            cboEstadoProductoProducto.addItem(esta.getDescripcionEstado());
        }
    }

    private void ListarCboUbicacion() {
        cboUbicacionProductoProducto.removeAllItems();
        cboUbicacionProductoProducto.addItem("-- Seleccione --");
        for (Ubicacion ubi : new DaoUbicacion().Listar()) {
            cboUbicacionProductoProducto.addItem(ubi.getDescripcionUbicacion());
        }
    }

    private void ListarCboTipoProducto() {
        cboTipoProductoProducto.removeAllItems();
        cboTipoProductoProducto.addItem("-- Seleccione --");
        for (TipoProducto tpProd : new DaoTipoProducto().Listar()) {
            cboTipoProductoProducto.addItem(tpProd.getDescripcionTipoProducto());
        }
    }

    private void ListarEmpleados() {
        DefaultTableModel modelo = new DefaultTableModel();
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
            fila[0] = item.getRutEmpleado();
            fila[1] = item.getNombreEmpleado();
            fila[2] = item.getTelefonoEmpleado();
            fila[3] = item.getDireccionEmpleado();
            fila[4] = item.getCargoEmpleado();
            fila[5] = item.getJornadaEmpleado();
            modelo.addRow(fila);
        }
    }

    //cboTipoProductoHome
    private void ListarcboTipoProductoHome() {
        cboTipoProductoHome.removeAllItems();
        cboTipoProductoHome.addItem("-- Seleccione --");
        for (TipoProducto tpprod : new DaoTipoProducto().Listar()) {
            cboTipoProductoHome.addItem(tpprod.getDescripcionTipoProducto());
        }
    }
    //cboUbicacionProductoHome
    private void ListarcboUbicacionProductoHome() {
        cboUbicacionProductoHome.removeAllItems();
        cboUbicacionProductoHome.addItem("-- Seleccione --");
        for (Ubicacion ubi : new DaoUbicacion ().Listar()) {
            cboUbicacionProductoHome.addItem(ubi.getDescripcionUbicacion());
        }
    }
    //cboEstadoProductoHome
    private void ListarcboEstadoProductoHome() {
        cboEstadoProductoHome.removeAllItems();
        cboEstadoProductoHome.addItem("-- Seleccione --");
        for (Estado est : new DaoEstado().Listar()) {
            cboEstadoProductoHome.addItem(est.getDescripcionEstado());
        }
    }
    
    //JtbListarProductosProductos
    private void ListarProductosProductos() {
        DefaultTableModel modelo = new DefaultTableModel();
        JtbListarProductosProductos.setModel(modelo);
        modelo.addColumn("Numero Activo");
        modelo.addColumn("Numero Serie");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("Tipo Producto");
        modelo.addColumn("Fecha Llegada");
        modelo.addColumn("Color");
        modelo.addColumn("Costo");
        modelo.addColumn("Estado");
        ArrayList<Producto> listado = new DaoProducto().Listar();
        for (Producto item : listado) {
            Object[] fila = new Object[9];
            fila[0] = item.getNumActivoProducto();
            fila[1] = item.getNumSerieProducto();
            fila[2] = item.getDescProducto();
            fila[3] = item.getUbicacionProducto();
            fila[4] = item.getTipoProducto();
            fila[5] = item.getFechaLlegadaProducto();
            fila[6] = item.getColorProducto();
            fila[7] = item.getCostoProducto();
            fila[8] = item.getEstadoProducto();
            modelo.addRow(fila);
        }
    }

    private void ListarProductosHome() {
        DefaultTableModel modelo = new DefaultTableModel();
        JtbListarProductosHome.setModel(modelo);
        modelo.addColumn("Numero Activo");
        modelo.addColumn("Numero Serie");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("Tipo Producto");
        modelo.addColumn("Fecha Llegada");
        modelo.addColumn("Color");
        modelo.addColumn("Costo");
        modelo.addColumn("Estado");
        ArrayList<Producto> listado = new DaoProducto().Listar();
        for (Producto item : listado) {
            Object[] fila = new Object[9];
            fila[0] = item.getNumActivoProducto();
            fila[1] = item.getNumSerieProducto();
            fila[2] = item.getDescProducto();
            fila[3] = item.getUbicacionProducto();
            fila[4] = item.getTipoProducto();
            fila[5] = item.getFechaLlegadaProducto();
            fila[6] = item.getColorProducto();
            fila[7] = item.getCostoProducto();
            fila[8] = item.getEstadoProducto();
            modelo.addRow(fila);
        }
    }

    //JTblListarProductosInformes
    private void ListarProductosInformes() {
        DefaultTableModel modelo = new DefaultTableModel();
        JTblListarProductosInformes.setModel(modelo);
        modelo.addColumn("Numero Activo");
        modelo.addColumn("Numero Serie");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("Tipo Producto");
        modelo.addColumn("Fecha Llegada");
        modelo.addColumn("Color");
        modelo.addColumn("Costo");
        modelo.addColumn("Estado");
        ArrayList<Producto> listado = new DaoProducto().Listar();
        for (Producto item : listado) {
            Object[] fila = new Object[9];
            fila[0] = item.getNumActivoProducto();
            fila[1] = item.getNumSerieProducto();
            fila[2] = item.getDescProducto();
            fila[3] = item.getUbicacionProducto();
            fila[4] = item.getTipoProducto();
            fila[5] = item.getFechaLlegadaProducto();
            fila[6] = item.getColorProducto();
            fila[7] = item.getCostoProducto();
            fila[8] = item.getEstadoProducto();
            modelo.addRow(fila);
        }
    }

    //JtbListarProductosMovimientos
    private void ListarProductosMovimientos() {
        DefaultTableModel modelo = new DefaultTableModel();
        JtbListarProductosMovimientos.setModel(modelo);
        modelo.addColumn("Numero Activo");
        modelo.addColumn("Numero Serie");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("Tipo Producto");
        modelo.addColumn("Fecha Llegada");
        modelo.addColumn("Color");
        modelo.addColumn("Costo");
        modelo.addColumn("Estado");
        SimpleDateFormat fmto = new SimpleDateFormat("DD/MM/YYYY");
        ArrayList<Producto> listado = new DaoProducto().Listar();
        for (Producto item : listado) {
            Object[] fila = new Object[9];
            fila[0] = item.getNumActivoProducto();
            fila[1] = item.getNumSerieProducto();
            fila[2] = item.getDescProducto();
            fila[3] = item.getUbicacionProducto();
            fila[4] = item.getTipoProducto();
            fila[5] = fmto.format(item.getFechaLlegadaProducto());
            fila[6] = item.getColorProducto();
            fila[7] = item.getCostoProducto();
            fila[8] = item.getEstadoProducto();
            modelo.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnMnuProductos = new javax.swing.JTabbedPane();
        JpHome = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtbListarProductosHome = new javax.swing.JTable();
        label1 = new java.awt.Label();
        label45 = new java.awt.Label();
        txtNumeroActivoHome = new javax.swing.JTextField();
        txtNnumeroDeSerieHome = new javax.swing.JTextField();
        label54 = new java.awt.Label();
        label55 = new java.awt.Label();
        txtDescripcionProductoHome = new javax.swing.JTextField();
        cboTipoProductoHome = new javax.swing.JComboBox<>();
        label56 = new java.awt.Label();
        label57 = new java.awt.Label();
        cboUbicacionProductoHome = new javax.swing.JComboBox<>();
        txtcontNetoProductoHome = new javax.swing.JTextField();
        label58 = new java.awt.Label();
        label59 = new java.awt.Label();
        cboEstadoProductoHome = new javax.swing.JComboBox<>();
        txtStockHome = new javax.swing.JTextField();
        label60 = new java.awt.Label();
        label61 = new java.awt.Label();
        JdcFechaLlegadaHome = new com.toedter.calendar.JDateChooser();
        txtUltimaActualizacionProducto1 = new javax.swing.JTextField();
        label62 = new java.awt.Label();
        txtCostoHome = new javax.swing.JTextField();
        txtColorProductoHome = new javax.swing.JTextField();
        label63 = new java.awt.Label();
        label64 = new java.awt.Label();
        JpCuentas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtbListarPersonas = new javax.swing.JTable();
        txtIdEmpleado = new javax.swing.JTextField();
        txtRunEmpleado = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefonoEmpleado = new javax.swing.JTextField();
        txtDireccionEmpleado = new javax.swing.JTextField();
        cboJornadaEmpleado = new javax.swing.JComboBox<>();
        cboSupervisorEmpleado = new javax.swing.JComboBox<>();
        cboCargoEmpleado = new javax.swing.JComboBox<>();
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
        jPanel3 = new javax.swing.JPanel();
        btnBuscarEmpleado = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtFiltroRunEmpleado = new javax.swing.JTextField();
        JpProductos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JtbListarProductosProductos = new javax.swing.JTable();
        txtNumeroDeActivoProducto = new javax.swing.JTextField();
        txtNumeroDeSerieProducto = new javax.swing.JTextField();
        txtDescripcionProductoProducto = new javax.swing.JTextField();
        cboTipoProductoProducto = new javax.swing.JComboBox<>();
        txtUltimaActualizacionProductoProducto = new javax.swing.JTextField();
        txtStockProductoProducto = new javax.swing.JTextField();
        cboEstadoProductoProducto = new javax.swing.JComboBox<>();
        txtColorProductoProducto = new javax.swing.JTextField();
        txtcontNetoProductoProducto = new javax.swing.JTextField();
        txtCostoProductoProducto = new javax.swing.JTextField();
        label40 = new java.awt.Label();
        label41 = new java.awt.Label();
        label42 = new java.awt.Label();
        label43 = new java.awt.Label();
        label44 = new java.awt.Label();
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
        JdcFechaLlegadaProductoProducto = new com.toedter.calendar.JDateChooser();
        btnCancelarProducto = new java.awt.Button();
        label53 = new java.awt.Label();
        cboUbicacionProductoProducto = new javax.swing.JComboBox<>();
        btnGuardarProducto = new java.awt.Button();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtFiltroActivoProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
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
        setForeground(java.awt.Color.orange);
        setIconImage(getIconImage());
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        BtnMnuProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnMnuProductos.setToolTipText("");
        BtnMnuProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnMnuProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnMnuProductosMouseEntered(evt);
            }
        });

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
        JtbListarProductosHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtbListarProductosHomeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JtbListarProductosHome);

        label1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        label1.setText("Detalle del Producto");

        label45.setText("Numero de Activo");

        txtNumeroActivoHome.setEnabled(false);
        txtNumeroActivoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActivoHomeActionPerformed(evt);
            }
        });

        txtNnumeroDeSerieHome.setEnabled(false);
        txtNnumeroDeSerieHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNnumeroDeSerieHomeActionPerformed(evt);
            }
        });

        label54.setText("Numero de Serie");

        label55.setText("Descripcion");

        txtDescripcionProductoHome.setEnabled(false);
        txtDescripcionProductoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionProductoHomeActionPerformed(evt);
            }
        });

        cboTipoProductoHome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTipoProductoHome.setEnabled(false);

        label56.setText("Tipo de Producto");

        label57.setText("Ubicacion");

        cboUbicacionProductoHome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboUbicacionProductoHome.setEnabled(false);

        txtcontNetoProductoHome.setEnabled(false);
        txtcontNetoProductoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontNetoProductoHomeActionPerformed(evt);
            }
        });

        label58.setText("Unidades/Lts");

        label59.setText("Estado");

        cboEstadoProductoHome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboEstadoProductoHome.setEnabled(false);

        txtStockHome.setEnabled(false);
        txtStockHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockHomeActionPerformed(evt);
            }
        });

        label60.setText("Stock");

        label61.setText("Fecha Llegada");

        JdcFechaLlegadaHome.setEnabled(false);

        txtUltimaActualizacionProducto1.setEnabled(false);
        txtUltimaActualizacionProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUltimaActualizacionProducto1ActionPerformed(evt);
            }
        });

        label62.setText("Ultima Actualización");

        txtCostoHome.setEnabled(false);
        txtCostoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoHomeActionPerformed(evt);
            }
        });

        txtColorProductoHome.setEnabled(false);
        txtColorProductoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorProductoHomeActionPerformed(evt);
            }
        });

        label63.setText("Color");

        label64.setText("Costo");

        javax.swing.GroupLayout JpHomeLayout = new javax.swing.GroupLayout(JpHome);
        JpHome.setLayout(JpHomeLayout);
        JpHomeLayout.setHorizontalGroup(
            JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpHomeLayout.createSequentialGroup()
                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpHomeLayout.createSequentialGroup()
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(label45, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label56, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label57, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cboUbicacionProductoHome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumeroActivoHome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcionProductoHome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNnumeroDeSerieHome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTipoProductoHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(189, 189, 189)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpHomeLayout.createSequentialGroup()
                                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label59, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUltimaActualizacionProducto1)
                                    .addComponent(txtStockHome)
                                    .addComponent(cboEstadoProductoHome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JdcFechaLlegadaHome, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(JpHomeLayout.createSequentialGroup()
                                .addComponent(label58, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(txtcontNetoProductoHome, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label63, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label64, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCostoHome)
                            .addComponent(txtColorProductoHome, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1345, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JpHomeLayout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JpHomeLayout.setVerticalGroup(
            JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpHomeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(JpHomeLayout.createSequentialGroup()
                            .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNumeroActivoHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(label54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNnumeroDeSerieHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(16, 16, 16)
                            .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(label55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDescripcionProductoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addComponent(label56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cboTipoProductoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpHomeLayout.createSequentialGroup()
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpHomeLayout.createSequentialGroup()
                                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUltimaActualizacionProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JdcFechaLlegadaHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(JpHomeLayout.createSequentialGroup()
                                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCostoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtColorProductoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label60, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboEstadoProductoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboUbicacionProductoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcontNetoProductoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        BtnMnuProductos.addTab("Home  ", new javax.swing.ImageIcon(getClass().getResource("/Img/home.png")), JpHome); // NOI18N
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

        txtTelefonoEmpleado.setEnabled(false);
        txtTelefonoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoEmpleadoActionPerformed(evt);
            }
        });

        txtDireccionEmpleado.setEnabled(false);
        txtDireccionEmpleado.setMaximumSize(new java.awt.Dimension(300, 22));
        txtDireccionEmpleado.setMinimumSize(new java.awt.Dimension(300, 22));
        txtDireccionEmpleado.setPreferredSize(new java.awt.Dimension(300, 22));
        txtDireccionEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionEmpleadoActionPerformed(evt);
            }
        });

        cboJornadaEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboJornadaEmpleado.setEnabled(false);

        cboSupervisorEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboSupervisorEmpleado.setEnabled(false);
        cboSupervisorEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSupervisorEmpleadoActionPerformed(evt);
            }
        });

        cboCargoEmpleado.setEnabled(false);
        cboCargoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCargoEmpleadoActionPerformed(evt);
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

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnBuscarEmpleado.setText("Buscar");
        btnBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoActionPerformed(evt);
            }
        });

        jLabel5.setText("INGRESE RUT");

        jLabel4.setText("BUSCAR EMPLEADO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBuscarEmpleado)
                .addGap(113, 113, 113))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(TxtFiltroRunEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel4)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(TxtFiltroRunEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnBuscarEmpleado)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JpCuentasLayout = new javax.swing.GroupLayout(JpCuentas);
        JpCuentas.setLayout(JpCuentasLayout);
        JpCuentasLayout.setHorizontalGroup(
            JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpCuentasLayout.createSequentialGroup()
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpCuentasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(JpCuentasLayout.createSequentialGroup()
                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                            .addComponent(label17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(120, 120, 120)
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRunEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTelefonoEmpleado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDireccionEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboJornadaEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JdcFechaLlegadaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(cboSupervisorEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboCargoEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(74, 74, 74)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        JpCuentasLayout.setVerticalGroup(
            JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpCuentasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpCuentasLayout.createSequentialGroup()
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
                                        .addComponent(txtTelefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDireccionEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(JpCuentasLayout.createSequentialGroup()
                                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboJornadaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JdcFechaLlegadaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboSupervisorEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboCargoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(JpCuentasLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        BtnMnuProductos.addTab("Cuentas  ", new javax.swing.ImageIcon(getClass().getResource("/Img/user.png")), JpCuentas); // NOI18N

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
        JtbListarProductosProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtbListarProductosProductosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(JtbListarProductosProductos);

        txtNumeroDeActivoProducto.setEnabled(false);
        txtNumeroDeActivoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDeActivoProductoActionPerformed(evt);
            }
        });

        txtNumeroDeSerieProducto.setEnabled(false);
        txtNumeroDeSerieProducto.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtNumeroDeSerieProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDeSerieProductoActionPerformed(evt);
            }
        });

        txtDescripcionProductoProducto.setEnabled(false);
        txtDescripcionProductoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionProductoProductoActionPerformed(evt);
            }
        });

        cboTipoProductoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTipoProductoProducto.setEnabled(false);

        txtUltimaActualizacionProductoProducto.setEnabled(false);
        txtUltimaActualizacionProductoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUltimaActualizacionProductoProductoActionPerformed(evt);
            }
        });

        txtStockProductoProducto.setEnabled(false);
        txtStockProductoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockProductoProductoActionPerformed(evt);
            }
        });

        cboEstadoProductoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboEstadoProductoProducto.setEnabled(false);

        txtColorProductoProducto.setEnabled(false);
        txtColorProductoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorProductoProductoActionPerformed(evt);
            }
        });

        txtcontNetoProductoProducto.setEnabled(false);
        txtcontNetoProductoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontNetoProductoProductoActionPerformed(evt);
            }
        });

        txtCostoProductoProducto.setEnabled(false);
        txtCostoProductoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoProductoProductoActionPerformed(evt);
            }
        });

        label40.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        label40.setText("Detalle del Producto");

        label41.setText("Numero de Serie");

        label42.setText("Numero de Activo");

        label43.setText("Descripcion");

        label44.setText("Tipo de Producto");

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
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        JdcFechaLlegadaProductoProducto.setEnabled(false);

        btnCancelarProducto.setActionCommand("Cancelar");
        btnCancelarProducto.setEnabled(false);
        btnCancelarProducto.setLabel("Cancelar");
        btnCancelarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarProductoMouseClicked(evt);
            }
        });

        label53.setText("Ubicacion");

        cboUbicacionProductoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboUbicacionProductoProducto.setEnabled(false);

        btnGuardarProducto.setActionCommand("Guardar");
        btnGuardarProducto.setEnabled(false);
        btnGuardarProducto.setLabel("Guardar");
        btnGuardarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarProductoMouseClicked(evt);
            }
        });
        btnGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProductoActionPerformed(evt);
            }
        });

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setText("BUSCAR PRODUCTO");

        jLabel7.setText("INGRESE NUMERO DE ACTIVO");

        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtFiltroActivoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel6)))
                .addGap(34, 34, 34))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(btnBuscarProducto))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(TxtFiltroActivoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnBuscarProducto)
                .addContainerGap(55, Short.MAX_VALUE))
        );

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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JpProductosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addGroup(JpProductosLayout.createSequentialGroup()
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label42, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label41, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                        .addComponent(label43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(label53, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cboUbicacionProductoProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNumeroDeActivoProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(txtDescripcionProductoProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(txtNumeroDeSerieProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(cboTipoProductoProducto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(22, 22, 22)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(JpProductosLayout.createSequentialGroup()
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label49, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(17, 17, 17)
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtUltimaActualizacionProductoProducto)
                                            .addComponent(txtStockProductoProducto)
                                            .addComponent(cboEstadoProductoProducto, 0, 172, Short.MAX_VALUE)
                                            .addComponent(JdcFechaLlegadaProductoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(JpProductosLayout.createSequentialGroup()
                                        .addComponent(label51, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(txtcontNetoProductoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(44, 44, 44)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(JpProductosLayout.createSequentialGroup()
                                        .addComponent(btnGuardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(JpProductosLayout.createSequentialGroup()
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(JpProductosLayout.createSequentialGroup()
                                                .addComponent(label50, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpProductosLayout.createSequentialGroup()
                                                .addComponent(label52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)))
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtColorProductoProducto)
                                            .addComponent(txtCostoProductoProducto))))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
                    .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpProductosLayout.createSequentialGroup()
                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUltimaActualizacionProductoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JdcFechaLlegadaProductoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpProductosLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStockProductoProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboEstadoProductoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(JpProductosLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGuardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(92, 92, 92))
                    .addGroup(JpProductosLayout.createSequentialGroup()
                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCostoProductoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtColorProductoProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(174, 174, 174))
                    .addGroup(JpProductosLayout.createSequentialGroup()
                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JpProductosLayout.createSequentialGroup()
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(JpProductosLayout.createSequentialGroup()
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNumeroDeActivoProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNumeroDeSerieProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(16, 16, 16)
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDescripcionProductoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addComponent(label44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cboTipoProductoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboUbicacionProductoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcontNetoProductoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        BtnMnuProductos.addTab("Productos  ", new javax.swing.ImageIcon(getClass().getResource("/Img/box.png")), JpProductos); // NOI18N

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
                .addContainerGap(67, Short.MAX_VALUE))
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
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
        );

        BtnMnuProductos.addTab("Informes  ", new javax.swing.ImageIcon(getClass().getResource("/Img/paper.png")), JpInformes); // NOI18N

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
                        .addGap(0, 453, Short.MAX_VALUE)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnMnuProductos.addTab("Movimientos  ", new javax.swing.ImageIcon(getClass().getResource("/Img/arrows.png")), JpMovimientos); // NOI18N

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
                .addComponent(BtnMnuProductos)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnMnuProductos)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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

    private void txtNumeroDeActivoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDeActivoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDeActivoProductoActionPerformed

    private void txtDescripcionProductoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionProductoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionProductoProductoActionPerformed

    private void txtNumeroDeSerieProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDeSerieProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDeSerieProductoActionPerformed

    private void txtUltimaActualizacionProductoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUltimaActualizacionProductoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUltimaActualizacionProductoProductoActionPerformed

    private void txtStockProductoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockProductoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockProductoProductoActionPerformed

    private void txtColorProductoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorProductoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorProductoProductoActionPerformed

    private void txtcontNetoProductoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontNetoProductoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontNetoProductoProductoActionPerformed

    private void txtCostoProductoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoProductoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoProductoProductoActionPerformed

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
        btnGuardarProducto.setEnabled(true);
        btnBuscarProducto.setEnabled(false);
        txtNumeroDeActivoProducto.setEnabled(true);
        txtNumeroDeSerieProducto.setEnabled(true);
        txtDescripcionProductoProducto.setEnabled(true);
        cboTipoProductoProducto.setEnabled(true);
        JdcFechaLlegadaProductoProducto.setEnabled(true);
        cboEstadoProductoProducto.setEnabled(true);
        txtColorProductoProducto.setEnabled(true);
        txtcontNetoProductoProducto.setEnabled(true);
        txtCostoProductoProducto.setEnabled(true);
        cboUbicacionProductoProducto.setEnabled(true);

        txtNumeroDeActivoProducto.setText("");
        txtNumeroDeSerieProducto.setText("");
        txtDescripcionProductoProducto.setText("");
        txtStockProductoProducto.setText("");
        txtColorProductoProducto.setText("");
        txtcontNetoProductoProducto.setText("");
        txtCostoProductoProducto.setText("");
        cboTipoProductoProducto.setSelectedItem("-- Seleccione --");
        cboEstadoProductoProducto.setSelectedItem("-- Seleccione --");
        cboUbicacionProductoProducto.setSelectedItem("-- Seleccione --");


    }//GEN-LAST:event_btnCrearProductoActionPerformed

    private void JpProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JpProductosMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_JpProductosMouseExited

    private void JpProductosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JpProductosPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_JpProductosPropertyChange

    private void btnCancelarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarProductoMouseClicked
        btnCancelarProducto.setEnabled(false);
        btnGuardarProducto.setEnabled(false);
        txtNumeroDeActivoProducto.setEnabled(false);
        txtNumeroDeSerieProducto.setEnabled(false);
        txtDescripcionProductoProducto.setEnabled(false);
        cboTipoProductoProducto.setEnabled(false);
        JdcFechaLlegadaProductoProducto.setEnabled(false);
        txtStockProductoProducto.setEnabled(false);
        cboEstadoProductoProducto.setEnabled(false);
        txtColorProductoProducto.setEnabled(false);
        txtcontNetoProductoProducto.setEnabled(false);
        txtCostoProductoProducto.setEnabled(false);
        cboUbicacionProductoProducto.setEnabled(false);

        txtNumeroDeActivoProducto.setText("");
        txtNumeroDeSerieProducto.setText("");
        txtDescripcionProductoProducto.setText("");
        txtStockProductoProducto.setText("");
        txtColorProductoProducto.setText("");
        txtcontNetoProductoProducto.setText("");
        txtCostoProductoProducto.setText("");
        cboTipoProductoProducto.setSelectedItem("-- Seleccione --");
        cboEstadoProductoProducto.setSelectedItem("-- Seleccione --");
        cboUbicacionProductoProducto.setSelectedItem("-- Seleccione --");
        btnBuscarProducto.setEnabled(true);
    }//GEN-LAST:event_btnCancelarProductoMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked

    }//GEN-LAST:event_jMenu1MouseClicked

    private void mnuCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_mnuCerrarMouseClicked

    private void mnuCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mnuCerrarActionPerformed

    private void BtnMnuProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMnuProductosMouseClicked
    }//GEN-LAST:event_BtnMnuProductosMouseClicked

    private void btnCancelarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarUsuarioMouseClicked
        // TODO add your handling code here:
        txtRunEmpleado.setEnabled(false);
        txtNombre.setEnabled(false);
        txtTelefonoEmpleado.setEnabled(false);
        txtDireccionEmpleado.setEnabled(false);
        cboJornadaEmpleado.setEnabled(false);
        JdcFechaLlegadaUsuario.setEnabled(false);
        cboSupervisorEmpleado.setEnabled(false);
        cboCargoEmpleado.setEnabled(false);

        txtRunEmpleado.setText("");
        txtNombre.setText("");
        txtTelefonoEmpleado.setText("");
        txtDireccionEmpleado.setText("");
        JdcFechaLlegadaUsuario.setEnabled(false);
        cboJornadaEmpleado.setEnabled(false);
        cboCargoEmpleado.setEnabled(false);
        cboJornadaEmpleado.setSelectedItem("-- Seleccione --");
        cboSupervisorEmpleado.setSelectedItem("-- Seleccione --");
        cboCargoEmpleado.setSelectedItem("-- Seleccione --");
        btnCancelarUsuario.setEnabled(false);
        btnBuscarEmpleado.setEnabled(true);
    }//GEN-LAST:event_btnCancelarUsuarioMouseClicked
    // TODO add your handling code here:
    // TODO add your handling code here:


    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        btnBuscarEmpleado.setEnabled(false);
        btnCancelarUsuario.setEnabled(true);
        txtRunEmpleado.setEnabled(true);
        txtNombre.setEnabled(true);
        txtTelefonoEmpleado.setEnabled(true);
        txtDireccionEmpleado.setEnabled(true);
        cboJornadaEmpleado.setEnabled(true);
        JdcFechaLlegadaUsuario.setEnabled(true);
        cboSupervisorEmpleado.setEnabled(true);
        cboCargoEmpleado.setEnabled(true);

        txtRunEmpleado.setText("");
        txtNombre.setText("");
        txtTelefonoEmpleado.setText("");
        txtDireccionEmpleado.setText("");
        cboJornadaEmpleado.setSelectedItem("-- Seleccione --");
        cboSupervisorEmpleado.setSelectedItem("-- Seleccione --");
        cboCargoEmpleado.setSelectedItem("-- Seleccione --");
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void cboCargoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCargoEmpleadoActionPerformed

    }//GEN-LAST:event_cboCargoEmpleadoActionPerformed

    private void cboSupervisorEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSupervisorEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSupervisorEmpleadoActionPerformed

    private void txtDireccionEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionEmpleadoActionPerformed

    private void txtTelefonoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoEmpleadoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtRunEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRunEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRunEmpleadoActionPerformed

    private void txtIdEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEmpleadoActionPerformed

    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        String run = TxtFiltroRunEmpleado.getText();
        Empleado emp = new DaoEmpleado().Buscar2(run);
        if (emp != null) {
            JOptionPane.showMessageDialog(null, "Existe Empleado");
            txtIdEmpleado.setText("" + emp.getIdEmpleado());
            txtRunEmpleado.setText(emp.getRutEmpleado());
            txtNombre.setText(emp.getNombreEmpleado());
            txtTelefonoEmpleado.setText(emp.getTelefonoEmpleado());
            txtDireccionEmpleado.setText(emp.getDireccionEmpleado());
        } else {
            JOptionPane.showMessageDialog(null, "No Existe Empleado");
        }
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void BtnMnuProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMnuProductosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnMnuProductosMouseEntered

    private void JtbListarProductosHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtbListarProductosHomeMouseClicked
        int fila = JtbListarProductosHome.getSelectedRow();
        int activo = Integer.parseInt(JtbListarProductosHome.getValueAt(fila, 0).toString());
        Producto prod = new DaoProducto().Buscar2(activo);
        if (prod != null) {
            txtNumeroActivoHome.setText("" + prod.getNumActivoProducto());
            txtNnumeroDeSerieHome.setText("" + prod.getNumSerieProducto());
            txtDescripcionProductoHome.setText(prod.getDescProducto());
            cboTipoProductoHome.setSelectedItem(prod.getTipoProducto().toString());
            cboUbicacionProductoHome.setSelectedItem(prod.getUbicacionProducto().toString());
            cboEstadoProductoHome.setSelectedItem(prod.getEstadoProducto().toString());
            txtColorProductoHome.setText(prod.getColorProducto());
            txtCostoHome.setText("" + prod.getCostoProducto());
            txtcontNetoProductoHome.setText("" + prod.getCostoProducto());
            JdcFechaLlegadaHome.setDate(prod.getFechaLlegadaProducto());
            
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
        String tipo = JtbListarProductosHome.getValueAt(fila, 4).toString();
        Producto prod1 = new DaoProducto().Buscar3(tipo);
        if (prod != null) {
            txtStockHome.setText("" + prod1.getStockProducto());
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_JtbListarProductosHomeMouseClicked

    private void txtNumeroActivoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActivoHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActivoHomeActionPerformed

    private void txtNnumeroDeSerieHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNnumeroDeSerieHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNnumeroDeSerieHomeActionPerformed

    private void txtDescripcionProductoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionProductoHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionProductoHomeActionPerformed

    private void txtcontNetoProductoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontNetoProductoHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontNetoProductoHomeActionPerformed

    private void txtStockHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockHomeActionPerformed

    private void txtUltimaActualizacionProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUltimaActualizacionProducto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUltimaActualizacionProducto1ActionPerformed

    private void txtCostoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoHomeActionPerformed

    private void txtColorProductoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorProductoHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorProductoHomeActionPerformed

    private void JtbListarProductosProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtbListarProductosProductosMouseClicked
        int fila = JtbListarProductosProductos.getSelectedRow();
        int activo = Integer.parseInt(JtbListarProductosProductos.getValueAt(fila, 0).toString());
        Producto prod = new DaoProducto().Buscar2(activo);
        if (prod != null) {
            txtNumeroDeActivoProducto.setText("" + prod.getNumActivoProducto());
            txtNumeroDeSerieProducto.setText("" + prod.getNumSerieProducto());
            txtDescripcionProductoProducto.setText(prod.getDescProducto());
            cboTipoProductoProducto.setSelectedItem(prod.getTipoProducto().toString());
            cboUbicacionProductoProducto.setSelectedItem(prod.getUbicacionProducto().toString());
            cboEstadoProductoProducto.setSelectedItem(prod.getEstadoProducto().toString());
            txtColorProductoProducto.setText(prod.getColorProducto());
            txtCostoProductoProducto.setText("" + prod.getCostoProducto());
            txtcontNetoProductoProducto.setText("" + prod.getCostoProducto());
            JdcFechaLlegadaProductoProducto.setDate(prod.getFechaLlegadaProducto());
            
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
        String tipo = JtbListarProductosProductos.getValueAt(fila, 4).toString();
        Producto prod1 = new DaoProducto().Buscar3(tipo);
        if (prod != null) {
            txtStockProductoProducto.setText("" + prod1.getStockProducto());
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_JtbListarProductosProductosMouseClicked

    private void btnGuardarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarProductoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarProductoMouseClicked

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        int numAct = Integer.parseInt(TxtFiltroActivoProducto.getText());
        Producto prod = new DaoProducto().Buscar2(numAct);
        if (prod != null) {
            JOptionPane.showMessageDialog(null, "Existe Producto");
            txtNumeroDeActivoProducto.setText("" + prod.getNumActivoProducto());
            txtNumeroDeSerieProducto.setText("" + prod.getNumSerieProducto());
            txtDescripcionProductoProducto.setText(prod.getDescProducto());
            cboTipoProductoProducto.setSelectedItem(prod.getTipoProducto().toString());
            cboUbicacionProductoProducto.setSelectedItem(prod.getUbicacionProducto().toString());
            cboEstadoProductoProducto.setSelectedItem(prod.getEstadoProducto().toString());
            txtColorProductoProducto.setText(prod.getColorProducto());
            txtCostoProductoProducto.setText("" + prod.getCostoProducto());
            txtcontNetoProductoProducto.setText("" + prod.getCostoProducto());
            JdcFechaLlegadaProductoProducto.setDate(prod.getFechaLlegadaProducto());
        } else {
            JOptionPane.showMessageDialog(null, "No Existe Producto");
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProductoActionPerformed
        try {
            int idProducto = 0;
            int NumActivoProducto = Integer.parseInt(txtNumeroDeActivoProducto.getText());
            int NumSerieProducto = Integer.parseInt(txtNumeroDeSerieProducto.getText());
            String DescProducto = txtDescripcionProductoProducto.getText();
            Ubicacion ubicacion = new DaoUbicacion().Buscar2(cboUbicacionProductoProducto.getSelectedItem().toString());
            TipoProducto tpProd = new DaoTipoProducto().Buscar2(cboTipoProductoProducto.getSelectedItem().toString());
            Empleado actualizacion = new DaoEmpleado().Buscar2("11.111.111-1");
            Date fecha = JdcFechaLlegadaProductoProducto.getDate();
            String colorProducto = txtColorProductoProducto.getText();
            int costoProducto = Integer.parseInt(txtCostoProductoProducto.getText());
            Estado estado = new DaoEstado().Buscar2(cboEstadoProductoProducto.getSelectedItem().toString());
            int litros = Integer.parseInt(txtcontNetoProductoProducto.getText());
            Producto producto = new Producto(idProducto, NumActivoProducto, NumSerieProducto, DescProducto, tpProd, actualizacion, fecha, costoProducto, estado, ubicacion, colorProducto, costoProducto, costoProducto);
            boolean resp = new DaoProducto().Grabar(producto);
            if (resp) {
                JOptionPane.showMessageDialog(null, "Grabo");
                ListarProductosProductos();
                ResetProducto();
            }else{
                JOptionPane.showMessageDialog(null, "Grabo");
            }
            }
        catch (Exception e) {
            System.out.println("Error grabar Producto:"+e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo grabar");
        }
    }//GEN-LAST:event_btnGuardarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        int numAct = Integer.parseInt(txtNumeroDeActivoProducto.getText());
        DaoProducto dao = new DaoProducto();
        boolean resp = dao.Eliminar(numAct);
        if (resp == true) {
            JOptionPane.showMessageDialog(null, "Elimino");
            ListarProductosProductos();
        } else {
            JOptionPane.showMessageDialog(null, "No Elimino");
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnCrearUsuarioActionPerformed() {
        // TODO add your handling code here:

    }

    private void ResetProducto(){
        btnCancelarProducto.setEnabled(false);
        btnGuardarProducto.setEnabled(false);
        txtNumeroDeActivoProducto.setEnabled(false);
        txtNumeroDeSerieProducto.setEnabled(false);
        txtDescripcionProductoProducto.setEnabled(false);
        cboTipoProductoProducto.setEnabled(false);
        JdcFechaLlegadaProductoProducto.setEnabled(false);
        txtStockProductoProducto.setEnabled(false);
        cboEstadoProductoProducto.setEnabled(false);
        txtColorProductoProducto.setEnabled(false);
        txtcontNetoProductoProducto.setEnabled(false);
        txtCostoProductoProducto.setEnabled(false);
        cboUbicacionProductoProducto.setEnabled(false);

        txtNumeroDeActivoProducto.setText("");
        txtNumeroDeSerieProducto.setText("");
        txtDescripcionProductoProducto.setText("");
        txtStockProductoProducto.setText("");
        txtColorProductoProducto.setText("");
        txtcontNetoProductoProducto.setText("");
        txtCostoProductoProducto.setText("");
        cboTipoProductoProducto.setSelectedItem("-- Seleccione --");
        cboEstadoProductoProducto.setSelectedItem("-- Seleccione --");
        cboUbicacionProductoProducto.setSelectedItem("-- Seleccione --");
        btnBuscarProducto.setEnabled(true);
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
    private javax.swing.JTabbedPane BtnMnuProductos;
    private javax.swing.JComboBox<String> CboFiltroProductoInforme;
    private javax.swing.JComboBox<String> CboSeleccionBodegaInforme;
    private javax.swing.JTable JTblListarProductosInformes;
    private javax.swing.JComboBox<String> JcbUbicacionDestino;
    private javax.swing.JComboBox<String> JcbUbicacioninicio;
    private com.toedter.calendar.JDateChooser JdcFechaLlegadaHome;
    private com.toedter.calendar.JDateChooser JdcFechaLlegadaMovimiento;
    private com.toedter.calendar.JDateChooser JdcFechaLlegadaProductoProducto;
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
    private javax.swing.JTextField TxtFiltroActivoProducto;
    private javax.swing.JTextField TxtFiltroRunEmpleado;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnBuscarProducto;
    private java.awt.Button btnCancelarProducto;
    private java.awt.Button btnCancelarUsuario;
    private java.awt.Button btnCrearProducto;
    private java.awt.Button btnCrearUsuario;
    private java.awt.Button btnEliminarProducto;
    private java.awt.Button btnEliminarUsuario;
    private java.awt.Button btnGuardarProducto;
    private java.awt.Button btnModificarProducto;
    private java.awt.Button btnModificarUsuario;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JComboBox<String> cboCargoEmpleado;
    private javax.swing.JComboBox<String> cboEstadoProductoHome;
    private javax.swing.JComboBox<String> cboEstadoProductoProducto;
    private javax.swing.JComboBox<String> cboJornadaEmpleado;
    private javax.swing.JComboBox<String> cboSupervisorEmpleado;
    private javax.swing.JComboBox<String> cboTipoProductoHome;
    private javax.swing.JComboBox<String> cboTipoProductoProducto;
    private javax.swing.JComboBox<String> cboUbicacionProductoHome;
    private javax.swing.JComboBox<String> cboUbicacionProductoProducto;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private java.awt.Label label15;
    private java.awt.Label label16;
    private java.awt.Label label17;
    private java.awt.Label label18;
    private java.awt.Label label19;
    private java.awt.Label label20;
    private java.awt.Label label21;
    private java.awt.Label label22;
    private java.awt.Label label23;
    private java.awt.Label label27;
    private java.awt.Label label28;
    private java.awt.Label label29;
    private java.awt.Label label30;
    private java.awt.Label label31;
    private java.awt.Label label32;
    private java.awt.Label label33;
    private java.awt.Label label34;
    private java.awt.Label label35;
    private java.awt.Label label36;
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
    private java.awt.Label label50;
    private java.awt.Label label51;
    private java.awt.Label label52;
    private java.awt.Label label53;
    private java.awt.Label label54;
    private java.awt.Label label55;
    private java.awt.Label label56;
    private java.awt.Label label57;
    private java.awt.Label label58;
    private java.awt.Label label59;
    private java.awt.Label label6;
    private java.awt.Label label60;
    private java.awt.Label label61;
    private java.awt.Label label62;
    private java.awt.Label label63;
    private java.awt.Label label64;
    private javax.swing.JMenuItem mnuCerrar;
    private javax.swing.JTextField txtColorProductoHome;
    private javax.swing.JTextField txtColorProductoProducto;
    private javax.swing.JTextField txtCostoHome;
    private javax.swing.JTextField txtCostoProductoProducto;
    private javax.swing.JTextField txtDescripcion2;
    private javax.swing.JTextField txtDescripcionProductoHome;
    private javax.swing.JTextField txtDescripcionProductoProducto;
    private javax.swing.JTextField txtDireccionEmpleado;
    private javax.swing.JTextField txtFechaAsignacion2;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtNnumeroDeSerie2;
    private javax.swing.JTextField txtNnumeroDeSerieHome;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroActivo2;
    private javax.swing.JTextField txtNumeroActivoHome;
    private javax.swing.JTextField txtNumeroDeActivoProducto;
    private javax.swing.JTextField txtNumeroDeSerieProducto;
    private javax.swing.JTextField txtRunEmpleado;
    private javax.swing.JTextField txtStockHome;
    private javax.swing.JTextField txtStockProductoProducto;
    private javax.swing.JTextField txtTelefonoEmpleado;
    private javax.swing.JTextField txtUltimaActializacion2;
    private javax.swing.JTextField txtUltimaActualizacionProducto1;
    private javax.swing.JTextField txtUltimaActualizacionProductoProducto;
    private javax.swing.JTextField txtcontNetoProductoHome;
    private javax.swing.JTextField txtcontNetoProductoProducto;
    // End of variables declaration//GEN-END:variables
}
