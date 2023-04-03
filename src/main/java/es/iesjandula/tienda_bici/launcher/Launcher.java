package es.iesjandula.tienda_bici.launcher;
import es.iesjandula.tienda_bici.clasesbase.*;
import es.iesjandula.tienda_bici.menu.*;
import es.iesjandula.tienda_bici.stats.*;
import java.util.Scanner;
import java.sql.*;
/**
 * This class execute the program
 * @author Pablo Elias Ruiz Canovas
 *
 */
public class Launcher {

	public static void main(String[] args) {
		//Scanner to write attributes
		Scanner scanner = new Scanner (System.in);
		//Strings to connect with the database
		String username = "root",password = "admin",url = "jdbc:mysql://localhost/tienda_bici";
		//Connection that allows use the database by java
		Connection connection = null;
		//Attributes of client
		String name = null,clientGender = null;
		int clientID = 0,age = 0;
		//Attributes of bike
		String mark = null,typeBike = null,bikeGender = null;
		int bikeID = 0,numWheel = 0;
		//Attributes of purchase record
		int purchaseID = 0;
		String date = null;
		
		try
		{
			connection = DriverManager.getConnection(url,"root","admin");
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		
		
		
	}

}
