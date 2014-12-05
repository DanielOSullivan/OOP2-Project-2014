//Arena.java
/*OOP instantiable class which models an Arena, storing all that Arena's details as one object*/
//This is also my Javadoc commented class

import java.io.*;

/**This is an instantiable Arena class.
 @author Daniel O'Sullivan
 @version 1.0 */ 
public class Arena implements Serializable{
	//Attributes
	private String name;
	private String location;
	private int capacity;
	
//Mutator Methods - To change the value of an attribute
	
	/** Mutator method to set the Arena name
	 *@param name the name of the Arena */
	public void setName(String name){
		this.name = name;}
	/** Mutator method to set the Arena location
	 *@param location the location of the Arena */
	public void setLocation(String location){
		this.location = location;}
	/** Mutator method to set the Arena capacity
	 *@param capacity the capacity of the Arena */
	public void setCapacity (int capacity){
		this.capacity = capacity;}
		
		
	//Accessor Methods - For returning copies of the requested attributes
	
	/** Acessor method to return the Arena name
	 *@return the name of the Arena*/
	public String getName(){ return name;}
	/** Acessor method to return the Arena location
	 *@return the location of the Arena*/
	public String getLocation(){ return location;}
	/** Acessor method to return the Arena capacity
	 *@return the capacity of the Arena*/
	public int getCapacity(){ return capacity;}
	
	
//Constructor Methods - To give people an initial state

//No Argument Constructor - To create a default fighter
/** No-Argument constructor method*/
	public Arena(){
		this("No-Name","No-Location",0);
		}
		
//Multi Argument Constructor - To create a fighter about whom everything is known

/** Multi-Argument constructor method
	 @param name the full name of the Arena
	 @param location the location of the Arena
	 @param capacity the full capacity of the Arena */	
	public Arena(String name, String location, int capacity){
		setName(name);
		setLocation(location);
		setCapacity(capacity);
		}
		
//toString Method - to give a quick String summary of the values of all the object's attributes
	
	/** toString method to return the Arena details
	 *@return the name, location and capacity of the Arena as a string */
	public String toString(){
		String message = "\nArena Name: " + getName() + "\nCapacity: " + getCapacity() + "\nLocation: " + getLocation() + "\n";
		
		return message;	
		}
}