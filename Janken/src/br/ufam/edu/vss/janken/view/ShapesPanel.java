package br.ufam.edu.vss.janken.view;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufam.edu.vss.janken.listener.ShapeLabelListener;
import br.ufam.edu.vss.janken.listener.ShapeLabelMouseListener;
import br.ufam.edu.vss.janken.model.Shape;
import br.ufam.edu.vss.janken.util.GUIConstants;
import br.ufam.edu.vss.janken.util.Utils;

public class ShapesPanel extends JPanel {

    private static final long serialVersionUID = -1947691441821981100L;
    private ImageIcon paperIcon;
    private ImageIcon rockIcon;
    private ImageIcon scissorsIcon;
    private JLabel paperLabel;
    private JLabel rockLabel;
    private JLabel scissorsLabel;

    public ShapesPanel(ShapeLabelListener listener) {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        paperIcon = Utils.getIcon(GUIConstants.PAPER_ICON_PATH, GUIConstants.SHAPE_WIDTH, GUIConstants.SHAPE_HEIGHT);
        rockIcon = Utils.getIcon(GUIConstants.ROCK_ICON_PATH, GUIConstants.SHAPE_WIDTH, GUIConstants.SHAPE_HEIGHT);
        scissorsIcon = Utils.getIcon(GUIConstants.SCISSORS_ICON_PATH, GUIConstants.SHAPE_WIDTH,
                GUIConstants.SHAPE_HEIGHT);

        paperLabel = new JLabel(paperIcon);
        rockLabel = new JLabel(rockIcon);
        scissorsLabel = new JLabel(scissorsIcon);

        rockLabel.setToolTipText(GUIConstants.ROCK_TEXT);
        scissorsLabel.setToolTipText(GUIConstants.SCISSORS_TEXT);

        paperLabel.addMouseListener(new ShapeLabelMouseListener(Shape.PAPER, listener));
        rockLabel.addMouseListener(new ShapeLabelMouseListener(Shape.ROCK, listener));
        scissorsLabel.addMouseListener(new ShapeLabelMouseListener(Shape.SCISSORS, listener));

        add(paperLabel);
        add(rockLabel);
        add(scissorsLabel);
    }

}
