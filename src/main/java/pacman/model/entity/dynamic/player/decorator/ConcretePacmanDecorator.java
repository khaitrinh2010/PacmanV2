package pacman.model.entity.dynamic.player.decorator;
import pacman.model.entity.dynamic.player.Pacman;
import pacman.model.entity.dynamic.player.Controllable;

public class ConcretePacmanDecorator extends PacmanDecorator {
    public ConcretePacmanDecorator(Controllable pacman) {
        super(pacman);
    }
}
