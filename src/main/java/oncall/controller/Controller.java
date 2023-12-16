package oncall.controller;

import oncall.domain.EmergencyWorkMonth;
import oncall.domain.Employee;
import oncall.domain.Employees;
import oncall.view.InputEmployeeView;
import oncall.view.InputMonthView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {
    private InputEmployeeView inputEmployeeView;

    public void run() {
        setEmergencyWorkMonth(getMonth());
        Employees weekday = setEmployees(getEmployee(getWeekdayEmployee()));
        Employees holiday = setEmployees(getEmployee(getHolidayEmployee()));
    }

    private EmergencyWorkMonth setEmergencyWorkMonth(Map<String, String> input) {
        if (!input.isEmpty()) {
            String month = input.keySet().iterator().next();
            String startDate = input.get(month);
            return new EmergencyWorkMonth(month, startDate);
        }
        return null;
    }

    private Map<String, String> getMonth() {
        InputMonthView inputMonthView = new InputMonthView();
        return inputMonthView.getMonth();
    }

    private Employees setEmployees(List<Employee> employees) {
        return new Employees(employees);
    }

    private List<Employee> getEmployee(List<String> employeeNames) {
        inputEmployeeView = new InputEmployeeView();
        List<Employee> employees = new ArrayList<>();
        List<String> names = employeeNames;
        for (String name : names) {
            Employee employee = new Employee(name);
            employees.add(employee);
        }
        return employees;
    }

    private List<String> getWeekdayEmployee() {
        return inputEmployeeView.getWeekdayEmployee();
    }

    private List<String> getHolidayEmployee() {
        return inputEmployeeView.getHolidayEmployee();
    }
}
