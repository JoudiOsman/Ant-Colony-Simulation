 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Ant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ant extends AbstAnt
{
    Ant target;//stores the reference to the ant instance we want to attack
    Ant help;

  int hearRange = 600;
 int helpState=1;
   Food food;
    /**
     * Act - do whatever the Ant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() {
     StateShift();   
    }
    public void StateShift() 
    {
        
        if (state == AntState.IDLE){
            super.act();
            checkHelp();
            helpState=1;
            //look for an ant to attack
            List<Ant> targets = getObjectsInRange(sightRange, Ant.class);
            if (targets.size()>0){//if the list is not empty
                target = targets.get(0);
                state = AntState.ATTACK;
            }
            List<Food> food2 = getObjectsInRange (sightRange, Food.class);
            if(targets.size() ==0){
             if(food2.size()>0){
                food = food2.get(0);
                state = AntState.FEED;
            }
                
        }
        }
        else if (state == AntState.ATTACK){
            if (target.getWorld() == null){
               target = null;
               state = AntState.IDLE;
            }
            //if touching the target
            else if (isTouching(Ant.class)){
                //calculate the damage done in the attack
                double damage = Greenfoot.getRandomNumber(attack);
                //call the target's takeDamage method
                target.takeDamage(damage);
                helpState=2;
            }
            else{
                //turn toward ant ==> turntowards

                
                    turnTowards(target.getX(), target.getY());
                    //move the ant
                    move(speed);
               
            }
        }
        else if (state == AntState.FEED){
            if (health <= 0){
            //change it to dead
            state = AntState.DEAD;
        }
            if(food.getWorld()==null){
                food= null;
                state = AntState.IDLE;
            }
            else if(isTouching(Food.class)){
                food.giveEnergy(energy);
            }
            else{
                turnTowards (food.getX(), food.getY());
                move(speed);
            }
        }
       
        else if(state == AntState.DEAD){
            getWorld().removeObject(this);
        }

    } 

    //Methods : what the ant does
    protected void eat(double fillEnergy){
energy += fillEnergy;
    }
    public int getHelpState(){
        return helpState;
        
    }
    protected void checkHelp(){
        
         List<Ant> helpNeeded = getObjectsInRange(hearRange, Ant.class);
         
         if(helpNeeded.size()>0){
            for(int i =0; i< helpNeeded.size();i++){
                help = helpNeeded.get(i);
                if (help.getHelpState() == 2){
                int helpsX = help.getX();
                int helpsY= help.getY(); 
                turnTowards(helpsX,helpsY);
                move(speed);
                 // tester++;
                if (getX()>= helpsX){
                     super.act();
                     
                }
            }
        }
            }
        
    }
    
  public void eats(double fillEnergy){
    eat(fillEnergy);
    }
    protected void attack(){
    }

    protected void track(){

    }

    protected void collectFood(){

    }

    protected void leaveTrail(){

    }

    public void takeDamage(double damage){
        //remove the damage from the health
        
        health-= damage;
        //if all the health is gone 
        if (health <= 0){
            //change it to dead
            state = AntState.DEAD;
        }
    }

}
