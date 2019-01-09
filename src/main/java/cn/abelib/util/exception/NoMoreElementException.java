package cn.abelib.util.exception;

/**
 * @Author: abel-huang
 * @Date: 2018-12-12 00:38
 */
public class NoMoreElementException extends RuntimeException {
    public NoMoreElementException() {
        super("No more element");
    }

    public NoMoreElementException(String s) {
        super(s);
    }
}
