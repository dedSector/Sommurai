/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sommurai.BackEnd;

import java.util.ArrayList;

/**
 * Partie avec la moyenne
 * @author Bert
 */
public class GameMean extends GameBase{
    
    String display = "";
    String[] solution;
    
    /**
     * consstructeur sans paramêtres
     */
    public GameMean(){
        super();
        solution = new String[super.getCuts()];
        for(int cuts = 0; cuts < super.getCuts(); cuts++){
            display += Integer.toString(super.getAllNumbers()[cuts]);
            solution[cuts] = Integer.toString(super.getAllNumbers()[cuts]);
        }
        
        if(super.getSum() % super.getCuts() != 0){
            int max = super.getSum() % super.getCuts();
            display = "";
            super.sum = 0;
            boolean changed = true;
            for(int i=0; i<super.getCuts(); i++){
                System.out.println(super.getAllNumbers()[i]);
                if(super.getAllNumbers()[i] > max && changed){
                    super.getAllNumbers()[i] = super.getAllNumbers()[i] - max;
                    solution[i] = Integer.toString(super.getAllNumbers()[i]);
                    display += Integer.toString(super.getAllNumbers()[i]);
                    changed = false;
                } else{
                    solution[i] = Integer.toString(super.getAllNumbers()[i]);
                    display += Integer.toString(super.getAllNumbers()[i]);
                }
                sum += super.getAllNumbers()[i];
            }
        }
    }
    
    /**
     * retourne les numéros à afficher
     * @return la chaine de caractère ou chaques caractères sont un numéros à afficher
     */
    @Override
    public String getSumNumbers() {
        return display;
    }

    /**
     * Retourne la somme 
     * @return la somme à atteindre
     */
    @Override
    public int getSum(){
        return sum/super.getCuts();
    }
    
    /**
     * Vérifier la somme
     * @param inputs
     * @return si la somme entrée est égale à la somme calculée
     */
    @Override
    public Boolean verifySum(ArrayList<Integer> inputs){
        if(inputs.size() != super.getCuts()){
            return false;
        }
        
        int inputSum = 0;
        
        
        for(int singleNumber : inputs){
            inputSum += singleNumber;
        }
        
        return (inputSum/super.getCuts()) == (super.getSum() / super.getCuts()) && (inputSum % super.getCuts()) == (super.getSum() % super.getCuts());
    }

    /**
     * La ssoolution
     * @return 
     */
    @Override
    public String[] getSolution() {
        return solution;
    }
}
