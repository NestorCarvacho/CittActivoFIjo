
package Modelo;
import java.util.Date;


public class Movimiento {
    private int idMovimiento;
    private TipoMovimiento tpMovIdTipoMovimiento;
    private Ubicacion ubicacionFinal;
    private Date fechaMovimiento;
    private Empleado emp;

    public Movimiento() {
    }

    public Movimiento(int idMovimiento, TipoMovimiento tpMovIdTipoMovimiento, Ubicacion ubicacionFinal, Date fechaMovimiento, Empleado emp) {
        this.idMovimiento = idMovimiento;
        this.tpMovIdTipoMovimiento = tpMovIdTipoMovimiento;
        this.ubicacionFinal = ubicacionFinal;
        this.fechaMovimiento = fechaMovimiento;
        this.emp = emp;
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

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "idMovimiento=" + idMovimiento + ", tpMovIdTipoMovimiento=" + tpMovIdTipoMovimiento + ", ubicacionFinal=" + ubicacionFinal + ", fechaMovimiento=" + fechaMovimiento + ", emp=" + emp + '}';
    }

    


}
