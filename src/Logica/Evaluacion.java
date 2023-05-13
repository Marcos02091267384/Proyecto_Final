/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Logica;

import java.io.Serializable;

/**
 *
 * @author Marcos
 */
public class Evaluacion implements Serializable {

    private Fecha fecha;
    private String descripcion;
    private boolean entregable; //Que es entregable? R\ Si es una tarea evaluativa o alguntrabajo extraclase o una PE o parcial

    public Evaluacion(Fecha fecha, String descripcion, boolean entregable) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.entregable = entregable;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEntregable() {
        return entregable;
    }

    public void setEntregable(boolean entregable) {
        this.entregable = entregable;
    }

}
