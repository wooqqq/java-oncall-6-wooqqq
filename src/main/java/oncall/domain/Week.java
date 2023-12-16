package oncall.domain;

public enum Week {
    MONDAY("월", 1, false),
    TUESDAY("화", 2, false),
    WEDNESDAY("수", 3, false),
    THURSDAY("목", 4, false),
    FRIDAY("금", 5, false),
    SATURDAY("토", 6, true),
    SUNDAY("일", 7, true);

    private final String date;
    private final int turn;
    private final boolean isWeekend;

    Week(String date, int turn, boolean isWeekend) {
        this.date = date;
        this.turn = turn;
        this.isWeekend = isWeekend;
    }

    public String getDate() {
        return date;
    }

    public int getTurn() {
        return turn;
    }

    public boolean getIsWeekend() {
        return isWeekend;
    }
}
