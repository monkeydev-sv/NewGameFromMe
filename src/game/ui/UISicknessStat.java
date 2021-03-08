package game.ui;

import core.Size;
import entity.MovingEntity;
import entity.effect.Sick;
import game.state.State;
import ui.*;

public class UISicknessStat extends HorizontalContainer {
    private UIText numberOfSick;
    private UIText numberOfHealty;

    public UISicknessStat(Size windowSize) {
        super(windowSize);
        this.numberOfSick = new UIText("");
        this.numberOfHealty = new UIText("");

        UIContainer sickContainer = new VerticalContainer(windowSize);
        sickContainer.setPadding(new Spacing(0));
        sickContainer.addUIComponent(new UIText("SICK"));
        sickContainer.addUIComponent(numberOfSick);
        UIContainer healtyContainer = new VerticalContainer(windowSize);
        healtyContainer.setPadding(new Spacing(0));
        healtyContainer.addUIComponent(new UIText("HEALTHY"));
        healtyContainer.addUIComponent(numberOfHealty);

        addUIComponent(healtyContainer);
        addUIComponent(sickContainer);

    }
    @Override
    public void update(State state) {
        super.update(state);
        long sickCount = state.getGameObjects().stream()
                .filter(gameObject -> gameObject instanceof MovingEntity)
                .map(gameObject -> (MovingEntity) gameObject)
                .filter(movingEntity -> movingEntity.isAffectedBy(Sick.class))
                .count();

        long healthyCount = state.getGameObjects().stream()
                .filter(gameObject -> gameObject instanceof MovingEntity)
                .map(gameObject -> (MovingEntity) gameObject)
                .filter(movingEntity -> !movingEntity.isAffectedBy(Sick.class))
                .count();

        numberOfSick.setText(String.valueOf(sickCount));
        numberOfHealty.setText(String.valueOf(healthyCount));
    }
}
