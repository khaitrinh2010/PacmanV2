package pacman.model.entity.dynamic.ghost.state;

import javafx.scene.image.Image;
import pacman.model.entity.Renderable;
import pacman.model.entity.dynamic.ghost.Ghost;
import pacman.model.entity.dynamic.ghost.GhostMode;
import pacman.model.entity.dynamic.physics.Direction;
import pacman.model.entity.dynamic.physics.KinematicState;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.maze.Maze;

import java.util.*;

import static pacman.model.entity.dynamic.ghost.GhostImpl.minimumDirectionCount;


public class FrightenedState implements GhostState{
    private final Ghost ghost;

    private static FrightenedState instance;

    private static double DURATION = 0;

    private double duration;

    private final Image frightenedImage =  new Image("maze/ghosts/frightened.png");
    public FrightenedState(Ghost ghost){
        this.ghost = ghost;
    }
    @Override
    public Image getImage() {
        return frightenedImage;
    }
    @Override
    public void handleCollide(Renderable entity) {

    }
    @Override
    public void update() {
        if (this.duration <= 0){
            this.duration = DURATION;
            ghost.setState(ghost.getRegularState());
            ghost.setGhostMode(GhostMode.SCATTER);
            return;
        }
        this.updateDirection();
        ghost.getKinematicState().update();
        ghost.getBoundingBox().setTopLeft(ghost.getKinematicState().getPosition());
        this.duration -= 1;
    }

    public void setDuration(double duration) {
        this.duration = duration;
        DURATION = duration;
    }

    private void updateDirection() {
        // Ghosts update their target location when they reach an intersection
        if (Maze.isAtIntersection(ghost.getPossibleDirections())) {
            ghost.setTargetLocation(ghost.getTargetLocation());
        }

        Direction newDirection = selectDirection(ghost.getPossibleDirections());

        // Ghosts have to continue in a direction for a minimum time before changing direction
        if (ghost.getCurrentDirection() != newDirection) {
            ghost.setCurrentDirectionCount(0);
        }
        ghost.setCurrentDirection(newDirection);
        KinematicState kinematicState = ghost.getKinematicState();

        switch (ghost.getCurrentDirection()) {
            case LEFT -> kinematicState.left();
            case RIGHT -> kinematicState.right();
            case UP -> kinematicState.up();
            case DOWN -> kinematicState.down();
        }
    }

    private Direction selectDirection(Set<Direction> possibleDirections) {
        if (possibleDirections.isEmpty()) {
            return ghost.getCurrentDirection();
        }
        Direction currentDirection = ghost.getCurrentDirection();
        int currentDirectionCount = ghost.getCurrentDirectionCount();

        // ghosts have to continue in a direction for a minimum time before changing direction
        if (currentDirection != null && currentDirectionCount < minimumDirectionCount) {
            ghost.setCurrentDirectionCount(currentDirectionCount + 1);
            return currentDirection;
        }
        Map<Direction, Double> distances = new HashMap<>();
        KinematicState kinematicState = ghost.getKinematicState();
        for (Direction direction : possibleDirections) {
            // ghosts never choose to reverse travel
            if (currentDirection == null || direction != currentDirection.opposite()) {
                distances.put(direction, Vector2D.calculateEuclideanDistance(kinematicState.getPotentialPosition(direction), ghost.getTargetLocation()));
            }
        }

        // only go the opposite way if trapped
        if (distances.isEmpty()) {
            return currentDirection.opposite();
        }

        List<Direction> directions = new ArrayList<>(distances.keySet());

        // select the direction that will reach the target location fastest
        return directions.get(new Random().nextInt(directions.size()));
    }

}
