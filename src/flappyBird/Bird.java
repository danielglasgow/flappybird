package flappyBird;

public class Bird extends MovingImage {

    private int ySpeed;
    private double jumpSpeed;

    public Bird() {
        super(0, 0, Utility.createBufferedImage(Game.BIRD_IMAGE));
    }

    @Override
    public void move() {
        moveY(ySpeed);
        ySpeed += Game.GRAVITY;
        if (jumpSpeed > Game.BASE_JUMP_SPEED) {
            jumpSpeed -= Game.JUMP_DECELERATION;
        }
    }

    public void jump() {
        ySpeed = 0;
        ySpeed -= (int) jumpSpeed;
        jumpSpeed += Game.JUMP_ACCELERATION;
    }

    public void restart() {
        this.ySpeed = Game.BIRD_START_SPEED;
        this.jumpSpeed = Game.BASE_JUMP_SPEED;
        setLocation(Game.BIRD_X_POSITION, Game.BIRD_STARTING_HEIGHT);
    }

}
