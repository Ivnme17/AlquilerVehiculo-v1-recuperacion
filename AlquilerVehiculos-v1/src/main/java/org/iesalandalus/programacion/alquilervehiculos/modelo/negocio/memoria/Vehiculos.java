package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IVehiculos;

public class Vehiculos implements IVehiculos {

    private List<Vehiculo> coleccionVehiculos;

    public Vehiculos() {
        this.coleccionVehiculos = new ArrayList<>();
    }

    @Override
	public List<Vehiculo> get() {
        return new ArrayList<>(coleccionVehiculos);
    }

    @Override
	public int getCantidad() {
        return coleccionVehiculos.size();
    }

    @Override
	public void insertar(Vehiculo Vehiculo) throws OperationNotSupportedException {
    	 if (Vehiculo == null) {
         	throw new NullPointerException("ERROR: No se puede insertar un Vehiculo nulo.");
         }
    	if (Vehiculo != null && !coleccionVehiculos.contains(Vehiculo)) {
            coleccionVehiculos.add(Vehiculo);
            }else { throw new OperationNotSupportedException("ERROR: Ya existe un Vehiculo con esa matrícula.");
            }
        }

    @Override
	public Vehiculo buscar(Vehiculo Vehiculo) {
        int index = coleccionVehiculos.indexOf(Vehiculo);
        if (index >= 0) {
            return coleccionVehiculos.get(index);
        }else if (Vehiculo==null){
            throw new NullPointerException("ERROR: No se puede buscar un Vehiculo nulo.");
        }
		return null;
    }

    @Override
	public void borrar(Vehiculo Vehiculo) throws OperationNotSupportedException {
    	if (Vehiculo == null) {
        	throw new NullPointerException("ERROR: No se puede borrar un Vehiculo nulo.");
        }
    
    	if (!coleccionVehiculos.remove(Vehiculo)) {
            throw new OperationNotSupportedException("ERROR: No existe ningún Vehiculo con esa matrícula."); 
}
}

}