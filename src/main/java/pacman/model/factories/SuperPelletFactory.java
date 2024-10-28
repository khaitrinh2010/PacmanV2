package pacman.model.factories;

import javafx.scene.image.Image;
import pacman.model.entity.Renderable;
import pacman.model.entity.dynamic.physics.BoundingBoxImpl;
import pacman.model.entity.dynamic.physics.Vector2D;
import pacman.model.entity.staticentity.collectable.SuperPellet;

/**
 * Concrete renderable factory for SuperPellet objects
 */
public class SuperPelletFactory extends PelletFactory {
    public SuperPelletFactory() {
        NUM_POINTS = 50;
        PELLET_IMAGE = doubleImageSize(PELLET_IMAGE); // Double the size of the image
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

    /**
     * Doubles the size of the image
     * @param image, the image to double
     * @return the doubled image
     */
    private Image doubleImageSize(Image image) {
        return new Image(image.getUrl(), image.getWidth() * 2, image.getHeight() * 2, true, true);
    }
}
