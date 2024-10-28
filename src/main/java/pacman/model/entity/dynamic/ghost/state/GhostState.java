package pacman.model.entity.dynamic.ghost.state;


import javafx.scene.image.Image;
import pacman.model.entity.Renderable;
import pacman.model.level.Level;


public interface GhostState {
    Image getImage();

    /**
     * Handle collision for the ghost in the corresponding state, in frightened mode, ghost will be eaten
     * @param entity
     */
    void handleCollide(Level level, Renderable entity);


    /**
     * Update the direction for corresponding state, in frightened state, ghost will randomly select the direction
     */
    void update();

    void resetCurrentStateAndTransist();
}
