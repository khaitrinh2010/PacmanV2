package pacman.model.entity.dynamic.ghost.strategy;

import pacman.model.entity.dynamic.ghost.Ghost;
import pacman.model.entity.dynamic.physics.Direction;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.maze.MazeCreator;

public class InkyStrategy implements Strategy {
    private Ghost ghost;
    private Ghost blinkyGhost;
    public InkyStrategy(Ghost ghost) {
        this.ghost = ghost;
    }

    @Override
    public Vector2D chaseTarget(Vector2D pacmanPosition, KinematicState pacmanKinematicState) {
        int xTilePacman = (int) Math.floor(pacmanPosition.getX() / MazeCreator.RESIZING_FACTOR);
        int yTilePacman = (int) Math.floor(pacmanPosition.getY() / MazeCreator.RESIZING_FACTOR);
        Direction direction = pacmanKinematicState.getDirection();
        switch (direction) {
            case UP:
                yTilePacman -= 2;
                break;
            case DOWN:
                yTilePacman += 2;
                break;
            case LEFT:
                xTilePacman -= 2;
                break;
            case RIGHT:
                xTilePacman += 2;
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
    public void setBlinkyGhost(Ghost blinkyGhost) {
        this.blinkyGhost = blinkyGhost;
    }
}
