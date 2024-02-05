package enums;

import utils.Utils;

public enum States {
    NRC("NCR", new String[] {"Delhi", "Gurgaon", "Noida"}),
    UP("Uttar Pradesh", new String[] {"Agra", "Lucknow", "Merrut"}),
    HAR("Haryana", new String[] {"Karnal", "Panipat"}),
    RAJ("Rajasthan", new String[] {"Jaipur", "Jaiselmer"});
    private final String name;
    private final String[] city;

    States(String name, String[] city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city[Utils.getRandomInt(0, city.length - 1)];
    }
}
