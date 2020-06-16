package lesson1.marathon;

import lesson1.marathon.interfaces.Obstacle;
import lesson1.marathon.interfaces.Dynamic;
import lesson1.marathon.obstacles.RunTrack;
import lesson1.marathon.obstacles.Wall;
import lesson1.marathon.players.Cat;
import lesson1.marathon.players.Human;
import lesson1.marathon.players.Robot;

public class Main1 {

    public static void main(String[] args) {

        Dynamic[] dynamics = {
          new Cat("Murka", 400, 3),
          new Robot("Werter", 20_000, 0),
          new Human("Peter", 5_000, 2)
        };

        Obstacle[] obstacles = {
          new RunTrack(400),
          new Wall(2),
          new RunTrack(3000)
        };

        for (Dynamic dynamic : dynamics) {
            System.out.println();
            for (Obstacle obstacle : obstacles) {
                obstacle.overcomeObstacles(dynamic);
                if(!dynamic.isOnDistance()){
                    break;
                }
            }
        }


    }
}
