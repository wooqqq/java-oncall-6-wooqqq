package oncall.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Calender {
    JANUARY(1, 31, true, "1"),
    FEBRUARY(2, 28, false, null),
    MARCH(3, 31, true, "1"),
    APRIL(4, 30, false, null),
    MAY(5, 31, true, "5"),
    JUNE(6, 30, true, "6"),
    JULY(7, 31, false, null),
    AUGUST(8, 31, true, "15"),
    SEPTEMBER(9, 30, false, null),
    OCTOBER(10, 31, true, "3,9"),
    NOVEMBER(11, 30, false, null),
    DECEMBER(12, 31, true, "25");

    private static final String SEPARATOR = ",";
    private final int month;
    private final int date;
    private final boolean hasHoliday;
    private final String holidayDate;

    Calender(int month, int date, boolean hasHoliday, String holidayDate) {
        this.month = month;
        this.date = date;
        this.hasHoliday = hasHoliday;
        this.holidayDate = holidayDate;
    }

    public List<String> parseHolidayDate(String input) {
        return new ArrayList<>(Arrays.asList(input.split(SEPARATOR)));
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public boolean getHasHoliday() {
        return hasHoliday;
    }

    public List<String> getHolidayDate() {
        return parseHolidayDate(holidayDate);
    }
}
