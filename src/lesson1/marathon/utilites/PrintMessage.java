package lesson1.marathon.utilites;

public class PrintMessage {

    public static void canRun(String name, int distance) {
        System.out.printf("%s пробежал дистанцию %d м.\n", name, distance);
    }

    public static void cantRun(String name, int distance) {
        System.out.printf("%s не смог пробежать дистанцию %d м. и сошел с дистанции\n", name, distance);
    }

    public static void canJump(String name, int height) {
        System.out.printf("%s прыгнул на высоту %d м.\n", name, height);
    }

    public static void cantJump(String name, int height) {
        System.out.printf("%s не смог прыгнуть на высоту %d м. и сошел с дистанции\n", name, height);
    }
}