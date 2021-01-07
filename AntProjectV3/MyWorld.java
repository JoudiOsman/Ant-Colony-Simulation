import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Ant ant;
    Food food;
    int numAnts = Greenfoot.getRandomNumber(8);
    int numFood = 5;
    SimpleTimer antSpawnTimer;
    protected int antSpawnTime= 4500;
    Colony colony;
    Colony colony1;
    public int tester = 1;
    protected int cSize =40;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 750, 1); 
        colony = new Colony();
        addObject(colony,Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        // antSpawnTimer= new SimpleTimer();
        colony.getImage().scale((int)cSize,(int)cSize);
        for (int i = 0; i < numAnts; i++){
            ant = new Ant();
            addObject(ant, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        for (int i = 0; i< numFood; i ++){
            food = new Food();
            addObject(food, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));

        }
    }

    public void act(){
        //System.out.println(tester);

        /** List<Colony> colonys = getObjects(Colony.class);
        if(colonys.size()>0){
        colony1 = colonys.get(0);
        }
        if(colony1.getSpawnEnergy()>50){
        if (antSpawnTimer.millisElapsed()> antSpawnTime){
        // tester++;
        Ant cAnt= new Ant();
        addObject(cAnt, colony1.getX(),colony1.getY());
        antSpawnTimer.mark();
        }
        }*/
    }
}
