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
            if (isWeekend(day) || isHoliday(calender.convertHolidayDate(), day)) {
                holiday.add(day);
            }
        }
        return holiday;
    }

    public List<Integer> setWeekday(EmergencyWorkMonth workMonth) {
        List<Integer> weekdays = new ArrayList<>();
        Calender calender = workMonth.getCalender();
        int lastDay = calender.getDate();
        for (int day = 1; day <= lastDay; day++) {
            if (!isWeekend(day) && !isHoliday(calender.convertHolidayDate(), day)) {
                weekdays.add(day);
            }
        }
        return weekdays;
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

    public Map<Integer, String> setWeekdayEmployees(EmergencyWork emergencyWork) {
        Map<Integer, String> weekdayEmployees = new HashMap<>();
        List<Integer> weekdays = setWeekday(emergencyWork.getWorkMonth());
        List<String> employees = emergencyWork.weekdayEmployee.getEmployees();
        for (int i = 0; i < weekdays.size(); i++) {
            int weekday = weekdays.get(i);
            String employee = employees.get(i % employees.size());
            weekdayEmployees.put(weekday, employee);
        }
        return weekdayEmployees;
    }

    public Map<Integer, String> mergeAndSort(EmergencyWork emergencyWork) {
        Map<Integer, String> weekday = setWeekdayEmployees(emergencyWork);
        Map<Integer, String> holiday = setHolidayEmployees(emergencyWork);
        Map<Integer, String> merge = new HashMap<>(weekday);
        merge.putAll(holiday);

        Map<Integer, String> sorted = new TreeMap<>(merge);

        return sorted;
    }

    public String getTheDayOfWeek(int day) {
        Week week = getWeekByDay(day);
        return week.getDate();
    }

    private Week getWeekByDay(int day) {
        int turn = (day + 1) % 7;
        return getWeekByTurn(turn);
    }

    private Week getWeekByTurn(int number) {
        for (Week week : Week.values()) {
            if (week.getTurn() == number) {
                return week;
            }
        }
        return null;
    }

    private boolean isWeekend(int day) {
        int turn = (day + 1) % 7;
        if (turn == 6 || turn == 0) {
            return true;
        }
        return false;
    }

    private boolean isHoliday(List<Integer> holiday, int day) {
        if (holiday.contains(day)) {
            return true;
        }
        return false;
    }
}
