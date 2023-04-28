package libreria.java.instituto;

public class Profesor {
	private String dni;
	private String nombre;
	private String telefono;
	public Profesor(String dni, String nombre, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Profesor [dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
	

}
