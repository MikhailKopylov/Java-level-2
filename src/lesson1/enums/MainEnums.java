package lesson1.enums;

public class MainEnums {

    public static void main(String[] args) {

        DayOfWeek[] dayOfWeeks = DayOfWeek.values();

        for (DayOfWeek dayOfWeek : dayOfWeeks) {
            System.out.println(getWorkingHours(dayOfWeek));
        }

    }

    private static String getWorkingHours(DayOfWeek dayOfWeek) {
        if (dayOfWeek.isHoliday()) {
            return dayOfWeek + " - сегодня выходной";
        }
        int countWorkingHours = (DayOfWeek.Saturday.getNumberDay() - dayOfWeek.getNumberDay()) * 8;
        return dayOfWeek + ": количество рабочих часов до конца недели составляет: " + countWorkingHours;
    }
}
