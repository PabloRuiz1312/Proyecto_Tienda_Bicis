package es.iesjandula.tienda_bici.launcher;
import es.iesjandula.tienda_bici.clasesbase.*;
import es.iesjandula.tienda_bici.menu.*;
import es.iesjandula.tienda_bici.stats.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;
import java.util.logging.*;
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
		String username = "root",password = "admin",url = "jdbc:mysql://localhost:3306/tienda_bici";
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
		//Menu of clients
		MenuClient menuC = new MenuClient();
		//Menu of bikes
		MenuBike menuB = new MenuBike();
		//Menu of purchase
		MenuPurchase menuP = new MenuPurchase();
		//Stats of the client
		StatsClient statsC = new StatsClient();
		//Stats of the bike 
		StatsBike statsB = new StatsBike();
		//Stats of Purchase
		StatsPurchase statsP = new StatsPurchase();		
		//Attributes of main
		String option = null;
		boolean endLoop = false,endMenu = true;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e)
		{
			Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE,null,e);
		}
		
		try
		{
			connection = DriverManager.getConnection(url,"root",password);
			System.out.println("Welcome to our bike shop, select one option:\n"
					+ "1.-Menu of clients and bikes\n"
					+ "2.-Buy a bike\n"
					+ "3.-Stats of the system\n"
					+ "4.-Exit");
			System.out.println("Select one option");
			option = scanner.next();
			while(!endLoop)
			{
				switch(option)
				{
				case "1":
					System.out.println("You choose menu of clients and bikes select one option:\n"
							+ "1.-Menu of clients\n"
							+ "2.-Menu of bikes\n"
							+ "3.-Back");
					option = scanner.next();
					endMenu = false;
					while(!endMenu)
					{
						switch(option)
						{
						case "1":
							System.out.println("You choose menu of client, choose one option:\n"
									+ "1.-Add a client\n"
									+ "2.-Delete a client\n"
									+ "3.-Modify a client\n"
									+ "4.-Search a client");
							break;
						case "2":
							System.out.println("You choose menu of bikes, choose one option:\n"
									+ "1.-Add a bike\n"
									+ "2.-Delete a bike\n"
									+ "3.-Modify a bike\n"
									+ "4.-Search a bike");
							
							break;
						case "3":
							endMenu=true;
							break;
						default:
							System.out.println("Error choosing option, choose again");
						}
						if(!endMenu)
						{
							System.out.println("Choose one option:\n"
									+ "1.-Menu of clients\n"
									+ "2.-Menu of bikes\n"
									+ "3.-Back");
							option = scanner.next();
						}
					}
					break;
				case "2":
					System.out.println("You choose buy a bike, select the id of the client that want the bike");
					statsC.showClients(connection);
					try
					{
						int dateInt = 0;
						clientID = scanner.nextInt();
						System.out.println("Ok now select the id of the bike");
						statsB.showAllBikes(connection);
						bikeID = scanner.nextInt();
						System.out.println("Ok now you must to introduce the date piece by piece, first the year");
						dateInt = scanner.nextInt();
						if(dateInt>1900 && dateInt<2024)
						{
							date = String.valueOf(dateInt)+"-";
							System.out.println("Perfect now introduce the month");
							dateInt = scanner.nextInt();
							if(dateInt>0 && dateInt<13)
							{
								date = date+String.valueOf(dateInt)+"-";
								System.out.println("Perfect now introduce the day");
								dateInt = scanner.nextInt();
								if(dateInt>0 && dateInt<32)
								{
									date = date+String.valueOf(dateInt);
									menuP.create(connection, clientID, bikeID, date);
								}else
								{
									System.out.println("Error doing operation");
								}
								
							}else
							{
								System.out.println("Error doing operation");
							}
						}else
						{
							System.out.println("Error doing operation");
						}
					}catch(InputMismatchException e)
					{
						System.out.println("Error doing the operation");
					}
					break;
				case "3":
					
					break;
				case "4":
					System.out.println("Thanks for use our application!!");
					endLoop = true;
					break;
				default:
					System.out.println("Error, choose again");
				}
				if(!endLoop)
				{
					System.out.println("Select one option:\n"
							+ "1.-Menu of clients and bikes\n"
							+ "2.-Buy a bike\n"
							+ "3.-Stats of the system\n"
							+ "4.-Exit");
					option = scanner.next();
				}
			}
			
			connection.close();
		}catch(SQLException e)
		{
			Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE,null,e);
		}
		
		
		
	}

}
