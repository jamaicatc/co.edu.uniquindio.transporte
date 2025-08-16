package co.edu.uniquindio.transporte;

import co.edu.uniquindio.transporte.factory.ModelFactory;
import co.edu.uniquindio.transporte.model.EmpresaTransporte;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        EmpresaTransporte empresaTransporte = modelFactory.inicializarDatos();
        crearPropietarioVehiculoCarga(modelFactory);
        calcularTotalPasajerosTransportados(empresaTransporte);
    }

    private static void calcularTotalPasajerosTransportados(EmpresaTransporte empresaTransporte) {

    }

    private static void crearPropietarioVehiculoCarga(ModelFactory modelFactory) {
        String propietario = "Pepe";
        String vehiculo = "ARM 2232";
        modelFactory.crearPropietarioVehiculoCarga(propietario, vehiculo);
    }
}