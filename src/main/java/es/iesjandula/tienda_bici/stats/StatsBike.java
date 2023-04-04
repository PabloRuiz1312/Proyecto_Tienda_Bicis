package es.iesjandula.tienda_bici.stats;
import java.sql.*;
/**
 * 
 * @author Pablo Elias Ruiz Canovas
 * This class show all bikes
 */
public class StatsBike {
	//Statement to search the identifier of the client
	private Statement simpleStatement = null;
	//Result of the statement
	private ResultSet resultSet = null;
	//Syntax of the statement
	private String syntax;
	/**
	 * This method show all bikes
	 * @param connection to database
	 */
	public void showAllBikes(Connection connection)
	{
		try
		{
			this.syntax = "SELECT * FROM Bicicleta";
			this.simpleStatement = connection.createStatement();
			this.resultSet = this.simpleStatement.executeQuery(this.syntax);
			while(resultSet.next())
			{
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Marca")
				+"\t"+this.resultSet.getString("Num_Rueda")+"\t"+this.resultSet.getString("Tipo_Bici")
				+"\t"+this.resultSet.getString("Genero"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error searching bike");
		}
	}
	/**
	 * This method show the bikes that are for mens
	 * @param connection
	 */
	public void showMenBikes(Connection connection)
	{
		try
		{
			this.syntax = "SELECT * FROM Bicicleta WHERE Genero = 'H'";
			this.simpleStatement = connection.createStatement();
			this.resultSet = this.simpleStatement.executeQuery(this.syntax);
			while(resultSet.next())
			{
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Marca")
				+"\t"+this.resultSet.getString("Num_Rueda")+"\t"+this.resultSet.getString("Tipo_Bici")
				+"\t"+this.resultSet.getString("Genero"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error searching bike");
		}
	}
	/**
	 * This method show the bikes that are for womens
	 * @param connection
	 */
	public void showWomenBikes(Connection connection)
	{
		try
		{
			this.syntax = "SELECT * FROM Bicicleta WHERE Genero = 'M'";
			this.simpleStatement = connection.createStatement();
			this.resultSet = this.simpleStatement.executeQuery(this.syntax);
			while(resultSet.next())
			{
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Marca")
				+"\t"+this.resultSet.getString("Num_Rueda")+"\t"+this.resultSet.getString("Tipo_Bici")
				+"\t"+this.resultSet.getString("Genero"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error searching bike");
		}
	}
	/**
	 * This method show the bikes with other gender
	 * @param connection
	 */
	public void showOtherBikes(Connection connection)
	{
		try
		{
			this.syntax = "SELECT * FROM Bicicleta WHERE Genero = 'T'";
			this.simpleStatement = connection.createStatement();
			this.resultSet = this.simpleStatement.executeQuery(this.syntax);
			while(resultSet.next())
			{
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Marca")
				+"\t"+this.resultSet.getString("Num_Rueda")+"\t"+this.resultSet.getString("Tipo_Bici")
				+"\t"+this.resultSet.getString("Genero"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error searching bike");
		}
	}
}
