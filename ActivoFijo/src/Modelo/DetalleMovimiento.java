
package Modelo;


public class DetalleMovimiento {
    private int idMovimiento;
    private int idProducto; 

    public DetalleMovimiento() {
    }

    public DetalleMovimiento(int idMovimiento, int idProducto) {
        this.idMovimiento = idMovimiento;
        this.idProducto = idProducto;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "DetalleMovimiento{" + "idMovimiento=" + idMovimiento + ", idProducto=" + idProducto + '}';
    }
    
    
}
