package saborea.model.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class ConnectionSaborea {

private String db="databaseName=SABOREA;";
//ruta de acceso para nuestra base de datos
//jdbc =java, database connection, proovedor de base de datos,nuestro servidor, puerto por el cual vamos a trabajar y es por default=1433 + NombredeBASE DE DATOS;
private String user="user=userSQL;";
private String password="password=123";
private String url="jdbc:sqlserver://DESKTOP-1CPJ7G8\\SQLEXPRESS:1433;"+db+user+password;

//el driver para poder acceder de forma directa a la BD es
private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public Connection getConnection(){
	
	try {
		//esto es lo que vamos a devolver
		Connection link=null;
		//pone todo nuestro codigo 
		Class.forName(driver);
		link= DriverManager.getConnection(url);			
		return link;
		
	} catch (ClassNotFoundException e) {			
		JOptionPane.showMessageDialog(null, e.getMessage());
	} catch (SQLException e) {			
		JOptionPane.showMessageDialog(null, e.getMessage());
	}
		return null;
	}
}
	
	
