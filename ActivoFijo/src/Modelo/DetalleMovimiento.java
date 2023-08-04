
package Modelo;


public class DetalleMovimiento {
    private int idMovimiento;
    private int idProducto; 
    private int UbicacionInicio;

    public DetalleMovimiento() {
    }

    public DetalleMovimiento(int idMovimiento, int idProducto, int UbicacionInicio) {
        this.idMovimiento = idMovimiento;
        this.idProducto = idProducto;
        this.UbicacionInicio = UbicacionInicio;
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

    public int getUbicacionInicio() {
        return UbicacionInicio;
    }

    public void setUbicacionInicio(int UbicacionInicio) {
        this.UbicacionInicio = UbicacionInicio;
    }

    @Override
    public String toString() {
        return "DetalleMovimiento{" + "idMovimiento=" + idMovimiento + ", idProducto=" + idProducto + ", UbicacionInicio=" + UbicacionInicio + '}';
    }

    
    
    
}
