package modelo;

public class Persona {
	
	private int dni;
	private String nombre;
	
	public Persona(int dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}
	
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre +"]";
	}

	
}