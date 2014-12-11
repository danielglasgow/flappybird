package flappyBird;

import java.awt.image.BufferedImage;

public class GameState {

    private int score;
    private boolean alive;

    private final Bird bird;
    private final BufferedImage display;

    public GameState() {
        this.display = Utility.createBufferedImage(Game.BACKGROUND_IMAGE);
        bird = new Bird();
        restart();
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    public void died() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public Bird getBird() {
        return bird;
    }

    public BufferedImage getDisplay() {
        return display;
    }

    public void restart() {
        alive = true;
        score = 0;
        bird.restart();
    }

}
