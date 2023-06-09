package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import java.util.List;
import java.util.Scanner;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class VistaTexto extends Vista {
    private Scanner scanner;

    public void comenzar() {
        scanner = new Scanner(System.in);
        mostrarMenu();

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer la opción

        while (opcion != 7) {
            ejecutar(opcion);

            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
        }

        terminar();
    }

    protected void mostrarMenu() {
        System.out.println("==== MENÚ ====");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Modificar cliente");
        System.out.println("3. Eliminar cliente");
        System.out.println("4. Mostrar lista de clientes");
        System.out.println("5. Registrar alquiler");
        System.out.println("6. Finalizar alquiler");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public void terminar() {
        scanner.close();
        System.out.println("¡Hasta luego!");
    }

    protected void ejecutar(int opcion) {
        switch (opcion) {
            case 1:
                registrarCliente();
                break;
            case 2:
                modificarCliente();
                break;
            case 3:
                eliminarCliente();
                break;
            case 4:
                mostrarListaClientes();
                break;
            case 5:
                registrarAlquiler();
                break;
            case 6:
                finalizarAlquiler();
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
                break;
        }
    }

    private void registrarCliente() {
        try {
            System.out.println("==== Registrar Cliente ====");
            
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("DNI: ");
            String dni = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();

            
            controlador.registrarCliente(nombre, dni, telefono, TipoVehiculo.TURISMO);

            System.out.println("Cliente registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar el cliente: " + e.getMessage());
        }
    }

    private void modificarCliente() {
        try {
            System.out.println("==== Modificar Cliente ====");
            
            System.out.print("DNI del cliente a modificar: ");
            String dni = scanner.nextLine();
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Nuevo teléfono: ");
            String nuevoTelefono = scanner.nextLine();

            
            controlador.modificar(dni, nuevoNombre, nuevoTelefono);

            System.out.println("Cliente modificado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al modificar el cliente: " + e.getMessage());
        }
    }

    private void eliminarCliente() {
        try {
            System.out.println("==== Eliminar Cliente ====");
            
            System.out.print("DNI del cliente a eliminar: ");
            String dni = scanner.nextLine();

            
            controlador.eliminarCliente(dni);

            System.out.println("Cliente eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        }
    }

    private void mostrarListaClientes() {
        try {
            System.out.println("==== Lista de Clientes ====");

            List<Cliente> listaClientes = controlador.getClientes();

            System.out.println(listaClientes);
        } catch (Exception e) {
            System.out.println("Error al mostrar la lista de clientes: " + e.getMessage());
        }
    }

    private void registrarAlquiler() {
        try {
            System.out.println("==== Registrar Alquiler ====");

            System.out.print("DNI del cliente: ");
            String dniCliente = scanner.nextLine();
            System.out.print("Matrícula del vehículo: ");
            String matricula = scanner.nextLine();
            System.out.print("Tipo de vehículo (0: Turismo, 1: Autobús, 2: Furgoneta): ");
            int tipoVehiculo = scanner.nextInt();
            scanner.nextLine();

            controlador.registrarAlquiler(dniCliente, matricula, tipoVehiculo.getTipoVehiculo(tipoVehiculo));

            System.out.println("Alquiler registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar el alquiler: " + e.getMessage());
        }
    }

    private void finalizarAlquiler() {
        try {
            System.out.println("==== Finalizar Alquiler ====");
            System.out.print("DNI del cliente: ");
            String dniCliente = scanner.nextLine();
            System.out.print("Matrícula del vehículo: ");
            String matricula = scanner.nextLine();

            controlador.terminar(dniCliente, matricula);

            System.out.println("Alquiler finalizado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al finalizar el alquiler: " + e.getMessage());
        }
    }
}
