/*
 * 
 * 
 * */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class archivo {

    public static void main(String[] args) {

        System.out.println("Inicio del programa");
        
        // --------------------------------------------------------------------
        // creamos un objeto aplicacion y otro para validar que en las posiciones
        // se estan insertando los datos
        // --------------------------------------------------------------------
        arreglo_numeros = new int[numero_elementos];
        arreglo_insertado = new boolean[numero_elementos];
        for (int i = 0; i<10; ++i) {
        	arreglo_insertado[i] = false;
        }

        // --------------------------------------------------------------------
        // creamos un objeto aplicacion
        // --------------------------------------------------------------------
        JFrame app = new JFrame(); 
        // establecemos las dimensiones de la aplciacion
        app.setSize(new Dimension(640, 480));
        // hace que el tamano de la ventana sea fijo
        app.setResizable(false);
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
        campo_numero = new JTextField(12);
        campo_posicion = new JTextField(12);
        lamina_temporal.add(new JLabel("Numero: "));
        lamina_temporal.add(campo_numero);
        lamina_temporal.add(new JLabel("        "));
        lamina_temporal.add(new JLabel("Posicion: "));
        lamina_temporal.add(campo_posicion);
        
        lamina.add(lamina_temporal, BorderLayout.NORTH);
        // --------------------------------------------------------------------

        // --------------------------------------------------------------------
        // agregamos la lamina que contiene los botones
        // --------------------------------------------------------------------
        JPanel lamina_botones = new JPanel();
        // creamos los botones
        // boton promedio
        JButton boton_promedio = new JButton("Promedio");
        boton_promedio.addActionListener(new CalcularPromedio());
        // boton agregar numero
        JButton boton_agregar_numero = new JButton("Agregar numero");
        boton_agregar_numero.addActionListener(new AgregarDato());
        // limpiar arreglo
        JButton boton_limpiar_arreglo = new JButton("Limpiar Arreglo");
        boton_limpiar_arreglo.addActionListener(new LimpiarArreglo());
        // limpiar dato
        JButton boton_limpiar_dato = new JButton("Limpiar dato");
        boton_limpiar_dato.addActionListener(new BorrarDato());
        // consultar numero
        JButton boton_consultar_numero = new JButton("Consultar dato");
        boton_consultar_numero.addActionListener(new ConsultarDato());
        // mostrar arreglo
        JButton boton_mostrar_arreglo = new JButton("Mostrar arreglo");
        boton_mostrar_arreglo.addActionListener(new MostarArreglo());
        // agregamos los botones
        lamina_botones.add(boton_agregar_numero);
        lamina_botones.add(boton_consultar_numero);
        lamina_botones.add(boton_limpiar_dato);
        lamina_botones.add(boton_limpiar_arreglo);
        lamina_botones.add(boton_promedio);
        lamina_botones.add(boton_mostrar_arreglo);
        
        lamina.add(lamina_botones, BorderLayout.CENTER);
        // --------------------------------------------------------------------
        
        // --------------------------------------------------------------------
        // agregamos la lamina a la apliacion y hacemos visible la aplicacion
        // --------------------------------------------------------------------        
        JPanel panel_salida = new JPanel();
        panel_salida.setLayout(new BorderLayout());
        area_salida = new JTextArea();
        area_salida.setEditable(false);
        area_salida.setColumns(52);
        area_salida.setRows(5);
        panel_salida.add(new JLabel("salida: "), BorderLayout.NORTH);
        panel_salida.add(area_salida, BorderLayout.SOUTH);
        lamina.add(panel_salida, BorderLayout.SOUTH);
        // --------------------------------------------------------------------

        // --------------------------------------------------------------------
        // agregamos la lamina a la apliacion y hacemos visible la aplicacion
        // --------------------------------------------------------------------
        app.add(lamina);
        app.setVisible(true);
        // --------------------------------------------------------------------
        
        
        
        
        System.out.println("Fin del programa.");

    }

    
    private static int arreglo_numeros[]; // = new int[10];
    private static boolean arreglo_insertado[]; // = new boolean[10];
    private static int posicion_insertada;
    private static int numero_insertado;
    private static double promedio;
    private static final int numero_elementos = 10;
    
    private static JTextField campo_numero;
    private static JTextField campo_posicion;
    private static JTextArea area_salida;

    private static class CalcularPromedio implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent event) {
    		double promedio = 0;
    		int counter = 0;
    		for (int i = 0; i < numero_elementos; ++i) {
    			if (arreglo_insertado[i]) {
    				promedio += arreglo_numeros[i];
    				counter++;
    			}
    		}
    		if (counter > 0) {
    			promedio /= counter;
    			area_salida.setText(new String("Promedio: " + promedio));    			
    		} else {
    			area_salida.setText(new String("El promedio no pudo ser calculado porque no hay datos"));	
    		}
		}
    }

    private static class MostarArreglo implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent event) {
    		String texto = new String("[");
    		int i;
    		for (i = 0; i < (numero_elementos - 1); ++i) {
    			String temp_str = arreglo_insertado[i] ? arreglo_numeros[i] + "," : "null, ";
    			texto = texto.concat(temp_str);
    		}
    		i = numero_elementos - 1;
    		texto = texto.concat(arreglo_insertado[i] ? arreglo_numeros[i] + "]" : "null]");
    		area_salida.setText(texto);
    	}
    }

    private static class LimpiarArreglo implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent event) {
    		for (int i = 0; i < numero_elementos; ++i) {
    			arreglo_insertado[i] = false;
    		}
    		arreglo_numeros = new int[10];
    		area_salida.setText("arreglo limpiado.");
    	}
    }
    
    private static class ConsultarDato implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent event) {
    		int posicion;
    		try {
    			posicion = Integer.parseInt(campo_posicion.getText());
    		} catch (Exception e) {
    			area_salida.setText("Error: El valor posicion no es valido.");
    			return;
    		}
    		if (posicion < 0) {
    			area_salida.setText("Error: El valor debe ser mayor o igual a 0.");
    			return;
    		}
    		if (posicion >= numero_elementos) {
    			area_salida.setText("Error: El valor debe ser menor a " + numero_elementos);
    			return;	
    		}
    		if (arreglo_insertado[posicion]) {
    			area_salida.setText("El valor en la posicion " + posicion + " es " + arreglo_numeros[posicion]);
    			campo_posicion.setText("");
    		} else {
    			area_salida.setText("No se ha insertado numero en la posicion " + posicion);
    		}
    	}
    }

    private static class AgregarDato implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent event) {
    		int posicion;
    		try {
    			posicion = Integer.parseInt(campo_posicion.getText());
    		} catch (Exception e) {
    			area_salida.setText("Error: El valor posicion no es valido.");
    			return;
    		}
    		if (posicion < 0) {
    			area_salida.setText("Error: El valor debe ser mayor o igual a 0.");
    			return;
    		}
    		if (posicion >= numero_elementos) {
    			area_salida.setText("Error: El valor debe ser menor a " + numero_elementos);
    			return;	
    		}
    		int numero;
    		try {
    			numero = Integer.parseInt(campo_numero.getText());
    		} catch (Exception e) {
    			area_salida.setText("Error: El valor numero no es valido.");
    			return;
    		}
    		arreglo_numeros[posicion] = numero;
    		arreglo_insertado[posicion] = true;
    		campo_numero.setText("");
    		campo_posicion.setText("");
    		area_salida.setText("Se ha insertado un " + numero + " en la posicion " + posicion);
    	}
    }

    private static class BorrarDato implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent event) {
    		int posicion;
    		try {
    			posicion = Integer.parseInt(campo_posicion.getText());
    		} catch (Exception e) {
    			area_salida.setText("Error: El valor posicion no es valido.");
    			return;
    		}
    		if (posicion < 0) {
    			area_salida.setText("Error: El valor debe ser mayor o igual a 0.");
    			return;
    		}
    		if (posicion >= numero_elementos) {
    			area_salida.setText("Error: El valor debe ser menor a " + numero_elementos);
    			return;	
    		}
    		arreglo_insertado[posicion] = false;
    		campo_posicion.setText("");
    	}
    }

}

