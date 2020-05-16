/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoprogreso;

import java.util.Arrays;

/**
 *
 * @author {Cristian Aragon, Sergio Correa, Nicolas Martinez, Carlos Ortigoza}
 */
public class Acciones {

    private String[][] clientes;

    public Acciones() {
        clientes = new String[1][6];
    }

    public void crearUsuarios(String[] usuario) {
        String[][] copiaClientes = Arrays.copyOf(clientes, clientes.length + 1);
        copiaClientes[clientes.length - 1] = usuario;
        clientes = copiaClientes;
    }

    public String[][] getClientes() {
        return clientes;
    }

    /*
    *metodo privado que recorrera cada usuario
    *luego se concatenara para mostrar en pantallla
    *@params data string valor que retorna la concatenacion de todos los usuarios
     */
    public String mostrarUsuarios() {
        String data = "";
        for (int i = 0; i < getClientes().length - 1; i++) {
            for (int j = 0; j < getClientes()[i].length; j++) {
                data += getClientes()[i][j] + "\n";
            }
            data += "___________________________\n";
        }
        return data;
    }

    /*
    *
    *
    *este metodo busca los clientes con perfil 2 y que exista su cedula en el banco
     */
    public String buscarCliente() {
        String cedulaCliente = Utilitarios.leerString("Ingresa cedula cliente");

        String data = "Cliente:\n";
        Boolean verificar = false;
        for (int i = 0; i < getClientes().length - 1; i++) {
            for (int j = 0; j < getClientes()[i].length; j++) {
                if (getClientes()[i][2].equals(cedulaCliente) && getClientes()[i][5].equals("2")) {
                    data += getClientes()[i][j] + "\n";
                    verificar = true;
                }
            }
        }
        return (verificar) ? data : "No existe cliente";
    }

    /*
    *
    *metodos para sumar el saldo de todos.
    *
     */
    public String sumaSaldos() {
        int data = 0;
        String response = "Total del saldos:\n";
        for (int i = 0; i < getClientes().length - 1; i++) {
            data += Integer.parseInt(getClientes()[i][3]);
        }
        return response += Integer.toString(data);
    }

    public void verClientes() {
    }

    public void filtrar() {
    }

    public void realizaAbono() {
    }
}
