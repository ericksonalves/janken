package br.ufam.edu.vss.janken.listener;

import java.awt.event.MouseListener;

public class RestartLabelMouseListener implements MouseListener {

    private RestartLabelListener listener;

    public RestartLabelMouseListener(RestartLabelListener listener) {
        this.listener = listener;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        listener.onRestartLabelClicked();
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

}
