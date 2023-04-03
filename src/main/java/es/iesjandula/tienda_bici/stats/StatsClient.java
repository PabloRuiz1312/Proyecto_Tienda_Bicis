package es.iesjandula.tienda_bici.stats;
import java.sql.*;
/**
 * 
 * @author Pablo Elias Ruiz Canovas
 * This class show all clients 
 */
public class StatsClient {
	//Statement to search the identifier of the client
	private Statement simpleStatement = null;
	//Result of the statement
	private ResultSet resultSet = null;
	//Syntax of the statement
	private String syntax;
	/**
	 * This methos show all clients
	 * @param connection to database
	 */
	public void showClients(Connection connection)
	{
		try
		{
			this.syntax = "SELECT * FROM Cliente";
			this.simpleStatement = connection.createStatement();
			this.resultSet = this.simpleStatement.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
				+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error searching client");
		}
	}
	/**
	 * This method show the clients that aren't adults
	 * @param connection to database
	 */
	public void showMenorClients (Connection connection)
	{
		try
		{
			this.syntax = "SELECT * FROM Cliente WHERE edad < 18";
			this.simpleStatement = connection.createStatement();
			this.resultSet = this.simpleStatement.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
				+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error searching client");
		}
	}
	/**
	 * This method show the clients that are adults
	 * @param connection to database
	 */
	public void showMayorClients(Connection connection)
	{
		try
		{
			this.syntax = "SELECT * FROM Cliente WHERE edad > 18";
			this.simpleStatement = connection.createStatement();
			this.resultSet = this.simpleStatement.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
				+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error searching client");
		}
	}
	/**
	 * This mthod show the clients that are men
	 * @param connection to database
	 */
	public void showMenClients(Connection connection)
	{
		try
		{
			this.syntax = "SELECT * FROM Cliente WHERE Genero = 'Hombre'";
			this.simpleStatement = connection.createStatement();
			this.resultSet = this.simpleStatement.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
				+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error searching client");
		}
	}
	/**
	 * This method show the clients that are women
	 * @param connection to database
	 */
	public void showWomenClients(Connection connection)
	{
		try
		{
			this.syntax = "SELECT * FROM Cliente WHERE Genero = 'Mujer'";
			this.simpleStatement = connection.createStatement();
			this.resultSet = this.simpleStatement.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
				+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error searching client");
		}
	}
	/**
	 * This method show the clients that have other gender
	 * @param connection to database
	 */
	public void showOtherClients(Connection connection)
	{
		try
		{
			this.syntax = "SELECT * FROM Cliente WHERE Genero = 'Otro'";
			this.simpleStatement = connection.createStatement();
			this.resultSet = this.simpleStatement.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
				+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error searchin client");
		}
	}
}
