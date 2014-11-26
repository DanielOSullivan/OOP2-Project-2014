//Fighter.java
/*OOP instantiable class which models a Fighter, storing all that Fighter's details as one object*/

import java.io.*;
public class Fighter implements Serializable{
	private String name;
	private int age;
	private char gender;
	
//Mutator Methods - To change the value of an attribute
	public void setName(String name){
		this.name = name;}

	public void setAge (int age){
		this.age = age;}
		
	public void setGender(char gender){
		this.gender = gender;}
		
//Accessor Methods - For returning copies of the requested attributes
	public String getName(){ return name;}
	public int getAge(){ return age;}
	public char getGender(){ return gender;}
	
//Constructor Methods - To give people an initial state
//No Argument Constructor - To create a default fighter
	public Fighter(){
		this("No-Name",0,'U');
		}
//Multi Argument Constructor - To create a fighter about whom everything is known	
	public Fighter(String name, int age, char gender){
		setName(name);
		setAge(age);
		setGender(gender);
		}
		
//toString Method - o give a quick String summary of the values of all the object's attributes
	public String toString(){
		String message = "\nFighter's Name: " + getName() + "\nFighter's Age: " + getAge() + "\nFigther's Gender: " + getGender() + "\n";	
			
		return message;
		}
}