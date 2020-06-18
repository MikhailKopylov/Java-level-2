package lesson2;

public class MyArraySizeException extends Exception{

    private int wrongLength;
    private int wrongLine;

    public MyArraySizeException(String message, int wrongLength, int wrongLine) {
        super(message);
        this.wrongLength = wrongLength;
        this.wrongLine = wrongLine;
    }

    public int getWrongLength() {
        return wrongLength;
    }

    public int getWrongLine() {
        return wrongLine;
    }
}
