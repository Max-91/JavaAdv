package Homework2;
/*
1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
 при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или
  текст вместо числа), должно быть брошено исключение MyArrayDataException – с детализацией,
   в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
и MyArrayDataException и вывести результат расчета.
 */

public class MainClass {
    public static void main(String[] args) {
        String[][] myMatrix = {
                {"5", "1", "3", "3"},
                {"55", "31", "14", "23"},
                {"2", "31", "5", "8"},
                {"3", "8", "40", "6"},
        };
        try {
            testSizeMatrix(myMatrix);
            testElementsMatrix(myMatrix);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("!!! Ошибка: "+e.getMessage());
        }
    }

    public static void testSizeMatrix(String[][] matrix) {
        if (matrix.length!=4) {
            throw new MyArraySizeException("Кол-во строк "+matrix.length +", а должно быть 4", matrix.length);
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length!=4) {
                throw new MyArraySizeException("Кол-во элементов "+matrix[i].length +" в "+(i+1)+" строке, а должно быть 4", i);
            }
        }
        System.out.println("Матрица правильного размера 4x4");
    }

    public static void testElementsMatrix(String[][] matrix) {
        int sum=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try{
                    sum+=Integer.parseInt(matrix[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("В строке "+(i+1) +" в "+(j+1)+" элементе находится не число", i,j);
                }
            }
        }
        System.out.println("Сумма всех элементов = "+sum);
    }

}

