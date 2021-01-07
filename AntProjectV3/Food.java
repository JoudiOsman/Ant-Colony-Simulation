import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends AFood
{
    protected int fillEnergy= 20;
    Ant eaterAnt;
    int cState =1;
    int i = 2;
    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(fillEnergy<=0){
            getWorld().removeObject(this);
            
        }
        
        if (cState==1){

            List<Ant> eaterAnts = getObjectsInRange(200,Ant.class);
            if(eaterAnts.size()>0){
                eaterAnt= eaterAnts.get(0);
                cState=2;
            }
        }
        else if (cState==2){
            if(eaterAnt.getWorld()== null){
                eaterAnt= null; 
                cState=1;
            }
            else  if(isTouching (Ant.class)){
                
                double fillEnergy= 20;
                eaterAnt.eats(fillEnergy);
                fillEnergy -=20;
                 getWorld().removeObject(this);

            }
        }    
        // if(eaterAnt== null){
        //           eaterAnt= null; 
        //        cState=1;
        // }
    }

    public void giveEnergy(double energy){
  
    }
}