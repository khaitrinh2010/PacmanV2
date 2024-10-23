package pacman.model.entity.dynamic.ghost.state;


import javafx.scene.image.Image;
import pacman.model.entity.Renderable;

public interface GhostState {
    Image getImage();
    void handleCollide(Renderable entity);

    void update();
}
