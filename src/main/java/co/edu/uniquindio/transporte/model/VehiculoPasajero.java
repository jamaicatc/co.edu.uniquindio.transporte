package co.edu.uniquindio.transporte.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiculoPasajero extends Vehiculo{
    private int numeroMaximoPasajeros;
    private int pasajerosTransportados;

    public VehiculoPasajero() {
    }

    public VehiculoPasajero(String placa, String modelo, String marca, String color, int numeroMaximoPasajeros) {
        super(placa, modelo, marca, color);
        this.numeroMaximoPasajeros = numeroMaximoPasajeros;
    }

    public int getNumeroMaximoPasajeros() {
        return numeroMaximoPasajeros;
    }

    public void setNumeroMaximoPasajeros(int numeroMaximoPasajeros) {
        this.numeroMaximoPasajeros = numeroMaximoPasajeros;
    }

    public int getPasajerosTransportados() {
        return pasajerosTransportados;
    }

    public void setPasajerosTransportados(int pasajerosTransportados) {
        this.pasajerosTransportados = pasajerosTransportados;
    }


    public VehiculoPasajero ingresarDatosVehiculoPasajero(EmpresaTransporte empresa, Propietario propietario){
        Scanner scanner = new Scanner(System.in);
        VehiculoPasajero vehiculoPasajero = new VehiculoPasajero();
        System.out.println("Ingrese la placa del Vehiculo de Pasajeros: ");
        vehiculoPasajero.setPlaca(scanner.nextLine());
        System.out.println("Ingrese el modelo del Vehiculo de Carga: ");
        vehiculoPasajero.setModelo(scanner.nextLine());
        System.out.println("Ingrese la marca del Vehiculo de Pasajeros: ");
        vehiculoPasajero.setMarca(scanner.nextLine());
        System.out.println("Ingrese el color del Vehiculo de Pasajeros: ");
        vehiculoPasajero.setColor(scanner.nextLine());
        System.out.println("Ingrese el numero maximo de pasajeros del Vehiculo de Pasajeros: ");
        vehiculoPasajero.setNumeroMaximoPasajeros(scanner.nextInt());
        empresa.getListaVehiculosPasajeros().add(vehiculoPasajero);
        propietario.setVehiculo(vehiculoPasajero);
        propietario.getListaVehiculosAsociados().add(vehiculoPasajero);

        return vehiculoPasajero;
    }


}
