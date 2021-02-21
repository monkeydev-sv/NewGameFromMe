package game.state;

import core.Position;
import core.Size;
import display.Camera;
import entity.GameObject;
import game.Time;
import gfx.SpriteLibrary;
import input.Input;
import map.GameMap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class State {

    protected GameMap gameMap;
    protected List<GameObject> gameObjects;
    protected SpriteLibrary spriteLibrary;
    protected Input input;
    protected Camera camera;
    protected Time time;

    public State(Size windowSize, Input input) {
        this.input = input;
        gameObjects = new ArrayList<>();
        spriteLibrary = new SpriteLibrary();
        camera = new Camera(windowSize);
        time = new Time();
    }

    public void update() {
        sortObjectsByPosition();
        gameObjects.forEach(gameObject -> gameObject.update(this));
        camera.update(this);
    }

    private void sortObjectsByPosition() {
        gameObjects.sort(Comparator.comparing(gameObject -> gameObject.getPosition().getY()));
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Camera getCamera() {
        return camera;
    }

    public Time getTime() {
        return time;
    }

    public Position getRandomPosition() {
        return gameMap.getRandomPosition();
    }

    public List<GameObject> getCollidingGameObjects(GameObject gameObject) {
        return gameObjects.stream()
                .filter(other -> other.collidesWith(gameObject))
                .collect(Collectors.toList());
    }
}
