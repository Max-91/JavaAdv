package Homework2;

public class MyArraySizeException extends RuntimeException {
    private int row; // Номер строки в которой проблема

    public MyArraySizeException(int row) {
        this.row = row;
    }

    public MyArraySizeException(String message, int row) {
        super(message);
        this.row = row;
    }

    public int getRow() {
        return row;
    }


}