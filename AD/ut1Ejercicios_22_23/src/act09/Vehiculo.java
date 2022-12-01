package act09;

import java.io.Serializable;

/**
 *
 * @author JuanLuis
 */
public class Vehiculo implements Serializable {

    private String marca;
    private String modelo;
    private int anio;
    private String color;
    private boolean metalizada;

    public Vehiculo(String marca, String modelo, int anio, String color, boolean metalizada) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.metalizada = metalizada;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isMetalizada() {
        return metalizada;
    }
    public void setMetalizada(boolean metalizada) {
        this.metalizada = metalizada;
    }

    @Override
    public String toString() {
        return "Marca=" + marca + ", modelo=" + modelo + ", color=" + color;
    }

}
