package flappyBird;

public class Slider extends MovingImage {

    public Slider(int x) {
        super(x, Game.SLIDER_Y_LOCATION, Utility.createBufferedImage(Game.SLIDER_IMAGE));
    }

    @Override
    public void move() {
        moveX(-Game.SPEED);
    }
}
