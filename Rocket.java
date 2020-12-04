import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    public double time = 0;
    public boolean done = false;
    public int rocketX = 30;
    /**
     * Constructor
     */
    public Rocket() {
        
    }
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }    
    public void time(double x, int y)
    {
        //checks if the rocket is done with flight
        while (done == false) {
            //checks if the y position is below the ground  
            //System.out.println(getY());
            if (getY() <= 350) {
                //increments the time
                time += 0.1; 
                //runs the launch method with different parameters
                //String theta = Greenfoot.ask("Input rocket launch angle:");
                //String power = Greenfoot.ask("Input rocket launch power:");
                launch(time, x, y);
                //waits in between movements
                Greenfoot.delay(1);
            }
            else {
                //makes rocket done with flight
                done = true;
            }
        }
        MyWorld.addToScore();
    }
    public void launch(double time, double angle, double velocity)
    {
        //changing the angle into radians to make it easier for substitutions 
        double angleRad = angle * 3.14/180;
        //calculates x-position based on velocity, angle, and time
        double xPosition = (velocity * Math.cos(angleRad) * time);
        //calculates y-position based on velocity, angle, and time 
        double yPosition = (velocity * Math.sin(angleRad)* time) + (0.5 * -9.8 * Math.pow(time, 2));
        //calculates x-velocity of object
        double xVelocity = velocity * Math.cos(angleRad); 
        //calculates y-velocity of object 
        double yVelocity = (int)(velocity * Math.sin(angleRad) + (-9.8 * time));
        //uses the x and y velocity to calculate the angle that the rocket should turn 
        setRotation((int)(90.0-(Math.atan(yVelocity/xVelocity) * 180/3.14)));
        //sets the rocket location to the correct x and y position 
        setLocation​(30 + (int)xPosition, 350 - (int)yPosition);
        MyWorld.rocketX = (int) xPosition;
    }
}
