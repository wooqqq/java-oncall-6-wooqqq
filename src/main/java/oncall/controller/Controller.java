package oncall.controller;

import oncall.view.InputMonthView;

public class Controller {
    public void run() {
        getMonth();
    }

    private void getMonth() {
        InputMonthView inputMonthView = new InputMonthView();
        inputMonthView.getMonth();
    }
}
