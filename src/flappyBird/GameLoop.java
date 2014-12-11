package flappyBird;

import java.awt.Frame;

public class GameLoop {

    private final Frame frame;
    private final GameState gameState;
    private final PoleLibrary poles;

    private static boolean stopRequested;

    public GameLoop(Frame frame, GameState gameState) {
        this.frame = frame;
        this.gameState = gameState;
        this.poles = new PoleLibrary();
    }

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    public static synchronized void requestStart() {
        stopRequested = false;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public void run() {
        while (true) {
            gameState.restart();
            requestStop();
            int count = 0;
            DisplayUpdater displayUpdater = new DisplayUpdater(gameState);
            int sliderTail = 0;
            int poleNumber = Game.NUMBER_OF_POLES / 2;
            while (gameState.isAlive() && !stopRequested()) {
                if (count == 0) {
                    sliderTail = initilizeSliders(displayUpdater);
                }
                displayUpdater.updateDisplay();
                frame.repaint();
                if ((count + 1) % Game.POLE_FREQUENCY == 0) {
                    poleNumber = generatePole(poleNumber);
                    displayUpdater.addMovingImage(poles.getTop(poleNumber));
                    displayUpdater.addMovingImage(poles.getBottom(poleNumber));
                }
                if (count > Game.POLE_FREQUENCY * 2
                        && ((count + Game.POLE_FREQUENCY / 2) + 1) % Game.POLE_FREQUENCY == 0) {
                    gameState.incrementScore();
                }
                sliderTail -= Game.SPEED;
                if (sliderTail < Game.SCREEN_WIDTH) {
                    displayUpdater.addMovingImage(new Slider(sliderTail));
                    sliderTail += Game.SLIDER_WIDTH;
                }

                try {
                    Thread.sleep(1000 / Game.FRAMES_PER_SECOND);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;

            }
        }
    }

    private int initilizeSliders(DisplayUpdater displayUpdater) {
        int tail = 0;
        for (int i = 0; i < Game.SCREEN_WIDTH; i += Game.SLIDER_WIDTH) {
            Slider slider = new Slider(i);
            displayUpdater.addMovingImage(slider);
            tail += Game.SLIDER_WIDTH;
        }
        return tail;
    }

    private int generatePole(int last) {
        double min = last - Game.MAX_POLE_CHANGE;
        double max = last + Game.MAX_POLE_CHANGE;
        if (min < 1) {
            min = 1;
        }
        if (max > Game.NUMBER_OF_POLES) {
            max = Game.NUMBER_OF_POLES;
        }
        return (int) Math.round((min + (Math.random() * (max - min))));
    }

}
