package es.iesjandula.tienda_bici.menu;
import java.sql.*;
import es.iesjandula.tienda_bici.clasesbase.Client;
import es.iesjandula.tienda_bici.interfaces.CheckIdClient;
/**
 * 
 * @author Pablo Elias Ruiz Canovas
 * This class create, update, delete or search a client
 */
public class MenuClient implements CheckIdClient {
	//Statement to realize (prepared to insert,update or delete syntax)
	private PreparedStatement statement = null;
	//Statement to search the identifier of the client
	private Statement searchID = null;
	//Result of the statement
	private ResultSet resultSet = null;
	//Syntax of the statement
	private String syntax = null;
	/**
	 * This method insert a new client in the database
	 * @param connection to database
	 * @param name of the client
	 * @param age of the client 
	 * @param gender of the client
	 */
	public void create(Connection connection,String name,int age,String gender)
	{
		int clientID = 0;
		try
		{
			this.syntax = "SELECT ID FROM Cliente";
			this.searchID = connection.createStatement();
			this.resultSet = this.searchID.executeQuery(syntax);
			while(this.resultSet.next())
			{
				clientID = this.resultSet.getInt("ID");
			}
			clientID++;
			this.syntax = "INSERT INTO Cliente (ID,Nombre,Edad,Genero) VALUES (?,?,?,?)";
			this.statement = connection.prepareStatement(this.syntax);
			this.statement.setInt(1,clientID);
			this.statement.setString(2,name);
			this.statement.setInt(3,age);
			this.statement.setString(4,gender);
			this.statement.executeUpdate();
			System.out.println("Ok client with id "+clientID+"name "+name+" age "+age+" and gender "+gender+" has been insert in the database");
		}catch(SQLException e)
		{
			System.out.println("Error creating the client");
		}
	}
	/**
	 * This method update the name of the client
	 * @param connection to database
	 * @param clientID identifier of the client
	 * @param newName to update 
	 */
	public void updateName(Connection connection,int clientID ,String newName)
	{
		if(check(connection, clientID))
		{
			try
			{
				this.syntax = "SELECT * FROM Cliente WHERE ID = ?";
				this.statement = connection.prepareStatement(this.syntax);
				this.statement.setInt(1,clientID);
				this.resultSet = this.statement.executeQuery();
				while(this.resultSet.next())
				{
					System.out.println("Older client");
					System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
					+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
				}
				this.syntax = "UPDATE Cliente SET Nombre = ? WHERE ID = ?";
				this.statement = connection.prepareStatement(this.syntax);
				this.statement.setString(1,newName);
				this.statement.setInt(2,clientID);
				this.statement.executeUpdate();
				this.syntax = "SELECT * FROM Cliente WHERE ID = ?";
				this.statement = connection.prepareStatement(this.syntax);
				this.statement.setInt(1,clientID);
				this.resultSet = this.statement.executeQuery();
				while(this.resultSet.next())
				{
					System.out.println("New client");
					System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
					+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
				}
			}catch(SQLException e)
			{
				System.out.println("Error updating the client");
			}
		}
		else
		{
			System.out.println("The id "+clientID+" doesnt exist");
		}
	}
	/**
	 * This method update the age of the client
	 * @param connection to database
	 * @param clientID identifier of the client
	 * @param newAge to update
	 */
	public void updateAge(Connection connection,int clientID,int newAge)
	{
		if(check(connection, clientID))
		{
			try
			{
				this.syntax = "SELECT * FROM Cliente WHERE ID = ?";
				this.statement = connection.prepareStatement(this.syntax);
				this.statement.setInt(1,clientID);
				this.resultSet = this.statement.executeQuery();
				while(this.resultSet.next())
				{
					System.out.println("Older client");
					System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
					+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
				}
				this.syntax = "UPDATE Cliente SET Edad = ? WHERE ID = ?";
				this.statement = connection.prepareStatement(this.syntax);
				this.statement.setInt(1,newAge);
				this.statement.setInt(2,clientID);
				this.statement.executeUpdate();
				this.syntax = "SELECT * FROM Cliente WHERE ID = ?";
				this.statement = connection.prepareStatement(this.syntax);
				this.statement.setInt(1,clientID);
				this.resultSet = this.statement.executeQuery();
				while(this.resultSet.next())
				{
					System.out.println("New client");
					System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
					+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
				}
			}catch(SQLException e)
			{
				System.out.println("Error updating the client");
			}
		}
		else
		{
			System.out.println("The id "+clientID+" doesnt exist");
		}
	}
	/**
	 * This method update the gender of the client
	 * @param connection to database
	 * @param clientID identifier of the client
	 * @param newGender to update
	 */
	public void updateGender(Connection connection,int clientID,String newGender)
	{
		if(check(connection, clientID))
		{
			try
			{
				this.syntax = "SELECT * FROM Cliente WHERE ID = ?";
				this.statement = connection.prepareStatement(this.syntax);
				this.statement.setInt(1,clientID);
				this.resultSet = this.statement.executeQuery();
				while(this.resultSet.next())
				{
					System.out.println("Older client");
					System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
					+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
				}
				this.syntax = "UPDATE Cliente SET Genero = ? WHERE ID = ?";
				this.statement = connection.prepareStatement(this.syntax);
				this.statement.setString(1,newGender);
				this.statement.setInt(2,clientID);
				this.statement.executeUpdate();
				this.syntax = "SELECT * FROM Cliente WHERE ID = ?";
				this.statement = connection.prepareStatement(this.syntax);
				this.statement.setInt(1,clientID);
				this.resultSet = this.statement.executeQuery();
				while(this.resultSet.next())
				{
					System.out.println("New client");
					System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
					+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
				}
			}catch(SQLException e)
			{
				System.out.println("Error updating the client");
			}
		}
		else
		{
			System.out.println("The id "+clientID+" doesnt exist");
		}
	}
	/**
	 * This method delete a client by his id
	 * @param connection to database
	 * @param clientID identifier of the client
	 */
	public void delete(Connection connection,int clientID) 
	{
		if(check(connection, clientID))
		{
			try
			{
				this.syntax = "SELECT * FROM Cliente WHERE ID = ?";
				this.statement = connection.prepareStatement(this.syntax);
				this.statement.setInt(1,clientID);
				this.resultSet = this.statement.executeQuery();
				while(this.resultSet.next())
				{
					System.out.println("Client to remove");
					System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
					+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
				}
				this.syntax = "DELETE FROM Cliente WHERE ID = ?";
				this.statement = connection.prepareStatement(this.syntax);
				this.statement.setInt(1, clientID);
				this.statement.executeUpdate();
				System.out.println("Client remove succesfully");
			}catch(SQLException e)
			{
				System.out.println("Error deleting the client");
			}
		}
		else
		{
			System.out.println("The id "+clientID+" doesnt exist");
		}
	}
	/**
	 * This method search a client by his id
	 * @param connection to database
	 * @param clientID identifier of the client
	 * @return the client that was searched
	 */
	public Client read(Connection connection, int clientID)
	{
		Client client = null;
		String name = null,gender = null;
		int age = 0;
		if(check(connection, clientID))
		{
			try
			{
				this.syntax = "SELECT * FROM Cliente WHERE ID = ?";
				this.statement = connection.prepareStatement(this.syntax);
				this.statement.setInt(1, clientID);
				this.resultSet = this.statement.executeQuery();
				while(this.resultSet.next())
				{
					age = this.resultSet.getInt("Edad");
					name = this.resultSet.getString("Nombre");
					gender = this.resultSet.getString("Genero");
				}
				client = new Client (clientID,name,age,gender);
			}catch(SQLException e)
			{
				System.out.println("Error searching the client");
			}
		}
		else
		{
			System.out.println("The id "+clientID+" doesnt exist");
		}
		return client;
	}
	
}
