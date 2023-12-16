package oncall.view;

import oncall.domain.EmergencyWork;

import java.util.Map;

public class OutputView {
    public void getEmployeeSheet(EmergencyWork emergencyWork) {
        Map<Integer, String> mergeEmployee = emergencyWork.mergeAndSort(emergencyWork);
        int month = emergencyWork.getWorkMonth().getMonth();

        for (Map.Entry<Integer, String> entry : mergeEmployee.entrySet()) {
            String theDayOfWeek = emergencyWork.getTheDayOfWeek(entry.getKey());
            System.out.println(month + "월 " + entry.getKey() + "일 " + theDayOfWeek + " " + entry.getValue());
        }
    }
}
