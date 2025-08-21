package co.edu.uniquindio.transporte.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiculoCarga extends Vehiculo{
    private double capacidadCarga;
    private int numeroEjes;

    public VehiculoCarga() {
    }

    public VehiculoCarga(String placa, String modelo, String marca, String color, double capacidadCarga) {
        super(placa, modelo, marca, color);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    @Override
    public void encender() {
        System.out.println("Endenciendo el vehiculo para cargarlo");
    }

    public VehiculoCarga ingresarDatosVehiculoCarga(EmpresaTransporte empresa, Propietario propietario){
        Scanner scanner = new Scanner(System.in);
        VehiculoCarga vehiculoCarga = new VehiculoCarga();
        System.out.println("Ingrese la placa del Vehiculo de Carga: ");
        vehiculoCarga.setPlaca(scanner.nextLine());
        System.out.println("Ingrese el modelo del Vehiculo de Carga: ");
        vehiculoCarga.setModelo(scanner.nextLine());
        System.out.println("Ingrese la marca del Vehiculo de Carga: ");
        vehiculoCarga.setMarca(scanner.nextLine());
        System.out.println("Ingrese el color del Vehiculo de Carga: ");
        vehiculoCarga.setColor(scanner.nextLine());
        System.out.println("Ingrese la capacidad del Vehiculo de Carga: ");
        vehiculoCarga.setCapacidadCarga(scanner.nextInt());
        System.out.println("Ingrese el numero de ejes del vehiculo Carga: ");
        vehiculoCarga.setNumeroEjes(scanner.nextInt());
        empresa.getListaVehiculosCarga().add(vehiculoCarga);
        propietario.setVehiculo(vehiculoCarga);
        propietario.getListaVehiculosAsociados().add(vehiculoCarga);

        return vehiculoCarga;
    }

}
