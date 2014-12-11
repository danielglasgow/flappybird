package flappyBird;

import java.awt.Frame;

public class Game {
    public static final String BIRD_IMAGE = "Images/bird.png";
    public static final String BACKGROUND_IMAGE = "Images/flappy-background.png";
    public static final String SLIDER_IMAGE = "Images/slider.jpg";

    // These shouldn't be modifed, unless by develper
    public static final int BASE_POLE_HEIGHT = 188;
    public static final int POLE_HEIGHT_INCREMENT = 40;
    public static final int SLIDER_Y_LOCATION = 540;
    public static final int SLIDER_WIDTH = 50;
    public static final int BIRD_X_POSITION = 80;
    public static final int BIRD_STARTING_HEIGHT = 100;
    public static final int SCREEN_WIDTH = 435;
    public static final int SCREEN_HEIGHT = 750;
    public static final int NUMBER_OF_POLES = 8;

    // Physics, can be played around with
    public static final int GRAVITY = 5;
    public static final int BIRD_START_SPEED = 12;
    public static final int BASE_JUMP_SPEED = 12;
    public static final double JUMP_ACCELERATION = 6;
    public static final double JUMP_DECELERATION = 1;
    public static final int SPEED = 12;
    public static final int POLE_FREQUENCY = 20;
    public static final int MAX_POLE_CHANGE = 8;
    public static final int FRAMES_PER_SECOND = 25;

    // Shouldn't be touched.
    public static final boolean INVISIBLE = false;

    private void play() {
        GameState gameState = new GameState();
        KeyBoardListener keyBoardListener = new KeyBoardListener(gameState);
        ImageJPanel background = new ImageJPanel(gameState);
        Frame frame = Utility.createFrame();
        frame.addKeyListener(keyBoardListener);
        frame.add(background);
        frame.pack();
        new GameLoop(frame, gameState).run();
    }

    public static void main(String[] args) {
        new Game().play();
    }

}
