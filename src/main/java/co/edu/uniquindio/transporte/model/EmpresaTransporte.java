package co.edu.uniquindio.transporte.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EmpresaTransporte {
    private String nombre;

    private List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
    private List<VehiculoPasajero> listaVehiculosPasajeros = new ArrayList<>();
    private List<Propietario> listaPropietarios = new ArrayList<>();

    public EmpresaTransporte() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<VehiculoCarga> getListaVehiculosCarga() {
        return listaVehiculosCarga;
    }

    public void setListaVehiculosCarga(List<VehiculoCarga> listaVehiculosCarga) {
        this.listaVehiculosCarga = listaVehiculosCarga;
    }

    public List<VehiculoPasajero> getListaVehiculosPasajeros() {
        return listaVehiculosPasajeros;
    }

    public void setListaVehiculosPasajeros(List<VehiculoPasajero> listaVehiculosPasajeros) {
        this.listaVehiculosPasajeros = listaVehiculosPasajeros;
    }

    public List<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }

    public void setListaPropietarios(List<Propietario> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
    }

    public void crearPropietarioVehiculoCarga(String propietario, String vehiculo) {
        Propietario propietarioObj = new Propietario();
        propietarioObj.setNombre(propietario);
        VehiculoCarga vehiculoObj = new VehiculoCarga();
        vehiculoObj.setPlaca(vehiculo);
        propietarioObj.setVehiculo(vehiculoObj);
        listaPropietarios.add(propietarioObj);
    }

    public ArrayList listaDePropietariosPesados(double peso){
        ArrayList<Propietario> propietariosPesados = new ArrayList<>();
        for (VehiculoCarga v: listaVehiculosCarga) {
            if (peso > v.getCapacidadCarga()){
                System.out.println("la lista de propietarios que superan el peso de carga son: ");
                for (Propietario p: listaPropietarios){
                    System.out.println(p.getNombre() + "esta excedido, su capacidad de carga");
                    propietariosPesados.add(p);
                }
            } else {
                System.out.println("no hay propietarios excedidos");
            }
        }
        return propietariosPesados;
    }

    public static double ingresarPeso(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese el peso de carga");

        return scanner.nextDouble();
    }

    public void usuariosMovilizadosEnVehiculo(EmpresaTransporte empresa, String placa){
        for (VehiculoPasajero v: empresa.getListaVehiculosPasajeros()){
            if (Objects.equals(v.getPlaca(), placa)){
                System.out.println("El vehiculo con placa: " + placa + " Transporto " + v.getPasajerosTransportados() + " Pasajeros");
                return;
            }
        }
        System.out.println("No se encontró un vehículo con la placa " + placa);
    }

    public ArrayList propietariosMayores(){
        ArrayList<Propietario> propietariosMayores = new ArrayList<>();
        for (Propietario p: listaPropietarios){
            if (p.getEdad() > 40){
                propietariosMayores.add(p);
            }
        }

        System.out.println("Los propietarios mayores de 40 años son:");
        for (Propietario r: propietariosMayores){
            System.out.println(r.getNombre());
        }
        return propietariosMayores;
    }
}
