import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    public static int targetX = 0;
    public static int score = 0;
    public static int rocketX;
    public static int cntr=0;

    public Button() {
        //sets the image as the launch button
        setImage("launch-button.png");
    }
    
        public double launch(double time, double angle, double velocity)
    {
        //calculates x-position based on velocity, angle, and time
        double xPosition = (velocity * Math.cos(angle) * time);
        return xPosition;
    }
            
    public void updateScore() {
        //showText("Score: " + score, 500, 30);
    }
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
   
        //checks if button is pressed
        if(Greenfoot.mouseClicked(this))
            {
                do{
                String theta = Greenfoot.ask("Input rocket launch angle:");
                String power = Greenfoot.ask("Input rocket launch power:");
                double theta3 = Integer.parseInt(theta);
                int power3 = Integer.parseInt(power);
    
                double theta2 = Integer.parseInt(theta) * 3.14/180;
                int power2 = Integer.parseInt(power);
                double time = 2 * power2 * (Math.sin(theta2)) / 9.8;
                double actualDistance = launch(time, theta2, power2);
            
                getWorld().showText("Actual Distance: " + actualDistance, 370, 60);
                getWorld().showText("Time: " + time + " seconds", 358, 90);
                //creates a new rocket
                //getWorld().addObject(target,rand, 350);
                Rocket rocket = new Rocket();
                //adds the rocket to the world
                getWorld().addObject(rocket, 30, 350);
                //starts the rocket time and launch
    
                rocket.time(theta3,power3);
                ++cntr;
                //System.out.println(cntr);
            }while(cntr <5);
            cntr =0;
            Greenfoot.stop();
                //System.out.println("Coming here");
        }
    }    
}
