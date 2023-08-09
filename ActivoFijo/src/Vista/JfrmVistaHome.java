package Vista;

import Controlador.DaoColor;
import Controlador.DaoEmpleado;
import Controlador.DaoEstado;
import Controlador.DaoJornada;
import Controlador.DaoMovimiento;
import Controlador.DaoProducto;
import Controlador.DaoTipoEmpleado;
import Controlador.DaoTipoProducto;
import Controlador.DaoTipoMovimiento;
import Controlador.DaoUbicacion;
import Modelo.Color;
import Modelo.Empleado;
import Modelo.Estado;
import Modelo.TipoEmpleado;
import Modelo.Jornada;
import Modelo.Movimiento;
import Modelo.Producto;
import Modelo.TipoProducto;
import Modelo.TipoMovimiento;
import Modelo.Ubicacion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
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
        //setExtendedState(MAXIMIZED_BOTH);
        //set programa en la mitad de la pantalla
        setLocationRelativeTo(null);
        //CARGA DE CBO APENAS INICIE EL PROGRAMA
        ListarCboCargo();
        ListarCboJornada();
        ListarCboEstadoProducto();
        ListarCboUbicacion();
        ListarCboTipoProducto();
        ListarCboColorHome();
        ListarCboColorProducto();
        ListarCboSeleccionBodegaInforme();
        ListarCboFiltroProductoInforme();
        ListarEmpleados();
        ListarProductosHome();
        ListarProductosProductos();
        ListarProductosInformes();
        ListarProductosMovimientos();
        ListarcboTipoProductoHome();
        ListarcboUbicacionProductoHome();
        ListarcboEstadoProductoHome();
        ListarSupervisores();

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
        cboCargoEmpleadoHome.addItem("-- Seleccione --");
        cboSupervisorEmpleadoHome.addItem("No aplica");
        for (TipoEmpleado tpEmp : new DaoTipoEmpleado().Listar()) {
            cboCargoEmpleadoHome.addItem(tpEmp.getDescripcionTipoEmpleado());
        }
    }

    private void ListarSupervisores() {
        cboSupervisorEmpleadoHome.removeAllItems();
        cboSupervisorEmpleadoHome.addItem("-- Seleccione --");
        cboSupervisorEmpleadoHome.addItem("NO APLICA");
        for (Empleado Emp : new DaoEmpleado().Listar2()) {
            cboSupervisorEmpleadoHome.addItem(Emp.getNombreEmpleado());
        }
    }

    private void ListarCboJornada() {
        cboJornadaEmpleadoHome.removeAllItems();
        cboJornadaEmpleadoHome.addItem("-- Seleccione --");
        for (Jornada jorn : new DaoJornada().Listar()) {
            cboJornadaEmpleadoHome.addItem(jorn.getDescripcionJornada());
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

    private void ListarCboColorHome() {
        cboColorHome.removeAllItems();
        cboColorHome.addItem("-- Seleccione --");
        for (Color col : new DaoColor().Listar()) {
            cboColorHome.addItem(col.getNombreColor());
        }
    }

    private void ListarCboColorProducto() {
        cboColorProducto.removeAllItems();
        cboColorProducto.addItem("-- Seleccione --");
        for (Color col : new DaoColor().Listar()) {
            cboColorProducto.addItem(col.getNombreColor());
        }
    }

    public DefaultTableModel getProductTableModel() {
        DefaultTableModel productTableModel = new DefaultTableModel();
        // Agrega los productos al modelo
        // ...
        return productTableModel;
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
        modelo.addColumn("Supervisor");
        ArrayList<Empleado> listado = new DaoEmpleado().Listar();
        for (Empleado item : listado) {
            Object[] fila = new Object[7];
            fila[0] = item.getRutEmpleado();
            fila[1] = item.getNombreEmpleado();
            fila[2] = item.getTelefonoEmpleado();
            fila[3] = item.getDireccionEmpleado();
            fila[4] = item.getCargoEmpleado();
            fila[5] = item.getJornadaEmpleado();
            fila[6] = item.getNombre_supervisor();
            modelo.addRow(fila);
        }
    }

    /* CboSeleccionBodegaInforme */
    private void ListarCboSeleccionBodegaInforme() {
        CboSeleccionBodegaInforme.removeAllItems();
        CboSeleccionBodegaInforme.addItem("-- Seleccione --");
        for (Empleado emp : new DaoEmpleado().Listar()) {
            CboSeleccionBodegaInforme.addItem(emp.getNombreEmpleado());
        }
        for (Ubicacion ubi : new DaoUbicacion().Listar()) {
            CboSeleccionBodegaInforme.addItem(ubi.getDescripcionUbicacion());
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
        for (Ubicacion ubi : new DaoUbicacion().Listar()) {
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

    /*CboFiltroProductoInforme*/
    private void ListarCboFiltroProductoInforme() {
        CboFiltroProductoInforme.removeAllItems();
        CboFiltroProductoInforme.addItem("-- Seleccione --");
        for (TipoProducto tpprod : new DaoTipoProducto().Listar()) {
            CboFiltroProductoInforme.addItem(tpprod.getDescripcionTipoProducto());
        }
    }

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
            fila[6] = item.getColorProducto().getNombreColor();
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
            fila[6] = item.getColorProducto().getNombreColor();
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
            fila[6] = item.getColorProducto().getNombreColor();
            fila[7] = item.getCostoProducto();
            fila[8] = item.getEstadoProducto();
            modelo.addRow(fila);
        }
    }

    //JtbListarProductosMovimientos
    private void ListarProductosMovimientos() {
        DefaultTableModel modelo = new DefaultTableModel();
        JtbListarProductosMovimientos.setModel(modelo);
        modelo.addColumn("Movimiento");
        modelo.addColumn("Tipo Movimiento");
        modelo.addColumn("Ubicacion Final");
        modelo.addColumn("Fecha Movimiento");
        SimpleDateFormat fmto = new SimpleDateFormat("DD/MM/YYYY");
        ArrayList<Movimiento> listado = new DaoMovimiento().Listar();
        for (Movimiento item : listado) {
            Object[] fila = new Object[9];
            fila[0] = item.getIdMovimiento();
            fila[1] = item.getTpMovIdTipoMovimiento().getNombreTipoMovimiento();
            fila[2] = item.getUbicacionFinal();
            fila[3] = item.getFechaMovimiento();
            modelo.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
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
        txtUltimaActualizacionProducto1 = new javax.swing.JTextField();
        label62 = new java.awt.Label();
        txtCostoHome = new javax.swing.JTextField();
        label63 = new java.awt.Label();
        label64 = new java.awt.Label();
        JdcFechaLlegadaHome = new com.toedter.calendar.JDateChooser();
        cboColorHome = new javax.swing.JComboBox<>();
        JpCuentas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtbListarPersonas = new javax.swing.JTable();
        txtIdEmpleadoHome = new javax.swing.JTextField();
        txtRunEmpleadoHome = new javax.swing.JTextField();
        txtNombreEmpleadoHome = new javax.swing.JTextField();
        txtTelefonoEmpleadoHome = new javax.swing.JTextField();
        txtDireccionEmpleadoHome = new javax.swing.JTextField();
        cboJornadaEmpleadoHome = new javax.swing.JComboBox<>();
        cboSupervisorEmpleadoHome = new javax.swing.JComboBox<>();
        cboCargoEmpleadoHome = new javax.swing.JComboBox<>();
        label6 = new java.awt.Label();
        label15 = new java.awt.Label();
        label16 = new java.awt.Label();
        label17 = new java.awt.Label();
        label18 = new java.awt.Label();
        label19 = new java.awt.Label();
        label20 = new java.awt.Label();
        btnCrearUsuarioHome = new java.awt.Button();
        btnEliminarUsuarioHome = new java.awt.Button();
        label22 = new java.awt.Label();
        label23 = new java.awt.Label();
        jPanel3 = new javax.swing.JPanel();
        btnBuscarEmpleado = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtFiltroRunEmpleadoHome = new javax.swing.JTextField();
        btnModificarUsuarioHome = new java.awt.Button();
        btnGuardarUsuarioHome = new java.awt.Button();
        btnCancelarUsuarioHome = new java.awt.Button();
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
        btnCancelarProducto = new java.awt.Button();
        label53 = new java.awt.Label();
        cboUbicacionProductoProducto = new javax.swing.JComboBox<>();
        btnGuardarProducto = new java.awt.Button();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtFiltroActivoProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        JdcFechaLlegadaProductoProducto = new com.toedter.calendar.JDateChooser();
        cboColorProducto = new javax.swing.JComboBox<>();
        JpInformes = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        BtnExportarInventario = new javax.swing.JButton();
        BtnImprimirInventario = new javax.swing.JButton();
        btnMovimientos = new javax.swing.JButton();
        BtnImprimirMovimientos = new javax.swing.JButton();
        CboSeleccionBodegaInforme = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        BtnFiltrarBodegaInforme = new javax.swing.JButton();
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
        txtBuscarNumeroActivoMovimiento = new javax.swing.JTextField();
        txtFechaAsignacionMovimiento = new javax.swing.JTextField();
        txtNnumeroDeSerieMovimiento = new javax.swing.JTextField();
        label32 = new java.awt.Label();
        txtUltimaActializacion2 = new javax.swing.JTextField();
        label33 = new java.awt.Label();
        label34 = new java.awt.Label();
        label35 = new java.awt.Label();
        label36 = new java.awt.Label();
        JcbUbicacioninicio = new javax.swing.JComboBox<>();
        JcbUbicacionDestino = new javax.swing.JComboBox<>();
        cboTipoProductoMovimiento = new javax.swing.JComboBox<>();
        jdcFechaMovimiento = new com.toedter.calendar.JDateChooser();
        cboTipoMovimientoMovimiento = new javax.swing.JComboBox<>();
        btnNuevoMovimiento = new java.awt.Button();
        btnBuscarParaMovimiento = new javax.swing.JButton();
        btnCancelarMovimiento = new javax.swing.JButton();
        btnGuardarMovimiento = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        btnCrearTpProd = new javax.swing.JMenuItem();
        btnEliminarTpProducto = new javax.swing.JMenuItem();
        btnCrearUbicacion = new javax.swing.JMenuItem();
        btnEliminarUbi = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MnuCerrarSesion = new javax.swing.JMenuItem();
        mnuCerrar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuCrearUsuario = new javax.swing.JMenuItem();
        mnuModificarUsuario = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MnuCrearColor = new javax.swing.JMenuItem();
        MnuCrearProducto = new javax.swing.JMenuItem();
        MnuModificarProducto = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Activo Fijo Bodega");
        setForeground(java.awt.Color.orange);
        setIconImage(getIconImage());
        setIconImages(null);
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

        label63.setText("Color");

        label64.setText("Costo");

        JdcFechaLlegadaHome.setEnabled(false);

        cboColorHome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboColorHome.setEnabled(false);

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
                                    .addComponent(cboEstadoProductoHome, 0, 172, Short.MAX_VALUE)
                                    .addComponent(JdcFechaLlegadaHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(JpHomeLayout.createSequentialGroup()
                                .addComponent(label58, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(txtcontNetoProductoHome, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label63, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label64, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCostoHome, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(cboColorHome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1316, Short.MAX_VALUE)
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
                            .addComponent(label62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUltimaActualizacionProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JdcFechaLlegadaHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label60, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboEstadoProductoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JpHomeLayout.createSequentialGroup()
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCostoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboColorHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(JpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboUbicacionProductoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcontNetoProductoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
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
        JtbListarPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtbListarPersonasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JtbListarPersonas);

        txtIdEmpleadoHome.setEnabled(false);
        txtIdEmpleadoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEmpleadoHomeActionPerformed(evt);
            }
        });

        txtRunEmpleadoHome.setEnabled(false);
        txtRunEmpleadoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRunEmpleadoHomeActionPerformed(evt);
            }
        });

        txtNombreEmpleadoHome.setEnabled(false);
        txtNombreEmpleadoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEmpleadoHomeActionPerformed(evt);
            }
        });

        txtTelefonoEmpleadoHome.setEnabled(false);
        txtTelefonoEmpleadoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoEmpleadoHomeActionPerformed(evt);
            }
        });

        txtDireccionEmpleadoHome.setEnabled(false);
        txtDireccionEmpleadoHome.setMaximumSize(new java.awt.Dimension(300, 22));
        txtDireccionEmpleadoHome.setMinimumSize(new java.awt.Dimension(300, 22));
        txtDireccionEmpleadoHome.setPreferredSize(new java.awt.Dimension(300, 22));
        txtDireccionEmpleadoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionEmpleadoHomeActionPerformed(evt);
            }
        });

        cboJornadaEmpleadoHome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboJornadaEmpleadoHome.setEnabled(false);

        cboSupervisorEmpleadoHome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboSupervisorEmpleadoHome.setEnabled(false);
        cboSupervisorEmpleadoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSupervisorEmpleadoHomeActionPerformed(evt);
            }
        });

        cboCargoEmpleadoHome.setEnabled(false);
        cboCargoEmpleadoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCargoEmpleadoHomeActionPerformed(evt);
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

        btnCrearUsuarioHome.setLabel("Crear Usuario");
        btnCrearUsuarioHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioHomeActionPerformed(evt);
            }
        });

        btnEliminarUsuarioHome.setLabel("Eliminar Usuario");
        btnEliminarUsuarioHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioHomeActionPerformed(evt);
            }
        });

        label22.setText("Supervisor");

        label23.setText("Cargo");

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
                        .addComponent(TxtFiltroRunEmpleadoHome, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(TxtFiltroRunEmpleadoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnBuscarEmpleado)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        btnModificarUsuarioHome.setActionCommand("Modificar Usuario");
        btnModificarUsuarioHome.setEnabled(false);
        btnModificarUsuarioHome.setLabel("Modificar Usuario");
        btnModificarUsuarioHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioHomeActionPerformed(evt);
            }
        });

        btnGuardarUsuarioHome.setActionCommand("Guardar");
        btnGuardarUsuarioHome.setEnabled(false);
        btnGuardarUsuarioHome.setLabel("Guardar");
        btnGuardarUsuarioHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUsuarioHomeActionPerformed(evt);
            }
        });

        btnCancelarUsuarioHome.setActionCommand("Cancelar Usuario");
        btnCancelarUsuarioHome.setEnabled(false);
        btnCancelarUsuarioHome.setLabel("Cancelar Usuario");

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
                        .addComponent(btnCrearUsuarioHome, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarUsuarioHome, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                            .addGroup(JpCuentasLayout.createSequentialGroup()
                                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdEmpleadoHome, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreEmpleadoHome, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRunEmpleadoHome, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefonoEmpleadoHome, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JpCuentasLayout.createSequentialGroup()
                                        .addComponent(label20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(79, 79, 79)
                                        .addComponent(cboJornadaEmpleadoHome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(JpCuentasLayout.createSequentialGroup()
                                        .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(65, 65, 65)
                                        .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(JpCuentasLayout.createSequentialGroup()
                                                .addComponent(btnGuardarUsuarioHome, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                                .addComponent(btnModificarUsuarioHome, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cboSupervisorEmpleadoHome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cboCargoEmpleadoHome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(JpCuentasLayout.createSequentialGroup()
                                .addComponent(txtDireccionEmpleadoHome, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarUsuarioHome, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111)))
                        .addGap(74, 74, 74)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addContainerGap())
        );
        JpCuentasLayout.setVerticalGroup(
            JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpCuentasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearUsuarioHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarUsuarioHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpCuentasLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(JpCuentasLayout.createSequentialGroup()
                                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdEmpleadoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRunEmpleadoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(JpCuentasLayout.createSequentialGroup()
                                        .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(label18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(JpCuentasLayout.createSequentialGroup()
                                        .addComponent(txtNombreEmpleadoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTelefonoEmpleadoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(JpCuentasLayout.createSequentialGroup()
                                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboJornadaEmpleadoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboSupervisorEmpleadoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboCargoEmpleadoHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardarUsuarioHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnModificarUsuarioHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addGroup(JpCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelarUsuarioHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDireccionEmpleadoHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(JpCuentasLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
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

        label43.setText("Marca");

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

        btnModificarProducto.setEnabled(false);
        btnModificarProducto.setLabel("Modificar Producto");
        btnModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setLabel("Eliminar Producto");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        btnCancelarProducto.setActionCommand("Cancelar");
        btnCancelarProducto.setEnabled(false);
        btnCancelarProducto.setLabel("Cancelar");
        btnCancelarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarProductoMouseClicked(evt);
            }
        });
        btnCancelarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProductoActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        JdcFechaLlegadaProductoProducto.setEnabled(false);

        cboColorProducto.setEnabled(false);
        cboColorProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboColorProductoActionPerformed(evt);
            }
        });

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
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                                .addComponent(txtCostoProductoProducto)
                                                .addComponent(cboColorProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addComponent(btnModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JpProductosLayout.createSequentialGroup()
                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpProductosLayout.createSequentialGroup()
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUltimaActualizacionProductoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addComponent(JdcFechaLlegadaProductoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStockProductoProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboEstadoProductoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpProductosLayout.createSequentialGroup()
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCostoProductoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JpProductosLayout.createSequentialGroup()
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboColorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(40, 40, 40)
                                        .addGroup(JpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnGuardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(label50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addComponent(btnModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );

        BtnMnuProductos.addTab("Productos  ", new javax.swing.ImageIcon(getClass().getResource("/Img/box.png")), JpProductos); // NOI18N

        JpInformes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
        CboSeleccionBodegaInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboSeleccionBodegaInformeActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione Bodega");

        BtnFiltrarBodegaInforme.setText("Buscar");
        BtnFiltrarBodegaInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFiltrarBodegaInformeActionPerformed(evt);
            }
        });

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
                        .addComponent(CboSeleccionBodegaInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnFiltrarBodegaInforme)))
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
                    .addComponent(jLabel1)
                    .addComponent(BtnFiltrarBodegaInforme))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Seleccione Productos para Filtar");

        CboFiltroProductoInforme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --" }));

        BtnFiltrarInforme.setText("Filtrar");

        jLabel3.setText("Ingrese Numero de Activo para Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(CboFiltroProductoInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnFiltrarInforme)
                .addContainerGap(28, Short.MAX_VALUE))
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
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
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

        txtBuscarNumeroActivoMovimiento.setEnabled(false);
        txtBuscarNumeroActivoMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarNumeroActivoMovimientoActionPerformed(evt);
            }
        });
        txtBuscarNumeroActivoMovimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarNumeroActivoMovimientoKeyPressed(evt);
            }
        });

        txtFechaAsignacionMovimiento.setEnabled(false);
        txtFechaAsignacionMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaAsignacionMovimientoActionPerformed(evt);
            }
        });

        txtNnumeroDeSerieMovimiento.setEnabled(false);
        txtNnumeroDeSerieMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNnumeroDeSerieMovimientoActionPerformed(evt);
            }
        });

        label32.setText("Fecha Llegada Producto");

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

        cboTipoProductoMovimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --" }));
        cboTipoProductoMovimiento.setEnabled(false);

        jdcFechaMovimiento.setEnabled(false);

        cboTipoMovimientoMovimiento.setEnabled(false);
        cboTipoMovimientoMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoMovimientoMovimientoActionPerformed(evt);
            }
        });

        btnNuevoMovimiento.setActionCommand("Nuevo Movimiento");
        btnNuevoMovimiento.setLabel("Nuevo Movimiento");
        btnNuevoMovimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMovimientoMouseClicked(evt);
            }
        });
        btnNuevoMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMovimientoActionPerformed(evt);
            }
        });

        btnBuscarParaMovimiento.setText("Buscar");
        btnBuscarParaMovimiento.setEnabled(false);
        btnBuscarParaMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarParaMovimientoActionPerformed(evt);
            }
        });

        btnCancelarMovimiento.setText("Cancelar");
        btnCancelarMovimiento.setEnabled(false);
        btnCancelarMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMovimientoActionPerformed(evt);
            }
        });

        btnGuardarMovimiento.setText("Guardar");
        btnGuardarMovimiento.setEnabled(false);

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
                                .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(label32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpMovimientosLayout.createSequentialGroup()
                                .addComponent(btnNuevoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 932, Short.MAX_VALUE))
                            .addGroup(JpMovimientosLayout.createSequentialGroup()
                                .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cboTipoMovimientoMovimiento, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboTipoProductoMovimiento, javax.swing.GroupLayout.Alignment.LEADING, 0, 172, Short.MAX_VALUE))
                                    .addGroup(JpMovimientosLayout.createSequentialGroup()
                                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBuscarNumeroActivoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNnumeroDeSerieMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFechaAsignacionMovimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarParaMovimiento)))
                                .addGap(72, 72, 72)
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
                                    .addComponent(jdcFechaMovimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113)))))
                .addContainerGap())
            .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpMovimientosLayout.createSequentialGroup()
                    .addContainerGap(1071, Short.MAX_VALUE)
                    .addComponent(btnGuardarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(119, 119, 119)))
        );
        JpMovimientosLayout.setVerticalGroup(
            JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMovimientosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpMovimientosLayout.createSequentialGroup()
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBuscarNumeroActivoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscarParaMovimiento)))
                        .addGap(17, 17, 17)
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNnumeroDeSerieMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTipoMovimientoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTipoProductoMovimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFechaAsignacionMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JpMovimientosLayout.createSequentialGroup()
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpMovimientosLayout.createSequentialGroup()
                                .addComponent(txtUltimaActializacion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdcFechaMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JpMovimientosLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(JcbUbicacioninicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnCancelarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(JpMovimientosLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(label35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(label33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcbUbicacionDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(JpMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpMovimientosLayout.createSequentialGroup()
                    .addContainerGap(488, Short.MAX_VALUE)
                    .addComponent(btnGuardarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(168, 168, 168)))
        );

        BtnMnuProductos.addTab("Movimientos  ", new javax.swing.ImageIcon(getClass().getResource("/Img/arrows.png")), JpMovimientos); // NOI18N

        jMenu1.setText("Archivo");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.add(jSeparator1);

        btnCrearTpProd.setText("Crear Tipo Producto");
        btnCrearTpProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTpProdActionPerformed(evt);
            }
        });
        jMenu1.add(btnCrearTpProd);

        btnEliminarTpProducto.setText("Eliminar Tipo Producto");
        btnEliminarTpProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTpProductoActionPerformed(evt);
            }
        });
        jMenu1.add(btnEliminarTpProducto);

        btnCrearUbicacion.setText("Crear Ubicacion");
        btnCrearUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUbicacionActionPerformed(evt);
            }
        });
        jMenu1.add(btnCrearUbicacion);

        btnEliminarUbi.setText("Eliminar Ubicacion");
        btnEliminarUbi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUbiActionPerformed(evt);
            }
        });
        jMenu1.add(btnEliminarUbi);
        jMenu1.add(jSeparator2);

        MnuCerrarSesion.setText("Cerrar Sesion");
        MnuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuCerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(MnuCerrarSesion);

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

        mnuCrearUsuario.setText("Crear Usuario");
        mnuCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCrearUsuarioActionPerformed(evt);
            }
        });
        jMenu2.add(mnuCrearUsuario);

        mnuModificarUsuario.setText("Modificar Ususario");
        mnuModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModificarUsuarioActionPerformed(evt);
            }
        });
        jMenu2.add(mnuModificarUsuario);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Productos");

        MnuCrearColor.setText("Crear Color");
        MnuCrearColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuCrearColorActionPerformed(evt);
            }
        });
        jMenu3.add(MnuCrearColor);

        MnuCrearProducto.setText("Crear Producto");
        MnuCrearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuCrearProductoActionPerformed(evt);
            }
        });
        jMenu3.add(MnuCrearProducto);

        MnuModificarProducto.setText("Modificar Producto");
        MnuModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuModificarProductoActionPerformed(evt);
            }
        });
        jMenu3.add(MnuModificarProducto);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Informes");

        jMenuItem13.setText("Crear Informe");
        jMenu4.add(jMenuItem13);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Movimientos");

        jMenuItem14.setText("Nuevo Movimiento");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        jMenuItem1.setText("Crear Tipo Movimiento");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

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

    private void txtBuscarNumeroActivoMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarNumeroActivoMovimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNumeroActivoMovimientoActionPerformed

    private void txtFechaAsignacionMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaAsignacionMovimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaAsignacionMovimientoActionPerformed

    private void txtNnumeroDeSerieMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNnumeroDeSerieMovimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNnumeroDeSerieMovimientoActionPerformed

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
        ListarCboTipoProducto();
        ListarCboEstadoProducto();
        ListarCboUbicacion();
        ListarCboColorProducto();
        btnCancelarProducto.setEnabled(true);
        btnGuardarProducto.setEnabled(true);
        btnBuscarProducto.setEnabled(false);
        txtNumeroDeActivoProducto.setEnabled(true);
        txtNumeroDeSerieProducto.setEnabled(true);
        txtDescripcionProductoProducto.setEnabled(true);
        cboTipoProductoProducto.setEnabled(true);
        JdcFechaLlegadaProductoProducto.setEnabled(true);
        cboEstadoProductoProducto.setEnabled(true);
        cboColorProducto.setEnabled(true);
        txtcontNetoProductoProducto.setEnabled(true);
        txtCostoProductoProducto.setEnabled(true);
        cboUbicacionProductoProducto.setEnabled(true);

        txtNumeroDeActivoProducto.setText("");
        txtNumeroDeSerieProducto.setText("");
        txtDescripcionProductoProducto.setText("");
        txtStockProductoProducto.setText("");
        cboColorProducto.setSelectedItem("-- Seleccione --");
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
        btnModificarProducto.setEnabled(false);
        btnCrearProducto.setEnabled(true);
        btnEliminarProducto.setEnabled(true);
        txtNumeroDeActivoProducto.setEnabled(false);
        txtNumeroDeSerieProducto.setEnabled(false);
        txtDescripcionProductoProducto.setEnabled(false);
        cboTipoProductoProducto.setEnabled(false);
        JdcFechaLlegadaProductoProducto.setEnabled(false);
        txtStockProductoProducto.setEnabled(false);
        cboEstadoProductoProducto.setEnabled(false);
        cboColorProducto.setEnabled(false);
        txtcontNetoProductoProducto.setEnabled(false);
        txtCostoProductoProducto.setEnabled(false);
        cboUbicacionProductoProducto.setEnabled(false);

        txtNumeroDeActivoProducto.setText("");
        txtNumeroDeSerieProducto.setText("");
        txtDescripcionProductoProducto.setText("");
        txtStockProductoProducto.setText("");
        cboColorProducto.setSelectedItem("-- Seleccione --");
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

    private void btnCrearUsuarioHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioHomeActionPerformed
        btnBuscarEmpleado.setEnabled(false);
        btnGuardarUsuarioHome.setEnabled(true);
        btnModificarProducto.setEnabled(false);
        btnCancelarUsuarioHome.setEnabled(true);
        txtRunEmpleadoHome.setEnabled(true);
        txtNombreEmpleadoHome.setEnabled(true);
        txtTelefonoEmpleadoHome.setEnabled(true);
        txtDireccionEmpleadoHome.setEnabled(true);
        cboJornadaEmpleadoHome.setEnabled(true);
        cboSupervisorEmpleadoHome.setEnabled(true);
        cboCargoEmpleadoHome.setEnabled(true);

        txtRunEmpleadoHome.setText("");
        txtNombreEmpleadoHome.setText("");
        txtTelefonoEmpleadoHome.setText("");
        txtDireccionEmpleadoHome.setText("");
        cboJornadaEmpleadoHome.setSelectedItem("-- Seleccione --");
        cboSupervisorEmpleadoHome.setSelectedItem("-- Seleccione --");
        cboCargoEmpleadoHome.setSelectedItem("-- Seleccione --");

    }//GEN-LAST:event_btnCrearUsuarioHomeActionPerformed

    private void cboCargoEmpleadoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCargoEmpleadoHomeActionPerformed

    }//GEN-LAST:event_cboCargoEmpleadoHomeActionPerformed

    private void cboSupervisorEmpleadoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSupervisorEmpleadoHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSupervisorEmpleadoHomeActionPerformed

    private void txtDireccionEmpleadoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionEmpleadoHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionEmpleadoHomeActionPerformed

    private void txtTelefonoEmpleadoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoEmpleadoHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoEmpleadoHomeActionPerformed

    private void txtNombreEmpleadoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEmpleadoHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEmpleadoHomeActionPerformed

    private void txtRunEmpleadoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRunEmpleadoHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRunEmpleadoHomeActionPerformed

    private void txtIdEmpleadoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEmpleadoHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEmpleadoHomeActionPerformed

    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        String run = TxtFiltroRunEmpleadoHome.getText();
        Empleado emp = new DaoEmpleado().Buscar2(run);
        if (emp != null) {
            JOptionPane.showMessageDialog(null, "Existe Empleado");
            txtIdEmpleadoHome.setText("" + emp.getIdEmpleado());
            txtRunEmpleadoHome.setText(emp.getRutEmpleado());
            txtNombreEmpleadoHome.setText(emp.getNombreEmpleado());
            txtTelefonoEmpleadoHome.setText(emp.getTelefonoEmpleado());
            txtDireccionEmpleadoHome.setText(emp.getDireccionEmpleado());
            cboCargoEmpleadoHome.setSelectedItem(emp.getCargoEmpleado().toString());
            cboJornadaEmpleadoHome.setSelectedItem(emp.getJornadaEmpleado().toString());
        } else {
            JOptionPane.showMessageDialog(null, "No Existe Empleado");
        }
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void BtnMnuProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMnuProductosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnMnuProductosMouseEntered

    private void JtbListarProductosHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtbListarProductosHomeMouseClicked
        int fila = JtbListarProductosHome.getSelectedRow();
        String activo = JtbListarProductosHome.getValueAt(fila, 0).toString();
        Producto prod = new DaoProducto().Buscar2(activo);
        if (prod != null) {
            txtNumeroActivoHome.setText(prod.getNumActivoProducto());
            txtNnumeroDeSerieHome.setText(prod.getNumSerieProducto());
            txtDescripcionProductoHome.setText(prod.getDescProducto());
            cboTipoProductoHome.setSelectedItem(prod.getTipoProducto().toString());
            cboUbicacionProductoHome.setSelectedItem(prod.getUbicacionProducto().toString());
            cboEstadoProductoHome.setSelectedItem(prod.getEstadoProducto().toString());
            cboColorHome.setSelectedItem(prod.getColorProducto().getNombreColor());
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

    private void JtbListarProductosProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtbListarProductosProductosMouseClicked
        int fila = JtbListarProductosProductos.getSelectedRow();
        String activo = JtbListarProductosProductos.getValueAt(fila, 0).toString();
        Producto prod = new DaoProducto().Buscar2(activo);
        if (prod != null) {
            txtNumeroDeActivoProducto.setText("" + prod.getNumActivoProducto());
            txtNumeroDeSerieProducto.setText("" + prod.getNumSerieProducto());
            txtDescripcionProductoProducto.setText(prod.getDescProducto());
            cboTipoProductoProducto.setSelectedItem(prod.getTipoProducto().toString());
            cboUbicacionProductoProducto.setSelectedItem(prod.getUbicacionProducto().toString());
            cboEstadoProductoProducto.setSelectedItem(prod.getEstadoProducto().toString());
            cboColorProducto.setSelectedItem(prod.getColorProducto().getNombreColor());
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
        String numAct = TxtFiltroActivoProducto.getText();
        Producto prod = new DaoProducto().Buscar2(numAct);
        if (prod != null) {
            JOptionPane.showMessageDialog(null, "Existe Producto");
            txtNumeroDeActivoProducto.setText("" + prod.getNumActivoProducto());
            txtNumeroDeSerieProducto.setText("" + prod.getNumSerieProducto());
            txtDescripcionProductoProducto.setText(prod.getDescProducto());
            cboTipoProductoProducto.setSelectedItem(prod.getTipoProducto().toString());
            cboUbicacionProductoProducto.setSelectedItem(prod.getUbicacionProducto().toString());
            cboEstadoProductoProducto.setSelectedItem(prod.getEstadoProducto().toString());
            cboColorHome.setSelectedItem(prod.getColorProducto().getNombreColor());
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
            String NumActivoProducto = txtNumeroDeActivoProducto.getText();
            String NumSerieProducto = txtNumeroDeSerieProducto.getText();
            String DescProducto = txtDescripcionProductoProducto.getText();
            Ubicacion ubicacion = new DaoUbicacion().Buscar2(cboUbicacionProductoProducto.getSelectedItem().toString());
            TipoProducto tpProd = new DaoTipoProducto().Buscar2(cboTipoProductoProducto.getSelectedItem().toString());
            Empleado actualizacion = new DaoEmpleado().Buscar2("11.111.111-1");
            Date fecha = JdcFechaLlegadaProductoProducto.getDate();
            Color colorProducto = new DaoColor().Buscar2(cboColorProducto.getSelectedItem().toString());
            int costoProducto = Integer.parseInt(txtCostoProductoProducto.getText());
            Estado estado = new DaoEstado().Buscar2(cboEstadoProductoProducto.getSelectedItem().toString());
            int litros = Integer.parseInt(txtcontNetoProductoProducto.getText());
            Producto producto = new Producto(idProducto, NumActivoProducto, NumSerieProducto, DescProducto, tpProd, actualizacion, fecha, costoProducto, estado, ubicacion, colorProducto, litros, costoProducto);
            boolean resp = new DaoProducto().Grabar(producto);
            if (resp) {
                JOptionPane.showMessageDialog(null, "Grabo");
                ListarProductosProductos();
                ResetProducto();
                ListarSupervisores();
            } else {
                JOptionPane.showMessageDialog(null, "Grabo");
            }
        } catch (Exception e) {
            System.out.println("Error grabar Producto:" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo grabar");
        }
    }//GEN-LAST:event_btnGuardarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        String numAct = txtNumeroDeActivoProducto.getText();
        DaoProducto dao = new DaoProducto();
        boolean resp = dao.Eliminar(numAct);
        if (resp == true) {
            JOptionPane.showMessageDialog(null, "Elimino");
            ListarProductosProductos();
        } else {
            JOptionPane.showMessageDialog(null, "No Elimino");
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProductoActionPerformed
        int idProducto = 0;
        String NumActivoProducto = txtNumeroDeActivoProducto.getText();
        String NumSerieProducto = txtNumeroDeSerieProducto.getText();
        String DescProducto = txtDescripcionProductoProducto.getText();
        Ubicacion ubicacion = new DaoUbicacion().Buscar2(cboUbicacionProductoProducto.getSelectedItem().toString());
        TipoProducto tpProd = new DaoTipoProducto().Buscar2(cboTipoProductoProducto.getSelectedItem().toString());
        Empleado actualizacion = new DaoEmpleado().Buscar2("11.111.111-1");
        Date fecha = JdcFechaLlegadaProductoProducto.getDate();
        Color colorProducto = new DaoColor().Buscar2(cboColorProducto.getSelectedItem().toString());
        int costoProducto = Integer.parseInt(txtCostoProductoProducto.getText());
        Estado estado = new DaoEstado().Buscar2(cboEstadoProductoProducto.getSelectedItem().toString());
        int litros = Integer.parseInt(txtcontNetoProductoProducto.getText());
        try {
            ////////////////////////////////////////////////////////
            Producto producto = new Producto(idProducto, NumActivoProducto, NumSerieProducto, DescProducto, tpProd, actualizacion, fecha, costoProducto, estado, ubicacion, colorProducto, costoProducto, costoProducto);
            ////////////////////////////////////////////////////////

            DaoProducto dao = new DaoProducto();
            boolean resp = dao.Modificar(producto);
            if (resp == true) {
                JOptionPane.showMessageDialog(null, "Modifico");
                ListarProductosProductos();
                ResetProducto();
                btnModificarProducto.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "No Modifico");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnModificarProductoActionPerformed

    private void MnuModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuModificarProductoActionPerformed
        BtnMnuProductos.setSelectedIndex(2);
        btnBuscarProducto.setEnabled(false);
        btnCrearProducto.setEnabled(false);
        btnGuardarProducto.setEnabled(false);
        btnCancelarProducto.setEnabled(true);
        btnModificarProducto.setEnabled(true);
        btnEliminarProducto.setEnabled(false);
        txtNumeroDeActivoProducto.setEnabled(false);
        txtNumeroDeSerieProducto.setEnabled(true);
        txtDescripcionProductoProducto.setEnabled(true);
        cboTipoProductoProducto.setEnabled(true);
        JdcFechaLlegadaProductoProducto.setEnabled(true);
        cboEstadoProductoProducto.setEnabled(true);
        cboColorProducto.setEnabled(true);
        txtcontNetoProductoProducto.setEnabled(true);
        txtCostoProductoProducto.setEnabled(true);
        cboUbicacionProductoProducto.setEnabled(true);
    }//GEN-LAST:event_MnuModificarProductoActionPerformed

    private void MnuCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuCrearProductoActionPerformed
        BtnMnuProductos.setSelectedIndex(2);
        btnBuscarEmpleado.setEnabled(false);
        btnCrearProducto.setEnabled(false);
        btnGuardarProducto.setEnabled(true);
        btnCancelarProducto.setEnabled(true);
        btnModificarProducto.setEnabled(false);
        btnEliminarProducto.setEnabled(false);
        txtNumeroDeActivoProducto.setEnabled(false);
        txtNumeroDeSerieProducto.setEnabled(true);
        txtDescripcionProductoProducto.setEnabled(true);
        cboTipoProductoProducto.setEnabled(true);
        JdcFechaLlegadaProductoProducto.setEnabled(true);
        cboEstadoProductoProducto.setEnabled(true);
        cboColorProducto.setEnabled(true);
        txtcontNetoProductoProducto.setEnabled(true);
        txtCostoProductoProducto.setEnabled(true);
        cboUbicacionProductoProducto.setEnabled(true);
    }//GEN-LAST:event_MnuCrearProductoActionPerformed

    private void btnCancelarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProductoActionPerformed
        ResetProducto();
    }//GEN-LAST:event_btnCancelarProductoActionPerformed

    private void resetCamposUsuario() {
        btnCancelarUsuarioHome.setEnabled(false);
        btnGuardarUsuarioHome.setEnabled(false);
        btnModificarUsuarioHome.setEnabled(false);
        txtRunEmpleadoHome.setEnabled(false);
        txtNombreEmpleadoHome.setEnabled(false);
        txtTelefonoEmpleadoHome.setEnabled(false);
        txtDireccionEmpleadoHome.setEnabled(false);
        cboJornadaEmpleadoHome.setEnabled(false);
        cboSupervisorEmpleadoHome.setEnabled(false);
        cboCargoEmpleadoHome.setEnabled(false);

        txtIdEmpleadoHome.setText("");
        txtRunEmpleadoHome.setText("");
        txtNombreEmpleadoHome.setText("");
        txtTelefonoEmpleadoHome.setText("");
        txtDireccionEmpleadoHome.setText("");
        cboJornadaEmpleadoHome.setSelectedItem("-- Seleccione --");
        cboSupervisorEmpleadoHome.setSelectedItem("-- Seleccione --");
        cboCargoEmpleadoHome.setSelectedItem("-- Seleccione --");
        btnBuscarEmpleado.setEnabled(true);
        btnEliminarUsuarioHome.setEnabled(true);
    }

    private void MnuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuCerrarSesionActionPerformed
        JfrmLogin login = new JfrmLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MnuCerrarSesionActionPerformed

    private void mnuCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCrearUsuarioActionPerformed
        BtnMnuProductos.setSelectedIndex(1);
        btnBuscarEmpleado.setEnabled(false);
        btnGuardarUsuarioHome.setEnabled(true);
        btnModificarProducto.setEnabled(false);
        btnCancelarUsuarioHome.setEnabled(true);
        txtRunEmpleadoHome.setEnabled(true);
        txtNombreEmpleadoHome.setEnabled(true);
        txtTelefonoEmpleadoHome.setEnabled(true);
        txtDireccionEmpleadoHome.setEnabled(true);
        cboJornadaEmpleadoHome.setEnabled(true);
        cboSupervisorEmpleadoHome.setEnabled(true);
        cboCargoEmpleadoHome.setEnabled(true);

        txtRunEmpleadoHome.setText("");
        txtNombreEmpleadoHome.setText("");
        txtTelefonoEmpleadoHome.setText("");
        txtDireccionEmpleadoHome.setText("");
        cboJornadaEmpleadoHome.setSelectedItem("-- Seleccione --");
        cboSupervisorEmpleadoHome.setSelectedItem("-- Seleccione --");
        cboCargoEmpleadoHome.setSelectedItem("-- Seleccione --");
    }//GEN-LAST:event_mnuCrearUsuarioActionPerformed

    private void mnuModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModificarUsuarioActionPerformed
        BtnMnuProductos.setSelectedIndex(1);
        btnBuscarEmpleado.setEnabled(false);
        btnCrearUsuarioHome.setEnabled(false);
        btnGuardarUsuarioHome.setEnabled(false);
        btnCancelarUsuarioHome.setEnabled(true);
        btnModificarUsuarioHome.setEnabled(true);
        btnEliminarUsuarioHome.setEnabled(false);
        txtIdEmpleadoHome.setEnabled(false);
        txtRunEmpleadoHome.setEnabled(true);
        txtNombreEmpleadoHome.setEnabled(true);
        txtTelefonoEmpleadoHome.setEnabled(true);
        txtDireccionEmpleadoHome.setEnabled(true);
        cboJornadaEmpleadoHome.setEnabled(true);
        cboSupervisorEmpleadoHome.setEnabled(true);
        cboCargoEmpleadoHome.setEnabled(true);

    }//GEN-LAST:event_mnuModificarUsuarioActionPerformed

    private void btnGuardarUsuarioHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuarioHomeActionPerformed
        try {
//    private int idEmpleado;
//    private String rutEmpleado;
//    private String nombreEmpleado;
//    private String telefonoEmpleado;
//    private String direccionEmpleado;
//    private TipoEmpleado cargoEmpleado;
//    private Jornada jornadaEmpleado;             
            int idEmpleado = 0;
            String rutEmpleado = txtRunEmpleadoHome.getText();
            String nombreEmpleado = txtNombreEmpleadoHome.getText();
            String telefonoEmpleado = txtTelefonoEmpleadoHome.getText();
            String direccionEmpleado = txtDireccionEmpleadoHome.getText();
            TipoEmpleado cargoEmpleado = new DaoTipoEmpleado().BuscarTipoEmpleado(cboCargoEmpleadoHome.getSelectedItem().toString());
            Jornada jornadaEmpleado = new DaoJornada().Buscar2(cboJornadaEmpleadoHome.getSelectedItem().toString());
            String supervisor = cboSupervisorEmpleadoHome.getSelectedItem().toString();
            Empleado empleado = new Empleado(idEmpleado, rutEmpleado, nombreEmpleado, telefonoEmpleado, direccionEmpleado, cargoEmpleado, jornadaEmpleado, supervisor);
            boolean resp = new DaoEmpleado().Grabar(empleado);
            if (resp) {
                JOptionPane.showMessageDialog(null, "Grabo");
                ListarEmpleados();
                resetCamposUsuario();
                ListarSupervisores();
            } else {
                JOptionPane.showMessageDialog(null, "No Grabo");
            }
        } catch (Exception e) {
            System.out.println("Error grabar Producto:" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo grabar");
        }
    }//GEN-LAST:event_btnGuardarUsuarioHomeActionPerformed

    private void JtbListarPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtbListarPersonasMouseClicked
        int fila = JtbListarPersonas.getSelectedRow();
        String run = JtbListarPersonas.getValueAt(fila, 0).toString();
        Empleado emp = new DaoEmpleado().Buscar2(run);
        if (emp != null) {
            txtIdEmpleadoHome.setText("" + emp.getIdEmpleado());
            txtRunEmpleadoHome.setText(emp.getRutEmpleado());
            txtNombreEmpleadoHome.setText(emp.getNombreEmpleado());
            txtTelefonoEmpleadoHome.setText(emp.getTelefonoEmpleado());
            txtDireccionEmpleadoHome.setText(emp.getDireccionEmpleado());
            cboCargoEmpleadoHome.setSelectedItem(emp.getCargoEmpleado().getDescripcionTipoEmpleado());
            cboJornadaEmpleadoHome.setSelectedItem(emp.getJornadaEmpleado().getDescripcionJornada());
            cboSupervisorEmpleadoHome.setSelectedItem(emp.getNombre_supervisor());

        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_JtbListarPersonasMouseClicked

    private void btnCrearTpProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTpProdActionPerformed
        ListarCboTipoProducto();
        ListarCboEstadoProducto();
        ListarCboUbicacion();
        JfrmAgregarTipoProducto tipoProd = new JfrmAgregarTipoProducto();
        tipoProd.setVisible(true);
    }//GEN-LAST:event_btnCrearTpProdActionPerformed

    private void btnEliminarTpProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTpProductoActionPerformed
        JfrmEliminarTipoProducto elimProd = new JfrmEliminarTipoProducto();
        elimProd.setVisible(true);
    }//GEN-LAST:event_btnEliminarTpProductoActionPerformed

    private void btnCrearUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUbicacionActionPerformed
        JfrmAgregarUbicacion creaUbi = new JfrmAgregarUbicacion();
        creaUbi.setVisible(true);
    }//GEN-LAST:event_btnCrearUbicacionActionPerformed

    private void btnEliminarUbiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUbiActionPerformed
        JfrmEliminarUbicacion elimUbi = new JfrmEliminarUbicacion();
        elimUbi.setVisible(true);
    }//GEN-LAST:event_btnEliminarUbiActionPerformed

    private void btnModificarUsuarioHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioHomeActionPerformed
        int idEmpleado = Integer.parseInt(txtIdEmpleadoHome.getText());
        String rutEmpleado = txtRunEmpleadoHome.getText();
        String nombreEmpleado = txtNombreEmpleadoHome.getText();
        String telefonoEmpleado = txtTelefonoEmpleadoHome.getText();
        String direccionEmpleado = txtDireccionEmpleadoHome.getText();
        TipoEmpleado cargoEmpleado = new DaoTipoEmpleado().BuscarTipoEmpleado(cboCargoEmpleadoHome.getSelectedItem().toString());
        Jornada jornadaEmpleado = new DaoJornada().Buscar2(cboJornadaEmpleadoHome.getSelectedItem().toString());
        String supervisor = cboSupervisorEmpleadoHome.getSelectedItem().toString();

        try {
            ////////////////////////////////////////////////////////
            Empleado empleado = new Empleado(idEmpleado, rutEmpleado, nombreEmpleado, telefonoEmpleado, direccionEmpleado, cargoEmpleado, jornadaEmpleado, supervisor);
            ////////////////////////////////////////////////////////

            DaoEmpleado dao = new DaoEmpleado();
            boolean resp = dao.Modificar(empleado);
            if (resp == true) {
                JOptionPane.showMessageDialog(null, "Modifico");
                ListarEmpleados();
                resetCamposUsuario();
                btnModificarUsuarioHome.setEnabled(false);
                ListarSupervisores();
            } else {
                JOptionPane.showMessageDialog(null, "No Modifico");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnModificarUsuarioHomeActionPerformed

    private void btnEliminarUsuarioHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioHomeActionPerformed
        int idEmp = Integer.parseInt(txtIdEmpleadoHome.getText());
        DaoEmpleado dao = new DaoEmpleado();
        boolean resp = dao.Eliminar(idEmp);
        if (resp == true) {
            JOptionPane.showMessageDialog(null, "Elimino");
            ListarEmpleados();
            ListarSupervisores();
        } else {
            JOptionPane.showMessageDialog(null, "No Elimino");
        }
    }//GEN-LAST:event_btnEliminarUsuarioHomeActionPerformed

    private void cboTipoMovimientoMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoMovimientoMovimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoMovimientoMovimientoActionPerformed

    private void btnNuevoMovimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMovimientoMouseClicked
        /*HabilitarMovimientos();*/
    }//GEN-LAST:event_btnNuevoMovimientoMouseClicked

    private void btnNuevoMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMovimientoActionPerformed
        JFrmNuevoMovimiento Movimientos = new JFrmNuevoMovimiento();
        Movimientos.setVisible(true);
    }//GEN-LAST:event_btnNuevoMovimientoActionPerformed

    private void btnCancelarMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMovimientoActionPerformed
        DeshabilitarMovimientos();
    }//GEN-LAST:event_btnCancelarMovimientoActionPerformed

    private void btnBuscarParaMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarParaMovimientoActionPerformed
        buscarMovimientoDeActivo();
    }//GEN-LAST:event_btnBuscarParaMovimientoActionPerformed

    private void txtBuscarNumeroActivoMovimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarNumeroActivoMovimientoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarMovimientoDeActivo();
        }
    }//GEN-LAST:event_txtBuscarNumeroActivoMovimientoKeyPressed

    private void MnuCrearColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuCrearColorActionPerformed
        JfrmAgregarColor color = new JfrmAgregarColor();
        MnuCrearColor.setEnabled(true);
        color.setVisible(true);

    }//GEN-LAST:event_MnuCrearColorActionPerformed

    private void cboColorProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboColorProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboColorProductoActionPerformed

    private void BtnFiltrarBodegaInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFiltrarBodegaInformeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnFiltrarBodegaInformeActionPerformed

    private void CboSeleccionBodegaInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboSeleccionBodegaInformeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CboSeleccionBodegaInformeActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        JFrmNuevoMovimiento Movimientos = new JFrmNuevoMovimiento();
        Movimientos.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void buscarMovimientoDeActivo() {
        int numAct = Integer.parseInt(txtBuscarNumeroActivoMovimiento.getText());
        Movimiento mov = new DaoMovimiento().Buscar(numAct);
        if (mov != null) {
            JOptionPane.showMessageDialog(null, "Existe Producto");
            cboTipoMovimientoMovimiento.setSelectedItem(mov.getTpMovIdTipoMovimiento().getNombreTipoMovimiento());
            jdcFechaMovimiento.setDate(mov.getFechaMovimiento());

        }
    }

    private void HabilitarMovimientos() {
        btnNuevoMovimiento.setEnabled(false);
        btnBuscarParaMovimiento.setEnabled(true);
        txtBuscarNumeroActivoMovimiento.setEnabled(true);
        cboTipoMovimientoMovimiento.setEnabled(true);
        JcbUbicacionDestino.setEnabled(true);
        btnGuardarMovimiento.setEnabled(true);
        btnCancelarMovimiento.setEnabled(true);
    }

    private void DeshabilitarMovimientos() {
        btnNuevoMovimiento.setEnabled(true);
        btnBuscarParaMovimiento.setEnabled(false);
        txtBuscarNumeroActivoMovimiento.setEnabled(false);
        cboTipoMovimientoMovimiento.setEnabled(false);
        JcbUbicacionDestino.setEnabled(false);
        btnGuardarMovimiento.setEnabled(false);
        btnCancelarMovimiento.setEnabled(false);
    }

    private void ResetProducto() {
        btnCancelarProducto.setEnabled(false);
        btnGuardarProducto.setEnabled(false);
        btnModificarProducto.setEnabled(false);
        txtNumeroDeActivoProducto.setEnabled(false);
        txtNumeroDeSerieProducto.setEnabled(false);
        txtDescripcionProductoProducto.setEnabled(false);
        cboTipoProductoProducto.setEnabled(false);
        JdcFechaLlegadaProductoProducto.setEnabled(false);
        txtStockProductoProducto.setEnabled(false);
        cboEstadoProductoProducto.setEnabled(false);
        cboColorProducto.setEnabled(false);
        txtcontNetoProductoProducto.setEnabled(false);
        txtCostoProductoProducto.setEnabled(false);
        cboUbicacionProductoProducto.setEnabled(false);

        txtNumeroDeActivoProducto.setText("");
        txtNumeroDeSerieProducto.setText("");
        txtDescripcionProductoProducto.setText("");
        txtStockProductoProducto.setText("");
        cboColorProducto.setSelectedItem("-- Seleccione --");
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
    private javax.swing.JButton BtnFiltrarBodegaInforme;
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
    private com.toedter.calendar.JDateChooser JdcFechaLlegadaProductoProducto;
    private javax.swing.JPanel JpCuentas;
    private javax.swing.JPanel JpHome;
    private javax.swing.JPanel JpInformes;
    private javax.swing.JPanel JpMovimientos;
    private javax.swing.JPanel JpProductos;
    private javax.swing.JTable JtbListarPersonas;
    private javax.swing.JTable JtbListarProductosHome;
    private javax.swing.JTable JtbListarProductosMovimientos;
    private javax.swing.JTable JtbListarProductosProductos;
    private javax.swing.JMenuItem MnuCerrarSesion;
    private javax.swing.JMenuItem MnuCrearColor;
    private javax.swing.JMenuItem MnuCrearProducto;
    private javax.swing.JMenuItem MnuModificarProducto;
    private javax.swing.JTextField TxtFiltroActivoProducto;
    private javax.swing.JTextField TxtFiltroRunEmpleadoHome;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnBuscarParaMovimiento;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCancelarMovimiento;
    private java.awt.Button btnCancelarProducto;
    private java.awt.Button btnCancelarUsuarioHome;
    private java.awt.Button btnCrearProducto;
    private javax.swing.JMenuItem btnCrearTpProd;
    private javax.swing.JMenuItem btnCrearUbicacion;
    private java.awt.Button btnCrearUsuarioHome;
    private java.awt.Button btnEliminarProducto;
    private javax.swing.JMenuItem btnEliminarTpProducto;
    private javax.swing.JMenuItem btnEliminarUbi;
    private java.awt.Button btnEliminarUsuarioHome;
    private javax.swing.JButton btnGuardarMovimiento;
    private java.awt.Button btnGuardarProducto;
    private java.awt.Button btnGuardarUsuarioHome;
    private java.awt.Button btnModificarProducto;
    private java.awt.Button btnModificarUsuarioHome;
    private javax.swing.JButton btnMovimientos;
    private java.awt.Button btnNuevoMovimiento;
    private javax.swing.JComboBox<String> cboCargoEmpleadoHome;
    private javax.swing.JComboBox<String> cboColorHome;
    private javax.swing.JComboBox<String> cboColorProducto;
    private javax.swing.JComboBox<String> cboEstadoProductoHome;
    private javax.swing.JComboBox<String> cboEstadoProductoProducto;
    private javax.swing.JComboBox<String> cboJornadaEmpleadoHome;
    private javax.swing.JComboBox<String> cboSupervisorEmpleadoHome;
    private javax.swing.JComboBox<String> cboTipoMovimientoMovimiento;
    private javax.swing.JComboBox<String> cboTipoProductoHome;
    private javax.swing.JComboBox<String> cboTipoProductoMovimiento;
    private javax.swing.JComboBox<String> cboTipoProductoProducto;
    private javax.swing.JComboBox<String> cboUbicacionProductoHome;
    private javax.swing.JComboBox<String> cboUbicacionProductoProducto;
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
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem3;
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
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JDateChooser jdcFechaMovimiento;
    private java.awt.Label label1;
    private java.awt.Label label15;
    private java.awt.Label label16;
    private java.awt.Label label17;
    private java.awt.Label label18;
    private java.awt.Label label19;
    private java.awt.Label label20;
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
    private javax.swing.JMenuItem mnuCrearUsuario;
    private javax.swing.JMenuItem mnuModificarUsuario;
    private javax.swing.JTextField txtBuscarNumeroActivoMovimiento;
    private javax.swing.JTextField txtCostoHome;
    private javax.swing.JTextField txtCostoProductoProducto;
    private javax.swing.JTextField txtDescripcionProductoHome;
    private javax.swing.JTextField txtDescripcionProductoProducto;
    private javax.swing.JTextField txtDireccionEmpleadoHome;
    private javax.swing.JTextField txtFechaAsignacionMovimiento;
    private javax.swing.JTextField txtIdEmpleadoHome;
    private javax.swing.JTextField txtNnumeroDeSerieHome;
    private javax.swing.JTextField txtNnumeroDeSerieMovimiento;
    private javax.swing.JTextField txtNombreEmpleadoHome;
    private javax.swing.JTextField txtNumeroActivoHome;
    private javax.swing.JTextField txtNumeroDeActivoProducto;
    private javax.swing.JTextField txtNumeroDeSerieProducto;
    private javax.swing.JTextField txtRunEmpleadoHome;
    private javax.swing.JTextField txtStockHome;
    private javax.swing.JTextField txtStockProductoProducto;
    private javax.swing.JTextField txtTelefonoEmpleadoHome;
    private javax.swing.JTextField txtUltimaActializacion2;
    private javax.swing.JTextField txtUltimaActualizacionProducto1;
    private javax.swing.JTextField txtUltimaActualizacionProductoProducto;
    private javax.swing.JTextField txtcontNetoProductoHome;
    private javax.swing.JTextField txtcontNetoProductoProducto;
    // End of variables declaration//GEN-END:variables
}
