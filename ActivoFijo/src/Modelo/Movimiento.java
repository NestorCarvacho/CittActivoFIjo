
package Modelo;
import java.util.Date;


public class Movimiento {
    private int idMovimiento;
    private TipoMovimiento tpMovIdTipoMovimiento;
    private Ubicacion ubicacionInicio;
    private Ubicacion ubicacionFinal;
    private Date fechaMovimiento;

    //CONSTRUCTOR SIN PARAMETROS
    public Movimiento() {
    }

    public Movimiento(int idMovimiento, TipoMovimiento tpMovIdTipoMovimiento, Producto productoIdProducto, Ubicacion ubicacionInicio, Ubicacion ubicacionFinal, Date fechaMovimiento) {
        this.idMovimiento = idMovimiento;
        this.tpMovIdTipoMovimiento = tpMovIdTipoMovimiento;
        this.ubicacionInicio = ubicacionInicio;
        this.ubicacionFinal = ubicacionFinal;
        this.fechaMovimiento = fechaMovimiento;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public TipoMovimiento getTpMovIdTipoMovimiento() {
        return tpMovIdTipoMovimiento;
    }

    public void setTpMovIdTipoMovimiento(TipoMovimiento tpMovIdTipoMovimiento) {
        this.tpMovIdTipoMovimiento = tpMovIdTipoMovimiento;
    }

    public Ubicacion getUbicacionInicio() {
        return ubicacionInicio;
    }

    public void setUbicacionInicio(Ubicacion ubicacionInicio) {
        this.ubicacionInicio = ubicacionInicio;
    }

    public Ubicacion getUbicacionFinal() {
        return ubicacionFinal;
    }

    public void setUbicacionFinal(Ubicacion ubicacionFinal) {
        this.ubicacionFinal = ubicacionFinal;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "idMovimiento=" + idMovimiento + ", tpMovIdTipoMovimiento=" + tpMovIdTipoMovimiento + ", ubicacionInicio=" + ubicacionInicio + ", ubicacionFinal=" + ubicacionFinal + ", fechaMovimiento=" + fechaMovimiento + '}';
    }


}
