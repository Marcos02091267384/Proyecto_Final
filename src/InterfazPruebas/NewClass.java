/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfazPruebas;

import Logica.Usuario;
import Utilidades.Carga_Salva;
import java.util.Scanner;

/**
 *
 * @author Marcos
 */
public final class NewClass {

    private static boolean salir = false;
    private static Usuario user;
    private static Scanner s = new Scanner(System.in);

    public static void main(String args[]) {
        Carga_Salva.cargar();
        user = Usuario.S();
        //user.setAsignaturas(new Asignatura(4, "Ingles"));
        while (!salir) {
            Interface();
        }
    }

    private NewClass() {
    }

    public static void Interface() {
        System.out.println("Introduzca su acion:\n1->Agregar\n2->Eliminar\n3->Ver\n4->Editar\n5->Guardar\n6->Salir");
        Scanner s = new Scanner(System.in);
        String m = s.nextLine();

        if (m.equalsIgnoreCase("Agregar") || m.equals("1")) {
            m = seccion();
            if (m != null) {
                if (m.equalsIgnoreCase("Notas") || m.equals("1")) {
                    System.out.println("A que asignatura deseas annadir la nota?");
                    agregarNota(s.nextLine());
                } else if (m.equalsIgnoreCase("Evaluaciones") || m.equals("2")) {
                    System.out.println("A que asignatura deseas annadir la evaluacion?");
                    agregarEvaluacion(s.nextLine());
                }
            }
        } else if (m.equalsIgnoreCase("Eliminar") || m.equals("2")) {
            m = seccion();
            if (m != null) {
                if (m.equalsIgnoreCase("Notas") || m.equals("1")) {

                } else if (m.equalsIgnoreCase("Evaluaciones") || m.equals("2")) {

                }
            }
        } else if (m.equalsIgnoreCase("Ver") || m.equals("3")) {
            m = seccion();
            if (m != null) {
                if (m.equalsIgnoreCase("Notas") || m.equals("1")) {

                } else if (m.equalsIgnoreCase("Evaluaciones") || m.equals("2")) {

                }
            }

        } else if (m.equalsIgnoreCase("Editar") || m.equals("4")) {
            m = seccion();
            if (m != null) {
                if (m.equalsIgnoreCase("Notas") || m.equals("1")) {

                } else if (m.equalsIgnoreCase("Evaluaciones") || m.equals("2")) {

                }
            }

        } else if (m.equalsIgnoreCase("Salir") || m.equals("6")) {
            salir = true;
        } else if (m.equalsIgnoreCase("Guardar") || m.equals("5")) {
            Carga_Salva.salvar();
        } else {
            Utilidades.Utiles.MensajeError("Accion no disponible");
        }
    }

    private static String seccion() {
        boolean retornar = false;

        System.out.println("Introduzca la secion:\n1->Notas\n2->Evaluaciones");
        String seccion = s.nextLine();
        if (seccion.equalsIgnoreCase("Notas") || seccion.equals("1")) {
            retornar = true;
        } else if (seccion.equalsIgnoreCase("Evaluaciones") || seccion.equals("2")) {
            retornar = true;
        } else {
            Utilidades.Utiles.MensajeError("Seccion no existente");
        }
        return retornar ? seccion : null;
    }

    public static void agregarEvaluacion(String asignatura) {
        //Asignatura a = user.buscarAsignatura(asignatura);
        System.out.println("Indique que dia, mes y a~o sera la evaluacion");
        System.out.print("Dia: ");
        int dia = s.nextInt();
        System.out.print("\nMes: ");
        int mes = s.nextInt();
        System.out.print("\nAnno: ");
        int anno = s.nextInt();
        System.out.println("");
        String des = null;
        System.out.println("Desea annadir alguna descripcion?");
        String desi = s.next();
        if (desi.equalsIgnoreCase("si")) {
            System.out.println("Descripcion:");
            des = s.next();
        }
        boolean entregable = false;
        System.out.println("Latarea es entregable?");
        desi = s.next();
        if (desi.equalsIgnoreCase("si")) {
            entregable = true;
        }
        //a.NuevaEvaluacion(new Evaluacion(new Fecha(dia, mes, anno), des, entregable));
    }

    public static void agregarNota(String asignatura) {
        //Asignatura a = user.buscarAsignatura(asignatura);
        System.out.print("Agrege la nota: ");
        //a.setNotas(new EvaluacionPasada(Double.parseDouble(s.nextLine()), new Fecha(1, 2, 3), null, false));
        System.out.print("\n");
    }
}
