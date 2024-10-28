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

    /**
     * Gets the frightened state of the Ghost
     * @return the frightened state of the Ghost
     */
    GhostState getFrightenedState();

    /**
     * Gets the regular state of the Ghost
     * @return regular state of the Ghost
     */
    GhostState getRegularState();

    /**
     * set the current state of the Ghost
     * @param state, the state of the Ghost
     */
    void setState(GhostState state);

    /**
     * Get the target location of the Ghost
     * @return position of the target location
     */
    Vector2D getTargetLocation();

    /**
     * Set the target location of the Ghost
     * @param targetLocation, the target location of the Ghost
     */
    void setTargetLocation(Vector2D targetLocation);

    /**
     * get all possible directions the Ghost can move
     * @return all possible directions the Ghost can move
     */
    Set<Direction> getPossibleDirections();

    /**
     * direction the Ghost is currently moving
     * @return direction the Ghost is currently moving
     */
    Direction getCurrentDirection();

    /**
     * set the direction count of the Ghost
     * @param currentDirectionCount, the current direction count
     */
    void setCurrentDirectionCount(int currentDirectionCount);

    /**
     * get the current direction count of the Ghost
     * @return the current direction count of the Ghost
     */
    int getCurrentDirectionCount();

    /**
     * set the current direction of the Ghost
     * @param currentDirection, the current direction of the Ghost
     */
    void setCurrentDirection(Direction currentDirection);

    /**
     * get the kinematic state of the Ghost
     * @return the kinematic state of the Ghost
     */
    KinematicState getKinematicState();

    /**
     * set duration that ghost will be freeze
     * @param freezeCount, the duration
     */
    void setFreezeCount(int freezeCount);
}
