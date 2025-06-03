package demoqa.utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {


    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomInt(10, 30));
        System.out.println(getRandomEmail());
        String[] names = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        System.out.println(getRandomItemFromArray(names));
        System.out.println(getRandomDoubleInt(16, 55));
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomString(int length) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }


    public static String getRandomEmail() {
        return getRandomString(10) + "@gmail.com";
    }


    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);
        return values[index];

    }

    public static double getRandomDoubleInt(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max + 1);
    }


//    //Faker сделать отдлеьно
//    public static String getRandomName() {
//       Faker new faker.name().firstName();
//
//    }


}
