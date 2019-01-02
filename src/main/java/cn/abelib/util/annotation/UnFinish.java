package cn.abelib.util.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by abel on 2018/4/30.
 * 用来表示方法内容没有实现完成, 用来代替todo的针对代码进行更细粒度的管理
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface UnFinish {
    String value() default "UnFinish";
}
