package oncall.view;

import oncall.domain.EmergencyWork;

import java.util.Map;

public class OutputView {
    public void getEmployeeSheet(EmergencyWork emergencyWork) {
        Map<Integer, String> mergeEmployee = emergencyWork.mergeAndSort(emergencyWork);

        for (Map.Entry<Integer, String> entry : mergeEmployee.entrySet()) {
            System.out.println(entry.getKey() + "일 " + entry.getValue());
        }
    }
}
