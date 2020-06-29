package lesson5;

import java.util.Arrays;

public class Main5 {

    static final int size = 10_000_000;
    static final int h = size / 2;

    public static void main(String[] args) {

        float[] arr = new float[size];
        countingTimeOneThread(arr);
        countingTimeTwoThread(arr);
    }

    static void countingTimeOneThread(float... arr) {
        Arrays.fill(arr, 1f);

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();

        System.out.println(b - a);
    }

    static void countingTimeTwoThread(float... arr) {
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();

        float[] partOne = new float[h];
        float[] partTwo = new float[h];
        System.arraycopy(arr, 0, partOne, 0, h);
        System.arraycopy(arr, 0, partOne, 0, h);

        new Thread(() -> {
            for (int i = 0; i < partOne.length; i++) {
            partOne[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < partTwo.length; i++) {
            partTwo[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }).start();

        System.arraycopy(partOne, 0, arr, 0, h);
        System.arraycopy(partTwo, 0, arr, h, h);
        long b = System.currentTimeMillis();

        System.out.println(b - a);

    }

}
