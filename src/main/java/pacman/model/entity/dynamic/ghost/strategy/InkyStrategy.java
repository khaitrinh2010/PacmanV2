package pacman.model.entity.dynamic.ghost.strategy;

import pacman.model.entity.dynamic.ghost.Ghost;
import pacman.model.entity.dynamic.ghost.GhostImpl;
import pacman.model.entity.dynamic.physics.Direction;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.maze.MazeCreator;
/**
 * Strategy for Inky ghost
 */

public class InkyStrategy implements Strategy {
    /**
     * Inky depends on Blinky's position to chase the target
     */
    private Ghost blinkyGhost;
    /**
     * 2 grid spaces ahead of Pacman in the direction it is facing
     */
    private final int CELL_THRESHOLD = 2;

    /**
     * Chase target for Inky
     * @param pacmanPosition, position of pacman
     * @param pacmanKinematicState, kinematic state of pacman
     * @param ghost, the ghost (Inky)
     * @return, the target position based on the strategy
     */
    @Override
    public Vector2D chaseTarget(Vector2D pacmanPosition, KinematicState pacmanKinematicState, Ghost ghost) {
        int xTilePacman = (int) Math.floor(pacmanPosition.getX() / MazeCreator.RESIZING_FACTOR);
        int yTilePacman = (int) Math.floor(pacmanPosition.getY() / MazeCreator.RESIZING_FACTOR);
        Direction direction = pacmanKinematicState.getDirection();
        switch (direction) {
            case UP:
                yTilePacman -= CELL_THRESHOLD;
                break;
            case DOWN:
                yTilePacman += CELL_THRESHOLD;
                break;
            case LEFT:
                xTilePacman -= CELL_THRESHOLD;
                break;
            case RIGHT:
                xTilePacman += CELL_THRESHOLD;
                break;
        }
        int xTileBlinky = (int) Math.floor(blinkyGhost.getCenter().getX() / MazeCreator.RESIZING_FACTOR);
        int yTileBlinky = (int) Math.floor(blinkyGhost.getCenter().getY() / MazeCreator.RESIZING_FACTOR);

        int distanceX = (xTileBlinky - xTilePacman) * 2;
        int distanceY = (yTileBlinky - yTilePacman) * 2;

        xTileBlinky += distanceX;
        yTileBlinky += distanceY;

        xTileBlinky = Math.max(1, Math.min(26, xTileBlinky));
        yTileBlinky = Math.max(4, Math.min(32, yTileBlinky));

        return new Vector2D(xTileBlinky * MazeCreator.RESIZING_FACTOR, yTileBlinky * MazeCreator.RESIZING_FACTOR);

    }

    /**
     * Set the blinky ghost
     * @param blinkyGhost, the blinky ghost
     */
    public void setBlinkyGhost(Ghost blinkyGhost) {
        this.blinkyGhost = blinkyGhost;
    }
}
