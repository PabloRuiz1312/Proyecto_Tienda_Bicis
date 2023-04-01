package es.iesjandula.tienda_bici.clasesbase;
/**
 * 
 * @author Pablo Elias Ruiz Canovas
 * This class takes care of save the purchase that the client realize 
 *
 */
public class PurchaseRecord {
	//This attribute register the identifier of purchase
	private int purchaseID;
	//This attribute its the client identifier that buy the bike
	private int clientID;
	//This attribute its the bike identifier that the client buy
	private int bikeID;
	//This attribute register the date of the bike purchase
	private String purchaseDate;
	/**
	 * 
	 * @param purchaseID identifier of the purcharse
	 * @param clientID client identifier
	 * @param bikeID bike identifier
	 * @param purchaseDate date were the bike was bought 
	 */
	public PurchaseRecord(int purchaseID,int clientID,int bikeID,String purchaseDate)
	{
		this.purchaseID = purchaseID;
		this.clientID = clientID;
		this.bikeID = bikeID;
		this.purchaseDate = purchaseDate;
	}
	//Getters and Setters
	/**
	 * 
	 * @return return the value of the purchase identifier
	 */
	public int getPurchaseID()
	{
		return this.purchaseID;
	}
	/**
	 * 
	 * @return return the value of the client identifier
	 */
	public int getClientID()
	{
		return this.clientID;
	}
	/**
	 * 
	 * @return return the value of the bike identifier
	 */
	public int getBikeID()
	{
		return this.bikeID;
	}
	/**
	 * 
	 * @return return the value of the purchase date
	 */
	public String getPurchaseDate()
	{
		return this.purchaseDate;
	}
	/**
	 * 
	 * @param purchaseDate set the new value
	 */
	public void setPurchaseDate(String purchaseDate)
	{
		this.purchaseDate = purchaseDate;
	}
	/**
	 * @return the values of all attributes
	 */
	@Override
	public String toString()
	{
		return "purchase "+purchaseID+" client "+clientID+" buy a bike "+bikeID+", in "+purchaseDate;
	}
	
	
}
