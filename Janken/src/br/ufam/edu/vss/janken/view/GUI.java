package br.ufam.edu.vss.janken.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.ufam.edu.vss.janken.listener.RestartGameListener;
import br.ufam.edu.vss.janken.listener.RestartLabelListener;
import br.ufam.edu.vss.janken.listener.ShapeLabelListener;
import br.ufam.edu.vss.janken.listener.WaitingForResultListener;
import br.ufam.edu.vss.janken.model.Player;
import br.ufam.edu.vss.janken.model.Result;
import br.ufam.edu.vss.janken.model.Shape;
import br.ufam.edu.vss.janken.util.GUIConstants;
import br.ufam.edu.vss.janken.util.Utils;

public class GUI implements RestartLabelListener, ShapeLabelListener {

    private static final String LOADING_PANEL = "LoadingPanel";
    private static final String RESULT_PANEL = "ResultPanel";
    private static final String SHAPES_PANEL = "ShapesPanel";
    private JFrame frame;
    private JPanel cards;
    private LoadingPanel loadingPanel;
    private PlayerPanel playerPanel;
    private ResultPanel resultPanel;
    private ShapesPanel shapesPanel;
    private Player player;
    private RestartGameListener restartGameListener;
    private WaitingForResultListener waitingForResultListener;

    public GUI(Player player) {
        this.player = player;
        initFrame();
        initPanels();
        prepare();
    }

    private void initFrame() {
        frame = new JFrame(GUIConstants.WINDOW_TITLE);
        frame.setLayout(new BorderLayout());

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initPanels() {
        cards = new JPanel(new CardLayout());
        loadingPanel = new LoadingPanel();
        playerPanel = new PlayerPanel(player.getName());
        resultPanel = new ResultPanel();
        shapesPanel = new ShapesPanel(this);

        cards.add(loadingPanel, LOADING_PANEL);
        cards.add(resultPanel, RESULT_PANEL);
        cards.add(shapesPanel, SHAPES_PANEL);
    }

    private void prepare() {
        frame.add(playerPanel, BorderLayout.PAGE_START);
        frame.add(cards, BorderLayout.CENTER);

        frame.pack();
        showChooseShapeStep();
    }

    public void show() {
        frame.setVisible(true);
    }

    public void dispose() {
        frame.dispose();
    }

    private void showCard(String name) {
        CardLayout layout = (CardLayout) cards.getLayout();
        layout.show(cards, name);
    }

    private void showChooseShapeStep() {
        showCard(SHAPES_PANEL);
    }

    private void showLoadingStep() {
        playerPanel.setCurrentStatus(GUIConstants.WAITING_OTHER_PLAYER_TEXT, true);
        showCard(LOADING_PANEL);
    }

    public void showResultStep(Result result) {
        playerPanel.setCurrentStatus(Utils.getResultMessage(result), false);
        resultPanel.setResult(result, this);
        showCard(RESULT_PANEL);
    }

    public void setListeners(RestartGameListener restartGameListener,
            WaitingForResultListener waitingForResultListener) {
        this.restartGameListener = restartGameListener;
        this.waitingForResultListener = waitingForResultListener;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void OnShapeLabelClicked(Shape shape) {
        player.setShape(shape);
        showLoadingStep();
        waitingForResultListener.onWaiting();
    }

    @Override
    public void onRestartLabelClicked() {
        showLoadingStep();
        restartGameListener.onRestart();
    }

}
