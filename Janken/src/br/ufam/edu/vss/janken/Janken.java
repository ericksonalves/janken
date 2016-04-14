package br.ufam.edu.vss.janken;

import br.ufam.edu.vss.janken.controller.Controller;
import br.ufam.edu.vss.janken.listener.RestartGameListener;
import br.ufam.edu.vss.janken.listener.WaitingForResultListener;
import br.ufam.edu.vss.janken.model.Player;
import br.ufam.edu.vss.janken.model.PlayerId;
import br.ufam.edu.vss.janken.model.Result;
import br.ufam.edu.vss.janken.model.Rule;
import br.ufam.edu.vss.janken.util.GUIConstants;
import br.ufam.edu.vss.janken.view.GUI;

public class Janken implements RestartGameListener, WaitingForResultListener {

    private int playersWaitingForResult;
    private int playersWaitingForRestart;
    private GUI playerOneGUI;
    private GUI playerTwoGUI;

    private void showGUI() {
        playerOneGUI = new GUI(new Player(PlayerId.ONE, GUIConstants.PLAYER_ONE_TEXT));
        playerTwoGUI = new GUI(new Player(PlayerId.TWO, GUIConstants.PLAYER_TWO_TEXT));
        playerOneGUI.setListeners(this, this);
        playerTwoGUI.setListeners(this, this);
        playersWaitingForResult = 2;
        playersWaitingForRestart = 2;
        playerOneGUI.show();
        playerTwoGUI.show();
    }

    public void play() {
        Controller.getInstance().init();
        showGUI();
    }

    @Override
    public void onWaiting() {
        playersWaitingForResult--;
        if (playersWaitingForResult == 0) {
            Result result = Controller.getInstance()
                    .getResult(new Rule(playerOneGUI.getPlayer().getShape(), playerTwoGUI.getPlayer().getShape()));
            playerOneGUI.showResultStep(result);
            playerTwoGUI.showResultStep(Controller.getInstance().getOppositeResult(result));
        }
    }

    @Override
    public void onRestart() {
        playersWaitingForRestart--;
        if (playersWaitingForRestart == 0) {
            playerOneGUI.dispose();
            playerTwoGUI.dispose();
            showGUI();
        }
    }
}
