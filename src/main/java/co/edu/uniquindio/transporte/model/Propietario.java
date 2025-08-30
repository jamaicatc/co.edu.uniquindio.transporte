package co.edu.uniquindio.transporte.model;

import jdk.security.jarsigner.JarSigner;

import java.util.ArrayList;
import java.util.List;


public class Propietario {
    private String nombre;
    private int edad;
    private String numeroIdentificacion;
    private String email;
    private String numeroCelular;
    private Vehiculo vehiculo;
    private List<Vehiculo> listaVehiculosAsociados = new ArrayList<>();

    public Propietario(String nombre, int edad, String numeroIdentificacion, String email, String numeroCelular, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroIdentificacion = numeroIdentificacion;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.vehiculo = vehiculo;
    }

    public static PropietarioBuilder builder(){
        return new PropietarioBuilder();
    }
    public String getNombre() {
        return nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public List<Vehiculo> getListaVehiculosAsociados() {
        return listaVehiculosAsociados;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Edad: " + edad + "\n" +
                "Numero de Identificación: " + numeroIdentificacion + "\n" +
                "Email: " + email + '\n' +
                "Numero de Celular: " + numeroCelular;
    }
}
