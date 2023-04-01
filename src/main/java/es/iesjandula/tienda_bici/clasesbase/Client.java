package es.iesjandula.tienda_bici.clasesbase;
/**
 * 
 * @author Pablo Ruiz Canovas
 * This class takes care of save the information of the client 
 */
public class Client {
	//This attribute register the identifier of the client 
	private int id;
	//This attribute register the name of the client
	private String name;
	//This attribute register the age of the client
	private int age;
	//This attribute rergister the gender of the client
	private String gender;
	
	/**
	 * Constructor
	 * @param id identifier of the client
	 * @param name name of the client
	 * @param age age of the client
	 * @param gender gender of the client
	 * If one of this attributes (except ID) would be null the method fixAttributes set a default value
	 */
	public Client (int id,String name,int age,String gender)
	{
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.fixAttributes();
	}
	
	//Getters and Setters
	/**
	 * 
	 * @return
	 * This getter return the value of the identifier of the client
	 */
	public int getID()
	{
		return this.id;
	}
	/**
	 * 
	 * @return
	 * This getter return the value of the name of the client
	 */
	public String getName()
	{
		return this.name;
	}
	/**
	 * 
	 * @param name
	 * This setter allows change the value of the name
	 */
	public void setName(String name)
	{
		this.name = name;
		this.fixAttributes();
	}
	/**
	 * 
	 * @return
	 * This getter return the value of the age of the client
	 */
	public int getAge()
	{
		return this.age;
	}
	/**
	 * 
	 * @param age
	 * This setter allows change the value of the age of the client
	 */
	public void setAge(int age)
	{
		this.age = age;
		this.fixAttributes();
	}
	/**
	 * 
	 * @return
	 * This getter return the value of the gender of the client
	 */
	public String getGender()
	{
		return this.gender;
	}
	/**
	 * 
	 * @param gender
	 * This setter allows change the value of the gender of the client
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
		if(this.name.isEmpty())
		{
			this.name = "Without name";
		}
		if(this.age<=0)
		{
			System.out.println("Negative age, set default");
			this.age = 18;
		}
		if(this.gender.isEmpty())
		{
			this.gender = "Other";
		}
	}
	@Override
	/**
	 * @return 
	 * This method returns the value of all attributes
	 */
	public String toString()
	{
		return "Client "+this.id+"{ name="+this.name+" age="+this.age+" gender="+this.gender;
	}
	
	
	
	
}
