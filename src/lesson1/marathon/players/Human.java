package lesson1.marathon.players;

import lesson1.marathon.interfaces.Dynamic;
import lesson1.marathon.utilites.PrintMessage;

public class Human implements Dynamic {

    private final int distanceRun;
    private final int heightJump;
    private final String name;
    private boolean onDistance;

    public Human(String name, int distanceRun, int heightJump) {
        this.distanceRun = distanceRun;
        this.heightJump = heightJump;
        this.name = name;
        onDistance = true;
    }

    @Override
    public void run(int distance) {
        if(distanceRun >= distance){
            PrintMessage.canRun(name, distance);
        } else {
            PrintMessage.cantRun(name, distance);
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if(heightJump >= height){
            PrintMessage.canJump(name, height);
        } else {
            PrintMessage.cantJump(name, height);
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }
}
