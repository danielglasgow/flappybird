package flappyBird;

import java.util.HashMap;
import java.util.Map;

public class PoleLibrary {

    private final Map<Integer, PolePair> poles;

    public PoleLibrary() {
        poles = initializePoles();
    }

    public Pole getTop(int poleNumber) {
        Pole pole = poles.get(poleNumber).top;
        return new Pole(pole.getX(), pole.getY(), pole.getImage());
    }

    public Pole getBottom(int poleNumber) {
        Pole pole = poles.get(poleNumber).bottom;
        return new Pole(pole.getX(), pole.getY(), pole.getImage());
    }

    private Map<Integer, PolePair> initializePoles() {
        Map<Integer, PolePair> poles = new HashMap<Integer, PolePair>();
        for (int i = 1; i <= Game.NUMBER_OF_POLES; i++) {
            Pole top = new Pole(Game.SCREEN_WIDTH, Game.BASE_POLE_HEIGHT + (8 - i)
                    * Game.POLE_HEIGHT_INCREMENT, Utility.createBufferedImage("Images/Poles/pole"
                    + i + "up.png"));
            Pole bottom = new Pole(Game.SCREEN_WIDTH, 0,
                    Utility.createBufferedImage("Images/Poles/pole" + (9 - i) + "down.png"));
            poles.put(i, new PolePair(top, bottom));
        }
        return poles;
    }

    private class PolePair {
        public final Pole top;
        public final Pole bottom;

        public PolePair(Pole top, Pole bottom) {
            this.top = top;
            this.bottom = bottom;
        }
    }
}
