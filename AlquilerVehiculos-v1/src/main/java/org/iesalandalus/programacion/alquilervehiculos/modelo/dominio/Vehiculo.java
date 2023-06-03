package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Vehiculo {
	private static String ER_MARCA = ("(^[A-Z][a-z]+)|(^[A-Z][a-z]+\s[A-Z][a-z]+)|(^[A-Z]+)|(^[A-Z][a-z]+-[A-Z][a-z]+)|(^[A-Z][a-z]+[A-Z][a-z]+)");
	private static String ER_MATRICULA = "/d{4}[BCDFGHJKLMNÑPQRSTVWXYZ]{3}";
	private String marca;
	private String modelo;
	private int cilindrada;
	private String matricula;

	public Vehiculo(String marca, String modelo, int cilindrada, String matricula) {
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
	}

	public Vehiculo(Vehiculo vehiculo) { // Constructor copia
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public static Vehiculo getTurismoConMatricula(String matricula) {
		return new Vehiculo("Seat", "León", 90, matricula);
	}

	public String getModelo() {
		return modelo;
	}

	public static String getMatricula() {
		return matricula;
	}

	protected void setMarca(String marca) {
		if (marca == null) {
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		}
		if (!marca.matches(ER_MARCA)) {
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		}
		this.marca = marca;
	}

	protected void setModelo(String modelo) {
		if (modelo == null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		if (modelo.isBlank()) {
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		}
		this.modelo = modelo;
	}

	private void setCilindrada(int cilindrada) {
		if (cilindrada <= 0 || cilindrada >= 5000) {
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		}
		this.cilindrada = cilindrada;
	}

	protected void setMatricula(String matricula) {
		if (matricula == null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		if (!matricula.matches(ER_MATRICULA)) {
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		}
		this.matricula = matricula;

	}

	@Override
	public String toString() {
		return String.format("%s %s (%sCV) - %s", marca, modelo, cilindrada, matricula);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ER_MARCA, ER_MATRICULA, cilindrada, marca, matricula, modelo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turismo other = (Turismo) obj;
		return Objects.equals(ER_MARCA, other.getMarca()) && Objects.equals(ER_MATRICULA, other.getMatricula())
				&& cilindrada == other.cilindrada && Objects.equals(marca, other.getMarca())
				&& Objects.equals(matricula, other.getMatricula()) && Objects.equals(modelo, other.getModelo());
	}

	public double getFactorPrecio() {
		if (this instanceof Turismo) {
			return cilindrada / getCilindrada();
		} else if (this instanceof Autobus) {
			return plazas * factorPlazas;
		} else if (this instanceof Furgoneta) {
			return pma / factorPma + plazas * factorPlazas;
		} else {
			throw new IllegalArgumentException("Tipo de vehículo no válido.");
		}
	}

}
