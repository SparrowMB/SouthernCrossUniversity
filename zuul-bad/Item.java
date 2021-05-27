
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String name;
    private Room belongedRoom;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name)
    {
      this.name=name;
    }

    
      /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setItemName(String name)
    {
        // put your code here
        this.name=name;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getItemName()
    {
        // put your code here
        return name;
    }
    
    public void setBelngedRoom(Room room){
    this.belongedRoom=room;
    }
    
    public String getBelngedRoomName(){
    return this.belongedRoom.getRoomName();
    }
}
