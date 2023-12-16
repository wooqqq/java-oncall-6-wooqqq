package oncall.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputEmployeeView extends InputView {
    private static final String SEPARATOR = ",";
    private static final String REQUEST_WEEKDAY_EMPLOYEE = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private static final String REQUEST_HOLIDAY_EMPLOYEE = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";


    public List<String> getWeekdayEmployee() {
        System.out.print(REQUEST_WEEKDAY_EMPLOYEE);
        String input = inputView();
        return parseEmployee(input);
    }

    public List<String> getHolidayEmployee() {
        System.out.print(REQUEST_HOLIDAY_EMPLOYEE);
        String input = inputView();
        return parseEmployee(input);
    }

    private List<String> parseEmployee(String input) {
        return new ArrayList<>(Arrays.asList(input.split(SEPARATOR)));
    }
}
