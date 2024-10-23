package pacman.model.factories.ghostfactories;

import pacman.model.entity.dynamic.ghost.Blinky;
import pacman.model.entity.dynamic.ghost.Ghost;
import pacman.model.entity.dynamic.ghost.GhostMode;
import pacman.model.entity.dynamic.physics.BoundingBox;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.factories.GhostFactory;

import java.awt.*;

public class BlinkyFactory extends GhostFactory {
    public BlinkyFactory() {
        GHOST_IMAGE = BLINKY_IMAGE;
        targetCorner = new Vector2D(RIGHT_X_POSITION_OF_MAP, TOP_Y_POSITION_OF_MAP);
    }

    @Override
    public Ghost createGhost(BoundingBox boundingBox, KinematicState kinematicState) {
        return new Blinky(GHOST_IMAGE, boundingBox, kinematicState, GhostMode.SCATTER, targetCorner);
    }
}
