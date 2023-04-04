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
		Client client = null;
		Bike bike = null;
		
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
							option = scanner.next();
							switch(option)
							{
							case "1":
								System.out.println("You choose add a client, you need specify his attributes");
								System.out.println("First choose a name");
								name = new Scanner (System.in).nextLine();
								System.out.println("Choose a age");
								try
								{
									age = new Scanner (System.in).nextInt();
								}catch(InputMismatchException e)
								{
									System.out.println("Error choosing age");
									age = -1;
								}
								System.out.println("Choose a gender (Hombre,Mujer,Otro)");
								clientGender = scanner.next();
								client = new Client(1,name,age,clientGender);
								menuC.create(connection, client.getName(), client.getAge(), client.getGender());
								break;
							case "2":
								System.out.println("You choose delete a client, select the id of the client to delete");
								statsC.showClients(connection);
								try
								{
									clientID = scanner.nextInt();
								}catch(InputMismatchException e)
								{
									System.out.println("Error deleting a client");
									clientID = -1;
								}
								if(clientID!=-1)
								{
									menuC.delete(connection, clientID);
								}
								break;
							case "3":
								System.out.println("You choose modify a client, select the id of the client to modify");
								statsC.showClients(connection);
								try
								{
									clientID = scanner.nextInt();
								}catch(InputMismatchException e)
								{
									System.out.println("Error selecting id");
									clientID = -1;
								}
								if(clientID!=-1 || clientID>0)
								{
									client = menuC.read(connection, clientID);
									if(client!=null)
									{
										System.out.println("Ok "+client+" selected now select the attribute to modify:\n"
												+ "1.-Name\n"
												+ "2.-Age\n"
												+ "3.-Gender");
										option = scanner.next();
										switch(option)
										{
										case "1":
											System.out.println("Select the new name");
											name = new Scanner (System.in).nextLine();
											menuC.updateName(connection, clientID, name);
											break;
										case "2":
											System.out.println("Select the new age");
											try
											{
												age = scanner.nextInt();
											}catch(InputMismatchException e)
											{
												System.out.println("Error selecting age");
												age = -1;
											}
											if(age>0 || age!=-1)
											{
												menuC.updateAge(connection, clientID, age);
											}
											else
											{
												System.out.println("Negative age introduce");
											}
											break;
										case "3":
											System.out.println("Select the new gender (Hombre,Mujer,Otro)");
											clientGender = scanner.next();
											if(clientGender.equalsIgnoreCase("Hombre") || clientGender.equalsIgnoreCase("Mujer") || clientGender.equalsIgnoreCase("Otro"))
											{
												menuC.updateGender(connection, clientID, clientGender);
											}
											break;
										default:
											System.out.println("Error selecting option");
										}
									}
								}
								break;
							case "4":
								System.out.println("You choose search a client, select his id");
								try
								{
									clientID = scanner.nextInt();
								}catch(InputMismatchException e)
								{
									System.out.println("Error searching the client");
									clientID = -1;
								}
								if(clientID!=-1)
								{
									client = menuC.read(connection, clientID);
									if(client!=null)
									{
										System.out.println(client);
									}		
								}
								break;
							default:
								System.out.println("Error choosing option");
							}
							break;
						case "2":
							System.out.println("You choose menu of bikes, choose one option:\n"
									+ "1.-Add a bike\n"
									+ "2.-Delete a bike\n"
									+ "3.-Modify a bike\n"
									+ "4.-Search a bike");
							option = scanner.next();
							switch(option)
							{
							case "1":
								System.out.println("You choose add a bike, you need specify his attributes");
								System.out.println("Select his mark");
								mark = new Scanner(System.in).nextLine();
								System.out.println("Select his number wheel");
								try
								{
									numWheel = new Scanner (System.in).nextInt();
								}catch(InputMismatchException e)
								{
									System.out.println("Error slecting number of wheel ");
									numWheel = -1;
								}
								System.out.println("Select the type of bike");
								typeBike = new Scanner (System.in).nextLine();
								System.out.println("Select the gender of the bike (H,M,T)");
								bikeGender = scanner.next();
								bike = new Bike(1,mark,numWheel,typeBike,bikeGender);
								menuB.create(connection, bike.getMark(), bike.getNumWheel(), bike.getBikeType(), bike.getGender());
								break;
							case "2":
								System.out.println("You choose delete a bike, select his id \n"
										+ "Be careful, if you delete a bike that was purchased you delete this purchase too");
								statsB.showAllBikes(connection);
								try
								{
									bikeID = scanner.nextInt();
								}catch(InputMismatchException e)
								{
									System.out.println("Error selecting id");
								}
								if(bikeID!=1 || bikeID>0)
								{
									menuB.delete(connection, bikeID);
								}
								break;
							case "3":
								System.out.println("You choose modify an attribute, select the id of the bike to modify");
								statsB.showAllBikes(connection);
								try
								{
									bikeID = new Scanner(System.in).nextInt();
								}catch(InputMismatchException e)
								{
									System.out.println("Error selecting id");
									bikeID = -1;
								}
								if(bikeID!=1 || bikeID>0)
								{
									bike = menuB.read(connection, bikeID);
									if(bike!=null)
									{
										System.out.println("Ok "+bike+" selected, select the attribute to modify:\n"
												+ "1.-Mark\n"
												+ "2.-Number of wheel\n"
												+ "3.-Bike type\n"
												+ "4.-Gender");
										option = scanner.next();
										switch(option)
										{
										case "1":
											System.out.println("Select the new mark");
											mark = new Scanner(System.in).nextLine();
											menuB.updateMark(connection, bikeID, mark);
											break;
										case "2":
											System.out.println("Select the new number of wheel");
											try
											{
												numWheel = new Scanner(System.in).nextInt();
											}catch(InputMismatchException e)
											{
												System.out.println("Error selecting the number of wheel");
												numWheel = -1;
											}
											if(numWheel>13 && numWheel<30)
											{
												menuB.updateNumWheel(connection, bikeID, numWheel);
											}
											else
											{
												System.out.println("The number of wheel "+numWheel+" doesnt exist");
											}
										case "3":
											System.out.println("Select the new bike type");
											typeBike = new Scanner (System.in).nextLine();
											menuB.updateBikeType(connection, bikeID, typeBike);
											break;
										case "4":
											System.out.println("Select the new gender (H,M,T)");
											bikeGender = scanner.next();
											if(bikeGender.equals("H") || bikeGender.equals("M") || bikeGender.equals("T"))
											{
												menuB.updateGender(connection, bikeID, bikeGender);
											}
										}
									}
								}
								break;
							case "4":
								System.out.println("Select the id of the bike to search");
								try
								{
									bikeID = scanner.nextInt();
								}catch(InputMismatchException e)
								{
									System.out.println("Error selecting email");
									bikeID = -1;
								}
								if(bikeID>0 || bikeID!=-1)
								{
									bike = menuB.read(connection, bikeID);
									System.out.println(bike);
								}
								break;
							default:
								System.out.println("Error choosing option");
							}
							
							
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
					System.out.println("You choose stats of the system, choose one option:\n"
							+ "1.-Stats of clients\n"
							+ "2.-Stats of bikes\n"
							+ "3.-General stats\n"
							+ "4.-Back");
					option = scanner.next();
					endMenu = false;
					while(!endMenu)
					{
						switch(option)
						{
						case "1":
							System.out.println("You choose stats of clients, choose one option: \n"
									+ "1.-Show all clients\n"
									+ "2.-Show menor age clients\n"
									+ "3.-Show mayor age clients\n"
									+ "4.-Show men clients\n"
									+ "5.-Show women clients\n"
									+ "6.-Show other clients");
							option = scanner.next();
							switch(option)
							{
							case "1":
								statsC.showClients(connection);
								break;
							case "2":
								statsC.showMenorClients(connection);
								break;
							case "3":
								statsC.showMayorClients(connection);
								break;
							case "4":
								statsC.showMenClients(connection);
								break;
							case "5":
								statsC.showWomenClients(connection);
								break;
							case "6":
								statsC.showOtherClients(connection);
								break;
							default:
								System.out.println("Error choosing option");
							}
							break;
						case "2":
							System.out.println("You choose stats of bikes, choose one option: \n"
									+ "1.-Show all bikes\n"
									+ "2.-Show gender H bikes\n"
									+ "3.-Show M bikes\n"
									+ "4.-Show T bikes");
							option = scanner.next();
							switch (option)
							{
							case "1":
								statsB.showAllBikes(connection);
								break;
							case "2":
								statsB.showMenBikes(connection);
								break;
							case "3":
								statsB.showWomenBikes(connection);
								break;
							case "4":
								statsB.showOtherBikes(connection);
								break;
							default:
								System.out.println("Error choosing option");
							}
							break;
						case "3":
							System.out.println("You choose general stats, choose one option: \n"
									+ "1.-Show all purchases\n"
									+ "2.-Show the best client\n"
									+ "3.-Show the clients that dont buy bikes");
							option = scanner.next();
							switch(option)
							{
							case "1":
								statsP.showAllPurchase(connection);
								break;
							case "2":
								statsP.showBestClient(connection);
								break;
							case "3":
								statsP.showWorstClient(connection);
								break;
							default:
								System.out.println("Error choosing option");
							}
							break;
						case "4":
							endMenu = true;
							break;
						default:
							System.out.println("Error choosing option");		
						}
						if(!endMenu)
						{
							System.out.println("Choose one option:\n"
									+ "1.-Stats of clients\n"
									+ "2.-Stats of bikes\n"
									+ "3.-General stats\n"
									+ "4.-Back");
							option = scanner.next();
						}
					}
					
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
