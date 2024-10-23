package pacman.model.entity.dynamic.ghost.strategy;

import pacman.model.entity.dynamic.ghost.Ghost;
import pacman.model.entity.dynamic.physics.Direction;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.maze.MazeCreator;

public class PinkyStrategy implements Strategy {
    private Ghost ghost;
    public PinkyStrategy(Ghost ghost) {
        this.ghost = ghost;
    }

    @Override
    public Vector2D chaseTarget(Vector2D pacmanPosition, KinematicState pacmanKinematicState) {
        int xTilePacman = (int) Math.floor(pacmanPosition.getX() / MazeCreator.RESIZING_FACTOR);
        int yTilePacman = (int) Math.floor(pacmanPosition.getY() / MazeCreator.RESIZING_FACTOR);
        Direction direction = pacmanKinematicState.getDirection();
        switch (direction) {
            case UP:
                yTilePacman -= 4;
                break;
            case DOWN:
                yTilePacman += 4;
                break;
            case LEFT:
                xTilePacman -= 4;
                break;
            case RIGHT:
                xTilePacman += 4;
                break;
        }
        xTilePacman = Math.max(1, Math.min(26, xTilePacman));
        yTilePacman = Math.max(4, Math.min(32, yTilePacman));
        return new Vector2D(xTilePacman * MazeCreator.RESIZING_FACTOR, yTilePacman * MazeCreator.RESIZING_FACTOR);
    }
}
