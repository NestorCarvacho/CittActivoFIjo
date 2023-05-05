
package Modelo;

import Enumeradores.EnumEstadoProducto;
import Enumeradores.EnumTipoProducto;
import java.util.Date;


public class Producto {
    //Atributos
    private int numActivoProducto;
    private int numSerieProducto;
    private String descProducto;
    private EnumTipoProducto tipoProducto;
    private Date fechaAsignacionProducto;
    private Empleado ultimaActualizacionProducto;
    private Date fechaLlegadaProducto;
    private int stockProducto;
    private EnumEstadoProducto estadoProducto;
    private Ubicacion ubicacionProducto;
    private String colorProducto;
    private String contNetoProducto;
    private int costoProducto;

    //Metodos Constructores
    public Producto() {
    }

    public Producto(int numActivoProducto, int numSerieProducto, String descProducto, EnumTipoProducto tipoProducto, Date fechaAsignacionProducto, Empleado ultimaActualizacionProducto, Date fechaLlegadaProducto, int stockProducto, EnumEstadoProducto estadoProducto, Ubicacion ubicacionProducto, String colorProducto, String contNetoProducto, int costoProducto) {
        this.numActivoProducto = numActivoProducto;
        this.numSerieProducto = numSerieProducto;
        this.descProducto = descProducto;
        this.tipoProducto = tipoProducto;
        this.fechaAsignacionProducto = fechaAsignacionProducto;
        this.ultimaActualizacionProducto = ultimaActualizacionProducto;
        this.fechaLlegadaProducto = fechaLlegadaProducto;
        this.stockProducto = stockProducto;
        this.estadoProducto = estadoProducto;
        this.ubicacionProducto = ubicacionProducto;
        this.colorProducto = colorProducto;
        this.contNetoProducto = contNetoProducto;
        this.costoProducto = costoProducto;
    }

    //Metodos Getters & Setters
    public int getNumActivoProducto() {
        return numActivoProducto;
    }

    public void setNumActivoProducto(int numActivoProducto) {
        this.numActivoProducto = numActivoProducto;
    }

    public int getNumSerieProducto() {
        return numSerieProducto;
    }

    public void setNumSerieProducto(int numSerieProducto) {
        this.numSerieProducto = numSerieProducto;
    }

    public String getDescProducto() {
        return descProducto;
    }

    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    public EnumTipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(EnumTipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Date getFechaAsignacionProducto() {
        return fechaAsignacionProducto;
    }

    public void setFechaAsignacionProducto(Date fechaAsignacionProducto) {
        this.fechaAsignacionProducto = fechaAsignacionProducto;
    }

    public Empleado getUltimaActualizacionProducto() {
        return ultimaActualizacionProducto;
    }

    public void setUltimaActualizacionProducto(Empleado ultimaActualizacionProducto) {
        this.ultimaActualizacionProducto = ultimaActualizacionProducto;
    }

    public Date getFechaLlegadaProducto() {
        return fechaLlegadaProducto;
    }

    public void setFechaLlegadaProducto(Date fechaLlegadaProducto) {
        this.fechaLlegadaProducto = fechaLlegadaProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public EnumEstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EnumEstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public Ubicacion getUbicacionProducto() {
        return ubicacionProducto;
    }

    public void setUbicacionProducto(Ubicacion ubicacionProducto) {
        this.ubicacionProducto = ubicacionProducto;
    }

    
    public String getColorProducto() {
        return colorProducto;
    }

    public void setColorProducto(String colorProducto) {
        this.colorProducto = colorProducto;
    }

    public String getContNetoProducto() {
        return contNetoProducto;
    }

    public void setContNetoProducto(String contNetoProducto) {
        this.contNetoProducto = contNetoProducto;
    }

    public int getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(int costoProducto) {
        this.costoProducto = costoProducto;
    }
    
    //Metodo toString
    @Override
    public String toString() {
        return "Producto{" + "numActivoProducto=" + numActivoProducto + ", numSerieProducto=" +
                numSerieProducto + ", descProducto=" + descProducto + ", tipoProducto=" + tipoProducto +
                ", fechaAsignacionProducto=" + fechaAsignacionProducto + ", ultimaActualizacionProducto=" +
                ultimaActualizacionProducto + ", fechaLlegadaProducto=" + fechaLlegadaProducto +
                ", stockProducto=" + stockProducto + ", estadoProducto=" + estadoProducto + ", ubicacionProducto=" + ubicacionProducto + ", colorProducto=" +
                colorProducto + ", contNetoProducto=" + contNetoProducto + ", costoProducto=" + costoProducto + '}';
    }
    
    //Metodos Customer
}
