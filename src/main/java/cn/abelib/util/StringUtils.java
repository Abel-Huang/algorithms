package cn.abelib.util;

import java.util.Objects;

/**
 * @author abel.huang
 * @date 2020/10/10 17:10
 */
public class StringUtils {
    private StringUtils() {}

    public static String nullString(String str) {
        if (Objects.isNull(str)) {
            return "null";
        }
        return str;
    }

    public static String nullObject(Object object) {
        if (Objects.isNull(object)) {
            return "null";
        }
        return object.toString();
    }
}
