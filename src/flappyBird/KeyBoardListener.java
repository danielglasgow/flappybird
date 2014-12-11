package flappyBird;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardListener implements KeyListener {

    private final GameState gameState;

    public KeyBoardListener(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            gameState.getBird().jump();
        }
        if (keyCode == KeyEvent.VK_ENTER) {
            GameLoop.requestStart();

        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

}
