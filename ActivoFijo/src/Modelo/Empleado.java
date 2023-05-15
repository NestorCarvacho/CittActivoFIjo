
package Modelo;

public class Empleado {
    private int idEmpleado;
    private String rutEmpleado;
    private String nombreEmpleado;
    private String telefonoEmpleado;
    private String direccionEmpleado;
    private TipoEmpleado cargoEmpleado;
    private Jornada jornadaEmpleado; 
    private String nombre_supervisor;
    
    
    
    
    //Metodos Customer

    public Empleado() {
    }

    public Empleado(int idEmpleado, String rutEmpleado, String nombreEmpleado, String telefonoEmpleado, String direccionEmpleado, TipoEmpleado cargoEmpleado, Jornada jornadaEmpleado, String nombre_supervisor) {
        this.idEmpleado = idEmpleado;
        this.rutEmpleado = rutEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.telefonoEmpleado = telefonoEmpleado;
        this.direccionEmpleado = direccionEmpleado;
        this.cargoEmpleado = cargoEmpleado;
        this.jornadaEmpleado = jornadaEmpleado;
        this.nombre_supervisor = nombre_supervisor;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getRutEmpleado() {
        return rutEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public TipoEmpleado getCargoEmpleado() {
        return cargoEmpleado;
    }

    public Jornada getJornadaEmpleado() {
        return jornadaEmpleado;
    }

    public String getNombre_supervisor() {
        return nombre_supervisor;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setRutEmpleado(String rutEmpleado) {
        this.rutEmpleado = rutEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public void setCargoEmpleado(TipoEmpleado cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }

    public void setJornadaEmpleado(Jornada jornadaEmpleado) {
        this.jornadaEmpleado = jornadaEmpleado;
    }

    public void setNombre_supervisor(String nombre_supervisor) {
        this.nombre_supervisor = nombre_supervisor;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", rutEmpleado=" + rutEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", telefonoEmpleado=" + telefonoEmpleado + ", direccionEmpleado=" + direccionEmpleado + ", cargoEmpleado=" + cargoEmpleado + ", jornadaEmpleado=" + jornadaEmpleado + ", nombre_supervisor=" + nombre_supervisor + '}';
    }

    


}
