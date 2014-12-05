//DriverProgram.java
/*Driver program*/

/********* Importing Packages *********/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;



/********* DriverProgram class *********/
																							 	   																	 	   																					
public class DriverProgram extends JFrame implements ActionListener{

	//Class Attributes	
	private JMenu fighterMenu, arenaMenu, quitMenu;	//JMenu attributes to be added to the JMenubar for each operation before the fight begins	
	private JMenuItem item; //Creating re-usable JMenuItem variable for use in the user-defined methods where they create different JMenus
	
	private JLabel response; //The response JLabel variable will change the label on the screen according to what events occur within the program
	private JLabel fightBackground = new JLabel(new ImageIcon("fightImage.jpg")); //Applying the designated picture background to a JLabel for the fight scene	
		
	private JButton beginFightButton; //JButton that will start the fight when clicked	
	private JButton f1PunchButton, f1KickButton, f2PunchButton, f2KickButton; //These buttons will be used in the fight simulator and each will have a particular function [outlined later]
	
	JTextArea textArea = new JTextArea();//Setting up a JTextArea variable which will be used in the welcome bmessage after the user clicks the beginFightButton
	
	//Fighter objects being created for use within the program
	private Fighter f1 = new Fighter(); 
    private	Fighter f2 = new Fighter();
    
    private Arena a1 = new Arena();//Arena object being created for use within the program
    
	private int f1Health = 100, f2Health = 100; //Initial health values of each fighter
	private int hitOrMiss; //This variable will be used in relation to the hit ratios (30%, 60% etc...) of punches and kicks
		
	
	
	/********* Driver *********/
																																																															
	public static void main(String args[]) throws Exception {
		
		DriverProgram frame = new DriverProgram(); //Creating frame object for display on the screen
		
		frame.setVisible(true); //Making a DriverProgram object visible to the end user
		
	} //End of driver 
		
		
		
	/********* Constructor (No argument) *********/	
																												
	public DriverProgram(){	
		
		super("The Fight!"); //Super reference being used here instead of the setTitle() method to demonstrate and understanding of inheritance
		
		Container cPane = getContentPane(); //Creating container for all the contents
		
		//Frame properties
        setSize(800,700); 
        setResizable(false);
        setLocation(250,50);
        
		cPane.setLayout(new FlowLayout()); //Setting a simple default layout on the content pane created earlier
		
		//Invoking the user-defined methods
		createFighterMenu();
		createArenaMenu();
		createQuitMenu();
		
		
		beginFightButton = new JButton("Begin Fight!"); //New button which will become visible only when neither of the JMenus are visible and allow the user to begin the fight
		
		cPane.add(beginFightButton); //Adding the begin fight button to the content pane
		
		beginFightButton.setVisible(false); //Setting the begin fight button to invisible for now until the fighters and arena are created
		
		beginFightButton.addActionListener(this); //Adding and action listener to listen for when the beginFightbutton is clicked
		
		//Creating and applying and editing the colored menu bar object
		JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.orange);
        
      	//Adding JMenu objects previously created to the JMenuBar
        menuBar.add(fighterMenu);
        menuBar.add(arenaMenu);
        menuBar.add(quitMenu);
        
        /*****Paul Kennedy (from class) told me that html referencing is possible in java so credit to him for the possibility of my use of html code in this project******/
        //Setting the response JLabel to instructions for the user
        response = new JLabel("<html><h1 color='blue'><br> Click [Fighters > Add] to add 2 fighters!</h1><br><h1 color='red'> Click [Arena > Create] to create an" +
        					  "arena!</h1><br><h1>Click [Quit > Quit] to exit program!</h1></html>");
        					  
		cPane.add(response); //Adding the response JLabel to the content pane
		
		cPane.add(beginFightButton); //Adding the beging fight button to the content pane
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Setting defaukt operation to close when x button is clicked
		
	} //End of constructor DriverProgram(){...}
	

		
	/********* Creating Menus (User-Defined Methods) *********/



	/********* Creating Fighter Menu *********/
																																	
	public void createFighterMenu(){
		
		fighterMenu = new JMenu("Fighters"); //Creating fighterMenu Object	
		fighterMenu.setForeground(Color.BLUE);
		
		item = new JMenuItem("Add"); //Creating object from using the item variable
		
		//Editing and adding the item to the fighter Menu 
		fighterMenu.add(item);
		item.setBackground(Color.BLUE);
		item.setForeground(Color.WHITE);
		
		item.addActionListener(this); //Adding an action listener to listen for the event of when this paticular item is clicked
		
	} //End of createFighterMenu(){...}
			
			
			
	/********* Creating Arena Menu	*********/	
																																				
	public void createArenaMenu(){
		
		arenaMenu = new JMenu("Arena"); //Creating ArenaMenu Object
		arenaMenu.setForeground(Color.RED);
		
		item = new JMenuItem("Create"); //Creating object from using the item variable
		
		//Editing and adding the item to the arena Menu 
		arenaMenu.add(item);
		item.setBackground(Color.RED);
		item.setForeground(Color.WHITE);
		
		item.addActionListener(this); //Adding an action listener to listen for the event of when this paticular item is clicked
		
	} //End of createArenaMenu(){...}				
	
			
			
	/********* Creating Quit Menu *********/	
																			 																			 		
	public void createQuitMenu(){
		
		quitMenu = new JMenu("Quit"); //Creating ArenaMenu Object
		
		item = new JMenuItem("Quit"); //Creating object from using the item variable
		 
		quitMenu.add(item); //Adding the item to the arena Menu
		
		item.addActionListener(this); //Adding an action listener to listen for the event of when this paticular item is clicked
		
	} //End of createQuitMenu(){...}
		
		
			
	/********* Begin Fight Method *********/
	 																																				
	public void beginFight(){
		
		beginFightButton.setVisible(true); //Setting the beginFightButton to visible under conditions listed in the actionPerformed Method below
	  	beginFightButton.setBackground(Color.YELLOW); //Editing the beginFightButton
	  	
		response.setText(""); //Setting the response label to empty string to center the fight button on the screen
		
	} //End of beginFight(){...}
	
	
	
	/********* Validating name input for f1 *********/
	
	public void nameValidation(Fighter f){
        			       	
       	String fName = JOptionPane.showInputDialog("Enter the name for the Fighter!"); //Creating a String variable for the validation of the name attribute
        	
       	while(fName.equals(""))	//While the name entered is an emoty string, do the following...
			fName = JOptionPane.showInputDialog("Inavlid Input!\n\n Enter the name for the Fighter");
			
		/************************************************************************************************************/	
		//Code Reference for name input validation
		//Availability: http://www.java2s.com/Tutorial/Java/0120__Development/Validatethefirstnameandlastname.htm
		//Author: 12 Demo Source 
		//Site: java2s.com
		//Source Code Date: 2009 
		/*Changes Made: Instead of using 2 variables for 1st name and last name, I just used the one variable for the full name
		 *				Also, I didn't use the validation in it's own method like the author did*/	
			 	
	    if (fName.matches("[a-zA-z]+([ '-][a-zA-Z]+)*" ))
	   		f.setName(fName);
	   		
	   	else{
	   		while(!fName.matches("[a-zA-z]+([ '][a-zA-Z]+)*" ))
	   			fName = JOptionPane.showInputDialog("Inavlid Input!\n\n Enter the name for the Fighter");
	   	}
	   	/************************************************************************************************************/
	   	  	
	} //End Validating Name input
	
	
	
	/********* Validating Age Input for f1 *********/
	
	public void ageValidation(Fighter f){
	 
       	String fAge = JOptionPane.showInputDialog("Enter the age of the Fighter"); //Creating String variable for the age variable
			
		while(fAge.equals("")) //If the age entered was an empty String, do the following...
			fAge = JOptionPane.showInputDialog("Invalid Input!\n\n Enter the age of the Fighter");
			
		/************************************************************************************************************
		 *Note: This is the same code as referenced above, just modified	
		 *Code Reference for age input validation (The next few lines of code)
		 *Availability: http://www.java2s.com/Tutorial/Java/0120__Development/Validatethefirstnameandlastname.htm
		 *Author: 12 Demo Source 
		 *Site: java2s.com
		 *Source Code Date: 2009 
		 *Changes Made: Instead of using 2 variables for 1st name and last name, I just used the one variable for the age
		 *				Also, I didn't use the validation in it's own method like the author did and i changed what was in the brackets to accomodate for numbers and not letters*/
	
		if (fAge.matches("[0-9]*")){
			int fAgee = Integer.parseInt(fAge);
	   		f.setAge(fAgee);
	   	}
	   	
	   	else{
	   		while(!fAge.matches("[0-9]*") || fAge.equals(""))
				fAge = JOptionPane.showInputDialog("Invalid Input!\n\n Enter the age of the Fighter");
	   	}
		/************************************************************************************************************/	
				
	}//End validating Age input
	
	
	
	/********* Validating Gender input for f1 *********/
	
	public void genderValidation(Fighter f){
			
        String fGenderInput = JOptionPane.showInputDialog("Enter the gender of the Fighter (M/F)"); //Creating String variable for gender for the validation
        	
       	while(fGenderInput.equals("")) ///If the gender entered was an empty String,do the following...
			fGenderInput = JOptionPane.showInputDialog("Invalid Input!\n\nEnter the gender of the Fighter (M/F)");
			
       	char fGender = fGenderInput.charAt(0); //Creating char ariable for the frst characte of the string entered by the user
			
       	if (fGender == 'f' || fGender == 'F' || fGender == 'm' || fGender == 'M') //Conditions in order to progress in the program
       		f.setGender(fGender); //Only do this when the condition are satisfied
       	
       	else{ //Invalid input validation...	
	       	for (int c=0; c <= c+1; c++){
	       		if (fGender == 'f' || fGender == 'F' || fGender == 'm' || fGender == 'M'){ //Conditions in order to progress in the program
       				f.setGender(fGender); //Only do this when the condition are satisfied
       				break;
	       		}
	       	
		       	else
		       		fGenderInput = JOptionPane.showInputDialog("Invalid Input!\n\nEnter the gender of the Fighter (M/F)");	
	       	}
       	}
       	
	} //End validating gender
	
	
	
	/********* Validating Name input for a1 *********/
	
	public void nameValidation(Arena a){
        			       	
       	String aName = JOptionPane.showInputDialog("Enter the name of the Arena!"); //Creating a String variable for the validation of the name attribute
        	
       	while(aName.equals(""))	//While the name entered is an emoty string, do the following...
			aName = JOptionPane.showInputDialog("Inavlid Input!\n\n Enter the name of the Arena");
			
		/************************************************************************************************************/	
		//Code Reference for name input validation
		//Availability: http://www.java2s.com/Tutorial/Java/0120__Development/Validatethefirstnameandlastname.htm
		//Author: 12 Demo Source 
		//Site: java2s.com
		//Source Code Date: 2009 
		/*Changes Made: Instead of using 2 variables for 1st name and last name, I just used the one variable for the full name
		 *				Also, I didn't use the validation in it's own method like the author did*/	
			 	
	    if (aName.matches("[a-zA-z]+([ '-][a-zA-Z]+)*" ))
	   		a.setName(aName);
	   		
	   	else{
	   		while(!aName.matches("[a-zA-z]+([0-9])+([ '-][a-zA-Z]+)*" ))
	   			aName = JOptionPane.showInputDialog("Inavlid Input!\n\n Enter the name of the Arena");
	   	}
	   	/************************************************************************************************************/
	   	  	
	} //End Validating Name input
	
	
	
	/********* Validating location input for a1 *********/
	
	public void locationValidation(Arena a){
        			       	
       	String aLocation = JOptionPane.showInputDialog("Enter the location of the Arena!"); //Creating a String variable for the validation of the name attribute
        	
       	while(aLocation.equals(""))	//While the name entered is an emoty string, do the following...
			aLocation = JOptionPane.showInputDialog("Inavlid Input!\n\n Enter the location of the Arena");
			
		/************************************************************************************************************/	
		//Code Reference for name input validation (The next 7 lines of code)
		//Availability: http://www.java2s.com/Tutorial/Java/0120__Development/Validatethefirstnameandlastname.htm
		//Author: 12 Demo Source 
		//Site: java2s.com
		//Source Code Date: 2009 
		/*Changes Made: Instead of using 2 variables for 1st name and last name, I just used the one variable for the full name
		 *				Also, I didn't use the validation in it's own method like the author did*/	
			 	
	    if (aLocation.matches("[a-zA-z]+([ '-][a-zA-Z]+)*" ))
	   		a.setLocation(aLocation);
	   		
	   	else{
	   		while(!aLocation.matches("[a-zA-z]+([ '-][a-zA-Z]+)*" ))
	   			aLocation = JOptionPane.showInputDialog("Inavlid Input!\n\n Enter the location of the Arena");
	   	}
	   	/************************************************************************************************************/
	   	  	
	} //End Validating Location input
    
    
    
    /********* Validating Capacity Input for a1 *********/
	
	public void capacityValidation(Arena a){
	 
       	String aCapacity = JOptionPane.showInputDialog("Enter the capacity of the Arena"); //Creating String variable for the age variable
			
		while(aCapacity.equals("")) //If the age entered was an empty String, do the following...
			aCapacity = JOptionPane.showInputDialog("Invalid Input!\n\n Enter the capacity of the Arena");
			
		/************************************************************************************************************
		 *Note: This is the same code as referenced above, just modified	
		 *Code Reference for age input validation (The next few lines of code)
		 *Availability: http://www.java2s.com/Tutorial/Java/0120__Development/Validatethefirstnameandlastname.htm
		 *Author: 12 Demo Source 
		 *Site: java2s.com
		 *Source Code Date: 2009 
		 *Changes Made: Instead of using 2 variables for 1st name and last name, I just used the one variable for the age
		 *				Also, I didn't use the validation in it's own method like the author did and i changed what was in the brackets to accomodate for numbers and not letters*/
	
		if (aCapacity.matches("[0-9]*")){
			int aCapacityy = Integer.parseInt(aCapacity);
	   		a.setCapacity(aCapacityy);
	   	}
	   	
	   	else{
	   		while(!aCapacity.matches("[0-9]*") || aCapacity.equals(""))
				aCapacity = JOptionPane.showInputDialog("Invalid Input!\n\n Enter the capacity of the Arena");
	   	}
		/************************************************************************************************************/	
				
	}//End validating Capacity input    	
        	

	/********* Handler/Listener *********/
																																																																
	public void actionPerformed(ActionEvent event){
		
		//Making variable for use in deciding which JMenuItem was clicked/what event occured
        String  itemClicked;
        itemClicked = event.getActionCommand();
              
              
                   										
		/********* Quit Program when "Quit" is clicked *********/
																	 
        if (itemClicked.equals("Quit")){
        	
        	JOptionPane.showMessageDialog(null,"Closing System","System Close",JOptionPane.INFORMATION_MESSAGE); //Displays appropriate message for the user
        	
        	System.exit(0); //Quit system method
        	
        } //End if(itemClicked.equals("Quit")){...}
        		     	
        		   
        		   		     		
		/********* Add two Fighters when "Add" is clicked *********/
																  		
        if(itemClicked.equals("Add")){
        	
        	JOptionPane.showMessageDialog(null,"You have chosen to create two Fighters!","Create Fighters",JOptionPane.INFORMATION_MESSAGE); //Displaying appropriate message 
        	
        	//Using the setName(),setAge() and setGender() mutator methods defined in the Fighter class	for the Fighter object f2 in the following validations...
        	JOptionPane.showMessageDialog(null,"Creating Fighter #1!","Fighter 1",JOptionPane.INFORMATION_MESSAGE);
        	nameValidation(f1);
			ageValidation(f1);
			genderValidation(f1); 
			JOptionPane.showMessageDialog(null,"Creating Fighter #2!","Fighter 2",JOptionPane.INFORMATION_MESSAGE);
			nameValidation(f2);
			ageValidation(f2);
			genderValidation(f2);       		
        	
        	String message = f1.toString() + f2.toString(); //Creating a variabe for holding the details of both fighter objects inputted by the user
        	
        	JOptionPane.showMessageDialog(null,message,"Fighter Details Entered!",JOptionPane.INFORMATION_MESSAGE);	//Displaying each Fighter's details on a single message dialog
			
        	fighterMenu.setVisible(false); //Setting fighterMenu to false so the user can't create more fighter objects	
        			
        	//If the arena menu is still visible it means an arena hasn't been previously created, so in the response JLabel, we suggest to the user to create it
        	if(arenaMenu.isVisible()){
        		response.setText("<html><h1 color='red'> Click Arena > Create to create an arena!</h1><br><h1>Quit > Quit to exit program!</h1></html>");
        		JOptionPane.showMessageDialog(null,"Now create the Arena!","Next Step",JOptionPane.INFORMATION_MESSAGE);
        	}	
        	
        	//If neither of the menus are visible it means they have both been created and we can begin the fight!
        	else if(!fighterMenu.isVisible() && !arenaMenu.isVisible()){
        		JOptionPane.showMessageDialog(null,"You are ready to begin the fight!","Ready!",JOptionPane.INFORMATION_MESSAGE);
        		
				beginFight(); //Invoking the beginFight() user-defined method
			}
				
        }//End if(itemClicked.equals("Add")){...}
        	
        	
        	
		/********* Create Arena when "Create" is clicked *********/  
		 	
        if(itemClicked.equals("Create")){
        	
        	JOptionPane.showMessageDialog(null,"You have chosen to create the Arena!","Create Arena",JOptionPane.INFORMATION_MESSAGE);
        	
        	//Using the setName(),setLocation() and setCpacity() mutator methods defined in the Arena class	for the Arena object a1
        	nameValidation(a1);	
        	locationValidation(a1);
        	capacityValidation(a1);
        
        	
        	String message = a1.toString(); //String variable for holding the details of the arena entered by the user
        	
        	JOptionPane.showMessageDialog(null,message,"Arena Details",JOptionPane.INFORMATION_MESSAGE); //Displaying the details of the arena
        	
        	arenaMenu.setVisible(false); //Since the arena has been created, we set it's visibility to false to avoid the user creating another
        
        	//If the fighter menu is still visible it means the fighters haven't been previously created, so in the response JLabel, we suggest to the user to create them
        	if(fighterMenu.isVisible()){
        		JOptionPane.showMessageDialog(null,"Now create the Fighters!","Next Step",JOptionPane.INFORMATION_MESSAGE);
        		response.setText("<html><h1 color='blue'><br> Click Fighters > Add to add 2 fighters!</h1><br><h1>Quit > Quit to exit program!</h1></html>");
        	}
        	
        	//If neither of the menus are visible it means they have both been created and we can begin the fight!	
        	else if(!fighterMenu.isVisible() && !arenaMenu.isVisible()){
        		JOptionPane.showMessageDialog(null,"You are ready to begin the fight!","Ready!",JOptionPane.INFORMATION_MESSAGE);
        		
				beginFight(); //Invoking the beginFight() user-defined method
			}
			
        } //End if(itemClicked.equals("Create")){...}

		
		
		/********* Demonstrating another way of determining what button was clicked in the following code instead of using the itemClicked variable like above to show an understanding *********/ 
		
		

		/********* Message For when the user clicks "BeginFight" *********/ 
						
		if(event.getSource().equals(beginFightButton)){
			//Resets both fighter's health stats to 100
			f1Health = 100;
			f2Health = 100;
			
			
			Font textAreaFont = new Font("monospaced",Font.PLAIN,12); //Setting up a monospaced font for the JTextArea
			
			textArea.setFont(textAreaFont); //Applying the font to the textArea
			
			//Creating a variable for the introduction to fight message that will be displayed 
			String message = "Welcome Everyone, to the event of a lifetime!\n\n \"" + f1.getName() + "\" and \"" + f2.getName() + 
							 "\" will battle it out to the death!\n\nThis battle is taking place in the infamous " + a1.getName() +
							 " Arena, located in " + a1.getLocation() + ".\nWe currently are at full capacity for this glorious event! A crowd-filling " + a1.getCapacity() +
							 " are here to witness the event today!";
							 
			textArea.append(message); //Applying the message to the TextArea
			
			//Changing the message displayed depending on the ages of the fighters	
			
			//If they are the same age, do the following...			 
			if(f1.getAge()==f2.getAge()){
				message += ("\n\nBoth Fighters are evenly aged at " + f1.getAge() + " !");
				textArea.setText("");
				textArea.append(message);
			}
			
			//If they aren't the same age, do the following...
			else{
				message += ("\n\n\"" + f1.getName() + "\" is aged " + f1.getAge() + " whereas \"" + f2.getName() + "\" is aged " + f2.getAge());
				textArea.setText("");
				textArea.append(message);	
			}
			
			//Changing the message displayed depending on the genders of the fighters
			
			//If they are the same gender, display the following
			if(f1.getGender() == f2.getGender()){
				
				if(f1.getGender() == 'm' || f1.getGender() == 'M'){ //If they are both male, display the following
					message += "\n\nBoth fighters today are Male!";
					textArea.setText("");
					textArea.append(message);
				}
				
				else if(f1.getGender() == 'f' || f1.getGender() == 'F'){ //If they are both female, display the following
					message += "\n\nBoth fighters today are female!";
					textArea.setText("");
					textArea.append(message);
				}
			}
			
			//If they aren't the same gender, display the following	
			else{
				message += "\n\nAn upset could be on the cards as we have both a male and a female fighter! \n" + f1.getName() + "(" + f1.getGender() + ")" +  
						   "\n" + f2.getName() + "(" + f2.getGender() + ")";
				textArea.setText("");
				textArea.append(message);
				}
			
			
			JOptionPane.showMessageDialog(null,textArea,"Welcome!",JOptionPane.INFORMATION_MESSAGE); //Displaying Welcome Message
			
		    //Creating the Punch and kick buttons for f1 and adding action listeners to them
	  		f1PunchButton = new JButton("Punch");
	  		f1PunchButton.addActionListener(this);
	  		f1KickButton = new JButton("Kick");
	  		f1KickButton.addActionListener(this);
	  		
	  		//Adding the buttons to the frame
	  		add(f1PunchButton);
	  		add(f1KickButton);
	  		
	  		add(fightBackground); //Adding the picture defined at the beginning to the screen
	  		
	  		fightBackground.setVisible(true); //Setting the picture to visible
	  		
	  		beginFightButton.setVisible(false); //Since the user has began the fight, we set the begin fight button to invisible
	  		
	  		//Creating the Punch and kick buttons for f2 and adding action listeners to them
	  		f2PunchButton = new JButton("Punch");
	  		f2PunchButton.addActionListener(this);
	  		f2KickButton = new JButton("Kick");
	  		f2KickButton.addActionListener(this);
	  		
	  		//Adding the buttons to the frame
	  		add(f2KickButton);
	  		add(f2PunchButton);
	  		
	  		//Setting f2's buttons to false because f1 will always be taking their turn first
	  		f2PunchButton.setVisible(false);
	  		f2KickButton.setVisible(false);
	  		
	  		add(response); //Adding and editing the response JLabel for appropriate display on the frame for the user [Rules, Health Stats etc...]
	  		
	  		//updating the health stats and applying them in the label
		  	response.setText("<html><h1 color = 'orange'>Health Stats:<br>\"" + 
		  					 f1.getName() + "\" @ " + f1Health + "%<br>\"" + f2.getName() + "\" @ " + f2Health + "%" + 
		  					 "</h1><br><h1 color='green'>Rules:<br>- Each player: 100% health<br>- Punch: 10% damage dealt (70% hit connection)<br>" + 
		  					 "- Kick: 30% damage dealt (30% hit connection)<br>- If any attack misses, the opponent regenerates 5% health!</h1><br>" + 
		  					 "<h1 color='red'>You will go first: \"" + f1.getName() + "\"</h1></html>");
		  					 
		}//End if(itemClicked.equals("Begin Fight!")){...}
				 	 
				 	
				 	 		 	
		/********* When f1's Punch is clicked *********/
		
	    if (event.getSource().equals(f1PunchButton)){ 
			
			hitOrMiss = (int)(Math.random()*9);	//Random integer between 0-9 (10 possibilities)
					      			
		    //Setting the Punch to have a 70% hit ratio. This if statement handles when it hits only (6/10 attempted punches theoretically will hit)
		   	if(hitOrMiss >= 0 && hitOrMiss <= 6){  
		   		
			    f2Health = f2Health - 10; //If it hits, f2's health gets 10 damage
			    
			    if(f2Health < 0) //So that thei health isn't displayed as a negative number
			    	f2Health = 0;

			    JOptionPane.showMessageDialog(null,"HIT! \n10% damage dealt!","HIT",JOptionPane.INFORMATION_MESSAGE);
		      	}
					      	
		    //Handles when the punch misses
			else if (hitOrMiss > 6){
		    	//message displaying to the user if their choice missed
		    	if (f2Health == 100)
		    		JOptionPane.showMessageDialog(null,"MISS! \nNo damage dealt!\n\n" + f2.getName() + ": 0% Health gained! [Full Health]","MISS",JOptionPane.INFORMATION_MESSAGE);

		    	else{
		    		JOptionPane.showMessageDialog(null,"MISS! \nNo damage dealt!\n\n" + f2.getName() + ": 5% Health gained!","MISS",JOptionPane.INFORMATION_MESSAGE);
		    		f2Health = f2Health + 5;
		    	}
			}
					
		  	//Making these invisible because f1 has just taken their turn (punch) and it's now f2's turn
		   	f1PunchButton.setVisible(false);	
		 	f1KickButton.setVisible(false);
		 	
		  	//since it's f2's turn, we set their buttons to visible
	       	f2PunchButton.setVisible(true);
		  	f2KickButton.setVisible(true);	
		  		
		  	//updating the health stats and applying them in the label
		  	response.setText("<html><h1 color = 'orange'>Health Stats:<br>\"" + 
		  					 f1.getName() + "\" @ " + f1Health + "%<br>\"" + f2.getName() + "\" @ " + f2Health + "%" + 
		  					 "</h1><br><h1 color='green'>Rules:<br>- Each player: 100% health<br>- Punch: 10% damage dealt (70% hit connection)<br>" + 
		  					 "- Kick: 30% damage dealt (30% hit connection)<br>- If any attack misses, the opponent regenerates 5% health!</h1><br>" + 
		  					 "<h1 color='red'>Your Turn: \"" + f2.getName() + "\"</h1></html>");
		  					 
	 	}//end of if (event.getSource().equals(f1PunchButton)){...}
	 	
	 	
	 
	 	/********* When f1's Kick is clicked *********/
	 	
	    else if (event.getSource().equals(f1KickButton)){ 
			
			hitOrMiss = (int)(Math.random()*9);	//Random integer between 0-9 (10 possibilities)
					      			
		    //Setting the Kick to have a 30% hit ratio. This if statement handles when it hits only (3/10 attempted punches theoretically will hit)
		   	if(hitOrMiss >= 0 && hitOrMiss <= 2){  
		   		
			    f2Health = f2Health - 30; //If it hits, f2's health gets 30 damage
			    
			    if(f2Health < 0){
			    	f2Health = 0;
			    }	
			    //message displaying to the user that their choice hit
			    JOptionPane.showMessageDialog(null,"HIT! \n30% damage dealt!","HIT",JOptionPane.INFORMATION_MESSAGE);
		      	}
					      	
		    //Handles when the kick misses
			else if (hitOrMiss > 2){
		    	//message displaying to the user if their choice missed 
		    	if (f2Health == 100)
		    		JOptionPane.showMessageDialog(null,"MISS! \nNo damage dealt!\n\n" + f2.getName() + ": 0% Health gained! [Full Health]","MISS",JOptionPane.INFORMATION_MESSAGE);

		    	else{
		    		JOptionPane.showMessageDialog(null,"MISS! \nNo damage dealt!\n\n" + f2.getName() + ": 5% Health gained!","MISS",JOptionPane.INFORMATION_MESSAGE);
		    		f2Health = f2Health + 5;
		    	}
		    }
			  	
		  	//Making these invisible because f1 has just taken their turn (punch) and it's now f2's turn
		   	f1PunchButton.setVisible(false);	
		 	f1KickButton.setVisible(false);
		 	
		  	//since it's f2's turn, we set their buttons to visible
	       	f2PunchButton.setVisible(true);
		  	f2KickButton.setVisible(true);	
		  		
		  	//updating the health stats and applying them in the label
		  	response.setText("<html><h1 color = 'orange'>Health Stats:<br>\"" + 
		  					 f1.getName() + "\" @ " + f1Health + "%<br>\"" + f2.getName() + "\" @ " + f2Health + "%" + 
		  					 "</h1><br><h1 color='green'>Rules:<br>- Each player: 100% health<br>- Punch: 10% damage dealt (70% hit connection)<br>" + 
		  					 "- Kick: 30% damage dealt (30% hit connection)<br>- If any attack misses, the opponent regenerates 5% health!</h1><br>" + 
		  					 "<h1 color='red'>Your Turn: \"" + f2.getName() + "\"</h1></html>");
	 	}//end of if (event.getSource().equals(f1PunchButton)){...}
		       	
		       	
		       	    	
		/********* f2's turn *********/
			
		/********* When f2's Punch Button is clicked *********/
		
		if (event.getSource().equals(f2PunchButton)){
		   			 
			hitOrMiss = (int)(Math.random()*9); //Random integer between 0-9 (10 possibilities)
				      				
			//Setting the Punch to have a 70% hit ratio. This if statement handles when it hits only (6/10 attempted punches theoretically will hit)
		   	if(hitOrMiss >= 0 && hitOrMiss <= 6){
		   		
			    f1Health = f1Health - 10; //If it hits, f1's health gets 10 damage
			    
			    if(f1Health < 0) //If the health will be a negative number, just set it to 0 and it's game over 
			    	f1Health = 0;
			    
			    JOptionPane.showMessageDialog(null,"HIT! \n10% damage dealt!","HIT",JOptionPane.INFORMATION_MESSAGE); //Displaying hit message
		    }
		    
		    //Handles when the punch misses
		    else if(hitOrMiss > 6){ 
		    	
		    	if (f2Health == 100) //Not adding 5% health if it's already full 
		    		JOptionPane.showMessageDialog(null,"MISS! \nNo damage dealt!\n\n" + f1.getName() + ": 0% Health gained! [Full Health]","MISS",JOptionPane.INFORMATION_MESSAGE);

		    	else{ //Adding on 5% heallth  to f1 since f2's punch missed
		    		JOptionPane.showMessageDialog(null,"MISS! \nNo damage dealt!\n\n" + f1.getName() + ": 5% Health gained!","MISS",JOptionPane.INFORMATION_MESSAGE);
		    		f1Health = f1Health + 5;
		    	}
		    }
			 		
		  	//Making these invisible because f1 has just taken their turn (punch) and it's now f2's turn
		   	f2PunchButton.setVisible(false);	
		 	f2KickButton.setVisible(false);
		 	
		  	//since it's f1's turn, we set their buttons to visible
		   	f1PunchButton.setVisible(true);
		  	f1KickButton.setVisible(true);	
		  		
		  	//Setting appropriate label in the Frame
		  	response.setText("<html><h1 color = 'orange'>Health Stats:<br>\"" + 
		  					 f1.getName() + "\" @ " + f1Health + "%<br>\"" + f2.getName() + "\" @ " + f2Health + "%" + 
		  					 "</h1><br><h1 color='green'>Rules:<br>- Each player: 100% health<br>- Punch: 10% damage dealt (70% hit connection)<br>" + 
		  					 "- Kick: 30% damage dealt (30% hit connection)<br>- If any attack misses, the opponent regenerates 5% health!</h1><br>" + 
		  					 "<h1 color='red'>Your Turn: \"" + f1.getName() + "\"</h1></html>");
		  					 
	    }//End of if (event.getSource().equals(f2PunchButton)){...)
	    
	    
	      
	    /********* When f2's Kick is clicked *********/
	    
	    else if (event.getSource().equals(f2KickButton)){ 
			
			hitOrMiss = (int)(Math.random()*9);	//Random integer between 0-9 (10 possibilities)
					      			
		    //Setting the Kick to have a 30% hit ratio. This if statement handles when it hits only (3/10 attempted punches theoretically will hit)
		   	if(hitOrMiss >= 0 && hitOrMiss <= 2){  
		   		//If it hits, f1's health gets 10 damage
			    f1Health = f1Health - 30; //If it hits, f1's health gets 30 damage
			    
			    if(f1Health < 0){
			    	f1Health = 0;
			    }	
			    	
			    //message displaying to the user that their choice hit
			    JOptionPane.showMessageDialog(null,"HIT! \n30% damage dealt!","HIT",JOptionPane.INFORMATION_MESSAGE);
		      	}
					      	
		    //Handles when the kick misses
			else if (hitOrMiss > 2){
		    	//message displaying to the user if their choice missed 
		    	if (f1Health == 100)
		    		JOptionPane.showMessageDialog(null,"MISS! \nNo damage dealt!\n\n" + f1.getName() + ": 0% Health gained! [Full Health]","MISS",JOptionPane.INFORMATION_MESSAGE);

		    	else{
		    		JOptionPane.showMessageDialog(null,"MISS! \nNo damage dealt!\n\n" + f1.getName() + ": 5% Health gained!","MISS",JOptionPane.INFORMATION_MESSAGE);
		    		f1Health = f1Health + 5;
		    	}
		    }
					       	
		  	//Making these invisible because f1 has just taken their turn (punch) and it's now f2's turn
		   	f1PunchButton.setVisible(true);	
		 	f1KickButton.setVisible(true);
		 	
		  	//since it's f2's turn, we set their buttons to visible
	       	f2PunchButton.setVisible(false);
		  	f2KickButton.setVisible(false);	
		  		
		  	response.setText("<html><h1 color = 'orange'>Health Stats:<br>\"" + 
		  					 f1.getName() + "\" @ " + f1Health + "%<br>\"" + f2.getName() + "\" @ " + f2Health + "%" + 
		  					 "</h1><br><h1 color='green'>Rules:<br>- Each player: 100% health<br>- Punch: 10% damage dealt (70% hit connection)<br>" + 
		  					 "- Kick: 30% damage dealt (30% hit connection)<br>- If any attack misses, the opponent regenerates 5% health!</h1><br>" + 
		  					 "<h1 color='red'>Your Turn: \"" + f2.getName() + "\"</h1></html>");
		  					 
	 	}//end of else if (event.getSource().equals(f2PunchButton)){...}
	    
	    
	       
	    /********* Determining when it's Game Over *********/
	    
	    //Handles if f1 Lost
	    
		if (f1Health <= 0){
		  		f1Health = 0; //Setting health to 0 so it can't be a negative integer
		  		
		  		//Re-dsiplaying the beginFightButto if the fighters wish to play again...
		  		beginFightButton = new JButton("Restart Fight?");
			  	beginFightButton.setVisible(true);
			  	beginFightButton.addActionListener(this);
			  	beginFightButton.setBackground(Color.YELLOW);
			  	beginFightButton.setLocation(400,400);
			  	add(beginFightButton);
			  	
			  	//Changing the the text to an appropriate message
		  		response.setText("<html><h1 color = 'orange'>Health Stats:<br>\"" + 
		 					 	 f1.getName() + "\" @ " + f1Health + "%<br>\"" + f2.getName() + "\" @ " + f2Health + "%" + "</h1><br> " + 
		 					  	 "<h1 color='green'>Congratulations: \"" + f2.getName() + "\", You are the Winner!<br> " + 
		 					  	 "\"" + f1.getName() + "\" is now @ " + f1Health + "% health! Unlucky!</h1><br><br><h1 color = 'red'>***** GAME OVER *****</h1></html>");
		 		
		 		//Message dialog displaying the winner			  	 
				JOptionPane.showMessageDialog(null,"\"" + f2.getName() + "\" is the winner!","Congratulations" + f2.getName(),JOptionPane.INFORMATION_MESSAGE);
				
				//Setting all these JButtons to invisible since the fight is over
				f2PunchButton.setVisible(false);	
			 	f2KickButton.setVisible(false);
			   	f1PunchButton.setVisible(false);
			  	f1KickButton.setVisible(false);
			  	
			  	if(event.getSource() == beginFightButton){ //If the user click the button, re-start the fight
			  		beginFight();
			  	}
			  	
		} //End if (f1Health <= 0){...}
			
				
			
		//Handles if f1 Lost	
					
		else if (f2Health <= 0){
			
		  		f2Health = 0; //Setting health to 0 so it can't be a negative integer
		  		
		  		//Re-dsiplaying the beginFightButto if the fighters wish to play again...
		  		beginFightButton = new JButton("Restart Fight?");
			  	beginFightButton.setVisible(true);
			  	beginFightButton.setBackground(Color.YELLOW);
			  	beginFightButton.addActionListener(this);
			  	add(beginFightButton);
			  	
			  	//Changing the the text to an appropriate message
		  		response.setText("<html><h1 color = 'orange'>Health Stats:<br>\"" + 
		 					 	 f1.getName() + "\" @ " + f1Health + "%<br>\"" + f2.getName() + "\" @ " + f2Health + "%" + "</h1><br> " + 
		 					  	 "<h1 color='green'>Congratulations: \"" + f1.getName() + "\", <br>You are the Winner!<br> " + 
		 					  	 "\"" + f2.getName() + "\" is now @ " + f2Health + "% health! Unlucky!</h1><br><br><h1 color='red'>GAME OVER</h1></html>");
		 		
		 		//Message dialog displaying the winner	
				JOptionPane.showMessageDialog(null,"\"" + f1.getName() + "\" is the winner!","Congratulations: " + f1.getName(),JOptionPane.INFORMATION_MESSAGE);
				
				//Setting all these JButtons to invisible since the fight is over
				f2PunchButton.setVisible(false);	
			 	f2KickButton.setVisible(false);
			   	f1PunchButton.setVisible(false);
			  	f1KickButton.setVisible(false);
			  	
			  	if(event.getSource() == beginFightButton){ //If the user click the button, re-start the fight
			  		beginFight();
			  	}
		} //End if (f2Health <= 0){...}	
		
	}//End of actionPerformed	
		   
}//End of class  