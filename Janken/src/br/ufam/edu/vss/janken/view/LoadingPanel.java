package br.ufam.edu.vss.janken.view;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufam.edu.vss.janken.util.GUIConstants;
import br.ufam.edu.vss.janken.util.Utils;

public class LoadingPanel extends JPanel {

    private static final long serialVersionUID = 2978101601765474589L;
    private ImageIcon loadingIcon;
    private JLabel loadingLabel;

    public LoadingPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        loadingIcon = Utils.getIcon(GUIConstants.LOADING_ICON_PATH, GUIConstants.SHAPE_WIDTH,
                GUIConstants.SHAPE_HEIGHT);

        loadingLabel = new JLabel(loadingIcon);
        loadingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(loadingLabel);
    }
}
