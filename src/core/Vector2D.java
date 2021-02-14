package core;

import controller.Controller;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void multiply(double speed) {
        x*=speed;
        y*=speed;

    }
    public double lenght() {
        return Math.sqrt(x * x + y);
    }
        public void normalize(){
        double length = lenght();
        x = x == 0 ? 0: x/length;
            y= y == 0 ? 0: y/length;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
