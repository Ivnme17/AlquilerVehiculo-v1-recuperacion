package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.vista.texto.VistaTexto;

public enum FactoriaVista {
	TEXTO {
		@Override
		public VistaTexto crearVista() {
			// TODO Auto-generated method stub
			return null;
		}
	}; 
		

	public abstract VistaTexto crearVista();
}
