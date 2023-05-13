/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Exepciones.AsignaturanoExistente;
import InterfazPruebas.Errores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Marcos
 */
public class Usuario implements Serializable {

    private LinkedList<Asignatura> asignaturas;
    private static Usuario singleton;
    private final Operaciones oper = new Operaciones();

    public int getCantidadAsignaturas() {
        return asignaturas.size();
    }

    public Asignatura buscarAsignatura(String name) throws AsignaturanoExistente {
        Iterator iter = asignaturas.iterator();
        Asignatura retorno = null;
        boolean esta = false;
        while (iter.hasNext() && !esta) {
            retorno = (Asignatura) iter.next();
            if (retorno.getNombre().equals(name)) {
                esta = true;
            }
        }
        return esta ? retorno : null;
    }

    private Usuario() {
        asignaturas = new LinkedList<>();
    }

    public static Usuario S() {
        if (singleton == null) {
            singleton = new Usuario();
        }
        return singleton;
    }

    public static void S(Usuario u) {
        singleton = u;
    }

    public Operable op() {
        return oper;
    }

    private class Operaciones implements Serializable, Operable {

        private Operaciones() {
        }

        public void agregarAsignatura(String nombre, int peso) {
            asignaturas.add(new Asignatura(peso, nombre));
        }

        public void agregarNota(int nota, Fecha fecha, String info, boolean entregable, String asignatura) {
            EvaluacionPasada e = new EvaluacionPasada(nota, fecha, info, entregable);
            try {
                Asignatura a = buscarAsignatura(asignatura);
                a.nuevaNotas(e);
            } catch (AsignaturanoExistente ex) {
                Errores.ErrorDeAsignatura();
            }
        }

        public void agregarEvaluacion(Fecha fecha, String descripcion, boolean entregable, String asignatura) {
            Evaluacion e = new Evaluacion(fecha, descripcion, entregable);
            try {
                Asignatura a = buscarAsignatura(asignatura);
                a.nuevaEvaluacion(e);
            } catch (Exception ex) {
                Errores.ErrorDeAsignatura();
            }
        }

        @Override
        public void eliminarAsignatura(String nombre) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void eliminar(Evaluacion e, String asignatura) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public ArrayList<Evaluacion> verEvaluacion(String asigntura, Fecha fecha) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void verAsignatura(String asignatura) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
