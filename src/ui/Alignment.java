package ui;

public class Alignment {

    public enum Position {
        START, CENTER, END
    }

    private final Position horizontal;
    private final Position vertical;

    public Alignment(Position horizontal, Position vertical) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public Position getVertical() {
        return vertical;
    }

    public Position getHorizontal() {
        return horizontal;
    }
}