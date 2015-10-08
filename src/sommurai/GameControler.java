/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sommurai;

import java.awt.Color;
import java.awt.Component;
import sommurai.BackEnd.GameBase;

/**
 * Classe gérant les 
 * @author Bert
 */
public final class GameControler {

    /**
     * créer une nouvelle partie
     * @param view
     * @param controlPanel
     * @param base
     */
    public void getNewGame(GameView view,GameControlPanel controlPanel, GameBase base){
        Component[] pannels = view.getComponents();
        for(Component comp: pannels){
            view.remove(comp);
            view.buttonPannel.remove((ButtonPannel)comp);
        }
        controlPanel.getLblSomme().setText("0 (0)");
        controlPanel.getLblObjective().setText(Integer.toString(base.getSum()));

        view.setButtonPannel(base.getSumNumbers());
        view.revalidate();
        view.resetSum();
    }
    
    /**
     * affiche la solution
     * @param view
     * @param controlPanel
     * @param base
     */
    public void getSolution(GameView view, GameControlPanel controlPanel, GameBase base){
        Component[] comp = view.getComponents();
        int count = 0;
        for(Component c : comp){
            view.remove(c);
            view.buttonPannel.remove((ButtonPannel)c);
        }
        controlPanel.getLblSomme().setText("0");
        controlPanel.getLblObjective().setText(Integer.toString(base.getSum()));
        for(String s : base.getSolution()){
            if(s.length() > 1 && s.charAt(1) == 'M'){
                ButtonPannel b = new ButtonPannel(s.charAt(0));
                b.setBackground(Color.BLACK);
                view.add(b);
            } else{
                for(Character c : s.toCharArray()){
                    ButtonPannel b = new ButtonPannel(c);
                    b.setBackground(view.getColors(count));
                    view.add(b);
                }
            }
            count++;
        }
        controlPanel.getLblSomme().setText(controlPanel.getLblObjective().getText());
        view.revalidate();
    }
    
    /**
     * Permet de rejouer une partie
     * @param view
     * @param controlPanel
     * @param base 
     */
    public void resetGame(GameView view, GameControlPanel controlPanel, GameBase base){
        Component[] comp = view.getComponents();
        for(Component c : comp){
            c.setBackground(Color.WHITE);
        }
        view.resetSum();
        controlPanel.getLblSomme().setText("0");
        controlPanel.getLblObjective().setText(Integer.toString(base.getSum()));
        view.revalidate();
    }
}
