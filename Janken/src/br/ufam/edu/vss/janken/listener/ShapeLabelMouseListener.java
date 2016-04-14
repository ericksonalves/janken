package br.ufam.edu.vss.janken.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import br.ufam.edu.vss.janken.model.Shape;
import br.ufam.edu.vss.janken.util.GUIConstants;
import br.ufam.edu.vss.janken.util.Utils;

public class ShapeLabelMouseListener implements MouseListener {

    private Shape shape;
    private ShapeLabelListener listener;
    private String shapeText;

    public ShapeLabelMouseListener(Shape shape, ShapeLabelListener listener) {
        this.shape = shape;
        this.shapeText = Utils.getShapeLabel(this.shape);
        this.listener = listener;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int dialogResult = JOptionPane.showConfirmDialog(null, String.format(GUIConstants.CONFIRMATION_TEXT, shapeText),
                GUIConstants.CONFIRMATION_DIALOG_TITLE, JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            listener.OnShapeLabelClicked(shape);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

}
