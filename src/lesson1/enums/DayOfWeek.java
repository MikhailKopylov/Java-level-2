package lesson1.enums;

public enum DayOfWeek {

    Sunday(0), Monday(1), Tuesday(2),
    Wednesday(3), Thursday(4), Friday(5),
    Saturday(6);

    private final int numberDay;

    DayOfWeek(int numberDay) {
        this.numberDay = numberDay;
    }

    public int getNumberDay() {
        return numberDay;
    }

    public boolean isHoliday(){
        return (this == Sunday || this == Saturday);
    }


}
