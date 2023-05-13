/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public interface Operable {

    public void agregarAsignatura(String nombre, int peso);

    public void agregarNota(int nota, Fecha fecha, String info, boolean entregable, String asignatura);

    public void agregarEvaluacion(Fecha fecha, String descripcion, boolean entregable, String asignatura);

    public void eliminarAsignatura(String nombre);

    public void eliminar(Evaluacion e, String asignatura);// Eliminar una nota o una evaluacion

    public ArrayList<Evaluacion> verEvaluacion(String asigntura, Fecha fecha);

    public void verAsignatura(String asignatura);

}
