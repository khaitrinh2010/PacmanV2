package pacman.model.entity.dynamic.ghost;

/***
 * Represents the different modes of ghosts, which determines how ghosts choose their target locations
 */
public enum GhostMode {
    SCATTER,
    FRIGHTENED,
    CHASE;



    /**
     * Ghosts alternate between SCATTER, CHASE, and FRIGHTENED modes
     *
     * @param ghostMode current ghost mode
     * @return next ghost mode
     */
    public static GhostMode getNextGhostMode(GhostMode ghostMode) {
        return switch (ghostMode) {
            case SCATTER -> CHASE;
            case CHASE -> SCATTER;
            case FRIGHTENED -> SCATTER;
        };
    }
}
