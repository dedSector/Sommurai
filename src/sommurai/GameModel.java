/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sommurai;
import sommurai.BackEnd.*;

/**
 *
 * @author Bert
 */
class GameModel
{
     GameFactory gameFactory;
    GameModel(){
        gameFactory = new GameFactory();
    }

    /**
     * @return la partie à jouer
     */
    public GameBase getGame(Boolean mean, Boolean noize) {
        String gameType;
        //System.out.println(mean + " " + noize);
        if(mean && !noize){
            gameType = "Mean";
        } else if (!mean && noize){
            gameType = "Noize";
        } else if (mean && noize){
            gameType = "All";
        } else{
            gameType = "Normal";
        }
        return gameFactory.getGame(gameType);
    }
}
