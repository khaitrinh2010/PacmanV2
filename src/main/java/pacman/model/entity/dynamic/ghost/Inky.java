package pacman.model.entity.dynamic.ghost;

import javafx.scene.image.Image;
import pacman.model.entity.dynamic.ghost.strategy.InkyStrategy;
import pacman.model.entity.dynamic.ghost.strategy.Strategy;
import pacman.model.entity.dynamic.physics.BoundingBox;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;

public class Inky extends GhostImpl{
    public Inky(Image image, BoundingBox boundingBox, KinematicState kinematicState, GhostMode ghostMode, Vector2D targetCorner) {
        super(image, boundingBox, kinematicState, ghostMode, targetCorner);
        strategy = new InkyStrategy(this);
    }

    public Strategy getStrategy() {
        return strategy;
    }
}
