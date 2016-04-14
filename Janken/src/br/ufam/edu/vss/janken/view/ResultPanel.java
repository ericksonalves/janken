package br.ufam.edu.vss.janken.view;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufam.edu.vss.janken.listener.RestartLabelListener;
import br.ufam.edu.vss.janken.listener.RestartLabelMouseListener;
import br.ufam.edu.vss.janken.model.Result;
import br.ufam.edu.vss.janken.util.GUIConstants;
import br.ufam.edu.vss.janken.util.Utils;

public class ResultPanel extends JPanel {

    private static final long serialVersionUID = 1186072973534675139L;
    private ImageIcon resultIcon;
    private JLabel resultLabel;

    public ResultPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public void setResult(Result result, RestartLabelListener listener) {
        resultIcon = Utils.getIcon(getResultPath(result), GUIConstants.SHAPE_WIDTH, GUIConstants.SHAPE_HEIGHT);

        resultLabel = new JLabel(resultIcon);
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLabel.setToolTipText(GUIConstants.RESTART_TOOL_TIP_TEXT);
        resultLabel.addMouseListener(new RestartLabelMouseListener(listener));

        add(resultLabel);
    }

    private String getResultPath(Result result) {
        return result == Result.BEATS || result == Result.TIE ? GUIConstants.WINNER_ICON_PATH
                : result == Result.IS_BEATEN_BY ? GUIConstants.LOSER_ICON_PATH : GUIConstants.UNKNOWN_ICON_PATH;
    }

}
