package lesson2;

import lesson3.hw2.MyArrayDataException;
import lesson3.hw2.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"1", "2", "3", "4"}, {"2", "2", "2", "3"}, {"1", "2", "2", "2"}, {"2", "2", "2", "2"}};
        try {
            try {
                int result = method(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива превышен!");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неправильное значение массива!");
                   }

    }
    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException("ошибка");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("ошибка");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("ошибка");
                }
            }

        }
        return count;
    }
}




