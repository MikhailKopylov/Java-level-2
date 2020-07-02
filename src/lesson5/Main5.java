package lesson5;

import java.util.Arrays;

public class Main5 {

    static final int size = 10_000_000;
    static final int h = size / 2;

    static private float elem1;
    static private float elem2;

    public static void main(String[] args) {

        float[] arr = new float[size];
        countingTimeOneThread(arr);
        countingTimeTwoThread(arr);
        System.out.println("elemArr1  " + elem1);
        System.out.println("elemArr2 " + elem2);
    }

    static void countingTimeOneThread(float... arr) {
        Arrays.fill(arr, 1f);

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        elem1 = arr[h];
        System.out.printf("1 thread = %d ms\n", b - a);
    }

    static void countingTimeTwoThread(float... arr) {
        Arrays.fill(arr, 1f);
        long a = System.currentTimeMillis();

        float[] partOne = new float[h];
        float[] partTwo = new float[h];
        System.arraycopy(arr, 0, partOne, 0, h);
        System.arraycopy(arr, 0, partTwo, 0, h);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < partOne.length; i++) {
                partOne[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < partTwo.length; i++) {
                int j = i + h;
                partTwo[i] = (float) (arr[i] * Math.sin(0.2f + j / 5) *
                        Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
            }
        });
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(partOne, 0, arr, 0, h);
        System.arraycopy(partTwo, 0, arr, h, h);
        long b = System.currentTimeMillis();

        System.out.printf("2 thread = %d ms\n", b - a);
        elem2 = arr[h];

    }

}
