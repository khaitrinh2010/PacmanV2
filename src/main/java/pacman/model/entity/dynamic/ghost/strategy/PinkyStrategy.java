package pacman.model.entity.dynamic.ghost.strategy;

import pacman.model.entity.dynamic.ghost.Ghost;
import pacman.model.entity.dynamic.physics.Direction;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.maze.MazeCreator;

public class PinkyStrategy implements Strategy {

    /**
     * 4 grid spaces ahead of Pacman in the direction it is facing
     */
    private final int THRESHOLD = 4;

    /**
     * Chase target for Pinky
     * @param pacmanPosition, position of pacman
     * @param pacmanKinematicState, kinematic state of pacman
     * @param ghost, the ghost (Pinky)
     * @return the target position based on the strategy
     */
    @Override
    public Vector2D chaseTarget(Vector2D pacmanPosition, KinematicState pacmanKinematicState, Ghost ghost) {
        int xTilePacman = (int) Math.floor(pacmanPosition.getX() / MazeCreator.RESIZING_FACTOR);
        int yTilePacman = (int) Math.floor(pacmanPosition.getY() / MazeCreator.RESIZING_FACTOR);
        Direction direction = pacmanKinematicState.getDirection();
        switch (direction) {
            case UP:
                yTilePacman -= THRESHOLD;
                break;
            case DOWN:
                yTilePacman += THRESHOLD;
                break;
            case LEFT:
                xTilePacman -= THRESHOLD;
                break;
            case RIGHT:
                xTilePacman += THRESHOLD;
                break;
        }
        xTilePacman = Math.max(1, Math.min(26, xTilePacman));
        yTilePacman = Math.max(4, Math.min(32, yTilePacman));
        return new Vector2D(xTilePacman * MazeCreator.RESIZING_FACTOR, yTilePacman * MazeCreator.RESIZING_FACTOR);
    }
}
