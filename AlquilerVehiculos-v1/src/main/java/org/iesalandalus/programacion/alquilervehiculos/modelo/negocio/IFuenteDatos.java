package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Vehiculos;

public interface IFuenteDatos {

	Clientes crearClientes(Clientes IClientes);

	Vehiculos crearTurismos(Vehiculos ITurismos);

	Alquileres creaAlquiler(Alquileres IAlquileres);

}