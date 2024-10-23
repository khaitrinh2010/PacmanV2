package pacman.model.factories;

import javafx.scene.image.Image;
import pacman.model.entity.Renderable;
import pacman.model.entity.dynamic.physics.BoundingBoxImpl;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.entity.staticentity.collectable.SuperPellet;

public class SuperPelletFactory extends PelletFactory {
    public SuperPelletFactory() {
        PELLET_IMAGE = doubleImageSize(PELLET_IMAGE);
    }
    @Override
    public Renderable createRenderable(Vector2D position) {
        position = new Vector2D(position.getX() - 8, position.getY() - 8);
        return new SuperPellet(
                new BoundingBoxImpl(
                        position,
                        PELLET_IMAGE.getHeight(),
                        PELLET_IMAGE.getWidth()
                ),
                layer,
                PELLET_IMAGE,
                NUM_POINTS
        );
    }
    private Image doubleImageSize(Image image) {
        return new Image(image.getUrl(), image.getWidth() * 2, image.getHeight() * 2, true, true);
    }
}
