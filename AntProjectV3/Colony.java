import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Colony here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Colony extends Actor
{
    /**
     * Act - do whatever the Colony wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected int energyNeeded= 50;
    protected int spawnEnergy=70;
    protected int antSpawnTime= 5000;
    MyWorld myWorld;
      SimpleTimer antSpawnTimer;
 public Colony(){
      
  antSpawnTimer= new SimpleTimer();

}
    public void act() 
    {
        if(spawnEnergy > energyNeeded){
        }
        if (antSpawnTimer.millisElapsed()> antSpawnTime){
                // tester++;
                Ant cAnt= new Ant();
                getWorld().addObject(cAnt, getX(),getY());
                antSpawnTimer.mark();
            }
       
}
 public int getSpawnEnergy(){
        return spawnEnergy;
        
    }
}
