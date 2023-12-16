package oncall.domain;

import java.util.*;

public class EmergencyWork {
    private static final int START_DAY = 1;
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

    public List<Integer> setHoliday(EmergencyWorkMonth workMonth) {
        List<Integer> holiday = new ArrayList<>();
        Calender calender = workMonth.getCalender();
        int lastDay = calender.getDate();
        for (int day = 0; day < lastDay; day++) {
            if (isWeekend(day) == 6 || isWeekend(day) == 0) {
                holiday.add(day);
            }
            if (calender.convertHolidayDate().contains(day)) {
                holiday.add(day);
            }
        }
        return holiday;
    }

    public Map<Integer, String> setHolidayEmployees(EmergencyWork emergencyWork) {
        Map<Integer, String> holidayEmployees = new HashMap<>();
        List<Integer> holidays = setHoliday(emergencyWork.getWorkMonth());
        List<String> employees = emergencyWork.holidayEmployee.getEmployees();
        for (int i = 0; i < holidays.size(); i++) {
            int holiday = holidays.get(i);
            String employee = employees.get(i % employees.size());
            holidayEmployees.put(holiday, employee);
        }
        return holidayEmployees;
    }

    private int isWeekend(int day) {
        return (day + 1) % 7;
    }
}
