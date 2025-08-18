package co.edu.uniquindio.transporte.model;

import java.util.Scanner;

public class Vehiculo {
    private String placa;
    private String modelo;
    private String marca;
    private String color;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String modelo, String marca, String color) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    public void encender(){
        System.out.println("Encendiendo mi vehiculo");
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public static void seleccionarTipoVehiculo(EmpresaTransporte empresa, Propietario propietario){
        Scanner scanner = new Scanner(System.in);
        VehiculoCarga tipoVehiculoCarga = new VehiculoCarga();
        VehiculoPasajero tipoVehiculoPasajero = new VehiculoPasajero();
        System.out.println("Seleccione el tipo de vehiculo\n");
        System.out.println("1.Vehiculo de Carga 2.Vehiculo de Pasajeros");
        int respuesta = scanner.nextInt();
        scanner.nextLine();
        switch (respuesta){
            case 1:
                tipoVehiculoCarga.ingresarDatosVehiculoCarga(empresa, propietario);
                break;
            case 2:
                tipoVehiculoPasajero.ingresarDatosVehiculoPasajero(empresa, propietario);
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public static String buscarPlaca(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese la placa del vehiculo de pasajeros");

        return scanner.nextLine();
    }

}
