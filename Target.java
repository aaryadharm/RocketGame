import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Target extends Actor
{
    public double time = 0;
    /**
     * Constructor
     */
    public Target() {
        GreenfootImage image = new GreenfootImage("target.jpg");
        image.scale(image.getWidth() - 550, image.getHeight() - 550);
        setImage(image);
    }
}
