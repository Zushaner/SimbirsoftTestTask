package enums;

public enum Subjects {
    ACC("Accounting"),
    ART("Arts"),
    BIO("Biology"),
    CHE("Chemistry"),
    CIV("Civics"),
    COM("Commerce"),
    CSI("Computer Science"),
    ECO("Economics"),
    ENG("English"),
    HIN("Hindi"),
    HIS("History"),
    MAT("Maths"),
    PHY("Physics"),
    SST("Social Studies");
    private final String name;

    public String getName() {
        return name;
    }

    Subjects(String name) {
        this.name = name;
    }
}
