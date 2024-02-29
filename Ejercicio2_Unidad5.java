package desafio_logicaUnidad5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Ejercicio2_Unidad5 {

	// Encapsulo el nombre de la carpeta para usarlo cuando me haga falta.
	private static final String DIR_EJER2 = "dirEjer2";

	// Creo otra constante para usarla a modo de ruta dentro de la carpeta del
	// Ejercicio2
	private static final String RUTACARPETA = System.getProperty("user.dir") + File.separator + DIR_EJER2;

	public static void main(String[] args) {

		// Muestra el directorio actual:

		System.out.println(System.getProperty("user.dir"));

		/* Comprueba si el directorio existe y si no lo crea. */

		compruebaYcreaDirectorio();

		// En el metodo crearFicheros se realiza la comprobacion de existencia de
		// archivos.

		crearFicheros();

		escribirNombresConBuffer(RUTACARPETA, "Dos.txt");

		leectorBuffer(RUTACARPETA, File.separator + "Dos.txt");

	}

	// Metodos que comprueban los directorios y crean los archivos solicitados.

	public static boolean crearFicheros() {

		if (!Ejercicio1_Unidad5.comprobarExiste(RUTACARPETA, "Uno.txt")
				&& !Ejercicio1_Unidad5.comprobarExiste(RUTACARPETA, "Dos.txt")) {

			Ejercicio1_Unidad5.crearFicheros(RUTACARPETA, "Uno.txt");
			Ejercicio1_Unidad5.crearFicheros(RUTACARPETA, "Dos.txt");

			JOptionPane.showMessageDialog(null, "Archivos creados correctamente");

			return true;

		} else

			JOptionPane.showMessageDialog(null, "Los archivos ya existen");

		return false;
	}

	public static boolean compruebaYcreaDirectorio() {

		if (!Ejercicio1_Unidad5.comprobarExiste(RUTACARPETA, DIR_EJER2)) {

			Ejercicio1_Unidad5.crearDirectorio(DIR_EJER2);

			return true;

		} else
			JOptionPane.showMessageDialog(null, "El directorio ya existe");
		return false;
	}

	// Metodo que comprueba la existencia y escribe en el archivo Dos.txt:

	public static boolean escribirNombresConBuffer(String ruta, String nombreArchivo) {

		boolean bandera = true;

		if (Ejercicio1_Unidad5.comprobarExiste(ruta, nombreArchivo)) {

			try {

				FileWriter escritor = new FileWriter(ruta + File.separator + nombreArchivo, true);

				BufferedWriter buffer = new BufferedWriter(escritor);

				String nombres = "";

				while (nombres != null && bandera) {

					nombres = JOptionPane.showInputDialog(null,
							"Introduce los nombres que quieras guardar en el archivo (Pulsa - para parar): ");

					if (nombres != null) {

						if (!nombres.equalsIgnoreCase("-")) {

							buffer.write(nombres + "\n");

						} else {

							bandera = false;
						}
					}
				}

				buffer.close();
				escritor.close();

			} catch (IOException e) {

				JOptionPane.showMessageDialog(null, "Guardado de nombres finalizado");

				return false;
			}

		} else
			JOptionPane.showMessageDialog(null, "El archivo no se encuentra");

		return true;
	}

	// Lee el archivo indicado usando un buffer.

	public static boolean leectorBuffer(String ruta, String nombreArchivo) {

		if (Ejercicio1_Unidad5.comprobarExiste(ruta, nombreArchivo)) {

			try {

				FileReader lector = new FileReader(ruta + nombreArchivo);

				BufferedReader lectorBuffer = new BufferedReader(lector);

				String entrada = "";

				while (entrada != null) {

					entrada = lectorBuffer.readLine();

					if (entrada != null) {

						System.out.println(entrada);

					}

				}

				lector.close();

				return true;

			} catch (IOException e) {

				JOptionPane.showMessageDialog(null, "El archivo no se puede leer");
			}

		}

		return false;
	}
	
	
}
