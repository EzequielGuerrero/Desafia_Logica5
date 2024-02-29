package desafio_logicaUnidad5;

import java.io.Serializable;

public class Persona implements Serializable {

	private final String nombre;

	private final String apellidos;

	private int edad;

	private final double altura;

	public Persona(String nombre, String apellidos, int edad, double altura) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.setEdad(edad);
		this.altura = altura;

	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public double getAltura() {
		return altura;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	//Metodo para que me imprima por pantalla las propiedades de los objetos

	public String toString() {
		return "El nombre de la persona es: " + getNombre() + " y los apellidos son: " + getApellidos()
				+ " con una altura de: " + getAltura() + " y con: " + getEdad() + " años de edad.";

	}

}
