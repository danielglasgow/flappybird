package flappyBird;

import java.awt.image.BufferedImage;

public class Pole extends MovingImage {

    public Pole(int x, int y, BufferedImage image) {
        super(x, y, image);
    }

    @Override
    public void move() {
        moveX(-Game.SPEED);
    }

}
