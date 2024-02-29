package desafio_logicaUnidad5;

import java.io.File;

import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class Ejercicio3 {

	private static final String DIR_EJER2 = "dirEjer2";

	private static final String RUTACARPETA = System.getProperty("user.dir") + File.separator + DIR_EJER2;

	public static void main(String[] args) {

		// Crea el fichero .dat que pide el ejercicio
		Ejercicio1_Unidad5.crearFicheros(RUTACARPETA, "Tres.dat");

		// Escribe los numeros en el archivo.
		escribirBinario(RUTACARPETA, "Tres.dat");

	}

	// Metodo que escribe los byte de los numeros que se van introduciendo en el
	// archivo indicado en el ejercicio.54

	public static boolean escribirBinario(String ruta, String nombre) {

		try {

			FileOutputStream escritorNumeros = new FileOutputStream(ruta + File.separator + nombre);

			boolean bandera = true;

			while (escritorNumeros != null && bandera) {

				int numerosIntroducidos = Integer.parseInt(
						JOptionPane.showInputDialog("Escribe los numeros que quieres escribir en el archivo"));

				if (numerosIntroducidos > 0) {

					escritorNumeros.write(numerosIntroducidos);

				} else {

					JOptionPane.showMessageDialog(null, "Numero introducido incorrecto, se cancela la ejecución.");
					bandera = false;

				}

			}
			escritorNumeros.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "No se ha podido escribir el archivo");

			return false;
		}

		return true;
	}

}
