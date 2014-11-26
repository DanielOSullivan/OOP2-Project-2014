//DriverProgram.java
/*Driver program*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class DriverProgram extends JFrame implements ActionListener{
	
	JMenu fighterMenu, arenaMenu, quitMenu;
	JLabel response;
	
//Driver
	public static void main(String args[]) {
		DriverProgram frame = new DriverProgram();
		frame.setVisible(true);
		}
//Constructor		
	public DriverProgram(){
		Container cPane = getContentPane();
		
		setTitle     ("The Fight!");
        setSize      (800,800);
        setResizable (false);
        setLocation  (250,50);
        
		cPane.setLayout(new FlowLayout());
		
		createFighterMenu();
		createArenaMenu();
		createQuitMenu();
		
		JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.orange);
        
        menuBar.add(fighterMenu);
        menuBar.add(arenaMenu);
        menuBar.add(quitMenu);
        
        response = new JLabel("Create the fighters/arena!");
		cPane.add(response);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	
//Creating Menus (User-Defined Methods)
//Creating Fighter Menu
	public void createFighterMenu(){
		fighterMenu = new JMenu("Fighters");
		
		JMenuItem item;
		item = new JMenuItem("Add");
		fighterMenu.add(item);
		item.addActionListener(this);
		}
		
//Creating Arena Menu		
	public void createArenaMenu(){
		arenaMenu = new JMenu("Arena");
		
		JMenuItem item;
		item = new JMenuItem("Create");
		arenaMenu.add(item);
		item.addActionListener(this);
		}		
			
//Creating Quit Menu		
	public void createQuitMenu(){
		quitMenu = new JMenu("Quit");
		
		JMenuItem item;
		item = new JMenuItem("Quit");
		quitMenu.add(item);
		item.addActionListener(this);
		}

//Handler		
	public void actionPerformed(ActionEvent event) {
        String  itemClicked;
        itemClicked = event.getActionCommand();
        
//Quit Program
        if (itemClicked.equals("Quit")){
        	JOptionPane.showMessageDialog(null,"Closing System","Close",JOptionPane.INFORMATION_MESSAGE);
        	System.exit(0);
        	} 
        		
//Add two Fighters		
        else if(itemClicked.equals("Add")){
        	JOptionPane.showMessageDialog(null,"You have chosen to create two Fighters!","Create Fighters",JOptionPane.INFORMATION_MESSAGE);
        	
        	Fighter f1 = new Fighter();
        	Fighter f2 = new Fighter();
        				
        	f1.setName(JOptionPane.showInputDialog("Enter the name for the Fighter 1"));	
        	f1.setAge(Integer.parseInt(JOptionPane.showInputDialog("Enter the age of " + f1.getName())));
        	char f1Gender;
        	f1Gender = JOptionPane.showInputDialog("Enter the gender of " + f1.getName()).charAt(0);
        	f1.setGender(f1Gender);
        		
        	f2.setName(JOptionPane.showInputDialog("Enter the name for the Fighter 2"));	
        	f2.setAge(Integer.parseInt(JOptionPane.showInputDialog("Enter the age of " + f2.getName())));
        	char f2Gender;
        	f2Gender = JOptionPane.showInputDialog("Enter the gender of " + f2.getName()).charAt(0);
        	f2.setGender(f2Gender);
    	
        	String message = f1.toString();
        		   message += f2.toString();
        	
        	JOptionPane.showMessageDialog(null,message,"Fighter Details Entered!",JOptionPane.INFORMATION_MESSAGE);
			
			//Setting fighterMenu to false so the user can't create more fighter objects
        	fighterMenu.setVisible(false);
        	
        	if(arenaMenu.isVisible()){
        		JOptionPane.showMessageDialog(null,"Now create the Arena!","Next Step",JOptionPane.INFORMATION_MESSAGE);
        		}
        		
        	else{
        		JOptionPane.showMessageDialog(null,"You are ready to begin the fight!","Ready!",JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        	
//Create Arena        	
        else if(itemClicked.equals("Create")){
        	JOptionPane.showMessageDialog(null,"You have chosen to create the Arena!","Create Arena",JOptionPane.INFORMATION_MESSAGE);
        	
        	Arena a1 = new Arena();
        	
        	a1.setName(JOptionPane.showInputDialog("Enter the name for the Arena"));	
        	a1.setLocation(JOptionPane.showInputDialog("Enter the location of " + a1.getName()));
        	a1.setCapacity(Integer.parseInt(JOptionPane.showInputDialog("Enter the capacity of " + a1.getName())));
        	
        	String message = a1.toString();
        	
        	JOptionPane.showMessageDialog(null,message,"Arena Details",JOptionPane.INFORMATION_MESSAGE);
        	
        	arenaMenu.setVisible(false);
        	
        	if(fighterMenu.isVisible()){
        		JOptionPane.showMessageDialog(null,"Now create the Fighters!","Next Step",JOptionPane.INFORMATION_MESSAGE);
        		}
        		
        	else{
        		JOptionPane.showMessageDialog(null,"You are ready to begin the fight!","Ready!",JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        	
        response.setText("");
        } 
} 