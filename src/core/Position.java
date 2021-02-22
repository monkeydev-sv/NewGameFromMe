package core;

public class Position {

    public static int PROXIMITY_RANGE = 5;

    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position copyOf(Position position) {
        return new Position(position.getX(), position.getY());
    }

    public int intX() {
        return (int) Math.round(x);
    }

    public int intY() {
        return (int) Math.round(y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void apply(Motion motion) {
        Vector2D vector = motion.getVector();
        x += vector.getX();
        y += vector.getY();
    }

    public boolean isInRangeOf(Position position) {
        return Math.abs(x - position.getX()) < Position.PROXIMITY_RANGE &&  Math.abs(y - position.getY()) < Position.PROXIMITY_RANGE;
    }

    public void applyX(Motion motion) {
        x += motion.getVector().getX();

    }
    public void applyY(Motion motion) {
        y += motion.getVector().getY();

    }
}
