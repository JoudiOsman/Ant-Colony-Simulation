import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AbstAnt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class AbstAnt extends Actor
{
   enum AntState{
       IDLE, HUNT, FEED, ATTACK, DEAD, TRACK, FOLLOW, FORAGE, RETURN
    }
    
    //Properties : what an ant has
    protected int speed =5;
    protected int size = 20;
    protected int sightRange =250;
    protected double energy = 100;//the amount of energy, if < 0, it starves
    protected double health =  10;//if < 0, it dies
    protected int attack = 5;
    protected int capacity = 100;//maximum an ant can carry
    protected int weight =20;//what the ant presently weighs
    AntState state = AntState.IDLE;
    //public static long tester ;
    /**
     * Act - do whatever the AbstAnt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turn(Greenfoot.getRandomNumber(60)-30);
        move(Greenfoot.getRandomNumber(8*(5)-2));  
        //System.out.println(tester);
    }    
    
    //Methods : what the ant does
    protected abstract void eat(double fillEnergy);
    
    protected abstract void attack();
    
    protected abstract void track();
    
    protected abstract void collectFood();
    
    protected abstract void leaveTrail();
    
}