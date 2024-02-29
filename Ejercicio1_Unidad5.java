package desafio_logicaUnidad5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ejercicio1_Unidad5 {

	public static final String rutaArchivos = System.getProperty("user.dir");
	public static final String RutaCheck = rutaArchivos + File.separator;

	public static void main(String[] args) {

		/*
		 * He intentado usar el Main lo menos posible, condicionando solo las
		 * condiciones básicas de ejecución y dejando la ejecución más complicada dentro
		 * de los métodos.
		 * 
		 * Aclarar que los pasos en los que se exige la comprobación de si el fichero
		 * existe o no, suele hacerse en cada llamada a los métodos que corresponden
		 * (interior de estos).
		 */

		String primerNombre = preguntaNombre1();
		String segundoNombre = preguntaNombre2();

		if (!comprobarExiste(RutaCheck,primerNombre)) {

			crearFicheros(rutaArchivos, primerNombre);
		} else
			JOptionPane.showMessageDialog(null,
					"El nombre del archivo " + primerNombre + " ya existe y no se puede crear");

		if (!comprobarExiste(RutaCheck,segundoNombre)) {

			crearFicheros(rutaArchivos, segundoNombre);
		} else
			JOptionPane.showMessageDialog(null,
					"El nombre del archivo " + segundoNombre + " ya existe y no se puede crear");
		
		// Imprimo la carpeta en la que se esta trabajando.

		System.out.println("El directorio actual es: " + System.getProperty("user.dir"));
		
		
		//Inicio el procedimiento de preguntas al usuario.

		String archivoAEscribir = JOptionPane.showInputDialog(null, "¿Que archivo quieres escribir?");

		escribirEnFichero(archivoAEscribir + ".txt");
		
		

		String archivoALeer = JOptionPane.showInputDialog(null, "¿Que archivo quieres leer?");
		
		leerDeFichero(RutaCheck,archivoALeer + ".txt");
		

		String nombreArchivoDatos = JOptionPane.showInputDialog(null, "¿De que archivo quieres saber los datos?");

		datosFichero(nombreArchivoDatos + ".txt");

		/* Se hace duplicar la informacion del fichero 1 al 2 directamente: */

		duplicarFicheros(primerNombre, segundoNombre);

		/* Borro el primer fichero creado */

		borrarFichero(primerNombre);
		
		//Lee los ficheros.

		leerDeFichero(RutaCheck,segundoNombre);
		
		// Crea directorio.

		crearDirectorio("dirEjer1");

	}

	/*
	 * Los métodos preguntaNombre1 y preguntaNombre2 funcionan prácticamente igual.
	 * Inician un bucle while que comprueba la longitud del nombre y se mantiene en
	 * bucle, mientras no tenga como mínimo una longitud de 3 caracteres:
	 */

	public static String preguntaNombre1() {

		String nombrePrimerFichero = "";

		while (nombrePrimerFichero.length() < 3) {

			nombrePrimerFichero = JOptionPane
					.showInputDialog("Introduce el nombre del primer fichero que quieres crear: ");

			if (nombrePrimerFichero.length() < 3) {

				JOptionPane.showMessageDialog(null,
						"El nombre del primer fichero es demasiado corto. Introduce un nombre con al menos 4 caracteres.");
			}

		}

		return nombrePrimerFichero + ".txt";
	}

	public static String preguntaNombre2() {

		String nombreSegundoFichero = "";

		while (nombreSegundoFichero.length() < 3) {

			nombreSegundoFichero = JOptionPane
					.showInputDialog("Introduce el nombre del segundo fichero que quieres crear: ");

			if (nombreSegundoFichero.length() < 3) {

				JOptionPane.showMessageDialog(null,
						"El nombre del segundo fichero es demasiado corto. Introduce un nombre con al menos 3 caracteres.");

			}
		}
		return nombreSegundoFichero + ".txt";
	}

	/*
	 * El método crearFichero usa la estructura básica para tal fin. Luego, en el
	 * Main, comprueba si existe o no y después de introducir el nombre, te dice si
	 * el archivo existe o no. En función de esto, crea o no el archivo:
	 */

	public static boolean crearFicheros(String rutaArchivo, String nombreFichero) {

		File lector;

		try {

			lector = new File(rutaArchivo + File.separator + nombreFichero);

			lector.createNewFile();

		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "No se ha podido crear el archivo");
			System.out.println(e.getMessage());

			return false;
		}

		return true;
	}

	/*
	 * Método que utiliza funciones de la clase File para devolver un booleano. Este
	 * booleano se utiliza posteriormente para realizar las comprobaciones
	 * requeridas por el ejercicio:
	 */

	public static boolean comprobarExiste(String Ruta ,String nombreArchivo) {

		
		File comprobador = new File(Ruta , nombreArchivo);

		return comprobador.exists();
	}

	/*
	 * Método para escribir en un archivo. Devuelve true si se ha escrito
	 * correctamente, false en caso contrario:
	 */

	public static boolean escribirEnFichero(String nombreArchivo) {

		FileWriter escritor;

		if (comprobarExiste(RutaCheck,nombreArchivo)) {

			try {

				escritor = new FileWriter(rutaArchivos + File.separator + nombreArchivo);

				for (int i = 0; i <= 10; i++) {

					escritor.write(String.valueOf(i + "\n"));
				}

				escritor.close();

				return true;

			} catch (IOException e) {

				JOptionPane.showMessageDialog(null, "El archivo no se ha podido escribir");
			}

		}
		return false;

	}

	/*
	 * Método para leer contenido de un archivo. Devuelve true si se ha leído
	 * correctamente, false en caso contrario:
	 */

	public static boolean leerDeFichero(String ruta,String nombreArchivo) {

		if (comprobarExiste(ruta,nombreArchivo)) {

			try {

				FileReader lector = new FileReader(ruta + nombreArchivo);

				int entrada = lector.read();

				while (entrada != -1) {

					System.out.print((char) entrada);
					entrada = lector.read();

				}

				lector.close();

				return true;

			} catch (IOException e) {

				JOptionPane.showMessageDialog(null, "El archivo no se puede leer");
			}

		}

		return false;
	}

	/*
	 * // Método para obtener información sobre un archivo. Usando los metodos de la
	 * clase File:
	 */

	public static void datosFichero(String nombreFichero) {

		File datos;

		if (comprobarExiste(RutaCheck,nombreFichero)) {

			datos = new File(rutaArchivos + File.separator + nombreFichero);

			System.out.println("--------------------------------------------------------");

			System.out.println("El nombre del archivo es: " + datos.getName());
			System.out.println("La ruta absoluta del archivo solicitado es : " + datos.getAbsolutePath());
			System.out.println("La ruta del directorio padre es: " + datos.getParent());
			System.out.println("El tamaño del fichero es: " + datos.getTotalSpace());

			if (datos.isDirectory()) {
				System.out.println("Es un fichero un directorio");

			} else
				System.out.println("Es un fichero");

			System.out.println("¿Tiene permiso de lectura?: " + datos.canRead());
			System.out.println("¿Tiene permiso de escritura?: " + datos.canWrite());
			System.out.println("¿Tiene permiso de ejecucion?: " + datos.canExecute());
			System.out.println("¿Esta oculto? " + datos.isHidden());

			System.out.println("--------------------------------------------------------");

		} else
			JOptionPane.showMessageDialog(null, "El archivo del que quieres informacion no existe");
	}

	/*
	 * El seguiente metodo duplicara la informacion del archivo1 que se pase por
	 * parametros al archivo 2. Con este metodo tambien se podria clonar los
	 * archivos completamente ya que almacena la composicion de bytes:
	 */

	public static boolean duplicarFicheros(String nombreArchivo1, String nombreArchivo2) {

		try {

			boolean finalArchivo = false;

			FileInputStream archivoEntrada = new FileInputStream(rutaArchivos + File.separator + nombreArchivo1);
			FileOutputStream clon = new FileOutputStream(rutaArchivos + File.separator + nombreArchivo2);

			while (!finalArchivo) {

				int byteArchivo = archivoEntrada.read();

				if (byteArchivo != -1) {

					clon.write(byteArchivo);

				} else {

					finalArchivo = true;
				}
			}

			archivoEntrada.close();
			clon.close();

			return true;

		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "El archivo no se ha podido copiar");
		}

		return false;
	}

	public static void borrarFichero(String nombreArchivo1) {

		File borrado = new File(rutaArchivos + File.separator + nombreArchivo1);

		borrado.delete();

	}

	/*
	 * Este metodo crea un directorio con el nombre que se le indique si es que no
	 * existe.
	 */

	public static void crearDirectorio(String NombreDirectorio) {

		if (!comprobarExiste(RutaCheck,NombreDirectorio)) {

			File crearDirectorio = new File(rutaArchivos + File.separator + NombreDirectorio);

			crearDirectorio.mkdir();

			JOptionPane.showMessageDialog(null, "Directorio creado exitosamente");

		} else {
			JOptionPane.showMessageDialog(null, "El directorio ya existe");
		}
	}
}
