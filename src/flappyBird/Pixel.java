package flappyBird;

public class Pixel {
    public final int x;
    public final int y;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        Pixel pixel = (Pixel) o;
        return (pixel.x == x && pixel.y == y);

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
        // return Objects.hashCode(x, y); require guava library.
    }
}
