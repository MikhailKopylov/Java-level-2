package lesson1.marathon.obstacles;

import lesson1.marathon.interfaces.Dynamic;
import lesson1.marathon.interfaces.Obstacle;

public class Wall implements Obstacle {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void overcomeObstacles(Dynamic overcoming) {
        overcoming.jump(height);
    }
}
