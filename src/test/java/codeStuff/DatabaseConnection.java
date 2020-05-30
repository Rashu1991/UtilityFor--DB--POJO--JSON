package codeStuff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static DatabaseConnection dbInstance=null;
	private Connection conn;
	private DatabaseConnection() throws SQLException {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=User;integratedSecurity=true;");
		
	}

	public static DatabaseConnection getInstance() throws SQLException {
		
		if(dbInstance==null)
			dbInstance = new DatabaseConnection();
		else if(dbInstance.getConnection().isClosed())
			dbInstance = new DatabaseConnection();
		return dbInstance;
	}
	
	public Connection getConnection() {
		return conn;
	}
}
