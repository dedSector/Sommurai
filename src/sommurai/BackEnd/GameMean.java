/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sommurai.BackEnd;

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
    public Boolean verifySum(int[] inputs){
        int inputSum = 0;
        for(int singleNumber : inputs){
            inputSum += singleNumber;
        }
        
        return (inputSum/super.getCuts()) == (super.getSum() / super.getCuts());
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
