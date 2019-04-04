package com.epam.homework.join_down.util;

import java.util.Arrays;

public class ParserUtil {

    private ParserUtil() {
    }

    public static Integer[] parseStringToIntArray(String str) {
        return Arrays.stream(str.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
