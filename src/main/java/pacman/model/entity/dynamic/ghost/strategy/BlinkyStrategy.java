package pacman.model.entity.dynamic.ghost.strategy;

import pacman.model.entity.dynamic.ghost.Ghost;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;
/**
 * Interface for ghost strategy
 */

public class BlinkyStrategy implements Strategy {
    /**
     * Chase target for Blinky
     * @param pacmanPosition, the position of pacman
     * @param pacmanKinematicState, the kinematic state of pacman
     * @param ghost, the ghost (Blinky)
     * @return the target position based on the strategy
     */
    @Override
    public Vector2D chaseTarget(Vector2D pacmanPosition, KinematicState pacmanKinematicState, Ghost ghost) {
        return pacmanPosition;
    }
}
