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
public class GameNoize extends GameBase{
    
    private String display = "";
    private final String[] solution;
    
    /**
     * Constructeur sans paramètres
     */
    public GameNoize(){
        
        int rand = (int) (Math.random() * super.getCuts());
        int count = 0;
        
        solution = new String[super.getCuts() + 1];
        
        for(int num : super.getAllNumbers()){
            if(rand == count){
                display += Integer.toString(rand);
                solution[count] = Integer.toString(rand) + "M";
                count++;
            }
            solution[count] = Integer.toString(num);
            display += Integer.toString(num);
            count++;
        }
    }
    
    /**
     * Tous les caractères à montrer
     * @return une chaine représentant tous 
     */
    @Override
    public String getSumNumbers(){
        return display;
    }
    
    /**
     * Vérification de la somme
     * @param inputs tous les nombres à vérifier
     * @return si la somme entrée égale la somme à trouver
     */
    @Override
    public Boolean verifySum(int[] inputs) {
        int inputSum = 0;
        
        for(int singleNumber : inputs){
            inputSum += singleNumber;
        }
        
        return inputSum == super.getSum();
    }

    /**
     * Retourne la solution fait plus tôt. Il y aura un 'm' à coté du chiffre qui est l'intrus.
     * @return 
     */
    @Override
    public String[] getSolution() {
        return solution;
    }
}
