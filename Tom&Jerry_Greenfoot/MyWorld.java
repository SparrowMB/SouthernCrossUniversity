import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Md Bhuiayn)
 * @version (R7-8)
 * 8 January 2021
 */
public class MyWorld extends World
{
    private int score;
    private int time;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(600, 400, 1); 
        prepare();
        score = 0;
        time= 1500;
        showScore();
        showTime();
    }
    
    /**
     * 
     */
    public void act()
    {
        countTime();
    }
    /**
     * Add some points to our current score. (May be negative.)
     * If the score falls below 0, game's up.
     */
    public void addScore(int points)
    {
        score = score + points;
        showScore();
        if (score < 0) 
        {
            Greenfoot.playSound("Game_over.wav");
            Greenfoot.stop();
        }
    }
    
    /**
     * Show our current score on screen.
     */
    private void showScore()
    {
        showText("Score: " + score, 50, 25);
    }
    
     /**
     * Count down the game time and display it. Stop the game 
     * with a winning message when time is up.
     */
    private void countTime()
    {
        time--;
        showTime();
        if (time == 0)
        {
            showEndMessage();
            Greenfoot.stop();
        }
    }
    
    /**
     * Show the end-of-game message on screen.
     */
    private void showEndMessage()
    {
        showText("Time is up - you win!", 390, 150);
        showText("Your final score: " + score + " points", 390, 170);
    }
    
    /**
     * Show the remaining game time on screen.
     */
    private void showTime()
    {
        showText("Time: " + time, 530, 25);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
       addObject(new PlayerMouse(), getWidth()/2,getHeight()/2); 
        
       int i=0;
       while(i<10)
       {
            addObject(new FoodCheese(), 100+(i*40),40);
            i++;
       }
       
       int j=0;
       while(j<3)
       {
            addObject(new EnemyCat(), 20,100+(j*40));
            j++;
       }
       
       
    }
}
