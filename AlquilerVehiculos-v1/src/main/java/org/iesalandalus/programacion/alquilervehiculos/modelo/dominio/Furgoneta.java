package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Furgoneta extends Vehiculo {
	private int FACTOR_PMA;
	private int FACTOR_PLAZAS;
	private int pma;
	private int plazas;

	public Furgoneta(String marca, String modelo, String matricula, int pma) {
		super(marca, modelo, pma, matricula);
		setModelo(modelo);
		setMarca(marca);
		setPma(pma);
		setMatricula(matricula);
	}

	public Vehiculo Furgoneta(Furgoneta furgoneta) { // Constructor copia
		if (furgoneta == null) {
			throw new NullPointerException("ERROR: El valor de furgoneta no puede ser nulo.");
		}
		this.pma = 7000;
		this.plazas = 2;
		return furgoneta;
	}

	@Override
	public double getFactorPrecio() {
		return 1.2;
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


}
