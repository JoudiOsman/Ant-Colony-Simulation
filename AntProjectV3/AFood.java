import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class AFood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AFood extends Actor
{
    /**
     * Act - do whatever the AFood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         List<Ant> eaterAnts = getObjectsInRange(200,Ant.class);
    }    
}
