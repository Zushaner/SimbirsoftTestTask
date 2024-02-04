package enums;

public enum Month {
    JAN(31, "January"),
    FEB(28, "February"),
    MAR(31,"March"),
    APR(30,"April"),
    MAY(31, "May"),
    JUN(30,"June"),
    JUL(31,"July"),
    AUG(31,"August"),
    SEP(30,"September"),
    OCT(31,"October"),
    NOV(30,"November"),
    DEC(31, "December");
    private final int countDay;
    private final String displayName;

    public int getCountDay() {
        return countDay;
    }

    public String getDisplayName() {
        return displayName;
    }

    Month(int countDay, String displayName) {
        this.countDay = countDay;
        this.displayName = displayName;
    }
}
