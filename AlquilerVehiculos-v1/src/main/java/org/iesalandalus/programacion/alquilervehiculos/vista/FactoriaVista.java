package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.vista.texto.VistaTexto;

public enum FactoriaVista {
	TEXTO;

	public VistaTexto crearVistaTexto() {
		return new VistaTexto();
	}
}
