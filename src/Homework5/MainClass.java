package Homework5;

import javax.naming.PartialResultException;
import java.util.Arrays;

/*
1) Создают одномерный длинный массив, например:
static final int size = 10000000;
static final int h = size / 2;
float[] arr = new float[size];
2) Заполняют этот массив единицами;
3) Засекают время выполнения: long a = System.currentTimeMillis();
4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
5) Проверяется время окончания метода System.currentTimeMillis();
6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 */
public class MainClass {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] arr = new float[SIZE];

    public static void firstMethod(float[] arr) {
        long a = System.currentTimeMillis(); // Фиксация времени начала
        // Вычисления
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        // Вывод инфо
        System.out.println(" Время выполнения по первому методу: " + (System.currentTimeMillis() - a) + " мсек");
    }

    public static void secondMethod(float[] arr) {
        long a = System.currentTimeMillis(); // Фиксация времени начала
        int half = arr.length / 2;
        float subArr1[] = new float[half];
        float subArr2[] = new float[half];
        // Разбивка исходного массива на два массива
        System.arraycopy(arr, 0, subArr1, 0, half);
        System.arraycopy(arr, half, subArr2, 0, half);
        // Вычисления
        // Первый поток
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < half; i++) {
                subArr1[i] = (float) (subArr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
        );
        // Второй поток
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < half; i++) {
                subArr2[i] = (float) (subArr2[i] * Math.sin(0.2f + (half + i) / 5) * Math.cos(0.2f + (half + i) / 5) * Math.cos(0.4f + (half + i) / 2));
            }
        }
        );
        // Выполнение потоков и ожидание их завершения
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Склейка массивов
        System.arraycopy(subArr1, 0, arr, 0, half);
        System.arraycopy(subArr2, 0, arr, half, half);
        // Вывод инфо
        System.out.println(" Время выполнения по второму методу: " + (System.currentTimeMillis() - a) + " мсек");
    }

    public static void main(String[] args) {
        Arrays.fill(arr, 1);
        firstMethod(arr);
        Arrays.fill(arr, 1);
        secondMethod(arr);
    }
}
