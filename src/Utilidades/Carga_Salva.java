/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import Logica.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Marcos
 */
public class Carga_Salva {

    public static void salvar() {
        try {
            FileOutputStream direccionPar = new FileOutputStream("C:\\Users\\Marcos\\Documents\\NetBeansProjects\\python\\src\\Utilidades\\User.us");

            ObjectOutputStream salva = new ObjectOutputStream(direccionPar);
            salva.writeObject(Usuario.S());
            salva.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargar() {
        try {
            FileInputStream direccion = new FileInputStream("C:\\Users\\Marcos\\Documents\\NetBeansProjects\\python\\src\\Utilidades\\User.us");
            ObjectInputStream carga = new ObjectInputStream(direccion);
            Usuario.S((Usuario) carga.readObject());
            carga.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
