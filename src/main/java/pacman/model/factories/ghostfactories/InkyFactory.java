package pacman.model.factories.ghostfactories;

import pacman.model.entity.dynamic.ghost.Ghost;
import pacman.model.entity.dynamic.ghost.GhostMode;
import pacman.model.entity.dynamic.ghost.Inky;
import pacman.model.entity.dynamic.physics.BoundingBox;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.factories.GhostFactory;

/**
 * Factory class for creating Inky ghost
 */
public class InkyFactory extends GhostFactory {
    public InkyFactory() {
        GHOST_IMAGE = INKY_IMAGE;
        targetCorner = new Vector2D(RIGHT_X_POSITION_OF_MAP, BOTTOM_Y_POSITION_OF_MAP);
    }
    public Ghost createGhost(BoundingBox boundingBox, KinematicState kinematicState) {
        return new Inky(GHOST_IMAGE, boundingBox, kinematicState, GhostMode.SCATTER, targetCorner);
    }
}
