package desafio_logicaUnidad5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Ejercicio4 {

	private static final String DIR_EJER2 = "dirEjer2";
	private static final String RUTACARPETA = System.getProperty("user.dir") + File.separator + DIR_EJER2;

	private static Persona[] personas = new Persona[5];

	public static void main(String[] args) {

		// Se crean las instancias de la clase persona dentro de un array con el
		// objetivo de escribir y leer los datos despues.

		personas[0] = new Persona("Ezequiel", "Guerrero", 33, 1.88);
		personas[1] = new Persona("Maria", "España", 35, 1.50);
		personas[2] = new Persona("Daniel", "DeSevilla", 45, 1.78);
		personas[3] = new Persona("Patricia", "Guerrero", 28, 1.68);
		personas[4] = new Persona("Juanjo", "Tome", 29, 1.68);

		guardarObjetos(RUTACARPETA, "Persona.dat");

		lectorObjetos(RUTACARPETA, "Persona.dat");

	}

	// Metodo que guarda los objetos de la clase persona, aclarar que la clase
	// persona implementa la interface Serializable.

	public static boolean guardarObjetos(String ruta, String nombreArchivo) {

		try {

			ObjectOutputStream guardar = new ObjectOutputStream(
					new FileOutputStream(ruta + File.separator + nombreArchivo));

			guardar.writeObject(personas);

			guardar.close();

			JOptionPane.showMessageDialog(null, "Objeto guardado correctamente");

		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "No se han podido guardar los objetos");

			return false;
		}
		return true;
	}

	// Lectura de los datos de entrada.

	public static boolean lectorObjetos(String ruta, String nombre) {

		try {

			ObjectInputStream entradaObjeto = new ObjectInputStream(
					new FileInputStream(ruta + File.separator + nombre));

			Persona[] personas = (Persona[]) entradaObjeto.readObject();

			for (Persona p : personas) {

				System.out.println(p.toString());

			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "No se ha podido leer el archivo");
			return false;
		}
		return true;

	}

}
