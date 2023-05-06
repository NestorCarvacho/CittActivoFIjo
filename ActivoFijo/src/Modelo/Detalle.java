
package Modelo;

import java.util.Date;


public class Detalle {
    private Date fechaAsignacion;
    private Producto productoIdProducto;
    private Empleado empleadoIdEmpleado;

    //CONSTRUCTOR SIN PARAMETROS
    public Detalle() {
    }

    public Detalle(Date fechaAsignacion, Producto productoIdProducto, Empleado empleadoIdEmpleado) {
        this.fechaAsignacion = fechaAsignacion;
        this.productoIdProducto = productoIdProducto;
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Producto getProductoIdProducto() {
        return productoIdProducto;
    }

    public void setProductoIdProducto(Producto productoIdProducto) {
        this.productoIdProducto = productoIdProducto;
    }

    public Empleado getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    public void setEmpleadoIdEmpleado(Empleado empleadoIdEmpleado) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    @Override
    public String toString() {
        return "Detalle{" + "fechaAsignacion=" + fechaAsignacion + ", productoIdProducto=" + productoIdProducto + ", empleadoIdEmpleado=" + empleadoIdEmpleado + '}';
    }

    
    
    
}
