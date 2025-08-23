package co.edu.uniquindio.transporte.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmpresaTransporte {
    private String nombre;

    private List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
    private List<VehiculoPasajero> listaVehiculosPasajeros = new ArrayList<>();
    private List<Propietario> listaPropietarios = new ArrayList<>();
    private List<Usuario> listaUsuarios = new ArrayList<>();

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

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    //CRUD PROPIETARIO
    public boolean agregarPropietario(Propietario propietario){
        for(Propietario p: listaPropietarios){
            if(p.getNumeroIdentificacion().equals(propietario.getNumeroIdentificacion()));{
                return false;
            }
        }
        listaPropietarios.add(propietario);
        return true;
    }

    public Propietario obtenerPropietario(String cedula){
        for (Propietario p : listaPropietarios) {
            if (p.getNumeroIdentificacion().equals(cedula)) {
                return p;
            }
        }
        return null;
    }

    public boolean eliminarPropietario(String cedula){
        Propietario p = obtenerPropietario(cedula);
        if (p != null){
            listaPropietarios.remove(p);
            return true;
        }
        return false;
    }

    public boolean actualizarPropietario(Propietario propietarioActualizado){
        Propietario existente = obtenerPropietario(propietarioActualizado.getNumeroIdentificacion());
        if (existente != null){
            existente.setNombre(propietarioActualizado.getNombre());
            existente.setEdad(propietarioActualizado.getEdad());
            existente.setEmail(propietarioActualizado.getEmail());
            existente.setNumeroCelular(propietarioActualizado.getNumeroCelular());
            return true;
        }
        return false;
    }

    //CRUD VEHICULO
    public boolean agregarVehiculo(String cedulaPropietario, Vehiculo vehiculo){
        Propietario propietario = obtenerPropietario(cedulaPropietario);
        if (propietario == null) {
            return false;
        }
        vehiculo.setPropietario(propietario);
        if (vehiculo instanceof VehiculoCarga) {
            listaVehiculosCarga.add((VehiculoCarga) vehiculo);
            propietario.getListaVehiculosAsociados().add(vehiculo);
        } else if (vehiculo instanceof VehiculoPasajero) {
            listaVehiculosPasajeros.add((VehiculoPasajero) vehiculo);
            propietario.getListaVehiculosAsociados().add(vehiculo);
        }

        return true;
    }
    public Vehiculo obtenerVehiculo(String cedula){
        for (VehiculoCarga v : listaVehiculosCarga) {
            if (v.getPropietario().getNumeroIdentificacion().equals(cedula)) {
                return v;
            }
        }

        for (VehiculoPasajero v : listaVehiculosPasajeros) {
            if (v.getPropietario().getNumeroIdentificacion().equals(cedula)) {
                return v;
            }
        }
        return null;
    }

    public VehiculoCarga obtenerVehiculoCarga(String cedula) {
        for (VehiculoCarga v : listaVehiculosCarga) {
            if (v.getPropietario().getNumeroIdentificacion().equals(cedula)) {
                return v;
            }
        }
        return null;
    }

    public VehiculoPasajero obtenerVehiculoPasajero(String cedula) {
        for (VehiculoPasajero v : listaVehiculosPasajeros) {
            if (v.getPropietario().getNumeroIdentificacion().equals(cedula)) {
                return v;
            }
        }
        return null;
    }

    public boolean eliminarVehiculo(String placa){
        Vehiculo v = obtenerVehiculo(placa);
        if (v != null){
            if (v instanceof VehiculoCarga){
                listaVehiculosCarga.remove(v);
                return true;
            } else if (v instanceof  VehiculoPasajero) {
                listaVehiculosPasajeros.remove(v);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarVehiculo(Vehiculo vehiculoActualizado){
        Vehiculo existente = obtenerVehiculo(vehiculoActualizado.getPropietario().getNumeroIdentificacion());
        if (existente != null) {
            if (existente instanceof VehiculoCarga && vehiculoActualizado instanceof VehiculoCarga) {
                VehiculoCarga existenteCarga = (VehiculoCarga) existente;
                VehiculoCarga actualizadoCarga = (VehiculoCarga) vehiculoActualizado;
                existenteCarga.setPlaca(actualizadoCarga.getPlaca());
                existenteCarga.setModelo(actualizadoCarga.getModelo());
                existenteCarga.setMarca(actualizadoCarga.getMarca());
                existenteCarga.setColor(actualizadoCarga.getColor());
                existenteCarga.setCapacidadCarga(actualizadoCarga.getCapacidadCarga());
                existenteCarga.setNumeroEjes(actualizadoCarga.getNumeroEjes());

                return true;
            } else if (existente instanceof VehiculoPasajero && vehiculoActualizado instanceof VehiculoPasajero) {
                VehiculoPasajero existentePasajero = (VehiculoPasajero) existente;
                VehiculoPasajero actualizadoPasajero = (VehiculoPasajero) vehiculoActualizado;
                existentePasajero.setPlaca(actualizadoPasajero.getPlaca());
                existentePasajero.setModelo(actualizadoPasajero.getModelo());
                existentePasajero.setMarca(actualizadoPasajero.getMarca());
                existentePasajero.setColor(actualizadoPasajero.getColor());
                existentePasajero.setNumeroMaximoPasajeros(actualizadoPasajero.getNumeroMaximoPasajeros());
                existentePasajero.setPasajerosTransportados(actualizadoPasajero.getPasajerosTransportados());

                return true;
            }
        }
        return false;
    }

    //CRUD USUARIO
    public boolean agregarUsuario(Usuario usuario){
        for(Usuario u: listaUsuarios){
            if(u.getEdad() == usuario.getEdad());{
                return false;
            }
        }
        listaUsuarios.add(usuario);
        return true;
    }

    public Usuario obtenerUsuario(int edad){
        for (Usuario u : listaUsuarios) {
            if (u.getEdad() == edad) {
                return u;
            }
        }
        return null;
    }

    public boolean eliminarUsuario(int edad){
        Usuario u = obtenerUsuario(edad);
        if (u != null){
            listaUsuarios.remove(u);
            return true;
        }
        return false;
    };

    public boolean actualizarUsuario(Usuario usuarioActualizado){
        Usuario existente = obtenerUsuario(usuarioActualizado.getEdad());
        if (existente != null){
            existente.setEdad(usuarioActualizado.getEdad());
            return true;
        }
        return false;
    };

    //Ejercicio solicitados
    public int calcularTotalPasajerosTransportados(String cedula, int[] numviajes){
        VehiculoPasajero vehiculo = obtenerVehiculoPasajero(cedula);
        if (vehiculo == null) {
            return -1;
        }
        int suma = 0;
        for (int pasajeros : numviajes) {
            suma += pasajeros;
        }
        vehiculo.setPasajerosTransportados(suma);
        return suma;
    }

    public List<Propietario> listaDePropietariosPesados(double peso) {
        List<Propietario> propietariosPesados = new ArrayList<>();
        for (VehiculoCarga v : listaVehiculosCarga) {
            if (peso > v.getCapacidadCarga()) {
                Propietario p = v.getPropietario();
                if (p != null && !propietariosPesados.contains(p)) {
                    propietariosPesados.add(p);
                }
            }
        }
        return propietariosPesados;
    }

    public String usuariosMovilizadosEnVehiculo(String placa) {
        for (VehiculoPasajero v : listaVehiculosPasajeros) {
            if (Objects.equals(v.getPlaca(), placa)) {
                return "El vehículo con placa " + placa + " transportó " + v.getPasajerosTransportados() + " pasajeros.";
            }
        }
        return "No se encontró un vehículo con la placa " + placa;
    }

    public ArrayList<Propietario> propietariosMayores() {
        ArrayList<Propietario> propietariosMayores = new ArrayList<>();
        for (Propietario p : listaPropietarios) {
            if (p.getEdad() > 40) {
                propietariosMayores.add(p);
            }
        }
        return propietariosMayores;
    }
}