import java.util.List;
import java.util.ArrayList;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Md Saiful Islam Bhuiyan
 * @version (1.0) 2021.05.24
 */
public class Room 
{
    public String description;
    public String name;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;
    
    public Room northeastExit;
    public Room southeastExit;
    public Room southwestExit;
    public Room northwestExit;

    private List <Item> itemList = new <Item>ArrayList();
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String name,String description) 
    {
        this.name=name;
        this.description = description;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west,Room northeast,Room southeast,Room southwest, Room northwest) 
    {
        if(north != null) 
        {
            northExit = north;
        }
        if(east != null) 
        {
            eastExit = east;
        }
        if(south != null) 
        {
            southExit = south;
        }
        if(west != null) 
        {
            westExit = west;
        }
        
        if(northeast != null) 
        {
            northeastExit = northeast;
        }
        if(southeast != null) 
        {
            southeastExit = southeast;
        }
        if(southwest != null) 
        {
            southwestExit = southwest;
        }
        if(northwest != null) 
        {
            northwestExit = northwest;
        }
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
     
    /**
     * @return The Short description of the room.
     */
    public String getShortDescription()
    {
        return description;
    }
    
    /**
     * @return The long description of the room.
     */
    public String getLongDescription()
    {
        return "You are " +description + ".\n" + getExitString();
    }
    
    /**
     * 
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        return returnString;
    }

    /**
     * 
     */
        public String listCurrentItems()
    {
        String list="";
        for( Item i : this.itemList)
        {
          list+=" "+i.getItemName();
        }
        return list;
    }
    
    /**
     * 
     */
    public void removeItem(Item item)
    {
    this.itemList.remove(item);
    }
    
    /**
     * 
     */
    public void addItem(Item item)
    {
    this.itemList.add(item);
    }
    
    /**
     * 
     */
    public Item getItemByName(String name)
    {
    
        for( Item i : this.itemList)
        {
        if (i.getItemName().equalsIgnoreCase(name))
        {
            return i;
        }
        }
        return null;
      }
    
    /**
     * 
     */
    public String getRoomName()
    {
        return this.name;
    }
      
}
