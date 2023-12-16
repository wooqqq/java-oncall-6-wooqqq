package oncall.domain;

public class EmergencyWorkMonth {
    private int month;
    private String startDate;

    public EmergencyWorkMonth(int month, String startDate) {
        this.month = month;
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
            if (week.getDate().contains(startDate)) {
                return week;
            }
        }
        return null;
    }
}
