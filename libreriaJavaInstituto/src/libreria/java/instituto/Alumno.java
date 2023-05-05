package libreria.java.instituto;

public class Alumno {
	private int numMatrícula;
	private String nombre;
	private String fechaNacimiento;
	private String telefono;
	
	
	public Alumno(int numMatrícula, String nombre, String fechaAlta, String telefono) {
		super();
		this.numMatrícula = numMatrícula;
		this.nombre = nombre;
		this.fechaNacimiento = fechaAlta;
		this.telefono = telefono;
	}


	public int getNumMatrícula() {
		return numMatrícula;
	}


	public void setNumMatrícula(int numMatrícula) {
		this.numMatrícula = numMatrícula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaAlta(String fechaAlta) {
		this.fechaNacimiento = fechaAlta;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Override
	public String toString() {
		return "Alumno [numMatrícula=" + numMatrícula + ", nombre=" + nombre + ", fechaAlta=" + fechaNacimiento
				+ ", telefono=" + telefono + "]";
	}
	
	
}
