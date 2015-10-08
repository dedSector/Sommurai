/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sommurai;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe représentant le panneau de contrôle du bas
 * @author Bert
 */
public class GameControlPanel extends JPanel{
    private final JPanel panel;
    private final JButton btnNext;
    private final JButton btnSolution;
    private final JButton btnReset;
    private final JCheckBox chkMean;
    private final JCheckBox chkNoise;
    private final JLabel lblObjective;
    private final JLabel lblSomme;
    
    /**
     * Constructeur sans paramètres
     */
    GameControlPanel(){
        setLayout(new GridLayout(0,2));
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(7,0));
        btnNext = new JButton("Next");
        btnSolution = new JButton("Solution");
        btnReset = new JButton("Reset");
        chkMean = new JCheckBox("Find Mean");
        chkNoise = new JCheckBox("Noize");
        lblObjective = new JLabel();
        lblSomme = new JLabel();
        
        panel.add(lblSomme);
        panel.add(lblObjective);
        panel.add(btnNext);
        panel.add(btnSolution);
        panel.add(btnReset);
        panel.add(chkMean);
        panel.add(chkNoise);
        add(panel);
    }

    /**
     * @return the panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * @return the btnNext
     */
    public JButton getBtnNext() {
        return btnNext;
    }

    /**
     * @return the btnSolution
     */
    public JButton getBtnSolution() {
        return btnSolution;
    }

    /**
     * @return the btnReset
     */
    public JButton getBtnReset() {
        return btnReset;
    }

    /**
     * @return the chkMean
     */
    public JCheckBox getChkMean() {
        return chkMean;
    }

    /**
     * @return the chkNoise
     */
    public JCheckBox getChkNoise() {
        return chkNoise;
    }

    /**
     * @return the lblObjective
     */
    public JLabel getLblObjective() {
        return lblObjective;
    }

    /**
     * @return the lblSomme
     */
    public JLabel getLblSomme() {
        return lblSomme;
    }
    
}