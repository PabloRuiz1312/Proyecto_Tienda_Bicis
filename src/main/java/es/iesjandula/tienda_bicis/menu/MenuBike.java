package es.iesjandula.tienda_bicis.menu;
import java.sql.*;
import es.iesjandula.tienda_bici.clasesbase.Bike;
/**
 * 
 * @author Pablo Elias Ruiz Canovas
 * This class create, update, delete and search bikes
 */
public class MenuBike {
	//Statement to realize (prepared to insert,update or delete syntax)
	private PreparedStatement statement = null;
	//Statement to search the identifier of the client
	private Statement searchID = null;
	//Result of the statement
	private ResultSet resultSet = null;
	//Syntax of the statement
	private String syntax = null;
	/**
	 * This method create a new bike in the database
	 * @param connection to database
	 * @param mark of the bike
	 * @param numWheel of the bike
	 * @param bikeType of the bike
	 * @param gender to the client that buy the bike
	 */
	public void create(Connection connection,String mark,int numWheel,String bikeType,String gender)
	{
		int bikeID = 0;
		try
		{
			this.syntax = "SELECT ID FROM Bicicleta";
			this.searchID = connection.createStatement();
			this.resultSet = this.searchID.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				bikeID = this.resultSet.getInt("ID");
			}
			bikeID++;
			this.syntax = "INSERT INTO Bicicleta (ID,Marca,Num_Rueda,Tipo_Bici,Genero) VALUES (?,?,?,?,?)";
			this.statement = connection.prepareStatement(this.syntax);
			this.statement.setInt(1,bikeID);
			this.statement.setString(2,mark);
			this.statement.setInt(3,numWheel);
			this.statement.setString(4, bikeType);
			this.statement.setString(5,gender);
			this.statement.executeUpdate();
			System.out.println("Bike create susccesfully");
			
		}catch(SQLException e)
		{
			System.out.println("Error creating a bike");
		}
	}
	/**
	 * This method update a mark of a bike
	 * @param connection to database
	 * @param bikeID identifier of the bike
	 * @param newMark to update
	 */
	public void updateMark(Connection connection,int bikeID,String newMark)
	{
		try
		{
			this.syntax = "SELECT * FROM Bicicleta WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.resultSet = this.searchID.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println("Old bike");
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Marca")
				+"\t"+this.resultSet.getString("Num_Rueda")+"\t"+this.resultSet.getString("Tipo_Bici")
				+"\t"+this.resultSet.getString("Genero"));
			}
			this.syntax = "UPDATE Bicicleta SET Marca = ? WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.statement.setString(1, newMark);
			this.statement.setInt(2, bikeID);
			this.statement.executeUpdate();
			this.syntax = "SELECT * FROM Bicicleta WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.resultSet = this.searchID.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println("New bike");
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Marca")
				+"\t"+this.resultSet.getString("Num_Rueda")+"\t"+this.resultSet.getString("Tipo_Bici")
				+"\t"+this.resultSet.getString("Genero"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error updating mark");
		}
	}
	/**
	 * This method update a number of wheel of a bike
	 * @param connection to database
	 * @param bikeID identifier of a bike
	 * @param numWheel to update
	 */
	public void updateNumWheel(Connection connection,int bikeID,int numWheel)
	{
		try
		{
			this.syntax = "SELECT * FROM Bicicleta WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.resultSet = this.searchID.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println("Old bike");
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Marca")
				+"\t"+this.resultSet.getString("Num_Rueda")+"\t"+this.resultSet.getString("Tipo_Bici")
				+"\t"+this.resultSet.getString("Genero"));
			}
			this.syntax = "UPDATE Bicicleta SET Num_Rueda = ? WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.statement.setInt(1, numWheel);
			this.statement.setInt(2, bikeID);
			this.statement.executeUpdate();
			this.syntax = "SELECT * FROM Bicicleta WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.resultSet = this.searchID.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println("New bike");
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Marca")
				+"\t"+this.resultSet.getString("Num_Rueda")+"\t"+this.resultSet.getString("Tipo_Bici")
				+"\t"+this.resultSet.getString("Genero"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error updating number of wheel");
		}
	}
	/**
	 * This method update a type of bike of a bike
	 * @param connection to a database
	 * @param bikeID identifier of a bike
	 * @param newTypeBike to update
	 */
	public void updateBikeType(Connection connection,int bikeID,String newTypeBike)
	{
		try
		{
			this.syntax = "SELECT * FROM Bicicleta WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.resultSet = this.searchID.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println("Old bike");
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Marca")
				+"\t"+this.resultSet.getString("Num_Rueda")+"\t"+this.resultSet.getString("Tipo_Bici")
				+"\t"+this.resultSet.getString("Genero"));
			}
			this.syntax = "UPDATE Bicicleta SET Tipo_Bici = ? WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.statement.setString(1, newTypeBike);
			this.statement.setInt(2, bikeID);
			this.statement.executeUpdate();
			this.syntax = "SELECT * FROM Bicicleta WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.resultSet = this.searchID.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println("New bike");
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Marca")
				+"\t"+this.resultSet.getString("Num_Rueda")+"\t"+this.resultSet.getString("Tipo_Bici")
				+"\t"+this.resultSet.getString("Genero"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error updating type of bike");
		}
	}
	/**
	 * This method 
	 * @param connection
	 * @param bikeID
	 * @param newGender
	 */
	public void updateGender(Connection connection,int bikeID,String newGender)
	{
		try
		{
			this.syntax = "SELECT * FROM Bicicleta WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.resultSet = this.searchID.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println("Old bike");
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Marca")
				+"\t"+this.resultSet.getString("Num_Rueda")+"\t"+this.resultSet.getString("Tipo_Bici")
				+"\t"+this.resultSet.getString("Genero"));
			}
			this.syntax = "UPDATE Bicicleta SET Genero = ? WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.statement.setString(1, newGender);
			this.statement.setInt(2, bikeID);
			this.statement.executeUpdate();
			this.syntax = "SELECT * FROM Bicicleta WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.resultSet = this.searchID.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println("New bike");
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Marca")
				+"\t"+this.resultSet.getString("Num_Rueda")+"\t"+this.resultSet.getString("Tipo_Bici")
				+"\t"+this.resultSet.getString("Genero"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error updating gender");
		}
	}
	/**
	 * This method delete a bike from the database
	 * @param connection
	 * @param bikeID
	 */
	public void delete(Connection connection, int bikeID)
	{
		try
		{
			this.syntax = "SELECT * FROM Bicicleta WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.resultSet = this.searchID.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println("Bike to remove");
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Marca")
				+"\t"+this.resultSet.getString("Num_Rueda")+"\t"+this.resultSet.getString("Tipo_Bici")
				+"\t"+this.resultSet.getString("Genero"));
			}
			this.syntax = "DELETE FROM Bicicleta WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.statement.setInt(1,bikeID);
			this.statement.executeUpdate();
			System.out.println("Bike remove succesfully");
		}catch(SQLException e)
		{
			System.out.println("Error deleting the bike");
		}
	}
	/**
	 * This method search a bike by his identifier
	 * @param connection to a database
	 * @param bikeID identifier of a bike
	 * @return the bike that is search
	 */
	public Bike read(Connection connection, int bikeID)
	{
		Bike bike = null;
		String mark = null,bikeType = null,gender = null;
		int numWheel = 0;
		try
		{
			this.syntax = "SELECT * FROM Bicicleta WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.statement.setInt(1, bikeID);
			this.resultSet = this.statement.executeQuery();
			while(this.resultSet.next())
			{
				mark = this.resultSet.getString("Marca");
				numWheel = this.resultSet.getInt("Num_Rueda");
				bikeType = this.resultSet.getString("Tipo_Bici");
				gender = this.resultSet.getString("Genero");
			}
			bike = new Bike(bikeID,mark,numWheel,bikeType,gender);
		}catch(SQLException e)
		{
			System.out.println("Error searching a bike");
		}
		return bike;
	}
}
