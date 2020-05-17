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
     * metodo publico que recorrera cada usuario luego se concatenara para mostrar
     * en pantallla
     * 
     * @params data string valor que retorna la concatenacion de todos los usuarios
     */
    public String mostrarUsuarios() {
        ordenarClientes();

        String data = "";
        for (int i = 0; i < clientes.length - 1; i++) {
            for (int j = 0; j < clientes[i].length; j++) {
                data += clientes[i][j] + "\n";
            }
            data += "___________________________\n";
        }
        return data;
    }

    /*
     * metodo publico que mostrara informacion de usuario dependiendo de su cedula
     * en pantallla
     * 
     * @params data string valor que retorna la concatenacion del usuario o el
     * enunciado
     */
    public String mostrarInformacion(String cedula) {

        String data = "";
        for (int i = 0; i < clientes.length - 1; i++) {
            for (int j = 0; j < clientes[i].length; j++) {
                if (clientes[i][2].equals(cedula)) {
                    data += clientes[i][j] + "\n";
                }
            }
        }
        return data == "" ? "No tiene acceso" : data;
    }

    /*
     *
     * metodo que dada cedyla y valor de abono restara dell valor total de la deuda
     * el valor debe ser mayor a 0 o meno a su valor total
     */
    public void debitarAbono(int abono, String cedula) {

        for (int i = 0; i < clientes.length - 1; i++) {
            for (int j = 0; j < clientes[i].length; j++) {
                if (clientes[i][2].equals(cedula) && abono != 0 && abono <= Integer.parseInt(clientes[i][3])) {

                    int saldo = Integer.parseInt(clientes[i][3]);

                    int nuevoSaldo = saldo - abono;

                    clientes[i][3] = Integer.toString(nuevoSaldo);
                }

                if (abono == 0 || abono > Integer.parseInt(clientes[i][3])) {
                    Utilitarios.mostrar("No se pudo realizar la operacion", false);
                    return;
                }
            }
        }
    }

    /*
     * este metodo mostrara el saldo actual del cliente por medio de su cedula .
     *
     *
     * public String obtenerSaldoActual(String cedula){ for (int i = 0; i <
     * clientes.length - 1; i++) { for (int j = 0; j < clientes[i].length; j++) {
     * if(clientes[i][2].equals(cedula)) return clientes[i][3]; } }
     * 
     * return ""; }
     * 
     * 
     * /**
     * 
     * Metodo que se encargará de ordenar los clientes de mayor a menor por medio de
     * la cedula
     */
    private void ordenarClientes() {

        boolean swapped = false;

        do {
            swapped = false;

            // Como la ultima posicion es null entonces el -2 hace que no lo recorramos
            // y lo ignoremos y así evitar un nullPointerException
            for (int i = 0; i < clientes.length - 2; i++) {
                if (Long.parseLong(clientes[i][2]) > Long.parseLong(clientes[i + 1][2])) {
                    String[] temp = clientes[i];
                    clientes[i] = clientes[i + 1];
                    clientes[i + 1] = temp;
                    swapped = true;
                }
            }

        } while (swapped);
    }

    /*
     *
     *
     * este metodo busca los clientes con perfil 2 y que exista su cedula en el
     * banco
     */
    public String buscarCliente() {
        String cedulaCliente = Utilitarios.leerString("Ingresa cedula cliente");

        String data = "Cliente:\n";
        Boolean verificar = false;
        for (int i = 0; i < clientes.length - 1; i++) {
            for (int j = 0; j < clientes[i].length; j++) {
                if (clientes[i][2].equals(cedulaCliente) && clientes[i][5].equals("2")) {
                    data += clientes[i][j] + "\n";
                    verificar = true;
                }
            }
        }
        return (verificar) ? data : "No existe cliente";
    }

    /*
     *
     * metodos para sumar el saldo de todos.
     *
     */
    public String sumaSaldos() {
        int data = 0;
        String response = "Total del saldos:\n";
        for (int i = 0; i < clientes.length - 1; i++) {
            data += Integer.parseInt(clientes[i][3]);
        }
        return response += Integer.toString(data);
    }

}
