package act09;

import java.io.Serializable;

//Warning: [serial] serializable class old_Persona has no definition of serialVersionUID
//@SuppressWarnings("serial")     // <-- Solución 2

public class old_Persona implements Serializable {

    //Solución 1 al warning
    //private static final long serialVersionUID = 1L;

    private String nombre;
    private String dni;
    private int edad;

    public old_Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
