package game.state;

import controller.NPCController;
import controller.PlayerController;

import core.Size;
import entity.NPC;
import entity.Player;

import input.Input;
import map.GameMap;

import java.util.List;

public class GameState extends State {

    public GameState(Size windowSize, Input input) {
        super(windowSize, input);
        gameMap = new GameMap(new Size(20, 20), spriteLibrary);
        initializeCharacters();
    }

    private void initializeCharacters() {
        Player player = new Player(new PlayerController(input), spriteLibrary);
        gameObjects.add(player);
        camera.focusOn(player);
        initializeNPCs(200);
    }

    private void initializeNPCs(int numberOFNPCs) {
        for(int i = 0; i< numberOFNPCs; i++) {
            NPC npc = new NPC(new NPCController(), spriteLibrary);
            npc.setPosition(gameMap.getRandomPosition());
            gameObjects.add(npc);
        }
    }
}
