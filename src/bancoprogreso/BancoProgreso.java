/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoprogreso;

import javax.swing.JOptionPane;

/**
 *
 * @author {Cristian Aragon, Sergio Correa, Nicolas Martinez, Carlos Ortigoza}
 */
public class BancoProgreso extends Perfiles {

    public BancoProgreso() {

    }

    public void bienvenido() {

        String cedula = Utilitarios.leerString("Bienvenido  por favor Ingrese su cedula");
        int seleccion = buscarUsuario(cedula);
        switch (seleccion) {
            case 0:
                admin(cedula, seleccion);
                break;
            case 1:
                funcionario(cedula, seleccion);
                break;
            case 2:
                cliente(cedula, seleccion);
                break;
            default:
                Utilitarios.mostrar("Este usuario no existe", Boolean.FALSE);
                break;

        }
    }
}