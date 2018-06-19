package com.company;

/**
 * Created by gild on 5/27/18.
 */
public class StringUtils {

    /**
     * Limit the string to a certain number of characters, adding "..." if it was truncated
     *
     * @param value
     *        The string to limit.
     * @param length
     *        the length to limit to (as an int).
     * @return The limited string.
     */
    public static String limit(String value, int length) {
        if (value.length() > length) {
            value = value.substring(0, length);
        }

        return value;
    }

    public static String limit(String value) {
        return limit(value, 25);
    }
}
