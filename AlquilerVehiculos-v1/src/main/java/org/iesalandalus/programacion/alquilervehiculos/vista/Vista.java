package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public abstract class Vista {
    protected Controlador controlador;
    
    public void setControlador(Controlador controlador) {
        if (controlador != null) {
            this.controlador = controlador;
        } else {
            throw new IllegalArgumentException("El controlador no puede ser nulo.");
        }
    }

    public abstract void comenzar();
    public abstract void terminar();
    protected abstract void mostrarMenu();
    protected abstract void ejecutar(int opcion);
}
