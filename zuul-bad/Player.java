import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author  Md Saiful Islam Bhuiyan
 * @version (1.0) 2021.05.24
 */
public class Player
{
    private List <Item> itemList;
    private String name;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        itemList = new <Item>ArrayList();
    }
    
    /**
     * 
     */
    public void setName(String name)
    {
        this.name=name;
    }
    
    /**
     * removing items
     */
    public void removeItem(Item item)
    {
       this.itemList.remove(item);
    }
    
    /**
     * adding items
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
       for (Item i:this.itemList)
       {
         if(i.getItemName().equalsIgnoreCase(name))
           {
             return i;
           }  
       }
       return null;
    }
    
    /**
     * listing items
     */
    public String listItem()
    {
         String itemList="";
           for (Item i:this.itemList)
         {
           itemList+=" "+i.getItemName();
         }
         return itemList;
    }
    
    /**
     * checking if the room has key
     */
    public boolean hasRoomKey(Room room)
    {
        for (Item i:this.itemList)
        {
           if(room.getRoomName().equalsIgnoreCase(i.getBelngedRoomName()))
           {
            return true;
           }
        }
        return false;
    }
}
