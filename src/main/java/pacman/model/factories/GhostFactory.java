package pacman.model.factories;

import javafx.scene.image.Image;
import pacman.ConfigurationParseException;
import pacman.model.entity.Renderable;
import pacman.model.entity.dynamic.ghost.Ghost;
import pacman.model.entity.dynamic.ghost.GhostImpl;
import pacman.model.entity.dynamic.ghost.GhostMode;
import pacman.model.entity.dynamic.physics.*;

import java.util.Arrays;
import java.util.List;

/**
 * Concrete renderable factory for Ghost objects
 */
public class GhostFactory implements RenderableFactory {

    protected static final int RIGHT_X_POSITION_OF_MAP = 448;
    protected static final int TOP_Y_POSITION_OF_MAP = 16 * 3;
    protected static final int BOTTOM_Y_POSITION_OF_MAP = 16 * 34;

    protected static final Image BLINKY_IMAGE = new Image("maze/ghosts/blinky.png");
    protected static final Image INKY_IMAGE = new Image("maze/ghosts/inky.png");
    protected static final Image CLYDE_IMAGE = new Image("maze/ghosts/clyde.png");
    protected static final Image PINKY_IMAGE = new Image("maze/ghosts/pinky.png");
    protected Image GHOST_IMAGE = BLINKY_IMAGE;
    List<Vector2D> targetCorners = Arrays.asList(
            new Vector2D(0, TOP_Y_POSITION_OF_MAP),
            new Vector2D(RIGHT_X_POSITION_OF_MAP, TOP_Y_POSITION_OF_MAP),
            new Vector2D(0, BOTTOM_Y_POSITION_OF_MAP),
            new Vector2D(RIGHT_X_POSITION_OF_MAP, BOTTOM_Y_POSITION_OF_MAP)
    );

    protected Vector2D targetCorner; // The corner of the map that the ghost is targeting

    @Override
    public Renderable createRenderable(
            Vector2D position
    ) {
        try {
            position = position.add(new Vector2D(4, -4));

            BoundingBox boundingBox = new BoundingBoxImpl(
                    position,
                    GHOST_IMAGE.getHeight(),
                    GHOST_IMAGE.getWidth()
            );

            KinematicState kinematicState = new KinematicStateImpl.KinematicStateBuilder()
                    .setPosition(position)
                    .build();

            return createGhost(boundingBox, kinematicState);
        } catch (Exception e) {
            throw new ConfigurationParseException(
                    String.format("Invalid ghost configuration | %s ", e));
        }
    }

    public Ghost createGhost(BoundingBox boundingBox, KinematicState kinematicState) {
        return new GhostImpl(GHOST_IMAGE, boundingBox, kinematicState, GhostMode.SCATTER, targetCorner);
    }
}
