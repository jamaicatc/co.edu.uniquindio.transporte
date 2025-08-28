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

    EmpresaTransporte ownedByEmpresaTransporte;

    public Propietario() {
    }

    private Propietario(Builder builder) {
        this.nombre = builder.nombre;
        this.edad= builder.edad;
        this.numeroIdentificacion= builder.numeroIdentificacion;
        this.email= builder.email;
        this.vehiculo= builder.vehiculo;
        if (builder.listaVehiculosAsociados != null) {
            this.listaVehiculosAsociados = builder.listaVehiculosAsociados;
        }
        this.ownedByEmpresaTransporte = builder.ownedByEmpresaTransporte;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String nombre;
        private int edad;
        private String numeroIdentificacion;
        private String email;
        private String numeroCelular;
        private Vehiculo vehiculo;
        private List<Vehiculo> listaVehiculosAsociados = new ArrayList<>();
        private EmpresaTransporte ownedByEmpresaTransporte;

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }
        public Builder edad(int edad){
            this.edad = edad;
            return this;

        }
        public Builder numeroIdentificacion(String numeroIdentificacion){
            this.numeroIdentificacion = numeroIdentificacion;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder numeroCelular(String numeroCelular){
            this.numeroCelular = numeroCelular;
            return this;
        }
        public Builder vehiculo(Vehiculo vehiculo){
            this.vehiculo = vehiculo;
            return this;
        }
        public Builder listaVehiculosAsociados(List<Vehiculo> vehiculos){
            this.listaVehiculosAsociados = vehiculos;
            return this;
        }
        public Builder ownedByEmpresaTransporte(EmpresaTransporte ownedByEmpresaTransporte){
            this.ownedByEmpresaTransporte = ownedByEmpresaTransporte;
            return this;
        }
        public Propietario build() {
            if (nombre == null || numeroIdentificacion == null) {
                throw new IllegalArgumentException("El nombre y la identificación deben ser obligatorias");
            }
            if (edad < 18) {
                throw new IllegalArgumentException("El propietario debe ser mayor de edad");
            }

            return new Propietario(this);
        }
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

    public EmpresaTransporte getOwnedByEmpresaTransporte() {
        return ownedByEmpresaTransporte;
    }

    // Setters (opcionales, puedes mantenerlos o eliminarlos según necesites)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setListaVehiculosAsociados(List<Vehiculo> listaVehiculosAsociados) {
        this.listaVehiculosAsociados = listaVehiculosAsociados;
    }

    public void setOwnedByEmpresaTransporte(EmpresaTransporte ownedByEmpresaTransporte) {
        this.ownedByEmpresaTransporte = ownedByEmpresaTransporte;
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
