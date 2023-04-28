package libreria.java.instituto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection connection;
	
	public boolean connect(String connectionString) {
		try {
            //cargar el driver
            DriverManager.registerDriver (new com.mysql.cj.jdbc.Driver());

            //crear un objeto de conexión
            this.connection =
                    DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection==null?false:true;
	}
	
	 public Connection getConnection() {
         return this.connection;
     }
	 public boolean isConnected() {
         try {
             return !this.connection.isClosed();
         } catch (SQLException e) {
             e.printStackTrace();
             return false;
         }
     }

}
