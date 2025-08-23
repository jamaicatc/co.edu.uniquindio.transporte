package co.edu.uniquindio.transporte.model;

import java.util.ArrayList;
import java.util.List;

public class VehiculoPasajero extends Vehiculo{
    private int numeroMaximoPasajeros;
    private int pasajerosTransportados;
    private List<Usuario> listaUsuariosAsociados = new ArrayList<>();


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

    public List<Usuario> getListaUsuariosAsociados() {
        return listaUsuariosAsociados;
    }

    public void setListaUsuariosAsociados(List<Usuario> listaUsuariosAsociados) {
        this.listaUsuariosAsociados = listaUsuariosAsociados;
    }
}
