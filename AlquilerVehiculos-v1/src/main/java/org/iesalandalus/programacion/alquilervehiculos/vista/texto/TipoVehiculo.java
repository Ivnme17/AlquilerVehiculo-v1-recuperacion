package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public enum TipoVehiculo {
	TURISMO, AUTOBUS, FURGONETA;

	private String nombre;

	private TipoVehiculo() {
		this.nombre = nombre;
	}

	private static boolean esOrdinalValido(int ordinal) {
		if (ordinal == 1) {
			return true;
		} else
			return false;
	}

	public static TipoVehiculo getTipoVehiculo(Vehiculo vehiculo) {
		if (vehiculo instanceof Turismo) {
			return TURISMO;
		} else if (vehiculo instanceof Autobus) {
			return AUTOBUS;
		} else if (vehiculo instanceof Furgoneta) {
			return FURGONETA;
		} else {
			throw new IllegalArgumentException("Tipo de vehículo desconocido");
		}
	}

	public static TipoVehiculo getTipoVehiculo(int ordinal) {
		if (esOrdinalValido(ordinal)) {
			return values()[ordinal];
		} else {
			throw new IllegalArgumentException("Ordinal de tipo de vehículo no válido");
		}
	}

	@Override
	public String toString() {
		return nombre;
	}
}
