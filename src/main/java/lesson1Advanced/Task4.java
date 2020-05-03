package lesson1Advanced;

/*
Семантическое версионирование
Реализовать метод который принимает на вход две строки
с версиями программы ("1.0.1.2", "1.1.1.2")
и возвращает версию более ранней
Подсказка - для решения строки надо разбить на массивы
Про семантическое версионирование почитать можно здесь https://semver.org/lang/ru/
*/

public class Task4 {

    public static void main(String[] args) {
        String lovestVersion = minVersion("1.0.0.1.2", "1.0.0.2.2");
        System.out.println(lovestVersion);
    }

    public static String minVersion(String v1, String v2) {
        String[] v1arr = v1.split(".");
        String[] v2arr = v2.split(".");
        String result = v1;
        for (int i = 0; i < v1arr.length; i++) {
            if (Integer.parseInt(v1arr[i]) < Integer.parseInt(v2arr[i])) {
                break;
            }
            else if (Integer.parseInt(v1arr[i]) > Integer.parseInt(v2arr[i])) {
                result = v2;
                break;
            }
        }
        return result;
    }
}