/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sommurai.BackEnd;

/**
 *
 * @author Bert
 */
public abstract class GameBase implements GameInterface{
    
    private int nbCuts;
    protected int sum;
    protected int[] allNumbers;
    
    /**
     * Base Constructor
     */
    GameBase(){
        nbCuts = (int) (Math.random() *3  + 3);
        allNumbers = new int[nbCuts];
        for(int cuts=0; cuts < nbCuts; cuts++){
            double prob = Math.random();
            int singleNumber;
            
            if(prob < 0.7){
                singleNumber = (int) (Math.random() * 8 + 1);          
            }else{
                singleNumber = (int) (Math.random() * 90 + 9);          
            }
            
            allNumbers[cuts] = singleNumber;
            sum += singleNumber;
        }
    }
    
    /**
     * return the number of cuts
     * @return 
     */
    public final int getCuts(){
        return nbCuts;
    }
    
    /**
     * Getteur de somme
     * @return the sum of all the numbers
     */
    public int getSum(){
        return sum;
    }
    
    /**
     * 
     * @return un tableau avec tous les nombres addtionnés
     */
    protected final int[] getAllNumbers(){
        return allNumbers;
    }
}
