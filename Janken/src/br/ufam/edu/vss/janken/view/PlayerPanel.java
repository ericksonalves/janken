package br.ufam.edu.vss.janken.view;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufam.edu.vss.janken.util.GUIConstants;

public class PlayerPanel extends JPanel {

    private static final long serialVersionUID = -399139901189373107L;
    private JLabel playerLabel;
    private JLabel playerStatusLabel;

    public PlayerPanel(String playerText) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        playerLabel = new JLabel(playerText);
        playerStatusLabel = new JLabel(GUIConstants.CHOOSE_SHAPE_TEXT);

        playerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerStatusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(playerLabel);
        add(playerStatusLabel);
    }

    public void setCurrentStatus(String status, boolean shouldFormat) {
        status = shouldFormat ? String.format(status, getOtherPlayer()) : status;
        playerStatusLabel.setText(status);
    }

    private String getOtherPlayer() {
        return playerLabel.getText().equals(GUIConstants.PLAYER_ONE_TEXT) ? GUIConstants.PLAYER_TWO_TEXT
                : GUIConstants.PLAYER_ONE_TEXT;
    }

}
