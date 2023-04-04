package es.iesjandula.tienda_bici.menu;
import java.sql.*;
import es.iesjandula.tienda_bici.clasesbase.PurchaseRecord;
import es.iesjandula.tienda_bici.interfaces.*;
/**
 * This class create, update,delete and search a purchase record
 * @author Pablo Elias Ruiz Canovas
 *
 */
public class MenuPurchase implements CheckIdClient,CheckIdBike {
	//Statement to realize (prepared to insert,update or delete syntax)
	private PreparedStatement statement = null;
	//Statement to search the identifier of the client
	private Statement searchID = null;
	//Result of the statement
	private ResultSet resultSet = null;
	//Syntax of the statement
	private String syntax = null;
	/**
	 * This method create a purchase record when a client buy a bike
	 * @param connection
	 * @param clientID
	 * @param bikeID
	 * @param date
	 */
	public void create(Connection connection,int clientID,int bikeID,String date)
	{
		int purchaseID = 0;
		if(checkClient(connection, clientID) && checkBike(connection, bikeID))
		{
			try
			{
				this.syntax = "SELECT ID_Registro FROM registro_compra";
				this.searchID = connection.createStatement();
				this.resultSet = this.searchID.executeQuery(this.syntax);
				while(this.resultSet.next())
				{
					purchaseID = this.resultSet.getInt("ID_Registro");
				}
				purchaseID++;
				this.syntax = "INSERT INTO registro_compra (ID_Cliente,ID_Bicicleta,ID_Registro,Fecha_Compra) VALUES (?,?,?,?)";
				this.statement = connection.prepareStatement(this.syntax);
				this.statement.setInt(1, clientID);
				this.statement.setInt(2, bikeID);
				this.statement.setInt(3, purchaseID);
				this.statement.setString(4, date);
				this.statement.executeUpdate();
				System.out.println("Purchase record create");
			}catch(SQLException e)
			{
				System.out.println("Error creating a purchase record");
			}
		}
		else
		{
			System.out.println("The client id "+clientID+" and bike id "+bikeID+" doesnt exist or dont match");
		}
	}
	/**
	 * This method update a purchase date of a purchase record
	 * @param connection
	 * @param purchaseID
	 * @param newDate
	 */
	public void updateDate(Connection connection,int purchaseID,String newDate)
	{
		try
		{
			this.syntax = "SELECT * FROM registro_compra WHERE ID_Registro = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.statement.setInt(1, purchaseID);
			this.resultSet = this.statement.executeQuery();
			while(this.resultSet.next())
			{
				System.out.println("Older purchase record");
				System.out.println(this.resultSet.getString("ID_Cliente")+"\t"+this.resultSet.getString("ID_Bicicleta")
				+"\t"+this.resultSet.getString("ID_Registro")+"\t"+this.resultSet.getString("Fecha_Compra"));
			}
			this.syntax = "UPDATE registro_compra SET Fecha_Compra = ? WHERE ID_Registro ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.statement.setString(1, newDate);
			this.statement.setInt(2, purchaseID);
			this.statement.executeUpdate();
			this.syntax = "SELECT * FROM registro_compra WHERE ID_Registro = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.statement.setInt(1, purchaseID);
			this.resultSet = this.statement.executeQuery();
			while(this.resultSet.next())
			{
				System.out.println("New purchase record");
				System.out.println(this.resultSet.getString("ID_Cliente")+"\t"+this.resultSet.getString("ID_Bicicleta")
				+"\t"+this.resultSet.getString("ID_Registro")+"\t"+this.resultSet.getString("Fecha_Compra"));
			}
			
		}catch(SQLException e)
		{
			System.out.println("Error updating the date");
		}
	}
	/**
	 * This method search a purchase record by his id
	 * @param connection
	 * @param purchaseID
	 * @return
	 */
	public PurchaseRecord delete(Connection connection, int purchaseID)
	{
		PurchaseRecord purchaseRecord = null;
		int clientID = 0,bikeID = 0;
		String date = null;		
		try
		{
			this.syntax = "SELECT * FROM registro_compra WHERE ID_Registro = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.statement.setInt(1, purchaseID);
			this.resultSet = this.statement.executeQuery();
			while(this.resultSet.next())
			{
				clientID = this.resultSet.getInt("ID_Cliente");
				bikeID = this.resultSet.getInt("ID_Bicicleta");
				date = this.resultSet.getString("Fecha_Compra");
			}
			purchaseRecord = new PurchaseRecord (clientID,bikeID,purchaseID,date);
			
		}catch(SQLException e)
		{
			System.out.println("Error deleting a purchase record");
		}
		return purchaseRecord;
	}
}
