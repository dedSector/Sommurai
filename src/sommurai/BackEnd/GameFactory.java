/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sommurai.BackEnd;

/**
 * contruit une partie sselon le la string passée
 * @author Bert
 */
public class GameFactory {
    public GameBase getGame(String GameType){
        GameBase gb;
        switch(GameType){
            case "Normal":
                gb = new GameNormal();
                break;
            case "Noize":
                gb = new GameNoize();
                break;
            case "Mean":
                gb = new GameMean();
                break;
            case "All":
                gb = new GameAll();
                break;
            default:
                gb = null;
                break;
        }
        return gb;
    }
}
