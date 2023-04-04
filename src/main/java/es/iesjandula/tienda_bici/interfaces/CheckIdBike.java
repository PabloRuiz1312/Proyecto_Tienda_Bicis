package es.iesjandula.tienda_bici.interfaces;
import java.sql.*;
import java.util.Arrays;
/**
 * 
 * @author Pablo Elias Ruiz Canovas
 * This interface takes care of check that exist the client identifier that the user introduce
 */
public interface CheckIdBike {
	/**
	 * 
	 * @param connection
	 * @param bikeID
	 * @return
	 */
	default boolean check(Connection connection, int bikeID)
	{
		boolean exist = false;
		try
		{
			int saveId [] = new int [0];
			String syntax = "SELECT ID FROM Bicicleta";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(syntax);
			while(resultSet.next())
			{
				saveId = Arrays.copyOf(saveId, saveId.length+1);
				saveId[saveId.length-1] = resultSet.getInt("ID");
			}
			for (int i = 0;i<saveId.length;i++)
			{
				if(saveId[i]==bikeID)
				{
					exist = true;
					break;
				}
				else
				{
					exist = false;
				}
			}
		}catch(SQLException e)
		{
			System.out.println("Error checking id");
		}
		return exist;
	}
}
	
