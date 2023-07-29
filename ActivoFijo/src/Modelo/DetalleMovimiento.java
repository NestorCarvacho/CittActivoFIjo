
package Modelo;


public class DetalleMovimiento {
    private Movimiento idMovimiento;
    private Producto idProducto; 

    public DetalleMovimiento() {
    }

    public DetalleMovimiento(Movimiento idMovimiento, Producto idProducto) {
        this.idMovimiento = idMovimiento;
        this.idProducto = idProducto;
    }

    public Movimiento getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Movimiento idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "DetalleMovimiento{" + "idMovimiento=" + idMovimiento + ", idProducto=" + idProducto + '}';
    }
}
