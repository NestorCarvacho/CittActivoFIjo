package Modelo;

public class TipoMovimiento {

    //private es para que solo puedan ser usadas dentro de la clase
    //int = number/numeric/etc...
    private int IdTipoMovimiento;
    //String = Varchar => se debe colocar la S en mayúscola para que pueda se usada en Netbeans
    private String nombreTipoMovimiento;

    //se crean los metodos para poder ocupar la clase
    //Constructor sin Parametros
    //click secundario > insert code > Constructor > sin seleccionar > generate
    public TipoMovimiento() {
    }

    //Constructor con Parametros
    //click secundario > insert code > Constructor > seleccionar todo > generate
    public TipoMovimiento(int IdColor, String nombreColor) {
        this.IdTipoMovimiento = IdColor;
        this.nombreTipoMovimiento = nombreColor;
    }

    //crear Getters and Setter
    //click secundario > insert code > Getters and Setter > seleccionar todo > generate
    public int getIdTipoMovimiento() {
        return IdTipoMovimiento;
    }

    public void setIdTipoMovimiento(int IdTipoMovimiento) {
        this.IdTipoMovimiento = IdTipoMovimiento;
    }

    public String getNombreTipoMovimiento() {
        return nombreTipoMovimiento;
    }

    public void setNombreTipoMovimiento(String nombreTipoMovimiento) {
        this.nombreTipoMovimiento = nombreTipoMovimiento;
    }

    //crear toString
    //click secundario > insert code > toString()... > seleccionar todo > generate
    @Override
    public String toString() {
        return "tipo_movimiento{" + "Idtipo_movimiento=" + IdTipoMovimiento + ", nombretipo_movimiento=" + nombreTipoMovimiento + '}';
    }
}
