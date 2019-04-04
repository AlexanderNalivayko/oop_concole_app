package com.epam.homework.join_down.util;

import java.text.ParseException;

public class ValidationUtil {

    private ValidationUtil() {
    }

    public static boolean validateInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean validatePositive(int value) {
        return value > 0;
    }
}
