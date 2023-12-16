package oncall.domain;

public class EmergencyWorkMonth {
    private int month;
    private String startDate;

    public EmergencyWorkMonth(String month, String startDate) {
        validateMonth(month);
        this.month = convertMonth(month);
        this.startDate = startDate;
    }

    private Calender getCalenderByMonth(int month) {
        for (Calender calender : Calender.values()) {
            if (calender.getMonth() == month) {
                return calender;
            }
        }
        return null;
    }

    private Week getWeekByStartDate(String startDate) {
        for (Week week : Week.values()) {
            if (week.getDate().equals(startDate)) {
                return week;
            }
        }
        return null;
    }

    private void validateMonth(String month) {
        validateNumeric(month);
    }

    private void validateNumeric(String month) {
        try {
            Integer.parseInt(month);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public int getMonth() {
        return month;
    }

    private int convertMonth(String month) {
        return Integer.parseInt(month);
    }

    public String getStartDate() {
        return startDate;
    }
}
