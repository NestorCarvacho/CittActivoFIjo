
package Modelo;


public class Supervisor {
    private int id_supervisor;
    private String nombreSupervisor;

    public Supervisor() {
    }

    public Supervisor(int id_supervisor, String nombreSupervisor) {
        this.id_supervisor = id_supervisor;
        this.nombreSupervisor = nombreSupervisor;
    }

    public int getId_supervisor() {
        return id_supervisor;
    }

    public void setId_supervisor(int id_supervisor) {
        this.id_supervisor = id_supervisor;
    }

    public String getNombreSupervisor() {
        return nombreSupervisor;
    }

    public void setNombreSupervisor(String nombreSupervisor) {
        this.nombreSupervisor = nombreSupervisor;
    }

    @Override
    public String toString() {
        return nombreSupervisor;
    }
}
