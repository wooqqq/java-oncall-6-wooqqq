package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private final List<Employee> employees;

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<String> getEmployees() {
        List<String> names = new ArrayList<>();
        for (Employee employee : employees) {
            String name = employee.getName();
            names.add(name);
        }
        return names;
    }
}
