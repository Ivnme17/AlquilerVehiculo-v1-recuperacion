package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public abstract class ModeloCascada extends Modelo {

    private String modeloCascada;

    public ModeloCascada() {
        super();
        modeloCascada = "";
    }



public abstract void comenzar();

public String getModeloCascada() {
    return modeloCascada;
}

public void setModeloCascada(String modeloCascada) {
    this.modeloCascada = modeloCascada;
}

public void insertar(Cliente cliente) {
	clientes.add(new Cliente(cliente));
}

public void insertar(Turismo turismo) {
	turismos.add(new Turismo(turismo));
}

public void insertar(Alquiler alquiler) {
	Cliente cliente = buscar(alquiler.getCliente().getDni());
	Turismo turismo = buscar(alquiler.getTurismo().getMatricula());
	if (cliente != null && turismo != null) {
		alquileres.add(new Alquiler(alquiler));
	}
}
public Cliente buscar(Cliente dni) {
	for (Cliente cliente : clientes) {
		if (cliente.getDni().equals(dni)) {
			return new Cliente(cliente);
		}
	}
	return null;
}

public Vehiculo buscar(Vehiculo matricula) {
	for (Vehiculo vehiculo: vehiculo) {
		if (Vehiculo.getMatricula().equals(matricula)) {
			return new Vehiculo(vehiculo);
		}
	}
	return null;
}


public void borrar(String dni) {
	for (int i = 0; i < clientes.size(); i++) {
		Cliente cliente = clientes.get(i);
		if (cliente.getDni().equals(dni)) {
			clientes.remove(i);
			borrarAlquileresPorCliente(cliente);
			break;
		}
	}
}
protected void borrarAlquileresPorCliente(Cliente cliente) {
	List<Alquiler> alquileresCliente = new ArrayList<>();
	for (Alquiler alquiler : alquileres) {
		if (alquiler.getCliente().equals(cliente)) {
			alquileresCliente.add(alquiler);
		}
	}
	alquileres.removeAll(alquileresCliente);
}

public void borrarVehiculo(String matricula) {
	for (int i = 0; i < turismos.size(); i++) {
		Turismo turismo = turismos.get(i);
		if (turismo.getMatricula().equals(matricula)) {
			turismos.remove(i);
			borrarAlquileresPorVehiculo(turismo);
			break;
		}
	}
}

private void borrarAlquileresPorVehiculo(Turismo turismo) {
	List<Alquiler> alquileresTurismo = new ArrayList<>();
	for (Alquiler alquiler : alquileres) {
		if (alquiler.getTurismo().equals(turismo)) {
			alquileresTurismo.add(alquiler);
		}
	}
	alquileres.removeAll(alquileresTurismo);
}



public void mostrarClientes() {
	for (Cliente cliente : clientes) {
		System.out.println(cliente);
	}
}




public void mostrarVehiculos() {
    for (Vehiculo vehiculo : vehiculos) {
        System.out.println(vehiculo);
    }
}

public void abrirAlquiler(String dni, String matricula) {
    Cliente cliente = buscar(dni);
    Vehiculo vehiculo = buscar(matricula);
    if (cliente != null && vehiculo != null) {
        Alquiler alquiler = new Alquiler(cliente, vehiculo);
        alquileres.add(alquiler);
    }
}

public void cerrarAlquiler(String dni, String matricula) {
    Cliente cliente = buscar(dni);
    Vehiculo vehiculo = buscar(matricula);
    if (cliente != null && vehiculo != null) {
        Alquiler alquiler = buscarAlquilerAbierto(cliente, vehiculo);
        if (alquiler != null) {
            alquiler.cerrar();
        }
    }
}

public Alquiler buscarAlquilerAbierto(Cliente cliente, Vehiculo vehiculo) {
    for (Alquiler alquiler : alquileres) {
        if (alquiler.getCliente().equals(cliente) && alquiler.getVehiculo().equals(vehiculo) && alquiler.getFechaRetirada() != null && alquiler.getFechaDevolucion() == null) {
            return alquiler;
        }
    }
    return null;
}

public void mostrarAlquileres() {
    for (Alquiler alquiler : alquileres) {
        System.out.println(alquiler);
    }
}
}