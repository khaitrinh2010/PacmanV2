package pacman.model.entity.dynamic.ghost.strategy;

import pacman.model.entity.dynamic.ghost.Ghost;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;

public class BlinkyStrategy implements Strategy {
    private Ghost ghost;
    public BlinkyStrategy(Ghost ghost) {
        this.ghost = ghost;
    }

    @Override
    public Vector2D chaseTarget(Vector2D pacmanPosition, KinematicState pacmanKinematicState) {
        return pacmanPosition;
    }
}
