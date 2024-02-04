package models;

import enums.Month;
import enums.States;
import enums.Subjects;
import org.apache.commons.lang3.RandomStringUtils;
import utils.Utils;

public record DataDocument(String firstName, String secondName, String email, int gender, String genderName,
                           String number, int year, Month month, int day, Subjects subjects, String address,
                           States states, String city) {

    public static DataDocument generateRandomDocument() {
        String firstName = RandomStringUtils.randomAlphabetic(Utils.getRandomInt(1, 20));
        String secondName = RandomStringUtils.randomAlphabetic(Utils.getRandomInt(1, 20));
        String email = RandomStringUtils.randomAlphabetic(Utils.getRandomInt(1, 20)) + "@" + RandomStringUtils.randomAlphabetic(4) + ".com";
        int gender = Utils.getRandomInt(0, 3);
        String genderName = genderByNumber(gender);
        String number = RandomStringUtils.randomNumeric(10);
        int year = Utils.getRandomInt(1900, 2100);
        Month month = Month.values()[Utils.getRandomInt(0, 11)]; // от 0 до 11
        int day = Utils.getRandomInt(1, month.getCountDay()); // от 1 до mounth.getCountDay()
        Subjects subjects = Subjects.values()[Utils.getRandomInt(0, 13)];
        String address = RandomStringUtils.randomAlphabetic(40);
        States states = States.values()[Utils.getRandomInt(0, 3)];
        String city = states.getCity();
        return new DataDocument(firstName, secondName, email, gender, genderName, number, year, month, day, subjects, address, states, city);
    }

    private static String genderByNumber(int a) {
        if (a == 0)
            return "Male";
        else if (a == 1)
            return "Female";
        else return "Other";
    }
}
