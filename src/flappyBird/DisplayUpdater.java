package flappyBird;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

public class DisplayUpdater {

    private final Set<Pixel> alterations;
    private final Set<MovingImage> movingImages;
    private final GameState gameState;
    private final BufferedImage backgroundImage;

    public DisplayUpdater(GameState gameState) {
        alterations = new HashSet<Pixel>();
        movingImages = new HashSet<MovingImage>();
        this.gameState = gameState;
        this.backgroundImage = Utility.createBufferedImage(Game.BACKGROUND_IMAGE);
        this.setDisplayToBackgroundImage();

    }

    private void setColor(int x, int y, int color) {
        gameState.getDisplay().setRGB(x, y, color);
        alterations.add(new Pixel(x, y));
    }

    private void setColorForBird(int x, int y, int color) {
        if (alterations.contains(new Pixel(x, y)) && !Game.INVISIBLE) {
            gameState.died();
        }
        setColor(x, y, color);
    }

    private void paintImage(int x, int y, BufferedImage image) {
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                if (i + x < Game.SCREEN_WIDTH && i + x > 0 && image.getRGB(i, j) != 0) {
                    setColor(x + i, y + j, image.getRGB(i, j));
                }
            }
        }
    }

    private void moveBird() {
        Bird bird = gameState.getBird();
        bird.move();
        for (int i = 0; i < bird.getImage().getWidth(); i++) {
            for (int j = 0; j < bird.getImage().getHeight(); j++) {
                if (bird.getImage().getRGB(i, j) != 0) {
                    if (bird.getY() < 0) {
                        bird.setLocation(bird.getX(), 0);
                        gameState.died();
                    } else if (bird.getY() > 500) {
                        bird.setLocation(bird.getX(), 500);
                        gameState.died();
                    }
                    setColorForBird(bird.getX() + i, bird.getY() + j, bird.getImage().getRGB(i, j));
                }
            }
        }
    }

    private void restorePixel(int x, int y) {
        gameState.getDisplay().setRGB(x, y, backgroundImage.getRGB(x, y));
    }

    private void clearScreen() {
        for (Pixel pixel : alterations) {
            restorePixel(pixel.x, pixel.y);
        }
        alterations.clear();
    }

    public void setDisplayToBackgroundImage() {
        for (int i = 0; i < Game.SCREEN_WIDTH; i++) {
            for (int j = 0; j < Game.SCREEN_HEIGHT; j++) {
                restorePixel(i, j);
            }
        }
    }

    public void updateDisplay() {
        clearScreen();
        Set<MovingImage> offSceenImages = new HashSet<MovingImage>();
        for (MovingImage image : movingImages) {
            if (isOnScreen(image)) {
                image.move();
                paintImage(image.getX(), image.getY(), image.getImage());
            } else {
                offSceenImages.add(image);
            }
        }
        moveBird();
        movingImages.removeAll(offSceenImages);
        offSceenImages.clear();
    }

    private boolean isOnScreen(MovingImage image) {
        return (image.getX() + image.getWidth() > 0 && image.getX() <= Game.SCREEN_WIDTH);

    }

    public void addMovingImage(MovingImage movingImage) {
        movingImages.add(movingImage);
    }
}
