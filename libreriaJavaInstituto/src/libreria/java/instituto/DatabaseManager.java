package libreria.java.instituto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DatabaseManager {
	private Connection connection=null;
	public DatabaseManager(Connection connection) {
		this.connection = connection;

	}		
	public ArrayList<Alumno> getAlumnos(){
		ArrayList<Alumno> alumnos = null;
		try {
			PreparedStatement ps = this.connection.
					prepareStatement("SELECT * FROM alumno");
			ResultSet rs = ps.executeQuery();
			alumnos = new ArrayList<Alumno>();
			while(rs.next()) {
				alumnos.add(new Alumno(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	
	public ArrayList<Profesor> getProfesores(){
		ArrayList<Profesor> profesores = null;
		try {
			PreparedStatement ps = this.connection.
					prepareStatement("SELECT * FROM profesor");
			ResultSet rs = ps.executeQuery();
			profesores = new ArrayList<Profesor>();
			while(rs.next()) {
				profesores.add(new Profesor(rs.getString(1),
						rs.getString(2),
						rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return profesores;
		
	}

	
	public ArrayList<Asignatura> getAsignaturas(){
		ArrayList<Asignatura> asignaturas = null;
		try {
			PreparedStatement ps = this.connection.
					prepareStatement("SELECT * FROM asignatura");
			ResultSet rs = ps.executeQuery();
			asignaturas = new ArrayList<Asignatura>();
			while(rs.next()) {
				asignaturas.add(new Asignatura(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return asignaturas;
		
	}
	
	public ArrayList<Recibe> getRecibe(){
		ArrayList<Recibe> recibes = null;
		try {
			PreparedStatement ps = this.connection.
					prepareStatement("SELECT * FROM recibe");
			ResultSet rs = ps.executeQuery();
			recibes = new ArrayList<Recibe>();
			while(rs.next()) {
				recibes.add(new Recibe(rs.getInt(1),
						rs.getInt(2),
						rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recibes;
		
	}
	public ArrayList<Alumno> getAlumnos(String campoOrdenacion, int valor){
		ArrayList<Alumno> alumnos = null;
		try {
			PreparedStatement ps = this.connection.
					prepareStatement("SELECT * FROM alumno where " + campoOrdenacion + " = ?");
			ps.setInt(1,valor);
			ResultSet rs = ps.executeQuery();
			alumnos = new ArrayList<Alumno>();
			while(rs.next()) {
				alumnos.add(new Alumno(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	
	

}
