package main.java.datastorage;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {
	
	private Connection connection;
	private Statement statement;
	private String host;
	private String name;
	private String pass;
	
	
	public DatabaseConnection() {
		connection = null;
		statement = null;
		String host = "jdbc:mysql://145.48.6.147:3306/23ivp4a3";
		String name = "23ivp4a3";
		String pass = "23ivp4a3";
	}
	
	public boolean openConnection() {
		
		if (connection == null){
			try{
				connection = DriverManager.getConnection(host, name, pass);
				if (connection != null){
					statement = connection.createStatement();
				}else{
					return false;
				}
				
			}catch (SQLException err){
				System.out.println(err.getMessage());
				return false;
			}
		}
		return true;
	}
	
	public boolean isConnectionOpen(){
		return connection != null && statement != null;
	}
	
	public Connection getOpenConnection(){
		return connection;
	}
	
	public boolean closeConnection() {
		if (connection != null){
			try{
				statement.close();
				connection.close();
			}catch (SQLException err){
				System.out.println(err.getMessage());
				return false;
			}
		}
		return true;
	}
	
	public boolean UpdateSQL(String command){
		
		if (isConnectionOpen()){
			try{
				statement.executeUpdate(command);
			}catch (SQLException err){
				System.out.println(err.getMessage());
				return false;
			}
		}else{
			return false;
		}
		return true;
	}
}
