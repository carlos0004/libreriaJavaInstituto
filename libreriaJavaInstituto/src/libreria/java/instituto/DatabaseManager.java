package libreria.java.instituto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.jdt.annotation.NonNull;
/**
 * Clase para realizar las operaciones con la base de datos
 * @author usuario
 *
 */
public class DatabaseManager {
	private Connection connection=null;
	private Statement statement=null;
	private DatabaseConnection databaseConnection =null;

	public DatabaseManager(@NonNull DatabaseConnection connection) {
		this.databaseConnection = connection;
	}

	/**
	 * Método para consultar alumnos a la base de datos
	 * @param ordenacion es un array que sirve para poder ordenar por columnas
	 * @return si se realiza la consulta devuelve un array con los resultados
	 */
	@SuppressWarnings("null")
	public ArrayList<Alumno> getAlumnos(ColunmOrder...ordenacion ){
		Connection connection=null;
		ArrayList<Alumno> alumnos = null;
		String consultaSql="SELECT * FROM alumno";
		String orden=" ORDER BY ";
		if(ordenacion.length==0) {			
			try {
				connection=
						DriverManager.getConnection(this.databaseConnection.getConnectionString());
				PreparedStatement ps = connection.
						prepareStatement(consultaSql);
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
			}finally {
				this.databaseConnection.disconnect();
			}
			return alumnos;
		}else {
			for (ColunmOrder col : ordenacion) {
				orden+=col.getColumna() +  " " + col.getOrden() + ",";
			}
			orden= orden.substring(0, orden.length()-1);
			consultaSql+=orden;
			try {
				connection=
						DriverManager.getConnection(this.databaseConnection.getConnectionString());
				PreparedStatement ps = connection.
						prepareStatement(consultaSql);
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
			}finally {
				this.databaseConnection.disconnect();
			}
			return alumnos;
		}
	}

	/**
	 * Método para consultar los profesores de la base de datos
	 * @param ordenacion es un array que sirve para poder ordenar por columnas
	 * @return si se realiza la consulta devuelve un array con los resultados
	 */
	public ArrayList<Profesor> getProfesores(ColunmOrder...ordenacion){
		ArrayList<Profesor> profesores = null;
		String consultaSql="SELECT * FROM profesor";
		String orden=" ORDER BY ";
		if(ordenacion.length==0) {
			try {
				connection=
						DriverManager.getConnection(this.databaseConnection.getConnectionString());
				PreparedStatement ps = connection.
						prepareStatement(consultaSql);
				ResultSet rs = ps.executeQuery();
				profesores = new ArrayList<Profesor>();
				while(rs.next()) {
					profesores.add(new Profesor(rs.getString(1),
							rs.getString(2),
							rs.getString(3)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				this.databaseConnection.disconnect();
			}
			return profesores;

		}else {
			for (ColunmOrder col : ordenacion) {
				orden+=col.getColumna() +  " " + col.getOrden() + ",";
			}
			orden= orden.substring(0, orden.length()-1);
			consultaSql+=orden;
			try {
				connection=
						DriverManager.getConnection(this.databaseConnection.getConnectionString());
				PreparedStatement ps = connection.
						prepareStatement(consultaSql);
				ResultSet rs = ps.executeQuery();
				profesores = new ArrayList<Profesor>();
				while(rs.next()) {
					profesores.add(new Profesor(rs.getString(1),
							rs.getString(2),
							rs.getString(3)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				this.databaseConnection.disconnect();
			}
			return profesores;

		}

	}

	/**
	 * metodo para consultar las asignaturas de la base de datos
	 * @param ordenacion
	 * @return si se realiza la consulta devuelve un array con los resultados
	 */
	public ArrayList<Asignatura> getAsignaturas(ColunmOrder...ordenacion){
		ArrayList<Asignatura> asignaturas = null;
		String consultaSql="SELECT * FROM asignatura";
		String orden=" ORDER BY ";
		if(ordenacion.length==0) {

			try {
				connection=
						DriverManager.getConnection(this.databaseConnection.getConnectionString());
				PreparedStatement ps = connection.
						prepareStatement(consultaSql);
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
			}finally {
				this.databaseConnection.disconnect();
			}
			return asignaturas;
		}else {
			for (ColunmOrder col : ordenacion) {
				orden+=col.getColumna() +  " " + col.getOrden() + ",";
			}
			orden= orden.substring(0, orden.length()-1);
			consultaSql+=orden;
			try {
				connection=
						DriverManager.getConnection(this.databaseConnection.getConnectionString());
				PreparedStatement ps = connection.
						prepareStatement(consultaSql);
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
			}finally {
				this.databaseConnection.disconnect();
			}
			return asignaturas;	
		}
	}

	public ArrayList<Asignatura> getAsignatura(String campoBusqueda, String valor){
		ArrayList<Asignatura> asignaturas = null;
		try {
			connection=
					DriverManager.getConnection(this.databaseConnection.getConnectionString());
			
			PreparedStatement ps = connection.
					prepareStatement("SELECT * FROM asignatura where " + campoBusqueda + " =?");
			ps.setString(1,valor);
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
		}finally {
			this.databaseConnection.disconnect();
		}
		return asignaturas;
	}
	
	/**
	 * Metodo para eliminar un registro de la base de datos
	 * @param tabla
	 * @param filtros
	 * @return si se realiza la consulta devuelve true
	 */
	public boolean deleteRegistro(String tabla , HashMap<String, Object> filtros){
		boolean delete = false;
		String consultaSql = "DELETE FROM "  + tabla +  " WHERE ";
		try {
			for (String clave:filtros.keySet()) {
				String valor = (String) filtros.get(clave);
				consultaSql+= clave + " = " + valor + " AND ";
			}
			consultaSql=consultaSql.substring(0, consultaSql.length()- 5);
			connection=
					DriverManager.getConnection(this.databaseConnection.getConnectionString());
			
			PreparedStatement ps = connection.
					prepareStatement(consultaSql);
			delete = ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
			delete=false;
		}finally {
			this.databaseConnection.disconnect();
		}
		return delete;
	}

	public boolean updateAlumno(Alumno alumno) {
		boolean updated = false;
		try {
			connection=
					DriverManager.getConnection(this.databaseConnection.getConnectionString());
			
			PreparedStatement ps = connection.prepareStatement("UPDATE alumno SET nombre='" + alumno.getNombre() +
					"',fechaNacimiento='" + alumno.getFechaNacimiento() + "',telefono='" + alumno.getTelefono() +
					"' WHERE numMatricula=" + alumno.getNumMatrícula());
			updated= ps.executeUpdate()>0;
		}catch(SQLException e) {
			return updated;
		}finally {
			this.databaseConnection.disconnect();
		}

		return updated;
	}
	
	/**
	 * Método para actualizar los datos de una asignatura
	 * @param asignatura
	 * @return si se realiza la consulta devuelve true
	 */
	public boolean updateAsigntura(Asignatura asignatura) {
		boolean updated = false;
		try {
			connection=
					DriverManager.getConnection(this.databaseConnection.getConnectionString());
			
			PreparedStatement ps = connection.prepareStatement("UPDATE asignatura SET nombre='" + asignatura.getNombre() +
					"',profesor='" + asignatura.getProfesor() + "',dniProfesor='" + asignatura.getDniProfesor() +
					"' WHERE codAsignatura=" + asignatura.getCodAsignatura());
			updated= (ps.executeUpdate())>0;
		}catch(SQLException e) {
			return updated;
		}finally {
			this.databaseConnection.disconnect();
		}

		return updated;
	}
	/**
	 * Método para actualizar los datos de un profesor
	 * @param profesor
	 * @return si se realiza la consulta devuelve true
	 */
	public boolean updateProfesor(Profesor profesor) {
		boolean update=false;

		try {
			connection=
					DriverManager.getConnection(this.databaseConnection.getConnectionString());
			
			PreparedStatement ps = connection.prepareStatement("UPDATE profesor SET nombre='" + profesor.getNombre() +
					"' ,telefono= '" + profesor.getTelefono() + "' WHERE dni= '" +profesor.getDni() + "'");
			update=(ps.executeUpdate())>0;

		} catch (SQLException e) {
			e.printStackTrace();
			return update;
		}finally {
			this.databaseConnection.disconnect();
		}
		return update;
	}
	
	/**
	 * Método para añadir un alumno 
	 * @param alumno
	 * @return si se realiza la consulta devuelve true
	 */
	public boolean addAlumno(Alumno alumno) {		
		boolean added=false;
		try {
			connection=
					DriverManager.getConnection(this.databaseConnection.getConnectionString());
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO  alumno values (" 
					+ alumno.getNumMatrícula()+ ", '"+ alumno.getNombre() + "', '"+ alumno.getFechaNacimiento() +
					"', '" + alumno.getTelefono()+ "')");
			added = ps.executeUpdate()>0;

			return added;
		}catch(SQLException e) {
			return added;
		}finally {
			this.databaseConnection.disconnect();
		}
	}
	
	/**
	 * Método para añadir registros a la base de datos desde un xml
	 * @param consultaSql
	 * @return si se realiza la consulta devuelve un true
	 */
	public boolean addTable(String consultaSql) {		
		boolean added=false;
		try {
			connection=
					DriverManager.getConnection(this.databaseConnection.getConnectionString());
			
			PreparedStatement ps = connection.prepareStatement(consultaSql);
			added = ps.executeUpdate()>0;													
			return added;
		}catch(SQLException e) {
			return added;
		}finally {
			this.databaseConnection.disconnect();
		}
	}
	
	/**
	 * Método para añadir un profesor
	 * @param profesor
	 * @return si se realiza la consulta devuelve true
	 */ 
	public boolean addProfesor(Profesor profesor) {		
		boolean added=false;
		try {
			connection=
					DriverManager.getConnection(this.databaseConnection.getConnectionString());
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO  profesor values (" 
					+ profesor.getDni()+ ", '"+ profesor.getNombre() + "', '"+ profesor.getTelefono() + "')");
			added = ps.executeUpdate()>0;
			return added;
		}catch(SQLException e) {
			return added;
		}finally {
			this.databaseConnection.disconnect();
		}
	}
	
	/**
	 * Método para añadir una asignatura
	 * @param asignatura
	 * @return si se realiza la consulta devuelve un array con los resultados
	 */
	public boolean addAsignatura(Asignatura asignatura) {		
		boolean added=false;
		try {
			connection=
					DriverManager.getConnection(this.databaseConnection.getConnectionString());
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO  asignatura values (" 
					+ asignatura.getCodAsignatura()+ ", '"+ asignatura.getNombre() + "', '"+ asignatura.getDniProfesor() +
					"', '" + asignatura.getDniProfesor()+ "')");
			added = ps.executeUpdate()>0;

			return added;
		}catch(SQLException e) {
			return added;
		}finally {
			this.databaseConnection.disconnect();
		}
	}

}

