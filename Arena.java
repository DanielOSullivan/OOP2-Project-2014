//Arena.java
/*OOP instantiable class which models an Arena, storing all that Arena's details as one object*/

import java.io.*;
public class Arena implements Serializable{
	private String name;
	private String location;
	private int capacity;
	
//Mutator Methods - To change the value of an attribute
	public void setName(String name){
		this.name = name;}

	public void setLocation(String location){
		this.location = location;}
	
	public void setCapacity (int capacity){
		this.capacity = capacity;}
		
//Accessor Methods - For returning copies of the requested attributes
	public String getName(){ return name;}
	public String getLocation(){ return location;}
	public int getCapacity(){ return capacity;}
	
//Constructor Methods - To give people an initial state
//No Argument Constructor - To create a default fighter
	public Arena(){
		this("No-Name","No-Location",0);
		}
//Multi Argument Constructor - To create a fighter about whom everything is known	
	public Arena(String name, String location, int capacity){
		setName(name);
		setLocation(location);
		setCapacity(capacity);
		}
		
//toString Method - o give a quick String summary of the values of all the object's attributes
	public String toString(){
		String message = "\nArena Name: " + getName() + "\nCapacity: " + getCapacity() + "\nLocation: " + getLocation() + "\n";
		
		return message;	
		}
}