/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoprogreso;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Marisol Gomez
 * @edited {Cristian Aragon, Sergio Correa, Nicolas Martinez, Carlos Ortigoza}
 *
 */
public class Utilitarios {

    /*
    *metodo para mostrar un mensaje
    *editado:agregado opciones personalizadas
    *estado_mensaje definido por defecto error
    *@params mensaje 
    *@params estado
     */
    public static void mostrar(String mensaje, Boolean estado) {
        int estado_mensaje = JOptionPane.ERROR_MESSAGE;
        if (estado) {
            estado_mensaje = JOptionPane.PLAIN_MESSAGE;
        }
        JOptionPane.showMessageDialog(null, mensaje, "Banco Progreso", estado_mensaje);
    }

    /*
    *
    *Menu diseñado para banco progreso
     */
    public static String menuMostrar(String mensaje, Object[] opciones) {
        int n = JOptionPane.showOptionDialog(null,
                mensaje,
                "Banco Progreso",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[opciones.length - 1]);
        return (String) opciones[n];
    }

    /*
    *
    *
    *metodo pedira la informacion del cliente a crear mediante dialogos
     */
    public static String[] formularioUsuario() {

        JTextField identificacion = new JTextField(15);
        JTextField nombre = new JTextField(15);
        JTextField apellido = new JTextField(15);
        JTextField saldo = new JTextField(15);
        JTextField fecha = new JTextField(15);
        JTextField nivel = new JTextField(15);

        JPanel Formulario = new JPanel();

        Formulario.setLayout(new BoxLayout(Formulario, BoxLayout.Y_AXIS));//modo vertical 
        Formulario.add(new JLabel("Identificacion:"));
        Formulario.add(identificacion);
        Formulario.add(new JLabel("Nombre:"));
        Formulario.add(nombre);
        Formulario.add(new JLabel("Apellido:"));
        Formulario.add(apellido);
        Formulario.add(new JLabel("Saldo:"));
        Formulario.add(saldo);
        Formulario.add(new JLabel("Fecha:"));
        Formulario.add(fecha);
        Formulario.add(new JLabel("Perfil:"));
        Formulario.add(nivel);
        Formulario.setSize(1024, 768);//resolucion seteada

        int result = JOptionPane.showConfirmDialog(null, Formulario,
                "Ingrese informacion cliente", JOptionPane.DEFAULT_OPTION);

        String[] usuario = {nombre.getText(), apellido.getText(), identificacion.getText(),
            saldo.getText(), fecha.getText(), nivel.getText()};
        return usuario;
    }

    public static int leerEntero(String mensaje) //metodo para leer un dato de tipo string y convertirlo a entero
    {
        String N = JOptionPane.showInputDialog(null, mensaje, "Banco Progreso", 1);
        int n = Integer.parseInt(N);
        return n;
    }

    public static double leerDoble(String mensaje) //metodo para leer un dato string y convertirlo a double
    {
        String N = JOptionPane.showInputDialog(null, mensaje, "Banco Progreso", 1);
        double n = Double.parseDouble(N);
        return n;
    }

    public static long leerLong(String mensaje) //metodo para leer un dato string y convertirlo a long
    {
        String N = JOptionPane.showInputDialog(null, mensaje, "Banco Progreso", 1);
        long n = Long.parseLong(N);
        return n;
    }

    public static float leerFloat(String mensaje) {
        //metodo para leer un dato string y convertirlo a float
        String N = JOptionPane.showInputDialog(null, mensaje, "Banco Progreso", 1);
        float n = Float.parseFloat(N);
        return n;

    }

    public static String leerString(String mensaje) {
        String N = JOptionPane.showInputDialog(null, mensaje, "Banco Progreso", 1);
        return N;
    }

    public static char leerChar(String mensaje) //metodo para leer un dato string y convertirlo a char
    {
        String N = JOptionPane.showInputDialog(null, mensaje, "Banco Progreso", 1);
        char n = N.charAt(0);
        return n;

    }

}
