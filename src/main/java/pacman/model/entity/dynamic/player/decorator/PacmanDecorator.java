package pacman.model.entity.dynamic.player.decorator;

import javafx.scene.image.Image;
import pacman.model.entity.Renderable;
import pacman.model.entity.dynamic.physics.BoundingBox;
import pacman.model.entity.dynamic.physics.Direction;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.entity.dynamic.player.Controllable;
import pacman.model.entity.dynamic.player.Pacman;
import pacman.model.entity.dynamic.player.observer.PlayerPositionObserver;
import pacman.model.level.Level;

import java.util.Set;

public abstract class PacmanDecorator implements Controllable, Component {
    protected Controllable pacman;
    public PacmanDecorator(Controllable pacman) {
        this.pacman = pacman;
    }
    @Override
    public Image getImage() {
        return this.pacman.getImage();
    }

    @Override
    public double getWidth() {
        return this.pacman.getWidth();
    }

    @Override
    public double getHeight() {
        return this.pacman.getHeight();
    }

    @Override
    public Vector2D getPosition() {
        return this.pacman.getPosition();
    }

    @Override
    public Layer getLayer() {
        return this.pacman.getLayer();
    }

    @Override
    public BoundingBox getBoundingBox() {
        return this.pacman.getBoundingBox();
    }

    @Override
    public void reset() {
        this.pacman.reset();
    }

    @Override
    public void update() {
        this.pacman.update();
    }

    @Override
    public Vector2D getPositionBeforeLastUpdate() {
        return this.pacman.getPositionBeforeLastUpdate();
    }

    @Override
    public void setPosition(Vector2D position) {
        this.pacman.setPosition(position);
    }

    @Override
    public boolean collidesWith(Renderable renderable) {
        return this.pacman.collidesWith(renderable);
    }

    @Override
    public void collideWith(Level level, Renderable renderable) {
        this.pacman.collideWith(level, renderable);
    }

    @Override
    public void setPossibleDirections(Set<Direction> possibleDirections) {
        this.pacman.setPossibleDirections(possibleDirections);
    }

    @Override
    public Direction getDirection() {
        return this.pacman.getDirection();
    }

    @Override
    public Vector2D getCenter() {
        return this.pacman.getCenter();
    }

    @Override
    public void up() {
        this.pacman.up();
    }

    @Override
    public void down() {
        this.pacman.down();
    }

    @Override
    public void left() {
        this.pacman.left();
    }

    @Override
    public void right() {
        this.pacman.right();
    }

    @Override
    public void setSpeed(double speed) {
        this.pacman.setSpeed(speed);
    }

    @Override
    public void switchImage() {
        this.pacman.switchImage();
    }

    @Override
    public void registerObserver(PlayerPositionObserver observer) {
        this.pacman.registerObserver(observer);
    }

    @Override
    public void removeObserver(PlayerPositionObserver observer) {
        this.pacman.removeObserver(observer);
    }

    @Override
    public void notifyObservers() {
        this.pacman.notifyObservers();
    }

    public Pacman getPacman() {
        return (Pacman) this.pacman;
    }

    /**
     * More additional responsibilities
     */
}
