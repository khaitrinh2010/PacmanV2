package pacman.model.entity.dynamic.ghost.strategy;

import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;

public interface Strategy {
    public Vector2D chaseTarget(Vector2D pacmanPosition, KinematicState pacmanKinematicState);
}
