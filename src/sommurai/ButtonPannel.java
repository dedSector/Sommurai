/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sommurai;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Le pannel qui affiche un chiffre
 * @author Bert
 */
public class ButtonPannel extends JPanel{
    private final Character _number;
    
    /**
     * Privatiser le constructeur sans paramètres
     */
    private ButtonPannel(){
        _number = null;
    }
    
    /**
     * Constructeur ave un seul paramètre
     * @param number à afficher
     */
    ButtonPannel(Character number){
        _number = number;
        this.setSize(300, 300);
        JLabel label = new JLabel(number.toString(), JLabel.LEFT);
        setLayout(new GridBagLayout());
        label.setSize(300, 300);
        label.setFont(new Font("Arial", 60, 64));
        add(label);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
    /**
     * Retourne le nombre affiché
     * @return nombre à afficher
     */
    public Character getNumber(){
        return _number;
    }
}
