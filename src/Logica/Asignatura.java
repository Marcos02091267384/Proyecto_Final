/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Marcos
 */
public class Asignatura implements Serializable {

    private String Nombre;
    private LinkedList<Evaluacion> evaluacionesPendientes;
    private ArrayList<EvaluacionPasada> notas;
    private int valorDeUsuario;
    private int valorTotal;

    public int notasSize() {
        return notas.size();
    }

    public double promedio() {
        double promedio = 0.0;
        for (int i = 0; i < notas.size(); i++) {
            promedio += notas.get(i).getValor();
        }
        return promedio /= notas.size();
    }

    public Asignatura(int valorDeUsuario, String Nombre) {
        this.evaluacionesPendientes = new LinkedList<>();
        this.notas = new ArrayList<>();
        this.valorDeUsuario = valorDeUsuario;
        this.Nombre = Nombre;
        DefinirPeso();

    }

    /*public void EliminarEvaluacionPendiente() {
     if (!evaluacionesPendientes.isEmpty()) {
     notas.add(this.evaluacionesPendientes.removeFirst().getNota());
     }
     }*/
    public void nuevaEvaluacion(Evaluacion evaluacion) {
        evaluacionesPendientes.add(evaluacion);
    }

    public EvaluacionPasada getNota(int index) {
        return notas.get(index);
    }

    public void nuevaNotas(EvaluacionPasada nota) {
        notas.add(nota);
    }

    public int getValorDeUsuario() {
        return valorDeUsuario;
    }

    public void setValorDeUsuario(int valorDeUsuario) {
        this.valorDeUsuario = valorDeUsuario;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    private void DefinirPeso() {
        this.valorTotal /= promedio(); //esto es el promedio, usemos el metodo existente y optizamos el uso de iterador
        this.valorTotal += this.valorDeUsuario;
        if (!evaluacionesPendientes.isEmpty()) {
            this.valorTotal += EvaluacionCercana(evaluacionesPendientes.peek().getFecha());
            //Entonces el valor total va a ser el promedio+valordeUsuario+losdiasquefaltan
            //Sin embargo mientras menos dias queden, menor va a ser el valor, y deberia ser mayor por la urgencia
            //Ademas si restas dia con dia y estan en diferente mes hay q sumarle mass
            //Debido a ello, se me ocurre hacer una escala del 1 al 5 depende de la urgencia
            //Te muestro el metodo en lo mio
        }
    }

    public int EvaluacionCercana(Fecha fecha) {
        int fechadeEvaluacion = fecha.getDia() + (fecha.getMes() * 30) + (fecha.getAnno() * 365);
        Date today = new Date();
        int fechadeHoy = today.getDate() + ((today.getMonth() + 1) * 30) + ((today.getYear() + 1900) * 365);
        fechadeEvaluacion -= fechadeHoy;
        if (fechadeEvaluacion <= 0) { //Ya paso la evaluacion
            fechadeEvaluacion = 0;
        } else if (fechadeEvaluacion >= 90) { //+ 3 meses
            fechadeEvaluacion = 1;
        } else if (fechadeEvaluacion >= 60) { //+ 2 meses
            fechadeEvaluacion = 2;
        } else if (fechadeEvaluacion >= 30) { //+ 1 mes
            fechadeEvaluacion = 3;
        } else if (fechadeEvaluacion >= 7) { //+ 1 semana
            fechadeEvaluacion = 4;
        } else {                            //misma semana
            fechadeEvaluacion = 5;
        }

        return fechadeEvaluacion;
    }

}
