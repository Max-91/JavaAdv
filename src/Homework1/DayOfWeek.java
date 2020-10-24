package Homework1;

/* Задание:
 Требуется реализовать enum DayOfWeek, который будет представлять дни недели.
С его помощью необходимо решить задачу определения кол-ва рабочих часов до конца недели по заданному текущему дню.

 Возвращает кол-во оставшихся рабочих часов до конца
 недели по заданному текущему дню. Считается, что
 текущий день ещё не начался, и рабочие часы за него
 должны учитываться.
 Если заданный день выходной то вывести "Сегодня выходной"

public class DayOfWeekMain {
 public static void main(String[] args) {
 System.out.println(getWorkingHours(DayOfWeek.MONDAY));
 }
*/
public enum DayOfWeek {
    MONDAY(1), THUESDAY(2), WENSDAY(3), THURSDAY(4), FRIDAY(5), SATURTDAY(6), SUNDAY(7);
    private int dayOfWeek;

    DayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public static String getWorkingHours(DayOfWeek dayOfWeek) {
        if (dayOfWeek.getDayOfWeek() > 5) {
            return "Сегодня выходной";
        } else {
            return "Осталось " + ((6 - dayOfWeek.getDayOfWeek()) * 8) + " рабочих часов";
        }
    }
}
