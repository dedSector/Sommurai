/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sommurai;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @author Bert
 */
class GameView extends JPanel{
    String[] sColors = new String[] { 
                                      "0X00FFFF", "0X7FFFD4", "0X89CFF0",
                                      "0XF4C2C2", "0X98777B", "0XFFBF00",
                                      "0XFBCEB1", "0XF0F8FF", "0X6495ED",
                                      "0X654321", "0X9BDDFF", "0XFBEC5D",
                                      "0XFF7F50", "0X00FFFF", "0X99BADD",
                                      "0XF0E130", "0XFFF8DC"
                                    };
    private Color[] colors;
    private int _WIDTH;
    private int firstclick;
    int sum;
    int colorClick = 0;
    ArrayList<Integer> _numbers = new ArrayList<>();
    ArrayList<ButtonPannel> buttonPannel;
    
    /**
     * Constructeur
     * @param numbers les chiffres à afficher
     */
    GameView(String numbers){
        setColor();
        buttonPannel = new ArrayList<>();
        
        for(Character c: numbers.toCharArray()){
            ButtonPannel bp = new ButtonPannel(c);
            buttonPannel.add(bp);
        }
        setLayout(new GridLayout(1, numbers.length()));
        setSize(2160, 540);
        for(ButtonPannel bp : buttonPannel){
            add(bp);
            bp.setBackground(Color.WHITE);
        }
        _WIDTH = this.getWidth();
        
        //ajouts des événements
        this.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                firstclick = ((int)(e.getX()* buttonPannel.size()) / _WIDTH);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int release = (int)((e.getX() * buttonPannel.size())/_WIDTH);
                //Si les cases cliquées sont inutilisées
                if(buttonPannel.get(firstclick).getBackground() == Color.WHITE && buttonPannel.get(release).getBackground() == Color.WHITE){
                    //Si plus qu'une case cliqueé
                    if(release - firstclick == 1){
                        buttonPannel.get(firstclick).setBackground(colors[colorClick]);
                        buttonPannel.get(release).setBackground(colors[colorClick]);
                        _numbers.add(Integer.parseInt(buttonPannel.get(firstclick).getNumber().toString() + buttonPannel.get(release).getNumber().toString()));
                        sum += Integer.parseInt(buttonPannel.get(firstclick).getNumber().toString() + buttonPannel.get(release).getNumber().toString());
                    } else {
                        buttonPannel.get(firstclick).setBackground(colors[colorClick]);
                        sum += Integer.parseInt(buttonPannel.get(firstclick).getNumber().toString());
                        _numbers.add(Integer.parseInt(buttonPannel.get(firstclick).getNumber().toString()));
                    }
                }
                colorClick++;
                firstclick = 0;
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    
    public Color getColors(int index){
        return colors[index];
    }
    
    /**
     * Set tous les couleurs.
     */
    private void setColor(){
        colors = new Color[sColors.length];
        for (int i=0; i<sColors.length; i++)
            colors[i] = Color.decode(sColors[i]);
    }
    
    /**
     * Crée tous les boutons
     * @param numbers la chaine de caractères avec tous les chiffres à afficher
     */
    public void setButtonPannel(String numbers){
        for(Character c : numbers.toCharArray()){
            ButtonPannel bp = new ButtonPannel(c);
            buttonPannel.add(bp);
            add(bp);
            bp.setBackground(Color.WHITE);
        }
    }
    
    /**
     * Retourne tous les ButtonPannels présents
     * @return le conteneur avec les coutons
     */
    public ArrayList<ButtonPannel> getButtonPannel(){
        return buttonPannel;
    }
    
    /**
     * Retourne la somme
     * @return int la somme calculée
     */
    public int getSum(){
        return sum;
    }
    
    /**
     * Remettre la somme à zéro
     */
    public void resetSum(){
        sum = 0;
        colorClick = 0;
        _numbers.clear();
    }
    
    public ArrayList<Integer> getSumNumbers(){
        return _numbers;
    }
    
    /**
     * Retourne le nombre de cliques utilisés
     * @return 
     */
    public int getColorClick(){
        return colorClick;
    }
}