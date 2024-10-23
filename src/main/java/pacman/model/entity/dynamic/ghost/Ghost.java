package pacman.model.entity.dynamic.ghost;

import pacman.model.entity.dynamic.DynamicEntity;
import pacman.model.entity.dynamic.ghost.state.GhostState;
import pacman.model.entity.dynamic.physics.Direction;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.entity.dynamic.player.observer.PlayerPositionObserver;

import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * Represents Ghost entity in Pac-Man Game
 */
public interface Ghost extends DynamicEntity, PlayerPositionObserver {

    /***
     * Sets the speeds of the Ghost for each GhostMode
     * @param speeds speeds of the Ghost for each GhostMode
     */
    void setSpeeds(Map<GhostMode, Double> speeds);

    /**
     * Sets the mode of the Ghost used to calculate target position
     *
     * @param ghostMode mode of the Ghost
     */
    void setGhostMode(GhostMode ghostMode);

    /**
     * get the target corner of the Ghost
     *
     * @return the target corner of the Ghost
     */
    Vector2D getTargetCorner();

    /**
     * Gets the current state of the Ghost
     * @return
     */
    GhostState getCurrentGhostState();

    void setCurrentGhostState(GhostState state);

    GhostState getFrightenedState();

    GhostState getRegularState();

    void setState(GhostState state);

    Vector2D getTargetLocation();

    void setTargetLocation(Vector2D targetLocation);

    Set<Direction> getPossibleDirections();

    Direction getCurrentDirection();

    void setCurrentDirectionCount(int currentDirectionCount);

    int getCurrentDirectionCount();

    void setCurrentDirection(Direction currentDirection);

    KinematicState getKinematicState();
}
