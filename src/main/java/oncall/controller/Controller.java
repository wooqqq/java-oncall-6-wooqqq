package oncall.controller;

import oncall.domain.EmergencyWorkMonth;
import oncall.view.InputMonthView;

import java.util.Map;

public class Controller {
    public void run() {
        setEmergencyWorkMonth(getMonth());
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
}
