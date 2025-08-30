package co.edu.uniquindio.transporte;

import co.edu.uniquindio.transporte.factory.ModelFactory;
import co.edu.uniquindio.transporte.model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        modelFactory.inicializarDatos();
        crudPropietario(modelFactory);
        crudVehiculo(modelFactory);
        crudUsuario(modelFactory);
        ejerciciosSolicitados(modelFactory);
    }

    //CRUD PROPIETARIO
    private static void crudPropietario(ModelFactory modelFactory){
        agregarPropietario();
        obtenerPropietario();
        actualizarPropietario();
        eliminarPropietario();
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
        int opcion = JOptionPane.showConfirmDialog(null, mensaje,"Ingresar Datos Propietario",JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION){
            Propietario datosPropietario = Propietario.builder()
                    .nombre(nombreField.getText())
                    .edad(Integer.parseInt(edadField.getText()))
                    .numeroIdentificacion(numeroIdentificacionField.getText())
                    .email(emailField.getText())
                    .numeroCelular(numeroCelularField.getText())
                    .build();
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
            PropietarioBuilder builder = Propietario.builder()
                    .nombre(propietario.getNombre())
                    .edad(propietario.getEdad())
                    .numeroIdentificacion(propietario.getNumeroIdentificacion())
                    .email(propietario.getEmail())
                    .numeroCelular(propietario.getNumeroCelular())
                    .vehiculo(propietario.getVehiculo());
            switch (seleccion){
                case "Nombre":
                    builder.nombre(JOptionPane.showInputDialog("Nuevo nombre:", propietario.getNombre()));
                    break;
                case "Edad":
                    builder.edad(Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:", propietario.getEdad())));
                    break;
                case "Email":
                    builder.email(JOptionPane.showInputDialog("Nuevo email:", propietario.getEmail()));
                    break;
                case "Teléfono":
                    builder.numeroCelular(JOptionPane.showInputDialog("Nuevo Teléfono:", propietario.getNumeroCelular()));
                    break;
            }
            Propietario propietarioActualizado = builder.build();
            boolean actualizado = ModelFactory.getInstance().actualizarPropietario(propietarioActualizado);
            if (actualizado){
                JOptionPane.showMessageDialog(null, "Propietario actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el propietario");
            }
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
        Vehiculo vehiculo = ModelFactory.getInstance().obtenerVehiculo(cedula);
        if (vehiculo != null) {
            JOptionPane.showMessageDialog(null, "Vehiculo encontrado:\n" + vehiculo.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la cedula perteneciente al vehiculo: " + cedula);
        }
    }

    private static void eliminarVehiculo(){
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del propietario para eliminar el vehiculo:");
        boolean borrado = ModelFactory.getInstance().eliminarVehiculo(cedula);
        if (borrado){
            JOptionPane.showMessageDialog(null, "Propietario eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el propietario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void actualizarVehiculo() {
        String[] opciones = {"Vehículo de Carga", "Vehículo de Pasajeros"};
        int eleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione el tipo de vehículo a actualizar",
                "Actualizar Vehículo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (eleccion == 0) {
            actualizarVehiculoCarga();
        } else if (eleccion == 1) {
            actualizarVehiculoPasajero();
        }
    }

    private static void actualizarVehiculoCarga() {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del propietario:");
        VehiculoCarga vehiculo = ModelFactory.getInstance().obtenerVehiculoCarga(cedula);

        if (vehiculo == null) {
            JOptionPane.showMessageDialog(null, "No se encontró un vehículo de carga para esa cédula");
            return;
        }

        String[] opciones = {"Placa", "Modelo", "Marca", "Color", "Capacidad de Carga", "Número de Ejes"};
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "¿Qué dato desea actualizar?",
                "Actualizar Vehículo de Carga",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (seleccion != null) {
            switch (seleccion) {
                case "Placa":
                    vehiculo.setPlaca(JOptionPane.showInputDialog("Nueva placa:"));
                    break;
                case "Modelo":
                    vehiculo.setModelo(JOptionPane.showInputDialog("Nuevo modelo:"));
                    break;
                case "Marca":
                    vehiculo.setMarca(JOptionPane.showInputDialog("Nueva marca:"));
                    break;
                case "Color":
                    vehiculo.setColor(JOptionPane.showInputDialog("Nuevo color:"));
                    break;
                case "Capacidad de Carga":
                    vehiculo.setCapacidadCarga(Double.parseDouble(JOptionPane.showInputDialog("Nueva capacidad:")));
                    break;
                case "Número de Ejes":
                    vehiculo.setNumeroEjes(Integer.parseInt(JOptionPane.showInputDialog("Nuevo número de ejes:")));
                    break;
            }
        }

        boolean actualizado = ModelFactory.getInstance().actualizarVehiculo(vehiculo);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Vehículo de carga actualizado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el vehículo de carga");
        }
    }

    private static void actualizarVehiculoPasajero() {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del propietario:");
        VehiculoPasajero vehiculo = ModelFactory.getInstance().obtenerVehiculoPasajero(cedula);

        if (vehiculo == null) {
            JOptionPane.showMessageDialog(null, "No se encontró un vehículo de carga para esa cédula");
            return;
        }

        String[] opciones = {"Placa", "Modelo", "Marca", "Color", "Numero maximo de pasajeros", "Numero de Pasajeros Transportados"};
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "¿Qué dato desea actualizar?",
                "Actualizar Vehículo Pasajero",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (seleccion != null) {
            switch (seleccion) {
                case "Placa":
                    vehiculo.setPlaca(JOptionPane.showInputDialog("Nueva placa:"));
                    break;
                case "Modelo":
                    vehiculo.setModelo(JOptionPane.showInputDialog("Nuevo modelo:"));
                    break;
                case "Marca":
                    vehiculo.setMarca(JOptionPane.showInputDialog("Nueva marca:"));
                    break;
                case "Color":
                    vehiculo.setColor(JOptionPane.showInputDialog("Nuevo color:"));
                    break;
                case "Numero maximo de pasajeros":
                    vehiculo.setNumeroMaximoPasajeros(Integer.parseInt(JOptionPane.showInputDialog("Nuevo numero maximo de pasajeros:")));
                    break;
                case "Numero de Pasajeros Transportados":
                    vehiculo.setPasajerosTransportados(Integer.parseInt(JOptionPane.showInputDialog("Nuevo número de pasajeros transportados:")));
                    break;
            }
        }

        boolean actualizado = ModelFactory.getInstance().actualizarVehiculo(vehiculo);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Vehículo de carga actualizado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el vehículo de carga");
        }
    }

    //CRUD USUARIO
    private static void crudUsuario(ModelFactory modelFactory){
        agregarUsuario();
        obtenerUsuario();
        eliminarUsuario();
        actualizarUsuario();
    }

    private static void agregarUsuario(){
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la edad del usuario"));
        Usuario datosUsuario = new Usuario();
        datosUsuario.setEdad(edad);
        boolean agregado = ModelFactory.getInstance().agregarUsuario(datosUsuario);
        if (agregado) {
            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un propietario con esa edad", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void obtenerUsuario(){
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la edad del usuario a buscar"));
        Usuario usuario = ModelFactory.getInstance().obtenerUsuario(edad);

        if (usuario != null) {
            JOptionPane.showMessageDialog(null, "Usuario encontrado:\n" + usuario.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un usuario con la edad: " + edad);
        }
    }
    private static void eliminarUsuario(){
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del usuario a eliminar:"));
        boolean borrado = ModelFactory.getInstance().eliminarUsuario(edad);
        if (borrado){
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void actualizarUsuario(){
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del Usuario a actualizar"));
        Usuario usuario = ModelFactory.getInstance().obtenerUsuario(edad);
        if (usuario == null){
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            return;
        }
        usuario.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Nueva edad: ")));
        boolean actualizado = ModelFactory.getInstance().actualizarUsuario(usuario);
        if (actualizado){
            JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el usuario");
        }
    }

    //Ejercicio solicitados
    private static void ejerciciosSolicitados(ModelFactory modelFactory){
        calcularTotalPasajerosTransportados();
        mostrarPropietariosPesados();
        mostrarUsuariosMovilizados();
        mostrarPropietariosMayores();
    }

    private static void calcularTotalPasajerosTransportados() {
        ModelFactory modelFactory = ModelFactory.getInstance();
        String placa = JOptionPane.showInputDialog("Ingrese la cedula del conductor: ");
        int numViajes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de viajes que hizo en el día"));
        int[] viajes = new int[numViajes];
        for (int i = 0; i < numViajes; i++) {
            viajes[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de pasajeros del viaje " + (i + 1)));
        }
        int total = modelFactory.calcularTotalPasajerosTransportados(placa, viajes);
        if (total == -1) {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado");
        } else {
            JOptionPane.showMessageDialog(null, "La cantidad total de pasajeros transportados es: " + total);
        }
    }

    private static void mostrarPropietariosPesados() {
        ModelFactory modelFactory = ModelFactory.getInstance();
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso de carga"));

        List<Propietario> propietariosPesados = modelFactory.listaDePropietariosPesados(peso);

        if (propietariosPesados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay propietarios excedidos.");
        } else {
            StringBuilder sb = new StringBuilder("Propietarios que exceden la capacidad:\n");
            for (Propietario p : propietariosPesados) {
                sb.append("- ").append(p.getNombre()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    private static void mostrarUsuariosMovilizados() {
        ModelFactory modelFactory = ModelFactory.getInstance();

        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo");
        String resultado = modelFactory.usuariosMovilizadosEnVehiculo(placa);

        JOptionPane.showMessageDialog(null, resultado);
    }


    private static void mostrarPropietariosMayores() {
        ModelFactory modelFactory = ModelFactory.getInstance();

        ArrayList<Propietario> propietariosMayores = modelFactory.propietariosMayores();

        if (propietariosMayores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay propietarios mayores de 40 años.");
        } else {
            StringBuilder sb = new StringBuilder("Propietarios mayores de 40 años:\n");
            for (Propietario p : propietariosMayores) {
                sb.append(p.getNombre()).append(" (").append(p.getEdad()).append(" años)\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}