package main.java.lesson1Advanced;

public class Task1 {
    /* Минимум n чисел
    Написать функцию, которая вычисляет минимум из массива чисел.
    */
    public static void main(String[] args) {
        int[] a = {2,4,6};
        int[] b = {2,4,6,1,90,2,0};
        System.out.println(min(a));
        System.out.println(min(b));
    }

    public static int min(int[] a) {
        int result = a[0];
        for (int i = 1; i < a.length; i++) {
            if (result > a[i]) { result = a[i]; }
        }
        return result;
    }
}
