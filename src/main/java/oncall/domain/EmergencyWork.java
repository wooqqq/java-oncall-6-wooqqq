package oncall.domain;

public class EmergencyWork {
    private final EmergencyWorkMonth workMonth;
    private final Employees weekdayEmployee;
    private final Employees holidayEmployee;
    private int month;
    private int lastDay;

    public EmergencyWork(EmergencyWorkMonth workMonth, Employees weekdayEmployee, Employees holidayEmployee) {
        Calender calender = workMonth.getCalender();
        this.workMonth = workMonth;
        this.weekdayEmployee = weekdayEmployee;
        this.holidayEmployee = holidayEmployee;
        this.month = calender.getMonth();
        this.lastDay = calender.getDate();
    }

    public EmergencyWorkMonth getWorkMonth() {
        return workMonth;
    }
}
