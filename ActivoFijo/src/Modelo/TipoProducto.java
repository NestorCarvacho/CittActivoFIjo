
package Modelo;


public class TipoProducto {
    private int idTipoProducto;
    private String descripcionTipoProducto;

    public TipoProducto() {
    }

    public TipoProducto(int idTipoProducto, String descripcionTipoProducto) {
        this.idTipoProducto = idTipoProducto;
        this.descripcionTipoProducto = descripcionTipoProducto;
    }

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getDescripcionTipoProducto() {
        return descripcionTipoProducto;
    }

    public void setDescripcionTipoProducto(String descripcionTipoProducto) {
        this.descripcionTipoProducto = descripcionTipoProducto;
    }

    @Override
    public String toString() {
        return descripcionTipoProducto;
    }



    
}
