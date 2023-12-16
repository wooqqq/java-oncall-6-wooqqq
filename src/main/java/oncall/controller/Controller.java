package oncall.controller;

import oncall.domain.EmergencyWork;
import oncall.domain.EmergencyWorkMonth;
import oncall.domain.Employee;
import oncall.domain.Employees;
import oncall.view.InputEmployeeView;
import oncall.view.InputMonthView;
import oncall.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {
    public void run() {
        EmergencyWorkMonth workMonth = setEmergencyWorkMonth(getMonth());
        Employees weekday = setEmployees(getEmployee(getWeekdayEmployee()));
        Employees holiday = setEmployees(getEmployee(getHolidayEmployee()));
        EmergencyWork emergencyWork = setEmergencyWork(workMonth, weekday, holiday);

        printWorkSheet(emergencyWork);
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
        List<Employee> employees = new ArrayList<>();
        List<String> names = employeeNames;
        for (String name : names) {
            Employee employee = new Employee(name);
            employees.add(employee);
        }
        return employees;
    }

    private List<String> getWeekdayEmployee() {
        InputEmployeeView inputEmployeeView = new InputEmployeeView();
        return inputEmployeeView.getWeekdayEmployee();
    }

    private List<String> getHolidayEmployee() {
        InputEmployeeView inputEmployeeView = new InputEmployeeView();
        return inputEmployeeView.getHolidayEmployee();
    }

    private EmergencyWork setEmergencyWork(EmergencyWorkMonth workMonth, Employees weekday, Employees holiday) {
        return new EmergencyWork(workMonth, weekday, holiday);
    }

    private void printWorkSheet(EmergencyWork emergencyWork) {
        OutputView outputView = new OutputView();
        outputView.getEmployeeSheet(emergencyWork);
    }
}
