
package Modelo;


public class Estado {
    private int idEstado;
    private String descripcionEstado;

    public Estado() {
    }

    public Estado(int idEstado, String descripcionEstado) {
        this.idEstado = idEstado;
        this.descripcionEstado = descripcionEstado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    @Override
    public String toString() {
        return descripcionEstado;
    }
    
}
