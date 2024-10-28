package pacman.model.factories.ghostfactories;

import pacman.model.entity.dynamic.ghost.Clyde;
import pacman.model.entity.dynamic.ghost.Ghost;
import pacman.model.entity.dynamic.ghost.GhostMode;
import pacman.model.entity.dynamic.physics.BoundingBox;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.factories.GhostFactory;

/**
 * Factory class for creating Clyde ghost
 */
public class ClydeFactory extends GhostFactory {
    public ClydeFactory() {
        GHOST_IMAGE = CLYDE_IMAGE;
        targetCorner = new Vector2D(0, BOTTOM_Y_POSITION_OF_MAP);
    }

    @Override
    public Ghost createGhost(BoundingBox boundingBox, KinematicState kinematicState) {
        return new Clyde(GHOST_IMAGE, boundingBox, kinematicState, GhostMode.SCATTER, targetCorner);
    }
}
