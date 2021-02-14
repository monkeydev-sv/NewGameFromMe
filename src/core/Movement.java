package core;

import controller.Controller;

public class Movement {
    private Vector2D vector;
    private double speed;



    public Movement(double speed) {
        this.speed = speed;
        this.vector = new Vector2D(0,0);

    }
    public void update(Controller controller){
        int deltaX = 0;
        int deltaY = 0;
        if(controller.isRequstingUp()){
            deltaY--;

        }
        if(controller.isRequstingDown()){
            deltaY++;

        }
        if(controller.isRequstingLeft()){
            deltaX--;

        }
        if(controller.isRequstingRight()){
            deltaX++;

        }
        vector = new Vector2D(deltaX,deltaY);
       vector.normalize();
        vector.multiply(speed);
        System.out.println(vector.lenght());
    }
    public Vector2D getVector() {
        return vector;
    }
}

