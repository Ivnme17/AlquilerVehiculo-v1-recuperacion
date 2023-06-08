package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public abstract class Modelo {
	protected static List<Cliente> clientes;
	protected List<Vehiculo> vehiculos;
	protected List<Alquiler> alquileres;

	public Modelo() {
		this.clientes = new ArrayList<>();
		this.vehiculos = new ArrayList<>();
		this.alquileres = new ArrayList<>();
	}

	public abstract void comenzar();

	public abstract void terminar();

	public void insertarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void insertarVehiculo(Vehiculo vehiculo) {
		vehiculos.add(vehiculo);
	}

	public void abrirAlquiler(Alquiler alquiler) {
		alquileres.add(alquiler);
	}

	public void cerrarAlquiler(Alquiler alquiler) {
		alquiler.setFechaDevolucion(LocalDate.now());
	}

	public static Cliente buscarCliente(Cliente cliente) {
	    for (Cliente c : clientes) {
	        if (c.getDni().equals(cliente.getDni())) {
	            return c;
	        }
	    }
	    return null;
	}

	public Vehiculo buscarVehiculo(Vehiculo vehiculo) {
	    for (Vehiculo v : vehiculos) {
	        if (v.getMatricula().equals(vehiculo.getMatricula())) {
	            return v;
	        }
	    }
	    return null;
	}


	public Alquiler buscarAlquiler(Cliente cliente, Vehiculo vehiculo) {
		for (Alquiler alquiler : alquileres) {
			if (alquiler.getCliente().equals(cliente) && alquiler.getVehiculo().equals(vehiculo)
					&& alquiler.getFechaDevolucion() == null) {
				return alquiler;
			}
		}
		return null;
	}

	public static void modificarCliente(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
	    Cliente clienteEncontrado = buscarCliente(cliente);
	    if (clienteEncontrado != null) {
	        clienteEncontrado.setNombre(nombre);
	        clienteEncontrado.setTelefono(telefono);
	        Modelo.modificarCliente(clienteEncontrado, nombre, telefono);
	        System.out.println("Cliente modificado correctamente.");
	    } else {
	        System.out.println("No se encontró ningún cliente con el DNI: " + cliente.getDni());
	    }
	}


	public void borrarCliente(Cliente cliente) {
	    if (cliente != null) {
	        clientes.remove(cliente);
	        System.out.println("Cliente eliminado correctamente.");
	    }
	}

	public void borrarVehiculo(Vehiculo vehiculo) {
	    if (vehiculo != null) {
	        vehiculos.remove(vehiculo);
	        System.out.println("Vehículo eliminado correctamente.");
	    }
	}



	public void borrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
		Alquiler alquiler = buscarAlquiler(cliente, vehiculo);
		if (alquiler != null) {
			alquileres.remove(alquiler);
		}
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		List<Alquiler> alquileresCliente = new ArrayList<>();
		for (Alquiler alquiler : alquileres) {
			if (alquiler.getCliente().equals(cliente)) {
				alquileresCliente.add(alquiler);
			}
		}
		return alquileresCliente;
	}

	public List<Alquiler> getAlquileres(Vehiculo vehiculo) {
		List<Alquiler> alquileresVehiculo = new ArrayList<>();
		for (Alquiler alquiler : alquileres) {
			if (alquiler.getVehiculo().equals(vehiculo)) {
				alquileresVehiculo.add(alquiler);
			}
		}
		return alquileresVehiculo;
	}

	public List<Alquiler> getAlquileres(Cliente cliente, Vehiculo vehiculo) {
		List<Alquiler> alquileresClienteVehiculo = new ArrayList<>();
		for (Alquiler alquiler : alquileres) {
			if (alquiler.getCliente().equals(cliente) && alquiler.getVehiculo().equals(vehiculo)) {
				alquileresClienteVehiculo.add(alquiler);
			}
		}
		return alquileresClienteVehiculo;
	}

	public void devolverVehiculo(Vehiculo vehiculo) {
		for (Alquiler alquiler : alquileres) {
			if (alquiler.getVehiculo().equals(vehiculo) && alquiler.getFechaDevolucion() == null) {
				alquiler.setFechaDevolucion(LocalDate.now());
			}
		}
	}

	public void devolverVehiculos(Vehiculo vehiculo) {
		for (Alquiler alquiler : alquileres) {
			if (alquiler.getCliente().equals(vehiculo) && alquiler.getFechaDevolucion() == null) {
				alquiler.setFechaDevolucion(LocalDate.now());
			}
		}
	}
}
