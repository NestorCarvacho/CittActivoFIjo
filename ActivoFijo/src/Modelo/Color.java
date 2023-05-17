package Modelo;

public class Color {

    //private es para que solo puedan ser usadas dentro de la clase
    //int = number/numeric/etc...
    private int IdColor;
    //String = Varchar => se debe colocar la S en mayúscola para que pueda se usada en Netbeans
    private String nombreColor;

    //se crean los metodos para poder ocupar la clase
    //Constructor sin Parametros
    //click secundario > insert code > Constructor > sin seleccionar > generate
    public Color() {
    }

    //Constructor con Parametros
    //click secundario > insert code > Constructor > seleccionar todo > generate
    public Color(int IdColor, String nombreColor) {
        this.IdColor = IdColor;
        this.nombreColor = nombreColor;
    }

    //crear Getters and Setter
    //click secundario > insert code > Getters and Setter > seleccionar todo > generate
    public int getIdColor() {
        return IdColor;
    }

    public void setIdColor(int IdColor) {
        this.IdColor = IdColor;
    }

    public String getNombreColor() {
        return nombreColor;
    }

    public void setNombreColor(String nombreColor) {
        this.nombreColor = nombreColor;
    }

    //crear toString
    //click secundario > insert code > toString()... > seleccionar todo > generate
    @Override
    public String toString() {
        return "Color{" + "IdColor=" + IdColor + ", nombreColor=" + nombreColor + '}';
    }
}
