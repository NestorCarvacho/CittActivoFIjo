
package Modelo;


public class Ubicacion {
   private int idUbicacion;
   private String descripcionUbicacion;

    public Ubicacion() {
    }

    public Ubicacion(int idUbicacion, String decUbicacion) {
        this.idUbicacion = idUbicacion;
        this.descripcionUbicacion = decUbicacion;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getDescripcionUbicacion() {
        return descripcionUbicacion;
    }

    public void setDescripcionUbicacion(String descripcionUbicacion) {
        this.descripcionUbicacion = descripcionUbicacion;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "idUbicacion=" + idUbicacion + ", decUbicacion=" + descripcionUbicacion + '}';
    }
   
   
}
