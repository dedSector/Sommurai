/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sommurai;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import sommurai.BackEnd.GameBase;

/**
 * Remise par email : LOG100A2015GR1@GMAIL.COM
 * @author Bert
 */
public class GameFrame extends JFrame
{
    GameModel gm;
    GameView gv;
    GameControlPanel gcp;
    GameBase gb;
    GameControler controler;
    
    public GameFrame(){
        gm = new GameModel();
        gcp = new GameControlPanel();
        gb = gm.getGame(false, false);
        gv = new GameView(gb.getSumNumbers());
        controler = new GameControler();
        
        initUI();
        
        this.add(gv);
        this.add(gcp);
        gcp.getLblSomme().setText("0 (0)");
        gcp.getLblObjective().setText(Integer.toString(gb.getSum()));
        
        gcp.getBtnNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gb = gm.getGame(gcp.getChkMean().isSelected(), gcp.getChkNoise().isSelected());
                controler.getNewGame(gv, gcp, gb);
            }
        });
        
        gcp.getBtnReset().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                controler.resetGame(gv, gcp, gb);
            }
            
        });
        
        gcp.getBtnSolution().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.getSolution(gv, gcp, gb);
            }
        });
        
        gv.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {
                gcp.getLblSomme().setText(Integer.toString(gv.getSum()) + "(" + Integer.toString(gv.getColorClick()) + ")");
                Component[] comps = gv.getComponents();
                if(!gcp.getChkMean().isSelected() && gv.getSum() == gb.getSum()){
                    for(Component c : comps){
                        c.setBackground(Color.green);
                    }
                } else if(!gcp.getChkMean().isSelected() && (gv.getSum() > gb.getSum() || gv.getColorClick() >= gb.getCuts())){
                    for(Component c : comps){
                        c.setBackground(Color.red);
                    }
                } else if(gcp.getChkMean().isSelected() && (gv.getColorClick() >= gb.getCuts()) && (gv.getSum() / gv.getColorClick() != gb.getSum())){
                    for(Component c : comps){
                        c.setBackground(Color.red);
                    }
                }
                else if(gcp.getChkMean().isSelected() && (gv.getColorClick() >= gb.getCuts()) && (gv.getSum() / gv.getColorClick() == gb.getSum()) ){
                    for(Component c : comps){
                        c.setBackground(Color.green);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    
    /**
     * Initialisation de l'interface graphique
     */
    private void initUI(){
        setTitle("Sommurai");
        setSize(2160, 1080);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /**
     * Programme Principal
     * @param args 
     */
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                GameFrame game = new GameFrame();
                game.setVisible(true);
            }
        });        
    }
}