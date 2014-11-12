//Equilibrium.java
/**/

import javax.swing.*;
public class Equilibrium {
	public static void main (String args []) {
		
		String numberAsString, seqLengthAsString, indice="";
		int i, seqLength, leftStart,  rightStart;
		double leftTotal=0, rightTotal=0;
	
		seqLengthAsString = JOptionPane.showInputDialog("Please enter the length of the sequence");
		seqLength = Integer.parseInt(seqLengthAsString);
		
		int numbers[] = new int[seqLength];
		
		for (i=0; i<seqLength; i++)
			{
			numberAsString = JOptionPane.showInputDialog("Enter number " + (i+1));
	 		numbers[i] = Integer.parseInt(numberAsString);
			}		
				
		for (i=0; i<seqLength; i++) //Overall outer for loop
		{
		  	for (i=0; i<seqLength; i++)
		  	{
		  		leftStart = numbers[i];
		  		
		  		leftTotal += leftStart;
		  	} //Left hand total
		  	
		  	for (i=4; i<seqLength; i--)
		  	{
		  		rightStart = numbers[i];
		  		
		  		rightTotal += rightStart;	
		  	} //Right hand total
		  	
		  	if (leftTotal == rightTotal) //If left hand total = right hand total
		  	{
		  		indice += numbers[i] + " ,";
		  	}
		}
		
		JOptionPane.showMessageDialog(null,"Equilibrium indices where left = right: " + indice,"Result",
		  							  JOptionPane.INFORMATION_MESSAGE);
		
		System.exit(0);
	}
}