package es.iesjandula.tienda_bici.stats;
import java.sql.*;
import java.util.Arrays;
/**
 * This method show all purchase 
 * @author Pablo Elias Ruiz Canovas
 *
 */
public class StatsPurchase {
	//Statement to realize (prepared to insert,update or delete syntax)
	private PreparedStatement statement = null;
	//Statement to search the identifier of the client
	private Statement simpleStatement = null;
	//Result of the statement
	private ResultSet resultSet = null;
	//Syntax of the statement
	private String syntax;
	/**
	 * This method show all purchase
	 * @param connection to database
	 */
	public void showAllPurchase(Connection connection)
	{
		try
		{
			this.syntax = "SELECT * FROM Registro_Compra";
			this.simpleStatement = connection.createStatement();
			this.resultSet = this.simpleStatement.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				System.out.println(this.resultSet.getString("ID_Cliente")+"\t"+this.resultSet.getString("ID_Bicicleta")
				+"\t"+this.resultSet.getString("ID_Registro")+"\t"+this.resultSet.getString("Fecha_Compra"));
			}
		}catch(SQLException e)
		{
			System.out.println("Error searching purchase");
		}
	}
	/**
	 * This method show the client that buy more bikes
	 * @param connection to database
	 */
	public void showBestClient(Connection connection)
	{
		int clientID = 0,cont = 0;
		int saveID [] = new int [0],saveCont[] = new int [0];
		try
		{
			this.syntax = "SELECT ID_Cliente FROM Registro_Compra ORDER BY ID_Cliente";
			this.simpleStatement = connection.createStatement();
			this.resultSet = this.simpleStatement.executeQuery(this.syntax);
			while(this.resultSet.next())
			{
				clientID = this.resultSet.getInt("ID_Cliente");
				if(saveID.length==0)
				{
					saveID = Arrays.copyOf(saveID, saveID.length+1);
					saveID[saveID.length-1] = clientID;
					saveCont = Arrays.copyOf(saveCont, saveCont.length+1);
					saveCont[saveCont.length-1] = cont;
					cont++;
				}else
				{
					if(saveID[saveID.length-1]==clientID)
					{
						cont++;
						saveCont[saveCont.length-1] = cont;
					}
					else
					{
						
						saveID = Arrays.copyOf(saveID, saveID.length+1);
						saveID[saveID.length-1] = clientID;
						cont=0;
						saveCont = Arrays.copyOf(saveCont, saveCont.length+1);
						saveCont[saveCont.length-1] = cont;
					}
				}	
			}
			for(int i=0;i<saveCont.length;i++)
			{
				cont = saveCont[i];
				for(int j = i;j<saveCont.length;j++)
				{
					if(cont>saveCont[j])
					{
						clientID = saveID[i];
					}
				}
			}
			this.syntax = "SELECT * FROM Cliente WHERE ID = ?";
			this.statement = connection.prepareStatement(this.syntax);
			this.statement.setInt(1, clientID);
			this.resultSet = statement.executeQuery();
			while(this.resultSet.next())
			{
				System.out.println("Th eclient that buy more bikes is:");
				System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
				+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
			}	
		}catch(SQLException e) 
		{
			System.out.println("Error searching client");
		}
	}
	/**
	 * This method show the clients that don't buy a bike
	 * @param connection to database
	 */
	public void showWorstClient(Connection connection)
	{
		boolean show = false;
		try
		{
		int registerID [] = new int [0];
		int clientID [] = new int [0];
		this.syntax = "SELECT ID FROM Cliente ORDER BY ID";
		this.simpleStatement = connection.createStatement();
		this.resultSet = this.simpleStatement.executeQuery(this.syntax);
		while(this.resultSet.next())
		{
			clientID = Arrays.copyOf(clientID,clientID.length+1);
			clientID[clientID.length-1] = this.resultSet.getInt("ID");
		}
		this.syntax = "SELECT DISTINCT ID_Cliente FROM Registro_Compra ORDER BY ID_Cliente";
		this.simpleStatement = connection.createStatement();
		this.resultSet = this.simpleStatement.executeQuery(this.syntax);
		while(this.resultSet.next())
		{
			registerID = Arrays.copyOf(registerID, registerID.length+1);
			registerID[registerID.length-1] = this.resultSet.getInt("ID_Cliente");
		}
		if(clientID.length!=registerID.length)
		{
			for(int i = 0;i<clientID.length;i++)
			{
				for(int j = 0;j<registerID.length;j++)
				{
					if(clientID[i]==registerID[j])
					{
						show = true;
						break;
					}
				}
				if(show == false)
				{
					this.syntax = "SELECT * FROM Cliente WHERE ID = ?";
					this.statement = connection.prepareStatement(this.syntax);
					this.statement.setInt(1, clientID[i]);
					this.resultSet = statement.executeQuery();
					while(this.resultSet.next())
					{
						System.out.println(this.resultSet.getString("ID")+"\t"+this.resultSet.getString("Nombre")
						+"\t"+this.resultSet.getString("Edad")+"\t"+this.resultSet.getString("Genero"));
					}
				}
				show = false;
			}
		}else
		{
			System.out.println("All clients buy at least one bike");
		}
		}catch(SQLException e)
		{
			System.out.println("ERror searching client");
		}
	}
}
