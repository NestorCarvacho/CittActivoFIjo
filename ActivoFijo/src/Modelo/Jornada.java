
package Modelo;


public class Jornada {
    private int idJornada;
    private String descripcionJornada;

    public Jornada() {
    }

    public Jornada(int idJornada, String descripcionJornada) {
        this.idJornada = idJornada;
        this.descripcionJornada = descripcionJornada;
    }

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public String getDescripcionJornada() {
        return descripcionJornada;
    }

    public void setDescripcionJornada(String descripcionJornada) {
        this.descripcionJornada = descripcionJornada;
    }

    @Override
    public String toString() {
        return "Jornada{" + "idJornada=" + idJornada + ", descripcionJornada=" + descripcionJornada + '}';
    }
        
}
