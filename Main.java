//1. Задать одномерный массив и найти в нем минимальный и максимальный
//        элементы
//2. Написать метод, который определяет, является ли введенный пользователем год високосным,
//        и возвращает в консоль boolean (високосный - true, не високосный - false).
//        Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й
//        – високосный.
//3. Дан массив nums = [3,2,2,3] и число val = 3.
//        Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец
//        массива. Таким образом, первые несколько (или все) элементов массива должны быть
//        отличны от заданного, а остальные - равны ему.


package home_work1;

import java.util.Random;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        task_1();
        task_2();
        task_3();




    }

    private static boolean isLeap(int year) {
        if ((year%4 == 0 && year%100 != 0) || year%400 ==0){
            return true;
        }
        return false;
    }

    private static void PrintArray(int array[]) {
        for (int i : array){
            System.out.print(i);
        }
        System.out.println();
    }

    private static int[] RandomArray(int countElements, int start, int end) {
        int[] arr = new int[countElements];
        int counter = 0;
        int maxLength = 0;
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(start, end); //[0;2)
        }
        return arr;
    }

    private static void task_3() {
        System.out.println("\nTask_3:");
        int[] array = RandomArray(20,  0, 5);
        PrintArray(array);
        int left = 0;
        int right = array.length-1;
        int temp;
        //System.out.println(left);
        //System.out.println(right);
        while (right > left){
            if (array[left] == 3 && array[right] != 3){
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            } else if (array[left] != 3) {
                left++;
            } else if (array[right] == 3) {
                right--;
            } else if (right <= left) {
                break;
            }
        }
        PrintArray(array);


    }

    private static void task_2() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\nTask_2:\nEnter a year: ");
        int year = scan.nextInt();
        //System.out.println(year);
        System.out.println(isLeap(year));

    }

    private static void task_1() {
        System.out.println("\nTask_1:");
        int[] array = RandomArray(10, 0, 10);
        PrintArray(array);
        int min = array[0];
        int max = array[0];
        for (int item: array){
            if (item < min){
                min = item;
            }
            if (item > max){
                max = item;
            }
        }
        System.out.printf("min = %s, max = %s", min, max);

    }

}
