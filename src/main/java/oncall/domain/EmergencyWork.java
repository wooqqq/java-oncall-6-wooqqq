package oncall.domain;

public class EmergencyWork {
    private final EmergencyWorkMonth workMonth;
    private final Employees weekdayEmployee;
    private final Employees holidayEmployee;

    public EmergencyWork(EmergencyWorkMonth workMonth, Employees weekdayEmployee, Employees holidayEmployee) {
        this.workMonth = workMonth;
        this.weekdayEmployee = weekdayEmployee;
        this.holidayEmployee = holidayEmployee;
    }
}
