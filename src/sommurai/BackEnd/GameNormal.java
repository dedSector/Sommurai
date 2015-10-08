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
public class GameNormal extends GameBase
{
    String display = "";
    String[] solution;
    
    /**
     * Constructeur sans paramètres
     */
    public GameNormal(){
        super();
        solution = new String[super.getCuts()];
        for(int cuts = 0; cuts < super.getCuts(); cuts++){
            display += Integer.toString(super.getAllNumbers()[cuts]);
            solution[cuts] = Integer.toString(super.getAllNumbers()[cuts]);
        }
    }
    
    /**
     * retourne la chaine qui représsente les nombres à afficher
     * @return string ou chaques caractères est un nombre à afficher
     */
    @Override
    public String getSumNumbers() {        
        return display;
    }

    /**
     * Vérifie la somme
     * @param inputs
     * @return si la somme entrée esst égale à la somme calulée
     */
    @Override
    public Boolean verifySum(int[] inputs) {
        int sumTry = 0;
        
        for(int singleNumber : inputs){
            sumTry += singleNumber;
        }
        
        return (sumTry == super.getSum());
    }

    /**
     * Retournne la solution
     * @return La solution de l'énigme
     */
    @Override
    public String[] getSolution() {
        //String
        return solution;
    }    
}
