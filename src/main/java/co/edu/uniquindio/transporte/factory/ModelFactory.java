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

//    public Propietario obtenerVehiculo(String placa){
//        return empresaTransporte.obtenerVehiculo(placa);
//    }
//
//    public boolean eliminarVehiculo(String placa){
//        return empresaTransporte.eliminarVehiculo(placa);
//    }
//
//    public boolean actualizarVehiculo(Vehiculo vehiculo){
//        return empresaTransporte.actualizarVehiculo(vehiculo);
//    }

}
