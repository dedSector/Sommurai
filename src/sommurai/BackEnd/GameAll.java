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
public class GameAll extends GameBase{
    
    private String display = "";
    private final String[] solution;
    
    /**
     * Construccteur normal
     */
    GameAll(){
        super();
        solution = new String[super.getCuts() + 1];
        int rand = (int) (Math.random() * super.getCuts());
        int count = 0;
        for(int num : super.getAllNumbers()){
            if(rand == count){
                display += Integer.toString(rand);
                solution[count] = Integer.toString(rand) + "M";
                count++;
            }
            display += Integer.toString(num);
            solution[count] = Integer.toString(num);
            count++;
        }
    }

    /**
     * Retourne les numéros à afficher
     * @return Numéros à afficher
     */
    @Override
    public String getSumNumbers() {
        return display;
    }

    /**
     * Retourne la solution
     * @return la solution 
     */
    @Override
    public String[] getSolution() {
        return solution;
    }

    /**
     * Vérifie la somme des chiffres choisis
     * @param inputs 
     * @return la solution
     */
    @Override
    public Boolean verifySum(int[] inputs) {
        int newSum = 0;
        
        for(int i:inputs){
            newSum += i;
        }
        
        return newSum / super.getCuts() == super.getSum() / super.getCuts();
    }
    
    /**
     * retourne la somme
     * @return la somme
     */
    @Override
    public int getSum(){
        int newSum = 0;
        super.getAllNumbers();
        for(int c: super.getAllNumbers()){
            newSum += c;
        }
        
        return newSum / super.getCuts();
    }
}
