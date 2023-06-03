package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import org.iesalandalus.programacion.alquilervehiculos.dominio.Vehiculo;

public class Furgoneta extends Vehiculo {
	private int FACTOR_PMA;
	private int FACTOR_PLAZAS;
	private int pma;
	private int plazas;
		
public Furgoneta(String marca, String modelo, String matricula) {
		super(marca, modelo, matricula);
		this.plazas = plazas;
	}

public void Furgoneta (Furgoneta furgoneta) { //Constructor copia
	
}
	@Override
	public int getFactorPrecio() {
		return 0;
	}
	public int getPma() {
		return pma;
	}
	public int getPlazas() {
		return plazas;
	}
	private void setPma(int pma) {
		this.pma = pma;
	}
	private void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	@Override
	public String toString() {
		return String.format("Furgoneta [FACTOR_PMA=%s, FACTOR_PLAZAS=%s, pma=%s, plazas=%s]", FACTOR_PMA,
				FACTOR_PLAZAS, pma, plazas);
	}

}
