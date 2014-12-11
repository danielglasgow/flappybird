package flappyBird;

import java.awt.image.BufferedImage;

public abstract class MovingImage implements MovingObject {
    private int x;
    private int y;
    private final BufferedImage image;

    public MovingImage(int x, int y, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    public BufferedImage getImage() {
        return image;
    }

    public void moveX(int x) {
        this.x += x;
    }

    public void moveY(int y) {
        this.y += y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
