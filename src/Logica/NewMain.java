/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Utilidades.Carga_Salva;
import java.util.Date;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carga_Salva.cargar();
        Usuario u = Usuario.S();
        u.op().agregarAsignatura("Calculo 3", 5);
        u.op().agregarEvaluacion(new Fecha(5, 5, 2020), "Integrales y derivadas", false, "Calculo 3");
        u.op().agregarNota(5, new Fecha(5, 5, 2020), "Integrales y derivadas", false, "Calculo 3");
        Carga_Salva.salvar();
        System.out.println("Fin");
    }

    public static int EvaluacionCercana(Fecha fecha) {

        int fechadeEvaluacion = fecha.getDia() + (fecha.getMes() * 30) + (fecha.getAnno() * 365);
        Date today = new Date();
        int fechadeHoy = today.getDate() + ((today.getMonth() + 1) * 30) + ((today.getYear() + 1900) * 365);
        fechadeEvaluacion -= fechadeHoy;
        if (fechadeEvaluacion <= 0) {
            fechadeEvaluacion = 0;
        } else if (fechadeEvaluacion >= 90) {
            fechadeEvaluacion = 1;
        } else if (fechadeEvaluacion >= 60) {
            fechadeEvaluacion = 2;
        } else if (fechadeEvaluacion >= 30) {
            fechadeEvaluacion = 3;
        } else if (fechadeEvaluacion >= 7) {
            fechadeEvaluacion = 4;
        } else {
            fechadeEvaluacion = 5;
        }

        return fechadeEvaluacion;
    }

}
