package map;

import gfx.SpriteLibrary;

import java.awt.*;

public class Tile {

    private final Image sprite;

    public Tile(SpriteLibrary spriteLibrary) {
        this.sprite = spriteLibrary.getTile("woodFloor");
    }

    public Image getSprite() {
        return sprite;
    }
}
