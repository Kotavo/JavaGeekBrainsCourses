package Theme2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    // Для удобства проверки рекомендую запустить метод main,
    // который выведет на экран результаты всех заданий
    // Входные данные я выбирал самостоятельно, но при желании вы можете изменить их непосредсвтенно в коде.

    public static void main(String[] args) {

        // task 1
        System.out.println("Task 1: " );
        int[] arr1 = {0,0,1,1,0,1,1,0,0,1};
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = (arr1[i] == 0)  ? 1 : 0;
            System.out.print(arr1[i] + " ");
        }

        // task 2
        System.out.println('\n' + "Task 2: ");  // перенос строки для удобства вывода в консоль
        int[] arr2 = new int[8];
        for (int i = 0, j = 0; i < arr2.length; i++, j+=3){
            arr2[i] = j;
            System.out.print(arr2[i] + " ");
        }

        // task 3
        System.out.println('\n' + "Task 3: ");
        int[] arr3 ={1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++){
            if(arr3[i] < 6) {
                arr3[i] *= 2;
            }
            System.out.print(arr3[i] + " ");
        }

        // task 4
        System.out.println('\n' + "Task 4: ");
        int[][] arr4 = new int[5][5];
        for(int i = 0; i < arr4.length; i++){
            arr4[i][i] = 1;
            arr4[i][arr4.length - i - 1] = 1;
            }
        // распечатка массива
        for(int i = 0; i < arr4.length; i ++){
            for(int j = 0; j < arr4.length; j++){
                System.out.print(arr4[i][j] + "\t");
            }
            System.out.println();
        }


        // task 5
        System.out.println('\n' + "Task 5: ");
        int[] arr5 = {3,5,6,1,12,16,27,72,4,8,1};
        int min = arr5[0];
        int max = arr5[0];
        System.out.println("Array: ");
        for(int i = 0; i < arr5.length; i++){
            if(arr5[i] < min) {
                min = arr5[i];
            }
            if(arr5[i] > max){
                max = arr5[i];
            }
            System.out.print(arr5[i] + " ");
        }
        System.out.println('\n' + "min: " + min + '\n' + "max: " + max);

        // task 6
        System.out.println('\n' + "Task 6: ");
        int[] arr6 = {1,1,1,2,1};
        int[] arr6test = {2,1,1,2,1};
        int[] arrTest = {10,10};
        System.out.println("Для массива {1,1,1,2,1} - " + Task6Method(arr6));
        System.out.println("Для массива {2,1,1,2,1} - " + Task6Method(arr6test));
        System.out.println("Для массива {10,10} - " + Task6Method(arrTest));

        // task7
        System.out.println('\n' + "Task 7: ");
        int[] arr7 = {1,2,3,4,5,6,7,8,9,10};
        int[] arr7test = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Тестовй массив - {1,2,3,4,5,6,7,8,9,10}" + '\n' + "Колличество сдвигов: 2");
        arr7 = task7Method(arr7,2);
        System.out.println("Результат: ");
        for(int i = 0; i < arr7.length; i ++){
            System.out.print(arr7[i] + " ");
        }
        System.out.println('\n' + "Тестовй массив - {1,2,3,4,5,6,7,8,9,10}" + '\n' + "Колличество сдвигов: -3");
        arr7test = task7Method(arr7test, -3);
        System.out.println("Результат: ");
        for(int i = 0; i < arr7test.length; i ++){
            System.out.print(arr7test[i] + " ");
        }

    }

    // task 6 method
    public static boolean Task6Method(int[] arr){
        int rightPart = 0;
        int leftPart = arr[0];
        boolean flag = false;
        // Вычисляем сумму всех элементов массива, кроме первого
        for(int i = 1; i < arr.length; i++){
            rightPart += arr[i];
        }
        // Сравниваем 1 элемент с суммой всех остальных, если половинки не равны, то
        // Добавляем к первому элементу второй, а из "правой" части вычитаем второй и т.д
        // Если находим равенство "частей", то выходим из цикла и возвращаем true.
        for(int i = 1; i < arr.length; i++){
            if(leftPart == rightPart){
                flag = true;
            }
            leftPart += arr[i];
            rightPart -= arr[i];
        }
        return flag;
    }

    // task 7 method
    public static int[] task7Method(int[] arr, int n) {
        // Если кол-во сдвигов равно 0 или кратно длинне массива, то возвращаем исходный массив
        if ((n == 0) || (n % arr.length == 0)) {
            return arr;
        }

        // Если число сдвигов по модулю больше длинны массива, убираем лишние проходы по массиву.
        if (Math.abs(n) > arr.length) {
            n = n % arr.length;
        }

        // Сам алгоритм представляет сдвиг элементов на один вправо ( лево, если n < 0 ) n раз.
        int temp = 0;
        if (n > 0) {

            for(int i = 0; i < n; i++){
                temp = arr[0];
                arr[0] = arr[arr.length-1];
                for( int j = 1; j < arr.length -1; j++){
                    arr[arr.length-j] = arr[arr.length - j - 1];
                }
                arr[1] = temp;
            }
            return arr;
        }
        else {
           for(int i = 0; i > n; i--){
               temp = arr[arr.length-1];
               arr[arr.length-1] = arr[0];
               for(int j = 1; j < arr.length - 1; j++){
                   arr[j-1] = arr[j];
               }
               arr[arr.length - 2] = temp;
           }
            return arr;
        }
    }
}
