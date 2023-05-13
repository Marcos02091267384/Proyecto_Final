/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.Serializable;

/**
 *
 * @author Marcos
 */
public class EvaluacionPasada extends Evaluacion implements Serializable {

    private double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public EvaluacionPasada(double nota, Fecha fecha, String info, boolean entregable) {
        super(fecha, info, entregable);
        valor = nota;
    }

}
