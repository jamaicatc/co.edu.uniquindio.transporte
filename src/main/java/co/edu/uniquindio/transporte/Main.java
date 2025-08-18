package co.edu.uniquindio.transporte;

import co.edu.uniquindio.transporte.factory.ModelFactory;
import co.edu.uniquindio.transporte.model.*;

import java.util.Objects;
import java.util.Scanner;

import static co.edu.uniquindio.transporte.model.EmpresaTransporte.ingresarPeso;
import static co.edu.uniquindio.transporte.model.Vehiculo.buscarPlaca;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        EmpresaTransporte empresaTransporte = modelFactory.inicializarDatos();
        crearPropietarioVehiculoCarga(modelFactory);
        Propietario p = Propietario.ingresarDatosPropietario(empresaTransporte);
        Vehiculo.seleccionarTipoVehiculo(empresaTransporte, p);
        calcularTotalPasajerosTransportados(empresaTransporte, buscarPlaca());
        empresaTransporte.listaDePropietariosPesados(ingresarPeso());
        empresaTransporte.usuariosMovilizadosEnVehiculo(empresaTransporte, buscarPlaca());
        empresaTransporte.propietariosMayores();
    }

    private static int calcularTotalPasajerosTransportados(EmpresaTransporte empresaTransporte, String placa) {
        Scanner scanner = new Scanner(System.in);
        int suma = 0;
        for (VehiculoPasajero v: empresaTransporte.getListaVehiculosPasajeros()){
            if (Objects.equals(v.getPlaca(), placa)){
                System.out.println("Ingrese el numero de viajes que hizo en el dia");
                int numViajes = scanner.nextInt();
                for (int i = 1; i <= numViajes; i++) {
                    System.out.println("Ingrese la cantidad de pasajeros del viaje " + i);
                    int cantidadPasajeros = scanner.nextInt();
                    suma += cantidadPasajeros;
                }
                v.setPasajerosTransportados(suma);
                System.out.println("la cantidad de pasajeros del dia fue: " + suma);
            }
        }
        return suma;
    }

    private static void crearPropietarioVehiculoCarga(ModelFactory modelFactory) {
        String propietario = "Pepe";
        String vehiculo = "ARM 2232";
        modelFactory.crearPropietarioVehiculoCarga(propietario, vehiculo);
    }
}