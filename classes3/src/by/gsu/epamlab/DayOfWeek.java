package by.gsu.epamlab;

public enum DayOfWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
