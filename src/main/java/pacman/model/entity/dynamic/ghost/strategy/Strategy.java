package pacman.model.entity.dynamic.ghost.strategy;

import pacman.model.entity.dynamic.ghost.Ghost;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;
/**
 * Interface for ghost strategy
 */

public interface Strategy {
    /**
     * method for all type of ghosts to override
     * @param pacmanPosition, the position of pacman
     * @param pacmanKinematicState, the kinematic state of pacman
     * @param ghost, the ghost
     * @return the target position based on the strategy
     */
    Vector2D chaseTarget(Vector2D pacmanPosition, KinematicState pacmanKinematicState, Ghost ghost);
}
