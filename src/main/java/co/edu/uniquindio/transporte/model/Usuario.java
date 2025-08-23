package co.edu.uniquindio.transporte.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int edad;
    public Usuario() {
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Edad: " + edad;
    }
}
