package co.edu.uniquindio.transporte.model;


public class PropietarioBuilder {
    protected String nombre;
    protected int edad;
    protected String numeroIdentificacion;
    protected String email;
    protected String numeroCelular;
    protected Vehiculo vehiculo;

    public PropietarioBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public PropietarioBuilder edad(int edad){
        this.edad = edad;
        return this;
    }

    public PropietarioBuilder numeroIdentificacion(String numeroIdentificacion){
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public PropietarioBuilder email(String email){
        this.email = email;
        return this;
    }

    public PropietarioBuilder numeroCelular(String numeroCelular){
        this.numeroCelular = numeroCelular;
        return this;
    }

    public PropietarioBuilder vehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
        return this;
    }

    public Propietario build() {
        return new Propietario(nombre, edad, numeroIdentificacion, email, numeroCelular, vehiculo);
    }

}
