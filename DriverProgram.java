//DriverProgram.java
/*Driver program*/
//Importing Packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
 
//Main DriverProgram class 
public class DriverProgram extends JFrame implements ActionListener{

	/**********Class Attributes**********/
	
	//JMenu attributes to be added to the JMenubarfor each operation before the figh begins
	private JMenu fighterMenu, arenaMenu, quitMenu; 
	//The response JLabel variable will change the label on the screen according to what events occur within the program
	private JLabel response;
	//Creating re-usable JMenuItem variable for use in the user-defined methods where they create JMenus
	private JMenuItem item;
	//Applying the designated picture background to a JLabel for the fight scene
	private JLabel fightBackground = new JLabel(new ImageIcon("fightImage.jpg"));
	//JButton that will start the fight when clicked
	private JButton beginFightButton;
	//These buttons will be used in the fight simulator and each will have a particular function [outlined later]
	private JButton f1PunchButton, f1KickButton, f2PunchButton, f2KickButton;
	//Fighter objects being created for use within the program
	private Fighter f1 = new Fighter();
    private	Fighter f2 = new Fighter();
    //Arena object being created for use within the program
    private Arena a1 = new Arena();	;
    //Initial health values of each fighter
	private int f1Health = 100, f2Health = 100;
	//This variable will be used in relation to the hit ratios (30%, 60% etc...) of punches and kicks
	private int hitOrMiss;
	
	//Driver
	public static void main(String args[]) {
		//Creating frame object for display on the screen
		DriverProgram frame = new DriverProgram();
		//Making frame object visible to the end uset
		frame.setVisible(true);
	}//End of driver 
		
	//Constructor (No argument)		
	public DriverProgram(){
		//Super reference being used here instead of the setTitle() method to demonstarte and understanding of inheritance
		super("The Fight!");
		//Creating container for all the contents
		Container cPane = getContentPane();
		//Frame properties
        setSize(800,700);
        setResizable(false);
        setLocation(250,50);
        //Setting a simple default layout on the content pane created earlier
		cPane.setLayout(new FlowLayout());
		//Invoking the user-defined methods
		createFighterMenu();
		createArenaMenu();
		createQuitMenu();
		//New button which will become visible when neither of the JMenus are visible and allow the user to begin the fight
		beginFightButton = new JButton("Begin Fight!");
		//Adding the begin fight button to the content pane
		cPane.add(beginFightButton);
		//Setting the begin fight button to invisible for now until the fighters and arena are created
		beginFightButton.setVisible(false);
		//Adding and action listener to listen for when the beginFightbutton is clicked
		beginFightButton.addActionListener(this);
		//Creating and applying the colored menu bar
		JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.orange);
      	//AddingcJMenus peviously created to menu bar
        menuBar.add(fighterMenu);
        menuBar.add(arenaMenu);
        menuBar.add(quitMenu);
        /*Paul Kennedy (from class) told me that html referencing is possible in java so credit to him for the possibility of my use of html code in this project*/
        //Setting the response JLabel to instructions for the user
        response = new JLabel("<html><h1 color='blue'><br> Click [Fighters > Add] to add 2 fighters!</h1><br><h1 color='red'> Click [Arena > Create] to create an" +
        					  "arena!</h1><br><h1>Click [Quit > Quit] to exit program!</h1></html>");
		//Adding the response JLabel to the content pane
		cPane.add(response);
		//Adding the beging fight button to the content pane
		cPane.add(beginFightButton);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//End of constructor DriverProgram(){...}
	
	
	//Creating Menus (User-Defined Methods)
	
	//Creating Fighter Menu user defined method
	public void createFighterMenu(){
		//Creating fighterMenu Object
		fighterMenu = new JMenu("Fighters");	
		fighterMenu.setForeground(Color.BLUE);
		//creating object from using the item variable
		item = new JMenuItem("Add");
		//editing and adding the item to the fighter Menu 
		fighterMenu.add(item);
		item.setBackground(Color.BLUE);
		item.setForeground(Color.WHITE);
		//Adding an action listener to listen for the event of when this paticular item is clicked
		item.addActionListener(this);
	}//End of createFighterMenu(){...}
			
	//Creating Arena Menu		
	public void createArenaMenu(){
		//Creating ArenaMenu Object
		arenaMenu = new JMenu("Arena");
		arenaMenu.setForeground(Color.RED);
		//Creating object from using the item variable
		item = new JMenuItem("Create");
		//Editing and adding the item to the arena Menu 
		arenaMenu.add(item);
		item.setBackground(Color.RED);
		item.setForeground(Color.WHITE);
		//Adding an action listener to listen for the event of when this paticular item is clicked
		item.addActionListener(this);
	}//End of createArenaMenu(){...}				
			
	//Creating Quit Menu		
	public void createQuitMenu(){
		//Creating ArenaMenu Object
		quitMenu = new JMenu("Quit");
		//Creating object from using the item variable
		item = new JMenuItem("Quit");
		//Editing and adding the item to the arena Menu 
		quitMenu.add(item);
		//Adding an action listener to listen for the event of when this paticular item is clicked
		item.addActionListener(this);
	}//End of createQuitMenu(){...}
		
	//Begin Fight Method
	public void beginFight(){
		//Editing and setting the beginFightButton to visible under conditions listed in the actionPerformed Method below
		beginFightButton.setVisible(true);
	  	beginFightButton.setBackground(Color.YELLOW);
	  	//Setting the response label to empty string to center the fight button on the screen
		response.setText("");
	}//End of beginFight(){...}



	//Handler/Listener		
	public void actionPerformed(ActionEvent event){
		//Making variable for use in deciding which JMenuItem was clicked/what event occured
        String  itemClicked;
        itemClicked = event.getActionCommand();
              
              
		//Quit Program when "Quit" is clicked
        if (itemClicked.equals("Quit")){
        	//Displays appropriate message for the user
        	JOptionPane.showMessageDialog(null,"Closing System","System Close",JOptionPane.INFORMATION_MESSAGE);
        	//Quit system method
        	System.exit(0);
        }//End if(itemClicked.equals("Quit")){...}
        		     	
        		     		
		//Add two Fighters when "Add" is clicked	
        if(itemClicked.equals("Add")){
        	//Displaying appropriate message 
        	JOptionPane.showMessageDialog(null,"You have chosen to create two Fighters!","Create Fighters",JOptionPane.INFORMATION_MESSAGE);
        	//Using the setName(),setAge() and setGender() mutator methods defined in the Fighter class	for the Fighter object f1		
        	f1.setName(JOptionPane.showInputDialog("Enter the name for the Fighter 1"));	
        	f1.setAge(Integer.parseInt(JOptionPane.showInputDialog("Enter the age of " + f1.getName())));
        	char f1Gender;
        	f1Gender = JOptionPane.showInputDialog("Enter the gender of " + f1.getName()).charAt(0);
        	f1.setGender(f1Gender);
        	//Using the setName(),setAge() and setGender() mutator methods defined in the Fighter class	for the Fighter object f2        		
        	f2.setName(JOptionPane.showInputDialog("Enter the name for the Fighter 2"));	
        	f2.setAge(Integer.parseInt(JOptionPane.showInputDialog("Enter the age of " + f2.getName())));
        	char f2Gender;
        	f2Gender = JOptionPane.showInputDialog("Enter the gender of " + f2.getName()).charAt(0);
        	f2.setGender(f2Gender);
    		//Creating a variabe for holding the details of both fighter objects inputted by the user
        	String message = f1.toString() + f2.toString();
        	//Displaying each Fighter's details on a single message dialog
        	JOptionPane.showMessageDialog(null,message,"Fighter Details Entered!",JOptionPane.INFORMATION_MESSAGE);	
			//Setting fighterMenu to false so the user can't create more fighter objects
        	fighterMenu.setVisible(false);		
        			
        	//If the arena menu is still visible it means an arena hasn't been previously created, so in the response JLabel, we suggest to the user to create it
        	if(arenaMenu.isVisible()){
        		response.setText("<html><h1 color='red'> Click Arena > Create to create an arena!</h1><br><h1>Quit > Quit to exit program!</h1></html>");
        		JOptionPane.showMessageDialog(null,"Now create the Arena!","Next Step",JOptionPane.INFORMATION_MESSAGE);
        	}//end if(arenaMenu.isVisible()){...}	
        	
        	//If neither of the menus are visible it means they have both been created and we can begin the fight!
        	else if(!fighterMenu.isVisible() && !arenaMenu.isVisible()){
        		JOptionPane.showMessageDialog(null,"You are ready to begin the fight!","Ready!",JOptionPane.INFORMATION_MESSAGE);
        		//Invoking the beginFight() user-defined method
				beginFight();
			}//End else if(!fighterMenu.isVisible() && !arenaMenu.isVisible()){...}		
        }//End if(itemClicked.equals("Add")){...}
        	
        	
		//Create Arena when "Create" is clicked   	
        if(itemClicked.equals("Create")){
        	JOptionPane.showMessageDialog(null,"You have chosen to create the Arena!","Create Arena",JOptionPane.INFORMATION_MESSAGE);
        	//Using the setName(),setLocation() and setCpacity() mutator methods defined in the Arena class	for the Arena object a1
        	a1.setName(JOptionPane.showInputDialog("Enter the name for the Arena"));	
        	a1.setLocation(JOptionPane.showInputDialog("Enter the location of " + a1.getName()));
        	a1.setCapacity(Integer.parseInt(JOptionPane.showInputDialog("Enter the capacity of " + a1.getName())));
        	//String variable for holding the details of the arena entered by the user
        	String message = a1.toString();
        	//Displaying the details of the arena
        	JOptionPane.showMessageDialog(null,message,"Arena Details",JOptionPane.INFORMATION_MESSAGE);
        	//Since the arena has been created, we set it to false to avoid the user creating another
        	arenaMenu.setVisible(false);
        
        	//If the fighter menu is still visible it means the fighters haven't been previously created, so in the response JLabel, we suggest to the user to create them
        	if(fighterMenu.isVisible()){
        		JOptionPane.showMessageDialog(null,"Now create the Fighters!","Next Step",JOptionPane.INFORMATION_MESSAGE);
        		response.setText("<html><h1 color='blue'><br> Click Fighters > Add to add 2 fighters!</h1><br><h1>Quit > Quit to exit program!</h1></html>");
        	}//End if(fighterMenu.isVisible()){	
        	
        	//If neither of the menus are visible it means they have both been created and we can begin the fight!	
        	else if(!fighterMenu.isVisible() && !arenaMenu.isVisible()){
        		JOptionPane.showMessageDialog(null,"You are ready to begin the fight!","Ready!",JOptionPane.INFORMATION_MESSAGE);
        		//Invoking the beginFight() user-defined method
				beginFight();
			}//End else if(!fighterMenu.isVisible() && !arenaMenu.isVisible()){...}
        }//End else if(!fighterMenu.isVisible() && !arenaMenu.isVisible()){...}  


		//Message For when the user clicks "BeginFight"			
		if(event.getSource().equals(beginFightButton)){
			f1Health = 100;
			f2Health = 100;
			//Creating a variable for the introduction to fght message that will be displayed 
			String message = "Welcome Everyone, to the event of a lifetime!\n\n \"" + f1.getName() + "\" and \"" + f2.getName() + 
							 "\" will battle it out to the death!\n\nThis battle is taking place in the infamous " + a1.getName() +
							 " Arena, located in " + a1.getLocation() + ".\nWe currently are at full capacity for this glorious event! A crowd-filling " + a1.getCapacity() +
							 " are here to witness the event today!";
			
			//Changing the message displayed depending on the ages of the fighters	
			//If they are the same age, do the following			 
			if(f1.getAge()==f2.getAge()){
				message += ("\n\nBoth Fighters are evenly aged at " + f1.getAge() + " !");
			}//End if(f1.getAge()==f2.getAge()){...}
			
			//If they aren't the same age, do the following 
			else{
				message += ("\n\n\"" + f1.getName() + "\" is aged " + f1.getAge() + " whereas \"" + f2.getName() + "\" is aged " + f2.getAge());	
			}//End else{...}
			
			//Changing the message displayed depending on the genders of the fighters
			//If they are the same gender, display the following
			if(f1.getGender() == f2.getGender()){
				//If they are both male, display the following
				if(f1.getGender() == 'm' || f1.getGender() == 'M'){
					message += "\n\nBoth fighters today are Male!";
				}//End if(f1.getGender() == 'm' || f1.getGender() == 'M'){...}
				//If they are both female, display the following
				else if(f1.getGender() == 'f' || f1.getGender() == 'F'){
					message += "\n\nBoth fighters today are female!";
				}//End else if(f1.getGender() == 'f' || f1.getGender == 'F'){...}
			}//End if(f1.getGender() == f2.getGender()){...}
			
			//If they aren't the same gender, display the following	
			else{
				message += "\n\nAn upset could be on the cards as we have both a male and a female fighter! \n" + f1.getName() + "(" + f1.getGender() + ")" +  
						   "\n" + f2.getName() + "(" + f2.getGender() + ")";
				}//End else{...}
			
			//Displaying Message
			JOptionPane.showMessageDialog(null,message,"Welcome!",JOptionPane.INFORMATION_MESSAGE);
		    //Creating the Punch and kick buttons for f1 and adding action listeners to them
	  		f1PunchButton = new JButton("Punch");
	  		f1PunchButton.addActionListener(this);
	  		f1KickButton = new JButton("Kick");
	  		f1KickButton.addActionListener(this);
	  		//Adding the buttons to the frame
	  		add(f1PunchButton);
	  		add(f1KickButton);
	  		//Adding the picture defined at the beginning to the screen
	  		add(fightBackground);
	  		//Setting the picture to visible
	  		fightBackground.setVisible(true);
	  		//Since the user has began the fight, we set the begin fight button to invisible
	  		beginFightButton.setVisible(false);
	  		//Creating the Punch and kick buttons for f2 and adding action listeners to them
	  		f2PunchButton = new JButton("Punch");
	  		f2PunchButton.addActionListener(this);
	  		f2KickButton = new JButton("Kick");
	  		f2KickButton.addActionListener(this);
	  		//Adding the buttons to the frame
	  		add(f2KickButton);
	  		add(f2PunchButton);
	  		//Setting f2's buttons to false because f1 will always be tking their turn first
	  		f2PunchButton.setVisible(false);
	  		f2KickButton.setVisible(false);
	  		//Adding and editing the response JLabel for appropriate display on the frame for the user [Rules, Health Stats etc...]
	  		add(response);
	  		response.setText("<html><h1 color = 'orange'>Health Stats:<br>\"" + 
	  						 f1.getName() + "\" @ " + f1Health + "%<br>\"" + f2.getName() + "\" @ " + f2Health + "%" + 
	  						 "</h1><br><h1 color='green'>Rules:<br>- Each player: 100% health<br>- Punch: 10% damage dealt (60% hit connection)<br>" + 
	  						 "-Kick: 30% damage dealt (30% hit connection)</h1><br></html>");
	  		//Message displaying that f1 will go first		
	  		JOptionPane.showMessageDialog(null,"\"" + f1.getName() + "\" will go first!","Turn:" + f1.getName(),JOptionPane.INFORMATION_MESSAGE);
		}//End if(itemClicked.equals("Begin Fight!")){...}
				 	 
				 	 
		//Demonstrating another way of determining what button was clicked in the following code instead of using the itemClicked variable like above to show 
		//an understanding	
		//When Punch is clicked
	    if (event.getSource().equals(f1PunchButton)){ 
			//Random integer between 0-9 (10 possibilities)
			hitOrMiss = (int)(Math.random()*9);	
					      			
		    //Setting the Punch to have a 60% hit ratio. This if statement handles when it hits only (6/10 attempted punches theoretically will hit)
		   	if(hitOrMiss >= 0 && hitOrMiss <= 5){  
		   		//If it hits, f2's health gets 10 damage
			    f2Health = f2Health - 10;	
			    //message displaying to the user that their choice hit
			    JOptionPane.showMessageDialog(null,"HIT! \n10% damage dealt!","HIT",JOptionPane.INFORMATION_MESSAGE);
		      	}
					      	
		    //Handles when the punch misses
			    else if (hitOrMiss >5){
		    	//message displaying to the user if their choice missed 
		    	JOptionPane.showMessageDialog(null,"MISS! \nNo damage dealt!","MISS",JOptionPane.INFORMATION_MESSAGE);
		       	}
					       	
			//updating the health stats and applying them in the label
		  	response.setText("<html><h1 color = 'orange'>Health Stats:<br>\"" + 
		  					 f1.getName() + "\" @ " + f1Health + "%<br>\"" + f2.getName() + "\" @ " + f2Health + "%" + 
		  					 "</h1><br><h1 color='green'>Rules:<br>- Each player: 100% health<br>- Punch: 10% damage dealt (60% hit connection)<br>" + 
		  					 "-Kick: 30% damage dealt (30% hit connection)</h1><br></html>");
			  		
		  	//message saying f1's turn is complete and its now f2's turn				 
		  	JOptionPane.showMessageDialog(null,"Your turn:\"" + f2.getName() + "\"","Turn: " + f2.getName(),JOptionPane.INFORMATION_MESSAGE);
			  	
		  	//Making these invisible because f1 has just taken their turn (punch) and it's now f2's turn
		   	f1PunchButton.setVisible(false);	
		 	f1KickButton.setVisible(false);
		  	//since it's f2's turn, we set their buttons to visible
	       	f2PunchButton.setVisible(true);
		  	f2KickButton.setVisible(true);	
		  		
		  	if (f2Health <= 0){
		  		response.setText("<html><h1 color = 'orange'>Health Stats:<br>\"" + 
		 					 	 f1.getName() + "\" @ " + f1Health + "%<br>\"" + f2.getName() + "\" @ " + f2Health + "%" + "</h1><br> " + 
		 					  	 "<h1 color='green'>Congratulations: \"" + f1.getName() + "\", You are the Winner!<br> " + 
		 					  	 "\"" + f2.getName() + "\" is now @ " + f2Health + "% health! Unlucky!</h1><br><br><h1 color='pink'>GAME OVER</h1></html>");
				JOptionPane.showMessageDialog(null,"\"" + f1.getName() + "\" is the winner!","Congratulations: " + f1.getName(),JOptionPane.INFORMATION_MESSAGE);
				f2PunchButton.setVisible(false);	
			 	f2KickButton.setVisible(false);
			   	f1PunchButton.setVisible(false);
			  	f1KickButton.setVisible(false);
			  	
			  	beginFightButton = new JButton("Restart Fight?");
			  	beginFightButton.setVisible(true);
			  	beginFightButton.addActionListener(this);
			  	add(beginFightButton);
			  	
			  	if(event.getSource() == beginFightButton){
			  		beginFight();
			  	}
			}
	 	}//end of if (event.getSource().equals(f1PunchButton)){...}
		       	
		//f2's turn	
		if (event.getSource().equals(f2PunchButton)){
		   			 
			hitOrMiss = (int)(Math.random()*9);
				      				
		   	if(hitOrMiss >= 0 && hitOrMiss <= 5){
			    f1Health = f1Health - 10;
			    JOptionPane.showMessageDialog(null,"HIT! \n10% damage dealt!","HIT",JOptionPane.INFORMATION_MESSAGE);
		      	}
		    else if(hitOrMiss > 5){
		    	JOptionPane.showMessageDialog(null,"MISS! \nNo damage dealt!","MISS",JOptionPane.INFORMATION_MESSAGE);
		       	}
			 		
			response.setText("<html><h1 color = 'orange'>Health Stats:<br>\"" + 
		 					 f1.getName() + "\" @ " + f1Health + "%<br>\"" + f2.getName() + "\" @ " + f2Health + "%" + 
		 					 "</h1><br><h1 color='green'>Rules:<br>- Each player: 100% health<br>- Punch: 10% damage dealt (60% hit connection)<br>" + 
		 					 "-Kick: 30% damage dealt (30% hit connection)</h1><br></html>");
		 					 
		 	//message saying f2's turn is complete and its now f1's turn				 
		  	JOptionPane.showMessageDialog(null,"Your turn:\"" + f1.getName() + "\"","Turn: " + f1.getName(),JOptionPane.INFORMATION_MESSAGE);
		  	//Making these invisible because f1 has just taken their turn (punch) and it's now f2's turn
		   	f2PunchButton.setVisible(false);	
		 	f2KickButton.setVisible(false);
		  	//since it's f1's turn, we set their buttons to visible
		   	f1PunchButton.setVisible(true);
		  	f1KickButton.setVisible(true);
		  	
		  	if (f1Health <= 0){
		  		response.setText("<html><h1 color = 'orange'>Health Stats:<br>\"" + 
		 					 	 f1.getName() + "\" @ " + f1Health + "%<br>\"" + f2.getName() + "\" @ " + f2Health + "%" + "</h1><br> " + 
		 					  	 "<h1 color='green'>Congratulations: \"" + f2.getName() + "\", You are the Winner!<br> " + 
		 					  	 "\"" + f1.getName() + "\" is now @ " + f1Health + "% health! Unlucky!</h1><br><br><h1 color = 'red'>***** GAME OVER *****</h1></html>");
				JOptionPane.showMessageDialog(null,"\"" + f2.getName() + "\" is the winner!","Congratulations" + f2.getName(),JOptionPane.INFORMATION_MESSAGE);
				f2PunchButton.setVisible(false);	
			 	f2KickButton.setVisible(false);
			   	f1PunchButton.setVisible(false);
			  	f1KickButton.setVisible(false);
			  	
			  	beginFightButton = new JButton("Restart Fight?");
			  	beginFightButton.setVisible(true);
			  	beginFightButton.addActionListener(this);
			  	beginFightButton.setBackground(Color.YELLOW);
			  	beginFightButton.setLocation(400,400);
			  	add(beginFightButton);
			  	
			  	if(event.getSource() == beginFightButton){
			  		beginFight();
			  	}
			}
	    }//End of if (event.getSource().equals(f2PunchButton)){...)

			
		
	}//End of actionPerformed		   
}//End of class
    
    