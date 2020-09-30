package Homework2;

public class MyArrayDataException extends RuntimeException {
    private int row; // Строка матрицы где ошибка
    private int col; // Столбец матрицы где ошибка

    public MyArrayDataException(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public MyArrayDataException(String message, int row, int col) {
        super(message);
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}