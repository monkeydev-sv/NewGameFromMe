package entity.action;

import entity.MovingEntity;
import game.state.State;

public abstract class Action {
    public abstract void update(State state, MovingEntity entity);
    public abstract boolean isDone();
    public abstract String getAnimationName();
}
