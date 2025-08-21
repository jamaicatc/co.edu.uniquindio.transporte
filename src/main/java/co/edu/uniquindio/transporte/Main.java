package co.edu.uniquindio.transporte;

import co.edu.uniquindio.transporte.factory.ModelFactory;
import co.edu.uniquindio.transporte.model.*;

import javax.swing.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        crudPropietario(modelFactory);
        crudVehiculo(modelFactory);
    }

    //CRUD PROPIETARIO
    private static void crudPropietario(ModelFactory modelFactory){
        agregarPropietario();
        obtenerPropietario();
        eliminarPropietario();
        actualizarPropietario();
    }

    private static void agregarPropietario(){
        JTextField nombreField = new JTextField();
        JTextField edadField = new JTextField();
        JTextField numeroIdentificacionField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField numeroCelularField = new JTextField();
        Object[] mensaje = {
                "Nombre:", nombreField,
                "Edad:", edadField,
                "Cedula:", numeroIdentificacionField,
                "Email:", emailField,
                "Telefono:", numeroCelularField
        };
        int opcion = JOptionPane.showConfirmDialog(null, mensaje,"ingresar Datos",JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION){
            Propietario datosPropietario = new Propietario();
            datosPropietario.setNombre(nombreField.getText());
            datosPropietario.setEdad(Integer.parseInt(edadField.getText()));
            datosPropietario.setNumeroIdentificacion(numeroIdentificacionField.getText());
            datosPropietario.setEmail(emailField.getText());
            datosPropietario.setNumeroCelular(numeroCelularField.getText());
            boolean agregado = ModelFactory.getInstance().agregarPropietario(datosPropietario);
            if (agregado) {
                JOptionPane.showMessageDialog(null, "Propietario agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un propietario con esa cédula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void obtenerPropietario(){
        String cedula = JOptionPane.showInputDialog(null, "Buscar Propietario por cedula:");
        Propietario propietario = ModelFactory.getInstance().obtenerPropietario(cedula);
        if (propietario != null) {
            JOptionPane.showMessageDialog(null, "Propietario encontrado:\n" + propietario.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un propietario con la cédula: " + cedula);
        }
    }

    private static void eliminarPropietario(){
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del propietario a eliminar:");
        boolean borrado = ModelFactory.getInstance().eliminarPropietario(cedula);
        if (borrado){
            JOptionPane.showMessageDialog(null, "Propietario eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el propietario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void actualizarPropietario(){
        String cedula = JOptionPane.showInputDialog("Ingrese la cedula del propietario a actualizar");
        Propietario propietario = ModelFactory.getInstance().obtenerPropietario(cedula);
        if (propietario == null){
            JOptionPane.showMessageDialog(null, "Propietario no encontrado");
            return;
        }
        String[] opciones = {"Nombre", "Edad", "Email", "Teléfono"};
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "¿Que dato desea actualizar?",
                "Actualizar Propietario",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        if(seleccion != null){
            switch (seleccion){
                case "Nombre":
                    propietario.setNombre(JOptionPane.showInputDialog("Nuevo nombre:"));
                    break;
                case "Edad":
                    propietario.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:")));
                    break;
                case "Email":
                    propietario.setEmail(JOptionPane.showInputDialog("Nuevo email:"));
                    break;
                case "Teléfono":
                    propietario.setNumeroCelular(JOptionPane.showInputDialog("Nuevo Teléfono:"));
                    break;
            }
        }
        boolean actualizado = ModelFactory.getInstance().actualizarPropietario(propietario);
        if (actualizado){
            JOptionPane.showMessageDialog(null, "Propietario actualizado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el propietario");
        }
    }

    //CRUD VEHICULO
    private static void crudVehiculo(ModelFactory modelFactory){
        agregarVehiculo();
        obtenerVehiculo();
        eliminarVehiculo();
        actualizarVehiculo();
    }

    private static void agregarVehiculo() {
        String[] opciones = {"Vehículo de Carga", "Vehículo de Pasajeros"};
        int eleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione el tipo de vehículo",
                "Tipo de Vehículo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        Vehiculo vehiculo = null;
        if (eleccion == 0) {
            vehiculo = agregarVehiculoCarga();
        } else if (eleccion == 1) {
            vehiculo = agregarVehiculoPasajero();
        }

    }

    private static Vehiculo agregarVehiculoCarga(){
        JTextField placaField = new JTextField();
        JTextField modeloField = new JTextField();
        JTextField marcaField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField capacidadCargaField = new JTextField();
        JTextField numeroEjesField = new JTextField();
        Object[] mensaje = {
                "Placa:", placaField,
                "Modelo:", modeloField,
                "Marca:", marcaField,
                "Color", colorField,
                "Capacidad de Carga:", capacidadCargaField,
                "Numero de ejes:", numeroEjesField
        };
        VehiculoCarga datosVehiculo = new VehiculoCarga();
        int opcion = JOptionPane.showConfirmDialog(null, mensaje,"ingresar Datos",JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION){
            datosVehiculo.setPlaca(placaField.getText());
            datosVehiculo.setModelo(modeloField.getText());
            datosVehiculo.setMarca(marcaField.getText());
            datosVehiculo.setColor(colorField.getText());
            datosVehiculo.setCapacidadCarga(Double.parseDouble(capacidadCargaField.getText()));
            datosVehiculo.setNumeroEjes(Integer.parseInt(numeroEjesField.getText()));
            String cedulaPropietario = JOptionPane.showInputDialog(null, "Ingrese la cedula del propietario");
            boolean agregado = ModelFactory.getInstance().agregarVehiculo(cedulaPropietario, datosVehiculo);
            if (agregado) {
                JOptionPane.showMessageDialog(null, "Vehiculo asignado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro un propietario con esa cédula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return datosVehiculo;
    }
    private static Vehiculo agregarVehiculoPasajero(){
        JTextField placaField = new JTextField();
        JTextField modeloField = new JTextField();
        JTextField marcaField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField numeroMaximoPasajerosField = new JTextField();
        JTextField pasajerosTransportadosField = new JTextField();
        Object[] mensaje = {
                "Placa:", placaField,
                "Modelo:", modeloField,
                "Marca:", marcaField,
                "Color", colorField,
                "Número maximo de pasajeros:", numeroMaximoPasajerosField,
                "Numero de pasajeros transportados:", pasajerosTransportadosField
        };
        VehiculoPasajero datosVehiculo = new VehiculoPasajero();
        int opcion = JOptionPane.showConfirmDialog(null, mensaje,"ingresar Datos",JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION){
            datosVehiculo.setPlaca(placaField.getText());
            datosVehiculo.setModelo(modeloField.getText());
            datosVehiculo.setMarca(marcaField.getText());
            datosVehiculo.setColor(colorField.getText());
            datosVehiculo.setNumeroMaximoPasajeros(Integer.parseInt(numeroMaximoPasajerosField.getText()));
            datosVehiculo.setPasajerosTransportados(Integer.parseInt(pasajerosTransportadosField.getText()));
            String cedulaPropietario = JOptionPane.showInputDialog(null, "Ingrese la cedula del propietario");
            boolean agregado = ModelFactory.getInstance().agregarVehiculo(cedulaPropietario, datosVehiculo);
            if (agregado) {
                JOptionPane.showMessageDialog(null, "Vehiculo asignado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro un propietario con esa cédula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return datosVehiculo;
    }

    private static void obtenerVehiculo(){
        String cedula = JOptionPane.showInputDialog(null, "Buscar Propietario por cedula:");
        Propietario propietario = ModelFactory.getInstance().obtenerPropietario(cedula);
        if (propietario != null) {
            JOptionPane.showMessageDialog(null, "Propietario encontrado:\n" + propietario.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un propietario con la cédula: " + cedula);
        }
    }

    private static void eliminarVehiculo(){
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del propietario a eliminar:");
        boolean borrado = ModelFactory.getInstance().eliminarPropietario(cedula);
        if (borrado){
            JOptionPane.showMessageDialog(null, "Propietario eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el propietario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void actualizarVehiculo(){
        String cedula = JOptionPane.showInputDialog("Ingrese la cedula del propietario a actualizar");
        Propietario propietario = ModelFactory.getInstance().obtenerPropietario(cedula);
        if (propietario == null){
            JOptionPane.showMessageDialog(null, "Propietario no encontrado");
            return;
        }
        String[] opciones = {"Nombre", "Edad", "Email", "Teléfono"};
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "¿Que dato desea actualizar?",
                "Actualizar Propietario",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        if(seleccion != null){
            switch (seleccion){
                case "Nombre":
                    propietario.setNombre(JOptionPane.showInputDialog("Nuevo nombre:"));
                    break;
                case "Edad":
                    propietario.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:")));
                    break;
                case "Email":
                    propietario.setEmail(JOptionPane.showInputDialog("Nuevo email:"));
                    break;
                case "Teléfono":
                    propietario.setNumeroCelular(JOptionPane.showInputDialog("Nuevo Teléfono:"));
                    break;
            }
        }
        boolean actualizado = ModelFactory.getInstance().actualizarPropietario(propietario);
        if (actualizado){
            JOptionPane.showMessageDialog(null, "Propietario actualizado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el propietario");
        }
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

}