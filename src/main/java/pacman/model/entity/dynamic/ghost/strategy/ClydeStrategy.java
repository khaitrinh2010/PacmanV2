package pacman.model.entity.dynamic.ghost.strategy;

import pacman.model.entity.dynamic.ghost.Ghost;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.maze.MazeCreator;

public class ClydeStrategy implements Strategy {
    private Ghost ghost;
    public ClydeStrategy(Ghost ghost) {
        this.ghost = ghost;
    }

    @Override
    public Vector2D chaseTarget(Vector2D pacmanPosition, KinematicState pacmanKinematicState) {
        int xTilePacman = (int) Math.floor(pacmanPosition.getX() / MazeCreator.RESIZING_FACTOR);
        int yTilePacman = (int) Math.floor(pacmanPosition.getY() / MazeCreator.RESIZING_FACTOR);
        int xTileGhost = (int) Math.floor(ghost.getCenter().getX() / MazeCreator.RESIZING_FACTOR);
        int yTileGhost = (int) Math.floor(ghost.getCenter().getY() / MazeCreator.RESIZING_FACTOR);

        double distance = Vector2D.calculateEuclideanDistance(new Vector2D(xTilePacman, yTilePacman), new Vector2D(xTileGhost, yTileGhost));
        if (distance > 8) {
            return pacmanPosition;
        }
        return ghost.getTargetCorner();
    }
}
