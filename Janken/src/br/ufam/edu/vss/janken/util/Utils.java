package br.ufam.edu.vss.janken.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import br.ufam.edu.vss.janken.model.Result;
import br.ufam.edu.vss.janken.model.Shape;

public class Utils {

    public static String getShapeLabel(Shape shape) {
        return shape == Shape.PAPER ? GUIConstants.PAPER_TEXT
                : shape == Shape.ROCK ? GUIConstants.ROCK_TEXT : GUIConstants.SCISSORS_TEXT;
    }

    public static ImageIcon getIcon(String path, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(path);
        imageIcon.setImage(getScaledImage(imageIcon.getImage(), width, height));
        return imageIcon;
    }

    public static String getResultMessage(Result result) {
        return result == Result.BEATS ? GUIConstants.WINNER_TEXT
                : result == Result.IS_BEATEN_BY ? GUIConstants.LOSER_TEXT
                        : result == Result.TIE ? GUIConstants.TIE_TEXT : GUIConstants.UNKNOWN_TEXT;
    }

    public static Image getScaledImage(Image src, int width, int height) {
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = resized.createGraphics();

        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics.drawImage(src, 0, 0, width, height, null);
        graphics.dispose();

        return resized;
    }

}
