package entity;

import controller.Controller;
import core.Position;
import entity.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
private Controller controller;
public  Player (Controller controller){
    super();
    this.controller = controller;

}

    @Override
    public void update() {
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

position = new Position(position.getX()+deltaX, position.getY()+deltaY);
    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(),size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.blue);
        graphics.fillRect(0,0, size.getWidth(),size.getHeight() );
        graphics.dispose();
        return image;
    }
}
