
package Modelo;

public class TipoEmpleado {
    private int idTipoEmpleado;
    private String descripcionTipoEmpleado;

    public TipoEmpleado() {
    }

    public TipoEmpleado(int idTipoEmpleado, String descripcionTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
        this.descripcionTipoEmpleado = descripcionTipoEmpleado;
    }

    public int getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(int idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public String getDescripcionTipoEmpleado() {
        return descripcionTipoEmpleado;
    }

    public void setDescripcionTipoEmpleado(String descripcionTipoEmpleado) {
        this.descripcionTipoEmpleado = descripcionTipoEmpleado;
    }

    @Override
    public String toString() {
        return "TipoEmpleado{" + "idTipoEmpleado=" + idTipoEmpleado + ", descripcionTipoEmpleado=" + descripcionTipoEmpleado + '}';
    }
}
