package pacman.model.factories.ghostfactories;

import pacman.model.entity.dynamic.ghost.Ghost;
import pacman.model.entity.dynamic.ghost.GhostMode;
import pacman.model.entity.dynamic.ghost.Pinky;
import pacman.model.entity.dynamic.physics.BoundingBox;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.factories.GhostFactory;

public class PinkyFactory extends GhostFactory {
    public PinkyFactory() {
        GHOST_IMAGE = PINKY_IMAGE;
        targetCorner = new Vector2D(0, TOP_Y_POSITION_OF_MAP);
    }

    @Override
    public Ghost createGhost(BoundingBox boundingBox, KinematicState kinematicState) {
        return new Pinky(GHOST_IMAGE, boundingBox, kinematicState, GhostMode.SCATTER, targetCorner);
    }
}
