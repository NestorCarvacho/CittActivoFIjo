
package Modelo;

public class Empleado {
    private int idEmpleado;
    private String rutEmpleado;
    private String nombreEmpleado;
    private String telefonoEmpleado;
    private String direccionEmpleado;
    private TipoEmpleado cargoEmpleado;
    private Jornada jornadaEmpleado; 
    
    //Metodos Consturctores
    public Empleado() {
    }

    public Empleado(int idEmpleado, String rutEmpleado, String nombreEmpleado, String telefonoEmpleado, String direccionEmpleado, TipoEmpleado cargoEmpleado, Jornada jornadaEmpleado) {
        this.idEmpleado = idEmpleado;
        this.rutEmpleado = rutEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.telefonoEmpleado = telefonoEmpleado;
        this.direccionEmpleado = direccionEmpleado;
        this.cargoEmpleado = cargoEmpleado;
        this.jornadaEmpleado = jornadaEmpleado;
    }
    
    //Metodos Getters & Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }
    
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getRutEmpleado() {
        return rutEmpleado;
    }

    public void setRutEmpleado(String rutEmpleado) {    
        this.rutEmpleado = rutEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public TipoEmpleado getCargoEmpleado() {
        return cargoEmpleado;
    }

    public void setCargoEmpleado(TipoEmpleado cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }

    public Jornada getJornadaEmpleado() {
        return jornadaEmpleado;
    }

    
    public void setJornadaEmpleado(Jornada jornadaEmpleado) {
        this.jornadaEmpleado = jornadaEmpleado;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", rutEmpleado=" + rutEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", telefonoEmpleado=" + telefonoEmpleado + ", direccionEmpleado=" + direccionEmpleado + ", cargoEmpleado=" + cargoEmpleado + ", jornadaEmpleado=" + jornadaEmpleado + '}';
    }
    //Metodos Customer


}
