package lesson1.marathon.players;

import lesson1.marathon.interfaces.Dynamic;
import lesson1.marathon.utilites.PrintMessage;

public class Cat implements Dynamic {

    private final String name;
    private final int distanceRun;
    private final int heightJump;
    private boolean onDistance;

    public Cat(String name, int distanceRun, int heightJump) {
        this.name = name;
        this.distanceRun = distanceRun;
        this.heightJump = heightJump;
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
