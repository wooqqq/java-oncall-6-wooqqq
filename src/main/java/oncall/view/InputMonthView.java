package oncall.view;

import java.util.HashMap;
import java.util.Map;

public class InputMonthView extends InputView {
    private static final String SEPARATOR = ",";
    private static final String REQUEST_MONTH = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String ERROR_MESSAGE = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.";

    public Map<String, String> getMonth() {
        System.out.print(REQUEST_MONTH);
        String input = inputValue();
        try {
            parseInputValue(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
            return getMonth();
        }
        return parseInputValue(input);
    }

    private Map<String, String> parseInputValue(String input) {
        String[] inputValue = input.split(SEPARATOR);
        Map<String, String> result = new HashMap<>();

        // month, startDate에 대한 유효성 검사 필요
        String month = inputValue[0];
        String startDate = inputValue[1];
        result.put(month, startDate);
        return result;
    }
}
