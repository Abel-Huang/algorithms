package cn.abelib.util.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by abel on 2018/4/30.
 *  用来表示方法内容没有经过测试
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface UnTest {
    String value() default "UnTest";
}
