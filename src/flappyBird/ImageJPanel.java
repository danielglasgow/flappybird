package flappyBird;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ImageJPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private final GameState gameState;

    public ImageJPanel(GameState gameState) {
        this.gameState = gameState;
        this.setPreferredSize(new Dimension(Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(gameState.getDisplay(), 0, 0, this);
        g.setFont(new Font("Braciola MS Extrabold", Font.BOLD, 50));
        g.setColor(Color.WHITE);
        g.drawString("" + gameState.getScore(), 200, 50);

    }

}
