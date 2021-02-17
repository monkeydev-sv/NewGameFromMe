package game;

import controller.PlayerController;
import core.Size;
import display.Display;
import entity.GameObject;
import entity.Player;
import game.state.GameState;
import game.state.State;
import gfx.SpriteLibrary;
import input.Input;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static int SPRITE_SIZE = 64;

    private Display display;
    private Input input;
    private State state;

    public Game(int width, int height) {
        input = new Input();
        display = new Display(width, height, input);
        state = new GameState(new Size(width, height), input);
    }

    public void update() {
        state.update();
    }

    public void render() {
        display.render(state);
    }
}
