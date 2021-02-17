package game.state;

import controller.PlayerController;
import core.Size;
import display.Camera;
import entity.GameObject;
import entity.Player;
import gfx.SpriteLibrary;
import input.Input;
import map.GameMap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class State {

    protected GameMap gameMap;
    protected List<GameObject> gameObjects;
    protected SpriteLibrary spriteLibrary;
    protected Input input;
    protected Camera camera;


    public State(Size windowSize,Input input) {
        this.input = input;
        gameObjects = new ArrayList<>();
        spriteLibrary = new SpriteLibrary();
        camera = new Camera(windowSize);

    }

    public void update() {
        sortObjectByPosition();
        gameObjects.forEach(gameObject -> gameObject.update());
        camera.update(this);
    }

    private void sortObjectByPosition(){
       gameObjects.sort(Comparator.comparing(gameObject -> gameObject.getPosition().getY()));
    }

    public Camera getCamera() {
        return camera;
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public GameMap getGameMap() {
        return gameMap;
    }
}