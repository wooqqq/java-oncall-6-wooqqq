package oncall.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Week {
    WEEKDAY("월,화,수,목,금", false),
    WEEKEND("토,일", true);

    private static final String SEPARATOR = ",";
    private final String date;
    private final boolean isWeekend;

    Week(String date, boolean isWeekend) {
        this.date = date;
        this.isWeekend = isWeekend;
    }

    public List<String> parseDate(String input) {
        return new ArrayList<>(Arrays.asList(input.split(SEPARATOR)));
    }

    public List<String> getDate() {
        return parseDate(date);
    }

    public boolean getIsWeekend() {
        return isWeekend;
    }
}
