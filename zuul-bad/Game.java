/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Md Saiful Islam Bhuiyan
 * @version (1.0) 2021.05.24
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Player player; 
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside,resturant, theater, pub, computerlab, helpdesk, deanoffice, studentcenter, toilet, gymhall,lecturehall1,lecturehall2,lecturehall3;
        Item theaterkey,pubkey,resturantkey,computerlabkey,helpdeskkey,goldenkey,studentcenterkey,toiletkey,gymhallkey,lecturinghall1key,lecturinghall2key,lecturinghall3key; 
       
        // create the rooms
        outside = new Room("outside","outside the main entrance of the university");
        theater = new Room("theater","in a lecture theater");
        pub = new Room("pub","in the campus pub");
        resturant= new Room("resturant","in the resturant");
        computerlab = new Room("computing lab","in a computing lab");
        helpdesk = new Room("helpDesk","in the helpDesk");
        deanoffice = new Room("deanOffice","in the deanOffice");
        studentcenter = new Room("studentCenter","in the studentCenter");
        toilet = new Room("toilet","in the toilet");
        gymhall = new Room("gymHall","in the gymHall ");
        lecturehall1 = new Room("lectureHall1","in the lectureHall1 ");
        lecturehall2 = new Room("lectureHall2","in the lectureHall2 ");
        lecturehall3 = new Room("lectureHall1","in the lectureHall3 ");
        
        // initialising the items
        theaterkey = new Item("theaterkey");
        theaterkey.setBelngedRoom(theater);
        
        pubkey = new Item("pubKey");
        pubkey.setBelngedRoom(pub);
        
        resturantkey = new Item("resturantKey");
        resturantkey.setBelngedRoom(resturant);
        
        computerlabkey = new Item("computerLabKey");
        computerlabkey.setBelngedRoom(computerlab);
        
        helpdeskkey = new Item("helpDeskKey");
        helpdeskkey.setBelngedRoom(helpdesk);
        
        goldenkey = new Item("goldenKey");
        goldenkey.setBelngedRoom(deanoffice);
        
        studentcenterkey = new Item("studentCenterKey");
        studentcenterkey.setBelngedRoom(studentcenter);
        
        toiletkey = new Item("toiletKey");
        toiletkey.setBelngedRoom(toilet);
        
        gymhallkey = new Item("gymHallKey");
        gymhallkey.setBelngedRoom(gymhall);
        
        lecturinghall1key = new Item("lecturingHall1Key");
        lecturinghall1key.setBelngedRoom(lecturehall1);
        
        lecturinghall2key = new Item("lecturingHall2Key");
        lecturinghall2key.setBelngedRoom(lecturehall2);
        
        lecturinghall3key = new Item("lecturingHall3Key");
        lecturinghall3key.setBelngedRoom(lecturehall3);
        
        // initialise room exits
        outside.setExits(helpdesk, null, null, null,studentcenter, null, null, outside);
        helpdesk.setExits(null, studentcenter, outside, toilet,lecturehall3, null, null, null);
        studentcenter.setExits(null, null, null, helpdesk,null, null, outside, null);
        toilet.setExits(gymhall, studentcenter, null, null,lecturehall2, null, null, null);
        lecturehall1.setExits(null, null, null, null,gymhall, null, null, null);
        lecturehall2.setExits(resturant, null, null, null,null, null, toilet, null);
        lecturehall3.setExits(null, computerlab, null, null,pub, null, helpdesk, null);
        
        // Add items to rooms
        outside.addItem(helpdeskkey);
        helpdesk.addItem(lecturinghall3key);
        lecturehall3.addItem(goldenkey);
        toilet.addItem(lecturinghall2key);
        toilet.addItem(lecturinghall1key);
        lecturehall1.addItem(gymhallkey);
        gymhall.addItem(resturantkey);
        resturant.addItem(theaterkey);
        theater.addItem(pubkey);
        pub.addItem(computerlabkey);   
        player = new Player();
        
        // start game outside
        currentRoom = outside;  
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.      
        boolean finished = false;
        while (!finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        getRoomExitsAndDescription();
    }
 
    /**
     * 
     */
    private void getRoomExitsAndDescription()
    {
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        if(currentRoom.northExit != null) 
        {
            System.out.print("North ");
        }
        if(currentRoom.eastExit != null) 
        {
            System.out.print("East ");
        }
        if(currentRoom.southExit != null) 
        {
            System.out.print("South ");
        }
        if(currentRoom.westExit != null) 
        {
            System.out.print("West ");
        }
        if(currentRoom.northeastExit != null) 
        {
            System.out.print("North East");
        }
        if(currentRoom.southeastExit != null) 
        {
            System.out.print("South East ");
        }
        if(currentRoom.southwestExit != null) 
        {
            System.out.print("South West");
        }
        if(currentRoom.northwestExit != null) 
        {
            System.out.print("North west ");
        }
        System.out.println();
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        if(command.isUnknown()) 
        {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) 
        {
            printHelp();
        }
        else if (commandWord.equals("go")) 
        {
            goRoom(command);
        }
        else if (commandWord.equals("take")) 
        {
            takeItem(command);
        }
        
        else if (commandWord.equals("drop")) 
        {
            dropItem(command);
        }
        
        else if (commandWord.equals("inventory")) 
        {
            listRoomItem(command);
        }
        
         else if (commandWord.equals("bag")) 
         {
            listPlayerItem(command);
        }
        
        else if (commandWord.equals("quit")) 
        {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("  go , take , drop , inventory , bag , quit , help");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        // Try to leave current room.
        Room nextRoom = null;
        if(direction.equals("north")) 
        {
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals("east")) 
        {
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals("west")) 
        {   
            nextRoom = currentRoom.westExit;
        }
        if(direction.equals("northeast")) 
        {
            nextRoom = currentRoom.northeastExit;
        }
        if(direction.equals("southeast")) 
        {
            nextRoom = currentRoom.southeastExit;
        }
        if(direction.equals("southwest")) 
        {
            nextRoom = currentRoom.southwestExit;
        }
        if(direction.equals("northwest")) 
        {   
            nextRoom = currentRoom.northwestExit;
        }
        
        if (nextRoom == null) 
        {
            System.out.println("There is no door!");
        }
        else if(!player.hasRoomKey(nextRoom))
        {
               System.out.println("You didn't pickup the key to open this room!");
        }
        else {
            currentRoom = nextRoom;
            if(currentRoom.getRoomName().equalsIgnoreCase("deanOffice"))
            {
            System.out.println("You won you reached Dean Office !!!!");
            }
            getRoomExitsAndDescription();
        }
    }

    /**
     * 
     */
     private boolean listRoomItem(Command command) 
    {
        System.out.println("The Room Items are:");
        String listItems=currentRoom.listCurrentItems();
        System.out.println(listItems);
        
        return true;
    }
    
     /**
     * 
     */
    private void takeItem(Command command)
    {
        if(!command.hasSecondWord())
        {
            System.out.println("Take what?");
            return;
        }
        
        String item = command.getSecondWord();
        Item itemObject=currentRoom.getItemByName(item);
        
        if (itemObject ==null)
        {
            System.out.println("No such Item");
        }
        else
        {
            currentRoom.removeItem(itemObject);
            player.addItem(itemObject);
        }
    }

    /**
     * 
     */   
    private void dropItem(Command command)
    {
        if(!command.hasSecondWord())
        {
            System.out.println("Drop what?");
            return;
        }
        
        String itemName = command.getSecondWord();
        Item itemObject=player.getItemByName(itemName);
        
        if (itemObject ==null)
        {
            System.out.println("No such Item");
        }
        else
        {
            currentRoom.addItem(itemObject);
            player.removeItem(itemObject);
        }
    }
        
    /**
     * 
     */
    private void listPlayerItem(Command command)
    {
        String output =" ";
     
         output=player.listItem();
    
        System.out.println("You are currently carrying: "+output);
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) 
        {
            System.out.println("Quit what?");
            return false;
        }
        else 
        {
            return true;  // signal that we want to quit
        }
    }
}
