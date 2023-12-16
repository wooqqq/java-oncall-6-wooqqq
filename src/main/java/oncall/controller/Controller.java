package oncall.controller;

import oncall.domain.EmergencyWorkMonth;
import oncall.view.InputMonthView;

import java.util.Map;

public class Controller {
    public void run() {
        setEmergencyWorkMonth(getMonth());
    }

    private EmergencyWorkMonth setEmergencyWorkMonth(Map<Integer, String> input) {
        if (!input.isEmpty()) {
            Integer month = input.keySet().iterator().next();
            String startDate = input.get(month);
            return new EmergencyWorkMonth(month, startDate);
        }
        return null;
    }

    private Map<Integer, String> getMonth() {
        InputMonthView inputMonthView = new InputMonthView();
        return inputMonthView.getMonth();
    }
}
