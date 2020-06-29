package lesson1.marathon.obstacles;

import lesson1.marathon.interfaces.Dynamic;
import lesson1.marathon.interfaces.Obstacle;

public class RunTrack  implements Obstacle {

    private final int distance;

    public RunTrack(int distance) {
        this.distance = distance;
    }

    @Override
    public void overcomeObstacles(Dynamic overcoming) {
        overcoming.run(distance);
    }
}
