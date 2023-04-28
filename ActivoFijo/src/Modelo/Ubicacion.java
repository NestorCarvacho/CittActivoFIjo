
package Modelo;


public class Ubicacion {
   private int idUbicacion;
   private String decUbicacion;

    public Ubicacion() {
    }

    public Ubicacion(int idUbicacion, String decUbicacion) {
        this.idUbicacion = idUbicacion;
        this.decUbicacion = decUbicacion;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getDecUbicacion() {
        return decUbicacion;
    }

    public void setDecUbicacion(String decUbicacion) {
        this.decUbicacion = decUbicacion;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "idUbicacion=" + idUbicacion + ", decUbicacion=" + decUbicacion + '}';
    }
   
   
}
