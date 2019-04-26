package com.epam.homework.join_down.util;

import java.lang.reflect.Field;
import java.util.List;

public class FormatUtil {
    private static final int ROW_LENGTH = 25;
    private static final String FORMAT = "%-" + ROW_LENGTH + "." + ROW_LENGTH + "s|";

    private FormatUtil() {
    }

    public static <T> String FormatObjToUserFriendlyStr(List<T> objects) {
        Field[] fields = objects.get(0).getClass().getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder((objects.size() + 1) * fields.length * (ROW_LENGTH + 1));

        for (Field field : fields) {
            stringBuilder.append(String.format(FORMAT, field.getName()));
        }
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(horizontalSplitter(fields.length));
        stringBuilder.append(System.lineSeparator());
        try {
            for (T obj : objects) {
                for (Field field : fields) {
                    field.setAccessible(true);
                    String fieldValue = field.get(obj).toString();
                    stringBuilder.append(String.format(FORMAT, fieldValue));
                }
                stringBuilder.append(System.lineSeparator());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private static String horizontalSplitter(int fieldsNumber) {
        StringBuilder stringBuilder = new StringBuilder(fieldsNumber * ROW_LENGTH);
        for (int i = 0; i < fieldsNumber; i++) {
            for (int j = 0; j < ROW_LENGTH; j++) {
                stringBuilder.append('—');
            }
            stringBuilder.append('+');
        }
        return stringBuilder.toString();
    }
}
