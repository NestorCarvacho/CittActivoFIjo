
package Modelo;


public class Bodega {
    private int idBodega;
    private String descripcionBodega;

    //CONSTRUCTOR SIN PARAMETROS
    public Bodega() {
    }

    //CONSTRUCTOR CON PARAMETROS
    public Bodega(int idBodega, String descripcionBodega) {
        this.idBodega = idBodega;
        this.descripcionBodega = descripcionBodega;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public String getDescripcionBodega() {
        return descripcionBodega;
    }

    public void setDescripcionBodega(String descripcionBodega) {
        this.descripcionBodega = descripcionBodega;
    }

    @Override
    public String toString() {
        return "Bodega{" + "idBodega=" + idBodega + ", descripcionBodega=" + descripcionBodega + '}';
    }
    
}
