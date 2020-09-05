/*
 * 
 * 
 * */

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class archivo {

    public static void main(String[] args) {

        System.out.println("Inicio del programa");

        // --------------------------------------------------------------------
        // creamos un objeto aplicacion
        // --------------------------------------------------------------------
        JFrame app = new JFrame(); 
        // establecemos las dimensiones de la aplciacion
        app.setSize(new Dimension(640, 480));
        app.setTitle("Manejo de arreglos");
        // establecemos que accion debe pasar al cerra la app
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // --------------------------------------------------------------------

        // --------------------------------------------------------------------
        // creamos una lamina donde se agregaran los elementos
        // --------------------------------------------------------------------
        JPanel lamina = new JPanel();
        // establecemos la organizacion del panel
        lamina.setLayout(new BorderLayout());
        // --------------------------------------------------------------------
        
        // --------------------------------------------------------------------
        // creamos los textos estaticos y las entradas
        // --------------------------------------------------------------------
        JPanel lamina_temporal = new JPanel();
        JTextField campo_numero = new JTextField(12);
        JTextField campo_posicion = new JTextField(12);
        lamina_temporal.add(new JLabel("Numero: "));
        lamina_temporal.add(campo_numero);
        lamina_temporal.add(new JLabel("        "));
        lamina_temporal.add(new JLabel("Posicion: "));
        lamina_temporal.add(campo_posicion);
        
        lamina.add(lamina_temporal, BorderLayout.NORTH);
        // --------------------------------------------------------------------
        
        
        
        // --------------------------------------------------------------------
        // agregamos la lamina a la apliacion y hacemos visible la aplicacion
        // --------------------------------------------------------------------
        JPanel lamina_botones = new JPanel();
        // --------------------------------------------------------------------
        
        
        // --------------------------------------------------------------------
        // agregamos la lamina a la apliacion y hacemos visible la aplicacion
        // --------------------------------------------------------------------
        app.add(lamina);
        app.setVisible(true);
        // --------------------------------------------------------------------
        
        
        
        
        System.out.println("Fin del programa");

    }

    /*
    private static class Aplicacion extends JFrame {
        Aplicacion() {
        	
        }
    }
    */
    
    

}

