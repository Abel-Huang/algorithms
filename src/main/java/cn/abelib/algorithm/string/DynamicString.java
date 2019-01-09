package cn.abelib.algorithm.string;


import cn.abelib.util.commons.Constant;

/**
 * Created by ${abel-huang} on 18/2/27.
 * redis字符串的底层结构SDS，一个可变的字符串
 *
 * @author abel
 */
public class DynamicString {
    private int len;
    private int free;
    private char[] buf;

    public DynamicString(String value) {
        int size;
        len = value.length();

        char[] original = value.toCharArray();

        if (len <= Constant.DEFAULT_CAPACITY) {
            buf = new char[Constant.DEFAULT_CAPACITY];
            free = Constant.DEFAULT_CAPACITY - len;

            System.arraycopy(original, 0, buf, 0, len);
        } else {

            if (len >= Constant.LENGTH_1_MB) {
                size = len + Constant.LENGTH_1_MB;
            } else {
                size = len << 1;
            }

            buf = new char[size];
            free = size - len;

            System.arraycopy(original, 0, buf, 0, len);
        }

    }

    public DynamicString() {
        buf = new char[Constant.DEFAULT_CAPACITY];
        len = 0;
        free = Constant.DEFAULT_CAPACITY;
    }

    public DynamicString(int capacity) {
        buf = new char[capacity];
        len = 0;
        free = capacity;
    }

    public DynamicString append(String value) {
        int size;
        int valueLen = value.length();
        char[] append = value.toCharArray();
        if (valueLen <= free) {
            System.arraycopy(append, 0, buf, len, valueLen);
            len = len + valueLen;
            free = free - valueLen;
        } else {
            char[] temp = new char[len];
            System.arraycopy(buf, 0, temp, 0, len);

            if (len + valueLen >= Constant.LENGTH_1_MB) {
                size = len + valueLen + Constant.LENGTH_1_MB;
            } else {
                size = (len + valueLen) << 1;
            }

            buf = new char[size];

            if (len != 0)
                System.arraycopy(temp, 0, buf, 0, len);
            System.arraycopy(append, 0, buf, len, valueLen);

            len = len + valueLen;
            free = size - len;
        }

        return this;
    }

    public DynamicString append(DynamicString append) {
        return this.append(append.value());
    }

    public DynamicString update(String value) {
        int size;
        int valueSize = value.length();

        char[] original = value.toCharArray();

        if (valueSize <= len + free) {
            free = Constant.DEFAULT_CAPACITY - len;
            System.arraycopy(original, 0, buf, 0, valueSize);
            free = free + len - valueSize;
            len = valueSize;
        } else {
            len = valueSize;
            if (len >= Constant.LENGTH_1_MB) {
                size = len + Constant.LENGTH_1_MB;
            } else {
                size = len << 1;
            }

            buf = new char[size];
            free = size - len;

            System.arraycopy(original, 0, buf, 0, len);
        }
        return this;
    }


    public int len() {
        return this.len;
    }

    public int available() {
        return this.free;
    }

    public String value() {

        return String.valueOf(buf, 0, len);
    }

    public DynamicString clear() {
        len = 0;
        free = Constant.DEFAULT_CAPACITY;
        return this;
    }
}