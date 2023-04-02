package es.iesjandula.tienda_bici.clasesbase;
/**
 * 
 * @author Pablo Elias Ruiz Canovas
 * This class takes care of save the information of the bikes
 */
public class Bike {
	//This attribute register the identifier of the bike
	private int id;
	//This attribute register the mark of the bike
	private String mark;
	//This attribute register the number of the wheel of the bike
	private int numWheel;
	//This attribute register the type of the bike
	private String bikeType;
	//This attribute register the gender of the bike
	private String gender;
	/**
	 * Constructor
	 * @param id of the bike (the id is choosen by the system)
	 * @param mark of the bike
	 * @param numWheel define the size of the wheel
	 * @param bikeType define the type of a bike
	 * @param gender define if the bike its for a men or woman 
	 * If one of this attributes (except ID) would be null the method fixAttributes set a default value
	 */
	public Bike (int id,String mark,int numWheel,String bikeType,String gender)
	{
		this.id = id;
		this.mark = mark;
		this.numWheel = numWheel;
		this.bikeType = bikeType;
		this.gender = gender;
		this.fixAttributes();
	}
	
	//Getter and Setters
	/**
	 * 
	 * @return return the value of the identifier of the bike
	 * 
	 */
	public int getId()
	{
		return this.id;
	}
	/**
	 * 
	 * @return return the value of the mark of the bike
	 * 
	 */
	public String getMark()
	{
		return this.mark;
	}
	/**
	 * 
	 * @param mark allows change the value of the old mark of the bike
	 * 
	 */
	public void setMark(String mark)
	{
		this.mark = mark;
		this.fixAttributes();
	}
	/**
	 * 
	 * @return return the value of the number of the wheel of the bike
	 * 
	 */
	public int getNumWheel()
	{
		return this.numWheel;
	}
	/**
	 * 
	 * @param numbWheel allows change the old value of number of the wheel of the bike
	 * 
	 */
	public void setNumbWheel(int numWheel)
	{
		this.numWheel = numWheel;
		this.fixAttributes();
	}
	/**
	 * 
	 * @return return the value of the bike type
	 * 
	 */
	public String getBikeType()
	{
		return this.bikeType;
	}
	/**
	 * 
	 * @param bikeType allows change the old value of the bike type
	 * 
	 */
	public void setBikeType(String bikeType)
	{
		this.bikeType = bikeType;
		this.fixAttributes();
	}
	/**
	 * 
	 * @return return the value of the gender of the bike
	 *  
	 */
	public String getGender()
	{
		return this.gender;
	}
	/**
	 * 
	 * @param gender change the old value of the gender of the bike
	 * 
	 */
	public void setGender(String gender)
	{
		this.gender = gender;
		this.fixAttributes();
	}
	/**
	 * This method set to default the attributes value if the user set his values null
	 */
	private void fixAttributes()
	{
		if(this.mark.isEmpty())
		{
			this.mark = "White mark";
		}
		if(this.numWheel<14)
		{
			this.numWheel = 14;
		}
		if(this.numWheel>29)
		{
			this.numWheel = 29;
		}
		if(this.bikeType.isEmpty())
		{
			this.bikeType = "Rigida";
		}
		if(!this.gender.equalsIgnoreCase("H") || !this.gender.equalsIgnoreCase("M") || !this.gender.equalsIgnoreCase("T"))
		{
			this.gender = "T";
		}
	}
	
	@Override
	public String toString()
	{
		return "Bike "+this.id+" mark="+this.mark+" number of wheel="+this.numWheel+" type of bike="+this.bikeType+" gender="+this.gender;
	}
	
	
	
	
}
