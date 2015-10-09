/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sommurai.BackEnd;

import java.util.ArrayList;

/**
 * les fonctions à implémenter afin de faire une partie
 * @author Bert
 */
public interface GameInterface {
    String getSumNumbers();
    String[] getSolution();
    Boolean verifySum(ArrayList<Integer> inputs);
}
