package co.edu.uniquindio.transporte.factory;

import co.edu.uniquindio.transporte.model.*;

import java.util.ArrayList;
import java.util.List;

public class ModelFactory {
    private static ModelFactory modelFactory;
    private EmpresaTransporte empresaTransporte;

    private ModelFactory() {
        empresaTransporte = new EmpresaTransporte();
    }

    public static ModelFactory getInstance() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    public EmpresaTransporte getEmpresaTransporte() {
        return empresaTransporte;
    }

    //CRUD PROPIETARIO

    public boolean agregarPropietario(Propietario propietario) {
        return empresaTransporte.agregarPropietario(propietario);
    }

    public Propietario obtenerPropietario(String cedula){
        return empresaTransporte.obtenerPropietario(cedula);
    }

    public boolean eliminarPropietario(String cedula){
        return empresaTransporte.eliminarPropietario(cedula);
    }

    public boolean actualizarPropietario(Propietario propietario){
        return empresaTransporte.actualizarPropietario(propietario);
    }

    //CRUD VEHICULO
    public boolean agregarVehiculo(String cedulaPropietario, Vehiculo vehiculo) {
        return empresaTransporte.agregarVehiculo(cedulaPropietario, vehiculo);
    }

    public Vehiculo obtenerVehiculo(String placa){
        return empresaTransporte.obtenerVehiculo(placa);
    }

    public VehiculoCarga obtenerVehiculoCarga(String cedula){
        return empresaTransporte.obtenerVehiculoCarga(cedula);
    }

    public VehiculoPasajero obtenerVehiculoPasajero(String cedula){
        return empresaTransporte.obtenerVehiculoPasajero(cedula);
    }


    public boolean eliminarVehiculo(String placa){
        return empresaTransporte.eliminarVehiculo(placa);
    }

    public boolean actualizarVehiculo(Vehiculo vehiculo){
        return empresaTransporte.actualizarVehiculo(vehiculo);
    }

    //CRUD USUARIO
    public boolean agregarUsuario(Usuario usuario){
        return empresaTransporte.agregarUsuario(usuario);
    };

    public Usuario obtenerUsuario(int edad){
        return  empresaTransporte.obtenerUsuario(edad);
    };

    public boolean eliminarUsuario(int edad){
        return empresaTransporte.eliminarUsuario(edad);
    };

    public boolean actualizarUsuario(Usuario usuario){
        return empresaTransporte.actualizarUsuario(usuario);
    };

}
