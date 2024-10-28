package pacman.model.level;

/**
 * Handler for the score when pacman eat ghost in frightened mode
 */
public interface FrightenedModeHandler {
    /**
     * get how many ghost has been eaten in a row
     * @return the number of ghost eaten in a row
     */
    int getStreakCount();

    /**
     * increment the score by the given amount
     * @param scoreIncremented, the amount to increment the score by
     */
    void incrementScore(int scoreIncremented);

    /**
     * increment the number of ghost eaten in a row, reset if all ghost are eaten
     */
    void incrementGhostStreak();

}
