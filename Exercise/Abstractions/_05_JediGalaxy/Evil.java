package Exercise.Abstractions._05_JediGalaxy;

public class Evil {
    private int x;
    private int y;

    public Evil(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        x--;
        y--;
    }
}
